package org.confluence.mod.common.item.bow;

import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import org.confluence.mod.common.entity.projectile.BaseArrowEntity;
import org.confluence.terra_curio.common.component.ModRarity;
import org.confluence.terra_curio.common.init.TCDataComponentTypes;

import java.util.function.Consumer;


public class RoutineBowItem extends TerraBowItem {
    private final float baseDamage;

    public RoutineBowItem(float baseDamage, int durability, ModRarity rarity) {
        super(baseDamage, durability, rarity);
        this.baseDamage = baseDamage;
    }

    public RoutineBowItem(float baseDamage, int durability, ModRarity rarity, Consumer<BaseArrowEntity.Builder> builder) {
        super(baseDamage, durability, rarity, builder);
        this.baseDamage = baseDamage;
    }
    @Override
    public AbstractArrow customArrow(AbstractArrow arrow, ItemStack projectileStack, ItemStack weaponStack) {
        arrow.setBaseDamage(baseDamage);
        return arrow;
    }

}
