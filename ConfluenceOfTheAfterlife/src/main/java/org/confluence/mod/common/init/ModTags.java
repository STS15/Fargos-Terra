package org.confluence.mod.common.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import org.confluence.mod.Confluence;

public final class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_1_LEVEL = register("needs_1_level");
        public static final TagKey<Block> NEEDS_2_LEVEL = register("needs_2_level");
        public static final TagKey<Block> NEEDS_3_LEVEL = register("needs_3_level");
        public static final TagKey<Block> NEEDS_4_LEVEL = register("needs_4_level");
        public static final TagKey<Block> NEEDS_5_LEVEL = register("needs_5_level");
        public static final TagKey<Block> NEEDS_6_LEVEL = register("needs_6_level");
        public static final TagKey<Block> NEEDS_7_LEVEL = register("needs_7_level");
        public static final TagKey<Block> NEEDS_8_LEVEL = register("needs_8_level");
        public static final TagKey<Block> NEEDS_9_LEVEL = register("needs_9_level");
        public static final TagKey<Block> TORCH = register("torch");
        public static final TagKey<Block> HARDCORE = register("hardcore");
        public static final TagKey<Block> POTS_SURVIVE = register("pots_survive");
        public static final TagKey<Block> COIN_PILE = register("coin_pile");
        public static final TagKey<Block> EASY_CRASH = register("easy_crash");
        public static final TagKey<Block> VINES = register("vines");

        private static TagKey<Block> register(String id) {
            return BlockTags.create(Confluence.asResource(id));
        }
    }

    public static class Items {
        public static final TagKey<Item> HOOK = curios("hook");
        public static final TagKey<Item> MINECART = curios("minecart");
        public static final TagKey<Item> PROVIDE_MANA = register("provide_mana");
        public static final TagKey<Item> PROVIDE_LIFE = register("provide_life");
        public static final TagKey<Item> COIN = register("coin");
        public static final TagKey<Item> TORCH = register("torch"); // todo
        public static final TagKey<Item> HARDCORE = register("hardcore"); // todo
        public static final TagKey<Item> BOTTOMLESS = register("bottomless");
        public static final TagKey<Item> FRUIT = register("fruit");
        public static final TagKey<Item> DESERT_FOSSIL = register("desert_fossil");
        public static final TagKey<Item> GRAVEL = register("gravel");
        public static final TagKey<Item> JUNK = register("junk");
        public static final TagKey<Item> SLUSH = register("slush");
        public static final TagKey<Item> MARINE_GRAVEL = register("marine_gravel");
        public static final TagKey<Item> CORAL = register("coral");
        public static final TagKey<Item> TR_PLANKS = register("tr_planks");
        public static final TagKey<Item> LEAD_AND_IRON = register("lead_and_iron");
        public static final TagKey<Item> HAMMER = register("hammer");

        private static TagKey<Item> curios(String id) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath("curios", id));
        }

        private static TagKey<Item> register(String id) {
            return ItemTags.create(Confluence.asResource(id));
        }
    }

    public static final TagKey<Fluid> FISHING_ABLE = FluidTags.create(Confluence.asResource("fishing_able"));
    public static final TagKey<Fluid> NOT_LAVA = FluidTags.create(Confluence.asResource("not_lava"));

    public static final TagKey<DamageType> HARMFUL_EFFECT = TagKey.create(Registries.DAMAGE_TYPE, Confluence.asResource("harmful_effect"));
    public static final TagKey<Biome> SPREADING = TagKey.create(Registries.BIOME, Confluence.asResource("spreading"));
}
