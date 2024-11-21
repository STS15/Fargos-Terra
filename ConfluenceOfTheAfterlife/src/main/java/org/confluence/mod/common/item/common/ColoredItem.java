package org.confluence.mod.common.item.common;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import org.confluence.terra_curio.common.component.NbtComponent;
import org.confluence.terra_curio.common.init.TCDataComponentTypes;
import org.confluence.terra_curio.util.TCUtils;

public class ColoredItem extends Item {
    public ColoredItem(Properties pProperties) {
        super(pProperties);
    }

    public ColoredItem(Rarity rarity) {
        this(new Properties().rarity(rarity));
    }

    public static void setColor(ItemStack itemStack, int rgb) {
        TCUtils.updateItemStackNbt(itemStack, tag -> tag.putInt("color", rgb));
    }

    public static int getColor(ItemStack itemStack) {
        NbtComponent nbtComponent = itemStack.get(TCDataComponentTypes.NBT);
        if (nbtComponent == null) {
            return 0xFF66CCFF;
        }
        return nbtComponent.nbt().getInt("color");
    }
}
