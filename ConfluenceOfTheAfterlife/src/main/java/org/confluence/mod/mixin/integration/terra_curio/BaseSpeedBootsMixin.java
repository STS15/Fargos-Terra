package org.confluence.mod.mixin.integration.terra_curio;

import net.minecraft.world.item.ItemStack;
import org.confluence.mod.common.init.ModEffects;
import org.confluence.mod.terra_curio.common.item.curio.movement.BaseSpeedBoots;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import top.theillusivec4.curios.api.SlotContext;

@Mixin(BaseSpeedBoots.class)
public abstract class BaseSpeedBootsMixin {
    @Inject(method = "speedUp(Ltop/theillusivec4/curios/api/SlotContext;Lnet/minecraft/world/item/ItemStack;II)V", at = @At("HEAD"), cancellable = true)
    private void confluence(SlotContext slotContext, ItemStack stack, int addition, int max, CallbackInfo ci) {
        if (slotContext.entity().hasEffect(ModEffects.STONED)) {
            ci.cancel();
        }
    }
}
