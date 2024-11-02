package org.confluence.mod.common.item.food;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import org.jetbrains.annotations.NotNull;

public class BaseFoodItem extends Item {
    private int durability = 0;
    private UseAnim useAnim = UseAnim.NONE;
    private SoundEvent soundEvent = SoundEvents.HONEY_DRINK;

    public BaseFoodItem(FoodProperties foodProperties) {
        super(new Item.Properties().food(foodProperties).stacksTo(64));
    }

    public BaseFoodItem(FoodProperties foodProperties, boolean isFireResistant) {
        super(new Properties().food(foodProperties).stacksTo(64).fireResistant());
    }

    public BaseFoodItem(FoodProperties foodProperties, Item craftingRemainingItem, int durability, UseAnim useAnim, SoundEvent soundEvent) {
        super(new Properties().food(foodProperties).craftRemainder(craftingRemainingItem).stacksTo(64));
        this.useAnim = useAnim;
        this.soundEvent = soundEvent;
        this.durability = durability;
    }

    @Override
    public int getUseDuration(@NotNull ItemStack itemStack, @NotNull LivingEntity entity) {
        return durability;
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack itemStack) {
        return useAnim;
    }

    @Override
    public @NotNull SoundEvent getDrinkingSound() {
        return soundEvent;
    }

    @Override
    public @NotNull SoundEvent getEatingSound() {
        return soundEvent;
    }
}
