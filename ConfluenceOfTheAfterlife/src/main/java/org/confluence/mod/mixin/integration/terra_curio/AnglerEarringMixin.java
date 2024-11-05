package org.confluence.mod.mixin.integration.terra_curio;

import org.confluence.terra_curio.api.primitive.ValueType;
import org.confluence.terra_curio.common.component.AccessoriesComponent;
import org.confluence.terra_curio.common.item.curio.BaseCurioItem;
import org.confluence.terra_curio.common.item.curio.fishing.AnglerEarring;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = AnglerEarring.class, remap = false)
public abstract class AnglerEarringMixin {
    @Inject(method = "getBuilder", at = @At("RETURN"), cancellable = true)
    private static void confluence(CallbackInfoReturnable<BaseCurioItem.Builder> cir) {
        cir.setReturnValue(BaseCurioItem.builder("angler_earring").noTooltip().accessories(AccessoriesComponent.of(ValueType.FISHING$POWER, 10.0F)));
    }
}
