package org.confluence.mod.worldgen.feature;

/*
public class BoulderTrapFeature extends Feature<BoulderTrapFeature.Config> {
    public BoulderTrapFeature(Codec<Config> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<Config> pContext) {
        Config config = pContext.config();
        Block block = config.variant.get();
        if (block == null) return false;
        WorldGenLevel level = pContext.level();
        BlockPos blockPos = pContext.origin();
        if (ModFeatures.isPosAir(level, blockPos)) {
            Optional<Column> optionalColumn = Column.scan(level, blockPos, config.maxHeight, BlockBehaviour.BlockStateBase::isAir, blockState -> blockState.is(BlockTags.BASE_STONE_OVERWORLD));
            if (optionalColumn.isPresent() && optionalColumn.get() instanceof Column.Range range && range.height() > 4) {
                BlockPos supportPos = blockPos.atY(range.floor());
                if (ModFeatures.isPosSturdy(level, supportPos, Direction.UP)) {
                    BlockPos boulderPos = blockPos.atY(range.ceiling());
                    BlockPos platePos = blockPos.atY(range.floor() + 1);
                    safeSetBlock(level, boulderPos, block.defaultBlockState(), ModFeatures.IS_REPLACEABLE);
                    safeSetBlock(level, platePos, ModFeatures.getPressurePlate(level, supportPos), ModFeatures.IS_REPLACEABLE);
                    AbstractMechanicalBlock.Entity boulder = ModFeatures.getMechanicalEntity(level, boulderPos);
                    AbstractMechanicalBlock.Entity plate = ModFeatures.getMechanicalEntity(level, platePos);
                    if (boulder != null && plate != null) boulder.connectTo(0xFF0000, platePos, plate);
                    return true;
                }
            }
        }
        return false;
    }


    public record Config(BoulderBlock.Variant variant, int maxHeight) implements FeatureConfiguration {
        public static final Codec<Config> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            BoulderBlock.Variant.CODEC.fieldOf("variant").orElse(BoulderBlock.Variant.NORMAL).forGetter(Config::variant),
            ExtraCodecs.POSITIVE_INT.fieldOf("max_height").orElse(64).forGetter(Config::maxHeight)
        ).apply(instance, Config::new));
    }
}
 */
