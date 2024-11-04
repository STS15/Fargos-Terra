package org.confluence.mod.common.block.natural.sapling;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import org.confluence.mod.common.data.gen.limit.CustomItemModel;
import org.confluence.mod.common.data.gen.limit.CustomModel;
import org.confluence.mod.common.init.block.ModBlocks;
import org.jetbrains.annotations.NotNull;

public class AshSaplingBlock extends SaplingBlock implements CustomModel, CustomItemModel {
    public AshSaplingBlock(TreeGrower pTreeGrower, Properties pProperties) {
        super(pTreeGrower, pProperties);
    }

    @Override
    public boolean canSurvive(@NotNull BlockState pState, LevelReader pLevel, BlockPos pPos) {
        BlockPos below = pPos.below();
        BlockState blockBelow = pLevel.getBlockState(below);
        return blockBelow.is(ModBlocks.ASH_BLOCK.get()) || blockBelow.is(ModBlocks.ASH_GRASS_BLOCK.get());
    }
}
