package org.confluence.mod.common.item.mana;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.confluence.mod.common.attachment.ManaStorage;
import org.confluence.mod.common.init.ModAttachments;
import org.confluence.mod.common.item.CustomRarityItem;
import org.confluence.terra_curio.common.component.ModRarity;
import org.jetbrains.annotations.NotNull;

public class ArcaneCrystalItem extends CustomRarityItem {
    public ArcaneCrystalItem() {
        super(ModRarity.LIGHT_PURPLE);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand usedHand) {
        if (level.isClientSide) {
            player.playSound(SoundEvents.BELL_BLOCK);
        }
        ItemStack itemStack = player.getItemInHand(usedHand);
        if (player instanceof ServerPlayer serverPlayer) {
            ManaStorage manaStorage = player.getData(ModAttachments.MANA_STORAGE);
            if (manaStorage.setArcaneCrystalUsed()) {
                CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, itemStack);
                itemStack.shrink(1);
            }
        }
        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide);
    }
}
