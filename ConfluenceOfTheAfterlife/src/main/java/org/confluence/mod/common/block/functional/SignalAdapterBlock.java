package org.confluence.mod.common.block.functional;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;
import org.confluence.mod.common.block.functional.network.INetworkEntity;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

import static org.confluence.mod.common.block.StateProperties.REVERSE;
import static org.confluence.mod.common.block.StateProperties.SIGNAL;

@SuppressWarnings("deprecation")
public class SignalAdapterBlock extends AbstractMechanicalBlock {
    public SignalAdapterBlock() {
        super(Properties.ofFullCopy(Blocks.REDSTONE_BLOCK));
        registerDefaultState(stateDefinition.any()
                .setValue(SIGNAL, false) // 同时代表了signal和power(强度15)
                .setValue(REVERSE, false)); // false代表signal->power;true代表power->signal
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return defaultBlockState().setValue(SIGNAL, pContext.getLevel().hasNeighborSignal(pContext.getClickedPos()));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(SIGNAL, REVERSE);
    }

    @Override
    public void neighborChanged(@NotNull BlockState pState, Level pLevel, @NotNull BlockPos pPos, @NotNull Block pNeighborBlock, @NotNull BlockPos pNeighborPos, boolean pMovedByPiston) {
        if (!pLevel.isClientSide && pState.getValue(REVERSE)) { // power->signal
            execute(pState, (ServerLevel) pLevel, pPos, pLevel.hasNeighborSignal(pPos));
        }
    }

    @Override
    public @NotNull InteractionResult useWithoutItem(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, Player pPlayer, @NotNull BlockHitResult pHit) {
        if (cannotInteractWith(pPlayer.getMainHandItem().getItem())) {
            return InteractionResult.PASS;
        }
        if (!pLevel.isClientSide && pPlayer.isCrouching()) {
            pLevel.setBlockAndUpdate(pPos, pState.cycle(REVERSE));
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public int getSignal(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull Direction pDirection) {
        return !pState.getValue(REVERSE) && pState.getValue(SIGNAL) ? 15 : 0;
    }

    @Override
    public boolean isSignalSource(BlockState pState) {
        return !pState.getValue(REVERSE) && pState.getValue(SIGNAL);
    }

    @Override
    public boolean canConnectRedstone(BlockState state, BlockGetter level, BlockPos pos, @org.jetbrains.annotations.Nullable Direction direction) {
        return true;
    }

    @Override
    public void onExecute(BlockState pState, ServerLevel pLevel, BlockPos pPos, int pColor, INetworkEntity pEntity) {
        if (!pState.getValue(SIGNAL)) {
            pLevel.setBlockAndUpdate(pPos, pState.setValue(SIGNAL, true));
        }
    }

    @Override
    public void onUnExecute(BlockState pState, ServerLevel pLevel, BlockPos pPos, int pColor, INetworkEntity pEntity) {
        if (pState.getValue(SIGNAL)) {
            pLevel.setBlockAndUpdate(pPos, pState.setValue(SIGNAL, false));
        }
    }
}
