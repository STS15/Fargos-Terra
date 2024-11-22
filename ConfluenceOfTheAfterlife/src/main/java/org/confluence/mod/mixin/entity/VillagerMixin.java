package org.confluence.mod.mixin.entity;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import org.confluence.mod.common.init.item.AccessoryItems;
import org.confluence.terra_curio.util.TCUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Villager.class)
public abstract class VillagerMixin {
    @ModifyExpressionValue(method = "updateSpecialPrices", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Player;hasEffect(Lnet/minecraft/core/Holder;)Z"))
    private boolean hasSpecialOffer(boolean original, @Local(argsOnly = true) Player player) {
        return original || TCUtils.getAccessoriesValue(player, AccessoryItems.SPECIAL$PRICE) > 0;
    }

    @ModifyExpressionValue(method = "updateSpecialPrices", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/effect/MobEffectInstance;getAmplifier()I"))
    private int modifyAmplifier(int original, @Local(argsOnly = true) Player player) {
        return Math.max(original, TCUtils.getAccessoriesValue(player, AccessoryItems.SPECIAL$PRICE));
    }
}
