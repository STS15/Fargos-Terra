package org.confluence.mod.common.init.item;

import net.minecraft.data.tags.IntrinsicHolderTagsProvider;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.confluence.mod.Confluence;
import org.confluence.mod.common.init.ModTiers;
import org.confluence.mod.common.item.axe.BaseAxeItem;

public class AxeItems {
    public static final DeferredRegister.Items AXES = DeferredRegister.createItems(Confluence.MODID);

    public static final DeferredItem<BaseAxeItem> COPPER_AXE = AXES.register("copper_axe", () -> new BaseAxeItem(ModTiers.COPPER, 2, 1));
    public static final DeferredItem<BaseAxeItem> TIN_AXE = AXES.register("tin_axe", () -> new BaseAxeItem(ModTiers.TIN, 2, 1));
    public static final DeferredItem<BaseAxeItem> LEAD_AXE = AXES.register("lead_axe", () -> new BaseAxeItem(ModTiers.LEAD, 3, 1));
    public static final DeferredItem<BaseAxeItem> SILVER_AXE = AXES.register("silver_axe", () -> new BaseAxeItem(ModTiers.SILVER, 3, 1));
    public static final DeferredItem<BaseAxeItem> TUNGSTEN_AXE = AXES.register("tungsten_axe", () -> new BaseAxeItem(ModTiers.TUNGSTEN, 4, 1));
    public static final DeferredItem<BaseAxeItem> GOLDEN_AXE = AXES.register("golden_axe", () -> new BaseAxeItem(ModTiers.GOLD, 5, 1));
    public static final DeferredItem<BaseAxeItem> PLATINUM_AXE = AXES.register("platinum_axe", () -> new BaseAxeItem(ModTiers.PLATINUM, 5, 1));
    public static final DeferredItem<BaseAxeItem> EBONY_AXE = AXES.register("ebony_axe", () -> new BaseAxeItem(ModTiers.EBONY, 7, 1));
    public static final DeferredItem<BaseAxeItem> TR_CRIMSON_AXE = AXES.register("tr_crimson_axe", () -> new BaseAxeItem(ModTiers.TR_CRIMSON, 8, 1));

    public static void acceptTag(IntrinsicHolderTagsProvider.IntrinsicTagAppender<Item> tag) {
        AXES.getEntries().forEach(axe -> tag.add(axe.get()));
    }
}
