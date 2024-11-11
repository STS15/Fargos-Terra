package org.confluence.mod.client.event;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.*;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import org.confluence.mod.Confluence;
import org.confluence.mod.client.gui.hud.ArrowInBowHud;
import org.confluence.mod.client.handler.HookThrowingHandler;
import org.confluence.mod.common.init.ModEffects;
import org.confluence.mod.common.item.sword.stagedy.ProjectileStrategy;
import org.confluence.terra_curio.api.event.PerformJumpingEvent;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT, modid = Confluence.MODID)
public final class GameClientEvents {

    @SubscribeEvent
    public static void mouseClickEvent(InputEvent.MouseButton.Pre event) {

    }

    @SubscribeEvent
    public static void clientTick$Post(ClientTickEvent.Post event) {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer player = minecraft.player;
        if (player == null) return;

        ProjectileStrategy.handle(minecraft, player);
        HookThrowingHandler.handle(player);
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

    @SubscribeEvent
    public static void renderHandEvent(RenderHandEvent event) {
        ArrowInBowHud.render(event);
    }
}