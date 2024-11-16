package org.confluence.mod.common.block.natural.spreadable;

import com.google.common.collect.ImmutableMap;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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
            if (targetBlock == null || beforeTransformState.is(Blocks.SHORT_GRASS) || beforeTransformState.is(Blocks.FERN) || beforeTransformState.is(Blocks.TALL_GRASS)) {
                continue; // 不要直接传播草
            }
            if (beforeTransformState.is(Blocks.DIRT) || beforeTransformState.is(ModBlocks.ASH_BLOCK.get())) {
                if (!isFullBlock(serverLevel, targetPos.above())) {
                    spreadOrDie(phase, blockState, serverLevel, blockPos, randomSource, targetBlock.defaultBlockState(), targetPos);
                }
            } else {
                spreadOrDie(phase, blockState, serverLevel, blockPos, randomSource, targetBlock.defaultBlockState(), targetPos);
            }
            BlockState above = serverLevel.getBlockState(targetPos.above());
            if (above.is(Blocks.SHORT_GRASS) || above.is(Blocks.FERN) || above.is(Blocks.TALL_GRASS)) {  // 被动传播草
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
            () -> Blocks.DIRT, ModBlocks.HALLOW_GRASS_BLOCK,
            // 原木
            () -> Blocks.OAK_LOG, ModBlocks.PEARL_LOG_BLOCKS.getLog(),
            () -> Blocks.ACACIA_LOG, ModBlocks.PEARL_LOG_BLOCKS.getLog(),
            () -> Blocks.BIRCH_LOG, ModBlocks.PEARL_LOG_BLOCKS.getLog(),
            () -> Blocks.CHERRY_LOG, ModBlocks.PEARL_LOG_BLOCKS.getLog(),
            () -> Blocks.JUNGLE_LOG, ModBlocks.PEARL_LOG_BLOCKS.getLog(),
            () -> Blocks.DARK_OAK_LOG, ModBlocks.PEARL_LOG_BLOCKS.getLog(),
            () -> Blocks.MANGROVE_LOG, ModBlocks.PEARL_LOG_BLOCKS.getLog(),
            () -> Blocks.SPRUCE_LOG, ModBlocks.PEARL_LOG_BLOCKS.getLog(),
            ModBlocks.PALM_LOG_BLOCKS.getLog(), ModBlocks.PEARL_LOG_BLOCKS.getLog(),
            ModBlocks.EBONY_LOG_BLOCKS.getLog(), ModBlocks.PEARL_LOG_BLOCKS.getLog(),
            ModBlocks.SHADOW_LOG_BLOCKS.getLog(), ModBlocks.PEARL_LOG_BLOCKS.getLog(),
            // 树皮
            () -> Blocks.OAK_WOOD, ModBlocks.PEARL_LOG_BLOCKS.getWood(),
            () -> Blocks.ACACIA_WOOD, ModBlocks.PEARL_LOG_BLOCKS.getWood(),
            () -> Blocks.BIRCH_WOOD, ModBlocks.PEARL_LOG_BLOCKS.getWood(),
            () -> Blocks.CHERRY_WOOD, ModBlocks.PEARL_LOG_BLOCKS.getWood(),
            () -> Blocks.JUNGLE_WOOD, ModBlocks.PEARL_LOG_BLOCKS.getWood(),
            () -> Blocks.DARK_OAK_WOOD, ModBlocks.PEARL_LOG_BLOCKS.getWood(),
            () -> Blocks.MANGROVE_WOOD, ModBlocks.PEARL_LOG_BLOCKS.getWood(),
            () -> Blocks.SPRUCE_WOOD, ModBlocks.PEARL_LOG_BLOCKS.getWood(),
            ModBlocks.PALM_LOG_BLOCKS.getWood(), ModBlocks.PEARL_LOG_BLOCKS.getWood(),
            ModBlocks.EBONY_LOG_BLOCKS.getWood(), ModBlocks.PEARL_LOG_BLOCKS.getWood(),
            ModBlocks.SHADOW_LOG_BLOCKS.getWood(), ModBlocks.PEARL_LOG_BLOCKS.getWood(),
            // 去皮原木
            () -> Blocks.STRIPPED_ACACIA_LOG, ModBlocks.PEARL_LOG_BLOCKS.getStrippedLog(),
            () -> Blocks.STRIPPED_CHERRY_LOG, ModBlocks.PEARL_LOG_BLOCKS.getStrippedLog(),
            () -> Blocks.STRIPPED_BIRCH_LOG, ModBlocks.PEARL_LOG_BLOCKS.getStrippedLog(),
            () -> Blocks.STRIPPED_DARK_OAK_LOG, ModBlocks.PEARL_LOG_BLOCKS.getStrippedLog(),
            () -> Blocks.STRIPPED_OAK_LOG, ModBlocks.PEARL_LOG_BLOCKS.getStrippedLog(),
            () -> Blocks.STRIPPED_MANGROVE_LOG, ModBlocks.PEARL_LOG_BLOCKS.getStrippedLog(),
            () -> Blocks.STRIPPED_SPRUCE_LOG, ModBlocks.PEARL_LOG_BLOCKS.getStrippedLog(),
            ModBlocks.PALM_LOG_BLOCKS.getStrippedLog(), ModBlocks.PEARL_LOG_BLOCKS.getStrippedLog(),
            ModBlocks.EBONY_LOG_BLOCKS.getStrippedLog(), ModBlocks.PEARL_LOG_BLOCKS.getStrippedLog(),
            ModBlocks.SHADOW_LOG_BLOCKS.getStrippedLog(), ModBlocks.PEARL_LOG_BLOCKS.getStrippedLog(),
            // 去皮树皮
            () -> Blocks.STRIPPED_ACACIA_WOOD, ModBlocks.PEARL_LOG_BLOCKS.getStrippedWood(),
            () -> Blocks.STRIPPED_CHERRY_WOOD, ModBlocks.PEARL_LOG_BLOCKS.getStrippedWood(),
            () -> Blocks.STRIPPED_BIRCH_WOOD, ModBlocks.PEARL_LOG_BLOCKS.getStrippedWood(),
            () -> Blocks.STRIPPED_DARK_OAK_WOOD, ModBlocks.PEARL_LOG_BLOCKS.getStrippedWood(),
            () -> Blocks.STRIPPED_OAK_WOOD, ModBlocks.PEARL_LOG_BLOCKS.getStrippedWood(),
            () -> Blocks.STRIPPED_MANGROVE_WOOD, ModBlocks.PEARL_LOG_BLOCKS.getStrippedWood(),
            () -> Blocks.STRIPPED_SPRUCE_WOOD, ModBlocks.PEARL_LOG_BLOCKS.getStrippedWood(),
            ModBlocks.PALM_LOG_BLOCKS.getStrippedWood(), ModBlocks.PEARL_LOG_BLOCKS.getStrippedWood(),
            ModBlocks.EBONY_LOG_BLOCKS.getStrippedWood(), ModBlocks.PEARL_LOG_BLOCKS.getStrippedWood(),
            ModBlocks.SHADOW_LOG_BLOCKS.getStrippedWood(), ModBlocks.PEARL_LOG_BLOCKS.getStrippedWood(),
            // 树叶
            () -> Blocks.OAK_LEAVES, ModBlocks.PEARL_LOG_BLOCKS.getLeaves(),
            () -> Blocks.ACACIA_LEAVES, ModBlocks.PEARL_LOG_BLOCKS.getLeaves(),
            () -> Blocks.BIRCH_LEAVES, ModBlocks.PEARL_LOG_BLOCKS.getLeaves(),
            () -> Blocks.CHERRY_LEAVES, ModBlocks.PEARL_LOG_BLOCKS.getLeaves(),
            () -> Blocks.JUNGLE_LEAVES, ModBlocks.PEARL_LOG_BLOCKS.getLeaves(),
            () -> Blocks.DARK_OAK_LEAVES, ModBlocks.PEARL_LOG_BLOCKS.getLeaves(),
            () -> Blocks.MANGROVE_LEAVES, ModBlocks.PEARL_LOG_BLOCKS.getLeaves(),
            () -> Blocks.SPRUCE_LEAVES, ModBlocks.PEARL_LOG_BLOCKS.getLeaves(),
            ModBlocks.PALM_LOG_BLOCKS.getLeaves(), ModBlocks.PEARL_LOG_BLOCKS.getLeaves(),
            ModBlocks.EBONY_LOG_BLOCKS.getLeaves(), ModBlocks.PEARL_LOG_BLOCKS.getLeaves(),
            ModBlocks.SHADOW_LOG_BLOCKS.getLeaves(), ModBlocks.PEARL_LOG_BLOCKS.getLeaves(),

            // 原版环境方块
            () -> Blocks.GRASS_BLOCK, ModBlocks.HALLOW_GRASS_BLOCK,
            () -> Blocks.STONE, ModBlocks.PEARL_STONE,
            () -> Blocks.COBBLESTONE, ModBlocks.PEARL_COBBLESTONE,
            () -> Blocks.SANDSTONE, ModBlocks.PEARL_SANDSTONE,
            () -> Blocks.SAND, ModBlocks.PEARL_SAND,
            () -> Blocks.SHORT_GRASS, ModBlocks.HALLOW_GRASS,
            () -> Blocks.TALL_GRASS, ModBlocks.HALLOW_GRASS,
            () -> Blocks.ICE, ModBlocks.PINK_ICE,
            () -> Blocks.PACKED_ICE, ModBlocks.PINK_PACKED_ICE,
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
            () -> Blocks.REDSTONE_ORE, OreBlocks.SANCTIFICATION_REDSTONE_ORE,
            () -> Blocks.COAL_ORE, OreBlocks.SANCTIFICATION_COAL_ORE,
            () -> Blocks.LAPIS_ORE, OreBlocks.SANCTIFICATION_LAPIS_ORE,
            () -> Blocks.COPPER_ORE, OreBlocks.SANCTIFICATION_COPPER_ORE,
            () -> Blocks.IRON_ORE, OreBlocks.SANCTIFICATION_IRON_ORE,
            () -> Blocks.EMERALD_ORE, OreBlocks.SANCTIFICATION_EMERALD_ORE,
            () -> Blocks.DIAMOND_ORE, OreBlocks.SANCTIFICATION_DIAMOND_ORE,
            () -> Blocks.GOLD_ORE, OreBlocks.SANCTIFICATION_GOLD_ORE,
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
            ModBlocks.CRIMSON_THORN, () -> Blocks.AIR,
            ModBlocks.CORRUPTION_THORN, () -> Blocks.AIR,
            ModBlocks.JUNGLE_THORN, () -> Blocks.AIR,
            ModBlocks.PLANTERA_THORN, () -> Blocks.AIR
        ),

        CRIMSON(
            () -> Blocks.DIRT, ModBlocks.TR_CRIMSON_GRASS_BLOCK,
            // 原木
            () -> Blocks.OAK_LOG, ModBlocks.SHADOW_LOG_BLOCKS.getLog(),
            () -> Blocks.ACACIA_LOG, ModBlocks.SHADOW_LOG_BLOCKS.getLog(),
            () -> Blocks.BIRCH_LOG, ModBlocks.SHADOW_LOG_BLOCKS.getLog(),
            () -> Blocks.CHERRY_LOG, ModBlocks.SHADOW_LOG_BLOCKS.getLog(),
            () -> Blocks.JUNGLE_LOG, ModBlocks.SHADOW_LOG_BLOCKS.getLog(),
            () -> Blocks.DARK_OAK_LOG, ModBlocks.SHADOW_LOG_BLOCKS.getLog(),
            () -> Blocks.MANGROVE_LOG, ModBlocks.SHADOW_LOG_BLOCKS.getLog(),
            () -> Blocks.SPRUCE_LOG, ModBlocks.SHADOW_LOG_BLOCKS.getLog(),
            ModBlocks.PALM_LOG_BLOCKS.getLog(), ModBlocks.SHADOW_LOG_BLOCKS.getLog(),

            // 树皮
            () -> Blocks.OAK_WOOD, ModBlocks.SHADOW_LOG_BLOCKS.getWood(),
            () -> Blocks.ACACIA_WOOD, ModBlocks.SHADOW_LOG_BLOCKS.getWood(),
            () -> Blocks.BIRCH_WOOD, ModBlocks.SHADOW_LOG_BLOCKS.getWood(),
            () -> Blocks.CHERRY_WOOD, ModBlocks.SHADOW_LOG_BLOCKS.getWood(),
            () -> Blocks.JUNGLE_WOOD, ModBlocks.SHADOW_LOG_BLOCKS.getWood(),
            () -> Blocks.DARK_OAK_WOOD, ModBlocks.SHADOW_LOG_BLOCKS.getWood(),
            () -> Blocks.MANGROVE_WOOD, ModBlocks.SHADOW_LOG_BLOCKS.getWood(),
            () -> Blocks.SPRUCE_WOOD, ModBlocks.SHADOW_LOG_BLOCKS.getWood(),
            ModBlocks.PALM_LOG_BLOCKS.getWood(), ModBlocks.SHADOW_LOG_BLOCKS.getWood(),

            // 去皮原木
            () -> Blocks.STRIPPED_ACACIA_LOG, ModBlocks.SHADOW_LOG_BLOCKS.getStrippedLog(),
            () -> Blocks.STRIPPED_CHERRY_LOG, ModBlocks.SHADOW_LOG_BLOCKS.getStrippedLog(),
            () -> Blocks.STRIPPED_BIRCH_LOG, ModBlocks.SHADOW_LOG_BLOCKS.getStrippedLog(),
            () -> Blocks.STRIPPED_DARK_OAK_LOG, ModBlocks.SHADOW_LOG_BLOCKS.getStrippedLog(),
            () -> Blocks.STRIPPED_OAK_LOG, ModBlocks.SHADOW_LOG_BLOCKS.getStrippedLog(),
            () -> Blocks.STRIPPED_MANGROVE_LOG, ModBlocks.SHADOW_LOG_BLOCKS.getStrippedLog(),
            () -> Blocks.STRIPPED_SPRUCE_LOG, ModBlocks.SHADOW_LOG_BLOCKS.getStrippedLog(),
            ModBlocks.PALM_LOG_BLOCKS.getStrippedLog(), ModBlocks.SHADOW_LOG_BLOCKS.getStrippedLog(),

            // 去皮树皮
            () -> Blocks.STRIPPED_ACACIA_WOOD, ModBlocks.SHADOW_LOG_BLOCKS.getStrippedWood(),
            () -> Blocks.STRIPPED_CHERRY_WOOD, ModBlocks.SHADOW_LOG_BLOCKS.getStrippedWood(),
            () -> Blocks.STRIPPED_BIRCH_WOOD, ModBlocks.SHADOW_LOG_BLOCKS.getStrippedWood(),
            () -> Blocks.STRIPPED_DARK_OAK_WOOD, ModBlocks.SHADOW_LOG_BLOCKS.getStrippedWood(),
            () -> Blocks.STRIPPED_OAK_WOOD, ModBlocks.SHADOW_LOG_BLOCKS.getStrippedWood(),
            () -> Blocks.STRIPPED_MANGROVE_WOOD, ModBlocks.SHADOW_LOG_BLOCKS.getStrippedWood(),
            () -> Blocks.STRIPPED_SPRUCE_WOOD, ModBlocks.SHADOW_LOG_BLOCKS.getStrippedWood(),
            ModBlocks.PALM_LOG_BLOCKS.getStrippedWood(), ModBlocks.SHADOW_LOG_BLOCKS.getStrippedWood(),

            // 树叶
            () -> Blocks.OAK_LEAVES, ModBlocks.SHADOW_LOG_BLOCKS.getLeaves(),
            () -> Blocks.ACACIA_LEAVES, ModBlocks.SHADOW_LOG_BLOCKS.getLeaves(),
            () -> Blocks.BIRCH_LEAVES, ModBlocks.SHADOW_LOG_BLOCKS.getLeaves(),
            () -> Blocks.CHERRY_LEAVES, ModBlocks.SHADOW_LOG_BLOCKS.getLeaves(),
            () -> Blocks.JUNGLE_LEAVES, ModBlocks.SHADOW_LOG_BLOCKS.getLeaves(),
            () -> Blocks.DARK_OAK_LEAVES, ModBlocks.SHADOW_LOG_BLOCKS.getLeaves(),
            () -> Blocks.MANGROVE_LEAVES, ModBlocks.SHADOW_LOG_BLOCKS.getLeaves(),
            () -> Blocks.SPRUCE_LEAVES, ModBlocks.SHADOW_LOG_BLOCKS.getLeaves(),
            ModBlocks.PALM_LOG_BLOCKS.getLeaves(), ModBlocks.SHADOW_LOG_BLOCKS.getLeaves(),

            // 原版环境方块
            () -> Blocks.GRASS_BLOCK, ModBlocks.TR_CRIMSON_GRASS_BLOCK,
            () -> Blocks.STONE, ModBlocks.TR_CRIMSON_STONE,
            () -> Blocks.COBBLESTONE, ModBlocks.TR_CRIMSON_COBBLESTONE,
            () -> Blocks.SANDSTONE, ModBlocks.TR_CRIMSON_SANDSTONE,
            () -> Blocks.SAND, ModBlocks.TR_CRIMSON_SAND,
            () -> Blocks.SHORT_GRASS, ModBlocks.TR_CRIMSON_GRASS,
            () -> Blocks.TALL_GRASS, ModBlocks.TR_CRIMSON_GRASS,
            () -> Blocks.ICE, ModBlocks.RED_ICE,
            () -> Blocks.PACKED_ICE, ModBlocks.RED_PACKED_ICE,
            //矿物
            () -> Blocks.REDSTONE_ORE, OreBlocks.FLESHIFICATION_REDSTONE_ORE,
            () -> Blocks.COAL_ORE, OreBlocks.FLESHIFICATION_COAL_ORE,
            () -> Blocks.LAPIS_ORE, OreBlocks.FLESHIFICATION_LAPIS_ORE,
            () -> Blocks.COPPER_ORE, OreBlocks.FLESHIFICATION_COPPER_ORE,
            () -> Blocks.IRON_ORE, OreBlocks.FLESHIFICATION_IRON_ORE,
            () -> Blocks.EMERALD_ORE, OreBlocks.FLESHIFICATION_EMERALD_ORE,
            () -> Blocks.DIAMOND_ORE, OreBlocks.FLESHIFICATION_DIAMOND_ORE,
            () -> Blocks.GOLD_ORE, OreBlocks.FLESHIFICATION_GOLD_ORE,
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
            () -> Blocks.DIRT, ModBlocks.CORRUPT_GRASS_BLOCK,
            // 原木
            () -> Blocks.OAK_LOG, ModBlocks.EBONY_LOG_BLOCKS.getLog(),
            () -> Blocks.ACACIA_LOG, ModBlocks.EBONY_LOG_BLOCKS.getLog(),
            () -> Blocks.BIRCH_LOG, ModBlocks.EBONY_LOG_BLOCKS.getLog(),
            () -> Blocks.CHERRY_LOG, ModBlocks.EBONY_LOG_BLOCKS.getLog(),
            () -> Blocks.JUNGLE_LOG, ModBlocks.EBONY_LOG_BLOCKS.getLog(),
            () -> Blocks.DARK_OAK_LOG, ModBlocks.EBONY_LOG_BLOCKS.getLog(),
            () -> Blocks.MANGROVE_LOG, ModBlocks.EBONY_LOG_BLOCKS.getLog(),
            () -> Blocks.SPRUCE_LOG, ModBlocks.EBONY_LOG_BLOCKS.getLog(),
            ModBlocks.PALM_LOG_BLOCKS.getLog(), ModBlocks.EBONY_LOG_BLOCKS.getLog(),
            ModBlocks.PEARL_LOG_BLOCKS.getLog(), ModBlocks.EBONY_LOG_BLOCKS.getLog(),
            // 树皮
            () -> Blocks.OAK_WOOD, ModBlocks.EBONY_LOG_BLOCKS.getWood(),
            () -> Blocks.ACACIA_WOOD, ModBlocks.EBONY_LOG_BLOCKS.getWood(),
            () -> Blocks.BIRCH_WOOD, ModBlocks.EBONY_LOG_BLOCKS.getWood(),
            () -> Blocks.CHERRY_WOOD, ModBlocks.EBONY_LOG_BLOCKS.getWood(),
            () -> Blocks.JUNGLE_WOOD, ModBlocks.EBONY_LOG_BLOCKS.getWood(),
            () -> Blocks.DARK_OAK_WOOD, ModBlocks.EBONY_LOG_BLOCKS.getWood(),
            () -> Blocks.MANGROVE_WOOD, ModBlocks.EBONY_LOG_BLOCKS.getWood(),
            () -> Blocks.SPRUCE_WOOD, ModBlocks.EBONY_LOG_BLOCKS.getWood(),
            ModBlocks.PALM_LOG_BLOCKS.getWood(), ModBlocks.EBONY_LOG_BLOCKS.getWood(),
            ModBlocks.PEARL_LOG_BLOCKS.getWood(), ModBlocks.EBONY_LOG_BLOCKS.getWood(),

            // 去皮原木
            () -> Blocks.STRIPPED_ACACIA_LOG, ModBlocks.EBONY_LOG_BLOCKS.getStrippedLog(),
            () -> Blocks.STRIPPED_CHERRY_LOG, ModBlocks.EBONY_LOG_BLOCKS.getStrippedLog(),
            () -> Blocks.STRIPPED_BIRCH_LOG, ModBlocks.EBONY_LOG_BLOCKS.getStrippedLog(),
            () -> Blocks.STRIPPED_DARK_OAK_LOG, ModBlocks.EBONY_LOG_BLOCKS.getStrippedLog(),
            () -> Blocks.STRIPPED_OAK_LOG, ModBlocks.EBONY_LOG_BLOCKS.getStrippedLog(),
            () -> Blocks.STRIPPED_MANGROVE_LOG, ModBlocks.EBONY_LOG_BLOCKS.getStrippedLog(),
            () -> Blocks.STRIPPED_SPRUCE_LOG, ModBlocks.EBONY_LOG_BLOCKS.getStrippedLog(),
            ModBlocks.PALM_LOG_BLOCKS.getStrippedLog(), ModBlocks.EBONY_LOG_BLOCKS.getStrippedLog(),
            ModBlocks.PEARL_LOG_BLOCKS.getStrippedLog(), ModBlocks.EBONY_LOG_BLOCKS.getStrippedLog(),

            // 去皮树皮
            () -> Blocks.STRIPPED_ACACIA_WOOD, ModBlocks.EBONY_LOG_BLOCKS.getStrippedWood(),
            () -> Blocks.STRIPPED_CHERRY_WOOD, ModBlocks.EBONY_LOG_BLOCKS.getStrippedWood(),
            () -> Blocks.STRIPPED_BIRCH_WOOD, ModBlocks.EBONY_LOG_BLOCKS.getStrippedWood(),
            () -> Blocks.STRIPPED_DARK_OAK_WOOD, ModBlocks.EBONY_LOG_BLOCKS.getStrippedWood(),
            () -> Blocks.STRIPPED_OAK_WOOD, ModBlocks.EBONY_LOG_BLOCKS.getStrippedWood(),
            () -> Blocks.STRIPPED_MANGROVE_WOOD, ModBlocks.EBONY_LOG_BLOCKS.getStrippedWood(),
            () -> Blocks.STRIPPED_SPRUCE_WOOD, ModBlocks.EBONY_LOG_BLOCKS.getStrippedWood(),
            ModBlocks.PALM_LOG_BLOCKS.getStrippedWood(), ModBlocks.EBONY_LOG_BLOCKS.getStrippedWood(),
            ModBlocks.PEARL_LOG_BLOCKS.getStrippedWood(), ModBlocks.EBONY_LOG_BLOCKS.getStrippedWood(),
            // 树叶
            () -> Blocks.OAK_LEAVES, ModBlocks.EBONY_LOG_BLOCKS.getLeaves(),
            () -> Blocks.ACACIA_LEAVES, ModBlocks.EBONY_LOG_BLOCKS.getLeaves(),
            () -> Blocks.BIRCH_LEAVES, ModBlocks.EBONY_LOG_BLOCKS.getLeaves(),
            () -> Blocks.CHERRY_LEAVES, ModBlocks.EBONY_LOG_BLOCKS.getLeaves(),
            () -> Blocks.JUNGLE_LEAVES, ModBlocks.EBONY_LOG_BLOCKS.getLeaves(),
            () -> Blocks.DARK_OAK_LEAVES, ModBlocks.EBONY_LOG_BLOCKS.getLeaves(),
            () -> Blocks.MANGROVE_LEAVES, ModBlocks.EBONY_LOG_BLOCKS.getLeaves(),
            () -> Blocks.SPRUCE_LEAVES, ModBlocks.EBONY_LOG_BLOCKS.getLeaves(),
            ModBlocks.PALM_LOG_BLOCKS.getLeaves(), ModBlocks.EBONY_LOG_BLOCKS.getLeaves(),
            ModBlocks.PEARL_LOG_BLOCKS.getLeaves(), ModBlocks.EBONY_LOG_BLOCKS.getLeaves(),


            // 原版环境方块
            () -> Blocks.GRASS_BLOCK, ModBlocks.CORRUPT_GRASS_BLOCK,
            () -> Blocks.STONE, ModBlocks.EBONY_STONE,
            () -> Blocks.COBBLESTONE, ModBlocks.EBONY_COBBLESTONE,
            () -> Blocks.SANDSTONE, ModBlocks.EBONY_SANDSTONE,
            () -> Blocks.SAND, ModBlocks.EBONY_SAND,
            () -> Blocks.SHORT_GRASS, ModBlocks.CORRUPT_GRASS,
            () -> Blocks.TALL_GRASS, ModBlocks.CORRUPT_GRASS,
            () -> Blocks.ICE, ModBlocks.PURPLE_ICE,
            () -> Blocks.PACKED_ICE, ModBlocks.PURPLE_PACKED_ICE,
            //矿物
            () -> Blocks.REDSTONE_ORE, OreBlocks.CORRUPTION_REDSTONE_ORE,
            () -> Blocks.COAL_ORE, OreBlocks.CORRUPTION_COAL_ORE,
            () -> Blocks.LAPIS_ORE, OreBlocks.CORRUPTION_LAPIS_ORE,
            () -> Blocks.COPPER_ORE, OreBlocks.CORRUPTION_COPPER_ORE,
            () -> Blocks.IRON_ORE, OreBlocks.CORRUPTION_IRON_ORE,
            () -> Blocks.EMERALD_ORE, OreBlocks.CORRUPTION_EMERALD_ORE,
            () -> Blocks.DIAMOND_ORE, OreBlocks.CORRUPTION_DIAMOND_ORE,
            () -> Blocks.GOLD_ORE, OreBlocks.CORRUPTION_GOLD_ORE,
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
            () -> Blocks.MUD, ModBlocks.MUSHROOM_GRASS_BLOCK,
            ModBlocks.JUNGLE_SPORE, ModBlocks.GLOWING_MUSHROOM
        ),

        PURE(
            ModBlocks.ASH_BLOCK, ModBlocks.ASH_GRASS_BLOCK,
            () -> Blocks.MUD, ModBlocks.MUSHROOM_GRASS_BLOCK,
            ModBlocks.TR_CRIMSON_MUSHROOM, ModBlocks.LIFE_MUSHROOM,
            ModBlocks.EBONY_MUSHROOM, ModBlocks.LIFE_MUSHROOM,
            ModBlocks.CORRUPT_GRASS, () -> Blocks.SHORT_GRASS,
            ModBlocks.TR_CRIMSON_GRASS, () -> Blocks.SHORT_GRASS,
            ModBlocks.HALLOW_GRASS, () -> Blocks.SHORT_GRASS,
            ModBlocks.TR_CRIMSON_STONE, () -> Blocks.STONE,
            ModBlocks.TR_CRIMSON_SAND, () -> Blocks.SAND,
            ModBlocks.TR_CRIMSON_GRASS_BLOCK, () -> Blocks.GRASS_BLOCK,
            ModBlocks.CORRUPT_GRASS_BLOCK, () -> Blocks.GRASS_BLOCK,
            ModBlocks.HALLOW_GRASS_BLOCK, () -> Blocks.GRASS_BLOCK,
            ModBlocks.CRIMSON_THORN, () -> Blocks.AIR,
            ModBlocks.CORRUPTION_THORN, () -> Blocks.AIR
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
