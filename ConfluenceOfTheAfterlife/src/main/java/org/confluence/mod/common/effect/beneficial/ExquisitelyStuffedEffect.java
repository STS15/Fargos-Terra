package org.confluence.mod.common.effect.beneficial;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import org.confluence.mod.Confluence;
import org.confluence.terra_curio.common.init.TCAttributes;

public class ExquisitelyStuffedEffect extends MobEffect {   //吃得好/很满意/酒足饭饱
    public static final ResourceLocation ID = Confluence.asResource("exquisitely_stuffed");

    //TODO 召唤物伤害 仆从击退
    public ExquisitelyStuffedEffect() {
        super(MobEffectCategory.BENEFICIAL, 0xFFFF00);
        addAttributeModifier(Attributes.MOVEMENT_SPEED, ID, AttributeModifier.Operation.ADD_VALUE, v -> switch (v) {
            case 2 -> 0.3;
            case 3 -> 0.4;
            default -> 0.2;
        });
        addAttributeModifier(Attributes.ARMOR, ID, AttributeModifier.Operation.ADD_VALUE, v -> switch (v) {
            case 2 -> 3;
            case 3 -> 4;
            default -> 2;
        });
        addAttributeModifier(TCAttributes.getCriticalChance(), ID, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, v -> switch (v) {
            case 2 -> 0.03;
            case 3 -> 0.04;
            default -> 0.02;
        });
        addAttributeModifier(Attributes.ATTACK_SPEED, ID, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, v -> switch (v) {
            case 2 -> 0.075;
            case 3 -> 0.10;
            default -> 0.05;
        });
        addAttributeModifier(Attributes.ATTACK_DAMAGE, ID, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, v -> switch (v) {
            case 2 -> 0.075;
            case 3 -> 0.1;
            default -> 0.05;
        });
        addAttributeModifier(Attributes.BLOCK_BREAK_SPEED, ID, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, v -> switch (v) {
            case 2 -> 0.3;
            case 3 -> 0.15;
            default -> 0.05;
        });
    }
}
