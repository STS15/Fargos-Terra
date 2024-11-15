package org.confluence.mod.common.data.gen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.data.LanguageProvider;
import org.confluence.mod.Confluence;
import org.confluence.mod.common.init.block.BoxBlocks;
import org.confluence.mod.common.init.block.DecorativeBlocks;
import org.confluence.mod.common.init.block.OreBlocks;
import org.confluence.mod.common.init.item.*;
import org.confluence.mod.mixin.accessor.LanguageProviderAccessor;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class ModEnglishProvider extends LanguageProvider {
    public ModEnglishProvider(PackOutput output) {
        super(output, Confluence.MODID, "en_us");
    }

    private static String toTitleCase(String raw) {
        return Arrays.stream(raw.split("_"))
                .map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
    }

    @Override
    protected void addTranslations() {

        add("config.jade.plugin_confluence.jade_mechanical_component", "Mechanical Info");

        add("creativetab.confluence.building_blocks", "Confluence | Buildings");
        add("creativetab.confluence.natural_blocks", "Confluence | Naturals");
        add("creativetab.confluence.materials", "Confluence | Materials");
        add("creativetab.confluence.tools", "Confluence | Tools");
        add("creativetab.confluence.warriors", "Confluence | Warriors");
        add("creativetab.confluence.rangers", "Confluence | Rangers");
        add("creativetab.confluence.mages", "Confluence | Mages");
        add("creativetab.confluence.summoners", "Confluence | Summoners");
        add("creativetab.confluence.misc", "Confluence | Miscellaneous");
        add("creativetab.confluence.food_and_potions", "Confluence | Food & Potions");
        add("creativetab.confluence.armors", "Confluence | Armors");
        add("creativetab.terra_curio", "Confluence | Accessories");
        add("creativetab.confluence.mechanical", "Confluence | Mechanical");
        add("creativetab.confluence.developer", "Confluence | Developer");

        add("item.confluence.meteorite_ingot.tooltip", "Warm to the touch");
        add("item.confluence.alpha.desc", "C418 - alpha");

        add("bossevent.confluence.boss_generate", "The %s has awakened!");
        add("bossevent.confluence.boss_death", "The %s been defeated!");
        add("bossevent.confluence.cthulhu_eye.leave", "The CthulhuEye leaved!");

        add("info.confluence.weather_radio.clear", "Weather: Clear, Wind Speed: %s");
        add("info.confluence.weather_radio.cloudy", "Weather: Cloudy, Wind Speed: %s");
        add("info.confluence.weather_radio.rain", "Weather: Rain, Wind Speed: %s");
        add("info.confluence.weather_radio.snow", "Weather: Snow, Wind Speed: %s");
        add("info.confluence.weather_radio.thunder", "Weather: Thunder, Wind Speed: %s");
        add("info.confluence.bait", "Bait Power: %s%%");
        add("info.confluence.network", "#%s Signal: %s");
        add("info.confluence.respawn_time", "Respawn Time: ");
        add("info.confluence.second", "s");

        add("key.confluence.hook", "Throwing Hook");

        add("curios.identifier.hook", "Hook");

        add("item.confluence.vanilla_potion", "Potion");
        add("item.confluence.magic_conch.pos", "Pos: [%s, %s, %s]");

        add("death.attack.falling_star", "%1$s got a response from a meteor");
        add("death.attack.boulder", "%1$s  is crushed by boulder");

        add("painting.confluence.magic_harp.title", "MAGIC_HARP");
        add("painting.confluence.magic_harp.author", "BiliBili_魔法竖琴waaa，看上去傻傻的...");
        add("painting.confluence.westernat.title", "WESTERNAT");
        add("painting.confluence.westernat.author", "BiliBili_Westernat233，MC21世纪以来，最具有印象派主义的白桦树绘画!");
        add("painting.confluence.cooobrid.title", "COOOBRID");
        add("painting.confluence.cooobrid.author", "BiliBili_事一只一只一只鸽子，事一只只会咕咕咕的鸽子");
        add("painting.confluence.nakinosi.title", "NAKINOSI");
        add("painting.confluence.nakinosi.author", "BiliBili_咕咕咕的屑枕头，世界上最好看的渐变头发！");
        add("painting.confluence.maker.title", "MAKER");
        add("painting.confluence.maker.author", "BiliBili_Maker-2333，是Maker不是Marker！");
        add("painting.confluence.mustard_oasis.title", "MUSTARD_OASIS");
        add("painting.confluence.mustard_oasis.author", "BiliBili_芥末Oasis，芥末配fish，豪赤😋");
        add("painting.confluence.a_pigeon_delight.title", "A_PIGEON_DELIGHT");
        add("painting.confluence.a_pigeon_delight.author", "BiliBili_一只鸽子悦");
        add("painting.confluence.sheep_mink.title", "SHEEP_MINK");
        add("painting.confluence.sheep_mink.author", "BiliBili_眠羊敏克，“啊？我打json？”");
        add("painting.confluence.voila.title", "VOILA");
        add("painting.confluence.voila.author", "BiliBili_风起下片灬");
        add("painting.confluence.xuanyu_1725.title", "XUANYU");
        add("painting.confluence.xuanyu_1725.author", "BiliBili_轩宇1725");
        add("painting.confluence.shadow_end.title", "SHADOW_END");
        add("painting.confluence.shadow_end.author", "BiliBili_影末子");
        add("painting.confluence.kl_jiana.title", "KL_JIANA");
        add("painting.confluence.kl_jiana.author", "BiliBili_KL_JIANA");
        add("painting.confluence.hunao.title", "HUNAO");
        add("painting.confluence.hunao.author", "BiliBili_小胡闹鸭");
        add("painting.confluence.sihuai_2412.title", "SIHUAI_2412");
        add("painting.confluence.sihuai_2412.author", "BiliBili_思怀_2412");
        add("painting.confluence.old_sheep.title", "OLD_SHEEP");
        add("painting.confluence.old_sheep.author", "BiliBili_我叫老绵羊");
        add("painting.confluence.slime_dragon.title", "SLIME_DRAGON");
        add("painting.confluence.slime_dragon.author", "BiliBili_小史龙吖Slime_Dragon");
        add("painting.confluence.khaki_coffee_beans.title", "KHAKI_COFFEE_BEANS");
        add("painting.confluence.khaki_coffee_beans.author", "BiliBili_卡其色咖啡豆");
        add("painting.confluence.uqtqu_day.title", "UQTQU_DAY");
        add("painting.confluence.uqtqu_day.author", "BiliBili__昼泽_");
        add("painting.confluence.emerald_shenyi.title", "EMERALD_SHENYI");
        add("painting.confluence.emerald_shenyi.author", "BiliBili_Emerald_审翼");
        add("painting.confluence.chromatic.title", "CHROMATIC");
        add("painting.confluence.chromatic.author", "BiliBili_陌林_Chromatic");

        // new
        add("achievements.toast.complete", "Achievement achieved!");
        add("achievements.confluence.new_world.title", "Old World, New Journey!");
        add("achievements.confluence.new_world.description", "The afterlife of convergence and exchange");
        add("achievements.confluence.timber.title", "Timber!! ");
        add("achievements.confluence.timber.description", "Chop down your first tree.");
        add("achievements.confluence.benched.title", "Benched");
        add("achievements.confluence.benched.description", "Craft your first Crafting Table.");
        add("achievements.confluence.star_power.title", "Star Power");
        add("achievements.confluence.star_power.description", "Craft a mana crystal multiOut of fallen stars, and consume it.");
        add("achievements.confluence.ooo_shinny.title", "Ooo! Shiny!");
        add("achievements.confluence.ooo_shinny.description", "Mine your first nugget of ore with a pickaxe.");
        add("achievements.confluence.i_am_loot.title", "I Am Loot!");
        add("achievements.confluence.i_am_loot.description", "Discover a golden chest underground and take a peek at its contents.");
        add("achievements.confluence.hold_on_tight.title", "Hold on Tight!");
        add("achievements.confluence.hold_on_tight.description", "Equip your first grappling hook.");
        add("achievements.confluence.heavy_metal.title", "Heavy Metal");
        add("achievements.confluence.heavy_metal.description", "Obtain an anvil made from iron or lead.");
        add("achievements.confluence.heart_breaker.title", "Heart Breaker");
        add("achievements.confluence.heart_breaker.description", "Discover and smash your first heart crystal underground.");
        add("achievements.confluence.hammer_time.title", "Stop! Hammer Time! ");
        add("achievements.confluence.hammer_time.description", "Obtain your first hammer via crafting or otherwise.");
        add("achievements.confluence.boots_of_the_hero.title", "Boots of the Hero");
        add("achievements.confluence.boots_of_the_hero.description", "Forged from the finest boots of fire and ice.");
        add("achievements.confluence.black_mirror.title", "Black Mirror");
        add("achievements.confluence.black_mirror.description", "You'll never leave home without it again.");
        add("achievements.confluence.ankhumulation_complete.title", "Ankhumulation Complete");
        add("achievements.confluence.ankhumulation_complete.description", "The finest protection from unpleasant maladies and ailments.");
        add("achievements.confluence.a_shimmer_in_the_dark.title", "A Shimmer In The Dark");
        add("achievements.confluence.a_shimmer_in_the_dark.description", "Shimmer an item into another item. What other transmutations can you find?");

        add("achievements.confluence.pretty_in_pink.title", "Pretty in Pink");
        add("achievements.confluence.pretty_in_pink.description", "Kill pinky.");
        add("achievements.confluence.slippery_shinobi.title", "Slippery Shinobi ");
        add("achievements.confluence.slippery_shinobi.description", "Defeat King Slime, the lord of all things slimy.");
        add("achievements.confluence.eye_on_you.title", "Eye on You");
        add("achievements.confluence.eye_on_you.description", "“Defeat the Eye of Cthulhu, an ocular menace who only appears at night.");

        add("fluid_type.confluence.shimmer", "Shimmer");
        add("fluid_type.confluence.honey", "Honey");

        add("title.confluence.shimmer_transmutation", "Shimmer Transmutation");
        add("condition.confluence.shimmer_transmutation", "Required game phase: %s");

        add("block.confluence.timers_block_1_1", "1 Second Timer");
        add("block.confluence.timers_block_3_1", "3 Second Timer");
        add("block.confluence.timers_block_5_1", "5 Second TImer");
        add("block.confluence.timers_block_1_2", "1/2 Second Timer");
        add("block.confluence.timers_block_1_4", "1/4 Second TImer");
        add("block.confluence.base_chest_block.locked_golden", "§rLocked Golden Chest");
        add("block.confluence.base_chest_block.unlocked_golden", "§rGolden Chest");
        add("block.confluence.base_chest_block.death_golden", "§rDeath Golden Chest");
        add("block.confluence.base_chest_block.locked_shadow", "§rLocked Shadow Chest");
        add("block.confluence.base_chest_block.unlocked_shadow", "§rShadow Chest");
        add("block.confluence.base_chest_block.death_shadow", "§rDeath Shadow Chest");
        add("block.confluence.base_chest_block.unlocked_lvy", "§rLvy Chest");
        add("block.confluence.base_chest_block.death_lvy", "§rDeath Lvy Chest");
        add("block.confluence.base_chest_block.unlocked_frozen", "§rFrozen Chest");
        add("block.confluence.base_chest_block.death_frozen", "§rDeath Frozen Chest");
        add("block.confluence.base_chest_block.unlocked_water", "§rWater Chest");
        add("block.confluence.base_chest_block.death_water", "§rDeath Water Chest");
        add("block.confluence.base_chest_block.unlocked_skyware", "§rSkyware Chest");
        add("block.confluence.base_chest_block.death_skyware", "§rDeath Skyware Chest");

        add("resourcepack.terraria_art", "Terraria Art");
        add("resourcepack.mainstream_connected_ores", "Mainstream Connected Ores");
        add("resourcepack.ter_armor", "Mainstream Terraria Armor Textures");

        add("event.confluence.blood_moon", "The Blood Moon is rising...");

        add("attribute.name.player.minion_capacity", "Minion Capacity");
        add("attribute.name.player.sentry_capacity", "Sentry Capacity");
        add("attribute.name.player.summon_damage", "Summon Damage");
        add("attribute.name.player.summon_knockback", "Summon Knockback");
        add("attribute.name.player.whip_range", "Whip Range");

        add("entity.minecraft.villager.confluence.sky_miller", "Sky Miller");

        add("container.confluence.workshop", "Workshop");
        add("title.confluence.workshop", "Workshop");

        add("generator.confluence.corruption", "The Corruption");
        add("generator.confluence.tr_crimson", "The Crimson");

        add("title.confluence.wiki", "Confluence Wiki");
        add("wiki.confluence.back", "Return");
        add("title.confluence.group", "Group Wiki");
        add("wiki.confluence.item", "Items");
        add("wiki.confluence.type_accessories", "Accessories");
        add("wiki.confluence.type_arrow", "Arrows");
        add("wiki.confluence.type_axe", "Axes");
        add("wiki.confluence.type_bait", "Baits");
        add("wiki.confluence.type_bow", "Bows");
        add("wiki.confluence.type_fishing_pole", "Fishing Poles");
        add("wiki.confluence.type_food", "Foods");
        add("wiki.confluence.type_material", "Materials");
        add("wiki.confluence.type_misc", "Misc");
        add("wiki.confluence.type_quested_fish", "Quested Fish");
        add("wiki.confluence.type_sword", "Swords");
        add("wiki.confluence.type_terra_potion", "Terra Potions");
        add("wiki.confluence.setDamage", "Attack Damage: ");
        add("wiki.confluence.use", "Durability: ");
        add("wiki.confluence.speed", "Use Speed: ");
        add("wiki.confluence.enchantment", "Enchantment Level: ");
        add("wiki.confluence.ingredient", "Repair Ingredient: ");
        add("wiki.confluence.power", "Pickaxe Power: ");
        add("wiki.confluence.nutrition", "Nutrition: ");
        add("wiki.confluence.saturation", "Saturation: ");

        add("wiki.confluence.copper_short_sword", """
                The Copper Shortsword is an early-game metal shortsword.
                Its alternate ore counterpart is the Tin Shortsword.
                
                Like all shortswords, the Copper Shortsword has a very limited range
                and attacks with a stabbing motion at any direction / horizontally
                in front of the player, instead of an arc.
                
                This makes it almost useless against flying or jumping enemies,
                although its high attack rate makes it
                somewhat effective against weaker fighter type enemies.
                
                Its best boomerangModifier is Legendary.""");

        //ModBlocks.BLOCKS.getEntries().forEach(block -> add(block.get(), toTitleCase(block.getId().getPath())));
        BoxBlocks.BLOCKS.getEntries().forEach(block -> add(block.get(), toTitleCase(block.getId().getPath())));
        DecorativeBlocks.BLOCKS.getEntries().forEach(block -> add(block.get(), toTitleCase(block.getId().getPath())));
        OreBlocks.BLOCKS.getEntries().forEach(block -> add(block.get(), toTitleCase(block.getId().getPath())));

        ModItems.ITEMS.getEntries().forEach(item -> {
            Item item1 = item.get();
            if (item1 instanceof BlockItem) return;
            add(item1, toTitleCase(item.getId().getPath()));
        });
        Map<String, String> data = ((LanguageProviderAccessor) this).getData();
        add(AccessoryItems.PHILOSOPHERS_STONE.get(), "Philosopher's Stone");
        AccessoryItems.ACCESSORIES.getEntries().forEach(accessory -> {
            Item item = accessory.get();
            String descriptionId = item.getDescriptionId();
            if (data.containsKey(descriptionId)) return;
            add(descriptionId, toTitleCase(accessory.getId().getPath()));
        });
        SwordItems.SWORDS.getEntries().forEach(sword -> add(sword.get(), toTitleCase(sword.getId().getPath())));
        ArrowItems.ARROWS.getEntries().forEach(arrow -> add(arrow.get(), toTitleCase(arrow.getId().getPath())));
        BowItems.BOWS.getEntries().forEach(bow -> add(bow.get(), toTitleCase(bow.getId().getPath())));
        PotionItems.POTIONS.getEntries().forEach(potion -> add(potion.get(), toTitleCase(potion.getId().getPath())));
    }
}
