package org.confluence.mod.common.block.natural;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

import static net.minecraft.world.level.block.state.properties.BlockStateProperties.LAYERS;

public class SandLayerBlock extends Block {
    protected static final VoxelShape[] SHAPE_BY_LAYER = new VoxelShape[]{
        Shapes.empty(), box(0.0, 0.0, 0.0, 16.0, 2.0, 16.0), box(0.0, 0.0, 0.0, 16.0, 4.0, 16.0),
        box(0.0, 0.0, 0.0, 16.0, 6.0, 16.0), box(0.0, 0.0, 0.0, 16.0, 8.0, 16.0),
        box(0.0, 0.0, 0.0, 16.0, 10.0, 16.0), box(0.0, 0.0, 0.0, 16.0, 12.0, 16.0),
        box(0.0, 0.0, 0.0, 16.0, 14.0, 16.0), box(0.0, 0.0, 0.0, 16.0, 16.0, 16.0)
    };

    public SandLayerBlock() {
        super(Properties.of().sound(SoundType.SAND));
        this.registerDefaultState(this.defaultBlockState().setValue(LAYERS, 1));
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return SHAPE_BY_LAYER[state.getValue(LAYERS)];
    }

    @Override
    public @NotNull VoxelShape getCollisionShape(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return SHAPE_BY_LAYER[state.getValue(LAYERS) - 1];
    }

    @Override
    public boolean useShapeForLightOcclusion(@NotNull BlockState state) {
        return true;
    }

    @Override
    public float getShadeBrightness(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos) {
        return state.getValue(LAYERS) == 8 ? 0.2F : 1.0F;
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext UseContext) {
        int StackLayers = state.getValue(LAYERS);
        if (UseContext.getItemInHand().is(asItem()) && StackLayers < 8) {
            if (UseContext.replacingClickedOnBlock()) {
                return UseContext.getClickedFace() == Direction.UP;
            } else {
                return true;
            }
        } else {
            return StackLayers == 1;
        }
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = context.getLevel().getBlockState(context.getClickedPos());
        if (state.is(this) && state.getValue(LAYERS) < 8) {
            return state.cycle(LAYERS);
        } else {
            return super.getStateForPlacement(context);
        }
    }

    @Override
    public boolean canSurvive(@NotNull BlockState state, LevelReader level, BlockPos pos) {
        BlockState below = level.getBlockState(pos.below());
        return below.is(this) || !below.isAir();
    }

    @Override
    public @NotNull BlockState updateShape(BlockState state, @NotNull Direction facing, @NotNull BlockState facingState, @NotNull LevelAccessor level, @NotNull BlockPos CurrentPos, @NotNull BlockPos facingPos) {
        return !state.canSurvive(level, CurrentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, facing, facingState, level, CurrentPos, facingPos);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LAYERS);
    }
}
