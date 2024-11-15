package org.confluence.mod.common.init.block;

import com.mojang.datafixers.DSL;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.confluence.mod.Confluence;
import org.confluence.mod.common.block.natural.MushroomBlock;
import org.confluence.mod.common.block.natural.*;
import org.confluence.mod.common.block.natural.herbs.*;
import org.confluence.mod.common.block.natural.sapling.*;
import org.confluence.mod.common.block.natural.spreadable.*;
import org.confluence.mod.common.init.ModFluids;
import org.confluence.mod.common.init.ModTreeGrower;
import org.confluence.mod.common.init.item.ModItems;

import java.util.function.Function;
import java.util.function.Supplier;

import static org.confluence.mod.common.block.natural.LogBlockSet.WoodSetType.*;

public final class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Confluence.MODID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Confluence.MODID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SignBlockEntity>> SIGN_BLOCK_ENTITY = BLOCK_ENTITIES.register("sign_block_entity", () -> BlockEntityType.Builder.of(SignBlockEntity::new, LogBlockSet.getSignBlocks()).build(null));

    // 环境辅助
    public static final DeferredBlock<Block> HARDENED_SAND_BLOCK = registerWithItem("hardened_sand_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> RED_HARDENED_SAND_BLOCK = registerWithItem("red_hardened_sand_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<Block> DIATOMACEOUS = registerWithItem("diatomaceous", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SAND)));

    public static final DeferredBlock<CoinPileBlock> COPPER_COIN_PILE = registerWithoutItem("copper_coin_pile", CoinPileBlock::new);
    public static final DeferredBlock<CoinPileBlock> SILVER_COIN_PILE = registerWithoutItem("silver_coin_pile", CoinPileBlock::new);
    public static final DeferredBlock<CoinPileBlock> GOLDEN_COIN_PILE = registerWithoutItem("golden_coin_pile", CoinPileBlock::new);
    public static final DeferredBlock<CoinPileBlock> PLATINUM_COIN_PILE = registerWithoutItem("platinum_coin_pile", CoinPileBlock::new);
    public static final DeferredBlock<SandLayerBlock> EBONY_SAND_LAYER_BLOCK = registerWithItem("ebony_sand_layer_block", SandLayerBlock::new);
    public static final DeferredBlock<SandLayerBlock> PEARL_SAND_LAYER_BLOCK = registerWithItem("pearl_sand_layer_block", SandLayerBlock::new);
    public static final DeferredBlock<SandLayerBlock> TR_CRIMSON_SAND_LAYER_BLOCK = registerWithItem("tr_crimson_sand_layer_block", SandLayerBlock::new);
    public static final DeferredBlock<SandLayerBlock> SAND_LAYER_BLOCK = registerWithItem("sand_layer_block", SandLayerBlock::new);
    public static final DeferredBlock<SandLayerBlock> RED_SAND_LAYER_BLOCK = registerWithItem("red_sand_layer_block", SandLayerBlock::new);

    // 腐化
    public static final LogBlockSet EBONY_LOG_BLOCKS = LogBlockSet.builder("ebony", true).createDefault(EBONY, true).build();
    public static final DeferredBlock<Block> EBONY_STONE = registerWithItem("ebony_stone", () -> new CustomModelSpreadingBlock(ISpreadable.Type.CORRUPT, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> EBONY_COBBLESTONE = registerWithItem("ebony_cobblestone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> EBONY_SANDSTONE = registerWithItem("ebony_sandstone", () -> new CustomModelSpreadingBlock(ISpreadable.Type.CORRUPT, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> EBONY_HARDENED_SAND_BLOCK = registerWithItem("ebony_hardened_sand_block", () -> new SpreadingBlock(ISpreadable.Type.CORRUPT, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> EBONY_SAND = registerWithItem("ebony_sand", () -> new SpreadingSandBlock(ISpreadable.Type.CORRUPT, 0x372B4B, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK)));
    public static final DeferredBlock<Block> CORRUPT_GRASS_BLOCK = registerWithItem("corrupt_grass_block", () -> new SpreadingGrassBlock(ISpreadable.Type.CORRUPT, BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK)));
    public static final DeferredBlock<Block> PURPLE_ICE = registerWithItem("purple_ice", () -> new IceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> PURPLE_PACKED_ICE = registerWithItem("purple_packed_ice", () -> new IceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> CORRUPT_GRASS = registerWithItem("corrupt_grass", () -> new BasePlantBlock(ModBlocks.CORRUPT_GRASS_BLOCK.get()));//腐化草
    public static final DeferredBlock<ThornBlock> CORRUPTION_THORN = registerWithItem("corruption_thorn", () -> new SpreadingThornBlock(2, CORRUPT_GRASS_BLOCK.get(), ISpreadable.Type.CORRUPT));
    public static final DeferredBlock<Block> EBONY_MUSHROOM = registerWithoutItem("ebony_mushroom", () -> new MushroomBlock(ModBlocks.CORRUPT_GRASS_BLOCK.get()));//魔菇

    // 神圣
    public static final LogBlockSet PEARL_LOG_BLOCKS = LogBlockSet.builder("pearl", true).createDefault(PEARL, true).build();
    public static final DeferredBlock<Block> PEARL_STONE = registerWithItem("pearl_stone", () -> new CustomModelSpreadingBlock(ISpreadable.Type.HALLOW, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> PEARL_COBBLESTONE = registerWithItem("pearl_cobblestone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> PEARL_HARDENED_SAND_BLOCK = registerWithItem("pearl_hardened_sand_block", () -> new SpreadingBlock(ISpreadable.Type.HALLOW, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> PEARL_SANDSTONE = registerWithItem("pearl_sandstone", () -> new CustomModelSpreadingBlock(ISpreadable.Type.HALLOW, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> PEARL_SAND = registerWithItem("pearl_sand", () -> new SpreadingSandBlock(ISpreadable.Type.HALLOW, 0xEDD5F6, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY)));
    public static final DeferredBlock<Block> HALLOW_GRASS_BLOCK = registerWithItem("hallow_grass_block", () -> new SpreadingGrassBlock(ISpreadable.Type.HALLOW, BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK)));
    public static final DeferredBlock<Block> RED_ICE = registerWithItem("red_ice", () -> new IceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> RED_PACKED_ICE = registerWithItem("red_packed_ice", () -> new IceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> LIFE_MUSHROOM = registerWithoutItem("life_mushroom", () -> new MushroomBlock(Blocks.GRASS_BLOCK));//生命蘑菇
    public static final DeferredBlock<Block> HALLOW_GRASS = registerWithItem("hallow_grass", () -> new BasePlantBlock(HALLOW_GRASS_BLOCK.get()));//神圣草

    // 猩红
    public static final LogBlockSet SHADOW_LOG_BLOCKS = LogBlockSet.builder("shadow", true).createDefault(SHADOW, true).build();
    public static final DeferredBlock<Block> TR_CRIMSON_STONE = registerWithItem("tr_crimson_stone", () -> new CustomModelSpreadingBlock(ISpreadable.Type.CRIMSON, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> TR_CRIMSON_COBBLESTONE = registerWithItem("tr_crimson_cobblestone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> TR_CRIMSON_HARDENED_SAND_BLOCK = registerWithItem("tr_crimson_hardened_sand_block", () -> new SpreadingBlock(ISpreadable.Type.CRIMSON, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> TR_CRIMSON_SANDSTONE = registerWithItem("tr_crimson_sandstone", () -> new CustomModelSpreadingBlock(ISpreadable.Type.CRIMSON, BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> TR_CRIMSON_SAND = registerWithItem("tr_crimson_sand", () -> new SpreadingSandBlock(ISpreadable.Type.CRIMSON, 0x5313E0, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED)));
    public static final DeferredBlock<Block> TR_CRIMSON_GRASS_BLOCK = registerWithItem("tr_crimson_grass_block", () -> new SpreadingGrassBlock(ISpreadable.Type.CRIMSON, BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK)));
    public static final DeferredBlock<Block> PINK_ICE = registerWithItem("pink_ice", () -> new IceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
    public static final DeferredBlock<Block> PINK_PACKED_ICE = registerWithItem("pink_packed_ice", () -> new IceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE)));
    public static final DeferredBlock<Block> TR_CRIMSON_GRASS = registerWithItem("tr_crimson_grass", () -> new BasePlantBlock(ModBlocks.TR_CRIMSON_GRASS_BLOCK.get()));//猩红草
    public static final DeferredBlock<ThornBlock> CRIMSON_THORN = registerWithItem("crimson_thorn", () -> new SpreadingThornBlock(2, TR_CRIMSON_GRASS_BLOCK.get(), ISpreadable.Type.CRIMSON));
    public static final DeferredBlock<Block> TR_CRIMSON_MUSHROOM = registerWithoutItem("tr_crimson_mushroom", () -> new MushroomBlock(ModBlocks.TR_CRIMSON_GRASS_BLOCK.get()));//毒蘑菇

    // 蘑菇地
    public static final DeferredBlock<MushroomGrassBlock> MUSHROOM_GRASS_BLOCK = registerWithItem("mushroom_grass_block", MushroomGrassBlock::new);
    // TODO: 发光蘑菇可以长在天花板上，可以长很长；天花板上的属于藤蔓，还没做
    public static final DeferredBlock<Block> GLOWING_MUSHROOM = registerWithoutItem("glowing_mushroom", () -> new MushroomBlock(ModBlocks.MUSHROOM_GRASS_BLOCK.get()));//发光蘑菇

    // 沙漠
    public static final LogBlockSet PALM_LOG_BLOCKS = LogBlockSet.builder("palm", true)
            .log(RotatedPillarBlock::new)
            .strippedLog(RotatedPillarBlock::new)
            .wood(RotatedPillarBlock::new)
            .strippedWood(RotatedPillarBlock::new)
            .leaves(PalmLeaves::new)
            .button(properties -> new ButtonBlock(PALM.SET, 30, properties))
            .fence(FenceBlock::new)
            .fenceGate(properties -> new FenceGateBlock(PALM.TYPE, properties))
            .pressurePlate(properties -> new PressurePlateBlock(PALM.SET, properties))
            .slab(SlabBlock::new)
            .stair(StairBlock::new)
            .sign(properties -> new LogBlockSet.ModStandingSignBlock(PALM.TYPE, properties), properties -> new LogBlockSet.ModWallSignBlock(PALM.TYPE, properties), SignItem::new)
            .trapdoor(properties -> new TrapDoorBlock(PALM.SET, properties))
            .door(properties -> new DoorBlock(PALM.SET, properties)).build();

    // 万圣节
    public static final LogBlockSet SPOOKY_LOG_BLOCKS = LogBlockSet.builder("spooky", true).createDefault(SPOOKY, false).build();

    // 灰烬
    public static final LogBlockSet ASH_LOG_BLOCKS = LogBlockSet.builder("ash", false).createDefault(ASH, true).build();
    public static final DeferredBlock<Block> ASH_BLOCK = registerWithItem("ash_block", AshBlock::new);
    public static final DeferredBlock<Block> ASH_GRASS_BLOCK = registerWithItem("ash_grass_block", AshGrassBlock::new);
    public static final DeferredBlock<Block> ASH_GRASS = registerWithItem("ash_grass", () -> new BasePlantBlock(ASH_GRASS_BLOCK.get()));

    // 丛林
    public static final DeferredBlock<ThornBlock> JUNGLE_THORN = registerWithItem("jungle_thorn", () -> new ThornBlock(3.4f, Blocks.MOSS_BLOCK));
    public static final DeferredBlock<ThornBlock> PLANTERA_THORN = registerWithItem("plantera_thorn", () -> new ThornBlock(20, null));
    public static final DeferredBlock<JungleSporeBlock> JUNGLE_SPORE = registerWithoutItem("jungle_spore", JungleSporeBlock::new);
    public static final DeferredBlock<Block> NATURES_GIFT = registerWithoutItem("natures_gift", NaturesGiftBlock::new);

    // 空岛
    public static final DeferredBlock<CloudBlock> CLOUD_BLOCK = registerWithItem("cloud_block", CloudBlock::new);
    public static final DeferredBlock<EvaporativeCloudBlock> EVAPORATIVE_CLOUD_BLOCK = registerWithItem("evaporative_cloud_block", () -> new EvaporativeCloudBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).sound(SoundType.SNOW).randomTicks()));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EvaporativeCloudBlock.EvaporativeCloudBlockEntity>> EVAPORATIVE_CLOUD_BLOCK_ENTITY = BLOCK_ENTITIES.register("evaporative_cloud_block", () -> BlockEntityType.Builder.of(EvaporativeCloudBlock.EvaporativeCloudBlockEntity::new, EVAPORATIVE_CLOUD_BLOCK.get()).build(DSL.remainderType()));
    public static final DeferredBlock<ParticleCloudBlock> RAIN_CLOUD_BLOCK = registerWithItem("rain_cloud_block", () -> new ParticleCloudBlock(ParticleTypes.FALLING_WATER));
    public static final DeferredBlock<ParticleCloudBlock> SNOW_CLOUD_BLOCK = registerWithItem("snow_cloud_block", () -> new ParticleCloudBlock(ParticleTypes.SNOWFLAKE));
    public static final DeferredBlock<Block> STELLAR_BLOSSOM = registerWithItem("stellar_blossom", () -> new StellarBlossomBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION).offsetType(BlockBehaviour.OffsetType.NONE)));
    public static final DeferredBlock<Block> CLOUDWEAVER = registerWithItem("cloudweaver", () -> new CloudWeaverBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION).offsetType(BlockBehaviour.OffsetType.NONE)));
    public static final DeferredBlock<Block> FLOATING_WHEAT = registerWithItem("floating_wheat", () -> new FloatingWheatBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).offsetType(BlockBehaviour.OffsetType.NONE)));

    // 易碎块 ModTags.Blocks.EASY_CRASH
    public static final DeferredBlock<ThinIceBlock> THIN_ICE_BLOCK = registerWithItem("thin_ice_block", ThinIceBlock::new);
    public static final DeferredBlock<SwordInStoneBlock> SWORD_IN_STONE = registerWithItem("sword_in_stone", SwordInStoneBlock::new);
    public static final DeferredBlock<CrackedBrickBlock> CRACKED_BLUE_BRICK = registerWithItem("cracked_blue_block", CrackedBrickBlock::new);
    public static final DeferredBlock<CrackedBrickBlock> CRACKED_GREEN_BRICK = registerWithItem("cracked_green_block", CrackedBrickBlock::new);
    public static final DeferredBlock<CrackedBrickBlock> CRACKED_PINK_BRICK = registerWithItem("cracked_pink_block", CrackedBrickBlock::new);
    public static final DeferredBlock<CrispyHoneyBlock> CRISPY_HONEY_BLOCK = registerWithItem("crispy_honey_block", CrispyHoneyBlock::new);

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

    // 树苗
    public static final DeferredBlock<Block> SHADOW_SAPLING = registerWithItem("shadow_sapling", () -> new BaseSaplingBlock(ModTreeGrower.SHADOW_GROWER, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING), ModBlocks.TR_CRIMSON_GRASS_BLOCK.get()));
    public static final DeferredBlock<Block> EBONY_SAPLING = registerWithItem("ebony_sapling", () -> new BaseSaplingBlock(ModTreeGrower.EBONY_GROWER, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING), ModBlocks.CORRUPT_GRASS_BLOCK.get()));
    public static final DeferredBlock<Block> PALM_SAPLING = registerWithItem("palm_sapling", () -> new PalmSaplingBlock(ModTreeGrower.PALM_GROWER, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> PEARL_SAPLING = registerWithItem("pearl_sapling", () -> new BaseSaplingBlock(ModTreeGrower.PEARL_GROWER, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING), ModBlocks.HALLOW_GRASS_BLOCK.get()));
    public static final DeferredBlock<Block> RUBY_SAPLING = registerWithItem("ruby_sapling", () -> new StoneSaplingBlock(ModTreeGrower.RUBY_GROWER, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> AMBER_SAPLING = registerWithItem("amber_sapling", () -> new StoneSaplingBlock(ModTreeGrower.AMBER_GROWER, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> TOPAZ_SAPLING = registerWithItem("topaz_sapling", () -> new StoneSaplingBlock(ModTreeGrower.TOPAZ_GROWER, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> EMERALD_SAPLING = registerWithItem("emerald_sapling", () -> new StoneSaplingBlock(ModTreeGrower.EMERALD_GROWER, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> DIAMOND_SAPLING = registerWithItem("diamond_sapling", () -> new StoneSaplingBlock(ModTreeGrower.DIAMOND_GROWER, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> SAPPHIRE_SAPLING = registerWithItem("sapphire_sapling", () -> new StoneSaplingBlock(ModTreeGrower.SAPPHIRE_GROWER, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> TR_AMETHYST_SAPLING = registerWithItem("tr_amethyst_sapling", () -> new StoneSaplingBlock(ModTreeGrower.TR_AMETHYST_GROWER, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> ASH_SAPLING = registerWithItem("ash_sapling", () -> new AshSaplingBlock(ModTreeGrower.ASH_GROWER, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> LIVING_SAPLING = registerWithItem("living_sapling", () -> new LivingSaplingBlock(ModTreeGrower.LIVING_GROWER, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    // 锁链
    public static final DeferredBlock<ChainBlock> RUBY_CHAIN = registerWithItem("ruby_chain", () -> new ChainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHAIN).mapColor(MapColor.COLOR_RED)));
    public static final DeferredBlock<ChainBlock> AMBER_CHAIN = registerWithItem("amber_chain", () -> new ChainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHAIN).mapColor(MapColor.COLOR_ORANGE)));
    public static final DeferredBlock<ChainBlock> TOPAZ_CHAIN = registerWithItem("topaz_chain", () -> new ChainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHAIN).mapColor(MapColor.COLOR_YELLOW)));
    public static final DeferredBlock<ChainBlock> EMERALD_CHAIN = registerWithItem("emerald_chain", () -> new ChainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHAIN).mapColor(MapColor.EMERALD)));
    public static final DeferredBlock<ChainBlock> SAPPHIRE_CHAIN = registerWithItem("sapphire_chain", () -> new ChainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHAIN).mapColor(MapColor.COLOR_BLUE)));
    public static final DeferredBlock<ChainBlock> DIAMOND_CHAIN = registerWithItem("diamond_chain", () -> new ChainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHAIN).mapColor(MapColor.DIAMOND)));
    public static final DeferredBlock<ChainBlock> AMETHYST_CHAIN = registerWithItem("amethyst_chain", () -> new ChainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHAIN).mapColor(MapColor.COLOR_PURPLE)));
    public static final DeferredBlock<ChainBlock> SILK_CHAIN = registerWithItem("silk_chain", () -> new ChainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHAIN).mapColor(MapColor.TERRACOTTA_WHITE)));
    public static final DeferredBlock<ChainBlock> BONE_CHAIN = registerWithItem("bone_chain", () -> new ChainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHAIN).mapColor(MapColor.TERRACOTTA_WHITE)));

    // 流体
    public static final DeferredBlock<LiquidBlock> HONEY = registerWithoutItem("honey", () -> new LiquidBlock(ModFluids.HONEY.fluid().get(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).mapColor(MapColor.COLOR_YELLOW)));
    public static final DeferredBlock<Block> THIN_HONEY_BLOCK = registerWithItem("thin_honey_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.HONEY_BLOCK)));
    public static final DeferredBlock<Block> LOOSE_HONEY_BLOCK = registerWithItem("loose_honey_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.HONEY_BLOCK)));
    public static final DeferredBlock<LiquidBlock> SHIMMER = registerWithoutItem("shimmer", () -> new LiquidBlock(ModFluids.SHIMMER.fluid().get(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).mapColor(MapColor.COLOR_PINK).lightLevel(blockState -> 10)));
    public static final DeferredBlock<Block> AETHERIUM_BLOCK = registerWithItem("aetherium_block", () -> new Block(BlockBehaviour.Properties.of()));
    public static final DeferredBlock<Block> DARK_AETHERIUM_BLOCK = registerWithItem("dark_aetherium_block", () -> new Block(BlockBehaviour.Properties.of()));

    public static <B extends Block> DeferredBlock<B> registerWithItem(String id, Supplier<B> block) {
        return registerWithItem(id, block, new Item.Properties());
    }

    public static <B extends Block> DeferredBlock<B> registerWithItem(String id, Supplier<B> block, Function<Supplier<B>, Supplier<BlockItem>> item) {
        DeferredBlock<B> object = BLOCKS.register(id, block);
        ModItems.ITEMS.register(id, item.apply(object));
        return object;
    }

    public static <B extends Block> DeferredBlock<B> registerWithItem(String id, Supplier<B> block, Item.Properties properties) {
        DeferredBlock<B> object = BLOCKS.register(id, block);
        ModItems.ITEMS.register(id, () -> new BlockItem(object.get(), properties));
        return object;
    }

    public static <B extends Block> DeferredBlock<B> registerWithoutItem(String id, Supplier<B> block) {
        return BLOCKS.register(id, block);
    }

    public static float getObsidianBasedExplosionResistance(float delta) {
        return Blocks.OBSIDIAN.getExplosionResistance() + delta;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        BLOCK_ENTITIES.register(eventBus);
        OreBlocks.BLOCKS.register(eventBus);
        DecorativeBlocks.BLOCKS.register(eventBus);
        BoxBlocks.BLOCKS.register(eventBus);
    }
}
