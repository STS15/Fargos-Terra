package org.confluence.mod.mixin;

import com.google.common.collect.ImmutableMap;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifierManager;
import org.confluence.terra_curio.TerraCurio;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Map;

@Mixin(value = LootModifierManager.class, remap = false)
public abstract class LootModifierManagerMixin {
    @ModifyExpressionValue(method = "apply(Ljava/util/Map;Lnet/minecraft/server/packs/resources/ResourceManager;Lnet/minecraft/util/profiling/ProfilerFiller;)V", at= @At(value = "INVOKE", target = "Lcom/google/common/collect/ImmutableMap$Builder;build()Lcom/google/common/collect/ImmutableMap;"))
    private ImmutableMap<ResourceLocation, IGlobalLootModifier> removeTerraCurio(ImmutableMap<ResourceLocation, IGlobalLootModifier> original) {
        ImmutableMap.Builder<ResourceLocation, IGlobalLootModifier> builder = ImmutableMap.builder();
        for (Map.Entry<ResourceLocation, IGlobalLootModifier> entry : original.entrySet()) {
            if (!entry.getKey().getNamespace().equals(TerraCurio.MODID)) {
                builder.put(entry);
            }
        }
        return builder.build();
    }
}
