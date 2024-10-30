package org.confluence.mod.common.item.sword.stagedy;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import org.confluence.mod.common.init.ModEffects;

import java.util.function.Consumer;

/**
 * 近战攻击给敌人施加的效果
 * @author coffee
 */
public class EffectStrategy {
    public static final Consumer<LivingEntity> BLOOD_BUTCHERED_EFFECT = (entity) -> {
        if (entity.hasEffect(ModEffects.BLOOD_BUTCHERED)) {
            if (entity.getEffect(ModEffects.BLOOD_BUTCHERED).getAmplifier() < 4) {
                entity.addEffect(new MobEffectInstance(ModEffects.BLOOD_BUTCHERED, 180, entity.getEffect(ModEffects.BLOOD_BUTCHERED).getAmplifier() + 1, false, true, false));
            } else {
                entity.addEffect(new MobEffectInstance(ModEffects.BLOOD_BUTCHERED, 180, 4, false, true, false));
            }
        } else {
            entity.addEffect(new MobEffectInstance(ModEffects.BLOOD_BUTCHERED, 180, 0, false, true, false));
        }
    };
}
