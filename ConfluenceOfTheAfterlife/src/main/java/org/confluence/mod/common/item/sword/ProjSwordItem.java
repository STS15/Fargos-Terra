package org.confluence.mod.common.item.sword;

import net.minecraft.world.item.Tier;
import org.confluence.mod.common.item.sword.stagedy.projectile.AbstractProjContainer;
import org.confluence.mod.terra_curio.common.component.ModRarity;

public class ProjSwordItem extends BaseSwordItem {
    public ProjSwordItem(Tier tier, ModRarity rarity, int rawDamage, float rawSpeed, AbstractProjContainer proj) {
        super(tier, rarity, rawDamage ,rawSpeed);
        this.modifier.proj = proj;
    }

}
