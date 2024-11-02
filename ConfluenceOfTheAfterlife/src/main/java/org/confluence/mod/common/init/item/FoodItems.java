package org.confluence.mod.common.init.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.UseAnim;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.confluence.mod.Confluence;
import org.confluence.mod.common.item.food.BaseFoodItem;
import org.confluence.mod.common.item.food.FoodType;

import static net.minecraft.world.item.Items.BOWL;
import static net.minecraft.world.item.Items.GLASS_BOTTLE;

public class FoodItems {
    public static final DeferredRegister.Items FOODS = DeferredRegister.createItems(Confluence.MODID);
    //常规食物
    public static final DeferredItem<BaseFoodItem> COOKED_SHRIMP = normalFoodRegister("cooked_shrimp", FoodType.MEDIUM);
    public static final DeferredItem<BaseFoodItem> ESCARGOT = normalFoodRegister("escargot", FoodType.MEDIUM); //法式蜗牛
    public static final DeferredItem<BaseFoodItem> FROGGLE_BUNWICH = normalFoodRegister("froggle_bunwich", FoodType.MEDIUM); //面包夹田鸡
    public static final DeferredItem<BaseFoodItem> GOLDEN_DELIGHT = normalFoodRegister("golden_delight", FoodType.GOLDEN_CARP); //金美味
    public static final DeferredItem<BaseFoodItem> GRILLED_SQUIRREL = normalFoodRegister("grilled_squirrel", FoodType.MEAT); //松鼠尾
    public static final DeferredItem<BaseFoodItem> LOBSTER_TAIL = normalFoodRegister("lobster_tail", FoodType.SENIOR); //龙虾尾
    public static final DeferredItem<BaseFoodItem> MONSTER_LASAGNA = normalFoodRegister("monster_lasagna", FoodType.SENIOR); //怪物千层面
    public static final DeferredItem<BaseFoodItem> SASHIMI = normalFoodRegister("sashimi", FoodType.MEDIUM); //生鱼片
    public static final DeferredItem<BaseFoodItem> ROASTED_BIRD = normalFoodRegister("roasted_bird", FoodType.MEAT); //烤鸟腿
    public static final DeferredItem<BaseFoodItem> ROASTED_DUCK= normalFoodRegister("roasted_duck", FoodType.MEAT); //鸭肉
    public static final DeferredItem<BaseFoodItem> SAUTEED_FROG_LEGS= normalFoodRegister("sauteed_frog_legs", FoodType.MEAT); //爆炒青蛙腿
    public static final DeferredItem<BaseFoodItem> SEAFOOD_DINNER = normalFoodRegister("seafood_dinner", FoodType.SENIOR); //海鲜大餐
    public static final DeferredItem<BaseFoodItem> BACON = normalFoodRegister("bacon", FoodType.SENIOR); //培根
    public static final DeferredItem<BaseFoodItem> BANANA_SPLIT = normalFoodRegister("banana_split", FoodType.SENIOR); //香蕉船
    public static final DeferredItem<BaseFoodItem> BBQ_RIBS = normalFoodRegister("bbq_ribs", FoodType.SENIOR); //炭烧排骨
    public static final DeferredItem<BaseFoodItem> BURGER = normalFoodRegister("burger", FoodType.SENIOR); //汉堡
    public static final DeferredItem<BaseFoodItem> CHICKEN_NUGGET = normalFoodRegister("chicken_nugget", FoodType.SENIOR); //鸡块
    public static final DeferredItem<BaseFoodItem> CHOCOLATE_CHIP_COOKIE = normalFoodRegister("chocolate_chip_cookie", FoodType.SENIOR); //巧克力大曲奇
    public static final DeferredItem<BaseFoodItem> FRIED_EGG = normalFoodRegister("fried_egg", FoodType.MEAT); //煎蛋
    public static final DeferredItem<BaseFoodItem> FRIES = normalFoodRegister("fries", FoodType.SENIOR); //薯条
    public static final DeferredItem<BaseFoodItem> HOTDOG = normalFoodRegister("hotdog", FoodType.SENIOR); //热狗
    public static final DeferredItem<BaseFoodItem> PIZZA = normalFoodRegister("pizza", FoodType.SENIOR); //披萨
    public static final DeferredItem<BaseFoodItem> POTATO_CHIPS = normalFoodRegister("potato_chips", FoodType.SENIOR); //薯片
    public static final DeferredItem<BaseFoodItem> SHRIMP_PO_BOY = normalFoodRegister("shrimp_po_boy", FoodType.SENIOR); //鲨宝男孩
    public static final DeferredItem<BaseFoodItem> SHUCKED_OYSTER = normalFoodRegister("shucked_oyster", FoodType.LOW); //去壳牡蛎
    public static final DeferredItem<BaseFoodItem> SPAGHETTI = normalFoodRegister("spaghetti", FoodType.SENIOR); //意大利面
    public static final DeferredItem<BaseFoodItem> SURPER_STEAK = normalFoodRegister("surper_steak", FoodType.SENIOR); //超大肉排
    public static final DeferredItem<BaseFoodItem> CHRISTMAS_PUDDING = normalFoodRegister("christmas_pudding", FoodType.SENIOR); //圣诞布丁
    public static final DeferredItem<BaseFoodItem> GINGERBREAD_COOKIE = normalFoodRegister("gingerbread_cookie", FoodType.SENIOR); //姜饼人
    public static final DeferredItem<BaseFoodItem> SUGAR_COOKIE = normalFoodRegister("sugar_cookie", FoodType.SENIOR); //糖曲奇
    public static final DeferredItem<BaseFoodItem> MARSHMALLOW = normalFoodRegister("marshmallow", FoodType.LOW); //棉花糖
    public static final DeferredItem<BaseFoodItem> COOKED_MARSHMALLOW = normalFoodRegister("cooked_marshmallow", FoodType.MEDIUM); //烤棉花糖
    public static final DeferredItem<BaseFoodItem> PAD_THAI = normalFoodRegister("pad_thai", FoodType.SENIOR); //泰式炒河粉
    public static final DeferredItem<BaseFoodItem> FISH_AND_MUSHROOM_SOUP = containerFoodRegister("fish_and_mushroom_soup", FoodType.MEDIUM, BOWL); //鱼菇汤
    public static final DeferredItem<BaseFoodItem> FRUIT_SALAD = containerFoodRegister("fruit_salad", FoodType.HIGH, GLASS_BOTTLE); //水果沙拉
    public static final DeferredItem<BaseFoodItem> GRUB_SOUP = containerFoodRegister("grub_soup", FoodType.HIGH, BOWL); //蛆虫汤
    public static final DeferredItem<BaseFoodItem> NACHOS = containerFoodRegister("nachos", FoodType.HIGH, BOWL); //一碗玉米粒
    public static final DeferredItem<BaseFoodItem> PHO = containerFoodRegister("pho", FoodType.MEDIUM, BOWL); //河粉
    public static final DeferredItem<BaseFoodItem> CLOUD_DOUGH = normalFoodRegister("cloud_dough", FoodType.LOW); // 粗制云朵面包
    public static final DeferredItem<BaseFoodItem> CLOUD_BREAD = normalFoodRegister("cloud_bread", FoodType.CLOUD_BREAD); // 云朵面包
    public static final DeferredItem<BaseFoodItem> FLUTTERING_LAMB_CHOPS = normalFoodRegister("fluttering_lamb_chops", FoodType.LOW);
    public static final DeferredItem<BaseFoodItem> COOKED_FLUTTERING_LAMB_CHOPS = normalFoodRegister("cooked_fluttering_lamb_chops", FoodType.SENIOR);
    // 水果
    public static final DeferredItem<BaseFoodItem> APRICOT = normalFoodRegister("apricot", FoodType.LOW);
    public static final DeferredItem<BaseFoodItem> BANANA = normalFoodRegister("banana", FoodType.LOW);
    public static final DeferredItem<BaseFoodItem> CHERRY = normalFoodRegister("cherry", FoodType.LOW);
    public static final DeferredItem<BaseFoodItem> COCONUT = normalFoodRegister("coconut", FoodType.LOW);
    public static final DeferredItem<BaseFoodItem> DRAGON_FRUIT = normalFoodRegister("dragon_fruit", FoodType.LOW);
    public static final DeferredItem<BaseFoodItem> GRAPE_FRUIT = normalFoodRegister("grape_fruit", FoodType.LOW);
    public static final DeferredItem<BaseFoodItem> LEMON = normalFoodRegister("lemon", FoodType.LOW);
    public static final DeferredItem<BaseFoodItem> MANGO = normalFoodRegister("mango", FoodType.LOW);
    public static final DeferredItem<BaseFoodItem> PEACH = normalFoodRegister("peach", FoodType.LOW);
    public static final DeferredItem<BaseFoodItem> PINEAPPLE = normalFoodRegister("pineapple", FoodType.LOW);
    public static final DeferredItem<BaseFoodItem> PLUM = normalFoodRegister("plum", FoodType.LOW);
    public static final DeferredItem<BaseFoodItem> GRAPE = normalFoodRegister("grape", FoodType.SENIOR);//葡萄
    public static final DeferredItem<BaseFoodItem> SPICY_PEPPER = normalFoodRegister("spicy_pepper", FoodType.LOW);
    public static final DeferredItem<BaseFoodItem> STAR_FRUIT = normalFoodRegister("star_fruit", FoodType.LOW);
    public static final DeferredItem<BaseFoodItem> POMEGRANATE = normalFoodRegister("pomegranate", FoodType.LOW);
    public static final DeferredItem<BaseFoodItem> RAMBUTAN = normalFoodRegister("rambutan", FoodType.LOW);
    public static final DeferredItem<BaseFoodItem> BLOOD_ORANGE = normalFoodRegister("blood_orange", FoodType.LOW);
    public static final DeferredItem<BaseFoodItem> ELDERBERRY = normalFoodRegister("elderberry", FoodType.LOW);
    public static final DeferredItem<BaseFoodItem> BLACKCURRANT = normalFoodRegister("blackcurrant", FoodType.LOW);
    //饮料
    public static final DeferredItem<BaseFoodItem> FRUIT_JUICE = containerFoodRegister("fruit_juice", FoodType.MEDIUM, GLASS_BOTTLE); //混合果汁
    public static final DeferredItem<BaseFoodItem> APPLE_JUICE = containerFoodRegister("apple_juice", FoodType.MEDIUM, GLASS_BOTTLE);
    public static final DeferredItem<BaseFoodItem> FROZEN_BANANA_DAIQUIRI = containerFoodRegister("frozen_banana_daiquiri", FoodType.MEDIUM, GLASS_BOTTLE); //香蕉圣代
    public static final DeferredItem<BaseFoodItem> GRAPE_JUICE = containerFoodRegister("grape_juice", FoodType.GOLDEN_CARP, GLASS_BOTTLE); //葡萄汁
    public static final DeferredItem<BaseFoodItem> LEMONADE = containerFoodRegister("lemonade", FoodType.MEDIUM, GLASS_BOTTLE); //柠檬水
    public static final DeferredItem<BaseFoodItem> PEACH_SANGRIA = containerFoodRegister("peach_sangria", FoodType.SENIOR, GLASS_BOTTLE); //桃子桑格利亚汽酒
    public static final DeferredItem<BaseFoodItem> PIÑA_COLADA = containerFoodRegister("pina_colada", FoodType.MEDIUM, GLASS_BOTTLE); //皮尼亚·科拉达
    public static final DeferredItem<BaseFoodItem> PRISMATIC_PUNCH = containerFoodRegister("prismatic_punch", FoodType.SENIOR, GLASS_BOTTLE); //味蕾冲击者
    public static final DeferredItem<BaseFoodItem> TROPICAL_SMOOTHIE = containerFoodRegister("tropical_smoothie", FoodType.SENIOR, GLASS_BOTTLE); //热带冰沙
    public static final DeferredItem<BaseFoodItem> SMOOTHIE_OF_DARKNESS = containerFoodRegister("smoothie_of_darkness", FoodType.MEDIUM, GLASS_BOTTLE); //黑暗奶昔
    public static final DeferredItem<BaseFoodItem> BLOODY_MOSCATO = containerFoodRegister("bloody_moscato", FoodType.MEDIUM, GLASS_BOTTLE);
    public static final DeferredItem<BaseFoodItem> CREAM_SODA = containerFoodRegister("cream_soda", FoodType.SENIOR, GLASS_BOTTLE); //奶油苏打
    public static final DeferredItem<BaseFoodItem> ICE_CREAM = containerFoodRegister("ice_cream", FoodType.SENIOR, GLASS_BOTTLE); //冰淇淋
    public static final DeferredItem<BaseFoodItem> MILKSHAKE = containerFoodRegister("milkshake", FoodType.SENIOR, GLASS_BOTTLE); //奶昔
    //不掉落瓶子的饮料
    public static final DeferredItem<BaseFoodItem> JOJA_COLA = containerFoodRegister("joja_cola", FoodType.LOW, GLASS_BOTTLE); //乔家可乐
    public static final DeferredItem<BaseFoodItem> CARTON_OF_MILK = containerFoodRegister("carton_of_milk", FoodType.SENIOR, GLASS_BOTTLE); //卡通牛奶
    public static final DeferredItem<BaseFoodItem> TEACUP = containerFoodRegister("teacup", FoodType.LOW, GLASS_BOTTLE); //一小杯茶
    public static final DeferredItem<BaseFoodItem> COFFEE = containerFoodRegister("coffee", FoodType.SENIOR, GLASS_BOTTLE); //咖啡
    public static final DeferredItem<BaseFoodItem> SAKE = containerFoodRegister("sake", FoodType.SENIOR, GLASS_BOTTLE); //清酒
    //鱼
    public static final DeferredItem<BaseFoodItem> SEA_BASS = normalFoodRegister("sea_bass", FoodType.FISH);
    public static final DeferredItem<BaseFoodItem> ATLANTIC_COD = normalFoodRegister("atlantic_cod", FoodType.FISH);
    public static final DeferredItem<BaseFoodItem> FROSTY_MINNOW = normalFoodRegister("frosty_minnow", FoodType.FISH);
    public static final DeferredItem<BaseFoodItem> PISCES_FIN_COD = normalFoodRegister("pisces_fin_cod", FoodType.FISH);
    public static final DeferredItem<BaseFoodItem> PARTIAL_MOUTH_FISH = normalFoodRegister("partial_mouth_fish", FoodType.FISH);
    public static final DeferredItem<BaseFoodItem> ROCK_LOBSTER = normalFoodRegister("rock_lobster", FoodType.FISH);
    public static final DeferredItem<BaseFoodItem> SHRIMP = normalFoodRegister("shrimp", FoodType.FISH);
    public static final DeferredItem<BaseFoodItem> TR_SALMON = normalFoodRegister("tr_salmon", FoodType.FISH);
    public static final DeferredItem<BaseFoodItem> TUNA = normalFoodRegister("tuna", FoodType.FISH);
    public static final DeferredItem<BaseFoodItem> RED_SNAPPER = normalFoodRegister("red_snapper", FoodType.FISH);
    public static final DeferredItem<BaseFoodItem> TROUT = normalFoodRegister("trout", FoodType.FISH);
    public static final DeferredItem<BaseFoodItem> ARMORED_CAVE_FISH = normalFoodRegister("armored_cave_fish", FoodType.FISH);
    public static final DeferredItem<BaseFoodItem> MIRROR_FISH = normalFoodRegister("mirror_fish", FoodType.FISH);
    public static final DeferredItem<BaseFoodItem> STINKY_FISH = normalFoodRegister("stinky_fish", FoodType.FISH);
    public static final DeferredItem<BaseFoodItem> NEON_GREASE_CARP = normalFoodRegister("neon_grease_carp", FoodType.FISH);
    public static final DeferredItem<BaseFoodItem> DAMSEL_FISH = normalFoodRegister("damsel_fish", FoodType.FISH);
    public static final DeferredItem<BaseFoodItem> EBONY_KOI = normalFoodRegister("ebony_koi", FoodType.FISH);
    public static final DeferredItem<BaseFoodItem> SCARLET_TIGER_FISH = normalFoodRegister("scarlet_tiger_fish", FoodType.FISH);
    public static final DeferredItem<BaseFoodItem> BLOODY_PIRANHAS = normalFoodRegister("bloody_piranhas", FoodType.FISH);
    public static final DeferredItem<BaseFoodItem> PRINCESS_FISH = normalFoodRegister("princess_fish", FoodType.FISH);
    public static final DeferredItem<BaseFoodItem> COLORFUL_MINERAL_FISH = normalFoodRegister("colorful_mineral_fish", FoodType.FISH);
    public static final DeferredItem<BaseFoodItem> CHAOS_FISH = normalFoodRegister("chaos_fish", FoodType.FISH);
    public static final DeferredItem<BaseFoodItem> MOTTLED_OILFISH = normalFoodRegister("mottled_oilfish", FoodType.FISH);
    public static final DeferredItem<BaseFoodItem> GOLDEN_CARP = normalFoodRegister("golden_carp", FoodType.GOLDEN_CARP);
    public static final DeferredItem<BaseFoodItem> OBSIDIAN_FISH = fireResistantFoodRegister("obsidian_fish", (FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> FLASHFIN_KOI = fireResistantFoodRegister("flashfin_koi", (FoodType.FISH));
    //节日特有
    public static final DeferredItem<BaseFoodItem > ZONGZI = fireResistantFoodRegister("zongzi", (FoodType.LOW));

    public static final DeferredItem<BaseFoodItem> HONEY_MOONCAKES = fireResistantFoodRegister("honey_mooncakes", (FoodType.MEDIUM));
    public static final DeferredItem<BaseFoodItem> HONEY_MOONCAKES_CHUNKS = fireResistantFoodRegister("honey_mooncakes_chunks", (FoodType.MOONCAKES));
    public static final DeferredItem<BaseFoodItem> EGG_YOLK_MOONCAKES = fireResistantFoodRegister("egg_yolk_mooncakes", (FoodType.MEDIUM));
    public static final DeferredItem<BaseFoodItem> EGG_YOLK_MOONCAKES_CHUNKS = fireResistantFoodRegister("egg_yolk_mooncakes_chunks", (FoodType.MEDIUM));

    public static final DeferredItem<BaseFoodItem> LONGEVITY_NOODLES = fireResistantFoodRegister("longevity_noodles", (FoodType.LOW));

    public static DeferredItem<BaseFoodItem> normalFoodRegister(String name, FoodProperties foodProperties) {
        return FOODS.register(name, () -> new BaseFoodItem(foodProperties));
    }
    
    public static DeferredItem<BaseFoodItem> fireResistantFoodRegister(String name, FoodProperties foodProperties) {
        return FOODS.register(name, () -> new BaseFoodItem(foodProperties, true));
    }

    public static DeferredItem<BaseFoodItem> containerFoodRegister(String name, FoodProperties foodProperties, Item craftingRemainingItem) {
        return FOODS.register(name, () -> new BaseFoodItem(foodProperties, craftingRemainingItem, 20, UseAnim.DRINK, SoundEvents.HONEY_DRINK, SoundEvents.HONEY_DRINK));
    }
}
