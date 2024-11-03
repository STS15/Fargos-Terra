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
import org.confluence.mod.common.init.item.AccessoryItems;
import org.confluence.mod.common.init.item.ArrowItems;
import org.confluence.mod.common.init.item.BowItems;
import org.confluence.mod.common.init.item.MaterialItems;
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

//        Hooks.acceptTag(tag(ModTags.Items.HOOK));
        tag(ModTags.Items.MINECART).add(Items.MINECART);
//        tag(ModTags.Items.PROVIDE_MANA).add(ModItems.STAR.getPrefab(), ModItems.SOUL_CAKE.getPrefab(), ModItems.SUGAR_PLUM.getPrefab());
//        tag(ModTags.Items.PROVIDE_LIFE).add(ModItems.HEART.getPrefab(), ModItems.CANDY_APPLE.getPrefab(), ModItems.CANDY_CANE.getPrefab());
//        tag(ModTags.Items.DESERT_FOSSIL).add(ModBlocks.DESERT_FOSSIL.getPrefab().asItem());
        tag(ModTags.Items.GRAVEL).add(Blocks.GRAVEL.asItem());
//        tag(ModTags.Items.SLUSH).add(ModBlocks.SLUSH.getPrefab().asItem());
//        tag(ModTags.Items.MARINE_GRAVEL).add(ModBlocks.MARINE_GRAVEL.getPrefab().asItem());
        tag(ModTags.Items.JUNK).add(Blocks.LILY_PAD.asItem(), Items.LEATHER_BOOTS, Blocks.SEAGRASS.asItem());
        tag(ModTags.Items.CORAL).add(Blocks.TUBE_CORAL.asItem(), Blocks.TUBE_CORAL_FAN.asItem(), Blocks.TUBE_CORAL_BLOCK.asItem(), Blocks.BRAIN_CORAL.asItem(), Blocks.BRAIN_CORAL_FAN.asItem(), Blocks.BRAIN_CORAL_BLOCK.asItem(),
                Blocks.BUBBLE_CORAL.asItem(), Blocks.BUBBLE_CORAL_FAN.asItem(), Blocks.BUBBLE_CORAL_BLOCK.asItem(), Blocks.FIRE_CORAL.asItem(), Blocks.FIRE_CORAL_FAN.asItem(), Blocks.FIRE_CORAL_BLOCK.asItem(), Blocks.HORN_CORAL.asItem(), Blocks.HORN_CORAL_FAN.asItem(), Blocks.HORN_CORAL_BLOCK.asItem(),
                Blocks.DEAD_TUBE_CORAL.asItem(), Blocks.DEAD_TUBE_CORAL_FAN.asItem(), Blocks.DEAD_TUBE_CORAL_BLOCK.asItem(), Blocks.DEAD_BRAIN_CORAL.asItem(), Blocks.DEAD_BRAIN_CORAL_FAN.asItem(), Blocks.DEAD_BRAIN_CORAL_BLOCK.asItem(),
                Blocks.DEAD_BUBBLE_CORAL.asItem(), Blocks.DEAD_BUBBLE_CORAL_FAN.asItem(), Blocks.DEAD_BUBBLE_CORAL_BLOCK.asItem(), Blocks.DEAD_FIRE_CORAL.asItem(), Blocks.DEAD_FIRE_CORAL_FAN.asItem(), Blocks.DEAD_FIRE_CORAL_BLOCK.asItem(), Blocks.DEAD_HORN_CORAL.asItem(), Blocks.DEAD_HORN_CORAL_FAN.asItem(), Blocks.DEAD_HORN_CORAL_BLOCK.asItem());
        tag(ModTags.Items.TR_PLANKS).add(
//                ModBlocks.EBONY_LOG_BLOCKS.PLANKS.getPrefab().asItem(), ModBlocks.SHADOW_LOG_BLOCKS.PLANKS.getPrefab().asItem(), ModBlocks.PALM_LOG_BLOCKS.PLANKS.getPrefab().asItem(),
//                ModBlocks.SPOOKY_LOG_BLOCKS.PLANKS.getPrefab().asItem(), ModBlocks.ASH_LOG_BLOCKS.PLANKS.getPrefab().asItem(), ModBlocks.PEARL_LOG_BLOCKS.PLANKS.getPrefab().asItem(), Blocks.OAK_PLANKS.asItem(), Blocks.SPRUCE_PLANKS.asItem(),
                Blocks.ACACIA_PLANKS.asItem(), Blocks.DARK_OAK_PLANKS.asItem(), Blocks.JUNGLE_PLANKS.asItem(), Blocks.MANGROVE_PLANKS.asItem(), Blocks.CHERRY_PLANKS.asItem(), Blocks.BAMBOO_PLANKS.asItem(), Blocks.CRIMSON_PLANKS.asItem(),
                Blocks.BIRCH_PLANKS.asItem(), Blocks.WARPED_PLANKS.asItem());
        tag(ModTags.Items.LEAD_AND_IRON).add(Items.IRON_INGOT, MaterialItems.LEAD_INGOT.get());
        IntrinsicTagAppender<Item> torch = tag(ModTags.Items.TORCH);
        torch.add(Items.TORCH, Items.SOUL_TORCH);
//        for (Torches torches : Torches.values()) torch.add(torches.item.getPrefab());
//        tag(ModTags.Items.BOTTOMLESS).add(
//                ModItems.BOTTOMLESS_WATER_BUCKET.getPrefab(),
//                ModItems.BOTTOMLESS_LAVA_BUCKET.getPrefab(),
//                ModItems.BOTTOMLESS_HONEY_BUCKET.getPrefab(),
//                ModItems.BOTTOMLESS_SHIMMER_BUCKET.getPrefab()
//        );
//        tag(ModTags.Items.FRUIT).add(
//                Items.APPLE, Items.MELON_SLICE, Foods.APRICOT.getPrefab(),
//                Foods.BANANA.getPrefab(), Foods.CHERRY.getPrefab(), Foods.COCONUT.getPrefab(),
//                Foods.DRAGON_FRUIT.getPrefab(), Foods.GRAPE_FRUIT.getPrefab(), Foods.LEMON.getPrefab(),
//                Foods.MANGO.getPrefab(), Foods.PEACH.getPrefab(), Foods.PINEAPPLE.getPrefab(),
//                Foods.PLUM.getPrefab(), Foods.GRAPE.getPrefab(), Foods.SPICY_PEPPER.getPrefab(),
//                Foods.STAR_FRUIT.getPrefab(), Foods.POMEGRANATE.getPrefab(), Foods.RAMBUTAN.getPrefab(),
//                Foods.BLOOD_ORANGE.getPrefab(), Foods.ELDERBERRY.getPrefab(), Foods.BLACKCURRANT.getPrefab()
//        );

        BowItems.BOWS.getEntries().forEach(entry -> tag(Tags.Items.TOOLS_BOW).add(entry.get()));
//
        ArrowItems.ARROWS.getEntries().forEach(entry -> tag(ItemTags.ARROWS).add(entry.get()));


//        IntrinsicTagAppender<Item> rangedWeapon = tag(ModTags.Items.RANGED_WEAPON);

//        rangedWeapon.addTag(Tags.Items.TOOLS_BOWS);
//        rangedWeapon.addTag(Tags.Items.TOOLS_CROSSBOWS);
//        rangedWeapon.addTag(Tags.Items.TOOLS_TRIDENTS);
//        for (ManaWeapons manaWeapons : ManaWeapons.values()) rangedWeapon.add(manaWeapons.getPrefab());
//        tag(ModTags.Items.COIN).add(ModItems.COPPER_COIN.getPrefab(), ModItems.SILVER_COIN.getPrefab(), ModItems.GOLDEN_COIN.getPrefab(), ModItems.PLATINUM_COIN.getPrefab());
//        tag(ItemTags.MUSIC_DISCS).add(ModItems.ALPHA.getPrefab());
//        IntrinsicTagAppender<Item> hammer = tag(ModTags.Items.HAMMER);
//        for (Hammers hammers : Hammers.values()) hammer.add(hammers.getPrefab());

    }
}
