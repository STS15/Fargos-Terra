package org.confluence.mod.common.data.gen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.confluence.mod.Confluence;
import org.confluence.mod.common.init.armor.ModArmors;
import org.confluence.mod.common.init.block.ModBlocks;
import org.confluence.mod.common.init.item.*;
import software.bernie.geckolib.animatable.GeoItem;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.confluence.mod.Confluence.MODID;

public class ModItemModelProvider extends ItemModelProvider {
    private static final Set<Item> SKIP_ITEMS = Set.of(ModBlocks.BEACH_BOX.asItem());
    private static final ResourceLocation MISSING_ITEM = Confluence.asResource("item/item_icon");
    private static final ResourceLocation MISSING_BLOCK = Confluence.asResource("item/blocks_icon");

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MODID, existingFileHelper);
    }

    private Map<DeferredRegister.Items,List<String>> createDir(DeferredRegister.Items reg, String... packPaths) {
        return Map.of(reg, Arrays.stream(packPaths).toList());
    }
    private void genModels(List<Map<DeferredRegister.Items,List<String>>> list, String parent){
        list.forEach(mp-> mp.forEach((items, packPaths) -> {
            items.getEntries().forEach(item -> {
                String path = item.getId().getPath().toLowerCase();
                boolean exist = false;
                for(String packPath : packPaths){
                    try {
                        withExistingParent(path, parent).texture("layer0", Confluence.asResource("item/" + packPath + path));
                        exist = true;
                        break;
                    } catch (Exception e) { }
                }
                if(!exist) withExistingParent(path,MISSING_ITEM);
            });
        }));
    }
    @Override
    protected void registerModels() {

        // 一般物品
        // tip：MATERIALS的贴图分多个文件夹 "materials/","gem/","ingot/","ore/"，物品多的文件夹放前面提高速度
        List<Map<DeferredRegister.Items,List<String>>> customModels = List.of(
                createDir(IconItems.ICONS,""),
                createDir(MaterialItems.MATERIALS,"materials/","gem/","ingot/","ore/"),
                createDir(TerraPotions.POTIONS,"potion/"),
                createDir(ArrowItems.ARROWS,"arrow/"),
                createDir(FoodItems.FOODS,"food/"),
                createDir(FishingPoleItems.POLES,"fishingpole/"),
                createDir(ModArmors.ARMOR,"boots/","chestplate/", "helmet/", "leggings/"),
                createDir(AccessoryItems.ACCESSORIES, "accessory/"),
                createDir(ModItems.ITEMS,"misc/")
        );
        genModels(customModels,"item/generated");


        // 手持物品
        List<Map<DeferredRegister.Items,List<String>>> handheld = List.of(
                createDir(SwordItems.SWORDS,"sword/"),
                createDir(BowItems.BOWS,"bow/"),
                createDir(AxeItems.AXE,"axe/")
        );
        genModels(handheld,"item/handheld");


        // 方块物品
        List<DeferredRegister.Items> blocks = List.of(
                ModItems.BLOCK_ITEMS
        );
        blocks.forEach(reg -> {reg.getEntries().forEach(item -> {
            Item item1 = item.get();
            String path = item.getId().getPath().toLowerCase();
            try{
                if (item1 instanceof BlockItem item2) {
                    Block block = item2.getBlock();
                    if (block instanceof DoorBlock) {
                        withExistingParent(path, "item/generated").texture("layer0", Confluence.asResource("item/" + path));
                    } else if (block instanceof TrapDoorBlock) {
                        withExistingParent(path, Confluence.asResource("block/" + path + "_bottom"));
                    } else {
                        withExistingParent(path, Confluence.asResource("block/" + path + (hasInventory(block) ? "_inventory" : "")));
                    }
                }
            }catch (Exception e){
                withExistingParent(path,MISSING_BLOCK);
            }
        });});

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
