package org.confluence.mod.common.entity.projectile;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import org.confluence.mod.common.component.SingleBooleanComponent;
import org.confluence.mod.common.init.ModEntities;
import org.confluence.mod.common.item.sword.Boomerang;
import org.confluence.mod.common.item.sword.Boomerang.BoomerangModifier;

public class BoomerangProjectile extends AbstractHurtingProjectile {
    private BoomerangModifier modifier;
    public boolean isBacking;
    public ItemStack weapon = ItemStack.EMPTY;
    public static final EntityDataAccessor<ItemStack> DATA_WEAPON = SynchedEntityData.defineId(BoomerangProjectile.class, EntityDataSerializers.ITEM_STACK);
    public static final EntityDataAccessor<Boolean> DATA_BACKING = SynchedEntityData.defineId(BoomerangProjectile.class, EntityDataSerializers.BOOLEAN);


    public BoomerangProjectile(EntityType<? extends AbstractHurtingProjectile> entityType, Level level) {
        super(entityType, level);
        modifier = new BoomerangModifier();

    }

    public BoomerangProjectile(LivingEntity owner, BoomerangModifier modifier, ItemStack weapon) {
        this(ModEntities.BOOMERANG_PROJECTILE.get(), owner.level());
        this.setOwner(owner);
        this.modifier = modifier;
        this.weapon = weapon;
        if(!level().isClientSide) this.entityData.set(DATA_WEAPON, weapon);
    }



    protected void onHitEntity(EntityHitResult result) {
        if(!level().isClientSide){
            if(result.getEntity() instanceof LivingEntity living && living.isAlive()
                    && this.getOwner()!= null && !this.getOwner().is(living)
            ){
                assert this.getOwner() instanceof LivingEntity;
                living.hurt(this.damageSources().mobProjectile(this, (LivingEntity) this.getOwner()), modifier.damage);
                modifier.onHitEffects.forEach(effect -> effect.accept(living, (LivingEntity) this.getOwner()));
                //击退
                doKnockback(living);
            }
            if(!modifier.canPenetrate)
                isBacking = true;
        }
    }

    protected void doKnockback(LivingEntity entity) {

        double d1 = Math.max(0.0, 1.0 - entity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
        Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(modifier.knockback * d1);
        if (vec3.lengthSqr() > 0.0) {
            entity.push(vec3.x, 0.1, vec3.z);
        }

    }

    protected void onHitBlock(BlockHitResult result) {
        isBacking = true;
        this.noPhysics = true;
        entityData.set(DATA_BACKING, true);
        super.onHitBlock(result);
    }
    
    public void tick(){


        if(!level().isClientSide && this.modifier.forwardTick < this.tickCount) {
            isBacking = true;
            this.noPhysics = true;
            entityData.set(DATA_BACKING, true);
        }

        if(!level().isClientSide && isBacking && this.getOwner()!= null && this.getOwner() instanceof LivingEntity living){
            Vec3 dir = living.position().add(0,1,0).subtract(this.position()).normalize();

            Vec3 motion = this.position().add(dir.scale(modifier.backSpeed));
//            Vec3 motion = this.position().add(dir.scale(1));

            this.setDeltaMovement(motion.subtract(this.position()));
            this.move(MoverType.SELF, this.getDeltaMovement());
            if(this.distanceToSqr(living.position().add(0,1,0)) < 1){
                discard();
            }
        }
        super.tick();
    }
    public void shootFromRotation(Entity shooter, float x, float y, float z, float velocity, float inaccuracy) {
        float f = -Mth.sin(y * 0.017453292F) * Mth.cos(x * 0.017453292F);
        float f1 = -Mth.sin((x + z) * 0.017453292F);
        float f2 = Mth.cos(y * 0.017453292F) * Mth.cos(x * 0.017453292F);
        this.shoot(f, f1, f2, velocity, inaccuracy);
        this.setDeltaMovement(this.getDeltaMovement());
    }
    protected ParticleOptions getTrailParticle() {
        return ParticleTypes.SMOKE;
    }
    public boolean isOnFire() {
        return modifier.fire && (this.level().isClientSide && this.getSharedFlag(0));
    }

    public void onAddedToLevel(){
        super.onAddedToLevel();
        if(modifier==null) discard();
        if(level().isClientSide) weapon = this.entityData.get(DATA_WEAPON);
    }

    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_WEAPON, ItemStack.EMPTY);
        builder.define(DATA_BACKING, false);
    }



    public void onRemovedFromLevel(){
        if(weapon!=null) {
            Boomerang.setBacked(weapon, SingleBooleanComponent.TRUE);
            //  提前部署
            if(getOwner() instanceof Player player && modifier.shouldWaitForBack && !modifier.shouldApplyCd)
                player.getCooldowns().removeCooldown(weapon.getItem());
        }
        super.onRemovedFromLevel();
    }
}
