package org.confluence.mod.api.event;

import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.Event;

public class GetCustomDiggingPowerEvent extends Event {
    private final ItemStack itemStack;
    private int power = -1;

    public GetCustomDiggingPowerEvent(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }
}
