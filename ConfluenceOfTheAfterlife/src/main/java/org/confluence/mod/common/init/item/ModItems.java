package org.confluence.mod.common.init.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.confluence.mod.Confluence;
import org.confluence.mod.common.entity.projectile.bombs.*;
import org.confluence.mod.common.init.armor.ArmorMaterials;
import org.confluence.mod.common.init.armor.ModArmors;
import org.confluence.mod.common.init.block.ModBlocks;
import org.confluence.mod.common.item.common.BombItem;
import org.confluence.mod.common.item.common.LifeCrystal;
import org.confluence.mod.common.item.common.LifeFruit;
import org.confluence.mod.common.item.mana.ManaStar;

public final class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Confluence.MODID);
    public static final DeferredRegister.Items BLOCK_ITEMS = DeferredRegister.createItems(Confluence.MODID);

    public static final DeferredItem<ManaStar> MANA_STAR = ITEMS.register("mana_star", ManaStar::new);
    public static final DeferredItem<LifeCrystal> LIFE_CRYSTAL = ITEMS.register("life_crystal", LifeCrystal::new);
    public static final DeferredItem<LifeFruit> LIFE_FRUIT = ITEMS.register("life_fruit", LifeFruit::new);

    public static final DeferredItem<BombItem> BOMB = ITEMS.register("bomb", () -> new BombItem(BaseBombEntity::new));
    public static final DeferredItem<BombItem> BOUNCY_BOMB = ITEMS.register("bouncy_bomb", () -> new BombItem(BouncyBombEntity::new));
    public static final DeferredItem<BombItem> STICKY_BOMB = ITEMS.register("sticky_bomb", () -> new BombItem(StickyBombEntity::new));
    public static final DeferredItem<BombItem> BOMB_FISH = ITEMS.register("bomb_fish", () -> new BombItem(BombFishEntity::new)); // todo 炸弹鱼
    public static final DeferredItem<BombItem> SCARAB_BOMB = ITEMS.register("scarab_bomb", () -> new BombItem(ScarabBombEntity::new));

    public static final DeferredItem<Item> COPPER_COIN = ITEMS.register("copper_coin", () -> new BlockItem(ModBlocks.COPPER_COIN_PILE.get(), new Item.Properties().rarity(Rarity.UNCOMMON).fireResistant()));
    public static final DeferredItem<Item> SILVER_COIN = ITEMS.register("silver_coin", () -> new BlockItem(ModBlocks.SILVER_COIN_PILE.get(), new Item.Properties().rarity(Rarity.UNCOMMON).fireResistant()));
    public static final DeferredItem<Item> GOLDEN_COIN = ITEMS.register("golden_coin", () -> new BlockItem(ModBlocks.GOLDEN_COIN_PILE.get(), new Item.Properties().rarity(Rarity.RARE).fireResistant()));
    public static final DeferredItem<Item> PLATINUM_COIN = ITEMS.register("platinum_coin", () -> new BlockItem(ModBlocks.PLATINUM_COIN_PILE.get(), new Item.Properties().rarity(Rarity.EPIC).fireResistant()));

    public static final DeferredItem<Item> STELLAR_BLOSSOM_SEED = ITEMS.register("stellar_blossom_seed", () -> new ItemNameBlockItem(ModBlocks.STELLAR_BLOSSOM.get(), new Item.Properties()));
    public static final DeferredItem<Item> CLOUDWEAVER_SEED = ITEMS.register("cloudweaver_seed", () -> new ItemNameBlockItem(ModBlocks.CLOUDWEAVER.get(), new Item.Properties()));
    public static final DeferredItem<Item> FLOATING_WHEAT_SEED = ITEMS.register("floating_wheat_seed", () -> new ItemNameBlockItem(ModBlocks.FLOATING_WHEAT.get(), new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        BLOCK_ITEMS.register(eventBus);
        ArrowItems.ARROWS.register(eventBus);
        BaitItems.BAITS.register(eventBus);
        BowItems.BOWS.register(eventBus);
        FishingPoleItems.POLES.register(eventBus);
        IconItems.ICONS.register(eventBus);
        MaterialItems.MATERIALS.register(eventBus);
        SwordItems.SWORDS.register(eventBus);
        TerraPotions.POTIONS.register(eventBus);
        QuestedFishes.FISHES.register(eventBus);
        FoodItems.FOODS.register(eventBus);
        AxeItems.AXE.register(eventBus);
        ArmorMaterials.ARMOR_MATERIALS.register(eventBus);
        ModArmors.ARMOR.register(eventBus);
        AccessoryItems.ACCESSORIES.register(eventBus);
    }
}
