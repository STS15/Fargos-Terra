package org.confluence.mod.common.data.gen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.confluence.mod.Confluence;
import org.confluence.mod.common.init.block.ModBlocks;
import org.confluence.mod.common.init.item.*;
import software.bernie.geckolib.animatable.GeoItem;

import java.util.List;
import java.util.Set;

import static org.confluence.mod.Confluence.MODID;

public class ModItemModelProvider extends ItemModelProvider {
    private static final Set<Item> SKIP_ITEMS = Set.of(ModBlocks.BEACH_BOX.asItem());
    private static final ResourceLocation MISSING_ITEM = Confluence.asResource("item/item_icon");
    private static final ResourceLocation MISSING_BLOCK = Confluence.asResource("item/blocks_icon");

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        // 一般物品
        List<DeferredRegister.Items> customModels = List.of(IconItems.ICONS,TerraPotions.POTIONS,MaterialItems.MATERIALS, ArrowItems.ARROWS, FoodItems.FOODS);
        customModels.forEach(reg -> reg.getEntries().forEach(item -> {
            String path = item.getId().getPath().toLowerCase();
            try {withExistingParent(path, "item/generated").texture("layer0", Confluence.asResource("item/" + path));}
            catch (Exception e) {
                Confluence.LOGGER.error(e.getMessage());
                withExistingParent(path,MISSING_ITEM);
            }
        }));
        customModels.forEach(reg -> reg.getEntries().forEach(item -> {
            String path = item.getId().getPath().toLowerCase();
            try {withExistingParent(path, "item/generated").texture("layer0", Confluence.asResource("item/materials/" + path));}
            catch (Exception e) {
                Confluence.LOGGER.error(e.getMessage());
                withExistingParent(path,MISSING_ITEM);
            }
        }));
        customModels.forEach(reg -> reg.getEntries().forEach(item -> {
            String path = item.getId().getPath().toLowerCase();
            try {withExistingParent(path, "item/generated").texture("layer0", Confluence.asResource("item/ore/" + path));}
            catch (Exception e) {
                Confluence.LOGGER.error(e.getMessage());
                withExistingParent(path,MISSING_ITEM);
            }
        }));
        customModels.forEach(reg -> reg.getEntries().forEach(item -> {
            String path = item.getId().getPath().toLowerCase();
            try {withExistingParent(path, "item/generated").texture("layer0", Confluence.asResource("item/gem/" + path));}
            catch (Exception e) {
                Confluence.LOGGER.error(e.getMessage());
                withExistingParent(path,MISSING_ITEM);
            }
        }));
        customModels.forEach(reg -> reg.getEntries().forEach(item -> {
            String path = item.getId().getPath().toLowerCase();
            try {withExistingParent(path, "item/generated").texture("layer0", Confluence.asResource("item/ingot/" + path));}
            catch (Exception e) {
                Confluence.LOGGER.error(e.getMessage());
                withExistingParent(path,MISSING_ITEM);
            }
        }));
        customModels.forEach(reg -> reg.getEntries().forEach(item -> {
            String path = item.getId().getPath().toLowerCase();
            try {withExistingParent(path, "item/generated").texture("layer0", Confluence.asResource("item/arrow/" + path));}
            catch (Exception e) {
                Confluence.LOGGER.error(e.getMessage());
                withExistingParent(path,MISSING_ITEM);
            }
        }));
        customModels.forEach(reg -> reg.getEntries().forEach(item -> {
            String path = item.getId().getPath().toLowerCase();
            try {withExistingParent(path, "item/generated").texture("layer0", Confluence.asResource("item/curio/" + path));}
            catch (Exception e) {
                Confluence.LOGGER.error(e.getMessage());
                withExistingParent(path,MISSING_ITEM);
            }
        }));
        customModels.forEach(reg -> reg.getEntries().forEach(item -> {
            String path = item.getId().getPath().toLowerCase();
            try {withExistingParent(path, "item/generated").texture("layer0", Confluence.asResource("item/food/" + path));}
            catch (Exception e) {
                Confluence.LOGGER.error(e.getMessage());
                withExistingParent(path,MISSING_ITEM);
            }
        }));
        customModels.forEach(reg -> reg.getEntries().forEach(item -> {
            String path = item.getId().getPath().toLowerCase();
            try {withExistingParent(path, "item/generated").texture("layer0", Confluence.asResource("item/potion/" + path));}
            catch (Exception e) {
                Confluence.LOGGER.error(e.getMessage());
                withExistingParent(path,MISSING_ITEM);
            }
        }));

        // 手持物品
        List<DeferredRegister.Items> Handled = List.of(SwordItems.SWORDS, BowItems.BOWS);
        Handled.forEach(reg -> reg.getEntries().forEach(item -> {
            String path = item.getId().getPath().toLowerCase();
            try { withExistingParent(path, "item/handheld").texture("layer0", Confluence.asResource("item/" + path));}
            catch (Exception e) {
            Confluence.LOGGER.error(e.getMessage());
            withExistingParent(path,MISSING_ITEM);
        }
        }));
        Handled.forEach(reg -> reg.getEntries().forEach(item -> {
            String path = item.getId().getPath().toLowerCase();
            try { withExistingParent(path, "item/handheld").texture("layer0", Confluence.asResource("item/sword/" + path));}
            catch (Exception e) {
                Confluence.LOGGER.error(e.getMessage());
                withExistingParent(path,MISSING_ITEM);
            }
        }));
        Handled.forEach(reg -> reg.getEntries().forEach(item -> {
            String path = item.getId().getPath().toLowerCase();
            try { withExistingParent(path, "item/handheld").texture("layer0", Confluence.asResource("item/bow/" + path));}
            catch (Exception e) {
                Confluence.LOGGER.error(e.getMessage());
                withExistingParent(path,MISSING_ITEM);
            }
        }));
    }

    private static boolean hasInventory(Block block) {
        return block instanceof ButtonBlock || block instanceof FenceBlock;
    }

    private static boolean isHandheld(Item item) {
        return item instanceof TieredItem
//                || item instanceof StaffItem
                ;
    }

    private static boolean shouldSkip(Item item) {
        return (
                //item instanceof IconItem ||
                item instanceof GeoItem
//                        && !(item instanceof NormalGeoItem))
                        || SKIP_ITEMS.contains(item))
//                || item instanceof VanillaPotionItem
                ;
    }
}
