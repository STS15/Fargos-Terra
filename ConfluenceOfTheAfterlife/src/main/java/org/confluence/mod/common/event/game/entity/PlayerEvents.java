package org.confluence.mod.common.event.game.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseRailBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.common.util.TriState;
import net.neoforged.neoforge.event.entity.player.*;
import org.confluence.mod.Confluence;
import org.confluence.mod.common.attachment.EverBeneficial;
import org.confluence.mod.common.effect.harmful.CursedEffect;
import org.confluence.mod.common.effect.harmful.SilencedEffect;
import org.confluence.mod.common.effect.harmful.StonedEffect;
import org.confluence.mod.common.entity.minecart.BaseMinecartEntity;
import org.confluence.mod.common.init.ModAttachments;
import org.confluence.mod.common.init.ModSoundEvents;
import org.confluence.mod.common.init.ModTags;
import org.confluence.mod.common.init.ModTiers;
import org.confluence.mod.common.init.item.AccessoryItems;
import org.confluence.mod.common.item.common.BaseMinecartItem;
import org.confluence.mod.common.item.common.EverBeneficialItem;
import org.confluence.mod.mixed.IAbstractMinecart;
import org.confluence.mod.mixed.IFishingHook;
import org.confluence.mod.util.PlayerUtils;
import org.confluence.terra_curio.util.CuriosUtils;
import org.confluence.terra_curio.util.TCUtils;

import java.util.Optional;

import static org.confluence.mod.api.event.MinecartAbilityEvent.DismountOnMinecart;
import static org.confluence.mod.api.event.MinecartAbilityEvent.RightClickRailBlock;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME, modid = Confluence.MODID)
public final class PlayerEvents {
    @SubscribeEvent
    public static void playerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();
        if (PlayerUtils.isServerNotFake(player)) {
            ServerPlayer serverPlayer = (ServerPlayer) player;
            PlayerUtils.syncMana2Client(serverPlayer);
            PlayerUtils.syncSavedData(serverPlayer);
        }
    }

    @SubscribeEvent
    public static void rightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getEntity();
        Level level = event.getLevel();
        if (!(level instanceof ServerLevel) || player.isCrouching() || event.getItemStack().is(ModTags.Items.MINECART)) return;
        BlockPos blockPos = event.getPos();
        BlockState blockState = level.getBlockState(blockPos);
        if (blockState.getBlock() instanceof BaseRailBlock railBlock) {
            Optional<ItemStack> optionalItemStack = CuriosUtils.getSlot(player, "minecart", 0);
            player.swing(InteractionHand.MAIN_HAND, true);
            ItemStack itemStack = optionalItemStack.orElse(ItemStack.EMPTY);
            RightClickRailBlock e = NeoForge.EVENT_BUS.post(new RightClickRailBlock(player, itemStack, blockState, railBlock, blockPos));
            if (e.isCanceled()) return;
            AbstractMinecart minecart = e.getMinecart();
            if (minecart != null) {
                itemStack.shrink(1);
                level.addFreshEntity(minecart);
                player.startRiding(minecart, true);
            }
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void itemEntityPickup$Pre(ItemEntityPickupEvent.Pre event) {
        ItemEntity itemEntity = event.getItemEntity();
        ItemStack itemStack = itemEntity.getItem();
        Player player = event.getPlayer();
        if (itemStack.is(ModTags.Items.PROVIDE_MANA)) {
            player.getData(ModAttachments.MANA_STORAGE).receiveMana(() -> itemStack.getCount() * 100);
            itemEntity.discard();
            event.setCanPickup(TriState.FALSE);
        } else if (itemStack.is(ModTags.Items.PROVIDE_LIFE)) {
            player.heal(itemStack.getCount() * 4.0F);
            itemEntity.discard();
            event.setCanPickup(TriState.FALSE);
        }
    }

    @SubscribeEvent
    public static void itemFished(ItemFishedEvent event) {
        Player player = event.getEntity();
        Level level = player.level();
        if (TCUtils.hasAccessoriesType(player, AccessoryItems.HIGH$TEST$FISHING$LINE) && level.random.nextFloat() < 0.1429F) {
            level.playSound(null, player.getOnPos().above(), ModSoundEvents.DECOUPLING.get(), SoundSource.PLAYERS);
            event.setCanceled(true);
            return;
        }
        IFishingHook fishingHook = (IFishingHook) event.getHookEntity();
        ItemStack bait = fishingHook.confluence$getBait();
        if (bait == null) return;
        float factor = TCUtils.hasAccessoriesType(player, AccessoryItems.TACKLE$BOX) ? 1.0F : 2.0F;
        if (player.getRandom().nextFloat() < 1.0F / (factor + fishingHook.confluence$getBonus() / 6.0F)) {
            bait.shrink(1);
        }
    }

    @SubscribeEvent
    public static void rightClickItem(PlayerInteractEvent.RightClickItem event) {
        Player player = event.getEntity();
        SilencedEffect.onRightClick(player, event);
        CursedEffect.onRightClick(player, event::setCanceled);
        StonedEffect.onRightClick(player, event::setCanceled);
    }

    @SubscribeEvent
    public static void attackEntity(AttackEntityEvent event) {
        Player player = event.getEntity();
        if (PlayerUtils.isServerNotFake(player)) {
            Entity target = event.getTarget();
            AccessoryItems.applyLuckyCoin(player, target);
        }
    }

    @SubscribeEvent
    public static void rightClickRailBlock(RightClickRailBlock event) {
        AbstractMinecart minecart = event.getMinecart();
        if (event.isCanceled() || minecart != null) return;

        ServerLevel level = (ServerLevel) event.getEntity().level();
        BlockPos blockPos = event.getBlockPos();
        boolean ascending = event.getRailBlock().getRailDirection(event.getBlockState(), level, blockPos, null).isAscending();
        double x = blockPos.getX() + 0.5;
        double y = blockPos.getY() + 0.0625 + (ascending ? 0.5 : 0.0);
        double z = blockPos.getZ() + 0.5;
        ItemStack minecartItem = event.getMinecartItem();

        if (minecartItem == ItemStack.EMPTY) {
            BaseMinecartEntity baseMinecart = new BaseMinecartEntity(level, x, y, z, BaseMinecartEntity.WOODEN);
            event.setMinecart(baseMinecart);
        } else if (minecartItem.getItem() == Items.MINECART) {
            event.setMinecart(new Minecart(level, x, y, z));
        } else if (minecartItem.getItem() instanceof BaseMinecartItem baseMinecartItem) {
            event.setMinecart(baseMinecartItem.createMinecart(level, x, y, z, AbstractMinecart.Type.RIDEABLE, minecartItem, event.getEntity()));
        }
    }

    @SubscribeEvent
    public static void dismountOnMinecart(DismountOnMinecart event) {
        if (event.isCanceled() || event.getMinecartItem() != null) return;
        AbstractMinecart.Type type = event.getMinecart().getMinecartType();

        if (type == AbstractMinecart.Type.RIDEABLE) {
            event.setMinecartItem(((IAbstractMinecart) event.getMinecart()).confluence$getDropItem().getDefaultInstance());
        }
    }

    @SubscribeEvent // 可以拿到复制前的玩家
    public static void respawnPosition(PlayerRespawnPositionEvent event) {
        if (!(event.getEntity() instanceof ServerPlayer serverPlayer)) return;
        if (event.isFromEndFight()) {
            serverPlayer.getPersistentData().putFloat("confluence:cached_health", serverPlayer.getHealth());
        }
    }

    @SubscribeEvent
    public static void respawn(PlayerEvent.PlayerRespawnEvent event) {
        if (!(event.getEntity() instanceof ServerPlayer serverPlayer)) return;
        EverBeneficial everBeneficial = serverPlayer.getData(ModAttachments.EVER_BENEFICIAL);
        if (everBeneficial.getUsedLifeCrystals() > 0) {
            EverBeneficialItem.LIFE_CRYSTAL.post().accept(EverBeneficialItem.LIFE_CRYSTAL.id(), serverPlayer, everBeneficial, true);
        }
        if (everBeneficial.getUsedLifeFruits() > 0) {
            EverBeneficialItem.LIFE_FRUITS.post().accept(EverBeneficialItem.LIFE_FRUITS.id(), serverPlayer, everBeneficial, true);
        }
        if (everBeneficial.isAegisAppleUsed()) {
            EverBeneficialItem.AEGIS_APPLE.post().accept(EverBeneficialItem.AEGIS_APPLE.id(), serverPlayer, everBeneficial, true);
        }
        if (everBeneficial.isAmbrosiaUsed()) {
            EverBeneficialItem.AMBROSIA.post().accept(EverBeneficialItem.AMBROSIA.id(), serverPlayer, everBeneficial, true);
        }
        if (everBeneficial.isGalaxyPearlUsed()) {
            EverBeneficialItem.GALAXY_PEARL.post().accept(EverBeneficialItem.GALAXY_PEARL.id(), serverPlayer, everBeneficial, true);
        }
        if (event.isEndConquered()) {
            serverPlayer.setHealth(serverPlayer.getPersistentData().getFloat("confluence:cached_health"));
        }
    }

    @SubscribeEvent
    public static void harvestCheck(PlayerEvent.HarvestCheck event) {
        ItemStack itemStack = event.getEntity().getMainHandItem();
        if (!itemStack.isEmpty() && itemStack.getItem() instanceof DiggerItem diggerItem) {
            int power = 0;
            Tier tier = diggerItem.getTier();
            if (tier instanceof ModTiers.PoweredTier poweredTier) {
                power = poweredTier.getPower();
            } else if (tier instanceof Tiers tiers) {
                power = ModTiers.getPowerForVanillaTiers(tiers);
            }
            event.setCanHarvest(ModTiers.isCorrectToolForDrops(power, itemStack, event.getTargetBlock()));
        }
    }
}
