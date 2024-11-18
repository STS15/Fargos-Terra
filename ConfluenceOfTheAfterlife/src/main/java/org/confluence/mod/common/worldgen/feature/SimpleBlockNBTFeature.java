package org.confluence.mod.common.worldgen.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import org.confluence.mod.mixed.IWorldGenRegion;

public class SimpleBlockNBTFeature extends Feature<SimpleBlockNBTFeature.Config> {
    public SimpleBlockNBTFeature(Codec<Config> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<Config> pContext) {
        Config config = pContext.config();
        WorldGenLevel level = pContext.level();
        BlockPos blockPos = pContext.origin();
        BlockState blockState = config.toPlace().getState(pContext.random(), blockPos);
        if (blockState.canSurvive(level, blockPos)) {
            ((IWorldGenRegion) level).confluence$setBlock(blockPos, blockState, 2);
            BlockEntity blockEntity = ModFeatures.getBlockEntity(level, blockPos);
            if (blockEntity != null) blockEntity.loadWithComponents(config.nbt, level.registryAccess());
            return true;
        }
        return false;
    }

    public record Config(BlockStateProvider toPlace, CompoundTag nbt) implements FeatureConfiguration {
        public static final Codec<Config> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                BlockStateProvider.CODEC.fieldOf("to_place").forGetter(Config::toPlace),
                CompoundTag.CODEC.fieldOf("nbt").forGetter(Config::nbt)
        ).apply(instance, Config::new));
    }
}
