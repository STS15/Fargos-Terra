package org.confluence.mod.common.event;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.RegisterEvent;
import org.confluence.mod.Confluence;
import org.confluence.mod.common.CommonConfigs;
import org.confluence.mod.common.block.natural.LogBlockSet;
import org.confluence.mod.common.block.natural.spreadable.ISpreadable;
import org.confluence.mod.common.fluid.FluidBuilder;
import org.confluence.mod.common.init.ModFluids;
import org.confluence.mod.common.init.block.FunctionalBlocks;
import org.confluence.mod.common.init.block.OreBlocks;
import org.confluence.mod.common.init.item.AccessoryItems;
import org.confluence.mod.network.c2s.HookThrowingPacketC2S;
import org.confluence.mod.network.c2s.SwordShootingPacketC2S;
import org.confluence.mod.network.s2c.*;
import org.confluence.phase_journey.PhaseJourney;
import org.confluence.phase_journey.api.PhaseJourneyEvent;
import org.confluence.terra_curio.api.event.RegisterAccessoriesComponentUpdateEvent;
import org.confluence.terra_curio.common.init.TCItems;
import org.confluence.terra_curio.common.init.TCTabs;

import static org.confluence.mod.Confluence.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD)
public final class ModEvents {
    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            CommonConfigs.onLoad();
            Confluence.registerGameRules();
            ModFluids.registerInteraction();
            ModFluids.registerShimmerTransform();
        });
    }

    @SubscribeEvent
    public static void loadComplete(FMLLoadCompleteEvent event) {
        event.enqueueWork(() -> {
            FunctionalBlocks.MECHANICAL_BLOCKS = null; // 销毁
            LogBlockSet.wrapStrip();
            ISpreadable.Type.buildMap();
        });
    }

    @SubscribeEvent
    public static void addPackFinders(AddPackFindersEvent event) {

    }

    @SubscribeEvent
    public static void register(RegisterEvent event) {
        FluidBuilder.register(event);
    }

    @SubscribeEvent
    public static void registerPayloadHandlers(RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar("1");
        registrar.playToClient(ManaPacketS2C.TYPE, ManaPacketS2C.STREAM_CODEC, ManaPacketS2C::handle);
        registrar.playToClient(GamePhasePacketS2C.TYPE, GamePhasePacketS2C.STREAM_CODEC, GamePhasePacketS2C::handle);
        registrar.playToClient(FishingPowerInfoPacketS2C.TYPE, FishingPowerInfoPacketS2C.STREAM_CODEC, FishingPowerInfoPacketS2C::handle);
        registrar.playToClient(MechanicalViewPacketS2C.TYPE, MechanicalViewPacketS2C.STREAM_CODEC, MechanicalViewPacketS2C::handle);
        registrar.playToClient(StarPhasesPacketS2C.TYPE, StarPhasesPacketS2C.STREAM_CODEC, StarPhasesPacketS2C::handle);

        registrar.playToServer(SwordShootingPacketC2S.TYPE, SwordShootingPacketC2S.STREAM_CODEC, SwordShootingPacketC2S::receive);
        registrar.playToServer(HookThrowingPacketC2S.TYPE, HookThrowingPacketC2S.STREAM_CODEC, HookThrowingPacketC2S::handle);
    }

    @SubscribeEvent
    public static void registerUnitType(RegisterAccessoriesComponentUpdateEvent.UnitType event) {
        event.register(AccessoryItems.MECHANICAL$VIEW);
        event.register(AccessoryItems.LUCKY$COIN);
        event.register(AccessoryItems.SHEARS$DIG);
        event.register(AccessoryItems.ICE$SAFE);
        event.register(AccessoryItems.AUTO$GET$MANA);
        event.register(AccessoryItems.HURT$GET$MANA);
        event.register(AccessoryItems.FAST$MANA$GENERATION);
    }

    @SubscribeEvent
    public static void registerOtherType(RegisterAccessoriesComponentUpdateEvent.OtherType event) {
        event.register(AccessoryItems.ADDITIONAL$MANA);
        event.register(AccessoryItems.MANA$USE$REDUCE);
        event.register(AccessoryItems.MANA$PICKUP$RANGE);
        event.register(AccessoryItems.COIN$PICKUP$RANGE);
        event.register(AccessoryItems.REDUCE$HEALING$COOLDOWN);
        event.register(AccessoryItems.FISHING$POWER);
    }

    @SubscribeEvent
    public static void buildCreativeModeTabContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == TCTabs.ACCESSORIES.get()) {
            event.insertFirst(TCItems.BASE_POINT.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertFirst(TCItems.EVERLASTING.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            Object[] entries = AccessoryItems.ITEMS.getEntries().toArray();
            for (int i = entries.length - 1; i > -1; i--) {
                DeferredItem<? extends Item> entry = (DeferredItem<? extends Item>) entries[i];
                event.insertFirst(entry.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            }
        }
    }

    @SubscribeEvent
    public static void phaseJourney$Register(PhaseJourneyEvent.Register event) {
        int step = 0;
        for (int state = 0; state < 3; state++) {
            event.phaseRegister(PhaseJourney.asResource("reveal_step_" + (step++)), context -> {
                context.blockReplacement(OreBlocks.DEEPSLATE_COBALT_ORE.get(), Blocks.DEEPSLATE);
                context.blockReplacement(OreBlocks.DEEPSLATE_PALLADIUM_ORE.get(), Blocks.DEEPSLATE);
            });
            event.phaseRegister(PhaseJourney.asResource("reveal_step_" + (step++)), context -> {
                context.blockReplacement(OreBlocks.DEEPSLATE_MITHRIL_ORE.get(), Blocks.DEEPSLATE);
                context.blockReplacement(OreBlocks.DEEPSLATE_ORICHALCUM_ORE.get(), Blocks.DEEPSLATE);
            });
            event.phaseRegister(PhaseJourney.asResource("reveal_step_" + (step++)), context -> {
                context.blockReplacement(OreBlocks.DEEPSLATE_ADAMANTITE_ORE.get(), Blocks.DEEPSLATE);
                context.blockReplacement(OreBlocks.DEEPSLATE_TITANIUM_ORE.get(), Blocks.DEEPSLATE);
            });
        }
    }
}
