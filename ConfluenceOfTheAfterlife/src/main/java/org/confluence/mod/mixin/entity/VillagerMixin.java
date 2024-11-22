package org.confluence.mod.mixin.entity;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
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

    @WrapOperation(method = "updateSpecialPrices", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Player;getEffect(Lnet/minecraft/core/Holder;)Lnet/minecraft/world/effect/MobEffectInstance;"))
    private MobEffectInstance modifyAmplifier(Player instance, Holder<MobEffect> holder, Operation<MobEffectInstance> original) {
        int value = TCUtils.getAccessoriesValue(instance, AccessoryItems.SPECIAL$PRICE);
        MobEffectInstance effectInstance = original.call(instance, holder);
        if (value > 0) {
            if (effectInstance == null) {
                return new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 0, value - 1);
            }
            effectInstance.update(new MobEffectInstance(
                    effectInstance.getEffect(),
                    effectInstance.getDuration(),
                    value,
                    effectInstance.isAmbient(),
                    effectInstance.isVisible(),
                    effectInstance.showIcon()
            ));
        }
        return effectInstance;
    }
}
