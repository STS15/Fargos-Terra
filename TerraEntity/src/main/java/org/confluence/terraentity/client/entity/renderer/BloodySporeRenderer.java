package org.confluence.terraentity.client.entity.renderer;

import net.minecraft.client.renderer.entity.CreeperRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Creeper;
import org.confluence.terraentity.TerraEntity;
import org.jetbrains.annotations.NotNull;

public class BloodySporeRenderer extends CreeperRenderer {
    private static final ResourceLocation LOCATION = TerraEntity.space("textures/entity/bloody_spore.png");

    public BloodySporeRenderer(EntityRendererProvider.Context p_173958_) {
        super(p_173958_);
    }

    @Override
    public ResourceLocation getTextureLocation(@NotNull Creeper pEntity) {
        return LOCATION;
    }
}