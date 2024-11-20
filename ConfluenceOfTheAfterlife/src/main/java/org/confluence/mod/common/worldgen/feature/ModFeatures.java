package org.confluence.mod.common.worldgen.feature;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.confluence.mod.Confluence;
import org.confluence.mod.common.block.functional.AbstractMechanicalBlock;
import org.confluence.mod.common.init.block.FunctionalBlocks;
import org.confluence.mod.mixed.IWorldGenRegion;
import org.confluence.mod.util.ModUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Predicate;

public final class ModFeatures {
    public static final Predicate<BlockState> IS_BASE_STONE = state -> state.is(BlockTags.BASE_STONE_OVERWORLD);
    static final Predicate<BlockState> IS_REPLACEABLE = Feature.isReplaceable(BlockTags.FEATURES_CANNOT_REPLACE);
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(BuiltInRegistries.FEATURE, Confluence.MODID);

    public static final DeferredHolder<Feature<?>, BoulderTrapFeature> BOULDER_TRAP = FEATURES.register("boulder_trap", () -> new BoulderTrapFeature(BoulderTrapFeature.Config.CODEC));
    public static final DeferredHolder<Feature<?>, DartTrapFeature> DART_TRAP = FEATURES.register("dart_trap", () -> new DartTrapFeature(DartTrapFeature.Config.CODEC));
    public static final DeferredHolder<Feature<?>, JewelryTreeFeature> JEWELRY_TREE = FEATURES.register("jewelry_tree", () -> new JewelryTreeFeature(JewelryTreeFeature.Config.CODEC));
    public static final DeferredHolder<Feature<?>, ThinIcePatchFeature> THIN_ICE_PATCH = FEATURES.register("thin_ice_patch", () -> new ThinIcePatchFeature(ThinIcePatchFeature.Config.CODEC));
    public static final DeferredHolder<Feature<?>, SimpleBlockNBTFeature> SIMPLE_BLOCK_NBT = FEATURES.register("simple_block_nbt", () -> new SimpleBlockNBTFeature(SimpleBlockNBTFeature.Config.CODEC));
    public static final DeferredHolder<Feature<?>, PalmTreeFeature> PALM_TREE = FEATURES.register("palm_tree", () -> new PalmTreeFeature(PalmTreeFeature.Config.CODEC));
    public static final DeferredHolder<Feature<?>, LivingTreeFeature> LIVING_TREE = FEATURES.register("living_tree", () -> new LivingTreeFeature(LivingTreeFeature.Config.CODEC));
    public static final DeferredHolder<Feature<?>, QueenBeeHiveFeature> QUEEN_BEE_HIVE = FEATURES.register("queen_bee_hive", () -> new QueenBeeHiveFeature(QueenBeeHiveFeature.Config.CODEC));

    public static final ResourceKey<ConfiguredFeature<?, ?>> SHADOW = ResourceKey.create(Registries.CONFIGURED_FEATURE, Confluence.asResource("trees_set/trees_tr_crimson"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> EBONY = ResourceKey.create(Registries.CONFIGURED_FEATURE, Confluence.asResource("trees_set/trees_corruption"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> PALM = ResourceKey.create(Registries.CONFIGURED_FEATURE, Confluence.asResource("palm_tree_checked"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> PEARL = ResourceKey.create(Registries.CONFIGURED_FEATURE, Confluence.asResource("trees_set/trees_hallow"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> RUBY = ResourceKey.create(Registries.CONFIGURED_FEATURE, Confluence.asResource("ruby_tree"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> AMBER = ResourceKey.create(Registries.CONFIGURED_FEATURE, Confluence.asResource("amber_tree"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> TOPAZ = ResourceKey.create(Registries.CONFIGURED_FEATURE, Confluence.asResource("topaz_tree"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> EMERALD = ResourceKey.create(Registries.CONFIGURED_FEATURE, Confluence.asResource("emerald_tree"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> DIAMOND = ResourceKey.create(Registries.CONFIGURED_FEATURE, Confluence.asResource("diamond_tree"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAPPHIRE = ResourceKey.create(Registries.CONFIGURED_FEATURE, Confluence.asResource("sapphire_tree"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> TR_AMETHYST = ResourceKey.create(Registries.CONFIGURED_FEATURE, Confluence.asResource("tr_amethyst_tree"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ASH = ResourceKey.create(Registries.CONFIGURED_FEATURE, Confluence.asResource("ash_tree"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> LIVING = ResourceKey.create(Registries.CONFIGURED_FEATURE, Confluence.asResource("living_tree"));

    static @NotNull BlockState getPressurePlate(WorldGenLevel level, BlockPos supportPos) {
        return level.isStateAtPosition(supportPos, blockState -> blockState.is(Blocks.DEEPSLATE))
                ? FunctionalBlocks.DEEPSLATE_PRESSURE_PLATE.get().defaultBlockState()
                : FunctionalBlocks.STONE_PRESSURE_PLATE.get().defaultBlockState();
    }

    static @Nullable AbstractMechanicalBlock.Entity getMechanicalEntity(WorldGenLevel level, BlockPos blockPos) {
        if (level.getBlockEntity(blockPos) instanceof AbstractMechanicalBlock.Entity entity) {
            return entity;
        }
        Confluence.LOGGER.error("Failed to fetch mechanical block entity at ({}, {}, {})", blockPos.getX(), blockPos.getY(), blockPos.getZ());
        return null;
    }

    static @Nullable BlockEntity getBlockEntity(WorldGenLevel level, BlockPos blockPos) {
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity == null) {
            Confluence.LOGGER.error("Failed to fetch block entity at ({}, {}, {})", blockPos.getX(), blockPos.getY(), blockPos.getZ());
            return null;
        }
        return blockEntity;
    }

    static void safeSetBlock(WorldGenLevel level, BlockPos pos, BlockState state, Predicate<BlockState> oldState) {
        if (oldState.test(level.getBlockState(pos))) {
            ((IWorldGenRegion) level).confluence$setBlock(pos, state, 2);
        }
    }

    static boolean isPosExposed(WorldGenLevel level, BlockPos blockPos) {
        for (Direction direction : ModUtils.HORIZONTAL) {
            if (level.isStateAtPosition(blockPos.relative(direction), BlockBehaviour.BlockStateBase::isAir)) {
                return true;
            }
        }
        return false;
    }

    static boolean isPosAir(WorldGenLevel level, BlockPos blockPos) {
        return level.isStateAtPosition(blockPos, BlockBehaviour.BlockStateBase::isAir);
    }

    static boolean isPosSturdy(WorldGenLevel level, BlockPos blockPos, Direction face) {
        return level.isStateAtPosition(blockPos, blockState -> blockState.isFaceSturdy(level, blockPos, face));
    }
}
