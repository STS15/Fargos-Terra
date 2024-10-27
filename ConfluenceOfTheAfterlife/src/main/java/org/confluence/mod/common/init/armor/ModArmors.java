package org.confluence.mod.common.init.armor;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.confluence.mod.Confluence;

import java.util.function.Supplier;

public class ModArmors {
    public static final DeferredRegister<Item> ARMOR = DeferredRegister.createItems(Confluence.MODID);

    public static final Supplier<ArmorItem> CACTUS_HELMET = ARMOR.register("cactus_helmet", () -> new ArmorItem(ArmorMaterials.CACTUS_ARMOR_MATERIALS, ArmorItem.Type.HELMET, new Item.Properties().durability(120)));
    public static final Supplier<ArmorItem> CACTUS_CHESTPLATE = ARMOR.register("cactus_chestplate", () -> new ArmorItem(ArmorMaterials.CACTUS_ARMOR_MATERIALS, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(170)));
    public static final Supplier<ArmorItem> CACTUS_LEGGINGS = ARMOR.register("cactus_leggings", () -> new ArmorItem(ArmorMaterials.CACTUS_ARMOR_MATERIALS, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(150)));
    public static final Supplier<ArmorItem> CACTUS_BOOTS = ARMOR.register("cactus_boots", () -> new ArmorItem(ArmorMaterials.CACTUS_ARMOR_MATERIALS, ArmorItem.Type.BOOTS, new Item.Properties().durability(130)));

    public static final Supplier<Item> COPPER_HELMET = ARMOR.register("copper_helmet", () -> new ArmorItem(ArmorMaterials.COPPER_ARMOR_MATERIALS, ArmorItem.Type.HELMET, new Item.Properties().durability(120)));
    public static final Supplier<Item> COPPER_CHESTPLATE = ARMOR.register("copper_chestplate", () -> new ArmorItem(ArmorMaterials.COPPER_ARMOR_MATERIALS, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(170)));
    public static final Supplier<Item> COPPER_LEGGINGS = ARMOR.register("copper_leggings", () -> new ArmorItem(ArmorMaterials.COPPER_ARMOR_MATERIALS, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(150)));
    public static final Supplier<Item> COPPER_BOOTS = ARMOR.register("copper_boots", () -> new ArmorItem(ArmorMaterials.COPPER_ARMOR_MATERIALS, ArmorItem.Type.BOOTS, new Item.Properties().durability(130)));

    public static final Supplier<Item> FOSSIL_HELMET = ARMOR.register("fossil_helmet", () -> new ArmorItem(ArmorMaterials.FOSSIL_ARMOR_MATERIALS, ArmorItem.Type.HELMET, new Item.Properties().durability(200)));
    public static final Supplier<Item> FOSSIL_CHESTPLATE = ARMOR.register("fossil_chestplate", () -> new ArmorItem(ArmorMaterials.FOSSIL_ARMOR_MATERIALS, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(270)));
    public static final Supplier<Item> FOSSIL_LEGGINGS = ARMOR.register("fossil_leggings", () -> new ArmorItem(ArmorMaterials.FOSSIL_ARMOR_MATERIALS, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(250)));
    public static final Supplier<Item> FOSSIL_BOOTS = ARMOR.register("fossil_boots", () -> new ArmorItem(ArmorMaterials.FOSSIL_ARMOR_MATERIALS, ArmorItem.Type.BOOTS, new Item.Properties().durability(200)));

    public static final Supplier<Item> GOLDEN_HELMET = ARMOR.register("golden_helmet", () -> new ArmorItem(ArmorMaterials.GOLDEN_ARMOR_MATERIALS, ArmorItem.Type.HELMET, new Item.Properties().durability(250)));
    public static final Supplier<Item> GOLDEN_CHESTPLATE = ARMOR.register("golden_chestplate", () -> new ArmorItem(ArmorMaterials.GOLDEN_ARMOR_MATERIALS, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(340)));
    public static final Supplier<Item> GOLDEN_LEGGINGS = ARMOR.register("golden_leggings", () -> new ArmorItem(ArmorMaterials.GOLDEN_ARMOR_MATERIALS, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(320)));
    public static final Supplier<Item> GOLDEN_BOOTS = ARMOR.register("golden_boots", () -> new ArmorItem(ArmorMaterials.GOLDEN_ARMOR_MATERIALS, ArmorItem.Type.BOOTS, new Item.Properties().durability(260)));

    public static final Supplier<Item> LEAD_HELMET = ARMOR.register("lead_helmet", () -> new ArmorItem(ArmorMaterials.LEAD_ARMOR_MATERIALS, ArmorItem.Type.HELMET, new Item.Properties().durability(170)));
    public static final Supplier<Item> LEAD_CHESTPLATE = ARMOR.register("lead_chestplate", () -> new ArmorItem(ArmorMaterials.LEAD_ARMOR_MATERIALS, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(250)));
    public static final Supplier<Item> LEAD_LEGGINGS = ARMOR.register("lead_leggings", () -> new ArmorItem(ArmorMaterials.LEAD_ARMOR_MATERIALS, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(230)));
    public static final Supplier<Item> LEAD_BOOTS = ARMOR.register("lead_boots", () -> new ArmorItem(ArmorMaterials.LEAD_ARMOR_MATERIALS, ArmorItem.Type.BOOTS, new Item.Properties().durability(160)));

    public static final Supplier<Item> NINJA_HELMET = ARMOR.register("ninja_helmet", () -> new ArmorItem(ArmorMaterials.NINJA_ARMOR_MATERIALS, ArmorItem.Type.HELMET, new Item.Properties().durability(170)));
    public static final Supplier<Item> NINJA_CHESTPLATE = ARMOR.register("ninja_chestplate", () -> new ArmorItem(ArmorMaterials.NINJA_ARMOR_MATERIALS, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(250)));
    public static final Supplier<Item> NINJA_LEGGINGS = ARMOR.register("ninja_leggings", () -> new ArmorItem(ArmorMaterials.NINJA_ARMOR_MATERIALS, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(230)));
    public static final Supplier<Item> NINJA_BOOTS = ARMOR.register("ninja_boots", () -> new ArmorItem(ArmorMaterials.NINJA_ARMOR_MATERIALS, ArmorItem.Type.BOOTS, new Item.Properties().durability(160)));

    public static final Supplier<Item> PLANK_HELMET = ARMOR.register("plank_helmet", () -> new ArmorItem(ArmorMaterials.PLANK_ARMOR_MATERIALS, ArmorItem.Type.HELMET, new Item.Properties().durability(55)));
    public static final Supplier<Item> PLANK_CHESTPLATE = ARMOR.register("plank_chestplate", () -> new ArmorItem(ArmorMaterials.PLANK_ARMOR_MATERIALS, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(80)));
    public static final Supplier<Item> PLANK_LEGGINGS = ARMOR.register("plank_leggings", () -> new ArmorItem(ArmorMaterials.PLANK_ARMOR_MATERIALS, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(75)));
    public static final Supplier<Item> PLANK_BOOTS = ARMOR.register("plank_boots", () -> new ArmorItem(ArmorMaterials.PLANK_ARMOR_MATERIALS, ArmorItem.Type.BOOTS, new Item.Properties().durability(65)));

    public static final Supplier<Item> PLATINUM_HELMET = ARMOR.register("platinum_helmet", () -> new ArmorItem(ArmorMaterials.PLATINUM_ARMOR_MATERIALS, ArmorItem.Type.HELMET, new Item.Properties().durability(250)));
    public static final Supplier<Item> PLATINUM_CHESTPLATE = ARMOR.register("platinum_chestplate", () -> new ArmorItem(ArmorMaterials.PLATINUM_ARMOR_MATERIALS, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(340)));
    public static final Supplier<Item> PLATINUM_LEGGINGS = ARMOR.register("platinum_leggings", () -> new ArmorItem(ArmorMaterials.PLATINUM_ARMOR_MATERIALS, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(320)));
    public static final Supplier<Item> PLATINUM_BOOTS = ARMOR.register("platinum_boots", () -> new ArmorItem(ArmorMaterials.PLATINUM_ARMOR_MATERIALS, ArmorItem.Type.BOOTS, new Item.Properties().durability(260)));

    public static final Supplier<Item> SILVER_HELMET = ARMOR.register("silver_helmet", () -> new ArmorItem(ArmorMaterials.SILVER_ARMOR_MATERIALS, ArmorItem.Type.HELMET, new Item.Properties().durability(190)));
    public static final Supplier<Item> SILVER_CHESTPLATE = ARMOR.register("silver_chestplate", () -> new ArmorItem(ArmorMaterials.SILVER_ARMOR_MATERIALS, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(270)));
    public static final Supplier<Item> SILVER_LEGGINGS = ARMOR.register("silver_leggings", () -> new ArmorItem(ArmorMaterials.SILVER_ARMOR_MATERIALS, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(250)));
    public static final Supplier<Item> SILVER_BOOTS = ARMOR.register("silver_boots", () -> new ArmorItem(ArmorMaterials.SILVER_ARMOR_MATERIALS, ArmorItem.Type.BOOTS, new Item.Properties().durability(180)));

    public static final Supplier<Item> SNOW_CAPS = ARMOR.register("snow_caps", () -> new ArmorItem(ArmorMaterials.SNOW_ARMOR_MATERIALS, ArmorItem.Type.HELMET, new Item.Properties().durability(120)));
    public static final Supplier<Item> SNOW_SUITS = ARMOR.register("snow_suits", () -> new ArmorItem(ArmorMaterials.SNOW_ARMOR_MATERIALS, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(170)));
    public static final Supplier<Item> INSULATED_PANTS = ARMOR.register("insulated_pants", () -> new ArmorItem(ArmorMaterials.SNOW_ARMOR_MATERIALS, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(150)));
    public static final Supplier<Item> INSULATED_SHOES = ARMOR.register("insulated_shoes", () -> new ArmorItem(ArmorMaterials.SNOW_ARMOR_MATERIALS, ArmorItem.Type.BOOTS, new Item.Properties().durability(140)));
    public static final Supplier<Item> PINK_SNOW_CAPS = ARMOR.register("pink_snow_caps", () -> new ArmorItem(ArmorMaterials.PINK_SNOW_ARMOR_MATERIALS, ArmorItem.Type.HELMET, new Item.Properties().durability(120)));
    public static final Supplier<Item> PINK_SNOW_SUITS = ARMOR.register("pink_snow_suits", () -> new ArmorItem(ArmorMaterials.PINK_SNOW_ARMOR_MATERIALS, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(170)));
    public static final Supplier<Item> PINK_INSULATED_PANTS = ARMOR.register("pink_insulated_pants", () -> new ArmorItem(ArmorMaterials.PINK_SNOW_ARMOR_MATERIALS, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(150)));
    public static final Supplier<Item> PINK_INSULATED_SHOES = ARMOR.register("pink_insulated_shoes", () -> new ArmorItem(ArmorMaterials.PINK_SNOW_ARMOR_MATERIALS, ArmorItem.Type.BOOTS, new Item.Properties().durability(140)));

    public static final Supplier<Item> TIN_HELMET = ARMOR.register("tin_helmet", () -> new ArmorItem(ArmorMaterials.TIN_ARMOR_MATERIALS, ArmorItem.Type.HELMET, new Item.Properties().durability(150)));
    public static final Supplier<Item> TIN_CHESTPLATE = ARMOR.register("tin_chestplate", () -> new ArmorItem(ArmorMaterials.TIN_ARMOR_MATERIALS, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(190)));
    public static final Supplier<Item> TIN_LEGGINGS = ARMOR.register("tin_leggings", () -> new ArmorItem(ArmorMaterials.TIN_ARMOR_MATERIALS, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(170)));
    public static final Supplier<Item> TIN_BOOTS = ARMOR.register("tin_boots", () -> new ArmorItem(ArmorMaterials.TIN_ARMOR_MATERIALS, ArmorItem.Type.BOOTS, new Item.Properties().durability(150)));

    public static final Supplier<Item> TUNGSTEN_HELMET = ARMOR.register("tungsten_helmet", () -> new ArmorItem(ArmorMaterials.TUNGSTEN_ARMOR_MATERIALS, ArmorItem.Type.HELMET, new Item.Properties().durability(210)));
    public static final Supplier<Item> TUNGSTEN_CHESTPLATE = ARMOR.register("tungsten_chestplate", () -> new ArmorItem(ArmorMaterials.TUNGSTEN_ARMOR_MATERIALS, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(290)));
    public static final Supplier<Item> TUNGSTEN_LEGGINGS = ARMOR.register("tungsten_leggings", () -> new ArmorItem(ArmorMaterials.TUNGSTEN_ARMOR_MATERIALS, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(270)));
    public static final Supplier<Item> TUNGSTEN_BOOTS = ARMOR.register("tungsten_boots", () -> new ArmorItem(ArmorMaterials.TUNGSTEN_ARMOR_MATERIALS, ArmorItem.Type.BOOTS, new Item.Properties().durability(200)));
}
