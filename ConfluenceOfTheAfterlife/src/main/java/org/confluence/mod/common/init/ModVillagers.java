package org.confluence.mod.common.init;

import com.google.common.collect.ImmutableSet;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.BasicItemListing;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.apache.commons.lang3.IntegerRange;
import org.confluence.mod.common.entity.npc.RandomItemListing;
import org.confluence.mod.common.entity.npc.SkyVillagerItemListing;
import org.confluence.mod.common.init.block.DecorativeBlocks;
import org.confluence.mod.common.init.block.FunctionalBlocks;
import org.confluence.mod.common.init.block.ModBlocks;
import org.confluence.mod.common.init.block.NatureBlocks;
import org.confluence.mod.common.init.item.*;
import org.confluence.terra_curio.common.init.TCItems;

import java.util.List;
import java.util.function.Supplier;

import static org.confluence.mod.Confluence.MODID;

public final class ModVillagers {
    public static final DeferredRegister<PoiType> POIS = DeferredRegister.create(BuiltInRegistries.POINT_OF_INTEREST_TYPE, MODID);
    public static final DeferredRegister<VillagerProfession> PROFESSIONS = DeferredRegister.create(BuiltInRegistries.VILLAGER_PROFESSION, MODID);
    public static final DeferredRegister<VillagerType> TYPES = DeferredRegister.create(BuiltInRegistries.VILLAGER_TYPE, MODID);

    // 村民的兴趣点
    public static final DeferredHolder<PoiType, PoiType> SKY_POI = POIS.register("sky", () -> new PoiType(ImmutableSet.copyOf(FunctionalBlocks.SKY_MILL.get().getStateDefinition().getPossibleStates()), 1, 1));
    public static final DeferredHolder<PoiType, PoiType> COIN_POI = POIS.register("coin", () -> new PoiType(ImmutableSet.copyOf(ModBlocks.GOLDEN_COIN_PILE.get().getStateDefinition().getPossibleStates()), 1, 1));

    // 村民的职业
    public static final Supplier<VillagerProfession> SKY_MILLER = PROFESSIONS.register("sky_miller", () -> new VillagerProfession("sky", holder -> holder.is(SKY_POI.getId()), holder -> holder.is(SKY_POI.getId()), ImmutableSet.of(MaterialItems.FALLING_STAR.get()), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_WEAPONSMITH));
    public static final Supplier<VillagerProfession> BANKER = PROFESSIONS.register("banker", () -> new VillagerProfession("coin", holder -> holder.is(COIN_POI.getId()), holder -> holder.is(COIN_POI.getId()), ImmutableSet.of(
            ModItems.COPPER_COIN.get(),
            ModItems.SILVER_COIN.get(),
            ModItems.GOLDEN_COIN.get(),
            ModItems.PLATINUM_COIN.get(),
            ModItems.EMERALD_COIN.get()
    ), ImmutableSet.of(), ModSoundEvents.COINS.get()));

    // 村民的群系
    public static final Supplier<VillagerType> SKY_TYPE = TYPES.register("sky", () -> new VillagerType("confluence_sky")); // 天域村民

    public static void villagerTrades(VillagerTradesEvent event) {
        VillagerProfession type = event.getType();
        Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
        List<VillagerTrades.ItemListing> tier1 = trades.get(1);
        List<VillagerTrades.ItemListing> tier2 = trades.get(2);
        List<VillagerTrades.ItemListing> tier3 = trades.get(3);
        List<VillagerTrades.ItemListing> tier4 = trades.get(4);
        List<VillagerTrades.ItemListing> tier5 = trades.get(5);
        if (type == SKY_MILLER.get()) {
            tier1.add(new RandomItemListing(Items.EMERALD, NatureBlocks.CLOUD_BLOCK.get(), IntegerRange.of(2, 3), 12, 5, 0.05f));
            tier1.add(new BasicItemListing(new ItemStack(MaterialItems.WEAVING_CLOUD_COTTON.get(), 5), new ItemStack(Items.EMERALD), 7, 5, 0.05f));
            tier2.add(new RandomItemListing(Items.DIRT, IntegerRange.of(61, 64), Items.EMERALD, 2, 10, 0.05f));
            tier3.add(new BasicItemListing(new ItemStack(ModItems.EMERALD_COIN.get()), new ItemStack(FoodItems.CLOUDWEAVER_SEED.get(), 3), 25, 10, 0.05f));
            tier3.add(new BasicItemListing(new ItemStack(Items.WATER_BUCKET), new ItemStack(NatureBlocks.RAIN_CLOUD_BLOCK.get()), 12, 20, 0.05f));
            tier3.add(new RandomItemListing(MaterialItems.FALLING_STAR.get(), IntegerRange.of(2, 3), DecorativeBlocks.SUN_PLATE.get(), 10, 12, 20, 0.05f));
            tier4.add(new BasicItemListing(new ItemStack(Items.POWDER_SNOW_BUCKET), new ItemStack(Items.EMERALD), 12, 30, 0.05f));
            tier5.add(new BasicItemListing(new ItemStack(ModItems.EMERALD_COIN.get(), 2), new ItemStack(FunctionalBlocks.SKY_MILL.get()), 12, 30, 0.05f));
        } else if (type == VillagerProfession.FARMER) {
            tier1.add(new SkyVillagerItemListing(NatureBlocks.FLOATING_WHEAT.get(), IntegerRange.of(4, 8), Items.EMERALD, 3, 25, 0.05F));
            tier1.add(new SkyVillagerItemListing(MaterialItems.WEAVING_CLOUD_COTTON.get(), IntegerRange.of(4, 8), Items.EMERALD, 3, 25, 0.05F));
            tier1.add(new SkyVillagerItemListing(Items.EMERALD, 3, FoodItems.CLOUD_BREAD.get(), 3, 25, 0.05F));
            tier2.add(new SkyVillagerItemListing(Items.EMERALD, 2, FoodItems.APRICOT.get(), 7, 25, 0.05F));
            tier2.add(new SkyVillagerItemListing(Items.EMERALD, 2, FoodItems.PLUM.get(), 7, 25, 0.05F));
            tier2.add(new SkyVillagerItemListing(Items.EMERALD, 6, FoodItems.HONEY_MOONCAKES.get(), 7, 25, 0.05F));
            tier3.add(new SkyVillagerItemListing(MaterialItems.FALLING_STAR.get(), IntegerRange.of(20, 22), Items.EMERALD, 2, 7, 25, 0.05F));
            tier5.add(new SkyVillagerItemListing(Items.EMERALD, FoodItems.CLOUDWEAVER_SEED.get(), 2, 7, 25, 0.05F));
            tier5.add(new SkyVillagerItemListing(Items.EMERALD, FoodItems.STELLAR_BLOSSOM_SEED.get(), 2, 7, 25, 0.05F));
            tier5.add(new SkyVillagerItemListing(Items.EMERALD, FoodItems.FLOATING_WHEAT_SEED.get(), 2, 7, 25, 0.05F));
        } else if (type == VillagerProfession.ARMORER) {
            // 故意替换原版的一部分(铅和铂金部分）
            tier1.add(new RandomItemListing(Items.EMERALD, IntegerRange.of(6, 10), ArmorItems.LEAD_HELMET.get(), 5, 25, 0.05F));
            tier1.add(new RandomItemListing(Items.EMERALD, IntegerRange.of(10, 14), ArmorItems.LEAD_CHESTPLATE.get(), 5, 25, 0.05F));
            tier1.add(new RandomItemListing(Items.EMERALD, IntegerRange.of(8, 12), ArmorItems.LEAD_LEGGINGS.get(), 5, 25, 0.05F));
            tier1.add(new RandomItemListing(Items.EMERALD, IntegerRange.of(6, 10), ArmorItems.LEAD_BOOTS.get(), 5, 25, 0.05F));
            tier2.add(new BasicItemListing(new ItemStack(MaterialItems.LEAD_INGOT.get(), 5), new ItemStack(Items.EMERALD), 10, 25, 0.05F));
            tier2.add(new BasicItemListing(new ItemStack(Items.EMERALD), new ItemStack(Items.COPPER_INGOT, 8), 10, 25, 0.05F));
            tier3.add(new SkyVillagerItemListing(MaterialItems.RUBY.get(), IntegerRange.of(1, 2), Items.EMERALD, 2, 10, 25, 0.05F));
            tier3.add(new SkyVillagerItemListing(MaterialItems.AMBER.get(), IntegerRange.of(1, 2), Items.EMERALD, 2, 10, 25, 0.05F));
            tier3.add(new SkyVillagerItemListing(MaterialItems.TOPAZ.get(), IntegerRange.of(1, 2), Items.EMERALD, 2, 10, 25, 0.05F));
            tier3.add(new SkyVillagerItemListing(MaterialItems.TR_EMERALD.get(), IntegerRange.of(1, 2), Items.EMERALD, 2, 10, 25, 0.05F));
            tier3.add(new SkyVillagerItemListing(MaterialItems.TR_AMETHYST.get(), IntegerRange.of(1, 2), Items.EMERALD, 2, 10, 25, 0.05F));
            tier3.add(new SkyVillagerItemListing(MaterialItems.SAPPHIRE.get(), IntegerRange.of(1, 2), Items.EMERALD, 2, 10, 25, 0.05F));
            tier4.add(new RandomItemListing(Items.EMERALD, IntegerRange.of(7, 9), MaterialItems.PLATINUM_INGOT.get(), 10, 25, 0.05F));
            tier5.add(new RandomItemListing(Items.EMERALD, IntegerRange.of(19, 20), ArmorItems.PLATINUM_HELMET.get(), 10, 25, 0.05F));
            tier5.add(new RandomItemListing(Items.EMERALD, IntegerRange.of(22, 23), ArmorItems.PLATINUM_CHESTPLATE.get(), 10, 25, 0.05F));
            tier5.add(new RandomItemListing(Items.EMERALD, IntegerRange.of(20, 21), ArmorItems.PLATINUM_LEGGINGS.get(), 10, 25, 0.05F));
            tier5.add(new RandomItemListing(Items.EMERALD, IntegerRange.of(18, 19), ArmorItems.PLATINUM_BOOTS.get(), 10, 25, 0.05F));
        } else if (type == VillagerProfession.BUTCHER) {
            tier1.add(new SkyVillagerItemListing(Items.BEEF, IntegerRange.of(6, 7), Items.EMERALD, 5, 25, 0.05F));
            tier1.add(new SkyVillagerItemListing(Items.MUTTON, IntegerRange.of(6, 7), Items.EMERALD, 5, 25, 0.05F));
            tier1.add(new SkyVillagerItemListing(Items.PORKCHOP, IntegerRange.of(6, 7), Items.EMERALD, 5, 25, 0.05F));
            tier2.add(new SkyVillagerItemListing(Items.EMERALD, 5, FoodItems.FISH_AND_MUSHROOM_SOUP.get(), 10, 25, 0.05F));
            tier3.add(new SkyVillagerItemListing(Items.RABBIT, 2, Items.EMERALD, 10, 25, 0.05F));
            tier3.add(new SkyVillagerItemListing(Items.CHICKEN, 10, Items.EMERALD, 2, 10, 25, 0.05F));
        } else if (type == VillagerProfession.CARTOGRAPHER) {
            //TODO 邪恶群系指南针，微光定位地图
        } else if (type == VillagerProfession.CLERIC) {
            // 这个有待思考，暂时没东西
        } else if (type == VillagerProfession.FISHERMAN) {
            tier1.add(new SkyVillagerItemListing(FoodItems.DAMSEL_FISH.get(), IntegerRange.of(8, 10), Items.EMERALD, 5, 25, 0.05F));
            tier1.add(new SkyVillagerItemListing(Items.PUFFERFISH, IntegerRange.of(8, 10), Items.EMERALD, 5, 25, 0.05F));
            tier3.add(new SkyVillagerItemListing(FoodItems.GOLDEN_CARP.get(), ModItems.EMERALD_COIN.get(), 20, 25, 0.05F));
            tier5.add(new SkyVillagerItemListing(ModItems.EMERALD_COIN.get(), 8, FishingPoleItems.FIBERGLASS_FISHING_POLE.get(), 10, 25, 0.05F));
        } else if (type == VillagerProfession.FLETCHER) {
            tier2.add(new SkyVillagerItemListing(Items.EMERALD, 2, ArrowItems.FLAMING_ARROW.get(), 15, 10, 25, 0.05F));
            tier3.add(new SkyVillagerItemListing(Items.EMERALD, 2, BowItems.WOODEN_SHORT_BOW.get(), 10, 25, 0.05F));
            tier4.add(new SkyVillagerItemListing(Items.EMERALD, 12, BowItems.TUNGSTEN_SHORT_BOW.get(), 10, 25, 0.05F));
            tier5.add(new SkyVillagerItemListing(Items.EMERALD, 3, ArrowItems.JESTERS_ARROW.get(), 25, 10, 25, 0.05F));
        } else if (type == VillagerProfession.LEATHERWORKER) {
            tier3.add(new SkyVillagerItemListing(Items.EMERALD, 4, ArmorItems.SNOW_CAPS.get(), 10, 25, 0.05F));
            tier3.add(new SkyVillagerItemListing(Items.EMERALD, 4, ArmorItems.PINK_SNOW_CAPS.get(), 10, 25, 0.05F));
            tier3.add(new SkyVillagerItemListing(Items.EMERALD, 4, ArmorItems.SNOW_SUITS.get(), 10, 25, 0.05F));
            tier3.add(new SkyVillagerItemListing(Items.EMERALD, 4, ArmorItems.PINK_SNOW_SUITS.get(), 10, 25, 0.05F));
            tier4.add(new SkyVillagerItemListing(Items.EMERALD, 5, ArmorItems.INSULATED_PANTS.get(), 10, 25, 0.05F));
            tier4.add(new SkyVillagerItemListing(Items.EMERALD, 5, ArmorItems.PINK_INSULATED_PANTS.get(), 10, 25, 0.05F));
            tier4.add(new SkyVillagerItemListing(Items.EMERALD, 5, ArmorItems.INSULATED_SHOES.get(), 10, 25, 0.05F));
            tier4.add(new SkyVillagerItemListing(Items.EMERALD, 5, ArmorItems.PINK_INSULATED_SHOES.get(), 10, 25, 0.05F));
            tier5.add(new SkyVillagerItemListing(ModItems.EMERALD_COIN.get(), 4, TCItems.HAND_WARMER.get(), 10, 25, 0.05F));
        } else if (type == VillagerProfession.LIBRARIAN) {
            // 这个有待思考，暂时没东西
        } else if (type == VillagerProfession.MASON) {
            tier1.add(new SkyVillagerItemListing(Items.EMERALD, Blocks.MUD_BRICKS, 9, 5, 25, 0.05F));
            tier1.add(new SkyVillagerItemListing(Items.EMERALD, Blocks.BRICKS, 9, 5, 25, 0.05F));
            tier2.add(new SkyVillagerItemListing(Blocks.STONE, 20, Items.EMERALD, 2, 5, 25, 0.05F));
            tier2.add(new SkyVillagerItemListing(Items.DIRT, IntegerRange.of(61, 64), Items.EMERALD, 2, 10, 0.05f));
            tier3.add(new SkyVillagerItemListing(NatureBlocks.DESERT_FOSSIL.get(), IntegerRange.of(7, 8), Items.EMERALD, 5, 25, 0.05F));
            tier3.add(new SkyVillagerItemListing(NatureBlocks.MARINE_GRAVEL.get(), IntegerRange.of(7, 8), Items.EMERALD, 5, 25, 0.05F));
            tier5.add(new SkyVillagerItemListing(Items.EMERALD, IntegerRange.of(10, 12), HammerItems.PLATINUM_HAMMER.get(), 15, 25, 0.05F));
            tier5.add(new SkyVillagerItemListing(ModItems.EMERALD_COIN.get(), 5, FunctionalBlocks.EXTRACTINATOR.get(), 25, 25, 0.05F));
        } else if (type == VillagerProfession.SHEPHERD) {
            tier3.add(new SkyVillagerItemListing(Items.EMERALD, 4, ArmorItems.SNOW_CAPS.get(), 10, 25, 0.05F));
            tier3.add(new SkyVillagerItemListing(Items.EMERALD, 4, ArmorItems.PINK_SNOW_CAPS.get(), 10, 25, 0.05F));
            tier3.add(new SkyVillagerItemListing(Items.EMERALD, 4, ArmorItems.SNOW_SUITS.get(), 10, 25, 0.05F));
            tier3.add(new SkyVillagerItemListing(Items.EMERALD, 4, ArmorItems.PINK_SNOW_SUITS.get(), 10, 25, 0.05F));
            tier4.add(new SkyVillagerItemListing(Items.EMERALD, 5, ArmorItems.INSULATED_PANTS.get(), 10, 25, 0.05F));
            tier4.add(new SkyVillagerItemListing(Items.EMERALD, 5, ArmorItems.PINK_INSULATED_PANTS.get(), 10, 25, 0.05F));
            tier4.add(new SkyVillagerItemListing(Items.EMERALD, 5, ArmorItems.INSULATED_SHOES.get(), 10, 25, 0.05F));
            tier4.add(new SkyVillagerItemListing(Items.EMERALD, 5, ArmorItems.PINK_INSULATED_SHOES.get(), 10, 25, 0.05F));
            tier5.add(new SkyVillagerItemListing(ModItems.EMERALD_COIN.get(), 4, TCItems.HAND_WARMER.get(), 10, 25, 0.05F));
        } else if (type == VillagerProfession.WEAPONSMITH) {
            tier1.add(new BasicItemListing(new ItemStack(Items.EMERALD, 5), new ItemStack(SwordItems.LEAD_SHORT_SWORD.get()), 10, 25, 0.05F));
            tier1.add(new BasicItemListing(new ItemStack(Items.EMERALD, 7), new ItemStack(SwordItems.LEAD_BOARD_SWORD.get()), 10, 25, 0.05F));
            tier2.add(new BasicItemListing(new ItemStack(MaterialItems.LEAD_INGOT.get(), 5), new ItemStack(Items.EMERALD), 10, 25, 0.05F));
            tier4.add(new RandomItemListing(Items.EMERALD, IntegerRange.of(8, 9), SwordItems.PLATINUM_SHORT_SWORD.get(), 10, 25, 0.05F));
            tier4.add(new RandomItemListing(Items.EMERALD, IntegerRange.of(9, 11), SwordItems.PLATINUM_BOARD_SWORD.get(), 10, 25, 0.05F));
            tier5.add(new RandomItemListing(Items.EMERALD, IntegerRange.of(9, 11), BowItems.PLATINUM_SHORT_BOW.get(), 10, 25, 0.05F));
            tier5.add(new RandomItemListing(Items.EMERALD, IntegerRange.of(11, 12), BowItems.PLATINUM_BOW.get(), 10, 25, 0.05F));
        } else if (type == VillagerProfession.TOOLSMITH) {
            tier2.add(new BasicItemListing(new ItemStack(MaterialItems.LEAD_INGOT.get(), 5), new ItemStack(Items.EMERALD), 10, 25, 0.05F));
            tier4.add(new RandomItemListing(Items.EMERALD, IntegerRange.of(9, 11), AxeItems.PLATINUM_AXE.get(), 10, 25, 0.05F));
            tier4.add(new RandomItemListing(Items.EMERALD, IntegerRange.of(9, 11), PickaxeItems.PLATINUM_PICKAXE.get(), 10, 25, 0.05F));
            tier4.add(new RandomItemListing(Items.EMERALD, IntegerRange.of(7, 7), HammerItems.PLATINUM_HAMMER.get(), 10, 25, 0.05F));
        } else if (type == BANKER.get()) {
            tier1.add(new BasicItemListing(new ItemStack(Items.EMERALD), new ItemStack(Blocks.CHEST), 3, 25, 0.05F));
            tier1.add(new BasicItemListing(new ItemStack(ModItems.SILVER_COIN.get(), 2), new ItemStack(Items.EMERALD), 3, 15, 0.05F));
            tier2.add(new BasicItemListing(new ItemStack(ModItems.GOLDEN_COIN.get(), 3), new ItemStack(ModItems.EMERALD_COIN.get()), 3, 15, 0.05F));
            tier2.add(new BasicItemListing(new ItemStack(Items.EMERALD, 20), new ItemStack(ModItems.EMERALD_COIN.get()), 3, 25, 0.05F));
            tier4.add(new BasicItemListing(new ItemStack(ModItems.EMERALD_COIN.get()), new ItemStack(Items.EMERALD, 20), 3, 25, 0.05F));
            tier4.add(new BasicItemListing(new ItemStack(ModItems.EMERALD_COIN.get()), new ItemStack(ModItems.GOLDEN_COIN.get(), 3), 3, 25, 0.05F));
        }
    }

    public static void setVillagerType(Villager villager) {
        if (villager.position().y >= 240.0) {
            villager.setVariant(SKY_TYPE.get());
        }
    }

    public static void register(IEventBus eventBus) {
        POIS.register(eventBus);
        PROFESSIONS.register(eventBus);
        TYPES.register(eventBus);
        NeoForge.EVENT_BUS.addListener(ModVillagers::villagerTrades);
    }
}
