package org.confluence.mod.common.block.natural;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.confluence.mod.common.init.block.ModBlocks;
import org.confluence.mod.common.init.item.ModItems;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Set;

public class CloudWeaverBlock extends BaseCropBlock {
    public CloudWeaverBlock(BlockBehaviour.Properties pProperties) {
        super(pProperties);
    }

    @Override
    protected @NotNull ItemLike getBaseSeedId() {
        return ModItems.CLOUDWEAVER_SEED.get();
    }

    @Override
    public Set<Block> getCanPlaceBlocks() {
        return Set.of(ModBlocks.CLOUD_BLOCK.get());
    }

    @Override
    public List<ItemStack> getCropDrops() {
        return List.of(); // No drops
    }
}
