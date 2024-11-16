package org.confluence.mod.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.status.ChunkType;
import org.confluence.mod.mixed.IWorldGenRegion;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(WorldGenRegion.class)
public abstract class WorldGenRegionMixin implements IWorldGenRegion, WorldGenLevel {
    @Shadow
    @Final
    private ServerLevel level;

    @Shadow
    protected abstract void markPosForPostprocessing(BlockPos pos);

    @Override
    public boolean confluence$setBlock(BlockPos pos, BlockState state, int flags, int recursionLeft) {
        ChunkAccess chunkaccess = getChunk(pos);
        BlockState blockstate = chunkaccess.setBlockState(pos, state, false);
        if (blockstate != null) {
            level.onBlockStateChange(pos, blockstate, state);
        }

        if (state.hasBlockEntity()) {
            if (chunkaccess.getPersistedStatus().getChunkType() == ChunkType.LEVELCHUNK) {
                BlockEntity blockentity = ((EntityBlock) state.getBlock()).newBlockEntity(pos, state);
                if (blockentity != null) {
                    chunkaccess.setBlockEntity(blockentity);
                } else {
                    chunkaccess.removeBlockEntity(pos);
                }
            } else {
                CompoundTag compoundtag = new CompoundTag();
                compoundtag.putInt("x", pos.getX());
                compoundtag.putInt("y", pos.getY());
                compoundtag.putInt("z", pos.getZ());
                compoundtag.putString("id", "DUMMY");
                chunkaccess.setBlockEntityNbt(compoundtag);
            }
        } else if (blockstate != null && blockstate.hasBlockEntity()) {
            chunkaccess.removeBlockEntity(pos);
        }

        if (state.hasPostProcess(this, pos)) {
            markPosForPostprocessing(pos);
        }

        return true;
    }
}
