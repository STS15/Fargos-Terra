package org.confluence.mod.common.data.gen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.confluence.mod.Confluence;
import org.confluence.mod.common.init.ModTags;
import org.confluence.mod.common.init.block.ModBlocks;
import org.confluence.mod.common.init.item.*;
import org.confluence.terra_curio.common.init.TCTags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, CompletableFuture<TagLookup<Block>> b, @Nullable ExistingFileHelper helper) {
        super(output, provider, b, Confluence.MODID, helper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        AccessoryItems.acceptTag(tag(TCTags.CURIO));

        HookItems.acceptTag(tag(ModTags.Items.HOOK));
        tag(ModTags.Items.MINECART).add(Items.MINECART);
        tag(ModTags.Items.PROVIDE_MANA).add(ModItems.STAR.get(), ModItems.SOUL_CAKE.get(), ModItems.SUGAR_PLUM.get());
        tag(ModTags.Items.PROVIDE_LIFE).add(ModItems.HEART.get(), ModItems.CANDY_APPLE.get(), ModItems.CANDY_CANE.get());
//        tag(ModTags.Items.DESERT_FOSSIL).add(ModBlocks.DESERT_FOSSIL.get().asItem());
        tag(ModTags.Items.GRAVEL).add(Blocks.GRAVEL.asItem());
//        tag(ModTags.Items.SLUSH).add(ModBlocks.SLUSH.get().asItem());
//        tag(ModTags.Items.MARINE_GRAVEL).add(ModBlocks.MARINE_GRAVEL.get().asItem());
        tag(ModTags.Items.JUNK).add(Blocks.LILY_PAD.asItem(), Items.LEATHER_BOOTS, Blocks.SEAGRASS.asItem());
        tag(ModTags.Items.CORAL).add(Blocks.TUBE_CORAL.asItem(), Blocks.TUBE_CORAL_FAN.asItem(), Blocks.TUBE_CORAL_BLOCK.asItem(), Blocks.BRAIN_CORAL.asItem(), Blocks.BRAIN_CORAL_FAN.asItem(), Blocks.BRAIN_CORAL_BLOCK.asItem(),
                Blocks.BUBBLE_CORAL.asItem(), Blocks.BUBBLE_CORAL_FAN.asItem(), Blocks.BUBBLE_CORAL_BLOCK.asItem(), Blocks.FIRE_CORAL.asItem(), Blocks.FIRE_CORAL_FAN.asItem(), Blocks.FIRE_CORAL_BLOCK.asItem(), Blocks.HORN_CORAL.asItem(), Blocks.HORN_CORAL_FAN.asItem(), Blocks.HORN_CORAL_BLOCK.asItem(),
                Blocks.DEAD_TUBE_CORAL.asItem(), Blocks.DEAD_TUBE_CORAL_FAN.asItem(), Blocks.DEAD_TUBE_CORAL_BLOCK.asItem(), Blocks.DEAD_BRAIN_CORAL.asItem(), Blocks.DEAD_BRAIN_CORAL_FAN.asItem(), Blocks.DEAD_BRAIN_CORAL_BLOCK.asItem(),
                Blocks.DEAD_BUBBLE_CORAL.asItem(), Blocks.DEAD_BUBBLE_CORAL_FAN.asItem(), Blocks.DEAD_BUBBLE_CORAL_BLOCK.asItem(), Blocks.DEAD_FIRE_CORAL.asItem(), Blocks.DEAD_FIRE_CORAL_FAN.asItem(), Blocks.DEAD_FIRE_CORAL_BLOCK.asItem(), Blocks.DEAD_HORN_CORAL.asItem(), Blocks.DEAD_HORN_CORAL_FAN.asItem(), Blocks.DEAD_HORN_CORAL_BLOCK.asItem());
        tag(ModTags.Items.TR_PLANKS).add(
                ModBlocks.EBONY_LOG_BLOCKS.getPlanks().asItem(), ModBlocks.SHADOW_LOG_BLOCKS.getPlanks().asItem(), ModBlocks.PALM_LOG_BLOCKS.getPlanks().asItem(),
                ModBlocks.SPOOKY_LOG_BLOCKS.getPlanks().asItem(), ModBlocks.ASH_LOG_BLOCKS.getPlanks().asItem(), ModBlocks.PEARL_LOG_BLOCKS.getPlanks().asItem(), Blocks.OAK_PLANKS.asItem(), Blocks.SPRUCE_PLANKS.asItem(),
                Blocks.ACACIA_PLANKS.asItem(), Blocks.DARK_OAK_PLANKS.asItem(), Blocks.JUNGLE_PLANKS.asItem(), Blocks.MANGROVE_PLANKS.asItem(), Blocks.CHERRY_PLANKS.asItem(), Blocks.BAMBOO_PLANKS.asItem(), Blocks.CRIMSON_PLANKS.asItem(),
                Blocks.BIRCH_PLANKS.asItem(), Blocks.WARPED_PLANKS.asItem());
        tag(ModTags.Items.LEAD_AND_IRON).add(Items.IRON_INGOT, MaterialItems.LEAD_INGOT.get());
        IntrinsicTagAppender<Item> torch = tag(ModTags.Items.TORCH);
        torch.add(Items.TORCH, Items.SOUL_TORCH);
//        for (Torches torches : Torches.values()) torch.add(torches.item.get());
        tag(ModTags.Items.BOTTOMLESS).add(
                ModItems.BOTTOMLESS_WATER_BUCKET.get(),
                ModItems.BOTTOMLESS_LAVA_BUCKET.get(),
                ModItems.BOTTOMLESS_HONEY_BUCKET.get(),
                ModItems.BOTTOMLESS_SHIMMER_BUCKET.get()
        );
        tag(ModTags.Items.FRUIT).add(
                Items.APPLE, Items.MELON_SLICE, FoodItems.APRICOT.get(),
                FoodItems.BANANA.get(), FoodItems.CHERRY.get(), FoodItems.COCONUT.get(),
                FoodItems.DRAGON_FRUIT.get(), FoodItems.GRAPE_FRUIT.get(), FoodItems.LEMON.get(),
                FoodItems.MANGO.get(), FoodItems.PEACH.get(), FoodItems.PINEAPPLE.get(),
                FoodItems.PLUM.get(), FoodItems.GRAPE.get(), FoodItems.SPICY_PEPPER.get(),
                FoodItems.STAR_FRUIT.get(), FoodItems.POMEGRANATE.get(), FoodItems.RAMBUTAN.get(),
                FoodItems.BLOOD_ORANGE.get(), FoodItems.ELDERBERRY.get(), FoodItems.BLACKCURRANT.get()
        );

        BowItems.acceptTag(tag(Tags.Items.TOOLS_BOW));
        ArrowItems.acceptTag(tag(ItemTags.ARROWS));
        HammerItems.acceptTag(tag(ModTags.Items.HAMMER));

        tag(ModTags.Items.COIN).add(ModItems.COPPER_COIN.get(), ModItems.SILVER_COIN.get(), ModItems.GOLDEN_COIN.get(), ModItems.PLATINUM_COIN.get());
    }
}
