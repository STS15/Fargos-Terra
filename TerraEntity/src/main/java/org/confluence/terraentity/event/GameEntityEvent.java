package org.confluence.terraentity.event;

import net.minecraft.ChatFormatting;
import net.minecraft.advancements.critereon.EntityHurtPlayerTrigger;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.EntityLeaveLevelEvent;
import net.neoforged.neoforge.event.entity.living.*;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import org.confluence.terraentity.TerraEntity;
import org.confluence.terraentity.entity.ai.Boss;
import org.confluence.terraentity.entity.monster.AbstractMonster;
import org.confluence.terraentity.entity.monster.DemonPossession;
import org.confluence.terraentity.entity.monster.prefab.FlyMonsterPrefab;
import org.confluence.terraentity.entity.monster.slime.BaseSlime;
import org.confluence.terraentity.entity.monster.slime.BlackSlime;
import org.confluence.terraentity.entity.monster.slime.HoneySlime;
import org.confluence.terraentity.entity.util.DeathAnimOptions;
import org.confluence.terraentity.init.ModEffects;
import org.confluence.terraentity.init.ModEntities;
import org.confluence.terraentity.utils.FloatRGB;

import static org.confluence.terraentity.TerraEntity.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.GAME)
public class GameEntityEvent {
    @SubscribeEvent
    public static void entityJoinLevel(EntityJoinLevelEvent event) {
        Level level = event.getLevel();
        if (event.loadedFromDisk() || !(level instanceof ServerLevel serverLevel)) return;
        if (event.getEntity() instanceof Zombie zombie && !zombie.isBaby() && !zombie.isVehicle() && zombie.getRandom().nextFloat() < 0.05F) {
            BaseSlime slime = ModEntities.BLUE_SLIME.get().create(level);
            if (slime != null) {
                slime.moveTo(zombie.getX(), zombie.getY(), zombie.getZ(), zombie.getYRot(), 0.0F);
                slime.finalizeSpawn(serverLevel, level.getCurrentDifficultyAt(zombie.blockPosition()), MobSpawnType.JOCKEY, null);
                slime.startRiding(zombie);
                level.addFreshEntity(slime);
            }
        }
        if (event.getEntity() instanceof Boss boss){
            if (boss.shouldShowMessage()){
                Component mes;
                FloatRGB color;
                if (event.getEntity() instanceof DeathAnimOptions dao){
                    float[] _color = dao.getBloodColor();
                    color = new FloatRGB(_color[0], _color[1], _color[2]);
                } else {
                    color = new FloatRGB(0.7F, 0, 0);
                }
                if (event.getEntity().getCustomName() != null){
                    mes = Component.translatable("message.terraentity.boss_spawn",
                            event.getEntity().getCustomName().getString()).withColor(color.get()).withStyle(ChatFormatting.BOLD);
                } else {
                    mes = Component.translatable("message.terraentity.boss_spawn",
                            event.getEntity().getName().getString()).withColor(color.get()).withStyle(ChatFormatting.BOLD);
                }
                for (Player player : level.players()){
                    player.sendSystemMessage(mes);
                }
            }
        }
    }

    @SubscribeEvent
    public static void FinalizeSpawnRegister(FinalizeSpawnEvent event) {
        if(event.getEntity() instanceof BlackSlime entity){
            entity.finalizeSpawn(entity.getRandom(),event.getDifficulty());
        }

    }
    @SubscribeEvent
    public static void FinalizeSpawnRegister(LivingEvent.LivingJumpEvent event) {

    }

    @SubscribeEvent
    public static void entityDeathLevel(LivingDeathEvent event) {
        Level level = event.getEntity().level();
        if (event.getEntity() instanceof Boss boss){
            if (boss.shouldShowMessage()){
                Component mes;
                FloatRGB color;
                if (event.getEntity() instanceof DeathAnimOptions dao){
                    float[] _color = dao.getBloodColor();
                    color = new FloatRGB(_color[0], _color[1], _color[2]);
                } else {
                    color = new FloatRGB(0.7F, 0, 0);
                }
                if (event.getEntity().getCustomName() != null){
                    mes = Component.translatable("message.terraentity.boss_leave",
                            event.getEntity().getCustomName().getString()).withColor(color.get()).withStyle(ChatFormatting.BOLD);
                } else {
                    mes = Component.translatable("message.terraentity.boss_leave",
                            event.getEntity().getName().getString()).withColor(color.get()).withStyle(ChatFormatting.BOLD);
                }
                for (Player player : level.players()){
                    player.sendSystemMessage(mes);   //todo 报两次
                }
            }
        }
    }

    @SubscribeEvent
    public static void livingDamageEntity(LivingDamageEvent.Post event) {
        LivingEntity e = (LivingEntity) event.getSource().getEntity();
        LivingEntity e1 = event.getEntity();
        Level level = event.getEntity().level();
        if (!(level instanceof ServerLevel serverLevel)) return;
        if (e instanceof DemonPossession dp){
            if (!e1.hasEffect(ModEffects.DEMONIC_THOUGHTS)){
                e1.addEffect(new MobEffectInstance(
                        ModEffects.DEMONIC_THOUGHTS, 200
                ), dp);
            } else {
                e1.removeEffect(ModEffects.DEMONIC_THOUGHTS);
                e1.hurt(event.getSource(), 6);
                AbstractMonster soulEater = ModEntities.SOULS_EATER.get().create(level);
                soulEater.setPos(e1.getEyePosition());
                soulEater.setTarget(e1);
                level.addFreshEntity(soulEater);
                e1.removeEffect(ModEffects.DEMONIC_THOUGHTS);
            }
        }
    }

    @SubscribeEvent
    public static void entityInteract(PlayerInteractEvent.EntityInteract event){
        ItemStack item = event.getItemStack();
        LivingEntity entity = (LivingEntity) event.getTarget();
        Player player = event.getEntity();
        Level level = event.getLevel();
        if (    entity.getType().equals(ModEntities.BLUE_SLIME.get()) ||
                entity.getType().equals(ModEntities.GREEN_SLIME.get()) ||
                entity.getType().equals(ModEntities.PURPLE_SLIME.get())){
            if (item.is(ItemTags.create(TerraEntity.asResource("confluence", "honey_translation_with_bucket")))){
                HoneySlime slime = ModEntities.HONEY_SLIME.get().create(level);
                item.shrink(1);
                player.addItem(new ItemStack(Items.BUCKET));
                slime.setSize(2, true);
                slime.setPos(entity.getPosition(0));
                slime.setXRot(entity.getXRot());
                slime.setYRot(entity.getYRot());
                level.addFreshEntity(slime);
                entity.remove(Entity.RemovalReason.DISCARDED);
            } else if (item.is(ItemTags.create(TerraEntity.asResource("confluence", "honey_translation")))){
                HoneySlime slime = ModEntities.HONEY_SLIME.get().create(level);
                item.shrink(1);
                slime.setSize(2, true);
                slime.setPos(entity.getPosition(0));
                slime.setXRot(entity.getXRot());
                slime.setYRot(entity.getYRot());
                level.addFreshEntity(slime);
                entity.remove(Entity.RemovalReason.DISCARDED);
            } else if (item.is(ItemTags.create(TerraEntity.asResource("confluence", "honey_translation_not_consumed")))){
                HoneySlime slime = ModEntities.HONEY_SLIME.get().create(level);
                slime.setSize(2, true);
                slime.setPos(entity.getPosition(0));
                slime.setXRot(entity.getXRot());
                slime.setYRot(entity.getYRot());
                level.addFreshEntity(slime);
                entity.remove(Entity.RemovalReason.DISCARDED);
                event.setCanceled(true);
                return;
            }
        }
    }
}
