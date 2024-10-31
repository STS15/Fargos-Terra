package org.confluence.mod.common.item.sword;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import org.confluence.mod.common.item.sword.stagedy.projectile.AbstractProjContainer;
import org.confluence.mod.terra_curio.common.component.ModRarity;
import org.confluence.mod.terra_curio.common.init.TCDataComponentTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;



public class BaseSwordItem extends SwordItem {
    public ModifierBuilder modifier = new ModifierBuilder();
    public BaseSwordItem(Tier tier, Properties properties) {
        super(tier, properties);
    }
    public BaseSwordItem(Tier tier, ModRarity rarity, int rawDamage, float rawSpeed) {
        super(tier, new Item.Properties()
                .component(DataComponents.ATTRIBUTE_MODIFIERS,createAttributes(tier,rawDamage,rawSpeed))
                .component(TCDataComponentTypes.MOD_RARITY, rarity)
        );
    }
    public BaseSwordItem(Tier tier, ModRarity rarity, int rawDamage, float rawSpeed, ModifierBuilder modifier) {
        super(tier, new Item.Properties()
                .component(DataComponents.ATTRIBUTE_MODIFIERS,createAttributes(tier,rawDamage,rawSpeed))
                .component(TCDataComponentTypes.MOD_RARITY, rarity)
        );
        this.modifier = modifier;
    }
    /**
     * 预测灌注要用到这个类
     */
    public static class ModifierBuilder {
        public List<Consumer<LivingEntity>> onHitEffects = new ArrayList<>();
        public AbstractProjContainer proj;
        public ModifierBuilder addOnHitEffect(Consumer<LivingEntity> onHit){
            this.onHitEffects.add(onHit);
            return this;
        }
        public ModifierBuilder setProj(AbstractProjContainer proj){
            this.proj = proj;
            return this;
        }
    }
}
