package org.confluence.mod.mixed;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public interface IWorldGenRegion {
    boolean confluence$setBlock(BlockPos pos, BlockState state, int flags, int recursionLeft);

    default boolean confluence$setBlock(BlockPos pos, BlockState state, int flags) {
        return confluence$setBlock(pos, state, flags, 512);
    }
}
