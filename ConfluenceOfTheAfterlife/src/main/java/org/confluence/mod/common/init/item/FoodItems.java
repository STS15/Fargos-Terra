package org.confluence.mod.common.init.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.UseAnim;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.confluence.mod.Confluence;
import org.confluence.mod.common.item.food.BaseFoodItem;
import org.confluence.mod.common.item.food.FoodType;

import java.util.function.Consumer;

import static net.minecraft.world.item.Items.BOWL;
import static net.minecraft.world.item.Items.GLASS_BOTTLE;

public class FoodItems {
    public static final DeferredRegister.Items FOODS = DeferredRegister.createItems(Confluence.MODID);
    //常规食物
    public static final DeferredItem<BaseFoodItem> COOKED_SHRIMP = registerFood("cooked_shrimp", builder -> builder.initialize().food(FoodType.MEDIUM));
    public static final DeferredItem<BaseFoodItem> ESCARGOT = registerFood("escargot", builder -> builder.initialize().food(FoodType.MEDIUM)); //法式蜗牛
    public static final DeferredItem<BaseFoodItem> FROGGLE_BUNWICH = registerFood("froggle_bunwich", builder -> builder.initialize().food(FoodType.MEDIUM)); //面包夹田鸡
    public static final DeferredItem<BaseFoodItem> GOLDEN_DELIGHT = registerFood("golden_delight", builder -> builder.initialize().food(FoodType.GOLDEN_CARP)); //金美味
    public static final DeferredItem<BaseFoodItem> GRILLED_SQUIRREL = registerFood("grilled_squirrel", builder -> builder.initialize().food(FoodType.MEAT)); //松鼠尾
    public static final DeferredItem<BaseFoodItem> LOBSTER_TAIL = registerFood("lobster_tail", builder -> builder.initialize().food(FoodType.SENIOR)); //龙虾尾
    public static final DeferredItem<BaseFoodItem> MONSTER_LASAGNA = registerFood("monster_lasagna", builder -> builder.initialize().food(FoodType.SENIOR)); //怪物千层面
    public static final DeferredItem<BaseFoodItem> SASHIMI = registerFood("sashimi", builder -> builder.initialize().food(FoodType.MEDIUM)); //生鱼片
    public static final DeferredItem<BaseFoodItem> ROASTED_BIRD = registerFood("roasted_bird", builder -> builder.initialize().food(FoodType.MEAT)); //烤鸟腿
    public static final DeferredItem<BaseFoodItem> ROASTED_DUCK = registerFood("roasted_duck", builder -> builder.initialize().food(FoodType.MEAT)); //鸭肉
    public static final DeferredItem<BaseFoodItem> SAUTEED_FROG_LEGS = registerFood("sauteed_frog_legs", builder -> builder.initialize().food(FoodType.MEAT)); //爆炒青蛙腿
    public static final DeferredItem<BaseFoodItem> SEAFOOD_DINNER = registerFood("seafood_dinner", builder -> builder.initialize().food(FoodType.SENIOR)); //海鲜大餐
    public static final DeferredItem<BaseFoodItem> BACON = registerFood("bacon", builder -> builder.initialize().food(FoodType.SENIOR)); //培根
    public static final DeferredItem<BaseFoodItem> BANANA_SPLIT = registerFood("banana_split", builder -> builder.initialize().food(FoodType.SENIOR)); //香蕉船
    public static final DeferredItem<BaseFoodItem> BBQ_RIBS = registerFood("bbq_ribs", builder -> builder.initialize().food(FoodType.SENIOR)); //炭烧排骨
    public static final DeferredItem<BaseFoodItem> BURGER = registerFood("burger", builder -> builder.initialize().food(FoodType.SENIOR)); //汉堡
    public static final DeferredItem<BaseFoodItem> CHICKEN_NUGGET = registerFood("chicken_nugget", builder -> builder.initialize().food(FoodType.SENIOR)); //鸡块
    public static final DeferredItem<BaseFoodItem> CHOCOLATE_CHIP_COOKIE = registerFood("chocolate_chip_cookie", builder -> builder.initialize().food(FoodType.SENIOR)); //巧克力大曲奇
    public static final DeferredItem<BaseFoodItem> FRIED_EGG = registerFood("fried_egg", builder -> builder.initialize().food(FoodType.MEAT)); //煎蛋
    public static final DeferredItem<BaseFoodItem> FRIES = registerFood("fries", builder -> builder.initialize().food(FoodType.SENIOR)); //薯条
    public static final DeferredItem<BaseFoodItem> HOTDOG = registerFood("hotdog", builder -> builder.initialize().food(FoodType.SENIOR)); //热狗
    public static final DeferredItem<BaseFoodItem> PIZZA = registerFood("pizza", builder -> builder.initialize().food(FoodType.SENIOR)); //披萨
    public static final DeferredItem<BaseFoodItem> POTATO_CHIPS = registerFood("potato_chips", builder -> builder.initialize().food(FoodType.SENIOR)); //薯片
    public static final DeferredItem<BaseFoodItem> SHRIMP_PO_BOY = registerFood("shrimp_po_boy", builder -> builder.initialize().food(FoodType.SENIOR)); //鲨宝男孩
    public static final DeferredItem<BaseFoodItem> SHUCKED_OYSTER = registerFood("shucked_oyster", builder -> builder.initialize().food(FoodType.LOW)); //去壳牡蛎
    public static final DeferredItem<BaseFoodItem> SPAGHETTI = registerFood("spaghetti", builder -> builder.initialize().food(FoodType.SENIOR)); //意大利面
    public static final DeferredItem<BaseFoodItem> SURPER_STEAK = registerFood("surper_steak", builder -> builder.initialize().food(FoodType.SENIOR)); //超大肉排
    public static final DeferredItem<BaseFoodItem> CHRISTMAS_PUDDING = registerFood("christmas_pudding", builder -> builder.initialize().food(FoodType.SENIOR)); //圣诞布丁
    public static final DeferredItem<BaseFoodItem> GINGERBREAD_COOKIE = registerFood("gingerbread_cookie", builder -> builder.initialize().food(FoodType.SENIOR)); //姜饼人
    public static final DeferredItem<BaseFoodItem> SUGAR_COOKIE = registerFood("sugar_cookie", builder -> builder.initialize().food(FoodType.SENIOR)); //糖曲奇
    public static final DeferredItem<BaseFoodItem> MARSHMALLOW = registerFood("marshmallow", builder -> builder.initialize().food(FoodType.LOW)); //棉花糖
    public static final DeferredItem<BaseFoodItem> COOKED_MARSHMALLOW = registerFood("cooked_marshmallow", builder -> builder.initialize().food(FoodType.MEDIUM)); //烤棉花糖
    public static final DeferredItem<BaseFoodItem> PAD_THAI = registerFood("pad_thai", builder -> builder.initialize().food(FoodType.SENIOR)); //泰式炒河粉
    public static final DeferredItem<BaseFoodItem> FISH_AND_MUSHROOM_SOUP = registerFood("fish_and_mushroom_soup", builder -> builder.initialize().food(FoodType.MEDIUM).craftRemainder(BOWL).duration(stack -> 20).drinkingSound(sound -> SoundEvents.HONEY_DRINK).eatingSound(sound -> SoundEvents.HONEY_DRINK).useAnim(useAnim -> UseAnim.DRINK)); //鱼菇汤
    public static final DeferredItem<BaseFoodItem> FRUIT_SALAD = registerFood("fruit_salad", builder -> builder.initialize().food(FoodType.HIGH).craftRemainder(GLASS_BOTTLE).duration(stack -> 20).drinkingSound(sound -> SoundEvents.HONEY_DRINK).eatingSound(sound -> SoundEvents.HONEY_DRINK).useAnim(useAnim -> UseAnim.DRINK)); //水果沙拉
    public static final DeferredItem<BaseFoodItem> GRUB_SOUP = registerFood("grub_soup", builder -> builder.initialize().food(FoodType.HIGH).craftRemainder(BOWL).duration(stack -> 20).drinkingSound(sound -> SoundEvents.HONEY_DRINK).eatingSound(sound -> SoundEvents.HONEY_DRINK).useAnim(useAnim -> UseAnim.DRINK)); //蛆虫汤
    public static final DeferredItem<BaseFoodItem> NACHOS = registerFood("nachos", builder -> builder.initialize().food(FoodType.HIGH).craftRemainder(BOWL).duration(stack -> 20).drinkingSound(sound -> SoundEvents.HONEY_DRINK).eatingSound(sound -> SoundEvents.HONEY_DRINK).useAnim(useAnim -> UseAnim.DRINK)); //一碗玉米粒
    public static final DeferredItem<BaseFoodItem> PHO = registerFood("pho", builder -> builder.initialize().food(FoodType.MEDIUM).craftRemainder(BOWL).duration(stack -> 20).drinkingSound(sound -> SoundEvents.HONEY_DRINK).eatingSound(sound -> SoundEvents.HONEY_DRINK).useAnim(useAnim -> UseAnim.DRINK)); //河粉
    public static final DeferredItem<BaseFoodItem> CLOUD_DOUGH = registerFood("cloud_dough", builder -> builder.initialize().food(FoodType.LOW)); // 粗制云朵面包
    public static final DeferredItem<BaseFoodItem> CLOUD_BREAD = registerFood("cloud_bread", builder -> builder.initialize().food(FoodType.CLOUD_BREAD)); // 云朵面包
    public static final DeferredItem<BaseFoodItem> FLUTTERING_LAMB_CHOPS = registerFood("fluttering_lamb_chops", builder -> builder.initialize().food(FoodType.LOW));
    public static final DeferredItem<BaseFoodItem> COOKED_FLUTTERING_LAMB_CHOPS = registerFood("cooked_fluttering_lamb_chops", builder -> builder.initialize().food(FoodType.SENIOR));
    // 水果
    public static final DeferredItem<BaseFoodItem> APRICOT = registerFood("apricot", builder -> builder.initialize().food(FoodType.LOW));
    public static final DeferredItem<BaseFoodItem> BANANA = registerFood("banana", builder -> builder.initialize().food(FoodType.LOW));
    public static final DeferredItem<BaseFoodItem> CHERRY = registerFood("cherry", builder -> builder.initialize().food(FoodType.LOW));
    public static final DeferredItem<BaseFoodItem> COCONUT = registerFood("coconut", builder -> builder.initialize().food(FoodType.LOW));
    public static final DeferredItem<BaseFoodItem> DRAGON_FRUIT = registerFood("dragon_fruit", builder -> builder.initialize().food(FoodType.LOW));
    public static final DeferredItem<BaseFoodItem> GRAPE_FRUIT = registerFood("grape_fruit", builder -> builder.initialize().food(FoodType.LOW));
    public static final DeferredItem<BaseFoodItem> LEMON = registerFood("lemon", builder -> builder.initialize().food(FoodType.LOW));
    public static final DeferredItem<BaseFoodItem> MANGO = registerFood("mango", builder -> builder.initialize().food(FoodType.LOW));
    public static final DeferredItem<BaseFoodItem> PEACH = registerFood("peach", builder -> builder.initialize().food(FoodType.LOW));
    public static final DeferredItem<BaseFoodItem> PINEAPPLE = registerFood("pineapple", builder -> builder.initialize().food(FoodType.LOW));
    public static final DeferredItem<BaseFoodItem> PLUM = registerFood("plum", builder -> builder.initialize().food(FoodType.LOW));
    public static final DeferredItem<BaseFoodItem> GRAPE = registerFood("grape", builder -> builder.initialize().food(FoodType.SENIOR));//葡萄
    public static final DeferredItem<BaseFoodItem> SPICY_PEPPER = registerFood("spicy_pepper", builder -> builder.initialize().food(FoodType.LOW));
    public static final DeferredItem<BaseFoodItem> STAR_FRUIT = registerFood("star_fruit", builder -> builder.initialize().food(FoodType.LOW));
    public static final DeferredItem<BaseFoodItem> POMEGRANATE = registerFood("pomegranate", builder -> builder.initialize().food(FoodType.LOW));
    public static final DeferredItem<BaseFoodItem> RAMBUTAN = registerFood("rambutan", builder -> builder.initialize().food(FoodType.LOW));
    public static final DeferredItem<BaseFoodItem> BLOOD_ORANGE = registerFood("blood_orange", builder -> builder.initialize().food(FoodType.LOW));
    public static final DeferredItem<BaseFoodItem> ELDERBERRY = registerFood("elderberry", builder -> builder.initialize().food(FoodType.LOW));
    public static final DeferredItem<BaseFoodItem> BLACKCURRANT = registerFood("blackcurrant", builder -> builder.initialize().food(FoodType.LOW));
    //饮料
    public static final DeferredItem<BaseFoodItem> FRUIT_JUICE = registerFood("fruit_juice", builder -> builder.initialize().food(FoodType.MEDIUM).craftRemainder(GLASS_BOTTLE).duration(duration -> 20).drinkingSound(sound -> SoundEvents.HONEY_DRINK).eatingSound(sound -> SoundEvents.HONEY_DRINK).useAnim(useAnim -> UseAnim.DRINK)); //混合果汁
    public static final DeferredItem<BaseFoodItem> APPLE_JUICE = registerFood("apple_juice", builder -> builder.initialize().food(FoodType.MEDIUM).craftRemainder(GLASS_BOTTLE).duration(duration -> 20).drinkingSound(sound -> SoundEvents.HONEY_DRINK).eatingSound(sound -> SoundEvents.HONEY_DRINK).useAnim(useAnim -> UseAnim.DRINK));
    public static final DeferredItem<BaseFoodItem> FROZEN_BANANA_DAIQUIRI = registerFood("frozen_banana_daiquiri", builder -> builder.initialize().food(FoodType.MEDIUM).craftRemainder(GLASS_BOTTLE).duration(duration -> 20).drinkingSound(sound -> SoundEvents.HONEY_DRINK).eatingSound(sound -> SoundEvents.HONEY_DRINK).useAnim(useAnim -> UseAnim.DRINK)); //香蕉圣代
    public static final DeferredItem<BaseFoodItem> GRAPE_JUICE = registerFood("grape_juice", builder -> builder.initialize().food(FoodType.GOLDEN_CARP).craftRemainder(GLASS_BOTTLE).duration(duration -> 20).drinkingSound(sound -> SoundEvents.HONEY_DRINK).eatingSound(sound -> SoundEvents.HONEY_DRINK).useAnim(useAnim -> UseAnim.DRINK)); //葡萄汁
    public static final DeferredItem<BaseFoodItem> LEMONADE = registerFood("lemonade", builder -> builder.initialize().food(FoodType.MEDIUM).craftRemainder(GLASS_BOTTLE).duration(duration -> 20).drinkingSound(sound -> SoundEvents.HONEY_DRINK).eatingSound(sound -> SoundEvents.HONEY_DRINK).useAnim(useAnim -> UseAnim.DRINK)); //柠檬水
    public static final DeferredItem<BaseFoodItem> PEACH_SANGRIA = registerFood("peach_sangria", builder -> builder.initialize().food(FoodType.SENIOR).craftRemainder(GLASS_BOTTLE).duration(duration -> 20).drinkingSound(sound -> SoundEvents.HONEY_DRINK).eatingSound(sound -> SoundEvents.HONEY_DRINK).useAnim(useAnim -> UseAnim.DRINK)); //桃子桑格利亚汽酒
    public static final DeferredItem<BaseFoodItem> PIÑA_COLADA = registerFood("pina_colada", builder -> builder.initialize().food(FoodType.MEDIUM).craftRemainder(GLASS_BOTTLE).duration(duration -> 20).drinkingSound(sound -> SoundEvents.HONEY_DRINK).eatingSound(sound -> SoundEvents.HONEY_DRINK).useAnim(useAnim -> UseAnim.DRINK)); //皮尼亚·科拉达
    public static final DeferredItem<BaseFoodItem> PRISMATIC_PUNCH = registerFood("prismatic_punch", builder -> builder.initialize().food(FoodType.SENIOR).craftRemainder(GLASS_BOTTLE).duration(duration -> 20).drinkingSound(sound -> SoundEvents.HONEY_DRINK).eatingSound(sound -> SoundEvents.HONEY_DRINK).useAnim(useAnim -> UseAnim.DRINK)); //味蕾冲击者
    public static final DeferredItem<BaseFoodItem> TROPICAL_SMOOTHIE = registerFood("tropical_smoothie", builder -> builder.initialize().food(FoodType.SENIOR).craftRemainder(GLASS_BOTTLE).duration(duration -> 20).drinkingSound(sound -> SoundEvents.HONEY_DRINK).eatingSound(sound -> SoundEvents.HONEY_DRINK).useAnim(useAnim -> UseAnim.DRINK)); //热带冰沙
    public static final DeferredItem<BaseFoodItem> SMOOTHIE_OF_DARKNESS = registerFood("smoothie_of_darkness", builder -> builder.initialize().food(FoodType.MEDIUM).craftRemainder(GLASS_BOTTLE).duration(duration -> 20).drinkingSound(sound -> SoundEvents.HONEY_DRINK).eatingSound(sound -> SoundEvents.HONEY_DRINK).useAnim(useAnim -> UseAnim.DRINK)); //黑暗奶昔
    public static final DeferredItem<BaseFoodItem> BLOODY_MOSCATO = registerFood("bloody_moscato", builder -> builder.initialize().food(FoodType.MEDIUM).craftRemainder(GLASS_BOTTLE).duration(duration -> 20).drinkingSound(sound -> SoundEvents.HONEY_DRINK).eatingSound(sound -> SoundEvents.HONEY_DRINK).useAnim(useAnim -> UseAnim.DRINK));
    public static final DeferredItem<BaseFoodItem> CREAM_SODA = registerFood("cream_soda", builder -> builder.initialize().food(FoodType.SENIOR).craftRemainder(GLASS_BOTTLE).duration(duration -> 20).drinkingSound(sound -> SoundEvents.HONEY_DRINK).eatingSound(sound -> SoundEvents.HONEY_DRINK).useAnim(useAnim -> UseAnim.DRINK)); //奶油苏打
    public static final DeferredItem<BaseFoodItem> ICE_CREAM = registerFood("ice_cream", builder -> builder.initialize().food(FoodType.SENIOR).craftRemainder(GLASS_BOTTLE).duration(duration -> 20).drinkingSound(sound -> SoundEvents.HONEY_DRINK).eatingSound(sound -> SoundEvents.HONEY_DRINK).useAnim(useAnim -> UseAnim.DRINK)); //冰淇淋
    public static final DeferredItem<BaseFoodItem> MILKSHAKE = registerFood("milkshake", builder -> builder.initialize().food(FoodType.SENIOR).craftRemainder(GLASS_BOTTLE).duration(duration -> 20).drinkingSound(sound -> SoundEvents.HONEY_DRINK).eatingSound(sound -> SoundEvents.HONEY_DRINK).useAnim(useAnim -> UseAnim.DRINK)); //奶昔
    //不掉落瓶子的饮料
    public static final DeferredItem<BaseFoodItem> JOJA_COLA = registerFood("joja_cola", builder -> builder.initialize().food(FoodType.LOW).craftRemainder(GLASS_BOTTLE).duration(duration -> 20).drinkingSound(sound -> SoundEvents.HONEY_DRINK).eatingSound(sound -> SoundEvents.HONEY_DRINK).useAnim(useAnim -> UseAnim.DRINK)); //乔家可乐
    public static final DeferredItem<BaseFoodItem> CARTON_OF_MILK = registerFood("carton_of_milk", builder -> builder.initialize().food(FoodType.SENIOR).craftRemainder(GLASS_BOTTLE).duration(duration -> 20).drinkingSound(sound -> SoundEvents.HONEY_DRINK).eatingSound(sound -> SoundEvents.HONEY_DRINK).useAnim(useAnim -> UseAnim.DRINK)); //卡通牛奶
    public static final DeferredItem<BaseFoodItem> TEACUP = registerFood("teacup", builder -> builder.initialize().food(FoodType.LOW).craftRemainder(GLASS_BOTTLE).duration(duration -> 20).drinkingSound(sound -> SoundEvents.HONEY_DRINK).eatingSound(sound -> SoundEvents.HONEY_DRINK).useAnim(useAnim -> UseAnim.DRINK)); //一小杯茶
    public static final DeferredItem<BaseFoodItem> COFFEE = registerFood("coffee", builder -> builder.initialize().food(FoodType.SENIOR).craftRemainder(GLASS_BOTTLE).duration(duration -> 20).drinkingSound(sound -> SoundEvents.HONEY_DRINK).eatingSound(sound -> SoundEvents.HONEY_DRINK).useAnim(useAnim -> UseAnim.DRINK)); //咖啡
    public static final DeferredItem<BaseFoodItem> SAKE = registerFood("sake", builder -> builder.initialize().food(FoodType.SENIOR).craftRemainder(GLASS_BOTTLE).duration(duration -> 20).drinkingSound(sound -> SoundEvents.HONEY_DRINK).eatingSound(sound -> SoundEvents.HONEY_DRINK).useAnim(useAnim -> UseAnim.DRINK)); //清酒
    //鱼
    public static final DeferredItem<BaseFoodItem> SEA_BASS = registerFood("sea_bass", builder -> builder.initialize().food(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> ATLANTIC_COD = registerFood("atlantic_cod", builder -> builder.initialize().food(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> FROSTY_MINNOW = registerFood("frosty_minnow", builder -> builder.initialize().food(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> PISCES_FIN_COD = registerFood("pisces_fin_cod", builder -> builder.initialize().food(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> PARTIAL_MOUTH_FISH = registerFood("partial_mouth_fish", builder -> builder.initialize().food(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> ROCK_LOBSTER = registerFood("rock_lobster", builder -> builder.initialize().food(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> SHRIMP = registerFood("shrimp", builder -> builder.initialize().food(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> TR_SALMON = registerFood("tr_salmon", builder -> builder.initialize().food(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> TUNA = registerFood("tuna", builder -> builder.initialize().food(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> RED_SNAPPER = registerFood("red_snapper", builder -> builder.initialize().food(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> TROUT = registerFood("trout", builder -> builder.initialize().food(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> ARMORED_CAVE_FISH = registerFood("armored_cave_fish", builder -> builder.initialize().food(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> MIRROR_FISH = registerFood("mirror_fish", builder -> builder.initialize().food(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> STINKY_FISH = registerFood("stinky_fish", builder -> builder.initialize().food(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> NEON_GREASE_CARP = registerFood("neon_grease_carp", builder -> builder.initialize().food(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> DAMSEL_FISH = registerFood("damsel_fish", builder -> builder.initialize().food(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> EBONY_KOI = registerFood("ebony_koi", builder -> builder.initialize().food(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> SCARLET_TIGER_FISH = registerFood("scarlet_tiger_fish", builder -> builder.initialize().food(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> BLOODY_PIRANHAS = registerFood("bloody_piranhas", builder -> builder.initialize().food(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> PRINCESS_FISH = registerFood("princess_fish", builder -> builder.initialize().food(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> COLORFUL_MINERAL_FISH = registerFood("colorful_mineral_fish", builder -> builder.initialize().food(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> CHAOS_FISH = registerFood("chaos_fish", builder -> builder.initialize().food(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> MOTTLED_OILFISH = registerFood("mottled_oilfish", builder -> builder.initialize().food(FoodType.FISH));
    public static final DeferredItem<BaseFoodItem> GOLDEN_CARP = registerFood("golden_carp", builder -> builder.initialize().food(FoodType.GOLDEN_CARP));
    public static final DeferredItem<BaseFoodItem> OBSIDIAN_FISH = registerFood("obsidian_fish", builder -> builder.initialize().food(FoodType.FISH).isFireResistant());
    public static final DeferredItem<BaseFoodItem> FLASHFIN_KOI = registerFood("flashfin_koi", builder -> builder.initialize().food(FoodType.FISH).isFireResistant());
    //节日特有
    public static final DeferredItem<BaseFoodItem> ZONGZI = registerFood("zongzi", builder -> builder.initialize().food(FoodType.LOW).isFireResistant());

    public static final DeferredItem<BaseFoodItem> HONEY_MOONCAKES = registerFood("honey_mooncakes", builder -> builder.initialize().food(FoodType.MEDIUM).isFireResistant());
    public static final DeferredItem<BaseFoodItem> HONEY_MOONCAKES_CHUNKS = registerFood("honey_mooncakes_chunks", builder -> builder.initialize().food(FoodType.MOONCAKES).isFireResistant());
    public static final DeferredItem<BaseFoodItem> EGG_YOLK_MOONCAKES = registerFood("egg_yolk_mooncakes", builder -> builder.initialize().food(FoodType.MEDIUM).isFireResistant());
    public static final DeferredItem<BaseFoodItem> EGG_YOLK_MOONCAKES_CHUNKS = registerFood("egg_yolk_mooncakes_chunks", builder -> builder.initialize().food(FoodType.MEDIUM).isFireResistant());

    public static final DeferredItem<BaseFoodItem> LONGEVITY_NOODLES = registerFood("longevity_noodles", builder -> builder.initialize().food(FoodType.LOW));

    public static DeferredItem<BaseFoodItem> registerFood(String name, Consumer<BaseFoodItem.Builder> consumer) {
        return FOODS.register(name, () -> {
            BaseFoodItem.Builder builder = BaseFoodItem.builder(name);
            consumer.accept(builder);
            return builder.build();
        });
    }
}
