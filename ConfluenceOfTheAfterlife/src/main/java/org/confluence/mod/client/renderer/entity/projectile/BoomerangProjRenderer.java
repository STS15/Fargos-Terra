package org.confluence.mod.client.renderer.entity.projectile;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import org.confluence.mod.Confluence;
import org.confluence.mod.client.model.entity.projectile.IceBladeSwordProjectileModel;
import org.confluence.mod.common.entity.projectile.BoomerangProjectile;

public class BoomerangProjRenderer extends EntityRenderer<BoomerangProjectile> {
    IceBladeSwordProjectileModel model;
    public BoomerangProjRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        model = new IceBladeSwordProjectileModel(pContext.bakeLayer(IceBladeSwordProjectileModel.LAYER_LOCATION));
    }

    public void render(BoomerangProjectile entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        int pack = OverlayTexture.pack((int) (partialTick*Math.sin(partialTick/10)), (int) (partialTick*Math.cos(partialTick/10)));
        model.renderToBuffer(poseStack, bufferSource.getBuffer(model.renderType(getTextureLocation(entity))), packedLight, pack);
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(BoomerangProjectile baseArrowEntity) {
        return Confluence.asResource(baseArrowEntity.getTexturePath());
    }

}
