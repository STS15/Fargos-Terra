package org.confluence.mod.common.block.common;

import com.mojang.serialization.MapCodec;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractCauldronBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.confluence.mod.common.init.block.ModBlocks;
import org.confluence.mod.common.init.item.ToolItems;
import org.confluence.terra_curio.common.init.TCEffects;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class HoneyCauldronBlock extends AbstractCauldronBlock {
    public static final MapCodec<HoneyCauldronBlock> CODEC = simpleCodec(HoneyCauldronBlock::new);
    public static final CauldronInteraction.InteractionMap INTERACTION_MAP = Util.make(CauldronInteraction.newInteractionMap("confluence_honey"), map -> {
        Map<Item, CauldronInteraction> interactionMap = map.map();
        interactionMap.put(Items.BUCKET, (blockState, level, blockPos, player, hand, itemStack) -> CauldronInteraction.fillBucket(
                blockState, level, blockPos, player, hand, itemStack,
                ToolItems.HONEY_BUCKET.get().getDefaultInstance(),
                blockState1 -> true,
                SoundEvents.BUCKET_FILL
        ));
        CauldronInteraction.addDefaultInteractions(interactionMap);
    });
    public static final CauldronInteraction FILL_HONEY = (blockState, level, blockPos, player, hand, itemStack) -> CauldronInteraction.emptyBucket(
            level, blockPos, player, hand, itemStack,
            ModBlocks.HONEY_CAULDRON.get().defaultBlockState(),
            SoundEvents.BUCKET_EMPTY_LAVA
    );

    public HoneyCauldronBlock(Properties properties) {
        super(properties, INTERACTION_MAP);
    }

    @Override
    public @NotNull MapCodec<HoneyCauldronBlock> codec() {
        return CODEC;
    }

    @Override
    protected double getContentHeight(@NotNull BlockState blockState) {
        return 0.9375;
    }

    @Override
    public boolean isFull(@NotNull BlockState blockState) {
        return true;
    }

    @Override
    protected void entityInside(@NotNull BlockState blockState, Level level, @NotNull BlockPos blockPos, @NotNull Entity entity) {
        if (!level.isClientSide && isEntityInsideContent(blockState, blockPos, entity) && entity instanceof LivingEntity living) {
            if (living instanceof Animal || living instanceof ServerPlayer) {
                living.addEffect(new MobEffectInstance(TCEffects.HONEY, 600));
            }
        }
    }

    @Override
    protected int getAnalogOutputSignal(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos) {
        return 3;
    }
}
