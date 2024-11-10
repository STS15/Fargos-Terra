package org.confluence.mod.common.event;

import net.minecraft.network.chat.Component;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.confluence.mod.Confluence;
import org.confluence.mod.client.gui.screens.GroupWikiScreen;
import org.confluence.mod.client.gui.screens.ObjectWikiScreen;
import org.confluence.mod.common.CommonConfigs;
import org.confluence.mod.common.block.natural.LogBlockSet;
import org.confluence.mod.common.block.natural.spreadable.ISpreadable;
import org.confluence.mod.common.init.item.*;
import org.confluence.mod.network.c2s.SwordShootingPacketC2S;
import org.confluence.mod.network.s2c.GamePhasePacketS2C;
import org.confluence.mod.network.s2c.ManaPacketS2C;
import org.confluence.terra_curio.api.event.RegisterAccessoriesComponentUpdateEvent;

import java.util.List;

import static org.confluence.mod.Confluence.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD)
public final class ModEvents {
    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            CommonConfigs.onLoad();
            Confluence.registerGameRules();
            GroupWikiScreen.putWikiType("item",
                    List.of(AccessoryItems.ACCESSORIES, ArrowItems.ARROWS, AxeItems.AXE,
                            BaitItems.BAITS, BowItems.BOWS, FishingPoleItems.POLES,
                            FoodItems.FOODS, MaterialItems.MATERIALS,
                            ModItems.ITEMS, QuestedFishes.FISHES,
                            SwordItems.SWORDS, TerraPotions.POTIONS),
                    List.of("accessories", "arrow", "axe", "bait", "bow",
                            "fishing_pole", "food", "material", "misc", "quested_fish",
                            "sword", "terra_potion"));
//            ObjectWikiScreen.putDescription("confluence:copper_short_sword",
//                    Component.translatable("key"));
            ObjectWikiScreen.putDescription("confluence:copper_short_sword",
                    Component.translatable("wiki.confluence.copper_short_sword"));
        });
    }

    @SubscribeEvent
    public static void loadComplete(FMLLoadCompleteEvent event) {
        event.enqueueWork(() -> {
            LogBlockSet.wrapStrip();
            Confluence.registerMinecartAbility();
            ISpreadable.Type.buildMap();
        });
    }

    @SubscribeEvent
    public static void addPackFinders(AddPackFindersEvent event) {

    }

    @SubscribeEvent
    public static void registerPayloadHandlers(RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar("1");
        registrar.playToClient(
                ManaPacketS2C.TYPE,
                ManaPacketS2C.STREAM_CODEC,
                ManaPacketS2C::handle
        );
        registrar.playToClient(
                GamePhasePacketS2C.TYPE,
                GamePhasePacketS2C.STREAM_CODEC,
                GamePhasePacketS2C::handle
        );
        registrar.playToServer(
                SwordShootingPacketC2S.TYPE,
                SwordShootingPacketC2S.STREAM_CODEC,
                SwordShootingPacketC2S::receive
        );
    }

    @SubscribeEvent
    public static void registerUnitType(RegisterAccessoriesComponentUpdateEvent.UnitType event) {
        event.register(AccessoryItems.LUCKY$COIN);
        event.register(AccessoryItems.SHEARS$DIG);
    }

    @SubscribeEvent
    public static void registerOtherType(RegisterAccessoriesComponentUpdateEvent.OtherType event) {
        event.register(AccessoryItems.COIN$PICKUP$RANGE);
    }
}
