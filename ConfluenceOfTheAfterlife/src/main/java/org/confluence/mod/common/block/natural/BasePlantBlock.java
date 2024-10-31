package org.confluence.mod.common.block.natural;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.confluence.mod.common.block.natural.spreadable.ISpreadable;
import org.confluence.mod.common.data.gen.limit.CustomItemModel;
import org.confluence.mod.common.data.gen.limit.CustomModel;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;

public class BasePlantBlock extends BushBlock implements CustomModel, CustomItemModel {
    public static final MapCodec<BasePlantBlock> CODEC = RecordCodecBuilder.mapCodec(
        builder -> builder.group(propertiesCodec(),
            ResourceLocation.CODEC.listOf().fieldOf("ground").forGetter(block -> {
                ArrayList<ResourceLocation> keys = new ArrayList<>();
                for(Block ground : block.survive){
                    keys.add(BuiltInRegistries.BLOCK.getKey(ground));
                }
                return keys;
            })).apply(builder, (prop, keys) -> {
            ArrayList<Block> ground = new ArrayList<>();
            for(ResourceLocation key : keys){
                ground.add(BuiltInRegistries.BLOCK.get(key));
            }
            return new BasePlantBlock(prop, ground.toArray(new Block[0]));
        })
    );

    private final Block[] survive;

    public BasePlantBlock(Block... survive){
        super(Properties.ofFullCopy(Blocks.DANDELION).replaceable());
        this.survive = survive;
    }

    public BasePlantBlock(Properties prop, Block... survive){
        super(prop);
        this.survive = survive;
    }

    @Override
    protected MapCodec<? extends BushBlock> codec(){
        return CODEC;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context){
        Vec3 offset = state.getOffset(world, pos);
        return box(2, 0, 2, 14, 13, 14).move(offset.x, offset.y, offset.z);
    }

    @Override
    public boolean mayPlaceOn(@NotNull BlockState groundState, @NotNull BlockGetter worldIn, @NotNull BlockPos pos){
        return Arrays.stream(survive).allMatch(state -> state == groundState.getBlock());
    }

    @Override
    public boolean canSurvive(@NotNull BlockState blockstate, LevelReader worldIn, BlockPos pos){
        BlockPos blockpos = pos.below();
        BlockState groundState = worldIn.getBlockState(blockpos);
        return mayPlaceOn(groundState, worldIn, blockpos);
    }

    /**
     * 邪恶草和蘑菇下方的方块被转化时转化自身
     */
    @Override
    @NotNull
    public BlockState updateShape(@NotNull BlockState originState, @NotNull Direction pFacing, @NotNull BlockState pFacingState, @NotNull LevelAccessor pLevel, @NotNull BlockPos pCurrentPos, @NotNull BlockPos pFacingPos){
        BlockState after = super.updateShape(originState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
        if(pFacing != Direction.DOWN) return after;
        ISpreadable.Type type = pFacingState.getBlock() instanceof ISpreadable sp ? sp.getType() : ISpreadable.Type.PURE;
        Block b = type.getBlockMap().get(originState.getBlock());
        BlockState transformResult = b == null ? originState : b.defaultBlockState();  // 默认不转化，如果结果是摧毁则是写到map里面
        return transformResult.canSurvive(pLevel, pCurrentPos) ? transformResult : Blocks.AIR.defaultBlockState();
    }
}
