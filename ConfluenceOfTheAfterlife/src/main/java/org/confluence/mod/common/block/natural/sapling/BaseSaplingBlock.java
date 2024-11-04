package org.confluence.mod.common.block.natural.sapling;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import org.confluence.mod.common.data.gen.limit.CustomItemModel;
import org.confluence.mod.common.data.gen.limit.CustomModel;
import org.jetbrains.annotations.NotNull;

public class BaseSaplingBlock extends SaplingBlock implements CustomModel, CustomItemModel {
    private final Block block;

    public BaseSaplingBlock(TreeGrower pTreeGrower, Properties pProperties, Block block) {
        super(pTreeGrower, pProperties);
        this.block = block;
    }

    @Override
    public boolean canSurvive(@NotNull BlockState pState, LevelReader pLevel, BlockPos pPos) {
        BlockPos below = pPos.below();
        BlockState blockBelow = pLevel.getBlockState(below);
        return blockBelow.is(block);
    }
}
