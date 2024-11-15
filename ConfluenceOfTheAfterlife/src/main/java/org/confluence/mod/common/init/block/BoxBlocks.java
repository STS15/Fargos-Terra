package org.confluence.mod.common.init.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.confluence.mod.Confluence;
import org.confluence.mod.common.init.item.ModItems;
import org.confluence.mod.common.item.common.BoxBlockItem;

public class BoxBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Confluence.MODID);

    public static final DeferredBlock<Block> WOODEN_BOX = register("wooden_box");
    public static final DeferredBlock<Block> IRON_BOX = register("iron_box");
    public static final DeferredBlock<Block> GOLDEN_BOX = register("golden_box");
    public static final DeferredBlock<Block> JUNGLE_BOX = register("jungle_box");
    public static final DeferredBlock<Block> SKY_BOX = register("sky_box");
    public static final DeferredBlock<Block> CORRUPT_BOX = register("corrupt_box");
    public static final DeferredBlock<Block> TR_CRIMSON_BOX = register("tr_crimson_box");
    public static final DeferredBlock<Block> SACRED_BOX = register("sacred_box");
    public static final DeferredBlock<Block> DUNGEON_BOX = register("dungeon_box");
    public static final DeferredBlock<Block> FREEZE_BOX = register("freeze_box");
    public static final DeferredBlock<Block> OASIS_BOX = register("oasis_box");
    public static final DeferredBlock<Block> OBSIDIAN_BOX = register("obsidian_box");
    public static final DeferredBlock<Block> OCEAN_BOX = register("ocean_box");

    public static final DeferredBlock<Block> PEARLWOOD_BOX = register("pearlwood_box");
    public static final DeferredBlock<Block> MITHRIL_BOX = register("mithril_box");
    public static final DeferredBlock<Block> TITANIUM_BOX = register("titanium_box");
    public static final DeferredBlock<Block> THORNS_BOX = register("thorns_box");
    public static final DeferredBlock<Block> SPACE_BOX = register("space_box");
    public static final DeferredBlock<Block> DEFACED_BOX = register("defaced_box");
    public static final DeferredBlock<Block> BLOOD_BOX = register("blood_box");
    public static final DeferredBlock<Block> PROVIDENTIAL_BOX = register("providential_box");
    public static final DeferredBlock<Block> FENCING_BOX = register("fencing_box");
    public static final DeferredBlock<Block> CONIFEROUS_WOOD_BOX = register("coniferous_wood_box");
    public static final DeferredBlock<Block> ILLUSION_BOX = register("illusion_box");
    public static final DeferredBlock<Block> HELL_STONE_BOX = register("hell_stone_box");
    public static final DeferredBlock<Block> BEACH_BOX = register("beach_box");

    private static DeferredBlock<Block> register(String name) {
        DeferredBlock<Block> block = BLOCKS.register(name, () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
        ModItems.ITEMS.register(name, () -> new BoxBlockItem(block.get(), Confluence.asResource(name)));
        return block;
    }
}
