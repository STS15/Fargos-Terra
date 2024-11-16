package org.confluence.mod.common.block.natural;

import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.IceBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.confluence.mod.mixed.ILivingEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ThinIceBlock extends IceBlock {
    public ThinIceBlock() {
        super(Properties.ofFullCopy(Blocks.PACKED_ICE));
    }

    @Override
    public void updateEntityAfterFallOn(@NotNull BlockGetter blockGetter, @NotNull Entity entity) {
        if (!(entity instanceof LivingEntity living && ((ILivingEntity) living).confluence$isBreakEasyCrashBlock())) {
            super.updateEntityAfterFallOn(blockGetter, entity);
        }
    }

    @Override
    public void playerDestroy(@NotNull Level level, Player player, @NotNull BlockPos pos, @NotNull BlockState state, @Nullable BlockEntity entity, @NotNull ItemStack item) {
        player.awardStat(Stats.BLOCK_MINED.get(this));
        player.causeFoodExhaustion(0.005F);
    }
}
