package org.confluence.mod.common.init.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.confluence.mod.Confluence;
import org.confluence.mod.common.init.ModJukeboxSongs;
import org.confluence.mod.common.init.ModSoundEvents;
import org.confluence.mod.common.init.armor.ArmorItems;
import org.confluence.mod.common.init.armor.ArmorMaterials;
import org.confluence.mod.common.init.block.ModBlocks;
import org.confluence.mod.common.item.CustomRarityItem;
import org.confluence.mod.common.item.common.EverBeneficialItem;
import org.confluence.mod.common.item.mana.ArcaneCrystalItem;
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
    public static final Supplier<ArcaneCrystalItem> ARCANE_CRYSTAL = ITEMS.register("arcane_crystal", ArcaneCrystalItem::new);
    public static final Supplier<EverBeneficialItem> AEGIS_APPLE = ITEMS.register("aegis_apple", () -> new EverBeneficialItem(ModRarity.LIGHT_PURPLE, EverBeneficialItem.AEGIS_APPLE));
    public static final Supplier<EverBeneficialItem> AMBROSIA = ITEMS.register("ambrosia", () -> new EverBeneficialItem(ModRarity.LIGHT_PURPLE, EverBeneficialItem.AMBROSIA));
    public static final Supplier<EverBeneficialItem> GUMMY_WORM = ITEMS.register("gummy_worm", () -> new EverBeneficialItem(ModRarity.LIGHT_PURPLE, EverBeneficialItem.GUMMY_WORM));
    public static final Supplier<EverBeneficialItem> GALAXY_PEARL = ITEMS.register("galaxy_pearl", () -> new EverBeneficialItem(ModRarity.LIGHT_PURPLE, EverBeneficialItem.GALAXY_PEARL));
    public static final Supplier<EverBeneficialItem> MINECART_UPGRADE_KIT = ITEMS.register("minecart_upgrade_kit", () -> new EverBeneficialItem(ModRarity.EXPERT, EverBeneficialItem.MINECART_UPGRADE_KIT));

    public static final Supplier<Item> COPPER_COIN = ITEMS.register("copper_coin", () -> new BlockItem(ModBlocks.COPPER_COIN_PILE.get(), new Item.Properties().rarity(Rarity.UNCOMMON).fireResistant()));
    public static final Supplier<Item> SILVER_COIN = ITEMS.register("silver_coin", () -> new BlockItem(ModBlocks.SILVER_COIN_PILE.get(), new Item.Properties().rarity(Rarity.UNCOMMON).fireResistant()));
    public static final Supplier<Item> GOLDEN_COIN = ITEMS.register("golden_coin", () -> new BlockItem(ModBlocks.GOLDEN_COIN_PILE.get(), new Item.Properties().rarity(Rarity.RARE).fireResistant()));
    public static final Supplier<Item> PLATINUM_COIN = ITEMS.register("platinum_coin", () -> new BlockItem(ModBlocks.PLATINUM_COIN_PILE.get(), new Item.Properties().rarity(Rarity.EPIC).fireResistant()));

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
        FoodItems.ITEMS.register(eventBus);
        AxeItems.AXES.register(eventBus);
        ArmorMaterials.ARMOR_MATERIALS.register(eventBus);
        ArmorItems.ARMORS.register(eventBus);
        AccessoryItems.ACCESSORIES.register(eventBus);
        HammerItems.HAMMERS.register(eventBus);
        HookItems.HOOKS.register(eventBus);
        BoomerangItems.BOOMERANG_ITEMS.register(eventBus);
        MinecartItems.ITEMS.register(eventBus);
        ToolItems.ITEMS.register(eventBus);
    }
}
