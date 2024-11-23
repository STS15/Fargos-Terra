package org.confluence.mod.common.init.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.confluence.mod.Confluence;
import org.confluence.mod.common.init.ModJukeboxSongs;
import org.confluence.mod.common.init.block.ModBlocks;
import org.confluence.mod.common.item.CustomRarityItem;
import org.confluence.terra_curio.common.component.ModRarity;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public final class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Confluence.MODID);
    public static final DeferredRegister.Items BLOCK_ITEMS = DeferredRegister.createItems(Confluence.MODID);

    public static final Supplier<Item> ALPHA = ITEMS.register("alpha", () -> new CustomRarityItem(new Item.Properties().stacksTo(1).fireResistant().jukeboxPlayable(ModJukeboxSongs.ALPHA), ModRarity.EXPERT));

    public static final Supplier<Item> STAR = ITEMS.register("star", () -> new CustomRarityItem(ModRarity.MASTER));
    public static final Supplier<Item> SOUL_CAKE = ITEMS.register("soul_cake", () -> new CustomRarityItem(ModRarity.MASTER));
    public static final Supplier<Item> SUGAR_PLUM = ITEMS.register("sugar_plum", () -> new CustomRarityItem(ModRarity.MASTER));
    public static final Supplier<Item> HEART = ITEMS.register("heart", () -> new CustomRarityItem(ModRarity.MASTER));
    public static final Supplier<Item> CANDY_APPLE = ITEMS.register("candy_apple", () -> new CustomRarityItem(ModRarity.MASTER));
    public static final Supplier<Item> CANDY_CANE = ITEMS.register("candy_cane", () -> new CustomRarityItem(ModRarity.MASTER));

    public static final Supplier<Item> COPPER_COIN = ITEMS.register("copper_coin", () -> new BlockItem(ModBlocks.COPPER_COIN_PILE.get(), new Item.Properties().rarity(Rarity.COMMON).fireResistant()));
    public static final Supplier<Item> SILVER_COIN = ITEMS.register("silver_coin", () -> new BlockItem(ModBlocks.SILVER_COIN_PILE.get(), new Item.Properties().rarity(Rarity.UNCOMMON).fireResistant()));
    public static final Supplier<Item> GOLDEN_COIN = ITEMS.register("golden_coin", () -> new BlockItem(ModBlocks.GOLDEN_COIN_PILE.get(), new Item.Properties().rarity(Rarity.UNCOMMON).fireResistant()));
    public static final Supplier<Item> PLATINUM_COIN = ITEMS.register("platinum_coin", () -> new BlockItem(ModBlocks.PLATINUM_COIN_PILE.get(), new Item.Properties().rarity(Rarity.RARE).fireResistant()));
    public static final Supplier<Item> EMERALD_COIN = ITEMS.register("emerald_coin", () -> new BlockItem(ModBlocks.EMERALD_COIN_PILE.get(), new Item.Properties().rarity(Rarity.EPIC).fireResistant()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        BLOCK_ITEMS.register(eventBus);
        AccessoryItems.ITEMS.register(eventBus);
        ArmorItems.register(eventBus);
        ArrowItems.ITEMS.register(eventBus);
        AxeItems.ITEMS.register(eventBus);
        BaitItems.ITEMS.register(eventBus);
        BoomerangItems.ITEMS.register(eventBus);
        BowItems.ITEMS.register(eventBus);
        ConsumableItems.ITEMS.register(eventBus);
        FishingPoleItems.ITEMS.register(eventBus);
        FoodItems.ITEMS.register(eventBus);
        HammerItems.ITEMS.register(eventBus);
        HookItems.ITEMS.register(eventBus);
        IconItems.ITEMS.register(eventBus);
        MaterialItems.ITEMS.register(eventBus);
        MinecartItems.ITEMS.register(eventBus);
        PickaxeItems.ITEMS.register(eventBus);
        PotionItems.ITEMS.register(eventBus);
        QuestedFishes.ITEMS.register(eventBus);
        SwordItems.ITEMS.register(eventBus);
        ToolItems.ITEMS.register(eventBus);
    }
}
