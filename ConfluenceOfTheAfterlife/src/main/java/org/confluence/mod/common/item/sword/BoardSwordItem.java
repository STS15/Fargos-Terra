package org.confluence.mod.common.item.sword;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.phys.AABB;
import org.confluence.mod.terra_curio.common.component.ModRarity;
import org.confluence.mod.terra_curio.common.init.ModDataComponentTypes;
import org.jetbrains.annotations.NotNull;

public class BoardSwordItem extends BaseSwordItem {
    public BoardSwordItem(Tier tier, ModRarity rarity, int rawDamage, float rawSpeed) {
        super(tier, rarity, (int) (rawDamage - tier.getAttackDamageBonus() - 1), rawSpeed - 4);
    }

    @Override
    public @NotNull AABB getSweepHitBox(@NotNull ItemStack stack, @NotNull Player player, @NotNull Entity target) {
        return target.getBoundingBox().inflate(1.5D, 0.5D, 1.5D);
    }
}
