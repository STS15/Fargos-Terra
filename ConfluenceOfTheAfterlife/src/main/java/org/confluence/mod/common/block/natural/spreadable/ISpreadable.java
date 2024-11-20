package org.confluence.mod.common.block.natural.spreadable;

import com.google.common.collect.ImmutableMap;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.confluence.mod.Confluence;
import org.confluence.mod.common.data.saved.ConfluenceData;
import org.confluence.mod.common.init.block.NatureBlocks;
import org.confluence.mod.common.init.block.OreBlocks;
import org.jetbrains.annotations.NotNull;

import java.util.Hashtable;
import java.util.Map;
import java.util.function.Supplier;

import static net.minecraft.world.level.block.Blocks.*;

public interface ISpreadable {
    // That was a joke haha!
    BooleanProperty STILL_ALIVE = BooleanProperty.create("still_alive");

    Type getType();

    default void spread(@NotNull BlockState blockState, @NotNull ServerLevel serverLevel, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource) {
        if (!blockState.getValue(STILL_ALIVE)) return;
        if (randomSource.nextInt(100) >= serverLevel.getGameRules().getInt(Confluence.SPREADABLE_CHANCE)) return;
        int phase = ConfluenceData.get(serverLevel).getGamePhase().ordinal();
        for (int i = 0; i < 4; ++i) {
            BlockPos targetPos = blockPos.offset(randomSource.nextInt(3) - 1, randomSource.nextInt(5) - 3, randomSource.nextInt(3) - 1);
            BlockState beforeTransformState = serverLevel.getBlockState(targetPos);
            Block targetBlock = getType().blockMap.get(beforeTransformState.getBlock());
            if (targetBlock == null || beforeTransformState.is(SHORT_GRASS) || beforeTransformState.is(FERN) || beforeTransformState.is(TALL_GRASS)) {
                continue; // 不要直接传播草
            }
            if (beforeTransformState.is(DIRT) || beforeTransformState.is(NatureBlocks.ASH_BLOCK.get())) {
                if (!isFullBlock(serverLevel, targetPos.above())) {
                    spreadOrDie(phase, blockState, serverLevel, blockPos, randomSource, targetBlock.defaultBlockState(), targetPos);
                }
            } else {
                spreadOrDie(phase, blockState, serverLevel, blockPos, randomSource, targetBlock.defaultBlockState(), targetPos);
            }
            BlockState above = serverLevel.getBlockState(targetPos.above());
            if (above.is(SHORT_GRASS) || above.is(FERN) || above.is(TALL_GRASS)) {  // 被动传播草
                targetBlock = getType().blockMap.get(above.getBlock());
                serverLevel.setBlockAndUpdate(targetPos.above(), targetBlock == null ? above : targetBlock.defaultBlockState());
            }

        }
    }

    static boolean isFullBlock(ServerLevel serverLevel, BlockPos pos) {
        return Block.isShapeFullBlock(serverLevel.getBlockState(pos).getCollisionShape(serverLevel, pos));
    }

    static void spreadOrDie(int phase, BlockState selfState, ServerLevel serverLevel, BlockPos selfPos, RandomSource randomSource, BlockState targetState, BlockPos targetPos) {
        serverLevel.setBlockAndUpdate(targetPos, targetState);
        if (randomSource.nextInt(7) > phase) {
            serverLevel.setBlockAndUpdate(selfPos, selfState.setValue(STILL_ALIVE, false));
        }
    }

    // 到时候溶液也用这个
    enum Type {
        HALLOW(
                getSupplier(DIRT), NatureBlocks.HALLOW_GRASS_BLOCK,
                // 原木
                getSupplier(OAK_LOG), NatureBlocks.PEARL_LOG_BLOCKS.getLog(),
                getSupplier(ACACIA_LOG), NatureBlocks.PEARL_LOG_BLOCKS.getLog(),
                getSupplier(BIRCH_LOG), NatureBlocks.PEARL_LOG_BLOCKS.getLog(),
                getSupplier(CHERRY_LOG), NatureBlocks.PEARL_LOG_BLOCKS.getLog(),
                getSupplier(JUNGLE_LOG), NatureBlocks.PEARL_LOG_BLOCKS.getLog(),
                getSupplier(DARK_OAK_LOG), NatureBlocks.PEARL_LOG_BLOCKS.getLog(),
                getSupplier(MANGROVE_LOG), NatureBlocks.PEARL_LOG_BLOCKS.getLog(),
                getSupplier(SPRUCE_LOG), NatureBlocks.PEARL_LOG_BLOCKS.getLog(),
                NatureBlocks.PALM_LOG_BLOCKS.getLog(), NatureBlocks.PEARL_LOG_BLOCKS.getLog(),
                NatureBlocks.EBONY_LOG_BLOCKS.getLog(), NatureBlocks.PEARL_LOG_BLOCKS.getLog(),
                NatureBlocks.SHADOW_LOG_BLOCKS.getLog(), NatureBlocks.PEARL_LOG_BLOCKS.getLog(),
                // 树皮
                getSupplier(OAK_WOOD), NatureBlocks.PEARL_LOG_BLOCKS.getWood(),
                getSupplier(ACACIA_WOOD), NatureBlocks.PEARL_LOG_BLOCKS.getWood(),
                getSupplier(BIRCH_WOOD), NatureBlocks.PEARL_LOG_BLOCKS.getWood(),
                getSupplier(CHERRY_WOOD), NatureBlocks.PEARL_LOG_BLOCKS.getWood(),
                getSupplier(JUNGLE_WOOD), NatureBlocks.PEARL_LOG_BLOCKS.getWood(),
                getSupplier(DARK_OAK_WOOD), NatureBlocks.PEARL_LOG_BLOCKS.getWood(),
                getSupplier(MANGROVE_WOOD), NatureBlocks.PEARL_LOG_BLOCKS.getWood(),
                getSupplier(SPRUCE_WOOD), NatureBlocks.PEARL_LOG_BLOCKS.getWood(),
                NatureBlocks.PALM_LOG_BLOCKS.getWood(), NatureBlocks.PEARL_LOG_BLOCKS.getWood(),
                NatureBlocks.EBONY_LOG_BLOCKS.getWood(), NatureBlocks.PEARL_LOG_BLOCKS.getWood(),
                NatureBlocks.SHADOW_LOG_BLOCKS.getWood(), NatureBlocks.PEARL_LOG_BLOCKS.getWood(),
                // 去皮原木
                getSupplier(STRIPPED_ACACIA_LOG), NatureBlocks.PEARL_LOG_BLOCKS.getStrippedLog(),
                getSupplier(STRIPPED_CHERRY_LOG), NatureBlocks.PEARL_LOG_BLOCKS.getStrippedLog(),
                getSupplier(STRIPPED_BIRCH_LOG), NatureBlocks.PEARL_LOG_BLOCKS.getStrippedLog(),
                getSupplier(STRIPPED_DARK_OAK_LOG), NatureBlocks.PEARL_LOG_BLOCKS.getStrippedLog(),
                getSupplier(STRIPPED_OAK_LOG), NatureBlocks.PEARL_LOG_BLOCKS.getStrippedLog(),
                getSupplier(STRIPPED_MANGROVE_LOG), NatureBlocks.PEARL_LOG_BLOCKS.getStrippedLog(),
                getSupplier(STRIPPED_SPRUCE_LOG), NatureBlocks.PEARL_LOG_BLOCKS.getStrippedLog(),
                NatureBlocks.PALM_LOG_BLOCKS.getStrippedLog(), NatureBlocks.PEARL_LOG_BLOCKS.getStrippedLog(),
                NatureBlocks.EBONY_LOG_BLOCKS.getStrippedLog(), NatureBlocks.PEARL_LOG_BLOCKS.getStrippedLog(),
                NatureBlocks.SHADOW_LOG_BLOCKS.getStrippedLog(), NatureBlocks.PEARL_LOG_BLOCKS.getStrippedLog(),
                // 去皮树皮
                getSupplier(STRIPPED_ACACIA_WOOD), NatureBlocks.PEARL_LOG_BLOCKS.getStrippedWood(),
                getSupplier(STRIPPED_CHERRY_WOOD), NatureBlocks.PEARL_LOG_BLOCKS.getStrippedWood(),
                getSupplier(STRIPPED_BIRCH_WOOD), NatureBlocks.PEARL_LOG_BLOCKS.getStrippedWood(),
                getSupplier(STRIPPED_DARK_OAK_WOOD), NatureBlocks.PEARL_LOG_BLOCKS.getStrippedWood(),
                getSupplier(STRIPPED_OAK_WOOD), NatureBlocks.PEARL_LOG_BLOCKS.getStrippedWood(),
                getSupplier(STRIPPED_MANGROVE_WOOD), NatureBlocks.PEARL_LOG_BLOCKS.getStrippedWood(),
                getSupplier(STRIPPED_SPRUCE_WOOD), NatureBlocks.PEARL_LOG_BLOCKS.getStrippedWood(),
                NatureBlocks.PALM_LOG_BLOCKS.getStrippedWood(), NatureBlocks.PEARL_LOG_BLOCKS.getStrippedWood(),
                NatureBlocks.EBONY_LOG_BLOCKS.getStrippedWood(), NatureBlocks.PEARL_LOG_BLOCKS.getStrippedWood(),
                NatureBlocks.SHADOW_LOG_BLOCKS.getStrippedWood(), NatureBlocks.PEARL_LOG_BLOCKS.getStrippedWood(),
                // 树叶
                getSupplier(OAK_LEAVES), NatureBlocks.PEARL_LOG_BLOCKS.getLeaves(),
                getSupplier(ACACIA_LEAVES), NatureBlocks.PEARL_LOG_BLOCKS.getLeaves(),
                getSupplier(BIRCH_LEAVES), NatureBlocks.PEARL_LOG_BLOCKS.getLeaves(),
                getSupplier(CHERRY_LEAVES), NatureBlocks.PEARL_LOG_BLOCKS.getLeaves(),
                getSupplier(JUNGLE_LEAVES), NatureBlocks.PEARL_LOG_BLOCKS.getLeaves(),
                getSupplier(DARK_OAK_LEAVES), NatureBlocks.PEARL_LOG_BLOCKS.getLeaves(),
                getSupplier(MANGROVE_LEAVES), NatureBlocks.PEARL_LOG_BLOCKS.getLeaves(),
                getSupplier(SPRUCE_LEAVES), NatureBlocks.PEARL_LOG_BLOCKS.getLeaves(),
                NatureBlocks.PALM_LOG_BLOCKS.getLeaves(), NatureBlocks.PEARL_LOG_BLOCKS.getLeaves(),
                NatureBlocks.EBONY_LOG_BLOCKS.getLeaves(), NatureBlocks.PEARL_LOG_BLOCKS.getLeaves(),
                NatureBlocks.SHADOW_LOG_BLOCKS.getLeaves(), NatureBlocks.PEARL_LOG_BLOCKS.getLeaves(),

                // 原版环境方块
                getSupplier(GRASS_BLOCK), NatureBlocks.HALLOW_GRASS_BLOCK,
                getSupplier(STONE), NatureBlocks.PEARL_STONE,
                getSupplier(COBBLESTONE), NatureBlocks.PEARL_COBBLESTONE,
                getSupplier(SANDSTONE), NatureBlocks.PEARL_SANDSTONE,
                getSupplier(SAND), NatureBlocks.PEARL_SAND,
                getSupplier(SHORT_GRASS), NatureBlocks.HALLOW_GRASS,
                getSupplier(TALL_GRASS), NatureBlocks.HALLOW_GRASS,
                getSupplier(ICE), NatureBlocks.PINK_ICE,
                getSupplier(PACKED_ICE), NatureBlocks.PINK_PACKED_ICE,
                // 邪恶环境方块
                NatureBlocks.TR_CRIMSON_GRASS_BLOCK, NatureBlocks.HALLOW_GRASS_BLOCK,
                NatureBlocks.CORRUPT_GRASS_BLOCK, NatureBlocks.HALLOW_GRASS_BLOCK,

                NatureBlocks.EBONY_STONE, NatureBlocks.PEARL_STONE,
                NatureBlocks.TR_CRIMSON_STONE, NatureBlocks.PEARL_STONE,

                NatureBlocks.EBONY_COBBLESTONE, NatureBlocks.PEARL_COBBLESTONE,
                NatureBlocks.TR_CRIMSON_COBBLESTONE, NatureBlocks.PEARL_COBBLESTONE,

                NatureBlocks.HARDENED_SAND_BLOCK, NatureBlocks.PEARL_HARDENED_SAND_BLOCK,
                NatureBlocks.EBONY_HARDENED_SAND_BLOCK, NatureBlocks.PEARL_HARDENED_SAND_BLOCK,
                NatureBlocks.TR_CRIMSON_HARDENED_SAND_BLOCK, NatureBlocks.PEARL_HARDENED_SAND_BLOCK,

                NatureBlocks.EBONY_SANDSTONE, NatureBlocks.PEARL_SANDSTONE,
                NatureBlocks.TR_CRIMSON_SANDSTONE, NatureBlocks.PEARL_SANDSTONE,

                NatureBlocks.PURPLE_ICE, NatureBlocks.PINK_ICE,
                NatureBlocks.PURPLE_PACKED_ICE, NatureBlocks.PINK_PACKED_ICE,
                NatureBlocks.RED_ICE, NatureBlocks.PINK_ICE,
                NatureBlocks.RED_PACKED_ICE, NatureBlocks.PINK_PACKED_ICE,
                // 蘑菇
                NatureBlocks.TR_CRIMSON_MUSHROOM, NatureBlocks.LIFE_MUSHROOM,
                NatureBlocks.EBONY_MUSHROOM, NatureBlocks.LIFE_MUSHROOM,
                //矿物
                getSupplier(REDSTONE_ORE), OreBlocks.SANCTIFICATION_REDSTONE_ORE,
                getSupplier(COAL_ORE), OreBlocks.SANCTIFICATION_COAL_ORE,
                getSupplier(LAPIS_ORE), OreBlocks.SANCTIFICATION_LAPIS_ORE,
                getSupplier(COPPER_ORE), OreBlocks.SANCTIFICATION_COPPER_ORE,
                getSupplier(IRON_ORE), OreBlocks.SANCTIFICATION_IRON_ORE,
                getSupplier(EMERALD_ORE), OreBlocks.SANCTIFICATION_EMERALD_ORE,
                getSupplier(DIAMOND_ORE), OreBlocks.SANCTIFICATION_DIAMOND_ORE,
                getSupplier(GOLD_ORE), OreBlocks.SANCTIFICATION_GOLD_ORE,
                OreBlocks.TIN_ORE, OreBlocks.SANCTIFICATION_TIN_ORE,
                OreBlocks.LEAD_ORE, OreBlocks.SANCTIFICATION_LEAD_ORE,
                OreBlocks.SILVER_ORE, OreBlocks.SANCTIFICATION_SILVER_ORE,
                OreBlocks.TUNGSTEN_ORE, OreBlocks.SANCTIFICATION_TUNGSTEN_ORE,
                OreBlocks.PLATINUM_ORE, OreBlocks.SANCTIFICATION_PLATINUM_ORE,

                OreBlocks.CORRUPTION_TIN_ORE, OreBlocks.SANCTIFICATION_TIN_ORE,
                OreBlocks.CORRUPTION_LEAD_ORE, OreBlocks.SANCTIFICATION_LEAD_ORE,
                OreBlocks.CORRUPTION_SILVER_ORE, OreBlocks.SANCTIFICATION_SILVER_ORE,
                OreBlocks.CORRUPTION_TUNGSTEN_ORE, OreBlocks.SANCTIFICATION_TUNGSTEN_ORE,
                OreBlocks.CORRUPTION_PLATINUM_ORE, OreBlocks.SANCTIFICATION_PLATINUM_ORE,
                OreBlocks.CORRUPTION_COAL_ORE, OreBlocks.SANCTIFICATION_COAL_ORE,
                OreBlocks.CORRUPTION_COPPER_ORE, OreBlocks.SANCTIFICATION_COPPER_ORE,
                OreBlocks.CORRUPTION_IRON_ORE, OreBlocks.SANCTIFICATION_IRON_ORE,
                OreBlocks.CORRUPTION_GOLD_ORE, OreBlocks.SANCTIFICATION_GOLD_ORE,
                OreBlocks.CORRUPTION_DIAMOND_ORE, OreBlocks.SANCTIFICATION_DIAMOND_ORE,
                OreBlocks.CORRUPTION_REDSTONE_ORE, OreBlocks.SANCTIFICATION_REDSTONE_ORE,
                OreBlocks.FLESHIFICATION_TIN_ORE, OreBlocks.SANCTIFICATION_TIN_ORE,
                OreBlocks.FLESHIFICATION_LEAD_ORE, OreBlocks.SANCTIFICATION_LEAD_ORE,
                OreBlocks.FLESHIFICATION_SILVER_ORE, OreBlocks.SANCTIFICATION_SILVER_ORE,
                OreBlocks.FLESHIFICATION_TUNGSTEN_ORE, OreBlocks.SANCTIFICATION_TUNGSTEN_ORE,
                OreBlocks.FLESHIFICATION_PLATINUM_ORE, OreBlocks.SANCTIFICATION_PLATINUM_ORE,
                OreBlocks.FLESHIFICATION_COAL_ORE, OreBlocks.SANCTIFICATION_COAL_ORE,
                OreBlocks.FLESHIFICATION_COPPER_ORE, OreBlocks.SANCTIFICATION_COPPER_ORE,
                OreBlocks.FLESHIFICATION_IRON_ORE, OreBlocks.SANCTIFICATION_IRON_ORE,
                OreBlocks.FLESHIFICATION_GOLD_ORE, OreBlocks.SANCTIFICATION_GOLD_ORE,
                OreBlocks.FLESHIFICATION_DIAMOND_ORE, OreBlocks.SANCTIFICATION_DIAMOND_ORE,
                OreBlocks.FLESHIFICATION_REDSTONE_ORE, OreBlocks.SANCTIFICATION_REDSTONE_ORE,
                OreBlocks.EBONY_ORE, OreBlocks.SANCTIFICATION_EBONY_ORE,
                OreBlocks.TR_CRIMSON_ORE, OreBlocks.SANCTIFICATION_TR_CRIMSON_ORE,
                OreBlocks.FLESHIFICATION_EBONY_ORE, OreBlocks.FLESHIFICATION_EBONY_ORE,
                OreBlocks.FLESHIFICATION_TR_CRIMSON_ORE, OreBlocks.SANCTIFICATION_TR_CRIMSON_ORE,
                OreBlocks.CORRUPTION_EBONY_ORE, OreBlocks.FLESHIFICATION_EBONY_ORE,
                OreBlocks.CORRUPTION_TR_CRIMSON_ORE, OreBlocks.SANCTIFICATION_TR_CRIMSON_ORE,
                // 植物
                NatureBlocks.CORRUPT_GRASS, NatureBlocks.HALLOW_GRASS,
                NatureBlocks.TR_CRIMSON_GRASS, NatureBlocks.HALLOW_GRASS,
                NatureBlocks.CRIMSON_THORN, getSupplier(AIR),
                NatureBlocks.CORRUPTION_THORN, getSupplier(AIR),
                NatureBlocks.JUNGLE_THORN, getSupplier(AIR),
                NatureBlocks.PLANTERA_THORN, getSupplier(AIR)
        ),

        CRIMSON(
                getSupplier(DIRT), NatureBlocks.TR_CRIMSON_GRASS_BLOCK,
                // 原木
                getSupplier(OAK_LOG), NatureBlocks.SHADOW_LOG_BLOCKS.getLog(),
                getSupplier(ACACIA_LOG), NatureBlocks.SHADOW_LOG_BLOCKS.getLog(),
                getSupplier(BIRCH_LOG), NatureBlocks.SHADOW_LOG_BLOCKS.getLog(),
                getSupplier(CHERRY_LOG), NatureBlocks.SHADOW_LOG_BLOCKS.getLog(),
                getSupplier(JUNGLE_LOG), NatureBlocks.SHADOW_LOG_BLOCKS.getLog(),
                getSupplier(DARK_OAK_LOG), NatureBlocks.SHADOW_LOG_BLOCKS.getLog(),
                getSupplier(MANGROVE_LOG), NatureBlocks.SHADOW_LOG_BLOCKS.getLog(),
                getSupplier(SPRUCE_LOG), NatureBlocks.SHADOW_LOG_BLOCKS.getLog(),
                NatureBlocks.PALM_LOG_BLOCKS.getLog(), NatureBlocks.SHADOW_LOG_BLOCKS.getLog(),

                // 树皮
                getSupplier(OAK_WOOD), NatureBlocks.SHADOW_LOG_BLOCKS.getWood(),
                getSupplier(ACACIA_WOOD), NatureBlocks.SHADOW_LOG_BLOCKS.getWood(),
                getSupplier(BIRCH_WOOD), NatureBlocks.SHADOW_LOG_BLOCKS.getWood(),
                getSupplier(CHERRY_WOOD), NatureBlocks.SHADOW_LOG_BLOCKS.getWood(),
                getSupplier(JUNGLE_WOOD), NatureBlocks.SHADOW_LOG_BLOCKS.getWood(),
                getSupplier(DARK_OAK_WOOD), NatureBlocks.SHADOW_LOG_BLOCKS.getWood(),
                getSupplier(MANGROVE_WOOD), NatureBlocks.SHADOW_LOG_BLOCKS.getWood(),
                getSupplier(SPRUCE_WOOD), NatureBlocks.SHADOW_LOG_BLOCKS.getWood(),
                NatureBlocks.PALM_LOG_BLOCKS.getWood(), NatureBlocks.SHADOW_LOG_BLOCKS.getWood(),

                // 去皮原木
                getSupplier(STRIPPED_ACACIA_LOG), NatureBlocks.SHADOW_LOG_BLOCKS.getStrippedLog(),
                getSupplier(STRIPPED_CHERRY_LOG), NatureBlocks.SHADOW_LOG_BLOCKS.getStrippedLog(),
                getSupplier(STRIPPED_BIRCH_LOG), NatureBlocks.SHADOW_LOG_BLOCKS.getStrippedLog(),
                getSupplier(STRIPPED_DARK_OAK_LOG), NatureBlocks.SHADOW_LOG_BLOCKS.getStrippedLog(),
                getSupplier(STRIPPED_OAK_LOG), NatureBlocks.SHADOW_LOG_BLOCKS.getStrippedLog(),
                getSupplier(STRIPPED_MANGROVE_LOG), NatureBlocks.SHADOW_LOG_BLOCKS.getStrippedLog(),
                getSupplier(STRIPPED_SPRUCE_LOG), NatureBlocks.SHADOW_LOG_BLOCKS.getStrippedLog(),
                NatureBlocks.PALM_LOG_BLOCKS.getStrippedLog(), NatureBlocks.SHADOW_LOG_BLOCKS.getStrippedLog(),

                // 去皮树皮
                getSupplier(STRIPPED_ACACIA_WOOD), NatureBlocks.SHADOW_LOG_BLOCKS.getStrippedWood(),
                getSupplier(STRIPPED_CHERRY_WOOD), NatureBlocks.SHADOW_LOG_BLOCKS.getStrippedWood(),
                getSupplier(STRIPPED_BIRCH_WOOD), NatureBlocks.SHADOW_LOG_BLOCKS.getStrippedWood(),
                getSupplier(STRIPPED_DARK_OAK_WOOD), NatureBlocks.SHADOW_LOG_BLOCKS.getStrippedWood(),
                getSupplier(STRIPPED_OAK_WOOD), NatureBlocks.SHADOW_LOG_BLOCKS.getStrippedWood(),
                getSupplier(STRIPPED_MANGROVE_WOOD), NatureBlocks.SHADOW_LOG_BLOCKS.getStrippedWood(),
                getSupplier(STRIPPED_SPRUCE_WOOD), NatureBlocks.SHADOW_LOG_BLOCKS.getStrippedWood(),
                NatureBlocks.PALM_LOG_BLOCKS.getStrippedWood(), NatureBlocks.SHADOW_LOG_BLOCKS.getStrippedWood(),

                // 树叶
                getSupplier(OAK_LEAVES), NatureBlocks.SHADOW_LOG_BLOCKS.getLeaves(),
                getSupplier(ACACIA_LEAVES), NatureBlocks.SHADOW_LOG_BLOCKS.getLeaves(),
                getSupplier(BIRCH_LEAVES), NatureBlocks.SHADOW_LOG_BLOCKS.getLeaves(),
                getSupplier(CHERRY_LEAVES), NatureBlocks.SHADOW_LOG_BLOCKS.getLeaves(),
                getSupplier(JUNGLE_LEAVES), NatureBlocks.SHADOW_LOG_BLOCKS.getLeaves(),
                getSupplier(DARK_OAK_LEAVES), NatureBlocks.SHADOW_LOG_BLOCKS.getLeaves(),
                getSupplier(MANGROVE_LEAVES), NatureBlocks.SHADOW_LOG_BLOCKS.getLeaves(),
                getSupplier(SPRUCE_LEAVES), NatureBlocks.SHADOW_LOG_BLOCKS.getLeaves(),
                NatureBlocks.PALM_LOG_BLOCKS.getLeaves(), NatureBlocks.SHADOW_LOG_BLOCKS.getLeaves(),

                // 原版环境方块
                getSupplier(GRASS_BLOCK), NatureBlocks.TR_CRIMSON_GRASS_BLOCK,
                getSupplier(STONE), NatureBlocks.TR_CRIMSON_STONE,
                getSupplier(COBBLESTONE), NatureBlocks.TR_CRIMSON_COBBLESTONE,
                getSupplier(SANDSTONE), NatureBlocks.TR_CRIMSON_SANDSTONE,
                getSupplier(SAND), NatureBlocks.TR_CRIMSON_SAND,
                getSupplier(SHORT_GRASS), NatureBlocks.TR_CRIMSON_GRASS,
                getSupplier(TALL_GRASS), NatureBlocks.TR_CRIMSON_GRASS,
                getSupplier(ICE), NatureBlocks.RED_ICE,
                getSupplier(PACKED_ICE), NatureBlocks.RED_PACKED_ICE,
                //矿物
                getSupplier(REDSTONE_ORE), OreBlocks.FLESHIFICATION_REDSTONE_ORE,
                getSupplier(COAL_ORE), OreBlocks.FLESHIFICATION_COAL_ORE,
                getSupplier(LAPIS_ORE), OreBlocks.FLESHIFICATION_LAPIS_ORE,
                getSupplier(COPPER_ORE), OreBlocks.FLESHIFICATION_COPPER_ORE,
                getSupplier(IRON_ORE), OreBlocks.FLESHIFICATION_IRON_ORE,
                getSupplier(EMERALD_ORE), OreBlocks.FLESHIFICATION_EMERALD_ORE,
                getSupplier(DIAMOND_ORE), OreBlocks.FLESHIFICATION_DIAMOND_ORE,
                getSupplier(GOLD_ORE), OreBlocks.FLESHIFICATION_GOLD_ORE,
                OreBlocks.TIN_ORE, OreBlocks.FLESHIFICATION_TIN_ORE,
                OreBlocks.LEAD_ORE, OreBlocks.FLESHIFICATION_LEAD_ORE,
                OreBlocks.SILVER_ORE, OreBlocks.FLESHIFICATION_SILVER_ORE,
                OreBlocks.TUNGSTEN_ORE, OreBlocks.FLESHIFICATION_TUNGSTEN_ORE,
                OreBlocks.PLATINUM_ORE, OreBlocks.FLESHIFICATION_PLATINUM_ORE,
                OreBlocks.EBONY_ORE, OreBlocks.FLESHIFICATION_EBONY_ORE,
                OreBlocks.TR_CRIMSON_ORE, OreBlocks.FLESHIFICATION_TR_CRIMSON_ORE,

                // 蘑菇
                NatureBlocks.LIFE_MUSHROOM, NatureBlocks.TR_CRIMSON_MUSHROOM
        ),


        CORRUPT(
                getSupplier(DIRT), NatureBlocks.CORRUPT_GRASS_BLOCK,
                // 原木
                getSupplier(OAK_LOG), NatureBlocks.EBONY_LOG_BLOCKS.getLog(),
                getSupplier(ACACIA_LOG), NatureBlocks.EBONY_LOG_BLOCKS.getLog(),
                getSupplier(BIRCH_LOG), NatureBlocks.EBONY_LOG_BLOCKS.getLog(),
                getSupplier(CHERRY_LOG), NatureBlocks.EBONY_LOG_BLOCKS.getLog(),
                getSupplier(JUNGLE_LOG), NatureBlocks.EBONY_LOG_BLOCKS.getLog(),
                getSupplier(DARK_OAK_LOG), NatureBlocks.EBONY_LOG_BLOCKS.getLog(),
                getSupplier(MANGROVE_LOG), NatureBlocks.EBONY_LOG_BLOCKS.getLog(),
                getSupplier(SPRUCE_LOG), NatureBlocks.EBONY_LOG_BLOCKS.getLog(),
                NatureBlocks.PALM_LOG_BLOCKS.getLog(), NatureBlocks.EBONY_LOG_BLOCKS.getLog(),
                NatureBlocks.PEARL_LOG_BLOCKS.getLog(), NatureBlocks.EBONY_LOG_BLOCKS.getLog(),
                // 树皮
                getSupplier(OAK_WOOD), NatureBlocks.EBONY_LOG_BLOCKS.getWood(),
                getSupplier(ACACIA_WOOD), NatureBlocks.EBONY_LOG_BLOCKS.getWood(),
                getSupplier(BIRCH_WOOD), NatureBlocks.EBONY_LOG_BLOCKS.getWood(),
                getSupplier(CHERRY_WOOD), NatureBlocks.EBONY_LOG_BLOCKS.getWood(),
                getSupplier(JUNGLE_WOOD), NatureBlocks.EBONY_LOG_BLOCKS.getWood(),
                getSupplier(DARK_OAK_WOOD), NatureBlocks.EBONY_LOG_BLOCKS.getWood(),
                getSupplier(MANGROVE_WOOD), NatureBlocks.EBONY_LOG_BLOCKS.getWood(),
                getSupplier(SPRUCE_WOOD), NatureBlocks.EBONY_LOG_BLOCKS.getWood(),
                NatureBlocks.PALM_LOG_BLOCKS.getWood(), NatureBlocks.EBONY_LOG_BLOCKS.getWood(),
                NatureBlocks.PEARL_LOG_BLOCKS.getWood(), NatureBlocks.EBONY_LOG_BLOCKS.getWood(),

                // 去皮原木
                getSupplier(STRIPPED_ACACIA_LOG), NatureBlocks.EBONY_LOG_BLOCKS.getStrippedLog(),
                getSupplier(STRIPPED_CHERRY_LOG), NatureBlocks.EBONY_LOG_BLOCKS.getStrippedLog(),
                getSupplier(STRIPPED_BIRCH_LOG), NatureBlocks.EBONY_LOG_BLOCKS.getStrippedLog(),
                getSupplier(STRIPPED_DARK_OAK_LOG), NatureBlocks.EBONY_LOG_BLOCKS.getStrippedLog(),
                getSupplier(STRIPPED_OAK_LOG), NatureBlocks.EBONY_LOG_BLOCKS.getStrippedLog(),
                getSupplier(STRIPPED_MANGROVE_LOG), NatureBlocks.EBONY_LOG_BLOCKS.getStrippedLog(),
                getSupplier(STRIPPED_SPRUCE_LOG), NatureBlocks.EBONY_LOG_BLOCKS.getStrippedLog(),
                NatureBlocks.PALM_LOG_BLOCKS.getStrippedLog(), NatureBlocks.EBONY_LOG_BLOCKS.getStrippedLog(),
                NatureBlocks.PEARL_LOG_BLOCKS.getStrippedLog(), NatureBlocks.EBONY_LOG_BLOCKS.getStrippedLog(),

                // 去皮树皮
                getSupplier(STRIPPED_ACACIA_WOOD), NatureBlocks.EBONY_LOG_BLOCKS.getStrippedWood(),
                getSupplier(STRIPPED_CHERRY_WOOD), NatureBlocks.EBONY_LOG_BLOCKS.getStrippedWood(),
                getSupplier(STRIPPED_BIRCH_WOOD), NatureBlocks.EBONY_LOG_BLOCKS.getStrippedWood(),
                getSupplier(STRIPPED_DARK_OAK_WOOD), NatureBlocks.EBONY_LOG_BLOCKS.getStrippedWood(),
                getSupplier(STRIPPED_OAK_WOOD), NatureBlocks.EBONY_LOG_BLOCKS.getStrippedWood(),
                getSupplier(STRIPPED_MANGROVE_WOOD), NatureBlocks.EBONY_LOG_BLOCKS.getStrippedWood(),
                getSupplier(STRIPPED_SPRUCE_WOOD), NatureBlocks.EBONY_LOG_BLOCKS.getStrippedWood(),
                NatureBlocks.PALM_LOG_BLOCKS.getStrippedWood(), NatureBlocks.EBONY_LOG_BLOCKS.getStrippedWood(),
                NatureBlocks.PEARL_LOG_BLOCKS.getStrippedWood(), NatureBlocks.EBONY_LOG_BLOCKS.getStrippedWood(),
                // 树叶
                getSupplier(OAK_LEAVES), NatureBlocks.EBONY_LOG_BLOCKS.getLeaves(),
                getSupplier(ACACIA_LEAVES), NatureBlocks.EBONY_LOG_BLOCKS.getLeaves(),
                getSupplier(BIRCH_LEAVES), NatureBlocks.EBONY_LOG_BLOCKS.getLeaves(),
                getSupplier(CHERRY_LEAVES), NatureBlocks.EBONY_LOG_BLOCKS.getLeaves(),
                getSupplier(JUNGLE_LEAVES), NatureBlocks.EBONY_LOG_BLOCKS.getLeaves(),
                getSupplier(DARK_OAK_LEAVES), NatureBlocks.EBONY_LOG_BLOCKS.getLeaves(),
                getSupplier(MANGROVE_LEAVES), NatureBlocks.EBONY_LOG_BLOCKS.getLeaves(),
                getSupplier(SPRUCE_LEAVES), NatureBlocks.EBONY_LOG_BLOCKS.getLeaves(),
                NatureBlocks.PALM_LOG_BLOCKS.getLeaves(), NatureBlocks.EBONY_LOG_BLOCKS.getLeaves(),
                NatureBlocks.PEARL_LOG_BLOCKS.getLeaves(), NatureBlocks.EBONY_LOG_BLOCKS.getLeaves(),


                // 原版环境方块
                getSupplier(GRASS_BLOCK), NatureBlocks.CORRUPT_GRASS_BLOCK,
                getSupplier(STONE), NatureBlocks.EBONY_STONE,
                getSupplier(COBBLESTONE), NatureBlocks.EBONY_COBBLESTONE,
                getSupplier(SANDSTONE), NatureBlocks.EBONY_SANDSTONE,
                getSupplier(SAND), NatureBlocks.EBONY_SAND,
                getSupplier(SHORT_GRASS), NatureBlocks.CORRUPT_GRASS,
                getSupplier(TALL_GRASS), NatureBlocks.CORRUPT_GRASS,
                getSupplier(ICE), NatureBlocks.PURPLE_ICE,
                getSupplier(PACKED_ICE), NatureBlocks.PURPLE_PACKED_ICE,
                //矿物
                getSupplier(REDSTONE_ORE), OreBlocks.CORRUPTION_REDSTONE_ORE,
                getSupplier(COAL_ORE), OreBlocks.CORRUPTION_COAL_ORE,
                getSupplier(LAPIS_ORE), OreBlocks.CORRUPTION_LAPIS_ORE,
                getSupplier(COPPER_ORE), OreBlocks.CORRUPTION_COPPER_ORE,
                getSupplier(IRON_ORE), OreBlocks.CORRUPTION_IRON_ORE,
                getSupplier(EMERALD_ORE), OreBlocks.CORRUPTION_EMERALD_ORE,
                getSupplier(DIAMOND_ORE), OreBlocks.CORRUPTION_DIAMOND_ORE,
                getSupplier(GOLD_ORE), OreBlocks.CORRUPTION_GOLD_ORE,
                OreBlocks.TIN_ORE, OreBlocks.CORRUPTION_TIN_ORE,
                OreBlocks.LEAD_ORE, OreBlocks.CORRUPTION_LEAD_ORE,
                OreBlocks.SILVER_ORE, OreBlocks.CORRUPTION_SILVER_ORE,
                OreBlocks.TUNGSTEN_ORE, OreBlocks.CORRUPTION_TUNGSTEN_ORE,
                OreBlocks.PLATINUM_ORE, OreBlocks.CORRUPTION_PLATINUM_ORE,
                OreBlocks.EBONY_ORE, OreBlocks.CORRUPTION_EBONY_ORE,
                OreBlocks.TR_CRIMSON_ORE, OreBlocks.CORRUPTION_TR_CRIMSON_ORE,

                OreBlocks.SANCTIFICATION_TIN_ORE, OreBlocks.CORRUPTION_TIN_ORE,
                OreBlocks.SANCTIFICATION_LEAD_ORE, OreBlocks.CORRUPTION_LEAD_ORE,
                OreBlocks.SANCTIFICATION_SILVER_ORE, OreBlocks.CORRUPTION_SILVER_ORE,
                OreBlocks.SANCTIFICATION_TUNGSTEN_ORE, OreBlocks.CORRUPTION_TUNGSTEN_ORE,
                OreBlocks.SANCTIFICATION_PLATINUM_ORE, OreBlocks.CORRUPTION_PLATINUM_ORE,
                OreBlocks.SANCTIFICATION_COAL_ORE, OreBlocks.CORRUPTION_COAL_ORE,
                OreBlocks.SANCTIFICATION_COPPER_ORE, OreBlocks.CORRUPTION_COPPER_ORE,
                OreBlocks.SANCTIFICATION_IRON_ORE, OreBlocks.CORRUPTION_IRON_ORE,
                OreBlocks.SANCTIFICATION_GOLD_ORE, OreBlocks.CORRUPTION_GOLD_ORE,
                OreBlocks.SANCTIFICATION_DIAMOND_ORE, OreBlocks.CORRUPTION_DIAMOND_ORE,
                OreBlocks.SANCTIFICATION_REDSTONE_ORE, OreBlocks.CORRUPTION_REDSTONE_ORE,

                // 邪恶环境方块
                NatureBlocks.HALLOW_GRASS_BLOCK, NatureBlocks.CORRUPT_GRASS_BLOCK,

                NatureBlocks.PEARL_STONE, NatureBlocks.EBONY_STONE,

                NatureBlocks.PEARL_COBBLESTONE, NatureBlocks.EBONY_COBBLESTONE,

                NatureBlocks.HARDENED_SAND_BLOCK, NatureBlocks.EBONY_HARDENED_SAND_BLOCK,
                NatureBlocks.PEARL_HARDENED_SAND_BLOCK, NatureBlocks.EBONY_HARDENED_SAND_BLOCK,

                NatureBlocks.PEARL_SANDSTONE, NatureBlocks.EBONY_SANDSTONE,

                NatureBlocks.PINK_ICE, NatureBlocks.PURPLE_ICE,
                NatureBlocks.PINK_PACKED_ICE, NatureBlocks.PURPLE_PACKED_ICE,

                // 蘑菇
                NatureBlocks.LIFE_MUSHROOM, NatureBlocks.EBONY_MUSHROOM,

                // 植物
                NatureBlocks.HALLOW_GRASS, NatureBlocks.CORRUPT_GRASS,
                NatureBlocks.CRIMSON_THORN, NatureBlocks.CORRUPTION_THORN,
                NatureBlocks.JUNGLE_THORN, NatureBlocks.CORRUPTION_THORN,
                NatureBlocks.PLANTERA_THORN, NatureBlocks.CORRUPTION_THORN
        ),

        GLOWING(
                getSupplier(MUD), NatureBlocks.MUSHROOM_GRASS_BLOCK,
                NatureBlocks.JUNGLE_SPORE, NatureBlocks.GLOWING_MUSHROOM
        ),

        PURE(
                NatureBlocks.ASH_BLOCK, NatureBlocks.ASH_GRASS_BLOCK,
                getSupplier(MUD), NatureBlocks.MUSHROOM_GRASS_BLOCK,
                NatureBlocks.TR_CRIMSON_MUSHROOM, NatureBlocks.LIFE_MUSHROOM,
                NatureBlocks.EBONY_MUSHROOM, NatureBlocks.LIFE_MUSHROOM,
                NatureBlocks.CORRUPT_GRASS, getSupplier(SHORT_GRASS),
                NatureBlocks.TR_CRIMSON_GRASS, getSupplier(SHORT_GRASS),
                NatureBlocks.HALLOW_GRASS, getSupplier(SHORT_GRASS),
                NatureBlocks.TR_CRIMSON_STONE, getSupplier(STONE),
                NatureBlocks.TR_CRIMSON_SAND, getSupplier(SAND),
                NatureBlocks.TR_CRIMSON_GRASS_BLOCK, getSupplier(GRASS_BLOCK),
                NatureBlocks.CORRUPT_GRASS_BLOCK, getSupplier(GRASS_BLOCK),
                NatureBlocks.HALLOW_GRASS_BLOCK, getSupplier(GRASS_BLOCK),
                NatureBlocks.CRIMSON_THORN, getSupplier(AIR),
                NatureBlocks.CORRUPTION_THORN, getSupplier(AIR)
        );

        private Map<Supplier<? extends Block>, Supplier<? extends Block>> supplierMap;
        private Map<Block, Block> blockMap;

        @SafeVarargs
        Type(Supplier<? extends Block>... suppliers) {
            if (suppliers.length % 2 != 0) throw new RuntimeException("Not enough suppliers!");
            Hashtable<Supplier<? extends Block>, Supplier<? extends Block>> map = new Hashtable<>();
            for (int i = 0; i < suppliers.length / 2; i++) {
                int j = i * 2;
                map.put(suppliers[j], suppliers[j + 1]);
            }
            this.supplierMap = map;
        }

        public Map<Block, Block> getBlockMap() {
            return blockMap;
        }

        private static Supplier<Block> getSupplier(Block block) {
            return () -> block;
        }

        public static void buildMap() {
            for (Type type : values()) {
                ImmutableMap.Builder<Block, Block> map = ImmutableMap.builder();
                type.supplierMap.forEach((s1, s2) -> map.put(s1.get(), s2.get()));
                type.blockMap = map.build();
                type.supplierMap = null;
            }
        }
    }
}
