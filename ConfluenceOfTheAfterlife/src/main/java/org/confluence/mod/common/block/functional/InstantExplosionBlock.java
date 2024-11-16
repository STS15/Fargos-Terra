package org.confluence.mod.common.block.functional;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.confluence.mod.common.block.functional.network.INetworkEntity;
import org.jetbrains.annotations.NotNull;

public class InstantExplosionBlock extends AbstractMechanicalBlock {
    public InstantExplosionBlock() {
        super(Properties.ofFullCopy(Blocks.TNT));
    }

    @Override
    public void neighborChanged(@NotNull BlockState pState, Level pLevel, @NotNull BlockPos pPos, @NotNull Block pNeighborBlock, @NotNull BlockPos pNeighborPos, boolean pMovedByPiston) {
        if (!pLevel.isClientSide && pLevel.hasNeighborSignal(pPos)) {
            execute(pState, (ServerLevel) pLevel, pPos, true);
        }
    }

    @Override
    public void onExecute(BlockState pState, ServerLevel pLevel, BlockPos pPos, int pColor, INetworkEntity pEntity) {
        pLevel.removeBlock(pPos, false);
        pLevel.explode(null, pPos.getX() + 0.5, pPos.getY() + 0.5, pPos.getZ() + 0.5, 10.0F, false, Level.ExplosionInteraction.BLOCK);
    }
}
