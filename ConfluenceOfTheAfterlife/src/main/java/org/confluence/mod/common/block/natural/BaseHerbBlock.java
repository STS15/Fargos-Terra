package org.confluence.mod.common.block.natural;

import com.google.common.collect.ImmutableMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.confluence.mod.common.init.block.ModBlocks;
import org.confluence.mod.util.ModUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Set;

/** @author voila1106 */
public abstract class BaseHerbBlock extends CropBlock implements EntityBlock {
    public static final int MAX_AGE = 2;
    public static final int BRIGHTNESS = 3;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_2;
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D)};

    public static Map<DeferredBlock<? extends Block>, Set<Block>> herbGroundMap = new ImmutableMap.Builder<DeferredBlock<? extends Block>, Set<Block>>()
        .put(ModBlocks.SUNFLOWERS, Set.of(Blocks.GRASS_BLOCK, ModBlocks.HALLOW_GRASS_BLOCK.get()))
        .put(ModBlocks.MOONSHINE_GRASS, Set.of(Blocks.GRASS_BLOCK, Blocks.MOSS_BLOCK))
        .put(ModBlocks.STELLAR_BLOSSOM, Set.of(ModBlocks.CLOUD_BLOCK.get(), ModBlocks.RAIN_CLOUD_BLOCK.get()))
        .put(ModBlocks.SHIVERINGTHORNS, Set.of(Blocks.GRASS_BLOCK, Blocks.ICE, ModBlocks.RED_ICE.get(), ModBlocks.RED_PACKED_ICE.get(), ModBlocks.PINK_PACKED_ICE.get(), ModBlocks.PINK_ICE.get(), ModBlocks.PURPLE_ICE.get(), ModBlocks.PURPLE_PACKED_ICE.get()))
        .put(ModBlocks.SHINE_ROOT, Set.of(Blocks.DIRT, Blocks.MUD, Blocks.STONE, Blocks.DEEPSLATE))
        .put(ModBlocks.DEATHWEED, Set.of(ModBlocks.CORRUPT_GRASS_BLOCK.get(), ModBlocks.EBONY_STONE.get(), ModBlocks.TR_CRIMSON_GRASS_BLOCK.get(), ModBlocks.TR_CRIMSON_STONE.get()))
        .put(ModBlocks.WATERLEAF, Set.of(Blocks.SAND, Blocks.RED_SAND, ModBlocks.PEARL_SAND.get()))
        .put(ModBlocks.FLAMEFLOWERS, Set.of(ModBlocks.ASH_BLOCK.get(), ModBlocks.ASH_GRASS_BLOCK.get()))
        .build();

    public BaseHerbBlock(){
        super(Properties.ofFullCopy(Blocks.DANDELION).randomTicks());
    }

    public BaseHerbBlock(Properties prop){
        super(prop);
    }

    @Override
    public boolean mayPlaceOn(@NotNull BlockState groundState, @NotNull BlockGetter worldIn, @NotNull BlockPos pos){
        Set<Block> blocks = herbGroundMap.get(DeferredBlock.createBlock(BuiltInRegistries.BLOCK.getKey(this)));
        return blocks != null && blocks.contains(groundState.getBlock());
    }

    public boolean canBloom(ServerLevel world, BlockState state){
        return false;
    }

    // 重写，不检查光照，不检查合理密植，抄父方法
    @Override
    public void randomTick(@NotNull BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource random){
        if(!level.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
        int i = this.getAge(state);
        if(i < this.getMaxAge()){
            float growthSpeed = 0.7f;
            if(net.neoforged.neoforge.common.CommonHooks.canCropGrow(level, pos, state, random.nextInt((int) (25.0F / growthSpeed) + 1) == 0)){
                level.setBlock(pos, this.getStateForAge(i + 1), 2);
                net.neoforged.neoforge.common.CommonHooks.fireCropGrowPost(level, pos, state);
            }
        }
    }

    @Override
    public boolean isValidBonemealTarget(@NotNull LevelReader pLevel, @NotNull BlockPos pPos, @NotNull BlockState pState){
        return false;
    }

    @Override
    public boolean canSurvive(@NotNull BlockState blockstate, LevelReader worldIn, BlockPos pos){
        BlockPos blockpos = pos.below();
        BlockState groundState = worldIn.getBlockState(blockpos);
        return this.mayPlaceOn(groundState, worldIn, blockpos);
    }

    @Override
    @NotNull
    protected ItemLike getBaseSeedId(){
        return Items.AIR;
    }

    @NotNull
    protected IntegerProperty getAgeProperty(){
        return AGE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder){
        pBuilder.add(AGE);
    }

    public int getMaxAge(){
        return MAX_AGE;
    }

    @NotNull
    public VoxelShape getShape(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext){
        return SHAPE_BY_AGE[this.getAge(pState)];
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pPos, @NotNull BlockState pState){
        return new Entity(pPos, pState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level pLevel, @NotNull BlockState pState, @NotNull BlockEntityType<T> pBlockEntityType){
        if(pLevel.isClientSide()){
            return null;
        }
        // 每刻判断能不能开花
        return ModUtils.getTicker(pBlockEntityType, ModBlocks.HERBS_ENTITY.get(), (level, blockPos, blockState, e) -> {
            int age = getAge(blockState);
            if(age < MAX_AGE - 1) return;
            if(canBloom((ServerLevel) level, blockState)){
                if(age != MAX_AGE){
                    level.setBlockAndUpdate(blockPos, blockState.setValue(AGE, MAX_AGE));
                }
            }else if(age == MAX_AGE){ // 如果不能开花且已经开花
                level.setBlockAndUpdate(blockPos, blockState.setValue(AGE, MAX_AGE - 1));
            }
        });
    }
    public static class Entity extends BlockEntity {

        public Entity(BlockPos pPos, BlockState pBlockState){
            super(ModBlocks.HERBS_ENTITY.get(), pPos, pBlockState);
        }
    }
}
