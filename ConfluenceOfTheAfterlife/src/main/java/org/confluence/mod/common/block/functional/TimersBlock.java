package org.confluence.mod.common.block.functional;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;
import org.confluence.mod.common.block.functional.network.INetworkEntity;
import org.confluence.mod.common.init.block.FunctionalBlocks;
import org.confluence.mod.util.ModUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static org.confluence.mod.common.block.StateProperties.DRIVE;
import static org.confluence.mod.common.block.StateProperties.SIGNAL;

public class TimersBlock extends AbstractMechanicalBlock {
    private final int duration;

    public TimersBlock(int duration) {
        super(Properties.ofFullCopy(Blocks.COMPARATOR));
        if (duration <= 0) throw new RuntimeException("Duration cannot less equal 0!");
        this.duration = duration;
        registerDefaultState(stateDefinition.any().setValue(DRIVE, false).setValue(SIGNAL, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(DRIVE, SIGNAL);
    }

    @Override
    public @NotNull InteractionResult useWithoutItem(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull Player pPlayer, @NotNull BlockHitResult pHit) {
        if (cannotInteractWith(pPlayer.getMainHandItem().getItem())) return InteractionResult.PASS;
        if (!pLevel.isClientSide && pPlayer.isCrouching()) {
            pState = pState.cycle(DRIVE);
            if (!pState.getValue(DRIVE)) { // 使网络收到负脉冲
                pState = pState.setValue(SIGNAL, false);
                execute(pState, (ServerLevel) pLevel, pPos, false);
            }
            pLevel.setBlockAndUpdate(pPos, pState);
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public void neighborChanged(@NotNull BlockState pState, Level pLevel, @NotNull BlockPos pPos, @NotNull Block pNeighborBlock, @NotNull BlockPos pNeighborPos, boolean pMovedByPiston) {
        if (pLevel.isClientSide && pLevel.hasNeighborSignal(pPos)) {
            pLevel.setBlockAndUpdate(pPos, pState.cycle(DRIVE)); // 目前仅能用红石控制其开关
        }
    }

    @Override
    public void onExecute(BlockState pState, ServerLevel pLevel, BlockPos pPos, int pColor, INetworkEntity pEntity) {}

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level pLevel, @NotNull BlockState pState, @NotNull BlockEntityType<T> pBlockEntityType) {
        return ModUtils.getTicker(pBlockEntityType, FunctionalBlocks.MECHANICAL_BLOCK_ENTITY.get(), TimersBlock::timer);
    }

    private static void timer(Level level, BlockPos blockPos, BlockState blockState, Entity entity) {
        if (level.isClientSide || !blockState.getValue(DRIVE)) return;
        TimersBlock timersBlock = (TimersBlock) blockState.getBlock();
        if ((level.getGameTime() + entity.getOrCreateNetworkNode().getId()) % timersBlock.duration == 0) {
            level.setBlockAndUpdate(blockPos, blockState.setValue(SIGNAL, true));
            timersBlock.execute(blockState, (ServerLevel) level, blockPos, true);
        } else if (blockState.getValue(SIGNAL)) { // 确保只激活一次负脉冲
            level.setBlockAndUpdate(blockPos, blockState.setValue(SIGNAL, false));
            timersBlock.execute(blockState, (ServerLevel) level, blockPos, false);
        }
    }
}
