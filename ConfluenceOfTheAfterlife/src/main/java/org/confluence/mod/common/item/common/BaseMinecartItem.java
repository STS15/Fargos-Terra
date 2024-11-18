package org.confluence.mod.common.item.common;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MinecartItem;
import org.confluence.mod.common.entity.minecart.BaseMinecartEntity;
import org.confluence.terra_curio.common.component.ModRarity;
import org.confluence.terra_curio.common.init.TCDataComponentTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("rawtypes")
public class BaseMinecartItem extends MinecartItem {
    private final BaseMinecartEntity.Abilities abilities;
    private final MinecartFactory factory;

    public BaseMinecartItem(Properties properties, ModRarity rarity, BaseMinecartEntity.Abilities abilities, MinecartFactory factory) {
        super(AbstractMinecart.Type.RIDEABLE, properties.stacksTo(1).component(TCDataComponentTypes.MOD_RARITY, rarity));
        this.abilities = abilities;
        this.factory = factory;
    }

    @Override
    public @NotNull MutableComponent getName(@NotNull ItemStack pStack) {
        return Component.translatable(getDescriptionId()).withStyle(style -> style.withColor(pStack.get(TCDataComponentTypes.MOD_RARITY).getColor()));
    }

    public AbstractMinecart createMinecart(ServerLevel level, double x, double y, double z, AbstractMinecart.Type type, ItemStack stack, @Nullable Player player) {
        if (type == AbstractMinecart.Type.RIDEABLE && stack.is(this)) {
            return factory.createMinecart(level, x, y, z, abilities);
        }
        return null;
    }

    @FunctionalInterface
    public interface MinecartFactory {
        AbstractMinecart createMinecart(ServerLevel level, double x, double y, double z, BaseMinecartEntity.Abilities abilities);
    }
}
