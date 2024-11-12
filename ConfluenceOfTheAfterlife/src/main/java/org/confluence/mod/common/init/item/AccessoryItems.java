package org.confluence.mod.common.init.item;

import net.minecraft.data.tags.IntrinsicHolderTagsProvider;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Unit;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.confluence.mod.Confluence;
import org.confluence.mod.common.CommonConfigs;
import org.confluence.mod.common.entity.fishing.CurioFishingHook;
import org.confluence.mod.common.init.ModEffects;
import org.confluence.mod.common.init.ModTags;
import org.confluence.mod.common.item.accessory.FishingBobber;
import org.confluence.mod.util.ModUtils;
import org.confluence.terra_curio.api.primitive.FloatValue;
import org.confluence.terra_curio.api.primitive.UnitValue;
import org.confluence.terra_curio.api.primitive.ValueType;
import org.confluence.terra_curio.common.component.ModRarity;
import org.confluence.terra_curio.common.item.curio.BaseCurioItem;
import org.confluence.terra_curio.util.TCUtils;

import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation.ADD_VALUE;
import static org.confluence.terra_curio.common.component.AccessoriesComponent.of;
import static org.confluence.terra_curio.common.component.AccessoriesComponent.units;
import static org.confluence.terra_curio.common.component.ModRarity.*;

@SuppressWarnings("all")
public class AccessoryItems {
    public static final DeferredRegister.Items ACCESSORIES = DeferredRegister.createItems(Confluence.MODID);

    public static final ValueType<Unit, UnitValue> LUCKY$COIN = ValueType.ofUnit("lucky_coin");
    public static final ValueType<Unit, UnitValue> SHEARS$DIG = ValueType.ofUnit("shears_dig");
    public static final ValueType<Unit, UnitValue> ICE$SAFE = ValueType.ofUnit("ice_safe");
    public static final ValueType<Unit, UnitValue> FALL$ON$EASY$CRASH$SAFE = ValueType.ofUnit("fall_on_easy_crash_safe"); // todo
    public static final ValueType<Float, FloatValue> COIN$PICKUP$RANGE = ValueType.ofFloat("coin_pickup_range", FloatValue.ADDITION, 2.0F);

    public static final Supplier<BaseCurioItem> ADHESIVE_BANDAGE = registerCurio("adhesive_bandage", builder -> builder.rarity(ModRarity.LIGHT_RED).accessories(of(ValueType.EFFECT_IMMUNITIES, Set.of(ModEffects.BLEEDING)))),
            MEDICATED_BANDAGE = registerCurio("medicated_bandage", builder -> builder.rarity(PINK).accessories(of(ValueType.EFFECT_IMMUNITIES, Set.of(MobEffects.POISON, ModEffects.BLEEDING)))),
            POCKET_MIRROR = registerCurio("pocket_mirror", builder -> builder.rarity(ORANGE).accessories(of(ValueType.EFFECT_IMMUNITIES, Set.of(ModEffects.STONED)))),
            REFLECTIVE_SHADES = registerCurio("reflective_shades", builder -> builder.rarity(PINK).accessories(of(ValueType.EFFECT_IMMUNITIES, Set.of(MobEffects.BLINDNESS, ModEffects.STONED)))),
            ARMOR_POLISH = registerCurio("armor_polish", builder -> builder.rarity(LIGHT_RED).accessories(of(ValueType.EFFECT_IMMUNITIES, Set.of(ModEffects.BROKEN_ARMOR)))),
            ARMOR_BRACING = registerCurio("armor_bracing", builder -> builder.rarity(PINK).accessories(of(ValueType.EFFECT_IMMUNITIES, Set.of(MobEffects.WEAKNESS, ModEffects.BROKEN_ARMOR)))),
            MEGAPHONE = registerCurio("megaphone", builder -> builder.rarity(LIGHT_RED).accessories(of(ValueType.EFFECT_IMMUNITIES, Set.of(ModEffects.SILENCED)))),
            NAZAR = registerCurio("nazar", builder -> builder.rarity(GREEN).accessories(of(ValueType.EFFECT_IMMUNITIES, Set.of(ModEffects.CURSED)))),
            COUNTERCURSE_MANTRA = registerCurio("countercurse_mantra", builder -> builder.rarity(LIGHT_RED).accessories(of(ValueType.EFFECT_IMMUNITIES, Set.of(ModEffects.SILENCED, ModEffects.CURSED))));

    public static final Supplier<BaseCurioItem> NATURES_GIFT = registerCurio("natures_gift", builder -> builder.rarity(ORANGE)/*TODO: 减魔耗*/);

    public static final Supplier<FishingBobber> FISHING_BOBBER = ACCESSORIES.register("fishing_bobber", () -> new FishingBobber(CurioFishingHook.Variant.COMMON)), // 钓鱼浮标
            GLOWING_FISHING_BOBBER = ACCESSORIES.register("glowing_fishing_bobber", () -> new FishingBobber(CurioFishingHook.Variant.GLOWING)), // 发光钓鱼浮标
            LAVA_MOSS_FISHING_BOBBER = ACCESSORIES.register("lava_moss_fishing_bobber", () -> new FishingBobber(CurioFishingHook.Variant.LAVA)), // 熔岩苔藓钓鱼浮标
            HELIUM_MOSS_FISHING_BOBBER = ACCESSORIES.register("helium_moss_fishing_bobber", () -> new FishingBobber(CurioFishingHook.Variant.HELIUM)), // 氦苔藓钓鱼浮标
            NEON_MOSS_FISHING_BOBBER = ACCESSORIES.register("neon_moss_fishing_bobber", () -> new FishingBobber(CurioFishingHook.Variant.NEON)), // 氖苔藓钓鱼浮标
            ARGON_MOSS_FISHING_BOBBER = ACCESSORIES.register("argon_moss_fishing_bobber", () -> new FishingBobber(CurioFishingHook.Variant.ARGON)), // 氩苔藓钓鱼浮标
            KRYPTON_MOSS_FISHING_BOBBER = ACCESSORIES.register("krypton_moss_fishing_bobber", () -> new FishingBobber(CurioFishingHook.Variant.KRYPTON)), // 氪苔藓钓鱼浮标
            XENON_MOSS_FISHING_BOBBER = ACCESSORIES.register("xenon_moss_fishing_bobber", () -> new FishingBobber(CurioFishingHook.Variant.XENON)); // 氙苔藓钓鱼浮标

    /* 向导巫毒娃娃 */
    /* 服装商巫毒娃娃 */
    public static final Supplier<BaseCurioItem> LUCKY_COIN = registerCurio("lucky_coin", builder -> builder.rarity(PINK).accessories(units(LUCKY$COIN)).attribute(Attributes.LUCK, 0.05, ADD_VALUE)), // 幸运币
            GOLD_RING = registerCurio("gold_ring", builder -> builder.rarity(PINK).accessories(of(COIN$PICKUP$RANGE, 14.67F))), // 金戒指
            COIN_RING = registerCurio("coin_ring", builder -> builder.rarity(PINK).accessories(units(LUCKY$COIN), of(COIN$PICKUP$RANGE, 14.67F)).attribute(Attributes.LUCK, 0.05, ADD_VALUE)), // 钱币戒指
    /* 优惠卡 */
    /* 贪婪戒指 */
            GUIDE_TO_PLANT_FIBER_CORDAGE = registerCurio("guide_to_plant_fiber_cordage", builder -> builder.accessories(units(SHEARS$DIG))); // 植物纤维绳索宝典
    /* 水母项链 */
    /* 收音机 */
    //SPECTRE_GOGGLES("spectre_goggles", SpectreGoggles::new), // 幽灵护目镜
    /* 炫彩斗篷 */

    /* 召唤师徽章 */
    /* 学徒围巾 */
    /* 侍卫护盾 */
    /* 女猎人圆盾 */
    /* 武僧腰带 */
    /* 大力士甲虫 */
    /* 死灵卷轴 */
    /* 甲虫莎草纸 */
    /* 矮人项链 */

    public static Supplier<BaseCurioItem> registerCurio(String name, Consumer<BaseCurioItem.Builder> consumer) {
        return ACCESSORIES.register(name, () -> {
            BaseCurioItem.Builder builder = BaseCurioItem.builder(name);
            consumer.accept(builder);
            return builder.build();
        });
    }

    public static Supplier<BaseCurioItem> registerDirectly(String name, Function<String, BaseCurioItem> function) {
        return ACCESSORIES.register(name, () -> function.apply(name));
    }

    public static void acceptTag(IntrinsicHolderTagsProvider.IntrinsicTagAppender<Item> tag) {
        for (DeferredHolder<Item, ? extends Item> accessory : ACCESSORIES.getEntries()) tag.add(accessory.get());
    }

    public static void applyCoinPickup(Player player) {
        float range = TCUtils.getAccessoriesValue(player, COIN$PICKUP$RANGE);
        if (range <= 0.0) return;
        player.level().getEntitiesOfClass(
                ItemEntity.class,
                new AABB(player.getOnPos()).inflate(range),
                itemEntity -> !itemEntity.hasPickUpDelay() && itemEntity.getItem().is(ModTags.Items.COIN)
        ).forEach(itemEntity -> {
            if (itemEntity.isRemoved()) return;
            Vec3 vec3 = player.position()
                    .subtract(itemEntity.getX(), itemEntity.getY(), itemEntity.getZ())
                    .normalize().scale(0.05F).add(0, 0.04F, 0);
            itemEntity.addDeltaMovement(vec3);
            itemEntity.move(MoverType.SELF, itemEntity.getDeltaMovement());
        });
    }

    public static void applyLuckyCoin(Player player, Entity target) {
        if (!CommonConfigs.DROP_MONEY.get()) return;
        RandomSource randomSource = player.getRandom();
        if (TCUtils.hasAccessoriesType(player, LUCKY$COIN) && randomSource.nextFloat() < 0.2F) {
            Item item;
            float a = randomSource.nextFloat();
            if (a < 0.01F) {
                item = ModItems.GOLDEN_COIN.get();
            } else if (a < 0.099F) {
                item = ModItems.SILVER_COIN.get();
            } else {
                item = ModItems.COPPER_COIN.get();
            }
            ItemStack itemStack = item.getDefaultInstance();
            itemStack.setCount(randomSource.nextInt(1, 3));
            ModUtils.createItemEntity(itemStack, target.getX(), target.getY(), target.getZ(), player.level(), 0);
        }
    }
}
