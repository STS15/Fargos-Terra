package org.confluence.mod.common.worldgen.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import org.confluence.mod.mixed.IWorldGenRegion;

import java.util.ArrayList;
import java.util.List;


public class QueenBeeHiveFeature extends Feature<QueenBeeHiveFeature.Config> {
    public QueenBeeHiveFeature(Codec<Config> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<Config> pContext) {
        Config config = pContext.config();
        WorldGenLevel level = pContext.level();
        IWorldGenRegion worldGenRegion = (IWorldGenRegion) level;
        BlockPos hiveBlockPos = pContext.origin();
        BlockState honeyState = config.honey().getState(pContext.random(), hiveBlockPos);
        BlockState hiveBlockState = config.hive_block().getState(pContext.random(), hiveBlockPos);

        List<BlockPos> listOfS = new ArrayList<>();

        int radius = config.radius;
        int y_to_honey = config.y_to_honey;
        int interRadius = radius / 2;
        for (int xPos = -interRadius - 1; xPos <= interRadius; xPos++) {
            for (int yPos = -interRadius - 1; yPos <= interRadius; yPos++) {
                for (int zPos = -interRadius - 1; zPos <= interRadius; zPos++) {
                    float distance = (float) Math.sqrt(xPos * xPos + yPos * yPos + zPos * zPos);
                    if (distance <= interRadius && pContext.random().nextInt(100) <= 1) {
                        BlockPos newPos = new BlockPos(xPos + hiveBlockPos.getX(), yPos + hiveBlockPos.getY(), zPos + hiveBlockPos.getZ());
                        listOfS.add(newPos);
                    }
                }
            }
        }
        for (int list = 0; list < listOfS.size(); list++) {
            for (int xPos = -interRadius - 1; xPos <= interRadius; xPos++) {
                for (int yPos = -interRadius - 1; yPos <= interRadius; yPos++) {
                    for (int zPos = -interRadius - 1; zPos <= interRadius; zPos++) {
                        float distance = (float) Math.sqrt(xPos * xPos + yPos * yPos + zPos * zPos);
                        if (distance <= interRadius) {
                            BlockPos newPos = new BlockPos(xPos + listOfS.get(list).getX(), yPos + listOfS.get(list).getY(), zPos + listOfS.get(list).getZ());
                            if ((level.getBlockState(newPos) != Blocks.CAVE_AIR.defaultBlockState() && level.getBlockState(newPos) != honeyState) && distance >= interRadius - 3) {
                                worldGenRegion.confluence$setBlock(newPos, hiveBlockState, 2);
                            }
                            if (distance < interRadius - 3 && newPos.getY() <= hiveBlockPos.getY() + y_to_honey) {
                                worldGenRegion.confluence$setBlock(newPos, honeyState, 2);
                            }
                            if (distance < interRadius - 3 && newPos.getY() > hiveBlockPos.getY() + y_to_honey) {
                                worldGenRegion.confluence$setBlock(newPos, Blocks.CAVE_AIR.defaultBlockState(), 2);
                            }
                        }
                    }
                }
            }
        }

        return true;
    }

    public record Config(BlockStateProvider hive_block, BlockStateProvider honey, int radius, int y_to_honey) implements FeatureConfiguration {
        public static final Codec<Config> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                BlockStateProvider.CODEC.fieldOf("hive_block").forGetter(Config::hive_block),
                BlockStateProvider.CODEC.fieldOf("honey").forGetter(Config::honey),
                Codec.INT.fieldOf("radius").forGetter(Config::radius),
                Codec.INT.fieldOf("y_to_honey").forGetter(Config::y_to_honey)
        ).apply(instance, Config::new));
    }
}
