package org.confluence.mod.common.block.functional;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.confluence.mod.common.block.StateProperties;
import org.confluence.mod.common.block.functional.network.INetworkEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("deprecation")
public class GeyserBlock extends AbstractMechanicalBlock { // 热喷泉
    public static final BooleanProperty IS_FLOOR = BooleanProperty.create("is_floor");
    private static final VoxelShape SHAPE_FLOOR = Shapes.box(0.0625, 0.0, 0.0625, 0.9375, 0.5, 0.9375);
    private static final VoxelShape SHAPE_CEIL = Shapes.box(0.0625, 0.5, 0.0625, 0.9375, 1.0, 0.9375);

    public GeyserBlock() {
        super(Properties.ofFullCopy(Blocks.STONE));
        registerDefaultState(stateDefinition.any().setValue(IS_FLOOR, true).setValue(StateProperties.DRIVE, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(IS_FLOOR, StateProperties.DRIVE);
    }

    @Override
    public boolean canConnectRedstone(BlockState state, BlockGetter level, BlockPos pos, @Nullable Direction direction) {
        return true;
    }

    @Override
    public void neighborChanged(@NotNull BlockState pState, Level pLevel, @NotNull BlockPos pPos, @NotNull Block pNeighborBlock, @NotNull BlockPos pNeighborPos, boolean pMovedByPiston) {
        if (!pLevel.isClientSide) {
            execute(pState, (ServerLevel) pLevel, pPos, pLevel.hasNeighborSignal(pPos));
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        Direction direction = pContext.getNearestLookingVerticalDirection();
        return defaultBlockState().setValue(IS_FLOOR, direction == Direction.DOWN);
    }

    @Override
    public boolean canSurvive(@NotNull BlockState pState, LevelReader pLevel, BlockPos pPos) {
        BlockPos below = pPos.below();
        BlockPos above = pPos.above();
        return pLevel.getBlockState(below).isFaceSturdy(pLevel, below, Direction.UP) || pLevel.getBlockState(above).isFaceSturdy(pLevel, above, Direction.DOWN);
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
        return pState.getValue(IS_FLOOR) ? SHAPE_FLOOR : SHAPE_CEIL;
    }

    @Override
    public @NotNull VoxelShape getCollisionShape(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
        return Shapes.empty();
    }

    @Override
    public void entityInside(@NotNull BlockState pState, Level pLevel, @NotNull BlockPos pPos, net.minecraft.world.entity.@NotNull Entity pEntity) {
        if (!pLevel.isClientSide && pLevel.getBlockEntity(pPos) instanceof Entity entity) {
            onExecute(pState, (ServerLevel) pLevel, pPos, -1, entity);
        }
    }

    @Override
    public void tick(BlockState pState, ServerLevel pLevel, @NotNull BlockPos pPos, @NotNull RandomSource pRandom) {
        pLevel.setBlockAndUpdate(pPos, pState.setValue(StateProperties.DRIVE, false));
    }

    @Override
    public void onExecute(BlockState pState, ServerLevel pLevel, BlockPos pPos, int pColor, INetworkEntity pEntity) {
        if (pState.getValue(StateProperties.DRIVE)) return;
        int bx = pPos.getX();
        int by = pPos.getY();
        int bz = pPos.getZ();
        double offsetY = pState.getValue(IS_FLOOR) ? 12.0 : -12.0;
        // todo 粒子
        pLevel.getEntities((net.minecraft.world.entity.Entity) null, new AABB(bx, by, bz, bx + 1.0, by + offsetY, bz + 1.0), entity -> entity instanceof LivingEntity)
                .forEach(entity -> entity.hurt(pLevel.damageSources().lava(), 4.0F));
        pLevel.setBlockAndUpdate(pPos, pState.setValue(StateProperties.DRIVE, true));
        pLevel.scheduleTick(pPos, this, 66);
    }
}
