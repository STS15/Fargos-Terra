package org.confluence.mod.common.item.bow;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import org.confluence.mod.common.entity.projectile.BaseArrowEntity;
import org.confluence.terra_curio.common.component.ModRarity;
import org.confluence.terra_curio.common.init.TCDataComponentTypes;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class TerraBowItem extends BowItem {

    public Consumer<BaseArrowEntity.Builder> modifyArrowBuilder;
    public float baseDamage;
    public TerraBowItem(float baseDamage, int durability, ModRarity rarity) {
        super(new Properties().durability(durability)
                .component(TCDataComponentTypes.MOD_RARITY, rarity));
        this.baseDamage = baseDamage;
    }
    public TerraBowItem(float baseDamage, int durability, ModRarity rarity,Consumer<BaseArrowEntity.Builder> modifyArrowBuilder) {
        this(baseDamage, durability, rarity);
        this.modifyArrowBuilder = modifyArrowBuilder;
        this.baseDamage = baseDamage;
    }

    @Override
    public @NotNull MutableComponent getName(@NotNull ItemStack pStack) {
        return Component.translatable(getDescriptionId()).withStyle(style -> style.withColor(pStack.get(TCDataComponentTypes.MOD_RARITY).getColor()));
    }

    @Override
    public @NotNull AbstractArrow customArrow(AbstractArrow arrow, ItemStack projectileStack, ItemStack weaponStack) {
        arrow.setBaseDamage(baseDamage);
        return arrow;
    }
}
