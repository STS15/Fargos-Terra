package org.confluence.mod.common.init.item;

import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.confluence.mod.Confluence;
import org.confluence.mod.common.item.armor.NormalArmorItem;

import java.util.function.Supplier;

public class ArmorItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Confluence.MODID);

    public static final Supplier<ArmorItem> CACTUS_HELMET = registerNormalArmor("cactus_helmet", "cactus_armor", ArmorMaterials.CACTUS_ARMOR_MATERIALS, ArmorItem.Type.HELMET, 120);
    public static final Supplier<ArmorItem> CACTUS_CHESTPLATE = registerNormalArmor("cactus_chestplate", "cactus_armor", ArmorMaterials.CACTUS_ARMOR_MATERIALS, ArmorItem.Type.CHESTPLATE, 170);
    public static final Supplier<ArmorItem> CACTUS_LEGGINGS = registerNormalArmor("cactus_leggings", "cactus_armor", ArmorMaterials.CACTUS_ARMOR_MATERIALS, ArmorItem.Type.LEGGINGS, 150);
    public static final Supplier<ArmorItem> CACTUS_BOOTS = registerNormalArmor("cactus_boots", "cactus_armor", ArmorMaterials.CACTUS_ARMOR_MATERIALS, ArmorItem.Type.BOOTS, 130);

    public static final Supplier<ArmorItem> PLANK_HELMET = registerNormalArmor("plank_helmet", "plank_armor", ArmorMaterials.PLANK_ARMOR_MATERIALS, ArmorItem.Type.HELMET, 55);
    public static final Supplier<ArmorItem> PLANK_CHESTPLATE = registerNormalArmor("plank_chestplate", "plank_armor", ArmorMaterials.PLANK_ARMOR_MATERIALS, ArmorItem.Type.CHESTPLATE, 80);
    public static final Supplier<ArmorItem> PLANK_LEGGINGS = registerNormalArmor("plank_leggings", "plank_armor", ArmorMaterials.PLANK_ARMOR_MATERIALS, ArmorItem.Type.LEGGINGS, 75);
    public static final Supplier<ArmorItem> PLANK_BOOTS = registerNormalArmor("plank_boots", "plank_armor", ArmorMaterials.PLANK_ARMOR_MATERIALS, ArmorItem.Type.BOOTS, 65);

    public static final Supplier<ArmorItem> SNOW_CAPS = registerNormalArmor("snow_caps", "snow_armor", ArmorMaterials.SNOW_ARMOR_MATERIALS, ArmorItem.Type.HELMET, 120);
    public static final Supplier<ArmorItem> SNOW_SUITS = registerNormalArmor("snow_suits", "snow_armor", ArmorMaterials.SNOW_ARMOR_MATERIALS, ArmorItem.Type.CHESTPLATE, 170);
    public static final Supplier<ArmorItem> INSULATED_PANTS = registerNormalArmor("insulated_pants", "snow_armor", ArmorMaterials.SNOW_ARMOR_MATERIALS, ArmorItem.Type.LEGGINGS, 150);
    public static final Supplier<ArmorItem> INSULATED_SHOES = registerNormalArmor("insulated_shoes", "snow_armor", ArmorMaterials.SNOW_ARMOR_MATERIALS, ArmorItem.Type.BOOTS, 140);

    public static final Supplier<ArmorItem> PINK_SNOW_CAPS = registerNormalArmor("pink_snow_caps", "", ArmorMaterials.PINK_SNOW_ARMOR_MATERIALS, ArmorItem.Type.HELMET, 120);
    public static final Supplier<ArmorItem> PINK_SNOW_SUITS = registerNormalArmor("pink_snow_suits", "", ArmorMaterials.PINK_SNOW_ARMOR_MATERIALS, ArmorItem.Type.CHESTPLATE, 170);
    public static final Supplier<ArmorItem> PINK_INSULATED_PANTS = registerNormalArmor("pink_insulated_pants", "", ArmorMaterials.PINK_SNOW_ARMOR_MATERIALS, ArmorItem.Type.LEGGINGS, 150);
    public static final Supplier<ArmorItem> PINK_INSULATED_SHOES = registerNormalArmor("pink_insulated_shoes", "", ArmorMaterials.PINK_SNOW_ARMOR_MATERIALS, ArmorItem.Type.BOOTS, 140);

    public static final Supplier<ArmorItem> COPPER_HELMET = registerNormalArmor("copper_helmet", "copper_armor", ArmorMaterials.COPPER_ARMOR_MATERIALS, ArmorItem.Type.HELMET, 120);
    public static final Supplier<ArmorItem> COPPER_CHESTPLATE = registerNormalArmor("copper_chestplate", "copper_armor", ArmorMaterials.COPPER_ARMOR_MATERIALS, ArmorItem.Type.CHESTPLATE, 170);
    public static final Supplier<ArmorItem> COPPER_LEGGINGS = registerNormalArmor("copper_leggings", "copper_armor", ArmorMaterials.COPPER_ARMOR_MATERIALS, ArmorItem.Type.LEGGINGS, 150);
    public static final Supplier<ArmorItem> COPPER_BOOTS = registerNormalArmor("copper_boots", "copper_armor", ArmorMaterials.COPPER_ARMOR_MATERIALS, ArmorItem.Type.BOOTS, 130);

    public static final Supplier<ArmorItem> TIN_HELMET = registerNormalArmor("tin_helmet", "tin_armor", ArmorMaterials.TIN_ARMOR_MATERIALS, ArmorItem.Type.HELMET, 150);
    public static final Supplier<ArmorItem> TIN_CHESTPLATE = registerNormalArmor("tin_chestplate", "tin_armor", ArmorMaterials.TIN_ARMOR_MATERIALS, ArmorItem.Type.CHESTPLATE, 190);
    public static final Supplier<ArmorItem> TIN_LEGGINGS = registerNormalArmor("tin_leggings", "tin_armor", ArmorMaterials.TIN_ARMOR_MATERIALS, ArmorItem.Type.LEGGINGS, 170);
    public static final Supplier<ArmorItem> TIN_BOOTS = registerNormalArmor("tin_boots", "tin_armor", ArmorMaterials.TIN_ARMOR_MATERIALS, ArmorItem.Type.BOOTS, 150);

    public static final Supplier<ArmorItem> LEAD_HELMET = registerNormalArmor("lead_helmet", "lead_armor", ArmorMaterials.LEAD_ARMOR_MATERIALS, ArmorItem.Type.HELMET, 170);
    public static final Supplier<ArmorItem> LEAD_CHESTPLATE = registerNormalArmor("lead_chestplate", "lead_armor", ArmorMaterials.LEAD_ARMOR_MATERIALS, ArmorItem.Type.CHESTPLATE, 250);
    public static final Supplier<ArmorItem> LEAD_LEGGINGS = registerNormalArmor("lead_leggings", "lead_armor", ArmorMaterials.LEAD_ARMOR_MATERIALS, ArmorItem.Type.LEGGINGS, 230);
    public static final Supplier<ArmorItem> LEAD_BOOTS = registerNormalArmor("lead_boots", "lead_armor", ArmorMaterials.LEAD_ARMOR_MATERIALS, ArmorItem.Type.BOOTS, 160);

    public static final Supplier<ArmorItem> SILVER_HELMET = registerNormalArmor("silver_helmet", "silver_armor", ArmorMaterials.SILVER_ARMOR_MATERIALS, ArmorItem.Type.HELMET, 190);
    public static final Supplier<ArmorItem> SILVER_CHESTPLATE = registerNormalArmor("silver_chestplate", "silver_", ArmorMaterials.SILVER_ARMOR_MATERIALS, ArmorItem.Type.CHESTPLATE, 270);
    public static final Supplier<ArmorItem> SILVER_LEGGINGS = registerNormalArmor("silver_leggings", "silver_", ArmorMaterials.SILVER_ARMOR_MATERIALS, ArmorItem.Type.LEGGINGS, 250);
    public static final Supplier<ArmorItem> SILVER_BOOTS = registerNormalArmor("silver_boots", "silver_", ArmorMaterials.SILVER_ARMOR_MATERIALS, ArmorItem.Type.BOOTS, 180);

    public static final Supplier<ArmorItem> TUNGSTEN_HELMET = registerNormalArmor("tungsten_helmet", "tungsten_armor", ArmorMaterials.TUNGSTEN_ARMOR_MATERIALS, ArmorItem.Type.HELMET, 210);
    public static final Supplier<ArmorItem> TUNGSTEN_CHESTPLATE = registerNormalArmor("tungsten_chestplate", "tungsten_armor", ArmorMaterials.TUNGSTEN_ARMOR_MATERIALS, ArmorItem.Type.CHESTPLATE, 290);
    public static final Supplier<ArmorItem> TUNGSTEN_LEGGINGS = registerNormalArmor("tungsten_leggings", "tungsten_armor", ArmorMaterials.TUNGSTEN_ARMOR_MATERIALS, ArmorItem.Type.LEGGINGS, 270);
    public static final Supplier<ArmorItem> TUNGSTEN_BOOTS = registerNormalArmor("tungsten_boots", "tungsten_armor", ArmorMaterials.TUNGSTEN_ARMOR_MATERIALS, ArmorItem.Type.BOOTS, 200);

    public static final Supplier<ArmorItem> GOLDEN_HELMET = registerNormalArmor("golden_helmet", "golden_armor", ArmorMaterials.GOLDEN_ARMOR_MATERIALS, ArmorItem.Type.HELMET, 250);
    public static final Supplier<ArmorItem> GOLDEN_CHESTPLATE = registerNormalArmor("golden_chestplate", "golden_armor", ArmorMaterials.GOLDEN_ARMOR_MATERIALS, ArmorItem.Type.CHESTPLATE, 340);
    public static final Supplier<ArmorItem> GOLDEN_LEGGINGS = registerNormalArmor("golden_leggings", "golden_armor", ArmorMaterials.GOLDEN_ARMOR_MATERIALS, ArmorItem.Type.LEGGINGS, 320);
    public static final Supplier<ArmorItem> GOLDEN_BOOTS = registerNormalArmor("golden_boots", "golden_armor", ArmorMaterials.GOLDEN_ARMOR_MATERIALS, ArmorItem.Type.BOOTS, 260);

    public static final Supplier<ArmorItem> PLATINUM_HELMET = registerNormalArmor("platinum_helmet", "platinum_armor", ArmorMaterials.PLATINUM_ARMOR_MATERIALS, ArmorItem.Type.HELMET, 250);
    public static final Supplier<ArmorItem> PLATINUM_CHESTPLATE = registerNormalArmor("platinum_chestplate", "platinum_armor", ArmorMaterials.PLATINUM_ARMOR_MATERIALS, ArmorItem.Type.CHESTPLATE, 340);
    public static final Supplier<ArmorItem> PLATINUM_LEGGINGS = registerNormalArmor("platinum_leggings", "platinum_armor", ArmorMaterials.PLATINUM_ARMOR_MATERIALS, ArmorItem.Type.LEGGINGS, 320);
    public static final Supplier<ArmorItem> PLATINUM_BOOTS = registerNormalArmor("platinum_boots", "platinum_armor", ArmorMaterials.PLATINUM_ARMOR_MATERIALS, ArmorItem.Type.BOOTS, 260);

    public static final Supplier<ArmorItem> NINJA_HELMET = registerNormalArmor("ninja_helmet", "ninja_armor", ArmorMaterials.NINJA_ARMOR_MATERIALS, ArmorItem.Type.HELMET, 170);
    public static final Supplier<ArmorItem> NINJA_CHESTPLATE = registerNormalArmor("ninja_chestplate", "ninja_armor", ArmorMaterials.NINJA_ARMOR_MATERIALS, ArmorItem.Type.CHESTPLATE, 2500);
    public static final Supplier<ArmorItem> NINJA_LEGGINGS = registerNormalArmor("ninja_leggings", "ninja_armor", ArmorMaterials.NINJA_ARMOR_MATERIALS, ArmorItem.Type.LEGGINGS, 2300);
    public static final Supplier<ArmorItem> NINJA_BOOTS = registerNormalArmor("ninja_boots", "ninja_armor", ArmorMaterials.NINJA_ARMOR_MATERIALS, ArmorItem.Type.BOOTS, 160);

    public static final Supplier<ArmorItem> FOSSIL_HELMET = registerNormalArmor("fossil_helmet", "fossil_armor", ArmorMaterials.FOSSIL_ARMOR_MATERIALS, ArmorItem.Type.HELMET, 200);
    public static final Supplier<ArmorItem> FOSSIL_CHESTPLATE = registerNormalArmor("fossil_chestplate", "fossil_armor", ArmorMaterials.FOSSIL_ARMOR_MATERIALS, ArmorItem.Type.CHESTPLATE, 270);
    public static final Supplier<ArmorItem> FOSSIL_LEGGINGS = registerNormalArmor("fossil_leggings", "fossil_armor", ArmorMaterials.FOSSIL_ARMOR_MATERIALS, ArmorItem.Type.LEGGINGS, 250);
    public static final Supplier<ArmorItem> FOSSIL_BOOTS = registerNormalArmor("fossil_boots", "fossil_armor", ArmorMaterials.FOSSIL_ARMOR_MATERIALS, ArmorItem.Type.BOOTS, 200);


    private static Supplier<ArmorItem> registerNormalArmor(String name, String geoName, Holder<ArmorMaterial> material, ArmorItem.Type type, int durability) {
        return ITEMS.register(name, () -> new NormalArmorItem("armor/" + geoName, material, type, new Item.Properties().stacksTo(1).durability(durability)));
    }

    public static void register(IEventBus eventBus) {
        ArmorMaterials.ARMOR_MATERIALS.register(eventBus);
        ITEMS.register(eventBus);
    }
}
