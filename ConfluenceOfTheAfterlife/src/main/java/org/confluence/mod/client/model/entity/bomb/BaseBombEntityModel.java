package org.confluence.mod.client.model.entity.bomb;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import org.confluence.mod.Confluence;
import org.confluence.mod.common.entity.projectile.bombs.BaseBombEntity;

public class BaseBombEntityModel extends EntityModel<BaseBombEntity> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Confluence.asResource("bomb_entity"), "main");
    private final ModelPart root;

    public BaseBombEntityModel(ModelPart root) {
        this.root = root;
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 6.0F, 6.0F, CubeDeformation.NONE)
                .texOffs(0, 12).addBox(-1.5F, 6.0F, -1.5F, 3.0F, 1.0F, 3.0F, CubeDeformation.NONE)
                .texOffs(2, 0).addBox(-0.5F, 7.0F, -1.0F, 1.0F, 2.0F, 0.0F, CubeDeformation.NONE)
                .texOffs(0, 0).addBox(0.0F, 7.0F, -1.5F, 0.0F, 2.0F, 1.0F, CubeDeformation.NONE), PartPose.ZERO);
        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(BaseBombEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        root.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }
}