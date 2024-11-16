package org.confluence.mod.common.init.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.confluence.mod.Confluence;
import org.confluence.mod.common.block.common.BaseChestBlock;
import org.confluence.mod.common.block.functional.*;
import org.confluence.mod.common.init.item.ModItems;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class FunctionalBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Confluence.MODID);
    private static final DeferredRegister.Blocks HIDDEN = DeferredRegister.createBlocks(Confluence.MODID);
    public static List<Supplier<? extends AbstractMechanicalBlock>> MECHANICAL_BLOCKS = new ArrayList<>();

    public static final Supplier<EchoBlock> ECHO_BLOCK = registerWithItem("echo_block", EchoBlock::new);
    public static final Supplier<BaseChestBlock> BASE_CHEST_BLOCK = registerWithItemButHidden("base_chest_block", BaseChestBlock::new);
    public static final Supplier<BlockEntityType<BaseChestBlock.Entity>> BASE_CHEST_BLOCK_ENTITY = ModBlocks.BLOCK_ENTITIES.register("base_chest_block_entity", () -> BlockEntityType.Builder.of(BaseChestBlock.Entity::new, BASE_CHEST_BLOCK.get()).build(null));
    public static final Supplier<DeathChestBlock> DEATH_CHEST_BLOCK = registerWithItemButHidden("death_chest_block", DeathChestBlock::new);
    public static final Supplier<BlockEntityType<DeathChestBlock.Entity>> DEATH_CHEST_BLOCK_ENTITY = ModBlocks.BLOCK_ENTITIES.register("death_chest_block_entity", () -> BlockEntityType.Builder.of(DeathChestBlock.Entity::new, DEATH_CHEST_BLOCK.get()).build(null));
    public static final Supplier<BehaviourPressurePlateBlock> PLAYER_PRESSURE_PLATE = registerWithItem("player_pressure_plate", () -> new BehaviourPressurePlateBlock(BehaviourPressurePlateBlock.PLAYER, BlockBehaviour.Properties.ofFullCopy(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE), BlockSetType.IRON));
    public static final Supplier<SignalPressurePlateBlock> STONE_PRESSURE_PLATE = registerWithItem("stone_pressure_plate", () -> new SignalPressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE)));
    public static final Supplier<SignalPressurePlateBlock> DEEPSLATE_PRESSURE_PLATE = registerWithItem("deepslate_pressure_plate", () -> new SignalPressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).mapColor(MapColor.DEEPSLATE).strength(0.1F)));
    public static final Supplier<EverPoweredRailBlock> EVER_POWERED_RAIL = registerWithItem("ever_powered_rail", () -> new EverPoweredRailBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACTIVATOR_RAIL)));

    public static final Supplier<InstantExplosionBlock> INSTANTANEOUS_EXPLOSION_TNT = registerWithEntity("instantaneous_explosion_tnt", InstantExplosionBlock::new);
    public static final Supplier<SwitchBlock> SWITCH = registerWithEntity("switch", SwitchBlock::new);
    public static final Supplier<SignalAdapterBlock> SIGNAL_ADAPTER = registerWithEntity("signal_adapter", SignalAdapterBlock::new);
    public static final Supplier<DartTrapBlock> DART_TRAP = registerWithEntity("dart_trap", DartTrapBlock::new);
    public static final Supplier<TimersBlock> TIMERS_BLOCK_1_1 = registerWithEntity("timers_1_1", () -> new TimersBlock(20)); // 1s
    public static final Supplier<TimersBlock> TIMERS_BLOCK_3_1 = registerWithEntity("timers_3_1", () -> new TimersBlock(60)); // 3s
    public static final Supplier<TimersBlock> TIMERS_BLOCK_5_1 = registerWithEntity("timers_5_1", () -> new TimersBlock(100)); // 5s
    public static final Supplier<TimersBlock> TIMERS_BLOCK_1_2 = registerWithEntity("timers_1_2", () -> new TimersBlock(10)); // 1/2s
    public static final Supplier<TimersBlock> TIMERS_BLOCK_1_4 = registerWithEntity("timers_1_4", () -> new TimersBlock(5)); // 1/4s
    public static final Supplier<GeyserBlock> GEYSER_BLOCK = registerWithEntity("geyser_block", GeyserBlock::new);
    public static final Supplier<BoulderBlock> NORMAL_BOULDER = registerWithEntity("normal_boulder", BoulderBlock::new);

    public static final Supplier<BlockEntityType<AbstractMechanicalBlock.Entity>> MECHANICAL_BLOCK_ENTITY = ModBlocks.BLOCK_ENTITIES.register("mechanical_block_entity", () -> BlockEntityType.Builder.of(AbstractMechanicalBlock.Entity::new, MECHANICAL_BLOCKS.stream().map(Supplier::get).toArray(Block[]::new)).build(null));

    private static <B extends Block> DeferredBlock<B> registerWithItem(String id, Supplier<B> block) {
        DeferredBlock<B> object = BLOCKS.register(id, block);
        ModItems.BLOCK_ITEMS.registerSimpleBlockItem(object);
        return object;
    }

    private static <B extends AbstractMechanicalBlock> Supplier<B> registerWithEntity(String id, Supplier<B> supplier) {
        DeferredBlock<B> holder = registerWithItem(id, supplier);
        MECHANICAL_BLOCKS.add(holder);
        return holder;
    }

    private static <B extends Block> DeferredBlock<B> registerWithItemButHidden(String id, Supplier<B> block) {
        DeferredBlock<B> object = HIDDEN.register(id, block);
        ModItems.BLOCK_ITEMS.registerSimpleBlockItem(object);
        return object;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        HIDDEN.register(eventBus);
    }
}
