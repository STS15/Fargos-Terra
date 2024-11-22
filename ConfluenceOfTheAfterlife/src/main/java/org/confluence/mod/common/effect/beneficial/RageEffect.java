package org.confluence.mod.common.effect.beneficial;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import org.confluence.mod.Confluence;
import org.confluence.terra_curio.common.init.TCAttributes;

public class RageEffect extends MobEffect {
    public static final ResourceLocation ID = Confluence.asResource("rage");

    public RageEffect() {
        super(MobEffectCategory.BENEFICIAL, 0xFF4500);
        addAttributeModifier(TCAttributes.getCriticalChance(), ID, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
    }
}
