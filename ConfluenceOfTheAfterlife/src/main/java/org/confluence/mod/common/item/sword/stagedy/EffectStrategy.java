package org.confluence.mod.common.item.sword.stagedy;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import org.confluence.mod.common.init.ModEffects;

import java.util.function.BiConsumer;

/**
 * 近战攻击给敌人施加的效果
 * @author coffee
 */
public class EffectStrategy {
    /**
     * 血腥屠刀
     */
    public static final BiConsumer<LivingEntity,LivingEntity> BLOOD_BUTCHERED_EFFECT = (owner,entity) -> {
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

    /**
     * 施加单一效果
     */
    public static final BiConsumer<LivingEntity,MobEffectInstance> SIMPLE_EFFECT = (entity,effect) ->
            entity.addEffect(new MobEffectInstance(effect.getEffect(), effect.getDuration(), effect.getAmplifier()));

    // todo: 未定义效果，暂时用发光代替
    public static final BiConsumer<LivingEntity,LivingEntity> UNDEFINED_EFFECT = (owner, entity) -> SIMPLE_EFFECT.accept(entity,new MobEffectInstance(MobEffects.GLOWING,5 * 20));



}
