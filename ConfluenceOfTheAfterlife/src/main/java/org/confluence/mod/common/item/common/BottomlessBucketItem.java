package org.confluence.mod.common.item.common;

import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.FlowingFluid;
import org.confluence.terra_curio.common.component.ModRarity;
import org.confluence.terra_curio.common.init.TCDataComponentTypes;
import org.jetbrains.annotations.NotNull;

public class BottomlessBucketItem extends BucketItem {
    public BottomlessBucketItem(FlowingFluid flowingFluid, ModRarity rarity) {
        super(flowingFluid, new Properties().stacksTo(1).component(TCDataComponentTypes.MOD_RARITY, rarity));
    }

    @Override
    public boolean hasCraftingRemainingItem(@NotNull ItemStack stack) {
        return true;
    }

    @Override
    public @NotNull ItemStack getCraftingRemainingItem(@NotNull ItemStack itemStack) {
        return itemStack;
    }
}
