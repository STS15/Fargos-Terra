package org.confluence.mod.mixin.integration.terra_curio;

import net.minecraft.world.effect.MobEffects;
import org.confluence.mod.common.init.ModEffects;
import org.confluence.mod.terra_curio.common.component.ModRarity;
import org.confluence.mod.terra_curio.common.item.curio.BaseCurioItem;
import org.confluence.mod.terra_curio.common.item.curio.combat.AnkhCharm;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = AnkhCharm.class, remap = false)
public abstract class AnkhCharmMixin {
    @Inject(method = "getBuilder", at = @At("RETURN"), cancellable = true)
    private static void confluence(CallbackInfoReturnable<BaseCurioItem.Builder> cir) {
        cir.setReturnValue(BaseCurioItem.builder("ankh_charm").effectImmunities(
                MobEffects.POISON, MobEffects.BLINDNESS,
                MobEffects.MOVEMENT_SLOWDOWN, MobEffects.WEAKNESS,
                ModEffects.BLEEDING, ModEffects.BROKEN_ARMOR,
                org.confluence.mod.terra_curio.common.effect.ModEffects.CONFUSED, ModEffects.CURSED,
                ModEffects.SILENCED, ModEffects.STONED
        ).rarity(ModRarity.LIGHT_PURPLE).initialize());
    }
}
