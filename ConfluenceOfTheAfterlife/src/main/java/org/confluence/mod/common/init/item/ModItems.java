package org.confluence.mod.common.init.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.confluence.mod.Confluence;
import org.confluence.mod.common.entity.projectile.bombs.*;
import org.confluence.mod.common.init.ModFluids;
import org.confluence.mod.common.init.ModJukeboxSongs;
import org.confluence.mod.common.init.ModSoundEvents;
import org.confluence.mod.common.init.armor.ArmorItems;
import org.confluence.mod.common.init.armor.ArmorMaterials;
import org.confluence.mod.common.init.block.ModBlocks;
import org.confluence.mod.common.item.CustomRarityItem;
import org.confluence.mod.common.item.common.*;
import org.confluence.mod.common.item.mana.ManaStarItem;
import org.confluence.terra_curio.common.component.ModRarity;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public final class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Confluence.MODID);
    public static final DeferredRegister.Items BLOCK_ITEMS = DeferredRegister.createItems(Confluence.MODID);

    public static final Supplier<Item> ALPHA = ITEMS.register("alpha", () -> new CustomRarityItem(new Item.Properties().stacksTo(1).fireResistant().jukeboxPlayable(ModJukeboxSongs.ALPHA), ModRarity.EXPERT));

    public static final Supplier<Item> STAR = ITEMS.register("star", () -> new CustomRarityItem(ModRarity.MASTER));
    public static final Supplier<Item> SOUL_CAKE = ITEMS.register("soul_cake", () -> new CustomRarityItem(ModRarity.MASTER));
    public static final Supplier<Item> SUGAR_PLUM = ITEMS.register("sugar_plum", () -> new CustomRarityItem(ModRarity.MASTER));
    public static final Supplier<Item> HEART = ITEMS.register("heart", () -> new CustomRarityItem(ModRarity.MASTER));
    public static final Supplier<Item> CANDY_APPLE = ITEMS.register("candy_apple", () -> new CustomRarityItem(ModRarity.MASTER));
    public static final Supplier<Item> CANDY_CANE = ITEMS.register("candy_cane", () -> new CustomRarityItem(ModRarity.MASTER));

    public static final Supplier<ManaStarItem> MANA_STAR = ITEMS.register("mana_star", ManaStarItem::new);
    public static final Supplier<EverBeneficialItem> LIFE_CRYSTAL = ITEMS.register("life_crystal", () -> new EverBeneficialItem(ModRarity.GREEN, EverBeneficialItem.LIFE_CRYSTAL, ModSoundEvents.LIFE_CRYSTAL_USE));
    public static final Supplier<EverBeneficialItem> LIFE_FRUIT = ITEMS.register("life_fruit", () -> new EverBeneficialItem(ModRarity.LIME, EverBeneficialItem.LIFE_FRUITS));
    public static final Supplier<EverBeneficialItem> VITAL_CRYSTAL = ITEMS.register("vital_crystal", () -> new EverBeneficialItem(ModRarity.LIGHT_PURPLE, EverBeneficialItem.VITAL_CRYSTAL));
    public static final Supplier<EverBeneficialItem> AEGIS_APPLE = ITEMS.register("aegis_apple", () -> new EverBeneficialItem(ModRarity.LIGHT_PURPLE, EverBeneficialItem.AEGIS_APPLE));
    public static final Supplier<EverBeneficialItem> AMBROSIA = ITEMS.register("ambrosia", () -> new EverBeneficialItem(ModRarity.LIGHT_PURPLE, EverBeneficialItem.AMBROSIA));
    public static final Supplier<EverBeneficialItem> GUMMY_WORM = ITEMS.register("gummy_worm", () -> new EverBeneficialItem(ModRarity.LIGHT_PURPLE, EverBeneficialItem.GUMMY_WORM));
    public static final Supplier<EverBeneficialItem> GALAXY_PEARL = ITEMS.register("galaxy_pearl", () -> new EverBeneficialItem(ModRarity.LIGHT_PURPLE, EverBeneficialItem.GALAXY_PEARL));
    public static final Supplier<EverBeneficialItem> MINECART_UPGRADE_KIT = ITEMS.register("minecart_upgrade_kit", () -> new EverBeneficialItem(ModRarity.EXPERT, EverBeneficialItem.MINECART_UPGRADE_KIT));

    public static final Supplier<BombItem> BOMB = ITEMS.register("bomb", () -> new BombItem(BaseBombEntity::new));
    public static final Supplier<BombItem> BOUNCY_BOMB = ITEMS.register("bouncy_bomb", () -> new BombItem(BouncyBombEntity::new));
    public static final Supplier<BombItem> STICKY_BOMB = ITEMS.register("sticky_bomb", () -> new BombItem(StickyBombEntity::new));
    public static final Supplier<BombItem> BOMB_FISH = ITEMS.register("bomb_fish", () -> new BombItem(BombFishEntity::new));
    public static final Supplier<BombItem> SCARAB_BOMB = ITEMS.register("scarab_bomb", () -> new BombItem(ScarabBombEntity::new));

    public static final Supplier<Item> COPPER_COIN = ITEMS.register("copper_coin", () -> new BlockItem(ModBlocks.COPPER_COIN_PILE.get(), new Item.Properties().rarity(Rarity.UNCOMMON).fireResistant()));
    public static final Supplier<Item> SILVER_COIN = ITEMS.register("silver_coin", () -> new BlockItem(ModBlocks.SILVER_COIN_PILE.get(), new Item.Properties().rarity(Rarity.UNCOMMON).fireResistant()));
    public static final Supplier<Item> GOLDEN_COIN = ITEMS.register("golden_coin", () -> new BlockItem(ModBlocks.GOLDEN_COIN_PILE.get(), new Item.Properties().rarity(Rarity.RARE).fireResistant()));
    public static final Supplier<Item> PLATINUM_COIN = ITEMS.register("platinum_coin", () -> new BlockItem(ModBlocks.PLATINUM_COIN_PILE.get(), new Item.Properties().rarity(Rarity.EPIC).fireResistant()));

    public static final Supplier<Item> STELLAR_BLOSSOM_SEED = ITEMS.register("stellar_blossom_seed", () -> new ItemNameBlockItem(ModBlocks.STELLAR_BLOSSOM.get(), new Item.Properties()));
    public static final Supplier<Item> CLOUDWEAVER_SEED = ITEMS.register("cloudweaver_seed", () -> new ItemNameBlockItem(ModBlocks.CLOUDWEAVER.get(), new Item.Properties()));
    public static final Supplier<Item> FLOATING_WHEAT_SEED = ITEMS.register("floating_wheat_seed", () -> new ItemNameBlockItem(ModBlocks.FLOATING_WHEAT.get(), new Item.Properties()));
    public static final Supplier<Item> WATERLEAF_SEED = ITEMS.register("waterleaf_seed", () -> new HerbSeedItem(ModBlocks.WATERLEAF.get()));
    public static final Supplier<Item> FLAMEFLOWERS_SEED = ITEMS.register("flameflowers_seed", () -> new HerbSeedItem(ModBlocks.FLAMEFLOWERS.get(), new Item.Properties().fireResistant()));
    public static final Supplier<Item> MOONSHINE_GRASS_SEED = ITEMS.register("moonshine_grass_seed", () -> new HerbSeedItem(ModBlocks.MOONSHINE_GRASS.get()));
    public static final Supplier<Item> SHINE_ROOT_SEED = ITEMS.register("shine_root_seed", () -> new HerbSeedItem(ModBlocks.SHINE_ROOT.get()));
    public static final Supplier<Item> SHIVERINGTHORNS_SEED = ITEMS.register("shiveringthorns_seed", () -> new HerbSeedItem(ModBlocks.SHIVERINGTHORNS.get()));
    public static final Supplier<Item> SUNFLOWERS_SEED = ITEMS.register("sunflowers_seed", () -> new HerbSeedItem(ModBlocks.SUNFLOWERS.get()));
    public static final Supplier<Item> DEATHWEED_SEED = ITEMS.register("deathweed_seed", () -> new HerbSeedItem(ModBlocks.DEATHWEED.get()));

    public static final Supplier<HoneyBucketItem> HONEY_BUCKET = ITEMS.register("honey_bucket", HoneyBucketItem::new);
    public static final Supplier<BottomlessBucketItem> BOTTOMLESS_WATER_BUCKET = ITEMS.register("bottomless_water_bucket", () -> new BottomlessBucketItem(Fluids.WATER, ModRarity.LIME));
    public static final Supplier<BottomlessBucketItem> BOTTOMLESS_LAVA_BUCKET = ITEMS.register("bottomless_lava_bucket", () -> new BottomlessBucketItem(Fluids.LAVA, ModRarity.LIME));
    public static final Supplier<BottomlessBucketItem> BOTTOMLESS_HONEY_BUCKET = ITEMS.register("bottomless_honey_bucket", () -> new BottomlessBucketItem(ModFluids.HONEY.fluid().get(), ModRarity.LIME));
    public static final Supplier<BottomlessBucketItem> BOTTOMLESS_SHIMMER_BUCKET = ITEMS.register("bottomless_shimmer_bucket", () -> new BottomlessBucketItem(ModFluids.SHIMMER.fluid().get(), ModRarity.RED));

    public static final Supplier<Item> GOLDEN_KEY = ITEMS.register("golden_key", () -> new CustomRarityItem(ModRarity.WHITE));
    public static final Supplier<Item> SHADOW_KEY = ITEMS.register("shadow_key", () -> new CustomRarityItem(ModRarity.WHITE));

    public static final Supplier<WrenchItem> RED_WRENCH = ITEMS.register("red_wrench", () -> new WrenchItem(0xFF0000));
    public static final Supplier<WrenchItem> GREEN_WRENCH = ITEMS.register("green_wrench", () -> new WrenchItem(0x00FF00));
    public static final Supplier<WrenchItem> BLUE_WRENCH = ITEMS.register("blue_wrench", () -> new WrenchItem(0x0000FF));
    public static final Supplier<WrenchItem> YELLOW_WRENCH = ITEMS.register("yellow_wrench", () -> new WrenchItem(0xFFFF00));
    public static final Supplier<WireCutterItem> WIRE_CUTTER = ITEMS.register("wire_cutter", WireCutterItem::new);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        BLOCK_ITEMS.register(eventBus);
        ArrowItems.ARROWS.register(eventBus);
        BaitItems.BAITS.register(eventBus);
        BowItems.BOWS.register(eventBus);
        FishingPoleItems.POLES.register(eventBus);
        IconItems.ICONS.register(eventBus);
        MaterialItems.MATERIALS.register(eventBus);
        SwordItems.SWORDS.register(eventBus);
        PotionItems.POTIONS.register(eventBus);
        QuestedFishes.FISHES.register(eventBus);
        FoodItems.FOODS.register(eventBus);
        AxeItems.AXES.register(eventBus);
        ArmorMaterials.ARMOR_MATERIALS.register(eventBus);
        ArmorItems.ARMORS.register(eventBus);
        AccessoryItems.ACCESSORIES.register(eventBus);
        HammerItems.HAMMERS.register(eventBus);
        HookItems.HOOKS.register(eventBus);
        BoomerangItems.BOOMERANG_ITEMS.register(eventBus);
        MinecartItems.ITEMS.register(eventBus);
    }
}
