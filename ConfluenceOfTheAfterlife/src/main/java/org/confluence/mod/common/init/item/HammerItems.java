package org.confluence.mod.common.init.item;

import net.minecraft.world.item.Tiers;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.confluence.mod.Confluence;
import org.confluence.mod.common.init.ModTiers;
import org.confluence.mod.common.item.hammer.HammerItem;

public class HammerItems {
    public static final DeferredRegister.Items HAMMERS = DeferredRegister.createItems(Confluence.MODID);

    public static final DeferredItem<HammerItem> WOODEN_HAMMER = HAMMERS.register("wooden_hammer", () -> new HammerItem(Tiers.WOOD, 1, 1));
    public static final DeferredItem<HammerItem> COPPER_HAMMER = HAMMERS.register("copper_hammer", () -> new HammerItem(ModTiers.COPPER, 2, 1));
    public static final DeferredItem<HammerItem> TIN_HAMMER = HAMMERS.register("tin_hammer", () -> new HammerItem(ModTiers.TIN, 2, 1));
    public static final DeferredItem<HammerItem> LEAD_HAMMER = HAMMERS.register("lead_hammer", () -> new HammerItem(ModTiers.LEAD, 3, 1));
    public static final DeferredItem<HammerItem> SILVER_HAMMER = HAMMERS.register("silver_hammer", () -> new HammerItem(ModTiers.SILVER, 3, 1));
    public static final DeferredItem<HammerItem> TUNGSTEN_HAMMER = HAMMERS.register("tungsten_hammer", () -> new HammerItem(ModTiers.TUNGSTEN, 4, 1));
    public static final DeferredItem<HammerItem> GOLDEN_HAMMER = HAMMERS.register("golden_hammer", () -> new HammerItem(ModTiers.GOLD, 5, 1));
    public static final DeferredItem<HammerItem> PLATINUM_HAMMER = HAMMERS.register("platinum_hammer", () -> new HammerItem(ModTiers.PLATINUM, 5, 1));
    public static final DeferredItem<HammerItem> EBONY_HAMMER = HAMMERS.register("ebony_hammer", () -> new HammerItem(ModTiers.EBONY, 6, 1));
    public static final DeferredItem<HammerItem> TR_CRIMSON_HAMMER = HAMMERS.register("tr_crimson_hammer", () -> new HammerItem(ModTiers.TR_CRIMSON, 6, 1));
    public static final DeferredItem<HammerItem> PWNHAMMER = HAMMERS.register("pwnhammer", () -> new HammerItem(ModTiers.HALLOWED, 7, 1));
}
