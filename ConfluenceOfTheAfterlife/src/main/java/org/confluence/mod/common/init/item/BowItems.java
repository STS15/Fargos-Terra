package org.confluence.mod.common.init.item;

import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.confluence.mod.Confluence;
import org.confluence.mod.client.gui.hud.ArrowInBowHud;
import org.confluence.mod.common.item.bow.DaedalusStormbow;
import org.confluence.mod.common.item.bow.TerraBowItem;
import org.confluence.mod.common.item.bow.ShortBowItem;
import org.confluence.terra_curio.common.component.ModRarity;

import java.util.function.Supplier;

/**
 * 弓箭位置修正参考{@link ArrowInBowHud}
 *
 */
public class BowItems {

    public static final DeferredRegister.Items BOWS = DeferredRegister.createItems(Confluence.MODID);

    // 短弓
    public static final DeferredItem<ShortBowItem> WOODEN_SHORT_BOW = BOWS.register("wooden_short_bow",() -> new ShortBowItem( 4.0F, 384));
    public static final DeferredItem<ShortBowItem> COPPER_SHORT_BOW = BOWS.register("copper_short_bow", () -> new ShortBowItem(4.5F, 640));
    public static final DeferredItem<ShortBowItem> TIN_SHORT_BOW = BOWS.register("tin_short_bow", () -> new ShortBowItem(4.5F, 768));
    public static final DeferredItem<ShortBowItem> IRON_SHORT_BOW = BOWS.register("iron_short_bow", () -> new ShortBowItem(5.0F, 896));
    public static final DeferredItem<ShortBowItem> LEAD_SHORT_BOW = BOWS.register("lead_short_bow", () -> new ShortBowItem(5.0F, 1024));
    public static final DeferredItem<ShortBowItem> SILVER_SHORT_BOW = BOWS.register("silver_short_bow", () -> new ShortBowItem(5.5F, 1152));
    public static final DeferredItem<ShortBowItem> TUNGSTEN_SHORT_BOW = BOWS.register("tungsten_short_bow", () -> new ShortBowItem(5.5F, 1280));
    public static final DeferredItem<ShortBowItem> GOLDEN_SHORT_BOW = BOWS.register("golden_short_bow", () -> new ShortBowItem(6.0F, 1408));
    public static final DeferredItem<ShortBowItem> PLATINUM_SHORT_BOW = BOWS.register("platinum_short_bow", () -> new ShortBowItem(6.0F, 1536));


    // 无效果蓄力弓
    public static final DeferredItem<TerraBowItem> COPPER_BOW = register("copper_bow", 3.0F, 640);
    public static final DeferredItem<TerraBowItem> TIN_BOW = register("tin_bow", 3.0F, 768);
    public static final DeferredItem<TerraBowItem> IRON_BOW = register("iron_bow", 3.5F, 896);
    public static final DeferredItem<TerraBowItem> LEAD_BOW = register("lead_bow", 3.5F, 1024);
    public static final DeferredItem<TerraBowItem> SILVER_BOW = register("silver_bow", 4.0F, 1152);
    public static final DeferredItem<TerraBowItem> TUNGSTEN_BOW = register("tungsten_bow", 4.0F, 1280);
    public static final DeferredItem<TerraBowItem> GOLDEN_BOW = register("golden_bow", 4.5F, 1408);
    public static final DeferredItem<TerraBowItem> PLATINUM_BOW = register("platinum_bow", 4.5F, 1536);


    // 代达罗斯风暴弓
    public static final DeferredItem<TerraBowItem> DAEDALUS_STORM_BOW = register("daedalus_storm_bow", ()->new DaedalusStormbow(1.5F, 2000, ModRarity.PURPLE));


    public static final DeferredItem<TerraBowItem> DEVELOPER_BOW = register("developer_bow", () -> new TerraBowItem(1F, 1536, ModRarity.MASTER,
            modifier->modifier.setCauseFire(200)
                    .setDamage(10)
                    .setSpeedFactor(2)
                    .setPenetration(2)
            ));


    public static DeferredItem<TerraBowItem> register(String name, Supplier<TerraBowItem> supplier) {
        return BOWS.register(name, supplier);
    }
    public static DeferredItem<TerraBowItem> register(String name, float damage, int durability, ModRarity rarity) {
        return register(name, () -> new TerraBowItem(damage, durability, rarity));
    }
    public static DeferredItem<TerraBowItem> register(String name, float damage, int durability) {
        return register(name, damage, durability, ModRarity.WHITE);
    }



    @OnlyIn(Dist.CLIENT)
    public static void registerProperties() {
        ResourceLocation pull = ResourceLocation.withDefaultNamespace("pull");
        ClampedItemPropertyFunction shortBowPull = (itemStack, clientLevel, living, speed) -> living != null && living.getUseItem() == itemStack ? (float) (itemStack.getUseDuration(living) - living.getUseItemRemainingTicks()) / ShortBowItem.MAX_DRAW_DURATION : 0.0F;
        ClampedItemPropertyFunction bowPull = (itemStack, clientLevel, living, speed) -> living != null && living.getUseItem() == itemStack ? (float) (itemStack.getUseDuration(living) - living.getUseItemRemainingTicks()) / BowItem.MAX_DRAW_DURATION : 0.0F;
        ResourceLocation pulling = ResourceLocation.withDefaultNamespace("pulling");
        ClampedItemPropertyFunction bowPulling = (itemStack, clientLevel, living, speed) -> living != null && living.isUsingItem() && living.getUseItem() == itemStack ? 1.0F : 0.0F;

        BOWS.getEntries().forEach(item -> {
            if(item.get() instanceof ShortBowItem) ItemProperties.register(item.get(), pull, shortBowPull);
            else ItemProperties.register(item.get(), pull, bowPull);
            ItemProperties.register(item.get(), pulling, bowPulling);
        });

        /*
        ItemProperties.register(WOODEN_SHORT_BOW.get(), pull, shortBowPull);
        ItemProperties.register(WOODEN_SHORT_BOW.get(), pulling, bowPulling);
        ItemProperties.register(COPPER_SHORT_BOW.get(), pull, shortBowPull);
        ItemProperties.register(COPPER_SHORT_BOW.get(), pulling, bowPulling);
        ItemProperties.register(TIN_SHORT_BOW.get(), pull, shortBowPull);
        ItemProperties.register(TIN_SHORT_BOW.get(), pulling, bowPulling);
        ItemProperties.register(IRON_SHORT_BOW.get(), pull, shortBowPull);
        ItemProperties.register(IRON_SHORT_BOW.get(), pulling, bowPulling);
        ItemProperties.register(LEAD_SHORT_BOW.get(), pull, shortBowPull);
        ItemProperties.register(LEAD_SHORT_BOW.get(), pulling, bowPulling);
        ItemProperties.register(SILVER_SHORT_BOW.get(), pull, shortBowPull);
        ItemProperties.register(SILVER_SHORT_BOW.get(), pulling, bowPulling);
        ItemProperties.register(TUNGSTEN_SHORT_BOW.get(), pull, shortBowPull);
        ItemProperties.register(TUNGSTEN_SHORT_BOW.get(), pulling, bowPulling);
        ItemProperties.register(GOLDEN_SHORT_BOW.get(), pull, shortBowPull);
        ItemProperties.register(GOLDEN_SHORT_BOW.get(), pulling, bowPulling);
        ItemProperties.register(PLATINUM_SHORT_BOW.get(), pull, shortBowPull);
        ItemProperties.register(PLATINUM_SHORT_BOW.get(), pulling, bowPulling);

        ItemProperties.register(COPPER_BOW.get(), pull, bowPull);
        ItemProperties.register(COPPER_BOW.get(), pulling, bowPulling);
        ItemProperties.register(TIN_BOW.get(), pull, bowPull);
        ItemProperties.register(TIN_BOW.get(), pulling, bowPulling);
        ItemProperties.register(IRON_BOW.get(), pull, bowPull);
        ItemProperties.register(IRON_BOW.get(), pulling, bowPulling);
        ItemProperties.register(LEAD_BOW.get(), pull, bowPull);
        ItemProperties.register(LEAD_BOW.get(), pulling, bowPulling);
        ItemProperties.register(SILVER_BOW.get(), pull, bowPull);
        ItemProperties.register(SILVER_BOW.get(), pulling, bowPulling);
        ItemProperties.register(TUNGSTEN_BOW.get(), pull, bowPull);
        ItemProperties.register(TUNGSTEN_BOW.get(), pulling, bowPulling);
        ItemProperties.register(GOLDEN_BOW.get(), pull, bowPull);
        ItemProperties.register(GOLDEN_BOW.get(), pulling, bowPulling);
        ItemProperties.register(PLATINUM_BOW.get(), pull, bowPull);
        ItemProperties.register(PLATINUM_BOW.get(), pulling, bowPulling);

        ItemProperties.register(DAEDALUS_STORM_BOW.get(), pull, bowPull);
        ItemProperties.register(DAEDALUS_STORM_BOW.get(), pulling, bowPulling);
        */

    }
}
