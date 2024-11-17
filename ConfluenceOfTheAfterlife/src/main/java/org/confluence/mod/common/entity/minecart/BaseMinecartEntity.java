package org.confluence.mod.common.entity.minecart;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.confluence.mod.common.init.ModAttachments;
import org.confluence.mod.common.init.ModEntities;
import org.confluence.mod.common.init.item.MinecartItems;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class BaseMinecartEntity extends Minecart {
    public static final double MECHANICAL_CART_MAX_SPEED = 0.615;
    public static final double MECHANICAL_CART_ACCELERATION = 2.5;
    public static final double MECHANICAL_CART_DRAG_AIR = 0.99;
    public static final Abilities<BaseMinecartEntity> WOODEN = new Abilities<>(ModEntities.WOODEN_MINECART, () -> Items.AIR, 0.308F, 0.16, 0.94);
    public static final Abilities<BaseMinecartEntity> MECHANICAL = new Abilities<>(ModEntities.MECHANICAL_CART, MinecartItems.MECHANICAL_CART, (float) MECHANICAL_CART_MAX_SPEED, MECHANICAL_CART_ACCELERATION, MECHANICAL_CART_DRAG_AIR);

    protected Supplier<? extends Item> dropItem = () -> Items.AIR;
    protected float maxSpeed = (float) MECHANICAL_CART_MAX_SPEED;
    protected double acceleration = MECHANICAL_CART_ACCELERATION;

    public BaseMinecartEntity(EntityType<? extends BaseMinecartEntity> entityType, Level level) {
        super(entityType, level);
    }

    public BaseMinecartEntity(Level level, double x, double y, double z, Abilities<? extends BaseMinecartEntity> abilities) {
        super(abilities.entityType.get(), level);
        this.dropItem = abilities.dropItem;
        this.acceleration = abilities.acceleration;
        setCurrentCartSpeedCapOnRail(maxSpeed);
        setDragAir(abilities.dragAir);
        setPos(x, y, z);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }

    @Override
    public void moveMinecartOnRail(@NotNull BlockPos pos) {
        boolean upgradeKit = getFirstPassenger() instanceof LivingEntity living && living.getData(ModAttachments.EVER_BENEFICIAL).isMinecartUpgradeKitUsed();
        if (upgradeKit) setDragAir(MECHANICAL_CART_DRAG_AIR);
        double d25 = upgradeKit ? MECHANICAL_CART_MAX_SPEED : getMaxCartSpeedOnRail();
        double d24 = upgradeKit ? MECHANICAL_CART_ACCELERATION : (isVehicle() ? acceleration : 1.0);
        Vec3 motion = getDeltaMovement();
        move(MoverType.SELF, new Vec3(Mth.clamp(d24 * motion.x, -d25, d25), 0.0D, Mth.clamp(d24 * motion.z, -d25, d25)));
    }

    @Override
    public @NotNull Item getDropItem() {
        return dropItem.get();
    }

    @Override
    public void setCurrentCartSpeedCapOnRail(float value) {
        this.maxSpeed = value;
        super.setCurrentCartSpeedCapOnRail(value);
    }

    @Override
    public float getMaxCartSpeedOnRail() {
        return maxSpeed;
    }

    @Override
    protected double getMaxSpeed() {
        return super.getMaxSpeed() * 2.0;
    }

    public record Abilities<E extends BaseMinecartEntity>(Supplier<EntityType<E>> entityType, Supplier<? extends Item> dropItem, float maxSpeed, double acceleration, double dragAir) {}
}
