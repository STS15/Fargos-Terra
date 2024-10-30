package org.confluence.mod.common.event.game.entity;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.*;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent.Post;
import org.confluence.mod.Confluence;
import org.confluence.mod.common.init.ModEffects;
import org.confluence.mod.common.item.sword.BaseSwordItem;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME, modid = Confluence.MODID)
public final class LivingEntityEvents {
    @SubscribeEvent
    public static void livingDeath(LivingDeathEvent event) {

    }

    @SubscribeEvent
    public static void livingChangeTarget(LivingChangeTargetEvent event) {

    }

    @SubscribeEvent
    public static void livingHeal(LivingHealEvent event) {

    }

    @SubscribeEvent
    public static void livingBreathe(LivingBreatheEvent event) {

    }

    @SubscribeEvent
    public static void finalizeSpawn(FinalizeSpawnEvent event) {

    }

    @SubscribeEvent
    public static void effectAdded(MobEffectEvent.Added event) {

    }

    @SubscribeEvent
    public static void effectExpired(MobEffectEvent.Expired event) {

    }

    @SubscribeEvent
    public static void effectRemove(MobEffectEvent.Remove event) {

    }

    @SubscribeEvent
    public static void livingEquipmentChange(LivingEquipmentChangeEvent event) {

    }

    @SubscribeEvent
    public static void livingEntityUseItem$tick(LivingEntityUseItemEvent.Tick event) {

    }

    @SubscribeEvent
    public static void livingAttack(LivingDamageEvent.Post event) {
        DamageSource damageSource = event.getSource();
        LivingEntity damageEntity = event.getEntity();
        if (damageSource != null && damageSource.getEntity() instanceof LivingEntity livingEntity) {
            if (livingEntity.getItemInHand(event.getEntity().getUsedItemHand()).getItem() instanceof BaseSwordItem sword) {
                if (sword.modifier != null) {
                    sword.modifier.onHitEffects.forEach(effect -> effect.accept(damageEntity));
                }
            }
        }
    }

}
