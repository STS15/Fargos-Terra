package org.confluence.mod.common.block.common;

import com.mojang.serialization.MapCodec;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractCauldronBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import org.confluence.mod.common.init.ModTags;
import org.confluence.mod.common.init.block.ModBlocks;
import org.confluence.mod.common.init.block.NatureBlocks;
import org.jetbrains.annotations.NotNull;

public class AetheriumCauldronBlock extends AbstractCauldronBlock {
    public static final MapCodec<AetheriumCauldronBlock> CODEC = simpleCodec(AetheriumCauldronBlock::new);
    public static final CauldronInteraction.InteractionMap DO_NOTHING = Util.make(CauldronInteraction.newInteractionMap("confluence_do_nothing"), map -> {});
    public static final CauldronInteraction FILL_AETHERIUM = (blockState, level, blockPos, player, hand, itemStack) -> {
        if (!level.isClientSide) {
            boolean bottomless = itemStack.is(ModTags.Items.BOTTOMLESS);
            ItemStack filledStack = bottomless ? itemStack : NatureBlocks.AETHERIUM_BLOCK.toStack();
            if (!bottomless) player.setItemInHand(hand, ItemStack.EMPTY);
            player.awardStat(Stats.FILL_CAULDRON);
            player.awardStat(Stats.ITEM_USED.get(filledStack.getItem()));
            level.setBlockAndUpdate(blockPos, ModBlocks.AETHERIUM_CAULDRON.get().defaultBlockState());
            level.playSound(null, blockPos, SoundEvents.AMETHYST_BLOCK_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
            level.gameEvent(null, GameEvent.FLUID_PLACE, blockPos);
        }
        return ItemInteractionResult.sidedSuccess(level.isClientSide);
    };

    public AetheriumCauldronBlock(Properties properties) {
        super(properties, DO_NOTHING);
    }

    @Override
    protected @NotNull MapCodec<AetheriumCauldronBlock> codec() {
        return CODEC;
    }

    @Override
    public boolean isFull(@NotNull BlockState state) {
        return true;
    }

    @Override
    protected @NotNull ItemInteractionResult useItemOn(@NotNull ItemStack stack, @NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hitResult) {
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Override
    protected @NotNull InteractionResult useWithoutItem(@NotNull BlockState state, Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull BlockHitResult hitResult) {
        if (!level.isClientSide) {
            ItemStack filledStack = NatureBlocks.AETHERIUM_BLOCK.toStack();
            if (player.hasInfiniteMaterials()) {
                if (!player.getInventory().contains(filledStack)) {
                    player.getInventory().add(filledStack);
                }
            } else {
                if (!player.getInventory().add(filledStack)) {
                    player.drop(filledStack, false);
                }
            }
            player.awardStat(Stats.USE_CAULDRON);
            level.setBlockAndUpdate(pos, Blocks.CAULDRON.defaultBlockState());
            level.playSound(null, pos, SoundEvents.AMETHYST_BLOCK_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
            level.gameEvent(null, GameEvent.FLUID_PICKUP, pos);
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }
}
