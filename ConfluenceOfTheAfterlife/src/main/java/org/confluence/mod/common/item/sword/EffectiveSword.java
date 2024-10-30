package org.confluence.mod.common.item.sword;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Tier;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.confluence.mod.terra_curio.common.component.ModRarity;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class EffectiveSword extends BaseSwordItem {

    public EffectiveSword(Tier tier, ModRarity rarity, int rawDamage, float rawSpeed, MobEffectInstance... effects) {
        super(tier, rarity, rawDamage, rawSpeed);
        Arrays.stream(effects).distinct().forEach(effect -> this.modifier.addOnHitEffect(entity -> entity.addEffect(new MobEffectInstance(effect.getEffect(), effect.getDuration(), effect.getAmplifier()))));
    }

    @SafeVarargs
    public EffectiveSword(Tier tier, ModRarity rarity, int rawDamage, float rawSpeed, Consumer<LivingEntity>... effects) {
        super(tier, rarity, rawDamage, rawSpeed);
        Arrays.stream(effects).distinct().forEach(effect -> this.modifier.addOnHitEffect(effect));

    }

}
