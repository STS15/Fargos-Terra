package org.confluence.mod.common.init.armor;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.confluence.mod.Confluence;
import org.confluence.mod.common.init.item.MaterialItems;

import java.util.EnumMap;
import java.util.List;

public class ArmorMaterials {
    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = DeferredRegister.create(BuiltInRegistries.ARMOR_MATERIAL, Confluence.MODID);

    public static final Holder<ArmorMaterial> CACTUS_ARMOR_MATERIALS = ARMOR_MATERIALS.register("cactus_armor_materials", () -> new ArmorMaterial(
        Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.HELMET, 1);
            map.put(ArmorItem.Type.CHESTPLATE, 2);
            map.put(ArmorItem.Type.LEGGINGS, 2);
            map.put(ArmorItem.Type.BOOTS, 1);
        }),
        15, SoundEvents.ARMOR_EQUIP_LEATHER, () -> Ingredient.of(Items.CACTUS),
        List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(Confluence.MODID, ""))), 0.0F, 0.0F
    ));
    public static final Holder<ArmorMaterial> COPPER_ARMOR_MATERIALS = ARMOR_MATERIALS.register("copper_armor_materials", () -> new ArmorMaterial(
        Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.HELMET, 2);
            map.put(ArmorItem.Type.CHESTPLATE, 4);
            map.put(ArmorItem.Type.LEGGINGS, 4);
            map.put(ArmorItem.Type.BOOTS, 2);
        }),
        15, SoundEvents.ARMOR_EQUIP_LEATHER, () -> Ingredient.of(Items.COPPER_INGOT),
        List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(Confluence.MODID, "copper"))), 0.0F, 0.0F
    ));
    public static final Holder<ArmorMaterial> FOSSIL_ARMOR_MATERIALS = ARMOR_MATERIALS.register("fossil_armor_materials", () -> new ArmorMaterial(
        Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.HELMET, 2);
            map.put(ArmorItem.Type.CHESTPLATE, 6);
            map.put(ArmorItem.Type.LEGGINGS, 6);
            map.put(ArmorItem.Type.BOOTS, 2);
        }),
        15, SoundEvents.ARMOR_EQUIP_LEATHER, () -> Ingredient.of(MaterialItems.STURDY_FOSSIL),
        List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(Confluence.MODID, "fossil"))), 0.0F, 0.0F
    ));
    public static final Holder<ArmorMaterial> GOLDEN_ARMOR_MATERIALS = ARMOR_MATERIALS.register("golden_armor_materials", () -> new ArmorMaterial(
        Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.HELMET, 3);
            map.put(ArmorItem.Type.CHESTPLATE, 6);
            map.put(ArmorItem.Type.LEGGINGS, 6);
            map.put(ArmorItem.Type.BOOTS, 3);
        }),
        15, SoundEvents.ARMOR_EQUIP_LEATHER, () -> Ingredient.of(Items.GOLD_INGOT),
        List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(Confluence.MODID, "golden"))), 0.0F, 0.0F
    ));
    public static final Holder<ArmorMaterial> LEAD_ARMOR_MATERIALS = ARMOR_MATERIALS.register("lead_armor_materials", () -> new ArmorMaterial(
        Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.HELMET, 2);
            map.put(ArmorItem.Type.CHESTPLATE, 5);
            map.put(ArmorItem.Type.LEGGINGS, 6);
            map.put(ArmorItem.Type.BOOTS, 2);
        }),
        15, SoundEvents.ARMOR_EQUIP_LEATHER, () -> Ingredient.of(MaterialItems.LEAD_INGOT),
        List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(Confluence.MODID, "lead"))), 0.0F, 0.0F
    ));
    public static final Holder<ArmorMaterial> NINJA_ARMOR_MATERIALS = ARMOR_MATERIALS.register("ninja_armor_materials", () -> new ArmorMaterial(
        Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.HELMET, 2);
            map.put(ArmorItem.Type.CHESTPLATE, 5);
            map.put(ArmorItem.Type.LEGGINGS, 6);
            map.put(ArmorItem.Type.BOOTS, 2);
        }),
        15, SoundEvents.ARMOR_EQUIP_LEATHER, () -> Ingredient.of(MaterialItems.BLACK_INK),
        List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(Confluence.MODID, "ninja"))), 0.0F, 0.0F
    ));
    public static final Holder<ArmorMaterial> PLANK_ARMOR_MATERIALS = ARMOR_MATERIALS.register("plank_armor_materials", () -> new ArmorMaterial(
        Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.HELMET, 1);
            map.put(ArmorItem.Type.CHESTPLATE, 1);
            map.put(ArmorItem.Type.LEGGINGS, 1);
            map.put(ArmorItem.Type.BOOTS, 1);
        }),
        15, SoundEvents.ARMOR_EQUIP_LEATHER, () -> Ingredient.of(Items.OAK_PLANKS),
        List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(Confluence.MODID, "plank"))), 0.0F, 0.0F
    ));
    public static final Holder<ArmorMaterial> PLATINUM_ARMOR_MATERIALS = ARMOR_MATERIALS.register("platinum_armor_materials", () -> new ArmorMaterial(
        Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.HELMET, 3);
            map.put(ArmorItem.Type.CHESTPLATE, 6);
            map.put(ArmorItem.Type.LEGGINGS, 7);
            map.put(ArmorItem.Type.BOOTS, 3);
        }),
        15, SoundEvents.ARMOR_EQUIP_LEATHER, () -> Ingredient.of(MaterialItems.PLATINUM_INGOT),
        List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(Confluence.MODID, "platinum"))), 0.0F, 0.0F
    ));
    public static final Holder<ArmorMaterial> SILVER_ARMOR_MATERIALS = ARMOR_MATERIALS.register("silver_armor_materials", () -> new ArmorMaterial(
        Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.HELMET, 2);
            map.put(ArmorItem.Type.CHESTPLATE, 6);
            map.put(ArmorItem.Type.LEGGINGS, 6);
            map.put(ArmorItem.Type.BOOTS, 2);
        }),
        15, SoundEvents.ARMOR_EQUIP_LEATHER, () -> Ingredient.of(MaterialItems.SILVER_INGOT),
        List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(Confluence.MODID, "silver"))), 0.0F, 0.0F
    ));
    public static final Holder<ArmorMaterial> SNOW_ARMOR_MATERIALS = ARMOR_MATERIALS.register("snow_armor_materials", () -> new ArmorMaterial(
        Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.HELMET, 2);
            map.put(ArmorItem.Type.CHESTPLATE, 2);
            map.put(ArmorItem.Type.LEGGINGS, 2);
            map.put(ArmorItem.Type.BOOTS, 2);
        }),
        15, SoundEvents.ARMOR_EQUIP_LEATHER, () -> Ingredient.of(Items.BLUE_WOOL),
        List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(Confluence.MODID, "snow"))), 0.0F, 0.0F
    ));
    public static final Holder<ArmorMaterial> PINK_SNOW_ARMOR_MATERIALS = ARMOR_MATERIALS.register("pink_snow_armor_materials", () -> new ArmorMaterial(
        Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.HELMET, 2);
            map.put(ArmorItem.Type.CHESTPLATE, 2);
            map.put(ArmorItem.Type.LEGGINGS, 2);
            map.put(ArmorItem.Type.BOOTS, 2);
        }),
        15, SoundEvents.ARMOR_EQUIP_LEATHER, () -> Ingredient.of(Items.PINK_WOOL),
        List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(Confluence.MODID, "pink_snow"))), 0.0F, 0.0F
    ));
    public static final Holder<ArmorMaterial> TIN_ARMOR_MATERIALS = ARMOR_MATERIALS.register("tin_armor_materials", () -> new ArmorMaterial(
        Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.HELMET, 2);
            map.put(ArmorItem.Type.CHESTPLATE, 4);
            map.put(ArmorItem.Type.LEGGINGS, 4);
            map.put(ArmorItem.Type.BOOTS, 2);
        }),
        15, SoundEvents.ARMOR_EQUIP_LEATHER, () -> Ingredient.of(MaterialItems.TIN_INGOT),
        List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(Confluence.MODID, "tin"))), 0.0F, 0.0F
    ));
    public static final Holder<ArmorMaterial> TUNGSTEN_ARMOR_MATERIALS = ARMOR_MATERIALS.register("tungsten_armor_materials", () -> new ArmorMaterial(
        Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.HELMET, 2);
            map.put(ArmorItem.Type.CHESTPLATE, 6);
            map.put(ArmorItem.Type.LEGGINGS, 7);
            map.put(ArmorItem.Type.BOOTS, 2);
        }),
        15, SoundEvents.ARMOR_EQUIP_LEATHER, () -> Ingredient.of(MaterialItems.TUNGSTEN_INGOT),
        List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(Confluence.MODID, "tungsten"))), 0.0F, 0.0F
    ));
}
