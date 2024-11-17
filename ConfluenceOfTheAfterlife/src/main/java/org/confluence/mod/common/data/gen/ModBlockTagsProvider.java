package org.confluence.mod.common.data.gen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.confluence.mod.common.block.natural.LogBlockSet;
import org.confluence.mod.common.init.ModTags;
import org.confluence.mod.common.init.block.FunctionalBlocks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static org.confluence.mod.Confluence.MODID;
import static org.confluence.mod.common.init.block.ModBlocks.*;

@SuppressWarnings("unchecked")
public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        LogBlockSet.acceptTags(this);
        tag(ModTags.Blocks.VINES).add(
                Blocks.VINE,
                Blocks.WEEPING_VINES,
                Blocks.WEEPING_VINES_PLANT,
                Blocks.TWISTING_VINES,
                Blocks.TWISTING_VINES_PLANT,
                Blocks.CAVE_VINES,
                Blocks.CAVE_VINES_PLANT
        );
        tag(ModTags.Blocks.EASY_CRASH).add(
                THIN_ICE_BLOCK.get(),
                SWORD_IN_STONE.get(),
                CRACKED_BLUE_BRICK.get(),
                CRACKED_GREEN_BRICK.get(),
                CRACKED_PINK_BRICK.get(),
                CRISPY_HONEY_BLOCK.get()
        );
        tag(BlockTags.RAILS).add(FunctionalBlocks.EVER_POWERED_RAIL.get());

        //tag(ModTags.Blocks.NEEDS_1_LEVEL).addTags(ModTags.Blocks.NEEDS_2_LEVEL, ModTags.Blocks.NEEDS_3_LEVEL, ModTags.Blocks.NEEDS_4_LEVEL, ModTags.Blocks.NEEDS_5_LEVEL, ModTags.Blocks.NEEDS_6_LEVEL, ModTags.Blocks.NEEDS_7_LEVEL, ModTags.Blocks.NEEDS_8_LEVEL, ModTags.Blocks.NEEDS_9_LEVEL);
        //tag(ModTags.Blocks.NEEDS_2_LEVEL).addTags(ModTags.Blocks.NEEDS_3_LEVEL, ModTags.Blocks.NEEDS_4_LEVEL, ModTags.Blocks.NEEDS_5_LEVEL, ModTags.Blocks.NEEDS_6_LEVEL, ModTags.Blocks.NEEDS_7_LEVEL, ModTags.Blocks.NEEDS_8_LEVEL, ModTags.Blocks.NEEDS_9_LEVEL);
        //tag(ModTags.Blocks.NEEDS_3_LEVEL).addTags(ModTags.Blocks.NEEDS_4_LEVEL, ModTags.Blocks.NEEDS_5_LEVEL, ModTags.Blocks.NEEDS_6_LEVEL, ModTags.Blocks.NEEDS_7_LEVEL, ModTags.Blocks.NEEDS_8_LEVEL, ModTags.Blocks.NEEDS_9_LEVEL);
        //tag(ModTags.Blocks.NEEDS_4_LEVEL).addTags(ModTags.Blocks.NEEDS_5_LEVEL, ModTags.Blocks.NEEDS_6_LEVEL, ModTags.Blocks.NEEDS_7_LEVEL, ModTags.Blocks.NEEDS_8_LEVEL, ModTags.Blocks.NEEDS_9_LEVEL);
        //tag(ModTags.Blocks.NEEDS_5_LEVEL).addTags(ModTags.Blocks.NEEDS_6_LEVEL, ModTags.Blocks.NEEDS_7_LEVEL, ModTags.Blocks.NEEDS_8_LEVEL, ModTags.Blocks.NEEDS_9_LEVEL);
        //tag(ModTags.Blocks.NEEDS_6_LEVEL).addTags(ModTags.Blocks.NEEDS_7_LEVEL, ModTags.Blocks.NEEDS_8_LEVEL, ModTags.Blocks.NEEDS_9_LEVEL);
        //tag(ModTags.Blocks.NEEDS_7_LEVEL).addTags(ModTags.Blocks.NEEDS_8_LEVEL, ModTags.Blocks.NEEDS_9_LEVEL);
        //tag(ModTags.Blocks.NEEDS_8_LEVEL).addTags(ModTags.Blocks.NEEDS_9_LEVEL);
        //tag(ModTags.Blocks.NEEDS_9_LEVEL).add(丛林蜥蜴砖);
    }

    @Override
    public @NotNull IntrinsicTagAppender<Block> tag(@NotNull TagKey<Block> tag) {
        return super.tag(tag);
    }
}
