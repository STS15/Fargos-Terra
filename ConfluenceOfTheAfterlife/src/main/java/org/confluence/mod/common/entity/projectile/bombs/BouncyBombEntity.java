package org.confluence.mod.common.entity.projectile.bombs;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.confluence.mod.common.init.ModEntities;
import org.confluence.mod.common.init.item.ToolItems;
import org.jetbrains.annotations.NotNull;

public class BouncyBombEntity extends BaseBombEntity {
    private static final float BOUNCE_FACTOR_NEW = 0.8f;

    public BouncyBombEntity(EntityType<? extends BouncyBombEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.bounceFactor = BOUNCE_FACTOR_NEW;
    }

    public BouncyBombEntity(Level pLevel, double pX, double pY, double pZ) {
        super(ModEntities.BOUNCY_BOMB_ENTITY.get(), pX, pY, pZ, pLevel);
        this.bounceFactor = BOUNCE_FACTOR_NEW;
    }

    public BouncyBombEntity(LivingEntity pShooter) {
        super(ModEntities.BOUNCY_BOMB_ENTITY.get(), pShooter);
        this.bounceFactor = BOUNCE_FACTOR_NEW;
    }

    @Override
    protected @NotNull Item getDefaultItem() {
        return ToolItems.BOUNCY_BOMB.get();
    }
}
