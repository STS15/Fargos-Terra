package org.confluence.mod.common.entity.projectile;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.item.ItemStack;
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
    private int backTime;
    public int randomRotation;
    private float backSpeed;
    public boolean isBacking;
    public ItemStack weapon = ItemStack.EMPTY;
    public static final EntityDataAccessor<ItemStack> DATA_WEAPON = SynchedEntityData.defineId(BoomerangProjectile.class, EntityDataSerializers.ITEM_STACK);
    public static final EntityDataAccessor<Boolean> DATA_BACKING = SynchedEntityData.defineId(BoomerangProjectile.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Integer> DATA_BACKING_TIME = SynchedEntityData.defineId(BoomerangProjectile.class, EntityDataSerializers.INT);


    public BoomerangProjectile(EntityType<? extends AbstractHurtingProjectile> entityType, Level level) {
        super(entityType, level);
        modifier = new BoomerangModifier();
        this.randomRotation = this.random.nextInt(114514);
    }

    public BoomerangProjectile(LivingEntity owner, BoomerangModifier modifier, ItemStack weapon) {
        this(ModEntities.BOOMERANG_PROJECTILE.get(), owner.level());
        this.setOwner(owner);
        this.modifier = modifier;
        this.weapon = weapon;
        if(!level().isClientSide) this.entityData.set(DATA_WEAPON, weapon);

    }

    public void onSyncedDataUpdated(EntityDataAccessor<?> var1){
        if(var1 == DATA_BACKING_TIME){
            this.backTime = this.entityData.get(DATA_BACKING_TIME);
        }
        if(var1 == DATA_BACKING){
            this.isBacking = this.entityData.get(DATA_BACKING);
        }
        if(var1 == DATA_WEAPON){
            this.weapon = this.entityData.get(DATA_WEAPON);
            }
    }


    protected void onHitEntity(EntityHitResult result) {
//        if(!level().isClientSide){
            if(result.getEntity() instanceof LivingEntity living && living.isAlive()
                    && this.getOwner()!= null && !this.getOwner().is(living)
            ){
                assert this.getOwner() instanceof LivingEntity;
                living.hurt(this.damageSources().mobProjectile(this, (LivingEntity) this.getOwner()), modifier.damage);
                modifier.onHitEffects.forEach(effect -> effect.accept(living, (LivingEntity) this.getOwner()));
                //击退
                doKnockback(living);
            }
            if(!modifier.canPenetrate) {
                if(!isBacking) {
                    backTime = this.tickCount;
                    this.entityData.set(DATA_BACKING_TIME, backTime);
                    this.entityData.set(DATA_BACKING, true);
                    backSpeed = (float) this.getDeltaMovement().length();
                }
                isBacking = true;

            }
//        }
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

        if(this.getOwner()!= null && this.getOwner() instanceof LivingEntity living){
            if(!isBacking){
                int delta = 10;
                double actualSpeed = Math.min(Mth.lerp((float) (modifier.forwardTick - tickCount) / delta,0.01F,modifier.flySpeed),modifier.flySpeed) ;
//                this.setDeltaMovement(getDeltaMovement().normalize().scale(actualSpeed));
                Vec3 dir = getDeltaMovement().normalize();
                Vec3 motion = dir.scale(actualSpeed );
                this.setDeltaMovement(motion);

                if(this.modifier.forwardTick <= this.tickCount) {
                    isBacking = true;
                    backTime = this.tickCount;
                    this.noPhysics = true;
                    entityData.set(DATA_BACKING, true);
                }
            }else{
                Vec3 dir = living.position().add(0,1,0).subtract(this.position()).normalize();
                int delta = 10;

                double actualSpeed = Math.min(Mth.lerp((float) (tickCount - backTime) / delta,backSpeed+0.01F,modifier.backSpeed),modifier.backSpeed);
//                System.out.println(actualSpeed);

                Vec3 motion = dir.scale(actualSpeed);
//            Vec3 motion = this.position().add(dir.scale(1));

                this.setDeltaMovement(motion);
//                this.move(MoverType.SELF, this.getDeltaMovement());
                if(this.distanceToSqr(living.position().add(0,1,0)) < 1){
                    discard();
                }
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
        return null;
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
        builder.define(DATA_BACKING_TIME, 0);
    }



    public void onRemovedFromLevel(){
        if(weapon!=null && !level().isClientSide) {
            Boomerang.setBacked(weapon, SingleBooleanComponent.TRUE);
            //  提前部署
            if(getOwner() instanceof Player player && modifier.shouldWaitForBack && !modifier.shouldApplyCd)
                player.getCooldowns().removeCooldown(weapon.getItem());
        }
        super.onRemovedFromLevel();
    }
}
