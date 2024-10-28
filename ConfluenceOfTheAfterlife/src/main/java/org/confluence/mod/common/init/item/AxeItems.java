package org.confluence.mod.common.init.item;

import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.confluence.mod.Confluence;
import org.confluence.mod.common.init.ModTiers;
import org.confluence.mod.common.item.axe.BaseAxeItem;

public class AxeItems {
    public static final DeferredRegister.Items AXE = DeferredRegister.createItems(Confluence.MODID);

    public static final DeferredItem<BaseAxeItem> COPPER_AXE = AXE.register("copper_axe", () -> new BaseAxeItem(ModTiers.COPPER, 2, 1));
    public static final DeferredItem<BaseAxeItem> TIN_AXE = AXE.register("tin_axe", () -> new BaseAxeItem(ModTiers.TIN, 2, 1));
    public static final DeferredItem<BaseAxeItem> LEAD_AXE = AXE.register("lead_axe", () -> new BaseAxeItem(ModTiers.LEAD, 3, 1));
    public static final DeferredItem<BaseAxeItem> SILVER_AXE = AXE.register("silver_axe", () -> new BaseAxeItem(ModTiers.SILVER, 3, 1));
    public static final DeferredItem<BaseAxeItem> TUNGSTEN_AXE = AXE.register("tungsten_axe", () -> new BaseAxeItem(ModTiers.TUNGSTEN, 4, 1));
    public static final DeferredItem<BaseAxeItem> GOLDEN_AXE = AXE.register("golden_axe", () -> new BaseAxeItem(ModTiers.GOLD, 5, 1));
    public static final DeferredItem<BaseAxeItem> PLATINUM_AXE = AXE.register("platinum_axe", () -> new BaseAxeItem(ModTiers.PLATINUM, 5, 1));
    public static final DeferredItem<BaseAxeItem.BigAxeItem> EBONY_AXE = AXE.register("ebony_axe", () -> new BaseAxeItem.BigAxeItem(ModTiers.EBONY, 7, 1));
    public static final DeferredItem<BaseAxeItem.BigAxeItem> TR_CRIMSON_AXE = AXE.register("tr_crimson_axe", () -> new BaseAxeItem.BigAxeItem(ModTiers.TR_CRIMSON, 8, 1));
}
