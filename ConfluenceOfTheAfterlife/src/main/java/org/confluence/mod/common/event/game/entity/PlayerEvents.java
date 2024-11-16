package org.confluence.mod.common.event.game.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseRailBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.common.util.TriState;
import net.neoforged.neoforge.event.entity.player.*;
import org.confluence.mod.Confluence;
import org.confluence.mod.common.effect.harmful.CursedEffect;
import org.confluence.mod.common.effect.harmful.SilencedEffect;
import org.confluence.mod.common.effect.harmful.StonedEffect;
import org.confluence.mod.common.entity.minecart.BaseMinecartEntity;
import org.confluence.mod.common.init.ModAttachments;
import org.confluence.mod.common.init.ModEntities;
import org.confluence.mod.common.init.ModTags;
import org.confluence.mod.common.init.item.AccessoryItems;
import org.confluence.mod.mixed.IAbstractMinecart;
import org.confluence.mod.util.PlayerUtils;
import org.confluence.terra_curio.util.CuriosUtils;

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
        if (level.isClientSide || player.isCrouching() || event.getItemStack().is(ModTags.Items.MINECART)) return;
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

    }

    @SubscribeEvent
    public static void arrowLoose(ArrowLooseEvent event) {

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

        Level level = event.getEntity().level();
        BlockPos blockPos = event.getBlockPos();
        boolean ascending = event.getRailBlock().getRailDirection(event.getBlockState(), level, blockPos, null).isAscending();
        double offsetY = ascending ? 0.5 : 0.0;
        double x = blockPos.getX() + 0.5;
        double y = blockPos.getY() + 0.0625 + offsetY;
        double z = blockPos.getZ() + 0.5;
        ItemStack minecartItem = event.getMinecartItem();

        if (minecartItem == ItemStack.EMPTY) {
            BaseMinecartEntity baseMinecart = new BaseMinecartEntity(ModEntities.WOODEN_MINECART.get(), level, () -> Items.AIR, 0.308F, 0.16);
            baseMinecart.setPos(x, y, z);
            event.setMinecart(baseMinecart);
        } else {
            Item item = minecartItem.getItem();
            if (item == Items.MINECART) {
                event.setMinecart(new Minecart(level, x, y, z));
            }
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
}
