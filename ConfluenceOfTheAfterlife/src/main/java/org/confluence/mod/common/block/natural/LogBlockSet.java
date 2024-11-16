package org.confluence.mod.common.block.natural;

import net.minecraft.core.BlockPos;
import net.minecraft.data.models.blockstates.PropertyDispatch;
import net.minecraft.data.tags.IntrinsicHolderTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import org.confluence.mod.Confluence;
import org.confluence.mod.common.data.gen.ModBlockTagsProvider;
import org.confluence.mod.common.init.block.ModBlocks;
import org.confluence.mod.common.init.item.ModItems;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import static org.confluence.mod.common.init.block.ModBlocks.registerWithItem;
import static org.confluence.mod.common.init.block.ModBlocks.registerWithoutItem;

public class LogBlockSet {
    private static final Map<Supplier<? extends Block>, Supplier<? extends Block>> STRIP_TABLE = new Hashtable<>();
    public static final Map<Block, Block> WRAPPED_STRIP_TABLE = new Hashtable<>();
    public static final List<LogBlockSet> LOG_BLOCK_SETS = new ArrayList<>();
    private static SignBlock[] SIGN_BLOCKS;

    private final Builder builder;

    LogBlockSet(Builder builder) {
        this.builder = builder;
    }

    public static Builder builder(String id, boolean ignitedByLava, Supplier<Block> planksSupplier) {
        return new Builder(id, ignitedByLava, planksSupplier);
    }

    public static Builder builder(String id, boolean ignitedByLava) {
        return new Builder(id, ignitedByLava);
    }

    public @NotNull DeferredBlock<Block> getPlanks() {
        return builder.PLANKS;
    }

    public DeferredBlock<RotatedPillarBlock> getLog() {
        return builder.LOG;
    }

    public DeferredBlock<RotatedPillarBlock> getStrippedLog() {
        return builder.STRIPPED_LOG;
    }

    public DeferredBlock<LeavesBlock> getLeaves() {
        return builder.LEAVES;
    }

    public DeferredBlock<RotatedPillarBlock> getWood() {
        return builder.WOOD;
    }

    public DeferredBlock<RotatedPillarBlock> getStrippedWood() {
        return builder.STRIPPED_WOOD;
    }

    public DeferredBlock<ButtonBlock> getButton() {
        return builder.BUTTON;
    }

    public DeferredBlock<FenceBlock> getFence() {
        return builder.FENCE;
    }

    public DeferredBlock<FenceGateBlock> getFenceGate() {
        return builder.FENCE_GATE;
    }

    public DeferredBlock<PressurePlateBlock> getPressurePlate() {
        return builder.PRESSURE_PLATE;
    }

    public DeferredBlock<SlabBlock> getSlab() {
        return builder.SLAB;
    }

    public DeferredBlock<StairBlock> getStairs() {
        return builder.STAIRS;
    }

    public DeferredBlock<StandingSignBlock> getSign() {
        return builder.SIGN;
    }

    public DeferredBlock<WallSignBlock> getWallSign() {
        return builder.WALL_SIGN;
    }

    public DeferredItem<SignItem> getSignItem() {
        return builder.SIGN_ITEM;
    }

    public DeferredBlock<TrapDoorBlock> getTrapdoor() {
        return builder.TRAPDOOR;
    }

    public DeferredBlock<DoorBlock> getDoor() {
        return builder.DOOR;
    }

    public static void acceptTags(ModBlockTagsProvider provider) {
        IntrinsicHolderTagsProvider.IntrinsicTagAppender<Block> completes = provider.tag(BlockTags.COMPLETES_FIND_TREE_TUTORIAL);
        IntrinsicHolderTagsProvider.IntrinsicTagAppender<Block> burn = provider.tag(BlockTags.LOGS_THAT_BURN);
        IntrinsicHolderTagsProvider.IntrinsicTagAppender<Block> logs = provider.tag(BlockTags.LOGS);
        IntrinsicHolderTagsProvider.IntrinsicTagAppender<Block> planks = provider.tag(BlockTags.PLANKS);
        IntrinsicHolderTagsProvider.IntrinsicTagAppender<Block> buttons = provider.tag(BlockTags.BUTTONS);
        IntrinsicHolderTagsProvider.IntrinsicTagAppender<Block> woodenButtons = provider.tag(BlockTags.WOODEN_BUTTONS);
        IntrinsicHolderTagsProvider.IntrinsicTagAppender<Block> stairs = provider.tag(BlockTags.STAIRS);
        IntrinsicHolderTagsProvider.IntrinsicTagAppender<Block> woodenStairs = provider.tag(BlockTags.WOODEN_STAIRS);
        IntrinsicHolderTagsProvider.IntrinsicTagAppender<Block> slabs = provider.tag(BlockTags.SLABS);
        IntrinsicHolderTagsProvider.IntrinsicTagAppender<Block> woodenSlabs = provider.tag(BlockTags.WOODEN_SLABS);
        IntrinsicHolderTagsProvider.IntrinsicTagAppender<Block> fences = provider.tag(BlockTags.FENCES);
        IntrinsicHolderTagsProvider.IntrinsicTagAppender<Block> woodenFences = provider.tag(BlockTags.WOODEN_FENCES);
        IntrinsicHolderTagsProvider.IntrinsicTagAppender<Block> forgeFences = provider.tag(Tags.Blocks.FENCES);
        IntrinsicHolderTagsProvider.IntrinsicTagAppender<Block> forgeFencesWooden = provider.tag(Tags.Blocks.FENCES_WOODEN);
        IntrinsicHolderTagsProvider.IntrinsicTagAppender<Block> fenceGates = provider.tag(BlockTags.FENCE_GATES);
        IntrinsicHolderTagsProvider.IntrinsicTagAppender<Block> forgeFenceGates = provider.tag(Tags.Blocks.FENCE_GATES);
        IntrinsicHolderTagsProvider.IntrinsicTagAppender<Block> forgeFenceGatesWooden = provider.tag(Tags.Blocks.FENCE_GATES_WOODEN);
        IntrinsicHolderTagsProvider.IntrinsicTagAppender<Block> trapdoors = provider.tag(BlockTags.TRAPDOORS);
        IntrinsicHolderTagsProvider.IntrinsicTagAppender<Block> woodenTrapdoors = provider.tag(BlockTags.WOODEN_TRAPDOORS);
        IntrinsicHolderTagsProvider.IntrinsicTagAppender<Block> woodenPressurePlates = provider.tag(BlockTags.WOODEN_PRESSURE_PLATES);
        IntrinsicHolderTagsProvider.IntrinsicTagAppender<Block> doors = provider.tag(BlockTags.DOORS);
        IntrinsicHolderTagsProvider.IntrinsicTagAppender<Block> woodenDoors = provider.tag(BlockTags.WOODEN_DOORS);
        IntrinsicHolderTagsProvider.IntrinsicTagAppender<Block> leaves = provider.tag(BlockTags.LEAVES);
        IntrinsicHolderTagsProvider.IntrinsicTagAppender<Block> signs = provider.tag(BlockTags.SIGNS);
        for (LogBlockSet logBlocks : LOG_BLOCK_SETS) {
            Builder builder1 = logBlocks.builder;
            planks.add(builder1.PLANKS.get());
            if (builder1.LOG != null) {
                RotatedPillarBlock value = builder1.LOG.get();
                completes.add(value);
                if (builder1.ignitedByLava) burn.add(value);
                logs.add(value);
            }
            if (builder1.STRIPPED_LOG != null) {
                RotatedPillarBlock value = builder1.STRIPPED_LOG.get();
                completes.add(value);
                if (builder1.ignitedByLava) burn.add(value);
                logs.add(value);
            }
            if (builder1.WOOD != null) {
                RotatedPillarBlock value = builder1.WOOD.get();
                completes.add(value);
                if (builder1.ignitedByLava) burn.add(value);
                logs.add(value);
            }
            if (builder1.STRIPPED_WOOD != null) {
                RotatedPillarBlock value = builder1.STRIPPED_WOOD.get();
                completes.add(value);
                if (builder1.ignitedByLava) burn.add(value);
                logs.add(value);
            }
            if (builder1.LEAVES != null) {
                LeavesBlock leavesBlock = builder1.LEAVES.get();
                completes.add(leavesBlock);
                leaves.add(leavesBlock);
            }
            if (builder1.BUTTON != null) {
                ButtonBlock buttonBlock = builder1.BUTTON.get();
                buttons.add(buttonBlock);
                woodenButtons.add(buttonBlock);
            }
            if (builder1.FENCE != null) {
                FenceBlock fenceBlock = builder1.FENCE.get();
                fences.add(fenceBlock);
                woodenFences.add(fenceBlock);
                forgeFences.add(fenceBlock);
                forgeFencesWooden.add(fenceBlock);
            }
            if (builder1.FENCE_GATE != null) {
                FenceGateBlock fenceGateBlock = builder1.FENCE_GATE.get();
                fenceGates.add(fenceGateBlock);
                forgeFenceGates.add(fenceGateBlock);
                forgeFenceGatesWooden.add(fenceGateBlock);
            }
            if (builder1.PRESSURE_PLATE != null) {
                PressurePlateBlock pressurePlateBlock = builder1.PRESSURE_PLATE.get();
                woodenPressurePlates.add(pressurePlateBlock);
            }
            if (builder1.SLAB != null) {
                SlabBlock slabBlock = builder1.SLAB.get();
                slabs.add(slabBlock);
                woodenSlabs.add(slabBlock);
            }
            if (builder1.STAIRS != null) {
                StairBlock stairBlock = builder1.STAIRS.get();
                stairs.add(stairBlock);
                woodenStairs.add(stairBlock);
            }
            if (builder1.SIGN != null) {
                signs.add(builder1.SIGN.get());
            }
            if (builder1.TRAPDOOR != null) {
                TrapDoorBlock trapDoorBlock = builder1.TRAPDOOR.get();
                trapdoors.add(trapDoorBlock);
                woodenTrapdoors.add(trapDoorBlock);
            }
            if (builder1.DOOR != null) {
                DoorBlock doorBlock = builder1.DOOR.get();
                doors.add(doorBlock);
                woodenDoors.add(doorBlock);
            }
        }
    }

    public static void acceptBuilding(CreativeModeTab.Output output) {
        for (LogBlockSet logBlocks : LOG_BLOCK_SETS) {
            Builder builder1 = logBlocks.builder;
            output.accept(builder1.PLANKS.get());
            if (builder1.STRIPPED_LOG != null) {
                output.accept(builder1.STRIPPED_LOG.get());
            }
            if (builder1.WOOD != null) {
                output.accept(builder1.WOOD.get());
            }
            if (builder1.STRIPPED_WOOD != null) {
                output.accept(builder1.STRIPPED_WOOD.get());
            }
            if (builder1.BUTTON != null) {
                output.accept(builder1.BUTTON.get());
            }
            if (builder1.FENCE != null) {
                output.accept(builder1.FENCE.get());
            }
            if (builder1.FENCE_GATE != null) {
                output.accept(builder1.FENCE_GATE.get());
            }
            if (builder1.PRESSURE_PLATE != null) {
                output.accept(builder1.PRESSURE_PLATE.get());
            }
            if (builder1.SLAB != null) {
                output.accept(builder1.SLAB.get());
            }
            if (builder1.STAIRS != null) {
                output.accept(builder1.STAIRS.get());
            }
            if (builder1.SIGN_ITEM != null) {
                output.accept(builder1.SIGN_ITEM.get());
            }
            if (builder1.TRAPDOOR != null) {
                output.accept(builder1.TRAPDOOR.get());
            }
            if (builder1.DOOR != null) {
                output.accept(builder1.DOOR.get());
            }
        }
    }

    public static void acceptNature(CreativeModeTab.Output output) {
        for (LogBlockSet logBlocks : LOG_BLOCK_SETS) {
            Builder builder1 = logBlocks.builder;
            if (builder1.LOG != null) {
                output.accept(builder1.LOG);
            }
            if (builder1.LEAVES != null) {
                output.accept(builder1.LEAVES);
            }
        }
    }

    public static void wrapStrip() {
        STRIP_TABLE.forEach((s1, s2) -> WRAPPED_STRIP_TABLE.put(s1.get(), s2.get()));
        STRIP_TABLE.clear();
    }

    public static SignBlock[] getSignBlocks() {
        if (SIGN_BLOCKS == null) {
            List<SignBlock> list = new ArrayList<>();
            for (LogBlockSet logBlockSet : LOG_BLOCK_SETS) {
                Builder builder1 = logBlockSet.builder;
                if (builder1.SIGN != null) {
                    list.add(builder1.SIGN.get());
                }
                if (builder1.WALL_SIGN != null) {
                    list.add(builder1.WALL_SIGN.get());
                }
            }
            SIGN_BLOCKS = list.toArray(SignBlock[]::new);
        }
        return SIGN_BLOCKS;
    }

    public static class Builder {
        private final String id;
        private final boolean ignitedByLava;
        private final DeferredBlock<Block> PLANKS;
        private DeferredBlock<RotatedPillarBlock> LOG;
        private DeferredBlock<RotatedPillarBlock> STRIPPED_LOG;
        private DeferredBlock<LeavesBlock> LEAVES;
        private DeferredBlock<RotatedPillarBlock> WOOD;
        private DeferredBlock<RotatedPillarBlock> STRIPPED_WOOD;
        private DeferredBlock<ButtonBlock> BUTTON;
        private DeferredBlock<FenceBlock> FENCE;
        private DeferredBlock<FenceGateBlock> FENCE_GATE;
        private DeferredBlock<PressurePlateBlock> PRESSURE_PLATE;
        private DeferredBlock<SlabBlock> SLAB;
        private DeferredBlock<StairBlock> STAIRS;
        private DeferredBlock<StandingSignBlock> SIGN;
        private DeferredBlock<WallSignBlock> WALL_SIGN;
        private DeferredItem<SignItem> SIGN_ITEM;
        private DeferredBlock<TrapDoorBlock> TRAPDOOR;
        private DeferredBlock<DoorBlock> DOOR;

        public Builder(String id, boolean ignitedByLava, Supplier<Block> planksSupplier) {
            this.id = id;
            this.ignitedByLava = ignitedByLava;
            this.PLANKS = registerWithItem(id, planksSupplier);
        }

        public Builder(String id, boolean ignitedByLava) {
            this.id = id;
            this.ignitedByLava = ignitedByLava;
            BlockBehaviour.Properties planks = BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD);
            this.PLANKS = registerWithItem(id + "_planks", () -> new Block(ignitedByLava ? planks.ignitedByLava() : planks));
        }

        public Builder createDefault(WoodSetType woodSetType, boolean requireTree) {
            if (requireTree) log(RotatedPillarBlock::new)
                    .strippedLog(RotatedPillarBlock::new)
                    .wood(RotatedPillarBlock::new)
                    .strippedWood(RotatedPillarBlock::new)
                    .leaves(LeavesBlock::new);
            button(properties -> new ButtonBlock(woodSetType.SET, 30, properties))
                    .fence(FenceBlock::new)
                    .fenceGate(properties -> new FenceGateBlock(woodSetType.TYPE, properties))
                    .pressurePlate(properties -> new PressurePlateBlock(woodSetType.SET, properties))
                    .slab(SlabBlock::new)
                    .stair(StairBlock::new)
                    .sign(properties -> new ModStandingSignBlock(woodSetType.TYPE, properties), properties -> new ModWallSignBlock(woodSetType.TYPE, properties), SignItem::new)
                    .trapdoor(properties -> new TrapDoorBlock(woodSetType.SET, properties))
                    .door(properties -> new DoorBlock(woodSetType.SET, properties));
            return this;
        }

        public Builder log(Function<BlockBehaviour.Properties, ? extends RotatedPillarBlock> function) {
            BlockBehaviour.Properties log = BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD);
            this.LOG = registerWithItem(id + "_log", () -> function.apply(ignitedByLava ? log.ignitedByLava() : log));
            return this;
        }

        public Builder strippedLog(Function<BlockBehaviour.Properties, ? extends RotatedPillarBlock> function) {
            if (LOG == null) log(function);
            this.STRIPPED_LOG = registerWithItem(id + "_stripped_log", () -> function.apply(BlockBehaviour.Properties.ofFullCopy(LOG.get())));
            STRIP_TABLE.put(LOG, STRIPPED_LOG);
            return this;
        }

        public Builder leaves(Function<BlockBehaviour.Properties, ? extends LeavesBlock> function) {
            BlockBehaviour.Properties leaves = BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(Builder::valid).isSuffocating(Builder::never).isViewBlocking(Builder::never).pushReaction(PushReaction.DESTROY).isRedstoneConductor(Builder::never);
            this.LEAVES = registerWithItem(id + "_leaves", () -> function.apply(ignitedByLava ? leaves.ignitedByLava() : leaves));
            return this;
        }

        public Builder wood(Function<BlockBehaviour.Properties, ? extends RotatedPillarBlock> function) {
            BlockBehaviour.Properties wood = BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD);
            this.WOOD = registerWithItem(id + "_wood", () -> function.apply(ignitedByLava ? wood.ignitedByLava() : wood));
            return this;
        }

        public Builder strippedWood(Function<BlockBehaviour.Properties, ? extends RotatedPillarBlock> function) {
            if (WOOD == null) wood(function);
            this.STRIPPED_WOOD = registerWithItem(id + "_stripped_wood", () -> function.apply(BlockBehaviour.Properties.ofFullCopy(WOOD.get())));
            STRIP_TABLE.put(WOOD, STRIPPED_WOOD);
            return this;
        }

        public Builder button(Function<BlockBehaviour.Properties, ? extends ButtonBlock> function) {
            BlockBehaviour.Properties button = BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY);
            this.BUTTON = registerWithItem(id + "_button", () -> function.apply(button));
            return this;
        }

        public Builder fence(Function<BlockBehaviour.Properties, ? extends FenceBlock> function) {
            BlockBehaviour.Properties fence = BlockBehaviour.Properties.of().forceSolidOn().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD);
            this.FENCE = registerWithItem(id + "_fence", () -> function.apply(ignitedByLava ? fence.mapColor(PLANKS.get().defaultMapColor()).ignitedByLava() : fence.mapColor(PLANKS.get().defaultMapColor())));
            return this;
        }

        public Builder fenceGate(Function<BlockBehaviour.Properties, ? extends FenceGateBlock> function) {
            BlockBehaviour.Properties fence_gate = BlockBehaviour.Properties.of().forceSolidOn().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F);
            this.FENCE_GATE = registerWithItem(id + "_fence_gate", () -> function.apply(ignitedByLava ? fence_gate.mapColor(PLANKS.get().defaultMapColor()).ignitedByLava() : fence_gate.mapColor(PLANKS.get().defaultMapColor())));
            return this;
        }

        public Builder pressurePlate(Function<BlockBehaviour.Properties, ? extends PressurePlateBlock> function) {
            BlockBehaviour.Properties pressure_plate = BlockBehaviour.Properties.of().forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY);
            this.PRESSURE_PLATE = registerWithItem(id + "_pressure_plate", () -> function.apply(ignitedByLava ? pressure_plate.mapColor(PLANKS.get().defaultMapColor()).ignitedByLava() : pressure_plate.mapColor(PLANKS.get().defaultMapColor())));
            return this;
        }

        public Builder slab(Function<BlockBehaviour.Properties, ? extends SlabBlock> function) {
            BlockBehaviour.Properties slab = BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD);
            this.SLAB = registerWithItem(id + "_slab", () -> function.apply(ignitedByLava ? slab.ignitedByLava() : slab));
            return this;
        }

        public Builder stair(BiFunction<BlockState, BlockBehaviour.Properties, ? extends StairBlock> function) {
            this.STAIRS = registerWithItem(id + "_stairs", () -> function.apply(PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(PLANKS.get())));
            return this;
        }

        public Builder sign(Function<BlockBehaviour.Properties, ? extends StandingSignBlock> standingSign, Function<BlockBehaviour.Properties, ? extends WallSignBlock> wallSign, PropertyDispatch.TriFunction<Item.Properties, StandingSignBlock, WallSignBlock, ? extends SignItem> signItem) {
            BlockBehaviour.Properties sign = BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F);
            this.SIGN = registerWithoutItem(id + "_sign", () -> standingSign.apply(ignitedByLava ? sign.ignitedByLava() : sign));
            BlockBehaviour.Properties wall_sign = BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).lootFrom(SIGN);
            this.WALL_SIGN = registerWithoutItem(id + "_wall_sign", () -> wallSign.apply(ignitedByLava ? wall_sign.ignitedByLava() : wall_sign));
            this.SIGN_ITEM = ModItems.BLOCK_ITEMS.register(id + "_sign", () -> signItem.apply(new Item.Properties().stacksTo(16), SIGN.get(), WALL_SIGN.get()));
            return this;
        }

        public Builder trapdoor(Function<BlockBehaviour.Properties, ? extends TrapDoorBlock> function) {
            BlockBehaviour.Properties trapdoor = BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().isValidSpawn(Builder::never).ignitedByLava();
            this.TRAPDOOR = registerWithItem(id + "_trapdoor", () -> function.apply(trapdoor));
            return this;
        }

        public Builder door(Function<BlockBehaviour.Properties, ? extends DoorBlock> function) {
            BlockBehaviour.Properties door = BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().pushReaction(PushReaction.DESTROY).ignitedByLava();
            this.DOOR = registerWithItem(id + "_door", () -> function.apply(door.mapColor(PLANKS.get().defaultMapColor())));
            return this;
        }

        public LogBlockSet build() {
            LogBlockSet logBlockSet = new LogBlockSet(this);
            LOG_BLOCK_SETS.add(logBlockSet);
            return logBlockSet;
        }

        private static boolean never(BlockState state, BlockGetter getter, BlockPos pos) {
            return false;
        }

        private static boolean valid(BlockState state, BlockGetter getter, BlockPos pos, EntityType<?> entityType) {
            return entityType == EntityType.OCELOT || entityType == EntityType.PARROT;
        }

        private static boolean never(BlockState state, BlockGetter getter, BlockPos pos, EntityType<?> entityType) {
            return false;
        }
    }

    public static class ModSignBlockEntity extends SignBlockEntity {
        public ModSignBlockEntity(BlockPos pPos, BlockState pBlockState) {
            super(ModBlocks.SIGN_BLOCK_ENTITY.get(), pPos, pBlockState);
        }
    }

    public static class ModStandingSignBlock extends StandingSignBlock {
        public ModStandingSignBlock(WoodType pType, Properties pProperties) {
            super(pType, pProperties);
        }

        @Override
        public BlockEntity newBlockEntity(@NotNull BlockPos pPos, @NotNull BlockState pState) {
            return new ModSignBlockEntity(pPos, pState);
        }
    }

    public static class ModWallSignBlock extends WallSignBlock {
        public ModWallSignBlock(WoodType pType, Properties pProperties) {
            super(pType, pProperties);
        }

        @Override
        public BlockEntity newBlockEntity(@NotNull BlockPos pPos, @NotNull BlockState pState) {
            return new ModSignBlockEntity(pPos, pState);
        }
    }

    public enum WoodSetType {
        EBONY("ebony"),
        PEARL("pearl"),
        SHADOW("shadow"),
        PALM("palm"),
        ASH("ash"),
        SPOOKY("spooky");

        public final BlockSetType SET;
        public final WoodType TYPE;

        WoodSetType(String id) {
            id = Confluence.MODID + ":" + id;
            this.SET = BlockSetType.register(new BlockSetType(id));
            this.TYPE = WoodType.register(new WoodType(id, SET));
        }
    }
}
