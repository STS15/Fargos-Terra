package org.confluence.mod.common.item.axe;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Tier;
import org.confluence.mod.common.data.gen.limit.Image24x;

public class BaseAxeItem extends AxeItem {

    public BaseAxeItem(Tier tier, float rawDamage, float rawSpeed) {
        super(tier, new Properties()
            .component(DataComponents.ATTRIBUTE_MODIFIERS, createAttributes(tier, (rawDamage - tier.getAttackDamageBonus() - 1), rawSpeed - 4)));
    }

    public static class BigAxeItem extends AxeItem implements Image24x {
        public BigAxeItem(Tier tier, float rawDamage, float rawSpeed) {
            super(tier, new Properties()
                .component(DataComponents.ATTRIBUTE_MODIFIERS, createAttributes(tier, (rawDamage - tier.getAttackDamageBonus() - 1), rawSpeed - 4)));
        }
    }
}

