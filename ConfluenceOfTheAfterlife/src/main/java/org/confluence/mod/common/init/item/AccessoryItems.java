package org.confluence.mod.common.init.item;

import net.minecraft.data.tags.IntrinsicHolderTagsProvider;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.confluence.mod.Confluence;
import org.confluence.mod.common.entity.fishing.CurioFishingHook;
import org.confluence.mod.common.init.ModEffects;
import org.confluence.mod.common.item.accessory.FishingBobber;
import org.confluence.mod.common.item.accessory.LuckyCoin;
import org.confluence.terra_curio.common.component.AccessoriesComponent;
import org.confluence.terra_curio.common.component.ModRarity;
import org.confluence.terra_curio.common.item.curio.BaseCurioItem;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static org.confluence.terra_curio.common.component.ModRarity.*;

@SuppressWarnings("all")
public class AccessoryItems {
    public static final DeferredRegister.Items ACCESSORIES = DeferredRegister.createItems(Confluence.MODID);

    public static final Supplier<BaseCurioItem> ADHESIVE_BANDAGE = registerCurio("adhesive_bandage", builder -> builder.rarity(ModRarity.LIGHT_RED).effectImmunities(ModEffects.BLEEDING)),
            MEDICATED_BANDAGE = registerCurio("medicated_bandage", builder -> builder.rarity(PINK).effectImmunities(MobEffects.POISON, ModEffects.BLEEDING)),
            POCKET_MIRROR = registerCurio("pocket_mirror", builder -> builder.rarity(ORANGE).effectImmunities(ModEffects.STONED)),
            REFLECTIVE_SHADES = registerCurio("reflective_shades", builder -> builder.rarity(PINK).effectImmunities(MobEffects.BLINDNESS, ModEffects.STONED)),
            ARMOR_POLISH = registerCurio("armor_polish", builder -> builder.rarity(LIGHT_RED).effectImmunities(ModEffects.BROKEN_ARMOR)),
            ARMOR_BRACING = registerCurio("armor_bracing", builder -> builder.rarity(PINK).effectImmunities(MobEffects.WEAKNESS, ModEffects.BROKEN_ARMOR)),
            MEGAPHONE = registerCurio("megaphone", builder -> builder.rarity(LIGHT_RED).effectImmunities(ModEffects.SILENCED)),
            NAZAR = registerCurio("nazar", builder -> builder.rarity(GREEN).effectImmunities(ModEffects.CURSED)),
            COUNTERCURSE_MANTRA = registerCurio("countercurse_mantra", builder -> builder.rarity(LIGHT_RED).effectImmunities(ModEffects.SILENCED, ModEffects.CURSED));

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
    public static final Supplier<BaseCurioItem> LUCKY_COIN = registerDirectly("lucky_coin", name -> new LuckyCoin(BaseCurioItem.builder(name)
            .accessories(AccessoriesComponent.units(LuckyCoin.LUCKY$COIN))
            .attribute(Attributes.LUCK, 0.05, AttributeModifier.Operation.ADD_VALUE))); // 幸运币
    //GOLD_RING("gold_ring", GoldRing::new), // 金戒指
    //COIN_RING("coin_ring", CoinRing::new), // 钱币戒指
    /* 优惠卡 */
    /* 贪婪戒指 */
    /* 植物纤维绳索宝典 */
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
}
