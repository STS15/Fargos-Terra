package org.confluence.mod.client.event;

import net.minecraft.client.Minecraft;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.*;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import org.confluence.mod.Confluence;
import org.confluence.mod.common.init.ModEffects;
import org.confluence.mod.common.item.sword.stagedy.ProjectileStrategy;
import org.confluence.mod.network.c2s.SwordShootingPacketC2S;
import org.confluence.mod.terra_curio.api.event.PerformJumpingEvent;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT, modid = Confluence.MODID)
public final class GameClientEvents {

    @SubscribeEvent
    public static void mouseClickEvent(InputEvent.MouseButton.Pre event) {

    }

    @SubscribeEvent
    public static void clientTick$Post(ClientTickEvent.Post event) {
        Player player = Minecraft.getInstance().player;
        // 弹幕
        if(player!=null){
            ProjectileStrategy.handle();
        }

    }

    @SubscribeEvent
    public static void movementInputUpdate(MovementInputUpdateEvent event) {

    }

    @SubscribeEvent
    public static void gatherComponents(RenderTooltipEvent.GatherComponents event) {

    }

    @SubscribeEvent
    public static void leftClick(InputEvent.InteractionKeyMappingTriggered event) {

    }

    @SubscribeEvent
    public static void itemToolTip(ItemTooltipEvent event) {

    }

    @SubscribeEvent
    public static void computeCameraAngles(ViewportEvent.ComputeCameraAngles event) {

    }

    @SubscribeEvent
    public static void renderFog(ViewportEvent.RenderFog event) {

    }

    @SubscribeEvent
    public static void computeFogColor(ViewportEvent.ComputeFogColor event) {

    }

    @SubscribeEvent
    public static void fov(ComputeFovModifierEvent event) {

    }

    @SubscribeEvent
    public static void interactionKeyMappingTriggered(InputEvent.InteractionKeyMappingTriggered event) {

    }

    @SubscribeEvent
    public static void renderGuiOverlay$Pre(RenderGuiLayerEvent.Pre event) {

    }

    @SubscribeEvent
    public static void beforeRenderLiving(RenderLivingEvent.Pre<?, ?> event) {

    }

    @SubscribeEvent
    public static void afterRenderLiving(RenderLivingEvent.Post<?, ?> event) {

    }

    @SubscribeEvent
    public static void performJumping(PerformJumpingEvent event) {
        if (event.isCanPerform() && event.getEntity().hasEffect(ModEffects.SHIMMER)) {
            event.setCanPerform(false);
        }
    }
}
