package org.confluence.mod.common.item.sword;

import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import org.confluence.mod.Confluence;
import org.confluence.mod.common.component.SingleBooleanComponent;
import org.confluence.mod.common.init.ModDataComponentTypes;
import org.confluence.mod.common.item.CustomRarityItem;
import org.confluence.mod.common.item.sword.stagedy.EffectStrategy;
import org.confluence.mod.common.item.sword.stagedy.InventoryTickStrategy;
import org.confluence.mod.common.item.sword.stagedy.ProjectileStrategy;
import org.confluence.mod.common.item.sword.stagedy.projectile.AbstractProjContainer;
import org.confluence.mod.common.item.sword.stagedy.projectile.BoomerangProjContainer;
import org.confluence.terra_curio.common.component.ModRarity;
import org.confluence.terra_curio.common.init.TCDataComponentTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class Boomerang extends CustomRarityItem {

    public final BoomerangModifier boomerangModifier;


    public Boomerang(float damage, int durability) {
        this(damage,durability,ModRarity.WHITE);
    }

    public Boomerang(float damage ,int durability, ModRarity rarity) {
        this(damage,durability,rarity,new BoomerangModifier());
    }

    public Boomerang(float damage, int durability, ModRarity rarity, BoomerangModifier boomerangModifier) {
        super(new Properties().stacksTo(1).durability(durability)
                .component(TCDataComponentTypes.MOD_RARITY, rarity)
                .component(ModDataComponentTypes.BOOMERANG_READY, SingleBooleanComponent.TRUE)
                .component(DataComponents.ATTRIBUTE_MODIFIERS, boomerangModifier.attributeModifiersBuilder.build())
        );
        this.boomerangModifier = boomerangModifier;
        this.boomerangModifier.damage = damage;
        this.boomerangModifier.proj = new BoomerangProjContainer(boomerangModifier);
    }

    public static boolean isBacked(ItemStack stack){
        if(stack == null || stack.get(ModDataComponentTypes.BOOMERANG_READY) == null) return true;
        return stack.get(ModDataComponentTypes.BOOMERANG_READY).value();
    }
    public static void setBacked(ItemStack stack, SingleBooleanComponent value){
        if(stack!= null && stack.get(ModDataComponentTypes.BOOMERANG_READY)!=null)
            stack.set(ModDataComponentTypes.BOOMERANG_READY, value);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {


        ItemStack stack = player.getItemInHand(usedHand);


        // 等待返回且未到达最大等待时间
        if(boomerangModifier.shouldWaitForBack && !isBacked(stack)
                 && player.getCooldowns().isOnCooldown(this)
        ) {
            return InteractionResultHolder.fail(stack);
        }
        // 冷却
        if(boomerangModifier.shouldApplyCd && player.getCooldowns().isOnCooldown(this))
            return InteractionResultHolder.fail(stack);



        if(level.isClientSide) {
            player.swing(InteractionHand.MAIN_HAND);
            return super.use(level, player, usedHand);
        }

        setBacked(stack,SingleBooleanComponent.FALSE);
        if(boomerangModifier.proj == null)
            return InteractionResultHolder.fail(stack);
        boomerangModifier.proj.genProjectile(player, stack);
        if(usedHand == InteractionHand.OFF_HAND) stack.hurtAndBreak(1, player, EquipmentSlot.OFFHAND);
        else stack.hurtAndBreak(1, player, EquipmentSlot.MAINHAND);
        if(boomerangModifier.shouldApplyCd )
            player.getCooldowns().addCooldown(this, boomerangModifier.cd);
        else player.getCooldowns().addCooldown(this, 100); //最大等待时间
        return super.use(level, player, usedHand);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if(boomerangModifier.inventoryTick!= null) boomerangModifier.inventoryTick.accept(stack,level,entity,isSelected);
    }

    @Override
    public boolean canContinueUsing(ItemStack oldStack, ItemStack newStack) {return false;}

    public static class BoomerangModifier {

        public float damage;
        public float flySpeed = 0.5f;               //向前飞行速度
        public float backSpeed = 0.5f;              //向后飞行速度//返回速度
        public float knockback = 1f;                //击退力度
        public int cd = 20;                         //冷却时间
        public int forwardTick = 20;                //前进时间
        public boolean canPenetrate = false;        //是否可穿透，否则命中生物返回
        public boolean shouldWaitForBack = true;    //是否等待返回
        public boolean shouldApplyCd = false;       //是否应用冷却
        public boolean fire = false;                //是否渲染火焰


        private AbstractProjContainer proj;
        public List<BiConsumer<LivingEntity, LivingEntity>> onHitEffects = new ArrayList<>();
        public BaseSwordItem.QuaConsumer<ItemStack, Level, Entity, Boolean> inventoryTick;
        public ItemAttributeModifiers.Builder attributeModifiersBuilder = ItemAttributeModifiers.builder();
        private int modifyCount = 0;


        /**
         * 添加击中效果
         *
         * @see EffectStrategy
         */
        public BoomerangModifier addOnHitEffect(BiConsumer<LivingEntity, LivingEntity> onHit) {
            this.onHitEffects.add(onHit);
            return this;
        }

        /**
         * 添加属性修改器
         */
        public BoomerangModifier addAttributeModifier(Holder<Attribute> attribute, float amount, AttributeModifier.Operation operation) {
            this.attributeModifiersBuilder.add(attribute, new AttributeModifier(Confluence.asResource("boomerang.modifier." + modifyCount++), amount, operation), EquipmentSlotGroup.MAINHAND);
            return this;
        }

        /**
         * 背包每刻效果
         *
         * @see InventoryTickStrategy
         */
        public BoomerangModifier setInventoryTick(BaseSwordItem.QuaConsumer<ItemStack, Level, Entity, Boolean> inventoryTick) {
            this.inventoryTick = inventoryTick;
            return this;
        }

        /**
         * 设置可穿透
         */
        public BoomerangModifier setCanPenetrate() {
            this.canPenetrate = true;
            return this;
        }

        /**
         * 设置前进时间
         */
        public BoomerangModifier setForwardTick(int forwardTick) {
            this.forwardTick = forwardTick;
            return this;
        }
        /**
         * 设置渲染火焰
         */
        public BoomerangModifier setFire() {
            this.fire = true;
            return this;
        }

        /**
         * 设置冷却时间
         */
        public BoomerangModifier setCd(int cd) {
            this.cd = cd;
            this.shouldApplyCd = true;
            return this;
        }

        /**
         * 设置不等待返回
         */
        public BoomerangModifier setNotWaitForBack() {
            this.shouldWaitForBack = false;
            return this;
        }
        /**
         * 设置击退力度
         */
        public BoomerangModifier setKnockbackFactor(float knockback) {
            this.knockback *= knockback;
            return this;
        }

    }




}

