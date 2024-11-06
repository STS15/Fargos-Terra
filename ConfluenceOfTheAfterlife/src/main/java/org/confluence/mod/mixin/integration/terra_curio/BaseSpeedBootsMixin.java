package org.confluence.mod.mixin.integration.terra_curio;

import org.confluence.mod.common.init.ModEffects;
import org.confluence.terra_curio.common.item.curio.movement.BaseSpeedBoots;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import top.theillusivec4.curios.api.SlotContext;

@Mixin(BaseSpeedBoots.class)
public abstract class BaseSpeedBootsMixin {
    @Inject(method = "speedUp", at = @At("HEAD"), cancellable = true)
    private void confluence(SlotContext slotContext, int acceleration, int maxSpeed, CallbackInfo ci) {
        if (slotContext.entity().hasEffect(ModEffects.STONED)) {
            ci.cancel();
        }
    }
}
