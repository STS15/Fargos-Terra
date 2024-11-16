package org.confluence.mod.common.entity.minecart;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class BaseMinecartEntity extends Minecart {
    private Supplier<? extends Item> dropItem = () -> Items.AIR;
    private float maxSpeed = 0.615F; // 机械矿车的最大速度
    private double acceleration = 2.5; // 机械矿车的加速度

    public BaseMinecartEntity(EntityType<? extends BaseMinecartEntity> entityType, Level level) {
        super(entityType, level);
    }

    public BaseMinecartEntity(EntityType<? extends BaseMinecartEntity> entityType, Level level, Supplier<? extends Item> dropItem, float maxSpeed, double acceleration) {
        super(entityType, level);
        this.dropItem = dropItem;
        this.maxSpeed = maxSpeed;
        this.acceleration = acceleration;
        setCurrentCartSpeedCapOnRail(maxSpeed);
    }

    @Override
    public void moveMinecartOnRail(@NotNull BlockPos pos) {
        double d24 = (isVehicle() ? acceleration : 1.0);
        double d25 = getMaxSpeedWithRail();
        Vec3 vec3d1 = getDeltaMovement();
        move(MoverType.SELF, new Vec3(Mth.clamp(d24 * vec3d1.x, -d25, d25), 0.0D, Mth.clamp(d24 * vec3d1.z, -d25, d25)));
    }

    @Override
    public @NotNull Item getDropItem() {
        return dropItem.get();
    }

    @Override
    public float getMaxCartSpeedOnRail() {
        return maxSpeed;
    }
}
