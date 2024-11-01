package org.confluence.mod.common.init.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.confluence.mod.Confluence;
import org.confluence.mod.common.init.ModTiers;
import org.confluence.mod.common.item.sword.*;
import org.confluence.mod.common.item.sword.stagedy.ProjectileStrategy;
import org.confluence.mod.common.item.sword.stagedy.projectile.AbstractProjContainer;
import org.confluence.terra_curio.common.component.ModRarity;

import java.util.function.Consumer;
import java.util.function.Supplier;

import static org.confluence.mod.common.item.sword.stagedy.EffectStrategy.BLOOD_BUTCHERED_EFFECT;

public class SwordItems {
    public static final DeferredRegister.Items SWORDS = DeferredRegister.createItems(Confluence.MODID);

    public static final DeferredItem<SwordItem> COPPER_SHORT_SWORD = registerShortSword("copper_short_sword", ModTiers.COPPER, 2, 3);
    public static final DeferredItem<SwordItem> TIN_SHORT_SWORD = registerShortSword("tin_short_sword", ModTiers.TIN, 3, 3);
    public static final DeferredItem<SwordItem> LEAD_SHORT_SWORD = registerShortSword("lead_short_sword", ModTiers.LEAD, 3, 3);
    public static final DeferredItem<SwordItem> SILVER_SHORT_SWORD = registerShortSword("silver_short_sword", ModTiers.SILVER, 4, 3);
    public static final DeferredItem<SwordItem> TUNGSTEN_SHORT_SWORD = registerShortSword("tungsten_short_sword", ModTiers.TUNGSTEN, 4, 3);
    public static final DeferredItem<SwordItem> GOLDEN_SHORT_SWORD = registerShortSword("golden_short_sword", ModTiers.GOLD, 5, 3);
    public static final DeferredItem<SwordItem> PLATINUM_SHORT_SWORD = registerShortSword("platinum_short_sword", Tiers.DIAMOND, 5, 3);

    public static final DeferredItem<SwordItem> CACTUS_SWORD = registerBoardSword("cactus_sword", ModTiers.CACTUS, 4, 1.6F);
    public static final DeferredItem<SwordItem> COPPER_BOARD_SWORD = registerBoardSword("copper_board_sword", ModTiers.COPPER, 4, 1.6F);
    public static final DeferredItem<SwordItem> TIN_BOARD_SWORD = registerBoardSword("tin_board_sword", ModTiers.TIN, 4, 1.6F);
    public static final DeferredItem<SwordItem> LEAD_BOARD_SWORD = registerBoardSword("lead_board_sword", ModTiers.LEAD, 5, 1.6F);
    public static final DeferredItem<SwordItem> SILVER_BOARD_SWORD = registerBoardSword("silver_board_sword", ModTiers.SILVER, 5, 1.6F);
    public static final DeferredItem<SwordItem> TUNGSTEN_BOARD_SWORD = registerBoardSword("tungsten_board_sword", ModTiers.TUNGSTEN, 6, 1.6F);
    public static final DeferredItem<SwordItem> GOLDEN_BOARD_SWORD = registerBoardSword("golden_board_sword", ModTiers.GOLD, 7, 1.6F);
    public static final DeferredItem<SwordItem> PLATINUM_BOARD_SWORD = registerBoardSword("platinum_board_sword", Tiers.DIAMOND, 7, 1.6F);

    public static final DeferredItem<SwordItem> TERRAGRIM = registerNormalSword("terragrim", ModTiers.TITANIUM, 1, 5.2F, ModRarity.ORANGE);

    public static final DeferredItem<SwordItem> LIGHTS_BANE = registerEffectiveSword("lights_bane",ModTiers.TITANIUM, 5, -0.1F, ModRarity.BLUE,new MobEffectInstance(MobEffects.GLOWING,5 * 20)); //TODO 魔光剑,暂时发光效果
    public static final DeferredItem<SwordItem> BLOOD_BUTCHERER = registerEffectiveSword("blood_butchere",ModTiers.TITANIUM, 7, -2.7F,ModRarity.BLUE,BLOOD_BUTCHERED_EFFECT);

    public static final DeferredItem<SwordItem> ICE_BLADE = registerProjectileSword("ice_blade",ModTiers.TITANIUM, 5, -0.1F, ModRarity.BLUE,ProjectileStrategy.ICE_PROJ);
    public static final DeferredItem<SwordItem>STARFURY = registerProjectileSword("starfury",ModTiers.TITANIUM, 6, -0.1f, ModRarity.BLUE,ProjectileStrategy.STAR_FURY_PROJ);
    public static final DeferredItem<SwordItem> ENCHANTED_SWORD = registerProjectileSword("enchanted_sword",ModTiers.TITANIUM, 7, -0.2F, ModRarity.ORANGE,ProjectileStrategy.ENCHANTED_SWORD_PROJ);


/*
    RED_LIGHT_SABER("red_light_saber", LightSaber.Red::new),
    ORANGE_LIGHT_SABER("orange_light_saber", LightSaber.Orange::new),
    YELLOW_LIGHT_SABER("yellow_light_saber", LightSaber.Yellow::new),
    GREEN_LIGHT_SABER("green_light_saber", LightSaber.Green::new),
    BLUE_LIGHT_SABER("blue_light_saber", LightSaber.Blue::new),
    PURPLE_LIGHT_SABER("purple_light_saber", LightSaber.Purple::new),
    WHITE_LIGHT_SABER("white_light_saber", LightSaber.White::new),

    ICE_BLADE("ice_blade", () -> new ProjSwordItem(ModTiers.TITANIUM, 5, -0.1F, new Item.Properties().rarity(ModRarity.BLUE))),
    STARFURY("starfury", () -> new StarFurySword(ModTiers.TITANIUM, 6, -0.1f, new Item.Properties().rarity(ModRarity.GREEN))),// 新版星怒
    ENCHANTED_SWORD("enchanted_sword", () -> new EnchantedSwordItem(ModTiers.TITANIUM, 7, -0.2F, new Item.Properties().rarity(ModRarity.ORANGE))),
    VOLCANO("volcano", () -> new BigRegularBroadSwordItem(ModTiers.TITANIUM, 16, -1.4F, new Item.Properties().rarity(ModRarity.ORANGE))),


    TERRAGRIM("terragrim", TerragrimItem::new),
    // 其他剑
    FAKE_SWORD("fake_sword", () -> new RegularBroadSwordItem(ModTiers.CANDY, 0, -1.4F, new Item.Properties().rarity(ModRarity.GRAY))),
    CANDY_CANE_SWORD("candy_cane_sword", () -> new BigRegularBroadSwordItem(ModTiers.CANDY, 0, -1.4F, new Item.Properties().rarity(ModRarity.WHITE))),

    BREATHING_REED("breathing_reed", BreathingReed::new),
    UMBRELLA("umbrella", UmbrellaItem::new),
    TRAGIC_UMBRELLA("tragic_umbrella", UmbrellaItem::new),
    FALCON_BLADE("falcon_blade", () -> new ReversalBoardSwordItem(ModTiers.TITANIUM, 3, -1.45F, new Item.Properties().rarity(ModRarity.BLUE))),
    ZOMBIE_ARM("zombie_arm", () -> new RegularBroadSwordItem(ModTiers.TITANIUM, 3, -1.4F, new Item.Properties().rarity(ModRarity.WHITE))),
    MANDIBLE_BLADE("mandible_blade", () -> new RegularBroadSwordItem(ModTiers.TITANIUM, 4, -1.4F, new Item.Properties().rarity(ModRarity.GREEN))),
    BONE_SWORD("bone_sword", () -> new ReversalBoardSwordItem(ModTiers.TITANIUM, 5, -0.2F, new Item.Properties().rarity(ModRarity.ORANGE))),
    BAT_BAT("bat_bat", BatBatItem::new),
    PURPLE_CLUBBERFISH("purple_clubberfish", () -> new BigRegularBroadSwordItem(ModTiers.TITANIUM, 10, -3.5F, new Item.Properties().rarity(ModRarity.BLUE))),
    STYLISH_SCISSORS("stylish_scissors", () -> new RegularBroadSwordItem(ModTiers.TITANIUM, 3, -1.2F, new Item.Properties().rarity(ModRarity.GREEN))),
    EXOTIC_SCIMITAR("exotic_scimitar", () -> new ReversalBoardSwordItem(ModTiers.TITANIUM, 5, -0.3F, new Item.Properties().rarity(ModRarity.GREEN))),
    KATANA("katana", () -> new BigRegularBroadSwordItem(ModTiers.TITANIUM, 4, -0.3F, new Item.Properties().rarity(ModRarity.BLUE))),
    TENTACLE_MACE("tentacle_mace", () -> new TentacleMaceSword(ModTiers.TITANIUM, 5, -1.4F, new Item.Properties().rarity(ModRarity.GREEN))),


    CROWBAR("crowbar", CrowbarItem::new),
    DEVELOPER_SWORD("developer_sword", DeveloperSword::new);
    */


    public static DeferredItem<SwordItem> register(String name, Supplier<SwordItem> supplier) {
        return SWORDS.register(name, supplier);
    }

    public static DeferredItem<SwordItem> registerShortSword(String name, Tier tier, int rawDamage, float rawSpeed) {
        return SWORDS.register(name, () -> new ShortSwordItem(tier, ModRarity.WHITE, rawDamage, rawSpeed));
    }

    public static DeferredItem<SwordItem> registerBoardSword(String name, Tier tier, int rawDamage, float rawSpeed) {
        return SWORDS.register(name, () -> new BoardSwordItem(tier, ModRarity.WHITE, rawDamage, rawSpeed));
    }
    //无弹幕无效果的剑
    public static DeferredItem<SwordItem> registerNormalSword(String name, Tier tier, int attackDamage, float attackSpeed) {
        return SWORDS.register(name, () -> new BaseSwordItem(tier, ModRarity.WHITE, attackDamage, attackSpeed));
    }

    public static DeferredItem<SwordItem> registerNormalSword(String name, Tier tier, int attackDamage, float attackSpeed, ModRarity rarity) {
        return SWORDS.register(name, () -> new BaseSwordItem(tier, rarity, attackDamage, attackSpeed));
    }
    //只有弹幕的剑
    public static DeferredItem<SwordItem> registerProjectileSword(String name, Tier tier, int attackDamage, float attackSpeed, ModRarity rarity, AbstractProjContainer proj) {
        return SWORDS.register(name, () -> new ProjSwordItem(tier, rarity, attackDamage, attackSpeed,proj));
    }
    public static DeferredItem<SwordItem> registerEffectiveSword(String name, Tier tier, int attackDamage, float attackSpeed, ModRarity rarity, MobEffectInstance effects) {
        return SWORDS.register(name, () -> new EffectiveSword(tier, rarity, attackDamage, attackSpeed, effects));
    }
    public static DeferredItem<SwordItem> registerEffectiveSword(String name, Tier tier, int attackDamage, float attackSpeed, ModRarity rarity, Consumer<LivingEntity> effects) {
        return SWORDS.register(name, () -> new EffectiveSword(tier, rarity, attackDamage, attackSpeed, effects));
    }
}
