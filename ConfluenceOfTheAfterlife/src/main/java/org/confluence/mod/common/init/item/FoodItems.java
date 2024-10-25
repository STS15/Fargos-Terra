package org.confluence.mod.common.init.item;

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
    public static final DeferredItem<BaseFoodItem> COOKED_SHRIMP = FOODS.register("cooked_shrimp", () -> new BaseFoodItem(FoodType.MEDIUM));
    public static final DeferredItem<BaseFoodItem> ESCARGOT = FOODS.register("escargot", () -> new BaseFoodItem(FoodType.MEDIUM)); //法式蜗牛
    public static final DeferredItem<BaseFoodItem> FROGGLE_BUNWICH = FOODS.register("froggle_bunwich", () -> new BaseFoodItem(FoodType.MEDIUM)); //面包夹田鸡
    public static final DeferredItem<BaseFoodItem> GOLDEN_DELIGHT = FOODS.register("golden_delight", () -> new BaseFoodItem(FoodType.GOLDEN_CARP)); //金美味
    public static final DeferredItem<BaseFoodItem> GRILLED_SQUIRREL = FOODS.register("grilled_squirrel", () -> new BaseFoodItem(FoodType.MEAT)); //松鼠尾
    public static final DeferredItem<BaseFoodItem> LOBSTER_TAIL = FOODS.register("lobster_tail", () -> new BaseFoodItem(FoodType.SENIOR)); //龙虾尾
    public static final DeferredItem<BaseFoodItem> MONSTER_LASAGNA = FOODS.register("monster_lasagna", () -> new BaseFoodItem(FoodType.SENIOR)); //怪物千层面
    public static final DeferredItem<BaseFoodItem> SASHIMI = FOODS.register("sashimi", () -> new BaseFoodItem(FoodType.MEDIUM)); //生鱼片
    public static final DeferredItem<BaseFoodItem> ROASTED_BIRD = FOODS.register("roasted_bird", () -> new BaseFoodItem(FoodType.MEAT)); //烤鸟腿
    public static final DeferredItem<BaseFoodItem> ROASTED_DUCK= FOODS.register("roasted_duck", () -> new BaseFoodItem(FoodType.MEAT)); //鸭肉
    public static final DeferredItem<BaseFoodItem> SAUTEED_FROG_LEGS= FOODS.register("sauteed_frog_legs", () -> new BaseFoodItem(FoodType.MEAT)); //爆炒青蛙腿
    public static final DeferredItem<BaseFoodItem> SEAFOOD_DINNER = FOODS.register("seafood_dinner", () -> new BaseFoodItem(FoodType.SENIOR)); //海鲜大餐
    public static final DeferredItem<BaseFoodItem> BACON = FOODS.register("bacon", () -> new BaseFoodItem(FoodType.SENIOR)); //培根
    public static final DeferredItem<BaseFoodItem> BANANA_SPLIT = FOODS.register("banana_split", () -> new BaseFoodItem(FoodType.SENIOR)); //香蕉船
    public static final DeferredItem<BaseFoodItem> BBQ_RIBS = FOODS.register("bbq_ribs", () -> new BaseFoodItem(FoodType.SENIOR)); //炭烧排骨
    public static final DeferredItem<BaseFoodItem> BURGER = FOODS.register("burger", () -> new BaseFoodItem(FoodType.SENIOR)); //汉堡
    public static final DeferredItem<BaseFoodItem> CHICKEN_NUGGET = FOODS.register("chicken_nugget", () -> new BaseFoodItem(FoodType.SENIOR)); //鸡块
    public static final DeferredItem<BaseFoodItem> CHOCOLATE_CHIP_COOKIE = FOODS.register("chocolate_chip_cookie", () -> new BaseFoodItem(FoodType.SENIOR)); //巧克力大曲奇
    public static final DeferredItem<BaseFoodItem> FRIED_EGG = FOODS.register("fried_egg", () -> new BaseFoodItem(FoodType.MEAT)); //煎蛋
    public static final DeferredItem<BaseFoodItem> FRIES = FOODS.register("fries", () -> new BaseFoodItem(FoodType.SENIOR)); //薯条
    public static final DeferredItem<BaseFoodItem> HOTDOG = FOODS.register("hotdog", () -> new BaseFoodItem(FoodType.SENIOR)); //热狗
    public static final DeferredItem<BaseFoodItem> PIZZA = FOODS.register("pizza", () -> new BaseFoodItem(FoodType.SENIOR)); //披萨
    public static final DeferredItem<BaseFoodItem> POTATO_CHIPS = FOODS.register("potato_chips", () -> new BaseFoodItem(FoodType.SENIOR)); //薯片
    public static final DeferredItem<BaseFoodItem> SHRIMP_PO_BOY = FOODS.register("shrimp_po_boy", () -> new BaseFoodItem(FoodType.SENIOR)); //鲨宝男孩
    public static final DeferredItem<BaseFoodItem> SHUCKED_OYSTER = FOODS.register("shucked_oyster", () -> new BaseFoodItem(FoodType.LOW)); //去壳牡蛎
    public static final DeferredItem<BaseFoodItem> SPAGHETTI = FOODS.register("spaghetti", () -> new BaseFoodItem(FoodType.SENIOR)); //意大利面
    public static final DeferredItem<BaseFoodItem> SURPER_STEAK = FOODS.register("surper_steak", () -> new BaseFoodItem(FoodType.SENIOR)); //超大肉排
    public static final DeferredItem<BaseFoodItem> CHRISTMAS_PUDDING = FOODS.register("christmas_pudding", () -> new BaseFoodItem(FoodType.SENIOR)); //圣诞布丁
    public static final DeferredItem<BaseFoodItem> GINGERBREAD_COOKIE = FOODS.register("gingerbread_cookie", () -> new BaseFoodItem(FoodType.SENIOR)); //姜饼人
    public static final DeferredItem<BaseFoodItem> SUGAR_COOKIE = FOODS.register("sugar_cookie", () -> new BaseFoodItem(FoodType.SENIOR)); //糖曲奇
    public static final DeferredItem<BaseFoodItem> MARSHMALLOW = FOODS.register("marshmallow", () -> new BaseFoodItem(FoodType.LOW)); //棉花糖
    public static final DeferredItem<BaseFoodItem> COOKED_MARSHMALLOW = FOODS.register("cooked_marshmallow", () -> new BaseFoodItem(FoodType.MEDIUM)); //烤棉花糖
    public static final DeferredItem<BaseFoodItem> PAD_THAI = FOODS.register("pad_thai", () -> new BaseFoodItem(FoodType.SENIOR)); //泰式炒河粉
    public static final DeferredItem<BaseFoodItem.ContainerFoodItem> FISH_AND_MUSHROOM_SOUP = FOODS.register("fish_and_mushroom_soup", () -> new BaseFoodItem.ContainerFoodItem(FoodType.MEDIUM, BOWL)); //鱼菇汤
    public static final DeferredItem<BaseFoodItem.ContainerFoodItem> FRUIT_SALAD = FOODS.register("fruit_salad", () -> new BaseFoodItem.ContainerFoodItem(FoodType.HIGH, GLASS_BOTTLE)); //水果沙拉
    public static final DeferredItem<BaseFoodItem.ContainerFoodItem> GRUB_SOUP = FOODS.register("grub_soup", () -> new BaseFoodItem.ContainerFoodItem(FoodType.HIGH, BOWL)); //蛆虫汤
    public static final DeferredItem<BaseFoodItem.ContainerFoodItem> NACHOS = FOODS.register("nachos", () -> new BaseFoodItem.ContainerFoodItem(FoodType.HIGH, BOWL)); //一碗玉米粒
    public static final DeferredItem<BaseFoodItem.ContainerFoodItem> PHO = FOODS.register("pho", () -> new BaseFoodItem.ContainerFoodItem(FoodType.MEDIUM, BOWL)); //河粉
    public static final DeferredItem<BaseFoodItem> CLOUD_DOUGH = FOODS.register("cloud_dough", () -> new BaseFoodItem(FoodType.LOW)); // 粗制云朵面包
    public static final DeferredItem<BaseFoodItem> CLOUD_BREAD = FOODS.register("cloud_bread", () -> new BaseFoodItem(FoodType.CLOUD_BREAD)); // 云朵面包
    public static final DeferredItem<BaseFoodItem> FLUTTERING_LAMB_CHOPS = FOODS.register("fluttering_lamb_chops", () -> new BaseFoodItem(FoodType.LOW));
    public static final DeferredItem<BaseFoodItem> COOKED_FLUTTERING_LAMB_CHOPS = FOODS.register("cooked_fluttering_lamb_chops", () -> new BaseFoodItem(FoodType.SENIOR));
    // 水果
    public static final DeferredItem<BaseFoodItem> APRICOT = FOODS.register("apricot", () -> new BaseFoodItem(FoodType.LOW));
    public static final DeferredItem<BaseFoodItem> BANANA = FOODS.register("banana", () -> new BaseFoodItem(FoodType.LOW));
    public static final DeferredItem<BaseFoodItem> CHERRY = FOODS.register("cherry", () -> new BaseFoodItem(FoodType.LOW));
    public static final DeferredItem<BaseFoodItem> COCONUT = FOODS.register("coconut", () -> new BaseFoodItem(FoodType.LOW));
    public static final DeferredItem<BaseFoodItem> DRAGON_FRUIT = FOODS.register("dragon_fruit", () -> new BaseFoodItem(FoodType.LOW));
    public static final DeferredItem<BaseFoodItem> GRAPE_FRUIT = FOODS.register("grape_fruit", () -> new BaseFoodItem(FoodType.LOW));
    public static final DeferredItem<BaseFoodItem> LEMON = FOODS.register("lemon", () -> new BaseFoodItem(FoodType.LOW));
    public static final DeferredItem<BaseFoodItem> MANGO = FOODS.register("mango", () -> new BaseFoodItem(FoodType.LOW));
    public static final DeferredItem<BaseFoodItem> PEACH = FOODS.register("peach", () -> new BaseFoodItem(FoodType.LOW));
    public static final DeferredItem<BaseFoodItem> PINEAPPLE = FOODS.register("pineapple", () -> new BaseFoodItem(FoodType.LOW));
    public static final DeferredItem<BaseFoodItem> PLUM = FOODS.register("plum", () -> new BaseFoodItem(FoodType.LOW));
    public static final DeferredItem<BaseFoodItem> GRAPE = FOODS.register("grape", () -> new BaseFoodItem(FoodType.SENIOR));//葡萄
    public static final DeferredItem<BaseFoodItem> SPICY_PEPPER = FOODS.register("spicy_pepper", () -> new BaseFoodItem(FoodType.LOW));
    public static final DeferredItem<BaseFoodItem> STAR_FRUIT = FOODS.register("star_fruit", () -> new BaseFoodItem(FoodType.LOW));
    public static final DeferredItem<BaseFoodItem> POMEGRANATE = FOODS.register("pomegranate", () -> new BaseFoodItem(FoodType.LOW));
    public static final DeferredItem<BaseFoodItem> RAMBUTAN = FOODS.register("rambutan", () -> new BaseFoodItem(FoodType.LOW));
    public static final DeferredItem<BaseFoodItem> BLOOD_ORANGE = FOODS.register("blood_orange", () -> new BaseFoodItem(FoodType.LOW));
    public static final DeferredItem<BaseFoodItem> ELDERBERRY = FOODS.register("elderberry", () -> new BaseFoodItem(FoodType.LOW));
    public static final DeferredItem<BaseFoodItem> BLACKCURRANT = FOODS.register("blackcurrant", () -> new BaseFoodItem(FoodType.LOW));
    //饮料
    public static final DeferredItem<BaseFoodItem.ContainerFoodItem> FRUIT_JUICE = FOODS.register("fruit_juice", () -> new BaseFoodItem.ContainerFoodItem(FoodType.MEDIUM, GLASS_BOTTLE)); //混合果汁
    public static final DeferredItem<BaseFoodItem.ContainerFoodItem> APPLE_JUICE = FOODS.register("apple_juice", () -> new BaseFoodItem.ContainerFoodItem(FoodType.MEDIUM, GLASS_BOTTLE));
    public static final DeferredItem<BaseFoodItem.ContainerFoodItem> FROZEN_BANANA_DAIQUIRI = FOODS.register("frozen_banana_daiquiri", () -> new BaseFoodItem.ContainerFoodItem(FoodType.MEDIUM, GLASS_BOTTLE)); //香蕉圣代
    public static final DeferredItem<BaseFoodItem.ContainerFoodItem> GRAPE_JUICE = FOODS.register("grape_juice", () -> new BaseFoodItem.ContainerFoodItem(FoodType.GOLDEN_CARP, GLASS_BOTTLE)); //葡萄汁
    public static final DeferredItem<BaseFoodItem.ContainerFoodItem> LEMONADE = FOODS.register("lemonade", () -> new BaseFoodItem.ContainerFoodItem(FoodType.MEDIUM, GLASS_BOTTLE)); //柠檬水
    public static final DeferredItem<BaseFoodItem.ContainerFoodItem> PEACH_SANGRIA = FOODS.register("peach_sangria", () -> new BaseFoodItem.ContainerFoodItem(FoodType.SENIOR, GLASS_BOTTLE)); //桃子桑格利亚汽酒
    public static final DeferredItem<BaseFoodItem.ContainerFoodItem> PIÑA_COLADA = FOODS.register("pina_colada", () -> new BaseFoodItem.ContainerFoodItem(FoodType.MEDIUM, GLASS_BOTTLE)); //皮尼亚·科拉达
    public static final DeferredItem<BaseFoodItem.ContainerFoodItem> PRISMATIC_PUNCH = FOODS.register("prismatic_punch", () -> new BaseFoodItem.ContainerFoodItem(FoodType.SENIOR, GLASS_BOTTLE)); //味蕾冲击者
    public static final DeferredItem<BaseFoodItem.ContainerFoodItem> TROPICAL_SMOOTHIE = FOODS.register("tropical_smoothie", () -> new BaseFoodItem.ContainerFoodItem(FoodType.SENIOR, GLASS_BOTTLE)); //热带冰沙
    public static final DeferredItem<BaseFoodItem.ContainerFoodItem> SMOOTHIE_OF_DARKNESS = FOODS.register("smoothie_of_darkness", () -> new BaseFoodItem.ContainerFoodItem(FoodType.MEDIUM, GLASS_BOTTLE)); //黑暗奶昔
    public static final DeferredItem<BaseFoodItem.ContainerFoodItem> BLOODY_MOSCATO = FOODS.register("bloody_moscato", () -> new BaseFoodItem.ContainerFoodItem(FoodType.MEDIUM, GLASS_BOTTLE));
    public static final DeferredItem<BaseFoodItem.ContainerFoodItem> CREAM_SODA = FOODS.register("cream_soda", () -> new BaseFoodItem.ContainerFoodItem(FoodType.SENIOR, GLASS_BOTTLE)); //奶油苏打
    public static final DeferredItem<BaseFoodItem.ContainerFoodItem> ICE_CREAM = FOODS.register("ice_cream", () -> new BaseFoodItem.ContainerFoodItem(FoodType.SENIOR, GLASS_BOTTLE)); //冰淇淋
    public static final DeferredItem<BaseFoodItem.ContainerFoodItem> MILKSHAKE = FOODS.register("milkshake", () -> new BaseFoodItem.ContainerFoodItem(FoodType.SENIOR, GLASS_BOTTLE)); //奶昔
    //不掉落瓶子的饮料
    public static final DeferredItem<BaseFoodItem.ContainerFoodItem> JOJA_COLA = FOODS.register("joja_cola", () -> new BaseFoodItem.ContainerFoodItem(FoodType.LOW, GLASS_BOTTLE)); //乔家可乐
    public static final DeferredItem<BaseFoodItem.ContainerFoodItem> CARTON_OF_MILK = FOODS.register("carton_of_milk", () -> new BaseFoodItem.ContainerFoodItem(FoodType.SENIOR, GLASS_BOTTLE)); //卡通牛奶
    public static final DeferredItem<BaseFoodItem.ContainerFoodItem> TEACUP = FOODS.register("teacup", () -> new BaseFoodItem.ContainerFoodItem(FoodType.LOW, GLASS_BOTTLE)); //一小杯茶
    public static final DeferredItem<BaseFoodItem.ContainerFoodItem> COFFEE = FOODS.register("coffee", () -> new BaseFoodItem.ContainerFoodItem(FoodType.SENIOR, GLASS_BOTTLE)); //咖啡
    public static final DeferredItem<BaseFoodItem.ContainerFoodItem> SAKE = FOODS.register("sake", () -> new BaseFoodItem.ContainerFoodItem(FoodType.SENIOR, GLASS_BOTTLE)); //清酒
    //鱼
    public static final DeferredItem<BaseFoodItem> SEA_BASS = FOODS.register("sea_bass", () -> new BaseFoodItem(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> ATLANTIC_COD = FOODS.register("atlantic_cod", () -> new BaseFoodItem(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> FROSTY_MINNOW = FOODS.register("frosty_minnow", () -> new BaseFoodItem(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> PISCES_FIN_COD = FOODS.register("pisces_fin_cod", () -> new BaseFoodItem(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> PARTIAL_MOUTH_FISH = FOODS.register("partial_mouth_fish", () -> new BaseFoodItem(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> ROCK_LOBSTER = FOODS.register("rock_lobster", () -> new BaseFoodItem(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> SHRIMP = FOODS.register("shrimp", () -> new BaseFoodItem(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> TR_SALMON = FOODS.register("tr_salmon", () -> new BaseFoodItem(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> TUNA = FOODS.register("tuna", () -> new BaseFoodItem(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> RED_SNAPPER = FOODS.register("red_snapper", () -> new BaseFoodItem(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> TROUT = FOODS.register("trout", () -> new BaseFoodItem(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> ARMORED_CAVE_FISH = FOODS.register("armored_cave_fish", () -> new BaseFoodItem(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> MIRROR_FISH = FOODS.register("mirror_fish", () -> new BaseFoodItem(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> STINKY_FISH = FOODS.register("stinky_fish", () -> new BaseFoodItem(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> NEON_GREASE_CARP = FOODS.register("neon_grease_carp", () -> new BaseFoodItem(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> DAMSEL_FISH = FOODS.register("damsel_fish", () -> new BaseFoodItem(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> EBONY_KOI = FOODS.register("ebony_koi", () -> new BaseFoodItem(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> SCARLET_TIGER_FISH = FOODS.register("scarlet_tiger_fish", () -> new BaseFoodItem(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> BLOODY_PIRANHAS = FOODS.register("bloody_piranhas", () -> new BaseFoodItem(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> PRINCESS_FISH = FOODS.register("princess_fish", () -> new BaseFoodItem(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> COLORFUL_MINERAL_FISH = FOODS.register("colorful_mineral_fish", () -> new BaseFoodItem(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> CHAOS_FISH = FOODS.register("chaos_fish", () -> new BaseFoodItem(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> MOTTLED_OILFISH = FOODS.register("mottled_oilfish", () -> new BaseFoodItem(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> GOLDEN_CARP = FOODS.register("golden_carp", () -> new BaseFoodItem(FoodType.GOLDEN_CARP));
    public static final DeferredItem<BaseFoodItem.FireproofFoodItem> OBSIDIAN_FISH = FOODS.register("obsidian_fish", () -> new BaseFoodItem.FireproofFoodItem(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem.FireproofFoodItem> FLASHFIN_KOI = FOODS.register("flashfin_koi", () -> new BaseFoodItem.FireproofFoodItem(FoodType.FISH));
    //节日特有
    public static final DeferredItem<BaseFoodItem.FireproofFoodItem > ZONGZI = FOODS.register("zongzi", () -> new BaseFoodItem.FireproofFoodItem(FoodType.LOW));

    public static final DeferredItem<BaseFoodItem.FireproofFoodItem> HONEY_MOONCAKES = FOODS.register("honey_mooncakes", () -> new BaseFoodItem.FireproofFoodItem(FoodType.MEDIUM));
    public static final DeferredItem<BaseFoodItem.FireproofFoodItem> HONEY_MOONCAKES_CHUNKS = FOODS.register("honey_mooncakes_chunks", () -> new BaseFoodItem.FireproofFoodItem(FoodType.MOONCAKES));
    public static final DeferredItem<BaseFoodItem.FireproofFoodItem> EGG_YOLK_MOONCAKES = FOODS.register("egg_yolk_mooncakes", () -> new BaseFoodItem.FireproofFoodItem(FoodType.MEDIUM));
    public static final DeferredItem<BaseFoodItem.FireproofFoodItem> EGG_YOLK_MOONCAKES_CHUNKS = FOODS.register("egg_yolk_mooncakes_chunks", () -> new BaseFoodItem.FireproofFoodItem(FoodType.MEDIUM));

    public static final DeferredItem<BaseFoodItem.FireproofFoodItem> LONGEVITY_NOODLES = FOODS.register("longevity_noodles", () -> new BaseFoodItem.FireproofFoodItem(FoodType.LOW));
}
