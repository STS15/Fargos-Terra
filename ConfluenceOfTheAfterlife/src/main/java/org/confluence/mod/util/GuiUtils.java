package org.confluence.mod.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.SimpleBakedModel;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.Tool;

import java.util.List;

public class GuiUtils {
    public static void drawImage(ResourceLocation loc, GuiGraphics g, int x, int y,
                                 int wid, int hig, int imWid, int imHig){
        g.blit(loc, x, y, 0, 0, wid, hig, imWid, imHig);
    }

    public static void drawImage(ResourceLocation loc, GuiGraphics g, int x, int y,
                                 int imWid, int imHig){
        drawImage(loc, g, x, y, imWid, imHig, imWid, imHig);
    }

    public static Button buildIconButton(GuiGraphics g, ResourceLocation loc,
                                         int x, int y, int wid, int hig, int icWid, int icHig,
                                         Button.OnPress onPress){
        drawImage(loc, g, x + ((wid - icWid) / 2), y + ((hig - icHig) / 2),
                icWid, icHig);
        return Button.builder(Component.empty(), onPress)
                .bounds(x, y, wid, hig).build();
    }

    public static Button buildIconButton(GuiGraphics g, ResourceLocation loc,
                                         int x, int y, int wid, int hig, int icWid, int icHig,
                                         Button.OnPress onPress, Component hoverText){
        drawImage(loc, g, x + ((wid - icWid) / 2), y + ((hig - icHig) / 2),
                icWid, icHig);
        return Button.builder(Component.empty(), onPress)
                .bounds(x, y, wid, hig).tooltip(Tooltip.create(hoverText)).build();
    }

    public static Button buildItemButton(GuiGraphics g, Item it,
                                         int x, int y, int wid, int hig, int icWid, int icHig,
                                         Button.OnPress onPress, Component hoverText,
                                         Minecraft mc){
        BakedModel model = mc.getItemRenderer().getModel(it.getDefaultInstance(),
                null, null, 0);
        if (model instanceof SimpleBakedModel simple){
            g.blit(x + ((wid - icWid) / 2), y + ((hig - icHig) / 2), 0,
                    icWid, icHig, simple.getParticleIcon());
        }
        return Button.builder(Component.empty(), onPress)
                .bounds(x, y, wid, hig).tooltip(Tooltip.create(hoverText)).build();
    }

    public static void drawItem(GuiGraphics g, Item it,
                                int x, int y, int wid, int hig, int icWid, int icHig,
                                Minecraft mc){
        BakedModel model = mc.getItemRenderer().getModel(it.getDefaultInstance(),
                null, null, 0);
        if (model instanceof SimpleBakedModel simple){
            g.blit(x + ((wid - icWid) / 2), y + ((hig - icHig) / 2), 0,
                    icWid, icHig, simple.getParticleIcon());
        }
    }

    public static void drawItem(GuiGraphics g, Item it,
                                int x, int y, int wid, int hig,
                                Minecraft mc, List<Component> tooltips, int mouseX,
                                int mouseY){
        BakedModel model = mc.getItemRenderer().getModel(it.getDefaultInstance(),
                null, null, 0);
        if (model instanceof SimpleBakedModel simple){
            g.blit(x, y, 0,
                    wid, hig, simple.getParticleIcon());
        }
        //g.renderItem(it.getDefaultInstance(), x, y);
        if (mouseX >= x && mouseX <= x + wid && mouseY >= y && mouseY <= y + hig){
            g.renderTooltip(mc.font, tooltips, java.util.Optional.empty(),
                    mouseX, mouseY);
        }
    }
}
