package org.confluence.mod.client.renderer.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BeaconRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.confluence.mod.common.block.functional.AbstractMechanicalBlock;
import org.confluence.terra_curio.client.handler.InformationHandler;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class MechanicalBlockRenderer<E extends AbstractMechanicalBlock.Entity> implements BlockEntityRenderer<E> {
    public MechanicalBlockRenderer(BlockEntityRendererProvider.Context context) {}

    @Override
    public boolean shouldRenderOffScreen(@NotNull E pBlockEntity) {
        return InformationHandler.hasMechanicalView();
    }

    @Override
    public int getViewDistance() {
        return InformationHandler.hasMechanicalView() ? 256 : BlockEntityRenderer.super.getViewDistance();
    }

    @Override
    public boolean shouldRender(@NotNull AbstractMechanicalBlock.Entity pBlockEntity, @NotNull Vec3 pCameraPos) {
        return InformationHandler.hasMechanicalView() && pBlockEntity.getBlockPos().getCenter().multiply(1.0, 0.0, 1.0).closerThan(pCameraPos.multiply(1.0, 0.0, 1.0), getViewDistance());
    }

    @Override
    public @NotNull AABB getRenderBoundingBox(@NotNull E blockEntity) {
        return AABB.INFINITE;
    }

    @Override
    public void render(@NotNull E pBlockEntity, float pPartialTick, @NotNull PoseStack pPoseStack, @NotNull MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        Level level = pBlockEntity.getLevel();
        long gameTime = level == null ? 0L : level.getGameTime();
        Vec3 vec31 = pBlockEntity.getBlockPos().getCenter();
        for (Int2ObjectMap.Entry<Set<BlockPos>> entry : pBlockEntity.getConnectedPoses().int2ObjectEntrySet()) {
            int color = entry.getIntKey();
            for (BlockPos pos : entry.getValue()) {
                pPoseStack.pushPose();
                Vec3 subtract = pos.getCenter().subtract(vec31);
                Vec3 normalize = subtract.normalize();
                pPoseStack.translate(0.5, 0.5, 0.5);
                pPoseStack.mulPose(Axis.YP.rotation(Mth.HALF_PI - (float) Math.atan2(normalize.z, normalize.x)));
                pPoseStack.mulPose(Axis.XP.rotation((float) Math.acos(normalize.y)));
                pPoseStack.translate(-0.5, 0.0, -0.5);
                int height = (int) Math.round(subtract.length());
                BeaconRenderer.renderBeaconBeam(pPoseStack, pBuffer, BeaconRenderer.BEAM_LOCATION, pPartialTick, 1.0F, gameTime, 0, height, color, 0.2F, 0.25F);
                pPoseStack.popPose();
            }
        }
    }
}
