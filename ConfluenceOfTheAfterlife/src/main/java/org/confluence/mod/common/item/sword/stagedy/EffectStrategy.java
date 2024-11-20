package org.confluence.mod.common.item.sword.stagedy;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import org.apache.commons.lang3.function.TriFunction;
import org.confluence.mod.common.init.ModEffects;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/**
 * 攻击时给敌人施加的效果或回调
 * NOT USABLE: 用于内部复用，不提供给外部调用

 * @author coffee
 */
public class EffectStrategy {

    /**NOT USABLE 施加单一效果*/
    private static final BiConsumer<LivingEntity,MobEffectInstance> ABSTRACT_SIMPLE_EFFECT = (entity, effect) ->
            entity.addEffect(new MobEffectInstance(effect.getEffect(), effect.getDuration(), effect.getAmplifier()));

    /**BASE: 最广泛的接口，可以派生出其他效果
     * <p>effect 效果</p>
     * <p>ticks 持续时间</p>
     * <p>possibility 概率</p>
     * */
    public static final TriFunction<Holder<MobEffect>,Integer,Float, BiConsumer<LivingEntity,LivingEntity>> TIME_POSSIBILITY_EFFECT = (effect, ticks, possibility)->
            (owner, entity) ->{ if(entity.getRandom().nextFloat() < possibility)  ABSTRACT_SIMPLE_EFFECT.accept(entity,new MobEffectInstance(effect,ticks));};


    /**占位符，未定义效果，暂时用发光代替*/
    public static final BiConsumer<LivingEntity,LivingEntity> UNDEFINED_EFFECT = TIME_POSSIBILITY_EFFECT.apply(MobEffects.GLOWING, 20*5, 0.5f);



//其他回调用法
    /**着火*/
    public static final BiFunction<Integer,Float,BiConsumer<LivingEntity,LivingEntity>> SET_FIRE = (ticks,possibility) ->
            (owner1,entity1)->{ if(entity1.getRandom().nextFloat() < possibility)  entity1.setRemainingFireTicks(ticks);};


    /**血腥屠刀*/
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


}
