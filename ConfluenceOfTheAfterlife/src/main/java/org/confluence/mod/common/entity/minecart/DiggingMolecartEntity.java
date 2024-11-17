package org.confluence.mod.common.entity.minecart;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class DiggingMolecartEntity extends BaseMinecartEntity {
    private static final EntityDataAccessor<ItemStack> DATA_ITEM_STACK = SynchedEntityData.defineId(DiggingMolecartEntity.class, EntityDataSerializers.ITEM_STACK);

    public DiggingMolecartEntity(EntityType<? extends BaseMinecartEntity> entityType, Level level) {
        super(entityType, level);
    }

    public DiggingMolecartEntity(Level level, double x, double y, double z, Abilities abilities) {
        super(level, x, y, z, abilities);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_ITEM_STACK, ItemStack.EMPTY);
    }

    public void setDiggerItem(ItemStack itemStack) {
        entityData.set(DATA_ITEM_STACK, itemStack);
    }

    public ItemStack getDiggerItem() {
        return entityData.get(DATA_ITEM_STACK);
    }

    protected boolean canDigging() {
        return getY() <= level().getSeaLevel();
    }

    @Override
    public void moveMinecartOnRail(@NotNull BlockPos pos) {
        Direction dir = Direction.fromYRot(getYRot());
        super.moveMinecartOnRail(pos);
    }
}
