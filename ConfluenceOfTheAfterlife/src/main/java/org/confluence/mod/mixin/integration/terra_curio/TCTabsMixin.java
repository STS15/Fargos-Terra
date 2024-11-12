package org.confluence.mod.mixin.integration.terra_curio;

import net.minecraft.world.item.CreativeModeTab;
import org.confluence.mod.common.init.item.AccessoryItems;
import org.confluence.terra_curio.common.init.TCTabs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = TCTabs.class, remap = false)
public abstract class TCTabsMixin {
    @Inject(method = "lambda$static$2(Lnet/minecraft/world/item/CreativeModeTab$ItemDisplayParameters;Lnet/minecraft/world/item/CreativeModeTab$Output;)V", at = @At("HEAD"))
    private static void confluence(CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output output, CallbackInfo ci) {
        AccessoryItems.ACCESSORIES.getEntries().forEach(holder -> output.accept(holder.get()));
    }
}
