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
import org.confluence.mod.common.init.block.ModBlocks;
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
            if (beforeTransformState.is(DIRT) || beforeTransformState.is(ModBlocks.ASH_BLOCK.get())) {
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
                getSupplier(DIRT), ModBlocks.HALLOW_GRASS_BLOCK,
                // 原木
                getSupplier(OAK_LOG), ModBlocks.PEARL_LOG_BLOCKS.getLog(),
                getSupplier(ACACIA_LOG), ModBlocks.PEARL_LOG_BLOCKS.getLog(),
                getSupplier(BIRCH_LOG), ModBlocks.PEARL_LOG_BLOCKS.getLog(),
                getSupplier(CHERRY_LOG), ModBlocks.PEARL_LOG_BLOCKS.getLog(),
                getSupplier(JUNGLE_LOG), ModBlocks.PEARL_LOG_BLOCKS.getLog(),
                getSupplier(DARK_OAK_LOG), ModBlocks.PEARL_LOG_BLOCKS.getLog(),
                getSupplier(MANGROVE_LOG), ModBlocks.PEARL_LOG_BLOCKS.getLog(),
                getSupplier(SPRUCE_LOG), ModBlocks.PEARL_LOG_BLOCKS.getLog(),
                ModBlocks.PALM_LOG_BLOCKS.getLog(), ModBlocks.PEARL_LOG_BLOCKS.getLog(),
                ModBlocks.EBONY_LOG_BLOCKS.getLog(), ModBlocks.PEARL_LOG_BLOCKS.getLog(),
                ModBlocks.SHADOW_LOG_BLOCKS.getLog(), ModBlocks.PEARL_LOG_BLOCKS.getLog(),
                // 树皮
                getSupplier(OAK_WOOD), ModBlocks.PEARL_LOG_BLOCKS.getWood(),
                getSupplier(ACACIA_WOOD), ModBlocks.PEARL_LOG_BLOCKS.getWood(),
                getSupplier(BIRCH_WOOD), ModBlocks.PEARL_LOG_BLOCKS.getWood(),
                getSupplier(CHERRY_WOOD), ModBlocks.PEARL_LOG_BLOCKS.getWood(),
                getSupplier(JUNGLE_WOOD), ModBlocks.PEARL_LOG_BLOCKS.getWood(),
                getSupplier(DARK_OAK_WOOD), ModBlocks.PEARL_LOG_BLOCKS.getWood(),
                getSupplier(MANGROVE_WOOD), ModBlocks.PEARL_LOG_BLOCKS.getWood(),
                getSupplier(SPRUCE_WOOD), ModBlocks.PEARL_LOG_BLOCKS.getWood(),
                ModBlocks.PALM_LOG_BLOCKS.getWood(), ModBlocks.PEARL_LOG_BLOCKS.getWood(),
                ModBlocks.EBONY_LOG_BLOCKS.getWood(), ModBlocks.PEARL_LOG_BLOCKS.getWood(),
                ModBlocks.SHADOW_LOG_BLOCKS.getWood(), ModBlocks.PEARL_LOG_BLOCKS.getWood(),
                // 去皮原木
                getSupplier(STRIPPED_ACACIA_LOG), ModBlocks.PEARL_LOG_BLOCKS.getStrippedLog(),
                getSupplier(STRIPPED_CHERRY_LOG), ModBlocks.PEARL_LOG_BLOCKS.getStrippedLog(),
                getSupplier(STRIPPED_BIRCH_LOG), ModBlocks.PEARL_LOG_BLOCKS.getStrippedLog(),
                getSupplier(STRIPPED_DARK_OAK_LOG), ModBlocks.PEARL_LOG_BLOCKS.getStrippedLog(),
                getSupplier(STRIPPED_OAK_LOG), ModBlocks.PEARL_LOG_BLOCKS.getStrippedLog(),
                getSupplier(STRIPPED_MANGROVE_LOG), ModBlocks.PEARL_LOG_BLOCKS.getStrippedLog(),
                getSupplier(STRIPPED_SPRUCE_LOG), ModBlocks.PEARL_LOG_BLOCKS.getStrippedLog(),
                ModBlocks.PALM_LOG_BLOCKS.getStrippedLog(), ModBlocks.PEARL_LOG_BLOCKS.getStrippedLog(),
                ModBlocks.EBONY_LOG_BLOCKS.getStrippedLog(), ModBlocks.PEARL_LOG_BLOCKS.getStrippedLog(),
                ModBlocks.SHADOW_LOG_BLOCKS.getStrippedLog(), ModBlocks.PEARL_LOG_BLOCKS.getStrippedLog(),
                // 去皮树皮
                getSupplier(STRIPPED_ACACIA_WOOD), ModBlocks.PEARL_LOG_BLOCKS.getStrippedWood(),
                getSupplier(STRIPPED_CHERRY_WOOD), ModBlocks.PEARL_LOG_BLOCKS.getStrippedWood(),
                getSupplier(STRIPPED_BIRCH_WOOD), ModBlocks.PEARL_LOG_BLOCKS.getStrippedWood(),
                getSupplier(STRIPPED_DARK_OAK_WOOD), ModBlocks.PEARL_LOG_BLOCKS.getStrippedWood(),
                getSupplier(STRIPPED_OAK_WOOD), ModBlocks.PEARL_LOG_BLOCKS.getStrippedWood(),
                getSupplier(STRIPPED_MANGROVE_WOOD), ModBlocks.PEARL_LOG_BLOCKS.getStrippedWood(),
                getSupplier(STRIPPED_SPRUCE_WOOD), ModBlocks.PEARL_LOG_BLOCKS.getStrippedWood(),
                ModBlocks.PALM_LOG_BLOCKS.getStrippedWood(), ModBlocks.PEARL_LOG_BLOCKS.getStrippedWood(),
                ModBlocks.EBONY_LOG_BLOCKS.getStrippedWood(), ModBlocks.PEARL_LOG_BLOCKS.getStrippedWood(),
                ModBlocks.SHADOW_LOG_BLOCKS.getStrippedWood(), ModBlocks.PEARL_LOG_BLOCKS.getStrippedWood(),
                // 树叶
                getSupplier(OAK_LEAVES), ModBlocks.PEARL_LOG_BLOCKS.getLeaves(),
                getSupplier(ACACIA_LEAVES), ModBlocks.PEARL_LOG_BLOCKS.getLeaves(),
                getSupplier(BIRCH_LEAVES), ModBlocks.PEARL_LOG_BLOCKS.getLeaves(),
                getSupplier(CHERRY_LEAVES), ModBlocks.PEARL_LOG_BLOCKS.getLeaves(),
                getSupplier(JUNGLE_LEAVES), ModBlocks.PEARL_LOG_BLOCKS.getLeaves(),
                getSupplier(DARK_OAK_LEAVES), ModBlocks.PEARL_LOG_BLOCKS.getLeaves(),
                getSupplier(MANGROVE_LEAVES), ModBlocks.PEARL_LOG_BLOCKS.getLeaves(),
                getSupplier(SPRUCE_LEAVES), ModBlocks.PEARL_LOG_BLOCKS.getLeaves(),
                ModBlocks.PALM_LOG_BLOCKS.getLeaves(), ModBlocks.PEARL_LOG_BLOCKS.getLeaves(),
                ModBlocks.EBONY_LOG_BLOCKS.getLeaves(), ModBlocks.PEARL_LOG_BLOCKS.getLeaves(),
                ModBlocks.SHADOW_LOG_BLOCKS.getLeaves(), ModBlocks.PEARL_LOG_BLOCKS.getLeaves(),

                // 原版环境方块
                getSupplier(GRASS_BLOCK), ModBlocks.HALLOW_GRASS_BLOCK,
                getSupplier(STONE), ModBlocks.PEARL_STONE,
                getSupplier(COBBLESTONE), ModBlocks.PEARL_COBBLESTONE,
                getSupplier(SANDSTONE), ModBlocks.PEARL_SANDSTONE,
                getSupplier(SAND), ModBlocks.PEARL_SAND,
                getSupplier(SHORT_GRASS), ModBlocks.HALLOW_GRASS,
                getSupplier(TALL_GRASS), ModBlocks.HALLOW_GRASS,
                getSupplier(ICE), ModBlocks.PINK_ICE,
                getSupplier(PACKED_ICE), ModBlocks.PINK_PACKED_ICE,
                // 邪恶环境方块
                ModBlocks.TR_CRIMSON_GRASS_BLOCK, ModBlocks.HALLOW_GRASS_BLOCK,
                ModBlocks.CORRUPT_GRASS_BLOCK, ModBlocks.HALLOW_GRASS_BLOCK,

                ModBlocks.EBONY_STONE, ModBlocks.PEARL_STONE,
                ModBlocks.TR_CRIMSON_STONE, ModBlocks.PEARL_STONE,

                ModBlocks.EBONY_COBBLESTONE, ModBlocks.PEARL_COBBLESTONE,
                ModBlocks.TR_CRIMSON_COBBLESTONE, ModBlocks.PEARL_COBBLESTONE,

                ModBlocks.HARDENED_SAND_BLOCK, ModBlocks.PEARL_HARDENED_SAND_BLOCK,
                ModBlocks.EBONY_HARDENED_SAND_BLOCK, ModBlocks.PEARL_HARDENED_SAND_BLOCK,
                ModBlocks.TR_CRIMSON_HARDENED_SAND_BLOCK, ModBlocks.PEARL_HARDENED_SAND_BLOCK,

                ModBlocks.EBONY_SANDSTONE, ModBlocks.PEARL_SANDSTONE,
                ModBlocks.TR_CRIMSON_SANDSTONE, ModBlocks.PEARL_SANDSTONE,

                ModBlocks.PURPLE_ICE, ModBlocks.PINK_ICE,
                ModBlocks.PURPLE_PACKED_ICE, ModBlocks.PINK_PACKED_ICE,
                ModBlocks.RED_ICE, ModBlocks.PINK_ICE,
                ModBlocks.RED_PACKED_ICE, ModBlocks.PINK_PACKED_ICE,
                // 蘑菇
                ModBlocks.TR_CRIMSON_MUSHROOM, ModBlocks.LIFE_MUSHROOM,
                ModBlocks.EBONY_MUSHROOM, ModBlocks.LIFE_MUSHROOM,
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
                ModBlocks.CORRUPT_GRASS, ModBlocks.HALLOW_GRASS,
                ModBlocks.TR_CRIMSON_GRASS, ModBlocks.HALLOW_GRASS,
                ModBlocks.CRIMSON_THORN, getSupplier(AIR),
                ModBlocks.CORRUPTION_THORN, getSupplier(AIR),
                ModBlocks.JUNGLE_THORN, getSupplier(AIR),
                ModBlocks.PLANTERA_THORN, getSupplier(AIR)
        ),

        CRIMSON(
                getSupplier(DIRT), ModBlocks.TR_CRIMSON_GRASS_BLOCK,
                // 原木
                getSupplier(OAK_LOG), ModBlocks.SHADOW_LOG_BLOCKS.getLog(),
                getSupplier(ACACIA_LOG), ModBlocks.SHADOW_LOG_BLOCKS.getLog(),
                getSupplier(BIRCH_LOG), ModBlocks.SHADOW_LOG_BLOCKS.getLog(),
                getSupplier(CHERRY_LOG), ModBlocks.SHADOW_LOG_BLOCKS.getLog(),
                getSupplier(JUNGLE_LOG), ModBlocks.SHADOW_LOG_BLOCKS.getLog(),
                getSupplier(DARK_OAK_LOG), ModBlocks.SHADOW_LOG_BLOCKS.getLog(),
                getSupplier(MANGROVE_LOG), ModBlocks.SHADOW_LOG_BLOCKS.getLog(),
                getSupplier(SPRUCE_LOG), ModBlocks.SHADOW_LOG_BLOCKS.getLog(),
                ModBlocks.PALM_LOG_BLOCKS.getLog(), ModBlocks.SHADOW_LOG_BLOCKS.getLog(),

                // 树皮
                getSupplier(OAK_WOOD), ModBlocks.SHADOW_LOG_BLOCKS.getWood(),
                getSupplier(ACACIA_WOOD), ModBlocks.SHADOW_LOG_BLOCKS.getWood(),
                getSupplier(BIRCH_WOOD), ModBlocks.SHADOW_LOG_BLOCKS.getWood(),
                getSupplier(CHERRY_WOOD), ModBlocks.SHADOW_LOG_BLOCKS.getWood(),
                getSupplier(JUNGLE_WOOD), ModBlocks.SHADOW_LOG_BLOCKS.getWood(),
                getSupplier(DARK_OAK_WOOD), ModBlocks.SHADOW_LOG_BLOCKS.getWood(),
                getSupplier(MANGROVE_WOOD), ModBlocks.SHADOW_LOG_BLOCKS.getWood(),
                getSupplier(SPRUCE_WOOD), ModBlocks.SHADOW_LOG_BLOCKS.getWood(),
                ModBlocks.PALM_LOG_BLOCKS.getWood(), ModBlocks.SHADOW_LOG_BLOCKS.getWood(),

                // 去皮原木
                getSupplier(STRIPPED_ACACIA_LOG), ModBlocks.SHADOW_LOG_BLOCKS.getStrippedLog(),
                getSupplier(STRIPPED_CHERRY_LOG), ModBlocks.SHADOW_LOG_BLOCKS.getStrippedLog(),
                getSupplier(STRIPPED_BIRCH_LOG), ModBlocks.SHADOW_LOG_BLOCKS.getStrippedLog(),
                getSupplier(STRIPPED_DARK_OAK_LOG), ModBlocks.SHADOW_LOG_BLOCKS.getStrippedLog(),
                getSupplier(STRIPPED_OAK_LOG), ModBlocks.SHADOW_LOG_BLOCKS.getStrippedLog(),
                getSupplier(STRIPPED_MANGROVE_LOG), ModBlocks.SHADOW_LOG_BLOCKS.getStrippedLog(),
                getSupplier(STRIPPED_SPRUCE_LOG), ModBlocks.SHADOW_LOG_BLOCKS.getStrippedLog(),
                ModBlocks.PALM_LOG_BLOCKS.getStrippedLog(), ModBlocks.SHADOW_LOG_BLOCKS.getStrippedLog(),

                // 去皮树皮
                getSupplier(STRIPPED_ACACIA_WOOD), ModBlocks.SHADOW_LOG_BLOCKS.getStrippedWood(),
                getSupplier(STRIPPED_CHERRY_WOOD), ModBlocks.SHADOW_LOG_BLOCKS.getStrippedWood(),
                getSupplier(STRIPPED_BIRCH_WOOD), ModBlocks.SHADOW_LOG_BLOCKS.getStrippedWood(),
                getSupplier(STRIPPED_DARK_OAK_WOOD), ModBlocks.SHADOW_LOG_BLOCKS.getStrippedWood(),
                getSupplier(STRIPPED_OAK_WOOD), ModBlocks.SHADOW_LOG_BLOCKS.getStrippedWood(),
                getSupplier(STRIPPED_MANGROVE_WOOD), ModBlocks.SHADOW_LOG_BLOCKS.getStrippedWood(),
                getSupplier(STRIPPED_SPRUCE_WOOD), ModBlocks.SHADOW_LOG_BLOCKS.getStrippedWood(),
                ModBlocks.PALM_LOG_BLOCKS.getStrippedWood(), ModBlocks.SHADOW_LOG_BLOCKS.getStrippedWood(),

                // 树叶
                getSupplier(OAK_LEAVES), ModBlocks.SHADOW_LOG_BLOCKS.getLeaves(),
                getSupplier(ACACIA_LEAVES), ModBlocks.SHADOW_LOG_BLOCKS.getLeaves(),
                getSupplier(BIRCH_LEAVES), ModBlocks.SHADOW_LOG_BLOCKS.getLeaves(),
                getSupplier(CHERRY_LEAVES), ModBlocks.SHADOW_LOG_BLOCKS.getLeaves(),
                getSupplier(JUNGLE_LEAVES), ModBlocks.SHADOW_LOG_BLOCKS.getLeaves(),
                getSupplier(DARK_OAK_LEAVES), ModBlocks.SHADOW_LOG_BLOCKS.getLeaves(),
                getSupplier(MANGROVE_LEAVES), ModBlocks.SHADOW_LOG_BLOCKS.getLeaves(),
                getSupplier(SPRUCE_LEAVES), ModBlocks.SHADOW_LOG_BLOCKS.getLeaves(),
                ModBlocks.PALM_LOG_BLOCKS.getLeaves(), ModBlocks.SHADOW_LOG_BLOCKS.getLeaves(),

                // 原版环境方块
                getSupplier(GRASS_BLOCK), ModBlocks.TR_CRIMSON_GRASS_BLOCK,
                getSupplier(STONE), ModBlocks.TR_CRIMSON_STONE,
                getSupplier(COBBLESTONE), ModBlocks.TR_CRIMSON_COBBLESTONE,
                getSupplier(SANDSTONE), ModBlocks.TR_CRIMSON_SANDSTONE,
                getSupplier(SAND), ModBlocks.TR_CRIMSON_SAND,
                getSupplier(SHORT_GRASS), ModBlocks.TR_CRIMSON_GRASS,
                getSupplier(TALL_GRASS), ModBlocks.TR_CRIMSON_GRASS,
                getSupplier(ICE), ModBlocks.RED_ICE,
                getSupplier(PACKED_ICE), ModBlocks.RED_PACKED_ICE,
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
                ModBlocks.LIFE_MUSHROOM, ModBlocks.TR_CRIMSON_MUSHROOM
        ),


        CORRUPT(
                getSupplier(DIRT), ModBlocks.CORRUPT_GRASS_BLOCK,
                // 原木
                getSupplier(OAK_LOG), ModBlocks.EBONY_LOG_BLOCKS.getLog(),
                getSupplier(ACACIA_LOG), ModBlocks.EBONY_LOG_BLOCKS.getLog(),
                getSupplier(BIRCH_LOG), ModBlocks.EBONY_LOG_BLOCKS.getLog(),
                getSupplier(CHERRY_LOG), ModBlocks.EBONY_LOG_BLOCKS.getLog(),
                getSupplier(JUNGLE_LOG), ModBlocks.EBONY_LOG_BLOCKS.getLog(),
                getSupplier(DARK_OAK_LOG), ModBlocks.EBONY_LOG_BLOCKS.getLog(),
                getSupplier(MANGROVE_LOG), ModBlocks.EBONY_LOG_BLOCKS.getLog(),
                getSupplier(SPRUCE_LOG), ModBlocks.EBONY_LOG_BLOCKS.getLog(),
                ModBlocks.PALM_LOG_BLOCKS.getLog(), ModBlocks.EBONY_LOG_BLOCKS.getLog(),
                ModBlocks.PEARL_LOG_BLOCKS.getLog(), ModBlocks.EBONY_LOG_BLOCKS.getLog(),
                // 树皮
                getSupplier(OAK_WOOD), ModBlocks.EBONY_LOG_BLOCKS.getWood(),
                getSupplier(ACACIA_WOOD), ModBlocks.EBONY_LOG_BLOCKS.getWood(),
                getSupplier(BIRCH_WOOD), ModBlocks.EBONY_LOG_BLOCKS.getWood(),
                getSupplier(CHERRY_WOOD), ModBlocks.EBONY_LOG_BLOCKS.getWood(),
                getSupplier(JUNGLE_WOOD), ModBlocks.EBONY_LOG_BLOCKS.getWood(),
                getSupplier(DARK_OAK_WOOD), ModBlocks.EBONY_LOG_BLOCKS.getWood(),
                getSupplier(MANGROVE_WOOD), ModBlocks.EBONY_LOG_BLOCKS.getWood(),
                getSupplier(SPRUCE_WOOD), ModBlocks.EBONY_LOG_BLOCKS.getWood(),
                ModBlocks.PALM_LOG_BLOCKS.getWood(), ModBlocks.EBONY_LOG_BLOCKS.getWood(),
                ModBlocks.PEARL_LOG_BLOCKS.getWood(), ModBlocks.EBONY_LOG_BLOCKS.getWood(),

                // 去皮原木
                getSupplier(STRIPPED_ACACIA_LOG), ModBlocks.EBONY_LOG_BLOCKS.getStrippedLog(),
                getSupplier(STRIPPED_CHERRY_LOG), ModBlocks.EBONY_LOG_BLOCKS.getStrippedLog(),
                getSupplier(STRIPPED_BIRCH_LOG), ModBlocks.EBONY_LOG_BLOCKS.getStrippedLog(),
                getSupplier(STRIPPED_DARK_OAK_LOG), ModBlocks.EBONY_LOG_BLOCKS.getStrippedLog(),
                getSupplier(STRIPPED_OAK_LOG), ModBlocks.EBONY_LOG_BLOCKS.getStrippedLog(),
                getSupplier(STRIPPED_MANGROVE_LOG), ModBlocks.EBONY_LOG_BLOCKS.getStrippedLog(),
                getSupplier(STRIPPED_SPRUCE_LOG), ModBlocks.EBONY_LOG_BLOCKS.getStrippedLog(),
                ModBlocks.PALM_LOG_BLOCKS.getStrippedLog(), ModBlocks.EBONY_LOG_BLOCKS.getStrippedLog(),
                ModBlocks.PEARL_LOG_BLOCKS.getStrippedLog(), ModBlocks.EBONY_LOG_BLOCKS.getStrippedLog(),

                // 去皮树皮
                getSupplier(STRIPPED_ACACIA_WOOD), ModBlocks.EBONY_LOG_BLOCKS.getStrippedWood(),
                getSupplier(STRIPPED_CHERRY_WOOD), ModBlocks.EBONY_LOG_BLOCKS.getStrippedWood(),
                getSupplier(STRIPPED_BIRCH_WOOD), ModBlocks.EBONY_LOG_BLOCKS.getStrippedWood(),
                getSupplier(STRIPPED_DARK_OAK_WOOD), ModBlocks.EBONY_LOG_BLOCKS.getStrippedWood(),
                getSupplier(STRIPPED_OAK_WOOD), ModBlocks.EBONY_LOG_BLOCKS.getStrippedWood(),
                getSupplier(STRIPPED_MANGROVE_WOOD), ModBlocks.EBONY_LOG_BLOCKS.getStrippedWood(),
                getSupplier(STRIPPED_SPRUCE_WOOD), ModBlocks.EBONY_LOG_BLOCKS.getStrippedWood(),
                ModBlocks.PALM_LOG_BLOCKS.getStrippedWood(), ModBlocks.EBONY_LOG_BLOCKS.getStrippedWood(),
                ModBlocks.PEARL_LOG_BLOCKS.getStrippedWood(), ModBlocks.EBONY_LOG_BLOCKS.getStrippedWood(),
                // 树叶
                getSupplier(OAK_LEAVES), ModBlocks.EBONY_LOG_BLOCKS.getLeaves(),
                getSupplier(ACACIA_LEAVES), ModBlocks.EBONY_LOG_BLOCKS.getLeaves(),
                getSupplier(BIRCH_LEAVES), ModBlocks.EBONY_LOG_BLOCKS.getLeaves(),
                getSupplier(CHERRY_LEAVES), ModBlocks.EBONY_LOG_BLOCKS.getLeaves(),
                getSupplier(JUNGLE_LEAVES), ModBlocks.EBONY_LOG_BLOCKS.getLeaves(),
                getSupplier(DARK_OAK_LEAVES), ModBlocks.EBONY_LOG_BLOCKS.getLeaves(),
                getSupplier(MANGROVE_LEAVES), ModBlocks.EBONY_LOG_BLOCKS.getLeaves(),
                getSupplier(SPRUCE_LEAVES), ModBlocks.EBONY_LOG_BLOCKS.getLeaves(),
                ModBlocks.PALM_LOG_BLOCKS.getLeaves(), ModBlocks.EBONY_LOG_BLOCKS.getLeaves(),
                ModBlocks.PEARL_LOG_BLOCKS.getLeaves(), ModBlocks.EBONY_LOG_BLOCKS.getLeaves(),


                // 原版环境方块
                getSupplier(GRASS_BLOCK), ModBlocks.CORRUPT_GRASS_BLOCK,
                getSupplier(STONE), ModBlocks.EBONY_STONE,
                getSupplier(COBBLESTONE), ModBlocks.EBONY_COBBLESTONE,
                getSupplier(SANDSTONE), ModBlocks.EBONY_SANDSTONE,
                getSupplier(SAND), ModBlocks.EBONY_SAND,
                getSupplier(SHORT_GRASS), ModBlocks.CORRUPT_GRASS,
                getSupplier(TALL_GRASS), ModBlocks.CORRUPT_GRASS,
                getSupplier(ICE), ModBlocks.PURPLE_ICE,
                getSupplier(PACKED_ICE), ModBlocks.PURPLE_PACKED_ICE,
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
                ModBlocks.HALLOW_GRASS_BLOCK, ModBlocks.CORRUPT_GRASS_BLOCK,

                ModBlocks.PEARL_STONE, ModBlocks.EBONY_STONE,

                ModBlocks.PEARL_COBBLESTONE, ModBlocks.EBONY_COBBLESTONE,

                ModBlocks.HARDENED_SAND_BLOCK, ModBlocks.EBONY_HARDENED_SAND_BLOCK,
                ModBlocks.PEARL_HARDENED_SAND_BLOCK, ModBlocks.EBONY_HARDENED_SAND_BLOCK,

                ModBlocks.PEARL_SANDSTONE, ModBlocks.EBONY_SANDSTONE,

                ModBlocks.PINK_ICE, ModBlocks.PURPLE_ICE,
                ModBlocks.PINK_PACKED_ICE, ModBlocks.PURPLE_PACKED_ICE,

                // 蘑菇
                ModBlocks.LIFE_MUSHROOM, ModBlocks.EBONY_MUSHROOM,

                // 植物
                ModBlocks.HALLOW_GRASS, ModBlocks.CORRUPT_GRASS,
                ModBlocks.CRIMSON_THORN, ModBlocks.CORRUPTION_THORN,
                ModBlocks.JUNGLE_THORN, ModBlocks.CORRUPTION_THORN,
                ModBlocks.PLANTERA_THORN, ModBlocks.CORRUPTION_THORN
        ),

        GLOWING(
                getSupplier(MUD), ModBlocks.MUSHROOM_GRASS_BLOCK,
                ModBlocks.JUNGLE_SPORE, ModBlocks.GLOWING_MUSHROOM
        ),

        PURE(
                ModBlocks.ASH_BLOCK, ModBlocks.ASH_GRASS_BLOCK,
                getSupplier(MUD), ModBlocks.MUSHROOM_GRASS_BLOCK,
                ModBlocks.TR_CRIMSON_MUSHROOM, ModBlocks.LIFE_MUSHROOM,
                ModBlocks.EBONY_MUSHROOM, ModBlocks.LIFE_MUSHROOM,
                ModBlocks.CORRUPT_GRASS, getSupplier(SHORT_GRASS),
                ModBlocks.TR_CRIMSON_GRASS, getSupplier(SHORT_GRASS),
                ModBlocks.HALLOW_GRASS, getSupplier(SHORT_GRASS),
                ModBlocks.TR_CRIMSON_STONE, getSupplier(STONE),
                ModBlocks.TR_CRIMSON_SAND, getSupplier(SAND),
                ModBlocks.TR_CRIMSON_GRASS_BLOCK, getSupplier(GRASS_BLOCK),
                ModBlocks.CORRUPT_GRASS_BLOCK, getSupplier(GRASS_BLOCK),
                ModBlocks.HALLOW_GRASS_BLOCK, getSupplier(GRASS_BLOCK),
                ModBlocks.CRIMSON_THORN, getSupplier(AIR),
                ModBlocks.CORRUPTION_THORN, getSupplier(AIR)
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
