package org.confluence.mod.common.item.pickaxe;

import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;

public class BasePickaxeItem extends PickaxeItem {
    public BasePickaxeItem(Tier tier, float rawDamage, float rawSpeed) {
        this(tier, rawDamage, rawSpeed, new Properties());
    }

    public BasePickaxeItem(Tier tier, float rawDamage, float rawSpeed, Properties properties) {
        super(tier, properties.attributes(createAttributes(tier, rawDamage - tier.getAttackDamageBonus() - 1.0F, rawSpeed - 4.0F)));
    }
}
