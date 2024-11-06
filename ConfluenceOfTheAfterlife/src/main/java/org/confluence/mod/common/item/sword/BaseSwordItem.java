package org.confluence.mod.common.item.sword;

import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.neoforged.neoforge.common.ItemAbility;
import org.apache.commons.lang3.function.TriConsumer;
import org.confluence.mod.common.item.sword.stagedy.projectile.AbstractProjContainer;
import org.confluence.terra_curio.common.component.ModRarity;
import org.confluence.terra_curio.common.init.TCDataComponentTypes;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;



public class BaseSwordItem extends SwordItem {
    public ModifierBuilder modifier;
    public BaseSwordItem(Tier tier, int rawDamage, float rawSpeed) {
        this(tier, ModRarity.WHITE, rawDamage, rawSpeed, new ModifierBuilder());
    }
    public BaseSwordItem(Tier tier, ModRarity rarity, int rawDamage, float rawSpeed) {
        this(tier, rarity, rawDamage, rawSpeed, new ModifierBuilder());
    }
    public BaseSwordItem(Tier tier, ModRarity rarity, int rawDamage, float rawSpeed, ModifierBuilder modifier) {
        super(tier, new Item.Properties()
                .component(DataComponents.ATTRIBUTE_MODIFIERS,
                        createAttributes(tier,rawDamage ,rawSpeed))
                .component(TCDataComponentTypes.MOD_RARITY, rarity)
        );
        this.modifier = modifier;
    }

    public static class ModifierBuilder {
        public List<BiConsumer<LivingEntity,LivingEntity>> onHitEffects = new ArrayList<>();
        public AbstractProjContainer proj;
        public QuaConsumer<ItemStack,Level,Entity,Boolean> inventoryTick;
        public boolean canPerformSweep = true;
        private float sweepRange = 3.0F;
        /**
         * 添加击中效果
         */
        public ModifierBuilder addOnHitEffect(BiConsumer<LivingEntity,LivingEntity> onHit){
            this.onHitEffects.add(onHit);
            return this;
        }
        /**
         * 设置弹幕
         */
        public ModifierBuilder setProj(AbstractProjContainer proj){
            this.proj = proj;
            return this;
        }
        /**
         * 禁用横扫
         */
        public ModifierBuilder setCanNotPerformSweep(){
            this.canPerformSweep = false;
            return this;
        }
        /**
         * 设置横扫范围
         */
        public ModifierBuilder setSweepRange(float sweepRange){
            this.sweepRange = sweepRange;
            return this;
        }
        public ModifierBuilder setInventoryTick(QuaConsumer<ItemStack,Level,Entity,Boolean> inventoryTick){
            this.inventoryTick = inventoryTick;
            return this;
        }

    }

    @Override
    public @NotNull AABB getSweepHitBox(@NotNull ItemStack stack, @NotNull Player player, @NotNull Entity target) {
        return super.getSweepHitBox(stack, player, target).inflate(modifier.sweepRange);
    }

    @Override
    public boolean canPerformAction(@NotNull ItemStack stack, @NotNull ItemAbility itemAbility) {
        return super.canPerformAction(stack, itemAbility) && modifier.canPerformSweep;
    }
    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if(modifier.inventoryTick!= null) modifier.inventoryTick.accept(stack,level,entity,isSelected);
    }

    @FunctionalInterface
    public interface QuaConsumer<A,B,C,D> {
        void accept(A a,B b,C c,D d);
    }
}
