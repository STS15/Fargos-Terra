package org.confluence.mod.common.item.sword.stagedy;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.confluence.mod.common.item.sword.BaseSwordItem.QuaConsumer;

public class InventoryTickStrategy {
    public static final QuaConsumer<ItemStack, Level, Entity,Boolean> UMBRELLA_TICK= (stack, level, entity, selected)-> {
        if (level.isClientSide) return;
        if (selected && entity instanceof LivingEntity living && !living.swinging) {
            living.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 2, 2, false, false, false));
        }
    };


    public static final QuaConsumer<ItemStack, Level, Entity,Boolean> INVINCIBLE= (stack, level, entity, selected)-> {
        if (level.isClientSide) return;
        if (selected && entity instanceof LivingEntity living && !living.swinging) {
            living.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 20, 2, false, false, true));
        }
    };
}
