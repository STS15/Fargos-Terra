package org.confluence.mod.mixin.integration.terra_curio;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.entity.player.Player;
import org.confluence.terra_curio.api.primitive.ValueType;
import org.confluence.terra_curio.client.handler.InformationHandler;
import org.confluence.terra_curio.util.TCUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = InformationHandler.class, remap = false)
public abstract class InformationHandlerMixin {
    @ModifyExpressionValue(method = "getFishingPowerInfo", at = @At(value = "INVOKE", target = "Lorg/confluence/terra_curio/util/TCUtils;forConfluence$ModifyExpression(Ljava/lang/Object;)Ljava/lang/Object;"))
    private static Object modifyFishingPower(Object original, @Local(argsOnly = true) Player player) {
        return TCUtils.getAccessoriesValue(player, ValueType.FISHING$POWER);
    }
}
