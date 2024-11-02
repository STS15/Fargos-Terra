package org.confluence.mod.client.gui.screens;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.common.SimpleTier;
import org.confluence.mod.Confluence;
import org.confluence.mod.common.init.ModTiers;
import org.confluence.mod.common.init.item.FoodItems;
import org.confluence.mod.common.init.item.SwordItems;
import org.confluence.mod.common.item.food.BaseFoodItem;
import org.confluence.mod.util.GuiUtils;

import java.awt.*;
import java.util.*;

public class ObjectWikiScreen extends BaseWikiScreen{
    private Item item;
    private BaseWikiScreen screen;
    private String id;
    private static Map<String, Component> descriptionMap = new HashMap<>();

    protected ObjectWikiScreen(Item item, BaseWikiScreen screen, String id) {
        super(Component.literal(item.getDescriptionId()));
        this.id = id;
        this.item = item;
        this.screen = screen;
    }

    public static void putDescription(String id, Component description){
        String eid = "item." + id.split(":")[0] + "." + id.split(":")[1];
        descriptionMap.put(eid, description);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        GuiUtils.drawItem(guiGraphics, item, 367, 35, 80, 80, minecraft,
                item.getDefaultInstance().getTooltipLines(Item.TooltipContext.EMPTY,
                        null, TooltipFlag.ADVANCED), mouseX, mouseY);;
        if (item instanceof TieredItem ti){
            guiGraphics.drawString(minecraft.font, Component.translatable("wiki.confluence.damage").append(String.valueOf(ti.getTier().getAttackDamageBonus())), 10, 10, Color.WHITE.getRGB());
            guiGraphics.drawString(minecraft.font, Component.translatable("wiki.confluence.use").append(ti.getTier().getUses() == 0 ? Component.translatable("item.unbreakable") : Component.literal(String.valueOf(ti.getTier().getUses()))), 10, 20, Color.WHITE.getRGB());
            guiGraphics.drawString(minecraft.font, Component.translatable("wiki.confluence.speed").append(String.valueOf(ti.getTier().getSpeed())), 10, 30, Color.WHITE.getRGB());
            guiGraphics.drawString(minecraft.font, Component.translatable("wiki.confluence.enchantment").append(String.valueOf(ti.getTier().getEnchantmentValue())), 10, 40, Color.WHITE.getRGB());
            guiGraphics.drawString(minecraft.font, Component.translatable("wiki.confluence.ingredient").append(Arrays.toString(getRepairIngredient(ti.getTier()
                                    .getRepairIngredient().getItems()))
                            .replace("[", "").replace("]", "")),
                    10, 50, Color.WHITE.getRGB());
            if (ti.getTier() instanceof ModTiers.PoweredTier pt){
                guiGraphics.drawString(minecraft.font, Component.translatable("wiki.confluence.power")
                        .append(String.valueOf(pt.getPower())) , 10, 60, Color.WHITE.getRGB());
            }
        } else if (item instanceof BaseFoodItem fi){
            guiGraphics.drawString(minecraft.font, Component.translatable("wiki.confluence.nutrition")
                    .append(String.valueOf(fi.getFoodProperties(fi.getDefaultInstance(), null).nutrition())),
                    10, 10, Color.WHITE.getRGB());
            guiGraphics.drawString(minecraft.font, Component.translatable("wiki.confluence.saturation")
                            .append(String.valueOf(fi.getFoodProperties(fi.getDefaultInstance(), null).saturation())),
                    10, 20, Color.WHITE.getRGB());
        }

        if (descriptionMap.containsKey(id)){
            drawDescription(guiGraphics, minecraft.font, descriptionMap.get(id), 10, 70);
        }
    }

    private static void drawDescription(GuiGraphics guiGraphics, Font font,
                                        Component description, int x, int y){
        String st = description.getString();
        String[] des = st.split("\n");
        for (int i = 0; i < des.length; i++) {
            guiGraphics.drawString(font, des[i],
                    x, y + i * 10, Color.WHITE.getRGB());
        }
    }

    private Object[] getRepairIngredient(ItemStack[] stacks){
        ArrayList<String> items = new ArrayList<>();
        for (ItemStack stack : stacks){
            items.add(stack.getItem().getName(stack).getString());
        }
        if (!items.isEmpty()){
            return items.toArray();
        } else {
            return new String[]{"无"};
        }
    }

    @Override
    public Screen getParentScreen() {
        return screen;
    }
}
