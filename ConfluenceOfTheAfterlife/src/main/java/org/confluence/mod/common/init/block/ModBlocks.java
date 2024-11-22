package org.confluence.mod.common.init.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.confluence.mod.Confluence;
import org.confluence.mod.common.block.common.AetheriumCauldronBlock;
import org.confluence.mod.common.block.common.HoneyCauldronBlock;
import org.confluence.mod.common.block.natural.*;
import org.confluence.mod.common.block.natural.herbs.*;
import org.confluence.mod.common.init.ModFluids;
import org.confluence.mod.common.init.item.ModItems;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;
import java.util.function.Supplier;

public final class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Confluence.MODID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Confluence.MODID);

    public static final Supplier<BlockEntityType<SignBlockEntity>> SIGN_BLOCK_ENTITY = BLOCK_ENTITIES.register("sign_block_entity", () -> BlockEntityType.Builder.of(SignBlockEntity::new, LogBlockSet.getSignBlocks()).build(null));

    public static final Supplier<CoinPileBlock> COPPER_COIN_PILE = registerWithoutItem("copper_coin_pile", CoinPileBlock::new);
    public static final Supplier<CoinPileBlock> SILVER_COIN_PILE = registerWithoutItem("silver_coin_pile", CoinPileBlock::new);
    public static final Supplier<CoinPileBlock> GOLDEN_COIN_PILE = registerWithoutItem("golden_coin_pile", CoinPileBlock::new);
    public static final Supplier<CoinPileBlock> PLATINUM_COIN_PILE = registerWithoutItem("platinum_coin_pile", CoinPileBlock::new);

    public static final Supplier<SwordInStoneBlock> SWORD_IN_STONE = registerWithItem("sword_in_stone", SwordInStoneBlock::new);
    public static final Supplier<CrackedBrickBlock> CRACKED_BLUE_BRICK = registerWithItem("cracked_blue_block", CrackedBrickBlock::new);
    public static final Supplier<CrackedBrickBlock> CRACKED_GREEN_BRICK = registerWithItem("cracked_green_block", CrackedBrickBlock::new);
    public static final Supplier<CrackedBrickBlock> CRACKED_PINK_BRICK = registerWithItem("cracked_pink_block", CrackedBrickBlock::new);
    public static final Supplier<CrispyHoneyBlock> CRISPY_HONEY_BLOCK = registerWithItem("crispy_honey_block", CrispyHoneyBlock::new);

    // 流体
    public static final Supplier<LiquidBlock> HONEY = registerWithoutItem("honey", () -> new LiquidBlock(ModFluids.HONEY.fluid().get(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).mapColor(MapColor.COLOR_YELLOW)));
    public static final Supplier<LiquidBlock> SHIMMER = registerWithoutItem("shimmer", () -> new LiquidBlock(ModFluids.SHIMMER.fluid().get(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).mapColor(MapColor.COLOR_PINK).lightLevel(blockState -> 10)) {
        @Override
        public @NotNull ItemStack pickupBlock(@Nullable Player player, @NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockState state) {
            return ItemStack.EMPTY;
        }
    });
    public static final Supplier<AetheriumCauldronBlock> AETHERIUM_CAULDRON = registerWithItem("aetherium_cauldron", () -> new AetheriumCauldronBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WATER_CAULDRON)));
    public static final Supplier<HoneyCauldronBlock> HONEY_CAULDRON = registerWithItem("honey_cauldron", () -> new HoneyCauldronBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WATER_CAULDRON)));

    // 草药
    public static final DeferredBlock<BaseHerbBlock> WATERLEAF = registerWithoutItem("waterleaf", Waterleaf::new);//幌菊
    public static final DeferredBlock<FlameFlower> FLAMEFLOWERS = registerWithoutItem("flameflowers", FlameFlower::new);//火焰花
    public static final DeferredBlock<MoonshineGrass> MOONSHINE_GRASS = registerWithoutItem("moonshine_grass", MoonshineGrass::new);//月光草
    public static final DeferredBlock<BaseHerbBlock> SHINE_ROOT = registerWithoutItem("shine_root", ShineRoot::new);//闪耀根
    public static final DeferredBlock<BaseHerbBlock> SHIVERINGTHORNS = registerWithoutItem("shiveringthorns", ShiveringThorn::new);//寒颤棘
    public static final DeferredBlock<BaseHerbBlock> SUNFLOWERS = registerWithoutItem("sunflowers", SunFlower::new);//太阳花
    public static final DeferredBlock<DeathWeed> DEATHWEED = registerWithoutItem("deathweed", DeathWeed::new);//死亡草
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BaseHerbBlock.Entity>> HERBS_ENTITY = BLOCK_ENTITIES.register("herbs_entity", () -> BlockEntityType.Builder.of(BaseHerbBlock.Entity::new,
            WATERLEAF.get(), FLAMEFLOWERS.get(), MOONSHINE_GRASS.get(), SHINE_ROOT.get(), SHIVERINGTHORNS.get(), SUNFLOWERS.get(), DEATHWEED.get()).build(null));

    public static <B extends Block> DeferredBlock<B> registerWithItem(String id, Supplier<B> block) {
        return registerWithItem(id, block, new Item.Properties());
    }

    public static <B extends Block> DeferredBlock<B> registerWithItem(String id, Supplier<B> block, Function<Supplier<B>, Supplier<BlockItem>> item) {
        DeferredBlock<B> object = BLOCKS.register(id, block);
        ModItems.BLOCK_ITEMS.register(id, item.apply(object));
        return object;
    }

    public static <B extends Block> DeferredBlock<B> registerWithItem(String id, Supplier<B> block, Item.Properties properties) {
        DeferredBlock<B> object = BLOCKS.register(id, block);
        ModItems.BLOCK_ITEMS.registerSimpleBlockItem(object, properties);
        return object;
    }

    public static <B extends Block> DeferredBlock<B> registerWithoutItem(String id, Supplier<B> block) {
        return BLOCKS.register(id, block);
    }

    /**
     * 基于黑曜石的爆炸抗性，汇流来世的方块设置爆炸抗性时，应当使用这个方法
     *
     * @param delta 偏差值
     * @return 爆炸抗性
     */
    public static float getObsidianBasedExplosionResistance(float delta) {
        return Blocks.OBSIDIAN.getExplosionResistance() + delta;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        BLOCK_ENTITIES.register(eventBus);
        OreBlocks.BLOCKS.register(eventBus);
        DecorativeBlocks.BLOCKS.register(eventBus);
        BoxBlocks.BLOCKS.register(eventBus);
        FunctionalBlocks.register(eventBus);
        NatureBlocks.BLOCKS.register(eventBus);
    }
}
