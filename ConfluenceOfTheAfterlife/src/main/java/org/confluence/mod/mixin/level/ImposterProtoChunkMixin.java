package org.confluence.mod.mixin.level;

import net.minecraft.world.level.chunk.ImposterProtoChunk;
import net.minecraft.world.level.chunk.LevelChunk;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ImposterProtoChunk.class)
public abstract class ImposterProtoChunkMixin {
    @Mutable
    @Shadow
    @Final
    private boolean allowWrites;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void modify(LevelChunk wrapped, boolean allowWrites, CallbackInfo ci) {
        this.allowWrites = true;
    }
}
