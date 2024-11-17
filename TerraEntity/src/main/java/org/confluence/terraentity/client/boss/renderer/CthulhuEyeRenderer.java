package org.confluence.terraentity.client.boss.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.minecraft.util.Mth;
import org.confluence.terraentity.client.boss.model.CthulhuEyeModel;
import org.confluence.terraentity.client.entity.model.GeoNormalModel;
import org.confluence.terraentity.entity.boss.AbstractTerraBossBase;
import org.confluence.terraentity.entity.boss.CthulhuEye;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CthulhuEyeRenderer extends GeoEntityRenderer<CthulhuEye> {
    //public static DIYBlitTarget tempBlurTarget;
    public CthulhuEyeRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CthulhuEyeModel());
    }

    @Override
    public void preRender(PoseStack poseStack, CthulhuEye entity, BakedGeoModel model, @org.jetbrains.annotations.Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {

        float yRot = Mth.lerp(partialTick, entity.yBodyRotO, entity.yBodyRot);
        double rad = yRot*Math.PI/180;
        float xRot = Mth.lerp(partialTick, entity.xRotO, entity.getXRot());
        poseStack.mulPose(Axis.of(new Vector3f((float) Math.cos(rad), 0, (float) Math.sin(rad))).rotationDegrees(xRot));
        poseStack.translate(0,0.5,0);
        super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, colour);

    }

    @Override
    protected float getDeathMaxRotation(CthulhuEye animatable){
        return 0;
    }

    @Override
    public void render(CthulhuEye entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {


        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);

    }
/*
    public RenderType getRenderType(CthulhuEye animatable, ResourceLocation texture,
                                     @Nullable MultiBufferSource bufferSource,
                                     float partialTick) {
        return ModRenderTypes.cthRenderType(texture);
    }
    */
}
