package org.confluence.mod.common.item.sword;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import org.confluence.mod.terra_curio.common.component.ModRarity;
import org.confluence.mod.terra_curio.common.init.ModDataComponentTypes;

public class HighAttackSpeedSwordItem extends SwordItem {
    public HighAttackSpeedSwordItem(Tier tier, int attackDamage, float attackSpeed, ModRarity rarity) {
        super(tier, new Item.Properties()
            .component(DataComponents.ATTRIBUTE_MODIFIERS, createAttributes(tier, attackDamage, attackSpeed))
            .component(ModDataComponentTypes.MOD_RARITY, rarity));
    }
}
