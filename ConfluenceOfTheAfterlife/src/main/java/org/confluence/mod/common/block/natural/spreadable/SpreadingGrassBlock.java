package org.confluence.mod.common.block.natural.spreadable;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.confluence.mod.common.block.natural.ThornBlock;
import org.confluence.mod.common.init.block.NatureBlocks;
import org.jetbrains.annotations.NotNull;

public class SpreadingGrassBlock extends SpreadingBlock {
    public SpreadingGrassBlock(Type type, Properties properties) {
        super(type, properties);
    }

    @Override
    public void randomTick(@NotNull BlockState blockState, @NotNull ServerLevel serverLevel, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource) {
        if (!serverLevel.isAreaLoaded(blockPos, 3)) return;
        BlockPos above = blockPos.above();
        if (ISpreadable.isFullBlock(serverLevel, above)) {
            serverLevel.setBlockAndUpdate(blockPos, Blocks.DIRT.defaultBlockState());
        } else {
            ThornBlock thorn = switch (getType()) {
                case CRIMSON -> NatureBlocks.CRIMSON_THORN.get();
                case CORRUPT -> NatureBlocks.CORRUPTION_THORN.get();
                default -> null;
            };
            if (thorn != null && randomSource.nextInt(10) == 0
                && serverLevel.getBlockState(above).isAir()
                && serverLevel.getBlockState(above.east()).isAir()
                && serverLevel.getBlockState(above.west()).isAir()
                && serverLevel.getBlockState(above.south()).isAir()
                && serverLevel.getBlockState(above.north()).isAir()
            ) {
                serverLevel.setBlockAndUpdate(above, thorn.getStateForPlacement(serverLevel, above));
            }
            super.randomTick(blockState, serverLevel, blockPos, randomSource);
        }
    }
}
