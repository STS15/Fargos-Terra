package org.confluence.mod.mixin.integration.terra_curio;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import org.confluence.mod.common.init.ModEffects;
import org.confluence.mod.terra_curio.common.component.ModRarity;
import org.confluence.mod.terra_curio.common.item.curio.BaseCurioItem;
import org.confluence.mod.terra_curio.common.item.curio.combat.AnkhShield;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = AnkhShield.class, remap = false)
public abstract class AnkhShieldMixin {
    @Inject(method = "getBuilder", at = @At("RETURN"), cancellable = true)
    private static void confluence(CallbackInfoReturnable<BaseCurioItem.Builder> cir) {
        cir.setReturnValue(BaseCurioItem.builder("ankh_shield").effectImmunities(
                MobEffects.POISON, MobEffects.BLINDNESS,
                MobEffects.MOVEMENT_SLOWDOWN, MobEffects.WEAKNESS,
                ModEffects.BLEEDING, ModEffects.BROKEN_ARMOR,
                ModEffects.CONFUSED, ModEffects.CURSED,
                ModEffects.SILENCED, ModEffects.STONED
        ).attribute(
                Attributes.KNOCKBACK_RESISTANCE, "knockback_resistance", 1.0, AttributeModifier.Operation.ADD_VALUE
        ).attribute(
                Attributes.ARMOR, "armor", 4.0, AttributeModifier.Operation.ADD_VALUE
        ).rarity(ModRarity.LIME).initialize());
    }
}
