package org.confluence.mod.common.item.sword;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import org.confluence.terra_curio.common.component.ModRarity;
import org.jetbrains.annotations.NotNull;

public class ShortSwordItem extends BaseSwordItem {
    public ShortSwordItem(Tier tier, ModRarity rarity, int rawDamage, float rawSpeed) {
        super(tier, rarity, (int) (rawDamage - tier.getAttackDamageBonus() - 1), rawSpeed - 4);
    }

    @Override
    public boolean canPerformAction(@NotNull ItemStack stack, @NotNull ItemAbility itemAbility) {
        // deny sweep
        return itemAbility == ItemAbilities.SWORD_DIG;
    }
}
