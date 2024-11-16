package org.confluence.mod.mixin.entity;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.confluence.mod.common.init.block.ModBlocks;
import org.confluence.mod.common.init.item.AccessoryItems;
import org.confluence.mod.mixinauxi.ILivingEntity;
import org.confluence.mod.mixinauxi.Immunity;
import org.confluence.terra_curio.mixinauxi.SelfGetter;
import org.confluence.terra_curio.util.TCUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity implements ILivingEntity, SelfGetter<LivingEntity> {
    @Unique
    private final Object2IntMap<Immunity> confluence$entityImmunityTicks = new Object2IntOpenHashMap<>();

    @Unique
    private boolean confluence$breakingEasyCrashBlock = false;

    public LivingEntityMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public void confluence$setBreakEasyCrashBlock(boolean breaking) {
        this.confluence$breakingEasyCrashBlock = breaking;
    }

    @Override
    public boolean confluence$isBreakEasyCrashBlock() {
        return confluence$breakingEasyCrashBlock;
    }

    @Override
    public Object2IntMap<Immunity> confluence$getImmunityTicks() {
        return confluence$entityImmunityTicks;
    }

    @Inject(method = "checkFallDamage", at = @At("HEAD"), cancellable = true)
    private void fall(double motionY, boolean onGround, BlockState blockState, BlockPos blockPos, CallbackInfo ci) {
        LivingEntity self = self();
        if (fallDistance >= 2.5F && blockState.is(ModBlocks.THIN_ICE_BLOCK) && !TCUtils.hasAccessoriesType(self, AccessoryItems.ICE$SAFE)) {
            if (!level().isClientSide) {
                BlockPos.betweenClosedStream(getBoundingBox().move(0.0, -0.5, 0.0)).forEach(pos -> {
                    if (pos.equals(blockPos) || level().getBlockState(pos).is(ModBlocks.THIN_ICE_BLOCK)) {
                        level().destroyBlock(pos, true, self);
                    }
                });
            }
            this.confluence$breakingEasyCrashBlock = true;
            setOnGround(false);
            super.checkFallDamage(motionY, false, blockState, blockPos);
            ci.cancel();
        } else {
            this.confluence$breakingEasyCrashBlock = false;
        }
    }
}
