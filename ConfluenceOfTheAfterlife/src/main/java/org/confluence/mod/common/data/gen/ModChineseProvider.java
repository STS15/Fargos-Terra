package org.confluence.mod.common.data.gen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import org.confluence.mod.Confluence;
import org.confluence.mod.common.init.ModEffects;
import org.confluence.mod.common.init.armor.ArmorItems;
import org.confluence.mod.common.init.block.BoxBlocks;
import org.confluence.mod.common.init.block.DecorativeBlocks;
import org.confluence.mod.common.init.block.ModBlocks;
import org.confluence.mod.common.init.block.OreBlocks;
import org.confluence.mod.common.init.item.*;

import static org.confluence.mod.common.init.block.ModBlocks.*;

public class ModChineseProvider extends LanguageProvider {
    public ModChineseProvider(PackOutput output) {
        super(output, Confluence.MODID, "zh_cn");
    }

    @Override
    protected void addTranslations() {

        add("config.jade.plugin_confluence.jade_mechanical_component", "机械信息");

        add("creativetab.confluence.building_blocks", "汇流来世 | 建筑方块");
        add("creativetab.confluence.natural_blocks", "汇流来世 | 自然方块");
        add("creativetab.confluence.materials", "汇流来世 | 材料");
        add("creativetab.confluence.tools", "汇流来世 | 工具");
        add("creativetab.confluence.warriors", "汇流来世 | 战士武器");
        add("creativetab.confluence.rangers", "汇流来世 | 射手武器");
        add("creativetab.confluence.mages", "汇流来世 | 法师武器");
        add("creativetab.confluence.summoners", "汇流来世 | 召唤师武器");
        add("creativetab.confluence.misc", "汇流来世 | 杂项");
        add("creativetab.confluence.food_and_potions", "汇流来世 | 食物与药水");
        add("creativetab.confluence.armors", "汇流来世 | 盔甲");
        add("creativetab.confluence.accessories", "汇流来世 | 配饰");
        add("creativetab.confluence.mechanical", "汇流来世 | 器械");
        add("creativetab.confluence.developer", "汇流来世 | 开发者物品");

        add("item.confluence.meteorite_ingot.tooltip", "摸起来是温的");

        add("gamerule.confluenceSpreadableChance", "邪恶群系蔓延设置");
        add("generator.confluence.corruption", "腐化之地");
        add("generator.confluence.tr_crimson", "猩红之地");

        add("bossevent.confluence.boss_generate", "%s已经苏醒！");
        add("bossevent.confluence.boss_death", "%s已被击败！");
        add("bossevent.confluence.cthulhu_eye.leave", "克苏鲁之眼离开了！");

        add("entity.confluence.ice_slime", "冰冻史莱姆");
        add("entity.confluence.blue_slime", "蓝色史莱姆");
        add("entity.confluence.red_slime", "红色史莱姆");
        add("entity.confluence.purple_slime", "紫色史莱姆");
        add("entity.confluence.jungle_slime", "丛林史莱姆");
        add("entity.confluence.pink_slime", "粉色史莱姆");
        add("entity.confluence.yellow_slime", "黄色史莱姆");
        add("entity.confluence.honey_slime", "蜂蜜史莱姆");
        add("entity.confluence.crimson_slime", "猩红史莱姆");
        add("entity.confluence.corrupted_slime", "腐化史莱姆");
        add("entity.confluence.desert_slime", "沙漠史莱姆");
        add("entity.confluence.tropic_slime", "热带史莱姆");
        add("entity.confluence.green_slime", "绿色史莱姆");
        add("entity.confluence.black_slime", "史莱姆之母");
        add("entity.confluence.lava_slime", "岩浆史莱姆");
        add("entity.confluence.demon_eye", "恶魔眼");
        add("entity.confluence.blood_crawler", "血爬虫");
        add("entity.confluence.bloody_spore", "血腥芽孢");

        add("entity.confluence.king_slime", "史莱姆王");
        add("entity.confluence.cthulhu_eye", "克苏鲁之眼");

        add("info.confluence.bait", "鱼饵力: %s%%");
        add("info.confluence.network", "#%s 信号: %s");
        add("info.confluence.potion_mana", "药水魔力: %s");
        add("info.confluence.respawn_time", "复活剩余时间: ");
        add("info.confluence.second", "秒");

        add("key.confluence.hook", "使用钩爪");

        add("curios.identifier.hook", "钩爪");
        add("curios.identifier.minecart", "矿车");

        add("death.attack.falling_star", "%1$s 得到了流星的回应");
        add("death.attack.boulder", "%1$s 被巨石均匀地涂抹在地上");

        add("biome.confluence.the_corruption", "腐化之地");
        add("biome.confluence.the_corruption_desert", "腐化沙漠");
        add("biome.confluence.the_corruption_tundra", "腐化苔原");
        add("biome.confluence.tr_crimson", "猩红之地");
        add("biome.confluence.tr_crimson_desert", "猩红沙漠");
        add("biome.confluence.tr_crimson_tundra", "猩红苔原");
        add("biome.confluence.the_hallow", "神圣之地");
        add("biome.confluence.the_hallow_desert", "神圣沙漠");
        add("biome.confluence.the_hallow_tundra", "神圣苔原");
        add("biome.confluence.glowing_mushroom", "发光蘑菇群系");
        add("biome.confluence.ash_wasteland", "灰烬荒地");
        add("biome.confluence.ash_forest", "白蜡木林");

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
        add("painting.confluence.uqtqu_day.author", "BiliBili__昼泽_，✞ʚ散兵重度依赖ɞ✟⁺");
        add("painting.confluence.emerald_shenyi.title", "EMERALD_SHENYI");
        add("painting.confluence.emerald_shenyi.author", "BiliBili_Emerald_审翼");
        add("painting.confluence.chromatic.title", "CHROMATIC");
        add("painting.confluence.chromatic.author", "BiliBili_陌林_Chromatic");

        // new
        add("achievements.toast.complete", "成就达成！");
        add("achievements.confluence.new_world.title", "旧的世界，新的旅途！");
        add("achievements.confluence.new_world.description", "汇合交流的来世。");
        add("achievements.confluence.timber.title", "木材！！");
        add("achievements.confluence.timber.description", "砍倒第一棵树。");
        add("achievements.confluence.benched.title", "准备到位");
        add("achievements.confluence.benched.description", "制作你的第一个工作台。");
        add("achievements.confluence.star_power.title", "星之力");
        add("achievements.confluence.star_power.description", "使用坠落之星制作魔力水晶并使用它。");
        add("achievements.confluence.ooo_shinny.title", "哦！亮闪闪！");
        add("achievements.confluence.ooo_shinny.description", "用镐开采第一块矿石。");
        add("achievements.confluence.i_am_loot.title", "我要洗劫！");
        add("achievements.confluence.i_am_loot.description", "在地下发现一个金箱子并看看里面有什么。");
        add("achievements.confluence.hold_on_tight.title", "抓紧！");
        add("achievements.confluence.hold_on_tight.description", "首次装备抓钩。");
        add("achievements.confluence.heavy_metal.title", "重金属");
        add("achievements.confluence.heavy_metal.description", "获得由铁或铅制成的砧子。");
        add("achievements.confluence.heart_breaker.title", "伤心者");
        add("achievements.confluence.heart_breaker.description", "首次在地下发现并粉碎水晶之心。");
        add("achievements.confluence.hammer_time.title", "停！锤子时间到！");
        add("achievements.confluence.hammer_time.description", "通过制作或其他方式获得第一把锤子。");
        add("achievements.confluence.boots_of_the_hero.title", "英雄之靴");
        add("achievements.confluence.boots_of_the_hero.description", "这是用最好的火靴和最好的冰靴铸成的。");
        add("achievements.confluence.black_mirror.title", "黑镜");
        add("achievements.confluence.black_mirror.description", "你以后再也不会不带它就出门。");
        add("achievements.confluence.ankhumulation_complete.title", "十字章收集完成");
        add("achievements.confluence.ankhumulation_complete.description", "这是对抗烦人疾病的最佳防护。");
        add("achievements.confluence.a_shimmer_in_the_dark.title", "暗中微光");
        add("achievements.confluence.a_shimmer_in_the_dark.description", "用微光将一个物品变成另一个物品。你还能找到哪些其他变化？");

        add("achievements.confluence.pretty_in_pink.title", "粉红佳人");
        add("achievements.confluence.pretty_in_pink.description", "杀死粉史莱姆。");
        add("achievements.confluence.slippery_shinobi.title", "黏滑忍者");
        add("achievements.confluence.slippery_shinobi.description", "打败史莱姆王，它是所有黏滑生物的首领。");
        add("achievements.confluence.eye_on_you.title", "盯着你");
        add("achievements.confluence.eye_on_you.description", "打败克苏鲁之眼，它是只在夜间出没的危险眼球怪。");

        add("prefix.confluence.hard", "坚硬");
        add("prefix.confluence.guarding", "守护");
        add("prefix.confluence.armored", "装甲");
        add("prefix.confluence.warding", "护佑");
        add("prefix.confluence.precise", "精确");
        add("prefix.confluence.lucky", "幸运");
        add("prefix.confluence.jagged", "锯齿");
        add("prefix.confluence.spiked", "尖刺");
        add("prefix.confluence.angry", "愤怒");
        add("prefix.confluence.menacing", "险恶");
        add("prefix.confluence.wild", "狂野");
        add("prefix.confluence.rash", "鲁莽");
        add("prefix.confluence.intrepid", "勇猛");
        add("prefix.confluence.violent", "暴力");
        add("prefix.confluence.brisk", "轻快");
        add("prefix.confluence.fleeting", "快速");
        add("prefix.confluence.hasty", "急速");
        add("prefix.confluence.quick", "迅捷");
        add("prefix.confluence.arcane", "奥秘");
        add("prefix.confluence.keen", "锐利");
        add("prefix.confluence.superior", "高端");
        add("prefix.confluence.forceful", "强力");
        add("prefix.confluence.broken", "碎裂");
        add("prefix.confluence.damaged", "破损");
        add("prefix.confluence.shoddy", "粗劣");
        add("prefix.confluence.hurtful", "致伤");
        add("prefix.confluence.strong", "强劲");
        add("prefix.confluence.unpleasant", "粗鲁");
        add("prefix.confluence.weak", "虚弱");
        add("prefix.confluence.ruthless", "无情");
        add("prefix.confluence.godly", "神级");
        add("prefix.confluence.demonic", "恶魔");
        add("prefix.confluence.zealous", "狂热");
        add("prefix.confluence.deadly", "致命");
        add("prefix.confluence.agile", "灵活");
        add("prefix.confluence.nimble", "灵巧");
        add("prefix.confluence.murderous", "残暴");
        add("prefix.confluence.slow", "缓慢");
        add("prefix.confluence.sluggish", "迟钝");
        add("prefix.confluence.lazy", "呆滞");
        add("prefix.confluence.annoying", "惹恼");
        add("prefix.confluence.nasty", "凶险");
        add("prefix.confluence.large", "大");
        add("prefix.confluence.massive", "巨大");
        add("prefix.confluence.dangerous", "危险");
        add("prefix.confluence.savage", "凶险");
        add("prefix.confluence.sharp", "锋利");
        add("prefix.confluence.pointy", "尖锐");
        add("prefix.confluence.tiny", "微小");
        add("prefix.confluence.terrible", "可怕");
        add("prefix.confluence.small", "小");
        add("prefix.confluence.dull", "钝");
        add("prefix.confluence.unhappy", "倒霉");
        add("prefix.confluence.bulky", "笨蛋");
        add("prefix.confluence.shameful", "可耻");
        add("prefix.confluence.heavy", "重");
        add("prefix.confluence.light", "轻");
        add("prefix.confluence.legendary", "传奇");
        add("prefix.confluence.sighted", "精准");
        add("prefix.confluence.rapid", "迅速");
        add("prefix.confluence.intimidating", " 恐怖");
        add("prefix.confluence.staunch", "可靠");
        add("prefix.confluence.awful", "可畏");
        add("prefix.confluence.lethargic", "无力");
        add("prefix.confluence.awkward", "粗笨");
        add("prefix.confluence.powerful", "强大");
        add("prefix.confluence.frenzying", "暴怒");
        add("prefix.confluence.mythic", "神秘");
        add("prefix.confluence.adeptl", "精巧");
        add("prefix.confluence.masterful", "精湛");
        add("prefix.confluence.inept", "笨拙");
        add("prefix.confluence.ignorant", "无知");
        add("prefix.confluence.deranged", "错乱");
        add("prefix.confluence.intense", "威猛");
        add("prefix.confluence.taboo", "禁忌");
        add("prefix.confluence.celestial", "天界");
        add("prefix.confluence.furious", "狂怒");
        add("prefix.confluence.manic", "狂躁");
        add("prefix.confluence.mythical", "神话");
        add("prefix.confluence.unreal", "虚幻");

        add("fluid_type.confluence.shimmer", "微光");
        add("fluid_type.confluence.honey", "蜂蜜");

        add("title.confluence.shimmer_transmutation", "微光嬗变");
        add("title.confluence.altar", "献祭");
        add("title.confluence.sky_mill", "天域工艺");
        add("container.confluence.sky_mill", "天域工艺");
        add("condition.confluence.shimmer_transmutation", "需要的游戏阶段: %s");

        add("info.confluence.weather_radio.clear", "天气: 晴天, 风速: %s");
        add("info.confluence.weather_radio.cloudy", "天气: 阴天, 风速: %s");
        add("info.confluence.weather_radio.rain", "天气: 下雨, 风速: %s");
        add("info.confluence.weather_radio.snow", "天气: 下雪, 风速: %s");
        add("info.confluence.weather_radio.thunder", "天气: 雷暴, 风速: %s");

        add("block.confluence.base_chest_block.locked_golden", "§r上锁的金箱");
        add("block.confluence.base_chest_block.unlocked_golden", "§r金箱");
        add("block.confluence.base_chest_block.death_golden", "§r死人金箱");
        add("block.confluence.base_chest_block.locked_shadow", "§r上锁的暗影箱");
        add("block.confluence.base_chest_block.unlocked_shadow", "§r暗影箱");
        add("block.confluence.base_chest_block.death_shadow", "§r死人暗影箱");
        add("block.confluence.base_chest_block.unlocked_lvy", "§r常春藤箱");
        add("block.confluence.base_chest_block.death_lvy", "§r死人常春藤箱");
        add("block.confluence.base_chest_block.unlocked_frozen", "§r冰冻箱");
        add("block.confluence.base_chest_block.death_frozen", "§r死人冰冻箱");
        add("block.confluence.base_chest_block.unlocked_water", "§r水中箱");
        add("block.confluence.base_chest_block.death_water", "§r死人水中箱");
        add("block.confluence.base_chest_block.unlocked_skyware", "§r天域箱");
        add("block.confluence.white_plastic_chair", "大排档凳子");

        add("resourcepack.terraria_art", "泰拉艺术");
        add("resourcepack.mainstream_connected_ores", "主流：连接矿石材质");
        add("resourcepack.ter_armor", "主流：泰拉盔甲样式材质");

        add("event.confluence.blood_moon", "血月正在升起...");

        add("attribute.name.player.minion_capacity", "仆从容量");
        add("attribute.name.player.sentry_capacity", "哨兵容量");
        add("attribute.name.player.summon_damage", "召唤伤害");
        add("attribute.name.player.summon_knockback", "召唤击退");
        add("attribute.name.player.whip_range", "鞭范围");

        add("entity.minecraft.villager.confluence.sky_miller", "天师");
        add("entity.minecraft.villager.confluence.banker", "银行家");

        add("title.confluence.wiki", "汇流来世Wiki");
        add("wiki.confluence.back", "返回上级菜单");
        add("title.confluence.group", "组Wiki");
        add("wiki.confluence.item", "物品");
        add("wiki.confluence.type_accessories", "饰品");
        add("wiki.confluence.type_arrow", "箭矢");
        add("wiki.confluence.type_axe", "斧");
        add("wiki.confluence.type_bait", "鱼饵");
        add("wiki.confluence.type_bow", "弓");
        add("wiki.confluence.type_fishing_pole", "鱼竿");
        add("wiki.confluence.type_food", "食物");
        add("wiki.confluence.type_material", "材料");
        add("wiki.confluence.type_misc", "杂项");
        add("wiki.confluence.type_quested_fish", "任务鱼");
        add("wiki.confluence.type_sword", "剑");
        add("wiki.confluence.type_terra_potion", "药水");
        add("wiki.confluence.setDamage", "攻击伤害：");
        add("wiki.confluence.use", "耐久：");
        add("wiki.confluence.speed", "使用速度：");
        add("wiki.confluence.enchantment", "附魔等级：");
        add("wiki.confluence.ingredient", "修复材料：");
        add("wiki.confluence.power", "稿力：");
        add("wiki.confluence.nutrition", "饱食度：");
        add("wiki.confluence.saturation", "饱和度：");

        add("wiki.confluence.copper_short_sword", """
                铜短剑是游戏早期的金属短剑。其代用矿石对应物是锡短剑。
                
                和所有短剑一样，铜短剑的攻击范围非常有限，
                且以向任意方向 / 水平地向玩家前方刺击而非弧线挥击的方式攻击，
                这使其在对付飞行或跳跃敌怪时几乎毫无用处，
                不过它的高攻击速率使其在对付较弱的战士类敌怪时还能派的上点用场。
                
                其最佳修饰语是传奇。""");

        //region blocks
        add(OreBlocks.SANCTIFICATION_COAL_ORE.get(), "圣化煤矿石");
        add(OreBlocks.CORRUPTION_COAL_ORE.get(), "腐化煤矿石");
        add(OreBlocks.FLESHIFICATION_COAL_ORE.get(), "血化煤矿石");
        add(OreBlocks.TIN_ORE.get(), "锡矿石");
        add(OreBlocks.SANCTIFICATION_TIN_ORE.get(), "圣化锡矿石");
        add(OreBlocks.CORRUPTION_TIN_ORE.get(), "腐化锡矿石");
        add(OreBlocks.FLESHIFICATION_TIN_ORE.get(), "血化锡矿石");
        add(OreBlocks.DEEPSLATE_TIN_ORE.get(), "深层锡矿石");
        add(OreBlocks.RAW_TIN_BLOCK.get(), "粗锡块");
        add(OreBlocks.TIN_BLOCK.get(), "锡块");
        add(OreBlocks.SANCTIFICATION_COPPER_ORE.get(), "圣化铜矿石");
        add(OreBlocks.CORRUPTION_COPPER_ORE.get(), "腐化铜矿石");
        add(OreBlocks.FLESHIFICATION_COPPER_ORE.get(), "血化铜矿石");
        add(OreBlocks.SANCTIFICATION_IRON_ORE.get(), "圣化铁矿石");
        add(OreBlocks.CORRUPTION_IRON_ORE.get(), "腐化铁矿石");
        add(OreBlocks.FLESHIFICATION_IRON_ORE.get(), "血化铁矿石");
        add(OreBlocks.LEAD_ORE.get(), "铅矿石");
        add(OreBlocks.SANCTIFICATION_LEAD_ORE.get(), "圣化铅矿石");
        add(OreBlocks.CORRUPTION_LEAD_ORE.get(), "腐化铅矿石");
        add(OreBlocks.FLESHIFICATION_LEAD_ORE.get(), "血化铅矿石");
        add(OreBlocks.DEEPSLATE_LEAD_ORE.get(), "深层铅矿石");
        add(OreBlocks.RAW_LEAD_BLOCK.get(), "粗铅块");
        add(OreBlocks.LEAD_BLOCK.get(), "铅块");
        add(OreBlocks.SILVER_ORE.get(), "银矿石");
        add(OreBlocks.SANCTIFICATION_SILVER_ORE.get(), "圣化银矿石");
        add(OreBlocks.CORRUPTION_SILVER_ORE.get(), "腐化银矿石");
        add(OreBlocks.FLESHIFICATION_SILVER_ORE.get(), "血化银矿石");
        add(OreBlocks.DEEPSLATE_SILVER_ORE.get(), "深层银矿石");
        add(OreBlocks.RAW_SILVER_BLOCK.get(), "粗银块");
        add(OreBlocks.SILVER_BLOCK.get(), "银块");
        add(OreBlocks.TUNGSTEN_ORE.get(), "钨矿石");
        add(OreBlocks.SANCTIFICATION_TUNGSTEN_ORE.get(), "圣化钨矿石");
        add(OreBlocks.CORRUPTION_TUNGSTEN_ORE.get(), "腐化钨矿石");
        add(OreBlocks.FLESHIFICATION_TUNGSTEN_ORE.get(), "血化钨矿石");
        add(OreBlocks.DEEPSLATE_TUNGSTEN_ORE.get(), "深层钨矿石");
        add(OreBlocks.RAW_TUNGSTEN_BLOCK.get(), "粗钨块");
        add(OreBlocks.TUNGSTEN_BLOCK.get(), "钨块");
        add(OreBlocks.SANCTIFICATION_GOLD_ORE.get(), "圣化金矿石");
        add(OreBlocks.CORRUPTION_GOLD_ORE.get(), "腐化金矿石");
        add(OreBlocks.FLESHIFICATION_GOLD_ORE.get(), "血化金矿石");
        add(OreBlocks.PLATINUM_ORE.get(), "铂金矿石");
        add(OreBlocks.SANCTIFICATION_PLATINUM_ORE.get(), "圣化铂金矿石");
        add(OreBlocks.CORRUPTION_PLATINUM_ORE.get(), "腐化铂金矿石");
        add(OreBlocks.FLESHIFICATION_PLATINUM_ORE.get(), "血化铂金矿石");
        add(OreBlocks.DEEPSLATE_PLATINUM_ORE.get(), "深层铂金矿石");
        add(OreBlocks.RAW_PLATINUM_BLOCK.get(), "粗铂金块");
        add(OreBlocks.PLATINUM_BLOCK.get(), "铂金块");
        add(OreBlocks.RUBY_ORE.get(), "红玉矿石");
        add(OreBlocks.SANCTIFICATION_RUBY_ORE.get(), "圣化红玉矿石");
        add(OreBlocks.CORRUPTION_RUBY_ORE.get(), "腐化红玉矿石");
        add(OreBlocks.FLESHIFICATION_RUBY_ORE.get(), "血化红玉矿石");
        add(OreBlocks.DEEPSLATE_RUBY_ORE.get(), "深层红玉矿石");
        add(OreBlocks.TOPAZ_ORE.get(), "黄玉矿石");
        add(OreBlocks.SANCTIFICATION_TOPAZ_ORE.get(), "圣化黄玉矿石");
        add(OreBlocks.CORRUPTION_TOPAZ_ORE.get(), "腐化黄玉矿石");
        add(OreBlocks.FLESHIFICATION_TOPAZ_ORE.get(), "血化黄玉矿石");
        add(OreBlocks.DEEPSLATE_TOPAZ_ORE.get(), "深层黄玉矿石");
        add(OreBlocks.AMBER_ORE.get(), "琥珀矿石");
        add(OreBlocks.SANCTIFICATION_AMBER_ORE.get(), "圣化琥珀矿石");
        add(OreBlocks.CORRUPTION_AMBER_ORE.get(), "腐化琥珀矿石");
        add(OreBlocks.FLESHIFICATION_AMBER_ORE.get(), "血化琥珀矿石");
        add(OreBlocks.DEEPSLATE_AMBER_ORE.get(), "深层琥珀矿石");
//        add(ModOreBlocks.TR_EMERALD_ORE.get(), "翡翠矿石");
//        add(ModOreBlocks.SANCTIFICATION_TR_EMERALD_ORE.get(), "圣化翡翠矿石");
//        add(ModOreBlocks.CORRUPTION_TR_EMERALD_ORE.get(), "腐化翡翠矿石");
//        add(ModOreBlocks.FLESHIFICATION_TR_EMERALD_ORE.get(), "血化翡翠矿石");
//        add(ModOreBlocks.DEEPSLATE_TR_EMERALD_ORE.get(), "深层翡翠矿石");
        add(OreBlocks.TR_AMETHYST_ORE.get(), "异域紫晶矿石");
        add(OreBlocks.SANCTIFICATION_TR_AMETHYST_ORE.get(), "圣化异域紫晶矿石");
        add(OreBlocks.CORRUPTION_TR_AMETHYST_ORE.get(), "腐化异域紫晶矿石");
        add(OreBlocks.FLESHIFICATION_TR_AMETHYST_ORE.get(), "血化异域紫晶矿石");
        add(OreBlocks.DEEPSLATE_TR_AMETHYST_ORE.get(), "深层异域紫晶矿石");
        add(OreBlocks.SAPPHIRE_ORE.get(), "蓝玉矿石");
        add(OreBlocks.SANCTIFICATION_SAPPHIRE_ORE.get(), "圣化蓝玉矿石");
        add(OreBlocks.CORRUPTION_SAPPHIRE_ORE.get(), "腐化蓝玉矿石");
        add(OreBlocks.FLESHIFICATION_SAPPHIRE_ORE.get(), "血化蓝玉矿石");
        add(OreBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), "深层蓝玉矿石");
        add(OreBlocks.SANCTIFICATION_EMERALD_ORE.get(), "珍珠石绿宝石矿石");
        add(OreBlocks.CORRUPTION_EMERALD_ORE.get(), "腐化绿宝石矿石");
        add(OreBlocks.FLESHIFICATION_EMERALD_ORE.get(), "血化绿宝石矿石");
        add(OreBlocks.SANCTIFICATION_DIAMOND_ORE.get(), "圣化钻石矿石");
        add(OreBlocks.CORRUPTION_DIAMOND_ORE.get(), "腐化钻石矿石");
        add(OreBlocks.FLESHIFICATION_DIAMOND_ORE.get(), "血化钻石矿石");
        add(OreBlocks.SANCTIFICATION_LAPIS_ORE.get(), "珍珠石青金石矿石");
        add(OreBlocks.CORRUPTION_LAPIS_ORE.get(), "腐化青金石矿石");
        add(OreBlocks.FLESHIFICATION_LAPIS_ORE.get(), "血化青金石矿石");
        add(OreBlocks.METEORITE_ORE.get(), "陨石矿石");
        add(OreBlocks.RAW_METEORITE_BLOCK.get(), "粗陨石块");
        add(OreBlocks.METEORITE_BLOCK.get(), "陨石块");
        add(OreBlocks.STURDY_FOSSIL_BLOCK.get(), "坚固化石块");
        add(OreBlocks.EBONY_ORE.get(), "魔矿石");
        add(OreBlocks.SANCTIFICATION_EBONY_ORE.get(), "圣化魔矿石");
        add(OreBlocks.CORRUPTION_EBONY_ORE.get(), "腐化魔矿石");
        add(OreBlocks.FLESHIFICATION_EBONY_ORE.get(), "血化魔矿石");
        add(OreBlocks.DEEPSLATE_EBONY_ORE.get(), "深层魔矿石");
        add(OreBlocks.EBONY_BLOCK.get(), "魔矿块");
        add(OreBlocks.RAW_EBONY_BLOCK.get(), "魔原矿块");
        add(OreBlocks.TR_CRIMSON_ORE.get(), "猩红矿石");
        add(OreBlocks.SANCTIFICATION_TR_CRIMSON_ORE.get(), "圣化猩红矿石");
        add(OreBlocks.CORRUPTION_TR_CRIMSON_ORE.get(), "腐化猩红矿石");
        add(OreBlocks.FLESHIFICATION_TR_CRIMSON_ORE.get(), "血化猩红矿石");
        add(OreBlocks.DEEPSLATE_TR_CRIMSON_ORE.get(), "深层猩红矿石");
        add(OreBlocks.TR_CRIMSON_BLOCK.get(), "猩红矿块");
        add(OreBlocks.RAW_TR_CRIMSON_BLOCK.get(), "猩红原矿块");
        add(OreBlocks.HELLSTONE.get(), "下界狱石");
        add(OreBlocks.ASH_HELLSTONE.get(), "灰烬狱石");
        add(OreBlocks.HELLSTONE_BLOCK.get(), "狱石块");
        add(OreBlocks.RAW_HELLSTONE_BLOCK.get(), "狱石原矿块");
        add(OreBlocks.RAW_COBALT_BLOCK.get(), "钴原矿");
//        add(ModOreBlocks.DEEPSLATE_COBALT_ORE.get(), "深层钴矿");
        add(OreBlocks.COBALT_BLOCK.get(), "钴块");
        add(OreBlocks.RAW_PALLADIUM_BLOCK.get(), "钯金原矿");
//        add(ModOreBlocks.DEEPSLATE_PALLADIUM_ORE.get(), "深层钯金矿");
        add(OreBlocks.PALLADIUM_BLOCK.get(), "钯金块");
        add(OreBlocks.RAW_MITHRIL_BLOCK.get(), "秘银原矿");
//        add(ModOreBlocks.DEEPSLATE_MITHRIL_ORE.get(), "深层秘银矿");
        add(OreBlocks.MITHRIL_BLOCK.get(), "秘银块");
        add(OreBlocks.RAW_ORICHALCUM_BLOCK.get(), "山铜原矿");
//        add(ModOreBlocks.DEEPSLATE_ORICHALCUM_ORE.get(), "深层山铜矿");
        add(OreBlocks.ORICHALCUM_BLOCK.get(), "山铜块");
        add(OreBlocks.RAW_ADAMANTITE_BLOCK.get(), "精金原矿");
//        add(ModOreBlocks.DEEPSLATE_ADAMANTITE_ORE.get(), "深层精金矿");
        add(OreBlocks.ADAMANTITE_BLOCK.get(), "精金块");
        add(OreBlocks.RAW_TITANIUM_BLOCK.get(), "钛金原矿");
//        add(ModOreBlocks.DEEPSLATE_TITANIUM_ORE.get(), "深层钛金矿");
        add(OreBlocks.TITANIUM_BLOCK.get(), "钛金块");
        add(OreBlocks.CHLOROPHYTE_ORE.get(), "叶绿矿");
        add(OreBlocks.CHLOROPHYTE_BLOCK.get(), "叶绿块");
        add(OreBlocks.RAW_CHLOROPHYTE_BLOCK.get(), "叶绿粗矿块");
        add(OreBlocks.LUMINITE_BLOCK.get(), "夜明块");
        add(OreBlocks.RAW_LUMINITE_BLOCK.get(), "夜明粗矿块");
        add(OreBlocks.HALLOWED_BLOCK.get(), "神圣块");
        add(OreBlocks.SPECTRE_BLOCK.get(), "幽灵块");
        add(OreBlocks.SHROOMITE_BLOCK.get(), "蘑菇矿块");

        add(EBONY_LOG_BLOCKS.getButton().get(), "乌木按钮");
        add(EBONY_LOG_BLOCKS.getPlanks().get(), "乌木板");
        add(EBONY_LOG_BLOCKS.getLog().get(), "乌木原木");
        add(EBONY_LOG_BLOCKS.getStrippedLog().get(), "乌木去皮原木");
        add(EBONY_LOG_BLOCKS.getStrippedWood().get(), "乌木去皮木");
        add(EBONY_LOG_BLOCKS.getDoor().get(), "乌木门");
        add(EBONY_LOG_BLOCKS.getSign().get(), "乌木告示牌");
        add(EBONY_LOG_BLOCKS.getStairs().get(), "乌木楼梯");
        add(EBONY_LOG_BLOCKS.getSlab().get(), "乌木台阶");
        add(EBONY_LOG_BLOCKS.getTrapdoor().get(), "乌木活板门");
        add(EBONY_LOG_BLOCKS.getPressurePlate().get(), "乌木压力板");
        add(EBONY_LOG_BLOCKS.getWood().get(), "乌木");
        add(EBONY_LOG_BLOCKS.getLeaves().get(), "乌木树叶");
        add(EBONY_LOG_BLOCKS.getFence().get(), "乌木栅栏");
        add(EBONY_LOG_BLOCKS.getFenceGate().get(), "乌木栅栏门");

        add(PEARL_LOG_BLOCKS.getButton().get(), "珍珠木按钮");
        add(PEARL_LOG_BLOCKS.getPlanks().get(), "珍珠木板");
        add(PEARL_LOG_BLOCKS.getLog().get(), "珍珠木原木");
        add(PEARL_LOG_BLOCKS.getStrippedLog().get(), "珍珠木去皮原木");
        add(PEARL_LOG_BLOCKS.getStrippedWood().get(), "珍珠木去皮木");
        add(PEARL_LOG_BLOCKS.getDoor().get(), "珍珠木门");
        add(PEARL_LOG_BLOCKS.getSign().get(), "珍珠木告示牌");
        add(PEARL_LOG_BLOCKS.getStairs().get(), "珍珠木楼梯");
        add(PEARL_LOG_BLOCKS.getSlab().get(), "珍珠木台阶");
        add(PEARL_LOG_BLOCKS.getTrapdoor().get(), "珍珠木活板门");
        add(PEARL_LOG_BLOCKS.getPressurePlate().get(), "珍珠木压力板");
        add(PEARL_LOG_BLOCKS.getWood().get(), "珍珠木");
        add(PEARL_LOG_BLOCKS.getLeaves().get(), "珍珠木树叶");
        add(PEARL_LOG_BLOCKS.getFence().get(), "珍珠木栅栏");
        add(PEARL_LOG_BLOCKS.getFenceGate().get(), "珍珠木栅栏门");

        add(SHADOW_LOG_BLOCKS.getButton().get(), "暗影木按钮");
        add(SHADOW_LOG_BLOCKS.getPlanks().get(), "暗影木板");
        add(SHADOW_LOG_BLOCKS.getLog().get(), "暗影木原木");
        add(SHADOW_LOG_BLOCKS.getStrippedLog().get(), "暗影木去皮原木");
        add(SHADOW_LOG_BLOCKS.getStrippedWood().get(), "暗影木去皮木");
        add(SHADOW_LOG_BLOCKS.getDoor().get(), "暗影木门");
        add(SHADOW_LOG_BLOCKS.getTrapdoor().get(), "暗影木活板门");
        add(SHADOW_LOG_BLOCKS.getSign().get(), "暗影木告示牌");
        add(SHADOW_LOG_BLOCKS.getStairs().get(), "暗影木楼梯");
        add(SHADOW_LOG_BLOCKS.getSlab().get(), "暗影木台阶");
        add(SHADOW_LOG_BLOCKS.getWood().get(), "暗影木");
        add(SHADOW_LOG_BLOCKS.getLeaves().get(), "暗影木树叶");
        add(SHADOW_LOG_BLOCKS.getFence().get(), "暗影木栅栏");
        add(SHADOW_LOG_BLOCKS.getFenceGate().get(), "暗影木栅栏门");
        add(SHADOW_LOG_BLOCKS.getPressurePlate().get(), "暗影木压力板");

        add(PALM_LOG_BLOCKS.getButton().get(), "沙漠风情按钮");
        add(PALM_LOG_BLOCKS.getPlanks().get(), "沙漠风情木板");
        add(PALM_LOG_BLOCKS.getLog().get(), "棕榈原木");
        add(PALM_LOG_BLOCKS.getDoor().get(), "沙漠风情木门");
        add(PALM_LOG_BLOCKS.getTrapdoor().get(), "沙漠风情活板门");
        add(PALM_LOG_BLOCKS.getSign().get(), "沙漠风情告示牌");
        add(PALM_LOG_BLOCKS.getStairs().get(), "沙漠风情楼梯");
        add(PALM_LOG_BLOCKS.getSlab().get(), "沙漠风情台阶");
        add(PALM_LOG_BLOCKS.getWood().get(), "棕榈木");
        add(PALM_LOG_BLOCKS.getStrippedLog().get(), "棕榈去皮原木");
        add(PALM_LOG_BLOCKS.getStrippedWood().get(), "棕榈去皮木");
        add(PALM_LOG_BLOCKS.getLeaves().get(), "棕榈树叶");
        add(PALM_LOG_BLOCKS.getFence().get(), "沙漠风情栅栏");
        add(PALM_LOG_BLOCKS.getFenceGate().get(), "沙漠风情栅栏门");
        add(PALM_LOG_BLOCKS.getPressurePlate().get(), "沙漠风情压力板");

        add(ASH_LOG_BLOCKS.getButton().get(), "白蜡木按钮");
        add(ASH_LOG_BLOCKS.getPlanks().get(), "白蜡木板");
        add(ASH_LOG_BLOCKS.getLog().get(), "白蜡木原木");
        add(ASH_LOG_BLOCKS.getStrippedLog().get(), "白蜡木去皮原木");
        add(ASH_LOG_BLOCKS.getStrippedWood().get(), "白蜡木去皮木");
        add(ASH_LOG_BLOCKS.getDoor().get(), "白蜡木门");
        add(ASH_LOG_BLOCKS.getTrapdoor().get(), "白蜡木活板门");
        add(ASH_LOG_BLOCKS.getSign().get(), "白蜡木告示牌");
        add(ASH_LOG_BLOCKS.getStairs().get(), "白蜡木楼梯");
        add(ASH_LOG_BLOCKS.getSlab().get(), "白蜡木台阶");
        add(ASH_LOG_BLOCKS.getWood().get(), "白蜡木");
        add(ASH_LOG_BLOCKS.getLeaves().get(), "白蜡木树叶");
        add(ASH_LOG_BLOCKS.getFence().get(), "白蜡木栅栏");
        add(ASH_LOG_BLOCKS.getFenceGate().get(), "白蜡木栅栏门");
        add(ASH_LOG_BLOCKS.getPressurePlate().get(), "白蜡木压力板");

/*
        add(LIFE_LOG.get(), "生命原木");
        add(LIFE_LEAVES.get(), "生命木树叶");
        add(LIFE_PLANKS.get(), "生命木板");
        */


//      add(ModBlocks.DESERT_FOSSIL.get(), "沙漠化石");
        add(ModBlocks.HARDENED_SAND_BLOCK.get(), "硬化沙块");
        add(ModBlocks.SAND_LAYER_BLOCK.get(), "沙片");
        add(ModBlocks.RED_SAND_LAYER_BLOCK.get(), "红沙片");
//        add(ModBlocks.RED_HARDENED_SAND_BLOCK.get(), "硬化红沙块");
//        add(ModBlocks.DIATOMACEOUS.get(), "硅藻土");
//        add(ModBlocks.SLUSH.get(), "雪泥块");
//        add(ModBlocks.MARINE_GRAVEL.get(), "海洋砂砾");
        add(ModBlocks.EBONY_STONE.get(), "黑檀石块");
        add(ModBlocks.EBONY_COBBLESTONE.get(), "黑檀圆石");
        add(ModBlocks.EBONY_HARDENED_SAND_BLOCK.get(), "硬化黑檀沙块");
        add(ModBlocks.EBONY_SANDSTONE.get(), "黑檀砂岩");
        add(ModBlocks.EBONY_SAND.get(), "黑檀沙块");
        add(ModBlocks.CORRUPT_GRASS_BLOCK.get(), "腐化草方块");
        add(ModBlocks.EBONY_SAND_LAYER_BLOCK.get(), "腐化沙片");
        add(ModBlocks.PEARL_STONE.get(), "珍珠石块");
        add(ModBlocks.PEARL_COBBLESTONE.get(), "珍珠圆石");
        add(ModBlocks.PEARL_HARDENED_SAND_BLOCK.get(), "硬化珍珠沙块");
        add(ModBlocks.PEARL_SANDSTONE.get(), "珍珠砂岩");
        add(ModBlocks.PEARL_SAND.get(), "珍珠沙块");
        add(ModBlocks.HALLOW_GRASS_BLOCK.get(), "神圣草方块");
        add(ModBlocks.PEARL_SAND_LAYER_BLOCK.get(), "神圣沙片");
        add(ModBlocks.TR_CRIMSON_STONE.get(), "猩红石块");
        add(ModBlocks.TR_CRIMSON_COBBLESTONE.get(), "猩红圆石");
        add(ModBlocks.TR_CRIMSON_HARDENED_SAND_BLOCK.get(), "硬化猩红沙块");
        add(ModBlocks.TR_CRIMSON_SANDSTONE.get(), "猩红砂岩");
        add(ModBlocks.TR_CRIMSON_SAND.get(), "猩红沙块");
        add(ModBlocks.TR_CRIMSON_SAND_LAYER_BLOCK.get(), "猩红沙片");
        add(ModBlocks.RED_ICE.get(), "红冰块");
        add(ModBlocks.RED_PACKED_ICE.get(), "红浮冰块");
        add(ModBlocks.PINK_ICE.get(), "粉冰块");
        add(ModBlocks.PINK_PACKED_ICE.get(), "粉浮冰块");
        add(ModBlocks.PURPLE_ICE.get(), "紫冰块");
        add(ModBlocks.PURPLE_PACKED_ICE.get(), "紫浮冰块");
        add(ModBlocks.TR_CRIMSON_GRASS_BLOCK.get(), "猩红草方块");
        add(ModBlocks.MUSHROOM_GRASS_BLOCK.get(), "蘑菇草方块");
        add(ModBlocks.ASH_BLOCK.get(), "灰烬块");
        add(ModBlocks.ASH_GRASS_BLOCK.get(), "灰烬草块");
        add(ModBlocks.ASH_GRASS.get(), "灰烬草");
//        add(ModBlocks.BIG_RUBY_BLOCK.get(), "大红玉块");
//        add(ModBlocks.BIG_AMBER_BLOCK.get(), "大琥珀块");
//        add(ModBlocks.BIG_TOPAZ_BLOCK.get(), "大黄玉块");
//        add(ModBlocks.BIG_TR_EMERALD_BLOCK.get(), "大翡翠块");
//        add(ModBlocks.BIG_SAPPHIRE_BLOCK.get(), "大蓝玉块");
//        add(ModBlocks.BIG_TR_AMETHYST_BLOCK.get(), "大紫晶块");
//        add(ModBlocks.TR_POLISHED_GRANITE.get(), "异域花岗岩块");
//        add(ModBlocks.POLISHED_MARBLE.get(), "异域大理石块");
        add(DecorativeBlocks.TR_COPPER_BRICKS.get(), "铜砖块");
//        add(ModBlocks.TR_COPPER_PLATE.get(), "铜条板块");
        add(DecorativeBlocks.TR_CRIMSON_ORE_BRICKS.get(), "猩红矿砖");
        add(DecorativeBlocks.TR_CRIMSON_ROCK_BRICKS.get(), "猩红石砖");
        add(DecorativeBlocks.TR_GOLD_BRICKS.get(), "金砖块");
        add(DecorativeBlocks.TR_IRON_BRICKS.get(), "铁砖块");
        add(DecorativeBlocks.TR_STONE_BRICKS.get(), "异域石砖");
//        add(ModBlocks.EBONY_ORE_BRICKS.get(), "魔矿砖");
//        add(ModBlocks.EBONY_ROCK_BRICKS.get(), "黑檀石砖");
        add(DecorativeBlocks.BLUE_GEL_BLOCK.get(), "凝胶块");
        add(DecorativeBlocks.GREEN_CANDY_BLOCK.get(), "绿色糖块");
        add(DecorativeBlocks.ICE_BRICKS.get(), "冰砖块");
        add(DecorativeBlocks.FROZEN_GEL_BLOCK.get(), "冻凝胶块");
        add(DecorativeBlocks.LEAD_BRICKS.get(), "铅砖块");
        add(DecorativeBlocks.METEORITE_BRICKS.get(), "陨石砖块");
//        add(ModBlocks.PEARL_ROCK_BRICKS.get(), "珍珠石砖");
        add(DecorativeBlocks.PINK_GEL_BLOCK.get(), "粉凝胶块");
        add(DecorativeBlocks.PLATINUM_BRICKS.get(), "铂金砖块");
        add(DecorativeBlocks.RED_CANDY_BLOCK.get(), "红色糖块");
        add(DecorativeBlocks.SILVER_BRICKS.get(), "银砖块");
        add(DecorativeBlocks.SNOW_BRICKS.get(), "雪砖块");
        add(DecorativeBlocks.SUN_PLATE.get(), "日盘块");
        add(DecorativeBlocks.TIN_BRICKS.get(), "锡砖块");
//        add(ModBlocks.TIN_PLATE.get(), "锡条板块");
        add(DecorativeBlocks.TUNGSTEN_BRICKS.get(), "钨砖块");
        add(DecorativeBlocks.TR_LAVA_BEAM.get(), "异域熔岩梁");
        add(DecorativeBlocks.TR_LAVA_BRICKS.get(), "异域熔岩砖块");
        add(DecorativeBlocks.TR_OBSIDIAN_BEAM.get(), "异域黑曜石梁");
        add(DecorativeBlocks.TR_OBSIDIAN_BRICKS.get(), "异域黑曜石砖");
        add(DecorativeBlocks.TR_OBSIDIAN_PLATE.get(), "异域黑曜石条板块");
        add(DecorativeBlocks.TR_OBSIDIAN_SMALL_BRICKS.get(), "异域切制黑曜石砖");
        add(DecorativeBlocks.TR_SMOOTH_OBSIDIAN.get(), "异域光滑黑曜石块");
        add(DecorativeBlocks.CHISELED_TR_OBSIDIAN_BRICKS.get(), "錾制异域黑曜石块");
        add(DecorativeBlocks.CRYSTAL_BLOCK.get(), "水晶块");
        add(DecorativeBlocks.RAINBOW_BRICK.get(), "彩虹砖");
        add(DecorativeBlocks.TR_OAK_BEAM.get(), "经典风情木梁");
//        add(ModBlocks.TR_OAK_PLANKS.get(), "经典风情木板");
        add(DecorativeBlocks.TR_NORTHLAND_BEAM.get(), "北地风情木梁");
//        add(ModBlocks.TR_NORTHLAND_PLANKS.get(), "北地风情木板");
//        add(ModBlocks.TR_GRANITE_COLUMN.get(), "异域花岗岩梁");
//        add(ModBlocks.MARBLE_COLUMN.get(), "异域大理岩梁");
        add(DecorativeBlocks.PURE_GLASS.get(), "纯净玻璃块");
//        add(ModBlocks.WHITE_PURE_GLASS.get(), "白色纯净玻璃块");
//        add(ModBlocks.LIGHT_GRAY_PURE_GLASS.get(), "淡灰色玻璃块");
//        add(ModBlocks.GRAY_PURE_GLASS.get(), "灰色纯净玻璃块");
//        add(ModBlocks.BLACK_PURE_GLASS.get(), "黑色纯净玻璃块");
//        add(ModBlocks.BROWN_PURE_GLASS.get(), "棕色纯净玻璃块");
//        add(ModBlocks.RED_PURE_GLASS.get(), "红色纯净玻璃块");
//        add(ModBlocks.ORANGE_PURE_GLASS.get(), "橙色纯净玻璃块");
//        add(ModBlocks.YELLOW_PURE_GLASS.get(), "黄色纯净玻璃块");
//        add(ModBlocks.LIME_PURE_GLASS.get(), "黄绿色纯净玻璃块");
//        add(ModBlocks.GREEN_PURE_GLASS.get(), "绿色纯净玻璃块");
//        add(ModBlocks.CYAN_PURE_GLASS.get(), "青色纯净玻璃块");
//        add(ModBlocks.LIGHT_BLUE_PURE_GLASS.get(), "淡蓝色纯净玻璃块");
//        add(ModBlocks.BLUE_PURE_GLASS.get(), "蓝色纯净玻璃块");
//        add(ModBlocks.PURPLE_PURE_GLASS.get(), "紫色纯净玻璃块");
//        add(ModBlocks.MAGENTA_PURE_GLASS.get(), "品红纯净玻璃块");
//        add(ModBlocks.PINK_PURE_GLASS.get(), "品红纯净玻璃块");
//        add(ModBlocks.DISC_BLOCK.get(), "飞盘块");


        add(ModBlocks.CLOUD_BLOCK.get(), "云块");
        add(ModBlocks.EVAPORATIVE_CLOUD_BLOCK.get(), "蒸发云块");
        add(ModBlocks.RAIN_CLOUD_BLOCK.get(), "雨云块");
        add(ModBlocks.SNOW_CLOUD_BLOCK.get(), "雪云块");
        add(ModBlocks.THIN_ICE_BLOCK.get(), "薄冰块");
        add(ModBlocks.CRISPY_HONEY_BLOCK.get(), "松脆蜂蜜块");
//        add(ModBlocks.LIFE_CRYSTAL_BLOCK.get(), "生命水晶");
//        add(ModBlocks.CRIMSON_ALTAR.get(), "猩红祭坛");
//        add(ModBlocks.DEMON_ALTAR.get(), "恶魔祭坛");
//        add(ModBlocks.EXTRACTINATOR.get(), "提炼机");
//        add(ModBlocks.FLOATING_WHEAT_BALE.get(), "飘飘麦捆");
//        add(ModBlocks.BASE_CHEST_BLOCK.get(), "箱子");
//        add(ModBlocks.JUNGLE_HIVE_BLOCK.get(), "丛林蜂巢");
//        add(ModBlocks.THIN_HONEY_BLOCK.get(), "稀薄蜂蜜块");
//        add(ModBlocks.LOOSE_HONEY_BLOCK.get(), "松散蜂蜜块");
//        add(ModBlocks.SANCTIFICATION_REDSTONE_ORE.get(), "圣化红石矿石");
//        add(ModBlocks.CORRUPTION_REDSTONE_ORE.get(), "腐化红石矿石");
//        add(ModBlocks.FLESHIFICATION_REDSTONE_ORE.get(), "血化红石矿石");
//        add(ModBlocks.OCULAR_BLOCKS.get(), "血肉眼球块");
        add(ModBlocks.SWORD_IN_STONE.get(), "石中剑");
//        add(ModBlocks.WOOD_STONE_SLATTED_BLOCKS.get(), "木石板条块");
//        add(ModBlocks.DEEPSLATE_PRESSURE_PLATE.get(), "深板岩压力板");
//        add(ModBlocks.STONY_LOGS.get(), "石质原木");
//        add(ModBlocks.AMBER_BRANCHES.get(), "琥珀石枝杈");
//        add(ModBlocks.RUBY_BRANCHES.get(), "红玉石枝杈");
//        add(ModBlocks.TOPAZ_BRANCHES.get(), "黄玉石枝杈");
//        add(ModBlocks.EMERALD_BRANCHES.get(), "翡翠石枝杈");
//        add(ModBlocks.DIAMOND_BRANCHES.get(), "钻石枝杈");
//        add(ModBlocks.SAPPHIRE_BRANCHES.get(), "蓝玉石枝杈");
//        add(ModBlocks.TR_AMETHYST_BRANCHES.get(), "紫晶石枝杈");
//        add(ModBlocks.ASH_BRANCHES.get(), "白蜡枝杈");
        add(ModBlocks.CRACKED_BLUE_BRICK.get(), "碎裂蓝色地牢砖");
        add(ModBlocks.CRACKED_GREEN_BRICK.get(), "碎裂绿色地牢砖");
        add(ModBlocks.CRACKED_PINK_BRICK.get(), "碎裂粉色地牢砖");
//        add(ModBlocks.BLUE_BRICK.get(), "蓝色地牢砖");
//        add(ModBlocks.GREEN_BRICK.get(), "绿色地牢砖");
//        add(ModBlocks.PINK_BRICK.get(), "粉色地牢砖");
//        add(ModBlocks.AETHERIUM_BLOCK.get(), "以太块");
//        add(ModBlocks.AETHERIUM_BRICK.get(), "以太砖");
//        add(ModBlocks.DARK_AETHERIUM_BLOCK.get(),"黯淡以太块");
//        add(ModBlocks.ANCIENT_COPPER_BRICKS.get(),"古代铜砖");
//        add(ModBlocks.ANCIENT_TIN_BRICKS.get(),"古代锡砖");
//        add(ModBlocks.ANCIENT_IRON_BRICKS.get(),"古代铁砖");
//        add(ModBlocks.ANCIENT_LEAD_BRICKS.get(),"古代铅砖");
//        add(ModBlocks.ANCIENT_TUNGSTEN_BRICKS.get(),"古代钨砖");
//        add(ModBlocks.ANCIENT_PLATINUM_BRICKS.get(),"古代铂金砖");
/*
        add(Torches.RED_TORCH.item.get(), "红火把");
        add(Torches.ORANGE_TORCH.item.get(), "橙火把");
        add(Torches.YELLOW_TORCH.item.get(), "黄火把");
        add(Torches.GREEN_TORCH.item.get(), "绿火把");
        add(Torches.BLUE_TORCH.item.get(), "蓝火把");
        add(Torches.WHITE_TORCH.item.get(), "白火把");
        add(Torches.PURPLE_TORCH.item.get(), "紫火把");
        add(Torches.ICE_TORCH.item.get(), "冰雪火把");
        add(Torches.PINK_TORCH.item.get(), "粉火把");
        add(Torches.BONE_TORCH.item.get(), "骨头火把");
        add(Torches.ULTRABRIGHT_TORCH.item.get(), "超亮火把");
        add(Torches.DEMON_TORCH.item.get(), "恶魔火把");
        add(Torches.CURSED_TORCH.item.get(), "诅咒火把");
        add(Torches.ICHOR_TORCH.item.get(), "灵液火把");
        add(Torches.RAINBOW_TORCH.item.get(), "彩虹火把");
        add(Torches.DESERT_TORCH.item.get(), "沙漠火把");
        add(Torches.CORAL_TORCH.item.get(), "珊瑚火把");
        add(Torches.CORRUPT_TORCH.item.get(), "腐化火把");
        add(Torches.CRIMSON_TORCH.item.get(), "猩红火把");
        add(Torches.HALLOWED_TORCH.item.get(), "神圣火把");
        add(Torches.JUNGLE_TORCH.item.get(), "丛林火把");
        add(Torches.MUSHROOM_TORCH.item.get(), "蘑菇火把");
        add(Torches.AETHER_TORCH.item.get(), "以太火把");
        */
/*
        add(Pots.FOREST_POTS.get(), "森林罐子");
        add(Pots.TUNDRA_POTS.get(), "苔原罐子");
        add(Pots.SPIDER_NEST_POTS.get(), "蛛洞罐子");
        add(Pots.UNDERGROUND_DESERT_POTS.get(), "沙漠罐子");
        add(Pots.JUNGLE_POTS.get(), "丛林罐子");
        add(Pots.MARBLE_CAVE_POTS.get(), "尘封罐子");
        add(Pots.OCEAN_POTS.get(), "海洋罐子");
        add(Pots.PYRAMID_POTS.get(), "祭祀罐子");
        add(Pots.CORRUPTION_POTS.get(), "蠕虫罐子");
        add(Pots.TR_CRIMSON_POTS.get(), "血肉罐子");
        add(Pots.DUNGEON_POTS.get(), "地牢罐子");
        add(Pots.UNDERWORLD_POTS.get(), "炎烬罐子");
        add(Pots.LIHZAHRD_POTS.get(), "神庙罐子");
*/
        add(BoxBlocks.WOODEN_BOX.get(), "木匣");
        add(BoxBlocks.IRON_BOX.get(), "铁匣");
        add(BoxBlocks.GOLDEN_BOX.get(), "金匣");
        add(BoxBlocks.JUNGLE_BOX.get(), "丛林匣");
        add(BoxBlocks.SKY_BOX.get(), "天空匣");
        add(BoxBlocks.CORRUPT_BOX.get(), "腐化匣");
        add(BoxBlocks.TR_CRIMSON_BOX.get(), "猩红匣");
        add(BoxBlocks.SACRED_BOX.get(), "神圣匣");
        add(BoxBlocks.DUNGEON_BOX.get(), "地牢匣");
        add(BoxBlocks.FREEZE_BOX.get(), "冰冻匣");
        add(BoxBlocks.OASIS_BOX.get(), "绿洲匣");
        add(BoxBlocks.OBSIDIAN_BOX.get(), "黑曜石匣");
        add(BoxBlocks.OCEAN_BOX.get(), "海洋匣");
        add(BoxBlocks.PEARLWOOD_BOX.get(), "珍珠木匣");
        add(BoxBlocks.MITHRIL_BOX.get(), "秘银匣");
        add(BoxBlocks.TITANIUM_BOX.get(), "钛金匣");
        add(BoxBlocks.THORNS_BOX.get(), "荆棘匣");
        add(BoxBlocks.SPACE_BOX.get(), "太空匣");
        add(BoxBlocks.DEFACED_BOX.get(), "污损匣");
        add(BoxBlocks.BLOOD_BOX.get(), "血匣");
        add(BoxBlocks.PROVIDENTIAL_BOX.get(), "天赐匣");
        add(BoxBlocks.FENCING_BOX.get(), "围栏匣");
        add(BoxBlocks.CONIFEROUS_WOOD_BOX.get(), "针叶木匣");
        add(BoxBlocks.ILLUSION_BOX.get(), "幻象匣");
        add(BoxBlocks.HELL_STONE_BOX.get(), "狱石匣");
        add(BoxBlocks.BEACH_BOX.get(), "海滩匣");

        add(SPOOKY_LOG_BLOCKS.getPlanks().get(), "阴森木板");
        add(SPOOKY_LOG_BLOCKS.getPressurePlate().get(), "阴森木压力板");
        add(SPOOKY_LOG_BLOCKS.getFence().get(), "阴森木栅栏");
        add(SPOOKY_LOG_BLOCKS.getFenceGate().get(), "阴森木栅栏门");
        add(SPOOKY_LOG_BLOCKS.getButton().get(), "阴森按钮");
        add(SPOOKY_LOG_BLOCKS.getDoor().get(), "阴森木门");
        add(SPOOKY_LOG_BLOCKS.getTrapdoor().get(), "阴森木活板门");
        add(SPOOKY_LOG_BLOCKS.getSign().get(), "阴森告示牌");
        add(SPOOKY_LOG_BLOCKS.getStairs().get(), "阴森楼梯");
        add(SPOOKY_LOG_BLOCKS.getSlab().get(), "阴森台阶");

        add(ArrowItems.FLAMING_ARROW.get(), "烈焰箭");
        add(ArrowItems.UNHOLY_ARROW.get(), "邪箭");
        add(ArrowItems.JESTERS_ARROW.get(), "小丑之箭");
        add(ArrowItems.HELLFIRE_ARROW.get(), "狱炎箭");
        add(ArrowItems.FROSTBURN_ARROW.get(), "寒霜箭");
        add(ArrowItems.BONE_ARROW.get(), "骨箭");
        add(ArrowItems.SHIMMER_ARROW.get(), "微光箭");

        //endregion blocks

        //region items
        add(MaterialItems.RAW_TIN.get(), "粗锡");
        add(MaterialItems.TIN_INGOT.get(), "锡锭");
        add(MaterialItems.RAW_LEAD.get(), "粗铅");
        add(MaterialItems.LEAD_INGOT.get(), "铅锭");
        add(MaterialItems.RAW_SILVER.get(), "粗银");
        add(MaterialItems.SILVER_INGOT.get(), "银锭");
        add(MaterialItems.RAW_TUNGSTEN.get(), "粗钨");
        add(MaterialItems.TUNGSTEN_INGOT.get(), "钨锭");
        add(MaterialItems.RAW_PLATINUM.get(), "粗铂金");
        add(MaterialItems.PLATINUM_INGOT.get(), "铂金锭");
        add(MaterialItems.RAW_METEORITE.get(), "陨铁原矿");
        add(MaterialItems.METEORITE_INGOT.get(), "陨铁锭");
        add(MaterialItems.RAW_EBONY.get(), "粗魔矿");
        add(MaterialItems.EBONY_INGOT.get(), "魔矿锭");
        add(MaterialItems.RAW_TR_CRIMSON.get(), "粗猩红矿");
        add(MaterialItems.TR_CRIMSON_INGOT.get(), "猩红矿锭");
        add(MaterialItems.RAW_HELLSTONE.get(), "狱石矿");
        add(MaterialItems.HELLSTONE_INGOT.get(), "狱石矿锭");
        add(MaterialItems.RAW_COBALT.get(), "钴原矿");
        add(MaterialItems.COBALT_INGOT.get(), "钴锭");
        add(MaterialItems.RAW_PALLADIUM.get(), "钯金原矿");
        add(MaterialItems.PALLADIUM_INGOT.get(), "钯金锭");
        add(MaterialItems.RAW_MITHRIL.get(), "秘银原矿");
        add(MaterialItems.MITHRIL_INGOT.get(), "秘银锭");
        add(MaterialItems.RAW_ORICHALCUM.get(), "山铜原矿");
        add(MaterialItems.ORICHALCUM_INGOT.get(), "山铜锭");
        add(MaterialItems.RAW_ADAMANTITE.get(), "精金原矿");
        add(MaterialItems.ADAMANTITE_INGOT.get(), "精金锭");
        add(MaterialItems.RAW_TITANIUM.get(), "钛金原矿");
        add(MaterialItems.TITANIUM_INGOT.get(), "钛金锭");
        add(MaterialItems.RAW_CHLOROPHYTE.get(), "叶绿原矿");
        add(MaterialItems.CHLOROPHYTE_INGOT.get(), "叶绿锭");
        add(MaterialItems.RAW_LUMINITE.get(), "夜明原矿");
        add(MaterialItems.LUMINITE_INGOT.get(), "夜明锭");
        add(MaterialItems.HALLOWED_INGOT.get(), "神圣锭");
        add(MaterialItems.SHROOMITE_INGOT.get(), "蘑菇矿锭");
        add(MaterialItems.SPECTRE_INGOT.get(), "幽灵锭");
        add(MaterialItems.RUBY.get(), "红玉");
        add(MaterialItems.AMBER.get(), "琥珀");
        add(MaterialItems.TOPAZ.get(), "黄玉");
        add(MaterialItems.TR_EMERALD.get(), "翡翠");
        add(MaterialItems.SAPPHIRE.get(), "蓝玉");
        add(MaterialItems.TR_AMETHYST.get(), "异域紫晶石");
        add(MaterialItems.FALLING_STAR.get(), "坠落之星");
        add(MaterialItems.STAR_PETALS.get(), "星辰花瓣");
        add(MaterialItems.WEAVING_CLOUD_COTTON.get(), "织云棉");
        add(MaterialItems.CARRION.get(), "腐肉");
        add(MaterialItems.VERTEBRA.get(), "椎骨");
        add(MaterialItems.BLOOD_CLOT_POWDER.get(), "血凝粉末");
        add(MaterialItems.LENS.get(), "晶状体");
        add(MaterialItems.BLACK_LENS.get(), "黑晶状体");
        add(MaterialItems.CRYSTAL_SHARDS_ITEM.get(), "水晶碎块");
        add(MaterialItems.ANTLION_MANDIBLE.get(), "蚁狮下颚");
        add(MaterialItems.BLACK_INK.get(), "黑墨水");
        add(MaterialItems.SHARK_FIN.get(), "鲨鱼鳍");
        add(MaterialItems.SHADOW_SCALE.get(), "暗影鳞片");
        add(MaterialItems.TISSUE_SAMPLE.get(), "组织样本");
        add(MaterialItems.PURPLE_MUCUS.get(), "紫色黏液");
        add(MaterialItems.CURSED_FLAME.get(), "诅咒火");
        add(MaterialItems.ICHOR.get(), "灵液");
        add(MaterialItems.PIXIE_DUST.get(), "妖精尘");
        add(MaterialItems.PEARL.get(), "珍珠");
        add(MaterialItems.BLACK_PEARL.get(), "黑珍珠");
        add(MaterialItems.PINK_PEARL.get(), "粉珍珠");
        add(MaterialItems.HOOK.get(), "爪钩");
        add(MaterialItems.GEL.get(), "凝胶");
        add(MaterialItems.PINK_GEL.get(), "粉凝胶");
        add(MaterialItems.STURDY_FOSSIL.get(), "坚固化石");
        add(MaterialItems.EMERALD_COIN.get(), "绿宝石币");


        add(SwordItems.COPPER_SHORT_SWORD.get(), "铜短剑");
        add(SwordItems.TIN_SHORT_SWORD.get(), "锡短剑");
        add(SwordItems.COPPER_BOARD_SWORD.get(), "铜阔剑");
        add(SwordItems.TIN_BOARD_SWORD.get(), "锡阔剑");
        add(SwordItems.LEAD_SHORT_SWORD.get(), "铅短剑");
        add(SwordItems.LEAD_BOARD_SWORD.get(), "铅阔剑");
        add(SwordItems.SILVER_SHORT_SWORD.get(), "银短剑");
        add(SwordItems.SILVER_BOARD_SWORD.get(), "银阔剑");
        add(SwordItems.TUNGSTEN_SHORT_SWORD.get(), "钨短剑");
        add(SwordItems.TUNGSTEN_BOARD_SWORD.get(), "钨阔剑");
        add(SwordItems.PLATINUM_SHORT_SWORD.get(), "铂金短剑");
        add(SwordItems.PLATINUM_BOARD_SWORD.get(), "铂金阔剑");
        add(SwordItems.GOLDEN_SHORT_SWORD.get(), "金短剑");
        add(SwordItems.GOLDEN_BOARD_SWORD.get(), "金阔剑");
        add(SwordItems.CACTUS_SWORD.get(), "仙人掌剑");


        add(SwordItems.CROWBAR.get(), "撬棍");
        add(SwordItems.ZOMBIE_ARM.get(), "僵尸臂");
        add(SwordItems.MANDIBLE_BLADE.get(), "颌骨剑");
        add(SwordItems.STYLISH_SCISSORS.get(), "时尚剪刀");
        add(SwordItems.BONE_SWORD.get(), "骨剑");
        add(SwordItems.PURPLE_CLUBBERFISH.get(), "紫挥棒鱼");
        add(SwordItems.UMBRELLA.get(), "雨伞");
        add(SwordItems.CANDY_CANE_SWORD.get(), "糖棒剑");
        add(SwordItems.BREATHING_REED.get(), "芦苇呼吸管");
        add(SwordItems.TRAGIC_UMBRELLA.get(), "悲剧雨伞");
        add(SwordItems.FALCON_BLADE.get(), "猎鹰刃");
        add(SwordItems.BAT_BAT.get(), "蝙蝠棍");
        add(SwordItems.STARFURY.get(), "星怒");
        add(SwordItems.LIGHTS_BANE.get(), "魔光剑");
        add(SwordItems.BLOOD_BUTCHERER.get(), "血腥屠刀");
        add(SwordItems.KATANA.get(), "武士刀");
        add(SwordItems.TENTACLE_MACE.get(), "触手钉锤");
        add(SwordItems.ICE_BLADE.get(), "冰雪剑");
        add(SwordItems.EXOTIC_SCIMITAR.get(), "异域弯刀");
        add(SwordItems.FAKE_SWORD.get(), "假剑");
        add(SwordItems.VOLCANO.get(), "火山");


        add(SwordItems.DEVELOPER_SWORD.get(), "开发者剑");

        add(AxeItems.COPPER_AXE.get(), "铜斧");
        add(AxeItems.TIN_AXE.get(), "锡斧");
        add(AxeItems.LEAD_AXE.get(), "铅斧");
        add(AxeItems.SILVER_AXE.get(), "银斧");
        add(AxeItems.TUNGSTEN_AXE.get(), "钨斧");
        add(AxeItems.GOLDEN_AXE.get(), "金斧");
        add(AxeItems.PLATINUM_AXE.get(), "铂金斧");
        add(AxeItems.EBONY_AXE.get(), "暗夜战斧");
        add(AxeItems.TR_CRIMSON_AXE.get(), "嗜血狂斧");

/*
        add(Pickaxes.COPPER_PICKAXE.get(), "铜镐");
        add(Pickaxes.CACTUS_PICKAXE.get(), "仙人掌镐");
        add(Pickaxes.CANDY_CANE_PICKAXE.get(), "糖棒镐");
        add(Pickaxes.FOSSIL_PICKAXE.get(), "化石镐");
        add(Pickaxes.TIN_PICKAXE.get(), "锡镐");
        add(Pickaxes.LEAD_PICKAXE.get(), "铅镐");
        add(Pickaxes.SILVER_PICKAXE.get(), "银镐");
        add(Pickaxes.TUNGSTEN_PICKAXE.get(), "钨镐");
        add(Pickaxes.GOLDEN_PICKAXE.get(), "金镐");
        add(Pickaxes.PLATINUM_PICKAXE.get(), "铂金镐");
        */
        /* Hammers */
        add(HammerItems.WOODEN_HAMMER.get(), "木锤");
        add(HammerItems.COPPER_HAMMER.get(), "铜锤");
        add(HammerItems.TIN_HAMMER.get(), "锡锤");
        add(HammerItems.LEAD_HAMMER.get(), "铅锤");
        add(HammerItems.SILVER_HAMMER.get(), "银锤");
        add(HammerItems.TUNGSTEN_HAMMER.get(), "钨锤");
        add(HammerItems.GOLDEN_HAMMER.get(), "金锤");
        add(HammerItems.PLATINUM_HAMMER.get(), "铂金锤");
        add(HammerItems.EBONY_HAMMER.get(), "魔锤");
        add(HammerItems.TR_CRIMSON_HAMMER.get(), "血肉锤");
        /* HammerAxes */


        // 杂项
//        add(ModItems.ICE_MIRROR.get(), "冰雪镜");
//        add(ModItems.CLAM.get(), "牡蛎");
//
//        add(ModItems.MAGIC_MIRROR.get(), "魔镜");
        add(ModItems.COPPER_COIN.get(), "铜币");
        add(ModItems.SILVER_COIN.get(), "银币");
        add(ModItems.GOLDEN_COIN.get(), "金币");
        add(ModItems.PLATINUM_COIN.get(), "铂金币");
//        add(ModItems.SHURIKEN.get(), "手里剑");
//        add(ModItems.THROWING_KNIVES.get(), "投刀");
//        add(ModItems.HONEY_BUCKET.get(), "蜂蜜桶");
//        add(ModItems.BOTTOMLESS_SHIMMER_BUCKET.get(), "无底微光桶");
//        add(ModItems.BOTTOMLESS_WATER_BUCKET.get(), "无底水桶");
//        add(ModItems.BOTTOMLESS_LAVA_BUCKET.get(), "无底岩浆桶");
//        add(ModItems.BOTTOMLESS_HONEY_BUCKET.get(), "无底蜂蜜桶");
//        add(ModItems.SOUL_CAKE.get(), "灵魂蛋糕");
//        add(ModItems.STAR.get(), "魔力星");
//        add(ModItems.SUGAR_PLUM.get(), "蜜糖李");
//        add(ModItems.HEART.get(), "心");
//        add(ModItems.CANDY_CANE.get(), "拐杖糖");
//        add(ModItems.CANDY_APPLE.get(), "糖葫芦");
//        add(ModItems.VITAL_CRYSTAL.get(), "活力水晶");
//        add(ModItems.GALAXY_PEARL.get(), "银河珍珠");
//        add(ModItems.ARCANE_CRYSTAL.get(), "奥术水晶");
//        add(ModItems.AEGIS_APPLE.get(), "神盾果");
//        add(ModItems.AMBROSIA.get(), "仙馔密酒");
//        add(ModItems.GUMMY_WORM.get(), "黏性蠕虫");
//        add(ModItems.ModBlocks.CHRISTMAS_GIFT.get(), "圣诞礼物");
//        add(ModItems.RED_ENVELOPE.get(), "红包");
//        add(ModItems.CAN_OF_WORMS.get(), "蠕虫罐头");
//        add(ModItems.HERB_BAG.get(), "草药袋");
//        add(ModItems.WHOOPIE_CUSHION.get(), "整蛊坐垫");
//        add(ModItems.RED_WRENCH.get(), "红扳手");
//        add(ModItems.BLUE_WRENCH.get(), "蓝扳手");
//        add(ModItems.GREEN_WRENCH.get(), "绿扳手");
//        add(ModItems.YELLOW_WRENCH.get(), "黄扳手");
//        add(ModItems.GOLDEN_KEY.get(), "金钥匙");
//        add(ModItems.SHADOW_KEY.get(), "暗影钥匙");
//        add(ModItems.SUSPICIOUS_LOOKING_EYE.get(), "可疑眼球");
//        add(ModItems.SLIME_CROWN.get(), "史莱姆皇冠");
//        add(ModItems.DEMON_HEART.get(), "恶魔之心");
//        add(ModItems.MAGIC_CONCH.get(), "魔法海螺");
//        add(ModItems.DEMON_CONCH.get(), "恶魔海螺");
//        add(ModItems.SKY_MILL.get(), "天磨");
//        add(ModItems.WORKSHOP.get(), "工匠作坊");
//        add(ModItems.ALCHEMY_TABLE_BLOCK.get(), "炼药桌");
//        add(ModItems.STONE_PRESSURE_PLATE.get(), "石头压力板");

        // 杂项
        add(ModItems.BOMB.get(), "炸弹");
        add(ModItems.BOUNCY_BOMB.get(), "弹力炸弹");
        add(ModItems.STICKY_BOMB.get(), "粘性炸弹");
        add(ModItems.SCARAB_BOMB.get(), "甲虫炸弹");
        add(ModItems.BOMB_FISH.get(), "炸弹鱼");
        add(ModItems.MANA_STAR.get(), "魔力水晶");
        add(ModItems.LIFE_CRYSTAL.get(), "生命水晶");
        add(ModItems.LIFE_FRUIT.get(), "生命果");
        // 种子
        add(ModItems.STELLAR_BLOSSOM_SEED.get(), "星辰花种子");
        add(ModItems.CLOUDWEAVER_SEED.get(), "云织草种子");
        add(ModItems.FLOATING_WHEAT_SEED.get(), "飘飘麦种子");


        /*
        // 功能性方块
        add(ECHO_BLOCK.get(), "回声块");
        add(BoulderBlock.Variant.NORMAL.get(), "巨石");
        add(INSTANTANEOUS_EXPLOSION_TNT.get(), "瞬爆TNT");
        add(SWITCH.get(), "开关");
        add(SIGNAL_ADAPTER.get(), "信号适配器");
        add(WIRE_CUTTER.get(), "钢丝钳");
        add(DART_TRAP.get(), "毒镖机关");
        add(TIMERS_BLOCK_1_1.get(), "1秒计时器");
        add(TIMERS_BLOCK_3_1.get(), "3秒计时器");
        add(TIMERS_BLOCK_5_1.get(), "5秒计时器");
        add(TIMERS_BLOCK_1_2.get(), "1/2秒计时器");
        add(TIMERS_BLOCK_1_4.get(), "1/4秒计时器");
*/
        /*
        // 鱼竿
        add(FishingPoles.HOTLINE_FISHING_HOOK.get(), "熔线钓竿");
        add(FishingPoles.WOOD_FISHING_POLE.get(), "木钓竿");
        add(FishingPoles.FISHER_OF_SOULS.get(), "灵魂钓手");
        add(FishingPoles.REINFORCED_FISHING_POLE.get(), "强化钓竿");
        add(FishingPoles.FLESHCATCHER.get(), "捕肉手");
        add(FishingPoles.SCARAB_FISHING_ROD.get(), "甲虫钓竿");
        add(FishingPoles.CHUM_CASTER.get(), "鱼饵投掷者");
        add(FishingPoles.FIBERGLASS_FISHING_POLE.get(), "玻璃钢钓竿");
        add(FishingPoles.MECHANICS_ROD.get(), "机械师钓竿");
        add(FishingPoles.SITTING_DUCKS_FISHING_POLE.get(), "冤大头钓竿");
        add(FishingPoles.GOLDEN_FISHING_ROD.get(), "金钓竿");
        */
         /*
        // 鱼饵
        add(Baits.APPRENTICE_BAIT.get(), "学徒诱饵");
        add(Baits.JOURNEYMAN_BAIT.get(), "熟手诱饵");
        add(Baits.MASTER_BAIT.get(), "大师诱饵");
        add(Baits.BLACK_DRAGONFLY.get(), "黑蜻蜓");
        add(Baits.BLACK_SCORPION.get(), "黑蝎子");
        add(Baits.BLUE_JELLYFISH.get(), "蓝水母");
        add(Baits.BLUE_DRAGONFLY.get(), "蓝蜻蜓");
        add(Baits.BUGGY.get(), "蚜虫");
        add(Baits.ENCHANTED_NIGHTCRAWLER.get(), "附魔夜行者");
        add(Baits.FIREFLY.get(), "萤火虫");
        add(Baits.GLOWING_SNAIL.get(), "发光蜗牛");
        add(Baits.GOLD_BUTTERFLY.get(), "金蝴蝶");
        add(Baits.GOLD_DRAGONFLY.get(), "金蜻蜓");
        add(Baits.GOLD_GRASSHOPPER.get(), "金蟋蟀");
        add(Baits.GOLD_LADYBUG.get(), "金瓢虫");
        add(Baits.GOLD_WATER_STRIDER.get(), "金水黾");
        add(Baits.GOLD_WORM.get(), "金蠕虫");
        add(Baits.GRASSHOPPER.get(), "蟋蟀");
        add(Baits.GREEN_DRAGONFLY.get(), "绿蜻蜓");
        add(Baits.GREEN_JELLYFISH.get(), "绿水母");
        add(Baits.GRUBBY.get(), "蛆虫");
        add(Baits.HELL_BUTTERFLY.get(), "地狱蝴蝶");
        add(Baits.JULIA_BUTTERFLY.get(), "珠袖蝶");
        add(Baits.LADYBUG.get(), "瓢虫");
        add(Baits.LAVAFLY.get(), "熔岩萤火虫");
        add(Baits.LIGHTNING_BUG.get(), "荧光虫");
        add(Baits.MAGGOT.get(), "蝇蛆");
        add(Baits.MAGMA_SNAIL.get(), "岩浆蜗牛");
        add(Baits.MONARCH_BUTTERFLY.get(), "帝王蝶");
        add(Baits.ORANGE_DRAGONFLY.get(), "橙蜻蜓");
        add(Baits.PINK_JELLYFISH.get(), "粉水母");
        add(Baits.PURPLE_EMPEROR_BUTTERFLY.get(), "紫蛱蝶");
        add(Baits.RED_ADMIRAL_BUTTERFLY.get(), "红蛱蝶");
        add(Baits.RED_DRAGONFLY.get(), "红蜻蜓");
        add(Baits.SCORPION.get(), "蝎子");
        add(Baits.SLUGGY.get(), "鼻涕虫");
        add(Baits.SNAIL.get(), "蜗牛");
        add(Baits.STINKBUG.get(), "臭虫");
        add(Baits.SULPHUR_BUTTERFLY.get(), "黄粉蝶");
        add(Baits.TREE_NYMPH_BUTTERFLY.get(), "帛斑蝶");
        add(Baits.TRUFFLE_WORM.get(), "松露虫");
        add(Baits.ULYSSES_BUTTERFLY.get(), "翠凤蝶");
        add(Baits.WATER_STRIDER.get(), "水黾");
        add(Baits.WORM.get(), "蠕虫");
        add(Baits.YELLOW_DRAGONFLY.get(), "黄蜻蜓");
        add(Baits.ZEBRA_SWALLOWTAIL_BUTTERFLY.get(), "带凤蝶");

          */
        // 钩爪
        /*
        add(Hooks.GRAPPLING_HOOK.get(), "抓钩");
        add(Hooks.RUBY_HOOK.get(), "红玉钩");
        add(Hooks.AMBER_HOOK.get(), "琥珀钩");
        add(Hooks.TOPAZ_HOOK.get(), "黄玉钩");
        add(Hooks.EMERALD_HOOK.get(), "翡翠钩");
        add(Hooks.SAPPHIRE_HOOK.get(), "蓝玉钩");
        add(Hooks.DIAMOND_HOOK.get(), "钻石钩");
        add(Hooks.AMETHYST_HOOK.get(), "紫晶钩");
        add(Hooks.ANTI_GRAVITY_HOOK.get(), "反重力钩");
        add(Hooks.WEB_SLINGER.get(), "蛛丝吊索");
        add(Hooks.SKELETRON_HAND.get(), "骷髅王之手");
        add(Hooks.SLIME_HOOK.get(), "史莱姆钩");
        add(Hooks.FISH_HOOK.get(), "鱼钩");
        add(Hooks.IVY_WHIP.get(), "常春藤钩");
        add(Hooks.BAT_HOOK.get(), "蝙蝠钩");
        add(Hooks.CANDY_CANE_HOOK.get(), "糖棒钩");
        add(Hooks.CHRISTMAS_HOOK.get(), "圣诞挂钩");
        add(Hooks.DUAL_HOOK.get(), "双钩");
        add(Hooks.HOOK_OF_DISSONANCE.get(), "失谐钩");
        add(Hooks.THORN_HOOK.get(), "棘刺钩");
        add(Hooks.ILLUMINANT_HOOK.get(), "荧光钩");
        add(Hooks.WORM_HOOK.get(), "蠕虫钩");
        add(Hooks.LUNAR_HOOK.get(), "月钩");
        add(Hooks.SPOOKY_HOOK.get(), "阴森钩");
        add(Hooks.TENDON_HOOK.get(), "肌腱钩");

         */
        // 锁链
        /*
        add(RUBY_CHAIN.get(), "红玉锁链");
        add(AMBER_CHAIN.get(), "琥珀锁链");
        add(TOPAZ_CHAIN.get(), "黄玉锁链");
        add(EMERALD_CHAIN.get(), "翡翠锁链");
        add(SAPPHIRE_CHAIN.get(), "蓝玉锁链");
        add(DIAMOND_CHAIN.get(), "钻石锁链");
        add(AMETHYST_CHAIN.get(), "紫晶锁链");
        add(SILK_CHAIN.get(), "蛛丝绳");
        add(BONE_CHAIN.get(), "骨头锁链");

         */
        // 植物
        add(ModBlocks.WATERLEAF.get(), "幌菊");
        add(ModBlocks.FLAMEFLOWERS.get(), "火焰花");
        add(ModBlocks.MOONSHINE_GRASS.get(), "月光草");
        add(ModBlocks.SHINE_ROOT.get(), "闪耀根");
        add(ModBlocks.SHIVERINGTHORNS.get(), "寒颤棘");
        add(ModBlocks.SUNFLOWERS.get(), "太阳花");
        add(ModBlocks.DEATHWEED.get(), "死亡草");
        add(MaterialItems.WATERLEAF.get(), "幌菊");
        add(MaterialItems.FLAMEFLOWERS.get(), "火焰花");
        add(MaterialItems.MOONSHINE_GRASS.get(), "月光草");
        add(MaterialItems.SHINE_ROOT.get(), "闪耀根");
        add(MaterialItems.SHIVERINGTHORNS.get(), "寒颤棘");
        add(MaterialItems.SUNFLOWERS.get(), "太阳花");
        add(MaterialItems.DEATHWEED.get(), "死亡草");

        add(ModBlocks.STELLAR_BLOSSOM.get(), "星辰花");
        add(ModBlocks.CLOUDWEAVER.get(), "云织草");
        add(ModBlocks.FLOATING_WHEAT.get(), "飘飘麦");
        add(ModItems.WATERLEAF_SEED.get(), "幌菊种子");
        add(ModItems.FLAMEFLOWERS_SEED.get(), "火焰花种子");
        add(ModItems.MOONSHINE_GRASS_SEED.get(), "月光草种子");
        add(ModItems.SHINE_ROOT_SEED.get(), "闪耀根种子");
        add(ModItems.SHIVERINGTHORNS_SEED.get(), "寒颤棘种子");
        add(ModItems.SUNFLOWERS_SEED.get(), "太阳花种子");
        add(ModItems.DEATHWEED_SEED.get(), "死亡草种子");


/*
        add(CRIMSON_THORN.get(), "猩红荆棘");
        add(CORRUPTION_THORN.get(), "腐化荆棘");
        add(JUNGLE_THORN.get(), "丛林荆棘");
        add(PLANTERA_THORN.get(), "世纪之花荆棘");

 */
        // 树苗
        add(ModBlocks.SHADOW_SAPLING.get(), "暗影树苗");
        add(ModBlocks.EBONY_SAPLING.get(), "乌木树苗");
        add(ModBlocks.PALM_SAPLING.get(), "棕榈树苗");
        add(ModBlocks.PEARL_SAPLING.get(), "珍珠树苗");
        add(ModBlocks.RUBY_SAPLING.get(), "红玉树苗");
        add(ModBlocks.AMBER_SAPLING.get(), "琥珀树苗");
        add(ModBlocks.TOPAZ_SAPLING.get(), "黄玉树苗");
        add(ModBlocks.EMERALD_SAPLING.get(), "翡翠树苗");
        add(ModBlocks.DIAMOND_SAPLING.get(), "钻石树苗");
        add(ModBlocks.SAPPHIRE_SAPLING.get(), "蓝玉树苗");
        add(ModBlocks.TR_AMETHYST_SAPLING.get(), "紫晶树苗");
        add(ModBlocks.ASH_SAPLING.get(), "白蜡树苗");
        add(ModBlocks.LIVING_SAPLING.get(), "生命树树苗");


        add(ModBlocks.TR_CRIMSON_MUSHROOM.get(), "毒蘑菇");
        add(ModBlocks.EBONY_MUSHROOM.get(), "魔菇");
        add(ModBlocks.GLOWING_MUSHROOM.get(), "发光蘑菇");
        add(ModBlocks.LIFE_MUSHROOM.get(), "生命蘑菇");
        add(ModBlocks.JUNGLE_SPORE.get(), "丛林孢子");
//        add(ModItems.JUNGLE_SPORE.get(), "丛林孢子");
//        add(JUNGLE_ROSE.get(), "丛林玫瑰");
        add(CORRUPT_GRASS.get(), "腐化草");
        add(TR_CRIMSON_GRASS.get(), "猩红草");
        add(HALLOW_GRASS.get(), "神圣草");
        add(ModBlocks.NATURES_GIFT.get(), "大自然的恩赐");

        // 法杖
        /*
        add(ManaWeapons.RUBY_STAFF.get(), "红玉法杖");
        add(ManaWeapons.AMBER_STAFF.get(), "琥珀法杖");
        add(ManaWeapons.TOPAZ_STAFF.get(), "黄玉法杖");
        add(ManaWeapons.EMERALD_STAFF.get(), "翡翠法杖");
        add(ManaWeapons.SAPPHIRE_STAFF.get(), "蓝玉法杖");
        add(ManaWeapons.DIAMOND_STAFF.get(), "钻石法杖");
        add(ManaWeapons.AMETHYST_STAFF.get(), "紫晶法杖");
        add(ManaWeapons.AQUA_SCEPTER.get(), "海蓝权杖");
        add(ManaWeapons.WOND_OF_SPARKING.get(), "火花魔棒");
        add(ManaWeapons.WOND_OF_FROSTING.get(), "霜冻魔棒");
        add(ManaWeapons.THUNDER_ZAPPER.get(), "雷霆法杖");
        add(ManaWeapons.VILETHORN.get(), "魔刺");
        add(ManaWeapons.WEATHER_PAIN.get(), "天候棒");
        add(ManaWeapons.MAGIC_MISSILE.get(), "魔法导弹");
        add(ManaWeapons.FLOWER_OF_FIRE.get(), "火之花");
        add(ManaWeapons.FLAMELASH.get(), "烈焰火鞭");
        add(ManaWeapons.SKY_FRACTURE.get(), "裂天剑");
        add(ManaWeapons.CRYSTAL_SERPENT.get(), "水晶蛇");
        add(ManaWeapons.FROST_STAFF.get(), "寒霜法杖");
        add(ManaWeapons.FLOWER_OF_FROST.get(), "寒霜之花");
        add(ManaWeapons.CRYSTAL_VILE_SHARD.get(), "魔晶碎块");
        add(ManaWeapons.LIFE_DRAIN.get(), "夺命杖");
        add(ManaWeapons.METEOR_STAFF.get(), "流星法杖");
        add(ManaWeapons.POISON_STAFF.get(), "毒液法杖");
        add(ManaWeapons.RAINBOW_ROD.get(), "彩虹法杖");
        add(ManaWeapons.UNHOLY_TRIDENT.get(), "邪恶三叉戟");
        add(ManaWeapons.TOME_OF_INFINITE_WISDOM.get(), "无限智慧巨著");
        add(ManaWeapons.NETTLE_BURST.get(), "爆裂藤曼");
        add(ManaWeapons.SHADOWBEAM_STAFF.get(), "暗影束法杖");
        add(ManaWeapons.INFERNO_FORK.get(), "狱火叉");
        add(ManaWeapons.VENOM_STAFF.get(), "毒液法杖");
        add(ManaWeapons.BAT_SCEPTER.get(), "蝙蝠权杖");
        add(ManaWeapons.BLIZZARD_STAFF.get(), "暴雪法杖");
        add(ManaWeapons.SPECTRE_STAFF.get(), "幽灵法杖");
        add(ManaWeapons.RESONANCE_SCEPTER.get(), "共鸣权杖");
        add(ManaWeapons.STAFF_OF_EARTH.get(), "大地法杖");
        add(ManaWeapons.RAZORPINE.get(), "剃刀松");
        add(ManaWeapons.BETSYS_WRATH.get(), "双足翼龙怒气");


         */
        // 射手武器
        /*
        add(GunItems.HANDGUN.get(), "手枪");
        add(GunItems.BLOWGUN.get(), "吹箭筒");
        add(GunItems.BLOWPIPE.get(), "吹管");
        add(GunItems.BOOMSTICK.get(), "三发猎枪");
        add(GunItems.FLAREGUN.get(), "信号枪");
        add(GunItems.FLINTLOCKPISTOL.get(), "燧发枪");
        add(GunItems.MINISHARK.get(), "迷你鲨");
        add(GunItems.ONYXBLASTER.get(), "玛瑙爆破枪");
        add(GunItems.PHOENIXBLASTER.get(), "凤凰爆破枪");
        add(GunItems.REVOLVER.get(), "左轮手枪");
        add(GunItems.THEUNDERTAKER.get(), "夺命枪");
        add(GunItems.SLIMEGUN.get(), "史莱姆枪");
        add(GunItems.SNIPERRIFLE.get(), "狙击步枪");
        add(GunItems.SNOWBALLCANNON.get(), "雪球炮");
        add(GunItems.STARCANNON.get(), "星星炮");
        add(GunItems.TACTICALSHOTGUN.get(), "战术霰弹枪");
        add(GunItems.UZI.get(), "乌兹冲锋枪");
        add(GunItems.SHOTGUN.get(), "霰弹枪");
        add(GunItems.MUSKET.get(), "火枪");
        add(GunItems.DEBUGGUN.get(), "调试枪");
        */

        // 弓
        add(BowItems.WOODEN_SHORT_BOW.get(), "木短弓");
        add(BowItems.COPPER_SHORT_BOW.get(), "铜短弓");
        add(BowItems.TIN_SHORT_BOW.get(), "锡短弓");
        add(BowItems.IRON_SHORT_BOW.get(), "铁短弓");
        add(BowItems.LEAD_SHORT_BOW.get(), "铅短弓");
        add(BowItems.SILVER_SHORT_BOW.get(), "银短弓");
        add(BowItems.TUNGSTEN_SHORT_BOW.get(), "钨短弓");
        add(BowItems.GOLDEN_SHORT_BOW.get(), "金短弓");
        add(BowItems.PLATINUM_SHORT_BOW.get(), "铂金短弓");


        add(BowItems.COPPER_BOW.get(), "铜弓");
        add(BowItems.TIN_BOW.get(), "锡弓");
        add(BowItems.IRON_BOW.get(), "铁弓");
        add(BowItems.LEAD_BOW.get(), "铅弓");
        add(BowItems.SILVER_BOW.get(), "银弓");
        add(BowItems.TUNGSTEN_BOW.get(), "钨弓");
        add(BowItems.GOLDEN_BOW.get(), "金弓");
        add(BowItems.PLATINUM_BOW.get(), "铂金弓");
        add(BowItems.DEVELOPER_BOW.get(), "开发者弓");

        // 子弹
        /*
        add(AmmoItems.MUSKET_BULLET.get(), "火枪子弹");
        add(AmmoItems.METEOR_BULLET.get(), "流星弹");
        add(AmmoItems.SILVER_BULLET.get(), "银子弹");
        add(AmmoItems.CRYSTAL_BILLET.get(), "水晶子弹");
        add(AmmoItems.CURSED_BULLET.get(), "诅咒弹");
        add(AmmoItems.CHLOROPHYTE_BULLET.get(), "叶绿弹");
        add(AmmoItems.HIGH_VELOCITY_BULLET.get(), "高速子弹");
        add(AmmoItems.ICHOR_BULLET.get(), "灵液弹");
        add(AmmoItems.VENOM_BULLET.get(), "毒液弹");
        add(AmmoItems.PARTY_BULLET.get(), "派对弹");
        add(AmmoItems.NANO_BULLET.get(), "纳米弹");
        add(AmmoItems.EXPLODING_BULLET.get(), "爆破弹");
        add(AmmoItems.GOLDEN_BULLET.get(), "金子弹");
        add(AmmoItems.ENDLESS_MUSKET_POUCH.get(), "无限子弹袋");
        add(AmmoItems.LUMINITE_BULLET.get(), "夜明弹");
        add(AmmoItems.TUNGSTEN_BULLET.get(), "钨子弹");

         */
        // 刷怪蛋
        /*
        add(SpawnEggs.BLUE_SLIME_SPAWN_EGG.get(), "蓝色史莱姆刷怪蛋");
        add(SpawnEggs.RED_SLIME_SPAWN_EGG.get(), "红色史莱姆刷怪蛋");
        add(SpawnEggs.YELLOW_SLIME_SPAWN_EGG.get(), "黄色史莱姆刷怪蛋");
        add(SpawnEggs.HONEY_SLIME_SPAWN_EGG.get(), "蜂蜜史莱姆刷怪蛋");
        add(SpawnEggs.PURPLE_SLIME_SPAWN_EGG.get(), "紫色史莱姆刷怪蛋");
        add(SpawnEggs.DESERT_SLIME_SPAWN_EGG.get(), "沙漠史莱姆刷怪蛋");
        add(SpawnEggs.JUNGLE_SLIME_SPAWN_EGG.get(), "丛林史莱姆刷怪蛋");
        add(SpawnEggs.PINK_SLIME_SPAWN_EGG.get(), "粉色史莱姆刷怪蛋");
        add(SpawnEggs.ICE_SLIME_SPAWN_EGG.get(), "冰冻史莱姆刷怪蛋");
        add(SpawnEggs.GREEN_SLIME_SPAWN_EGG.get(), "绿色史莱姆刷怪蛋");
        add(SpawnEggs.BLACK_SLIME_SPAWN_EGG.get(), "史莱姆之母刷怪蛋");
        add(SpawnEggs.CRIMSON_SLIME_SPAWN_EGG.get(), "猩红史莱姆刷怪蛋");
        add(SpawnEggs.TROPIC_SLIME_SPAWN_EGG.get(), "热带史莱姆刷怪蛋");
        add(SpawnEggs.LUMINOUS_SLIME_SPAWN_EGG.get(), "夜明史莱姆刷怪蛋");
        add(SpawnEggs.LAVA_SLIME_SPAWN_EGG.get(), "岩浆史莱姆刷怪蛋");
        add(SpawnEggs.DEMON_EYE_SPAWN_EGG.get(), "恶魔眼刷怪蛋");
        add(SpawnEggs.BLOOD_CRAWLER_SPAWN_EGG.get(), "血爬虫刷怪蛋");
        add(SpawnEggs.BLOODY_SPORE_SPAWN_EGG.get(), "血腥芽孢刷怪蛋");
        add(SpawnEggs.CTHULHU_EYE_SPAWN_EGG.get(), "克苏鲁之眼刷怪蛋");
        add(SpawnEggs.KING_SLIME_SPAWN_EGG.get(), "史莱姆王刷怪蛋");

         */
        // 光剑
        /*
        add(SwordItems.RED_LIGHT_SABER.get(), "陨石红光剑");
        add(SwordItems.ORANGE_LIGHT_SABER.get(), "陨石橙光剑");
        add(SwordItems.YELLOW_LIGHT_SABER.get(), "陨石黄光剑");
        add(SwordItems.GREEN_LIGHT_SABER.get(), "陨石绿光剑");
        add(SwordItems.BLUE_LIGHT_SABER.get(), "陨石蓝光剑");
        add(SwordItems.PURPLE_LIGHT_SABER.get(), "陨石紫光剑");
        add(SwordItems.WHITE_LIGHT_SABER.get(), "陨石白光剑");

         */
        //剑气
        add(SwordItems.ENCHANTED_SWORD.get(), "附魔剑");
        //快攻
        add(SwordItems.TERRAGRIM.get(), "泰拉魔刃");

        // 盔甲
        add(ArmorItems.CACTUS_CHESTPLATE.get(), "仙人掌胸甲");
        add(ArmorItems.CACTUS_HELMET.get(), "仙人掌头盔");
        add(ArmorItems.CACTUS_LEGGINGS.get(), "仙人掌护腿");
        add(ArmorItems.CACTUS_BOOTS.get(), "仙人掌靴子");
        add(ArmorItems.PLANK_CHESTPLATE.get(), "木制胸甲");
        add(ArmorItems.PLANK_HELMET.get(), "木制头盔");
        add(ArmorItems.PLANK_LEGGINGS.get(), "木制护腿");
        add(ArmorItems.PLANK_BOOTS.get(), "木制靴子");
//        add(ModArmors.EBONY_CHESTPLATE.get(), "乌木胸甲");
//        add(ModArmors.EBONY_HELMET.get(), "乌木头盔");
//        add(ModArmors.EBONY_LEGGINGS.get(), "乌木护腿");
//        add(ModArmors.EBONY_BOOTS.get(), "乌木靴子");
//        add(ModArmors.SHADOW_CHESTPLATE.get(), "暗影木胸甲");
//        add(ModArmors.SHADOW_HELMET.get(), "暗影木头盔");
//        add(ModArmors.SHADOW_LEGGINGS.get(), "暗影木护腿");
//        add(ModArmors.SHADOW_BOOTS.get(), "暗影木靴子");
//        add(ModArmors.PEARL_CHESTPLATE.get(), "珍珠木胸甲");
//        add(ModArmors.PEARL_HELMET.get(), "珍珠木头盔");
//        add(ModArmors.PEARL_LEGGINGS.get(), "珍珠木护腿");
//        add(ModArmors.PEARL_BOOTS.get(), "珍珠木靴子");
//        add(ModArmors.RAIN_CAP.get(), "雨帽");
//        add(ModArmors.RAINCOAT.get(), "雨衣");
        add(ArmorItems.SNOW_CAPS.get(), "防雪帽");
        add(ArmorItems.SNOW_SUITS.get(), "防雪衣");
        add(ArmorItems.INSULATED_PANTS.get(), "保温裤");
        add(ArmorItems.INSULATED_SHOES.get(), "保温鞋");
        add(ArmorItems.PINK_SNOW_CAPS.get(), "粉色防雪帽");
        add(ArmorItems.PINK_SNOW_SUITS.get(), "粉色防雪衣");
        add(ArmorItems.PINK_INSULATED_PANTS.get(), "粉色保温裤");
        add(ArmorItems.PINK_INSULATED_SHOES.get(), "粉色保温鞋");
        add(ArmorItems.COPPER_HELMET.get(), "铜头盔");
        add(ArmorItems.COPPER_CHESTPLATE.get(), "铜胸甲");
        add(ArmorItems.COPPER_LEGGINGS.get(), "铜护腿");
        add(ArmorItems.COPPER_BOOTS.get(), "铜靴子");
        add(ArmorItems.TIN_HELMET.get(), "锡头盔");
        add(ArmorItems.TIN_CHESTPLATE.get(), "锡胸甲");
        add(ArmorItems.TIN_LEGGINGS.get(), "锡护腿");
        add(ArmorItems.TIN_BOOTS.get(), "锡靴子");
        add(ArmorItems.LEAD_HELMET.get(), "铅头盔");
        add(ArmorItems.LEAD_CHESTPLATE.get(), "铅胸甲");
        add(ArmorItems.LEAD_LEGGINGS.get(), "铅护腿");
        add(ArmorItems.LEAD_BOOTS.get(), "铅靴子");
        add(ArmorItems.SILVER_HELMET.get(), "银头盔");
        add(ArmorItems.SILVER_CHESTPLATE.get(), "银胸甲");
        add(ArmorItems.SILVER_LEGGINGS.get(), "银护腿");
        add(ArmorItems.SILVER_BOOTS.get(), "银靴子");
        add(ArmorItems.TUNGSTEN_HELMET.get(), "钨头盔");
        add(ArmorItems.TUNGSTEN_CHESTPLATE.get(), "钨胸甲");
        add(ArmorItems.TUNGSTEN_LEGGINGS.get(), "钨护腿");
        add(ArmorItems.TUNGSTEN_BOOTS.get(), "钨靴子");
        add(ArmorItems.GOLDEN_HELMET.get(), "金头盔");
        add(ArmorItems.GOLDEN_CHESTPLATE.get(), "金胸甲");
        add(ArmorItems.GOLDEN_LEGGINGS.get(), "金护腿");
        add(ArmorItems.GOLDEN_BOOTS.get(), "金靴子");
        add(ArmorItems.PLATINUM_HELMET.get(), "铂金头盔");
        add(ArmorItems.PLATINUM_CHESTPLATE.get(), "铂金胸甲");
        add(ArmorItems.PLATINUM_LEGGINGS.get(), "铂金护腿");
        add(ArmorItems.PLATINUM_BOOTS.get(), "铂金靴子");
        add(ArmorItems.FOSSIL_HELMET.get(), "化石头盔");
        add(ArmorItems.FOSSIL_CHESTPLATE.get(), "化石胸甲");
        add(ArmorItems.FOSSIL_LEGGINGS.get(), "化石护腿");
        add(ArmorItems.FOSSIL_BOOTS.get(), "化石靴子");
        add(ArmorItems.NINJA_HELMET.get(), "忍者头盔");
        add(ArmorItems.NINJA_CHESTPLATE.get(), "忍者胸甲");
        add(ArmorItems.NINJA_LEGGINGS.get(), "忍者护腿");
        add(ArmorItems.NINJA_BOOTS.get(), "忍者靴子");
        // 鱼
        add(FoodItems.SEA_BASS.get(), "鲈鱼");
        add(FoodItems.ATLANTIC_COD.get(), "大西洋鳕鱼");
        add(FoodItems.ARMORED_CAVE_FISH.get(), "装甲洞穴鱼");
        add(FoodItems.CHAOS_FISH.get(), "混沌鱼");
        add(FoodItems.SCARLET_TIGER_FISH.get(), "猩红虎鱼");
        add(FoodItems.DAMSEL_FISH.get(), "雀鲷");
        add(FoodItems.PISCES_FIN_COD.get(), "双鳍鳕鱼");
        add(FoodItems.EBONY_KOI.get(), "黑檀锦鲤");
        add(FoodItems.FLASHFIN_KOI.get(), "闪耀锦鲤");
        add(FoodItems.PARTIAL_MOUTH_FISH.get(), "偏口鱼");
        add(FoodItems.FROSTY_MINNOW.get(), "寒霜鲦鱼");
        add(FoodItems.GOLDEN_CARP.get(), "金鲤鱼");
        add(FoodItems.BLOODY_PIRANHAS.get(), "血腥食人鱼");
        add(FoodItems.NEON_GREASE_CARP.get(), "霓虹脂鲤");
        add(FoodItems.OBSIDIAN_FISH.get(), "黑曜石鱼");
        add(FoodItems.PRINCESS_FISH.get(), "公主鱼");
        add(FoodItems.COLORFUL_MINERAL_FISH.get(), "七彩矿鱼");
        add(FoodItems.RED_SNAPPER.get(), "红鲷鱼");
        add(FoodItems.TROUT.get(), "鳟鱼");
        add(FoodItems.ROCK_LOBSTER.get(), "岩石龙虾");
        add(FoodItems.TR_SALMON.get(), "异域鲑鱼");
        add(FoodItems.SHRIMP.get(), "虾");
        add(FoodItems.MIRROR_FISH.get(), "镜面鱼");
        add(FoodItems.STINKY_FISH.get(), "臭味鱼");
        add(FoodItems.TUNA.get(), "金枪鱼");
        add(FoodItems.MOTTLED_OILFISH.get(), "斑驳油鱼");

        // 任务鱼

        add(QuestedFishes.AMANITA_FUNGIFIN.get(), "发光蘑菇鱼");
        add(QuestedFishes.ANGELFISH.get(), "天使鱼");
        add(QuestedFishes.BATFISH.get(), "蝙蝠鱼");
        add(QuestedFishes.BLOODY_MANOWAR.get(), "血腥战神");
        add(QuestedFishes.BONEFISH.get(), "骨鱼");
        add(QuestedFishes.BUMBLEBEE_TUNA.get(), "大黄蜂金枪鱼");
        add(QuestedFishes.BUNNYFISH.get(), "兔兔鱼");
        add(QuestedFishes.CAP_TUNABEARD.get(), "金枪鱼船长");
        add(QuestedFishes.CATFISH.get(), "猫猫鱼");
        add(QuestedFishes.CLOUDFISH.get(), "云朵鱼");
        add(QuestedFishes.TR_CLOWNFISH.get(), "异域小丑鱼");
        add(QuestedFishes.CURSEDFISH.get(), "诅咒鱼");
        add(QuestedFishes.DEMONIC_HELLFISH.get(), "地狱恶魔鱼");
        add(QuestedFishes.DERPFISH.get(), "跳跳鱼");
        add(QuestedFishes.DIRTFISH.get(), "土鱼");
        add(QuestedFishes.DYNAMITE_FISH.get(), "雷管鱼");
        add(QuestedFishes.EATER_OF_PLANKTON.get(), "浮游噬鱼");
        add(QuestedFishes.FALLEN_STARFISH.get(), "坠落星鱼");
        add(QuestedFishes.THE_FISH_OF_CTHULHU.get(), "克苏鲁之鱼");
        add(QuestedFishes.FISHOTRON.get(), "骷髅王鱼");
        add(QuestedFishes.FISHRON.get(), "猪龙鱼");
        add(QuestedFishes.GUIDE_VOODOO_FISH.get(), "向导巫毒鱼");
        add(QuestedFishes.HARPYFISH.get(), "鸟妖鱼");
        add(QuestedFishes.HUNGERFISH.get(), "饥饿鱼");
        add(QuestedFishes.ICHORFISH.get(), "灵液鱼");
        add(QuestedFishes.INFECTED_SCABBARDFISH.get(), "染病鞘鱼");
        add(QuestedFishes.JEWELFISH.get(), "宝石鱼");
        add(QuestedFishes.MIRAGE_FISH.get(), "混沌鱼");
        add(QuestedFishes.MUDFISH.get(), "泥鱼");
        add(QuestedFishes.MUTANT_FLINXFIN.get(), "突变弗林鱼");
        add(QuestedFishes.PENGFISH.get(), "企鹅鱼");
        add(QuestedFishes.PIXIEFISH.get(), "妖精鱼");
        add(QuestedFishes.SCARAB_FISH.get(), "甲虫鱼");
        add(QuestedFishes.SCORPIO_FISH.get(), "毒蝎鱼");
        add(QuestedFishes.SLIMEFISH.get(), "史莱姆鱼");
        add(QuestedFishes.SPIDERFISH.get(), "蜘蛛鱼");
        add(QuestedFishes.TROPICAL_BARRACUDA.get(), "热带梭鱼");
        add(QuestedFishes.TUNDRA_TROUT.get(), "苔原鳟鱼");
        add(QuestedFishes.UNICORN_FISH.get(), "独角兽鱼");
        add(QuestedFishes.WYVERNTAIL.get(), "飞龙尾");
        add(QuestedFishes.ZOMBIE_FISH.get(), "僵尸鱼");

        // 食物
        add(FoodItems.APPLE_JUICE.get(), "苹果汁");
        add(FoodItems.BLACKCURRANT.get(), "黑醋栗");
        add(FoodItems.BLOOD_ORANGE.get(), "血橙");
        add(FoodItems.BLOODY_MOSCATO.get(), "猩红麝香葡萄");
        add(FoodItems.ELDERBERRY.get(), "接骨木果");
        add(FoodItems.APRICOT.get(), "杏");
        add(FoodItems.BANANA.get(), "香蕉");
        add(FoodItems.CHERRY.get(), "樱桃");
        add(FoodItems.COCONUT.get(), "椰子");
        add(FoodItems.DRAGON_FRUIT.get(), "火龙果");
        add(FoodItems.GRAPE_FRUIT.get(), "葡萄柚");
        add(FoodItems.LEMON.get(), "柠檬");
        add(FoodItems.MANGO.get(), "芒果");
        add(FoodItems.PEACH.get(), "桃子");
        add(FoodItems.PINEAPPLE.get(), "菠萝");
        add(FoodItems.PLUM.get(), "李子");
        add(FoodItems.SPICY_PEPPER.get(), "辣椒");
        add(FoodItems.STAR_FRUIT.get(), "杨桃");
        add(FoodItems.POMEGRANATE.get(), "番石榴");
        add(FoodItems.RAMBUTAN.get(), "红毛丹");
        add(FoodItems.COOKED_SHRIMP.get(), "熟虾");
        add(FoodItems.ESCARGOT.get(), "法式蜗牛");
        add(FoodItems.FROGGLE_BUNWICH.get(), "面包夹田鸡");
        add(FoodItems.GOLDEN_DELIGHT.get(), "金美味");
        add(FoodItems.GRILLED_SQUIRREL.get(), "松鼠尾");
        add(FoodItems.LOBSTER_TAIL.get(), "龙虾尾");
        add(FoodItems.MONSTER_LASAGNA.get(), "怪物千层面");
        add(FoodItems.SASHIMI.get(), "生鱼片");
        add(FoodItems.ROASTED_BIRD.get(), "烤鸟腿");
        add(FoodItems.ROASTED_DUCK.get(), "鸭肉");
        add(FoodItems.SAUTEED_FROG_LEGS.get(), "爆炒青蛙腿");
        add(FoodItems.SEAFOOD_DINNER.get(), "海鲜大餐");
        add(FoodItems.BACON.get(), "培根");
        add(FoodItems.BANANA_SPLIT.get(), "香蕉船");
        add(FoodItems.BBQ_RIBS.get(), "炭烧排骨");
        add(FoodItems.BURGER.get(), "汉堡");
        add(FoodItems.CHICKEN_NUGGET.get(), "鸡块");
        add(FoodItems.CHOCOLATE_CHIP_COOKIE.get(), "巧克力大曲奇");
        add(FoodItems.FRIED_EGG.get(), "煎蛋");
        add(FoodItems.FRIES.get(), "薯条");
        add(FoodItems.HOTDOG.get(), "热狗");
        add(FoodItems.PIZZA.get(), "披萨");
        add(FoodItems.POTATO_CHIPS.get(), "薯片");
        add(FoodItems.SHRIMP_PO_BOY.get(), "鲨宝男孩");
        add(FoodItems.SHUCKED_OYSTER.get(), "去壳牡蛎");
        add(FoodItems.SPAGHETTI.get(), "意大利面");
        add(FoodItems.SURPER_STEAK.get(), "超大肉排");
        add(FoodItems.CHRISTMAS_PUDDING.get(), "圣诞布丁");
        add(FoodItems.GINGERBREAD_COOKIE.get(), "姜饼人");
        add(FoodItems.SUGAR_COOKIE.get(), "糖曲奇");
        add(FoodItems.MARSHMALLOW.get(), "棉花糖");
        add(FoodItems.COOKED_MARSHMALLOW.get(), "烤棉花糖");
        add(FoodItems.PAD_THAI.get(), "泰式炒河粉");
        add(FoodItems.GRAPE.get(), "葡萄");
        add(FoodItems.FROZEN_BANANA_DAIQUIRI.get(), "香蕉圣代");
        add(FoodItems.GRAPE_JUICE.get(), "葡萄汁");
        add(FoodItems.LEMONADE.get(), "柠檬水");
        add(FoodItems.PEACH_SANGRIA.get(), "桃子桑格利亚汽酒");
        add(FoodItems.PIÑA_COLADA.get(), "皮尼亚·科拉达");
        add(FoodItems.PRISMATIC_PUNCH.get(), "味蕾冲击者");
        add(FoodItems.TROPICAL_SMOOTHIE.get(), "热带冰沙");
        add(FoodItems.SMOOTHIE_OF_DARKNESS.get(), "黑暗奶昔");
        add(FoodItems.CREAM_SODA.get(), "奶油苏打");
        add(FoodItems.ICE_CREAM.get(), "冰淇淋");
        add(FoodItems.MILKSHAKE.get(), "奶昔");
        add(FoodItems.JOJA_COLA.get(), "Joja可乐");
        add(FoodItems.CARTON_OF_MILK.get(), "卡通牛奶");
        add(FoodItems.TEACUP.get(), "一小杯茶");
        add(FoodItems.COFFEE.get(), "咖啡");
        add(FoodItems.FISH_AND_MUSHROOM_SOUP.get(), "鱼菇汤");
        add(FoodItems.FRUIT_SALAD.get(), "水果沙拉");
        add(FoodItems.GRUB_SOUP.get(), "蛆虫汤");
        add(FoodItems.NACHOS.get(), "一碗玉米粒");
        add(FoodItems.PHO.get(), "河粉");
        add(FoodItems.FRUIT_JUICE.get(), "混合果汁");
        add(FoodItems.SAKE.get(), "清酒");
        add(FoodItems.ZONGZI.get(), "粽子");
        add(FoodItems.CLOUD_DOUGH.get(), "云朵面团");
        add(FoodItems.CLOUD_BREAD.get(), "云朵面包");
        add(FoodItems.HONEY_MOONCAKES.get(), "蜂蜜月饼");
        add(FoodItems.HONEY_MOONCAKES_CHUNKS.get(), "小块蜂蜜月饼");
        add(FoodItems.EGG_YOLK_MOONCAKES.get(), "蛋黄月饼");
        add(FoodItems.EGG_YOLK_MOONCAKES_CHUNKS.get(), "小块蛋黄月饼");
        add(FoodItems.LONGEVITY_NOODLES.get(), "长寿面");
        add(FoodItems.FLUTTERING_LAMB_CHOPS.get(), "飘飘羊排");
        add(FoodItems.COOKED_FLUTTERING_LAMB_CHOPS.get(), "熟飘飘羊排");
        // 药水

//        add(VANILLA_POTION.get(), "药水");
        add(PotionItems.LESSER_HEALING_POTION.get(), "弱效治疗药水");
        add(PotionItems.HEALING_POTION.get(), "治疗药水");
        add(PotionItems.GREATER_HEALING_POTION.get(), "强效治疗药水");
        add(PotionItems.SUPER_HEALING_POTION.get(), "超级治疗药水");
        add(PotionItems.LESSER_MANA_POTION.get(), "弱效魔力药水");
        add(PotionItems.MANA_POTION.get(), "魔力药水");
        add(PotionItems.GREATER_MANA_POTION.get(), "强效魔力药水");
        add(PotionItems.SUPER_MANA_POTION.get(), "超级魔力药水");
        add(PotionItems.GRAVITATION_POTION.get(), "重力药水");
        add(PotionItems.SHINE_POTION.get(), "光环药水");
        add(PotionItems.IRON_SKIN_POTION.get(), "铁皮药水");
        add(PotionItems.WRATH_POTION.get(), "怒气药水");
        add(PotionItems.TITAN_POTION.get(), "泰坦药水");
        add(PotionItems.BUILDER_POTION.get(), "建造者药水");
        add(PotionItems.ENDURANCE_POTION.get(), "耐力药水");
        add(PotionItems.INFERNO_POTION.get(), "狱火药水");
        add(PotionItems.LIFEFORCE_POTION.get(), "生命力药水");
        add(PotionItems.FISHING_POTION.get(), "钓鱼药水");
        add(PotionItems.RAGE_POTION.get(), "暴怒药水");
        add(PotionItems.MANA_REGENERATION_POTION.get(), "魔力回复药水");
        add(PotionItems.THORNS_POTION.get(), "荆棘药水");
        add(PotionItems.MAGIC_POWER_POTION.get(), "魔能药水");
        add(PotionItems.OBSIDIAN_SKIN_POTION.get(), "黑曜石皮肤药水");
        add(PotionItems.LESSER_LUCK_POTION.get(), "异域弱效幸运药水");
        add(PotionItems.LUCK_POTION.get(), "异域幸运药水");
        add(PotionItems.GREATER_LUCK_POTION.get(), "异域强效幸运药水");
        add(PotionItems.LOVE_POTION.get(), "爱情药水");
        add(PotionItems.SWIFTNESS_POTION.get(), "迅捷药水");
        add(PotionItems.REGENERATION_POTION.get(), "再生药水");
        add(PotionItems.FLIPPER_POTION.get(), "脚蹼药水");
        add(PotionItems.ARCHERY_POTION.get(), "箭术药水");
        add(PotionItems.HEART_REACH_POTION.get(), "拾心药水");
        add(PotionItems.GILLS_POTION.get(), "鱼腮药水");
        add(PotionItems.INVISIBILITY_POTION.get(), "虫洞药水");
        add(PotionItems.MINING_POTION.get(), "采矿药水");
        add(PotionItems.RECALL_POTION.get(), "回忆药水");
        add(PotionItems.NIGHT_OWL_POTION.get(), "夜猫子药水");
        add(PotionItems.WATER_WALKING_POTION.get(), "水上漂药水");
        add(PotionItems.FEATHERFALL_POTION.get(), "羽落药水");
        add(PotionItems.RANDOM_TELEPORT_POTION.get(), "传送药水");
        add(PotionItems.SPELUNKER_POTION.get(), "洞穴探险药水");
        add(PotionItems.DANGERSENSE_POTION.get(), "危险感药水");
        add(PotionItems.HUNTER_POTION.get(), "狩猎药水");


        // 药水效果
        add(ModEffects.MANA_SICKNESS.get(), "魔力病");
        add(ModEffects.SHINE.get(), "发光");
        add(ModEffects.SHIMMER.get(), "闪烁");
        add(ModEffects.EXQUISITELY_STUFFED.get(), "膳食");
        add(ModEffects.IRON_SKIN.get(), "铁皮");
        add(ModEffects.ENDURANCE.get(), "耐力");
        add(ModEffects.INFERNO.get(), "狱火");
        add(ModEffects.LIFE_FORCE.get(), "生命力");
        add(ModEffects.THORNS.get(), "荆棘");
        add(ModEffects.TITAN.get(), "泰坦之力");
        add(ModEffects.WRATH.get(), "愤怒");
        add(ModEffects.BUILDER.get(), "熟练建造");
        add(ModEffects.BLEEDING.get(), "流血");
        add(ModEffects.SILENCED.get(), "沉默");
        add(ModEffects.CURSED.get(), "诅咒");
        add(ModEffects.WITHERED_ARMOR.get(), "枯萎盔甲");
        add(ModEffects.ICHOR.get(), "灵液");
        add(ModEffects.POTION_SICKNESS.get(), "耐药性");
        add(ModEffects.BLOOD_BUTCHERED.get(), "血腥屠宰");
        add(ModEffects.TENTACLE_SPIKES.get(), "触手钉刺");
        add(ModEffects.BROKEN_ARMOR.get(), "破损盔甲");
        add(ModEffects.STONED.get(), "石化");

        // 雕像
//        add(STATUE_A.get(), "A雕像");
        //endregion items

        //region entities
//        add(ModEntities.STEP_STOOL.get(), "梯凳");
        //endregion entities
    }
}
