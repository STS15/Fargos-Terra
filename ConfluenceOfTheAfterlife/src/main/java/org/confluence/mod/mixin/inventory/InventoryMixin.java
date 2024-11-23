package org.confluence.mod.mixin.inventory;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Inventory.class)
public abstract class InventoryMixin {
    @ModifyExpressionValue(method = "hasRemainingSpaceForItem", at= @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Inventory;getMaxStackSize(Lnet/minecraft/world/item/ItemStack;)I"))
    private int modifyMaxStackSize1(int original, @Local(argsOnly = true, ordinal = 0) ItemStack destination) {
        return Math.max(original, destination.getMaxStackSize());
    }

    @ModifyExpressionValue(method = "addResource(ILnet/minecraft/world/item/ItemStack;)I",at= @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Inventory;getMaxStackSize(Lnet/minecraft/world/item/ItemStack;)I"))
    private int modifyMaxStackSize2(int original, @Local(ordinal = 1) ItemStack itemstack) {
        return Math.max(original, itemstack.getMaxStackSize());
    }
}
