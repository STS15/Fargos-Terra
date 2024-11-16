package org.confluence.mod.mixin.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.entity.vehicle.VehicleEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.confluence.mod.mixed.IAbstractMinecart;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(AbstractMinecart.class)
public abstract class AbstractMinecartMixin extends VehicleEntity implements IAbstractMinecart {
    public AbstractMinecartMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public Item confluence$getDropItem() {
        return getDropItem();
    }
}
