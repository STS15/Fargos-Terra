package org.confluence.mod.mixin.inventory;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponents;
import org.confluence.mod.Confluence;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = DataComponents.class, priority = 1500)
public abstract class DataComponentsMixin {
    @WrapOperation(method = "lambda$static$1", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/ExtraCodecs;intRange(II)Lcom/mojang/serialization/Codec;"))
    private static Codec<Integer> modifyMaxStackSize(int min, int max, Operation<Codec<Integer>> original) {
        return original.call(min, Math.max(max, Confluence.MAX_STACK_SIZE));
    }
}
