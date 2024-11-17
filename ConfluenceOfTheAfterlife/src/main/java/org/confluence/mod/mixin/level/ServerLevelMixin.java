package org.confluence.mod.mixin.level;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelWriter;
import net.minecraft.world.level.block.state.BlockState;
import org.confluence.mod.mixed.IWorldGenRegion;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ServerLevel.class)
public abstract class ServerLevelMixin implements IWorldGenRegion, LevelWriter {
    @Override
    public boolean confluence$setBlock(BlockPos pos, BlockState state, int flags, int recursionLeft) {
        return setBlock(pos, state, flags, recursionLeft);
    }
}
