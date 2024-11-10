package org.confluence.mod.common.block.natural;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.common.IShearable;
import org.confluence.mod.common.init.block.ModBlocks;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class  PalmLeaves extends Block implements SimpleWaterloggedBlock, IShearable {
    public static final EnumProperty<PalmLeaves.Type> TYPE = EnumProperty.create("type", PalmLeaves.Type.class);
    public static final BooleanProperty PLACE = BooleanProperty.create("place");
    public static final IntegerProperty DISTANCE = IntegerProperty.create("distance", 1, 8);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public PalmLeaves() {
        super(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).ignitedByLava().randomTicks());
        registerDefaultState(this.stateDefinition.any().setValue(PLACE, false).setValue(DISTANCE, 1).setValue(WATERLOGGED, false).setValue(TYPE, PalmLeaves.Type.NORMAL));
    }

    @Override
    public void setPlacedBy(@NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state, @Nullable LivingEntity placer, @NotNull ItemStack stack) {
        if (placer instanceof Player) {
            level.setBlock(pos, state.setValue(PLACE, true), 3);
        }
    }

    @Override
    protected void randomTick(@NotNull BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource random) {
        int min = 8;
        for (Direction direction : Direction.values()) {
            BlockPos blockPos = pos.relative(direction);
            BlockState neighborState = level.getBlockState(blockPos);
            if (neighborState.is(ModBlocks.ASH_LOG_BLOCKS.getWood()) || neighborState.is(ModBlocks.ASH_LOG_BLOCKS.getLog())) {
                min = 0;
                break;
            } else if (neighborState.is(this)) {
                int distance = neighborState.getValue(DISTANCE);
                if (distance < min) {
                    min = distance;
                }
            }
        }

        if (min < 8) {
            level.setBlockAndUpdate(pos, state.setValue(DISTANCE, min + 1));
        } else {
            boolean place = state.getValue(PLACE);
            if (state.getValue(DISTANCE) == 8 && !place) {
                level.removeBlock(pos, false);
            } else {
                level.setBlock(pos, state.setValue(DISTANCE, min), 3);
            }
        }
    }


    @Override
    protected @NotNull FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    protected @NotNull BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }
        return state;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        return this.defaultBlockState().setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);
    }


    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(DISTANCE, PLACE, WATERLOGGED, TYPE);
    }

    public enum Type implements StringRepresentable {
        NORMAL("normal"),
        TOP("top"),
        BOTTOM("bottom");

        private final String name;

        Type(String name) {
            this.name = name;
        }

        @Override
        public @NotNull String getSerializedName() {
            return name;
        }
    }
}
