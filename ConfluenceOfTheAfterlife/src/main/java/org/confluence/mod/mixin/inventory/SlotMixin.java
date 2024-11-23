package org.confluence.mod.mixin.inventory;

import net.minecraft.world.inventory.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Slot.class)
public abstract class SlotMixin {
    @Inject(method = "getMaxStackSize()I", at = @At("RETURN"), cancellable = true)
    private void modifyMaxStackSize(CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(Math.max(cir.getReturnValue(), 9999));
    }
}
