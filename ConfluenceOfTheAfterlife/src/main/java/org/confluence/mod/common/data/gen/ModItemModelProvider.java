package org.confluence.mod.common.data.gen;

import com.google.common.util.concurrent.Runnables;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.confluence.mod.Confluence;
import org.confluence.mod.common.init.armor.ArmorItems;
import org.confluence.mod.common.init.block.BoxBlocks;
import org.confluence.mod.common.init.item.*;
import software.bernie.geckolib.animatable.GeoItem;

import java.util.*;
import java.util.function.Consumer;

import static net.minecraft.world.item.ItemDisplayContext.*;
import static org.confluence.mod.Confluence.MODID;

public class ModItemModelProvider extends ItemModelProvider {
    private static final Set<Item> SKIP_ITEMS = Set.of(BoxBlocks.BEACH_BOX.asItem());
    private static final ResourceLocation MISSING_ITEM = Confluence.asResource("item/item_icon");
    private static final ResourceLocation MISSING_BLOCK = Confluence.asResource("item/blocks_icon");
    private Map<DeferredItem<? extends Item>, Consumer<ItemModelBuilder>> dispatcher;

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MODID, existingFileHelper);
        initDispatcher();
    }
    // 特殊调整贴图
    private void initDispatcher(){
        dispatcher = new HashMap<>();
        dispatcher.put(SwordItems.BAT_BAT, image24x);
        dispatcher.put(SwordItems.STARFURY, image24x);
        dispatcher.put(SwordItems.BLOOD_BUTCHERER, image24x);
        dispatcher.put(SwordItems.CANDY_CANE_SWORD, image24x);
        dispatcher.put(SwordItems.PURPLE_CLUBBERFISH, image24x);
        dispatcher.put(SwordItems.VOLCANO, image24x);
        dispatcher.put(SwordItems.KATANA, image24x);
//        dispatcher.put(SwordItems.LIGHTS_BANE, image24x);


        dispatcher.put(AxeItems.EBONY_AXE, image24x);
        dispatcher.put(AxeItems.TR_CRIMSON_AXE, image24x);

        dispatcher.put(HammerItems.EBONY_HAMMER, image24x);
        dispatcher.put(HammerItems.TR_CRIMSON_HAMMER, image24x);
    }

    @Override
    protected void registerModels() {

        // 一般物品
        // tip：MATERIALS的贴图分多个文件夹 "materials/","gem/","ingot/","ore/"，物品多的文件夹放前面提高速度
        List<Map<DeferredRegister.Items,List<String>>> customModels = new ArrayList<>();
        customModels.add(createDir(IconItems.ICONS,            "icon/"));
        customModels.add(createDir(MaterialItems.MATERIALS,    "materials/","gem/","ingot/","ore/"));
        customModels.add(createDir(TerraPotions.POTIONS,       "potion/"));
        customModels.add(createDir(ArrowItems.ARROWS,          "arrow/"));
        customModels.add(createDir(FoodItems.FOODS,            "food/"));
        customModels.add(createDir(FishingPoleItems.POLES,     "fishingpole/"));
        customModels.add(createDir(ArmorItems.ARMORS,            "armor_item/"));
        customModels.add(createDir(AccessoryItems.ACCESSORIES, "accessory/"));
        customModels.add(createDir(ModItems.ITEMS,             "misc/", "seed/", "consumables/", "materials/"));
        customModels.add(createDir(HammerItems.HAMMERS,        "hammer/"));

        genModels(customModels,"item/generated",false);

        // 手持物品
        List<Map<DeferredRegister.Items,List<String>>> handheld = new ArrayList<>();
        handheld.add(createDir(SwordItems.SWORDS,"sword/"));
        handheld.add(createDir(BowItems.BOWS,"bow/"));
        handheld.add(createDir(AxeItems.AXE,"axe/"));
        handheld.add(createDir(HammerItems.HAMMERS, "hammer/"));

        genModels(handheld,"item/handheld",true);


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

    private Map<DeferredRegister.Items,List<String>> createDir(DeferredRegister.Items reg, String... packPaths) {
        return Map.of(reg, Arrays.stream(packPaths).toList());
    }
    private void genModels(List<Map<DeferredRegister.Items,List<String>>> list, String parent,boolean handheldAdjust){
        list.forEach(mp-> mp.forEach((items, packPaths) -> {
            items.getEntries().forEach(item -> {
                String path = item.getId().getPath().toLowerCase();
                boolean exist = false;
                if(path.contains("seed")){
                    Runnables.doNothing();
                }
                for(String packPath : packPaths){
                    try {
                        withExistingParent(path, parent).texture("layer0", Confluence.asResource("item/" + packPath + path));
                        if(handheldAdjust){
                            Consumer<ItemModelBuilder> consumer = dispatcher.get(item);
                            if(consumer!= null) consumer.accept(getBuilder(path));
                        }
                        exist = true;
                        break;
                    } catch (Exception e) { }
                }
                if(!exist) withExistingParent(path,MISSING_ITEM);
            });
        }));
    }



    Consumer<ItemModelBuilder> image24x = builder->{
        builder.transforms()
                .transform(THIRD_PERSON_RIGHT_HAND).translation(0, 12, 4).rotation(-45, -90, 0).scale(1.5F, 1.5F, 1F).end()
                .transform(THIRD_PERSON_LEFT_HAND).translation(-1, 8, 12).rotation(0, 85, 0).scale(1.5F, 1.5F, 1F).end()
                .transform(FIRST_PERSON_RIGHT_HAND).rotation(-20F, -80F, 0).translation(3, 8, 0).scale(1.5F, 1.5F, 1F).end()
                .transform(FIRST_PERSON_LEFT_HAND).rotation(0, 105F, 0).translation(0, 8, 5).scale(0.5F, 1F, 1F).end()
                .transform(GROUND).scale(1F, 1F, 0.5F).translation(0F, 4F, 0).end()
                .transform(GUI).translation(2.8F, 2.8F, 0).scale(1.3F).rotation(0, 0, 0).end()
                .transform(FIXED).translation(-4.5F, 4.5F, 0).scale(1.5F).rotation(0, 0, 90).end();
    };

    Consumer<ItemModelBuilder> image24xAdjustmentExamples = builder->{
        builder.transforms()
                .transform(THIRD_PERSON_RIGHT_HAND).translation(0, 14, 2).rotation(60, 90, 0).scale(1.5F, 1.5F, 1F).end()
                .transform(THIRD_PERSON_LEFT_HAND).translation(-1, 14, 2).rotation(-45, 85, 0).scale(1.5F, 1.5F, 1F).end()
                .transform(FIRST_PERSON_RIGHT_HAND).rotation(-20F, -80F, 0).translation(3, 8, 0).scale(1.5F, 1.5F, 1F).end()
                .transform(FIRST_PERSON_LEFT_HAND).rotation(0, 105F, 0).translation(0, 8, 5).scale(0.5F, 1F, 1F).end()
                .transform(GROUND).scale(1F, 1F, 0.5F).translation(0F, 4F, 0).end()
                .transform(GUI).translation(2.8F, 2.8F, 0).scale(1.3F).rotation(0, 0, 0).end()
                .transform(FIXED).translation(-4.5F, 4.5F, 0).scale(1.5F).rotation(0, 0, 90).end();
    };

    Consumer<ItemModelBuilder> image64x = builder->{
        // 还没设置
        builder.transforms()
                .transform(THIRD_PERSON_RIGHT_HAND).translation(0, 0, 0).scale(1).rotation(0, 0, 0).end()
                .transform(FIRST_PERSON_LEFT_HAND).translation(0, 0, 0).scale(1).rotation(0, 0, 0).end()
                .transform(FIRST_PERSON_RIGHT_HAND).translation(0, 0, 0).scale(1).rotation(0, 0, 0).end()
                .transform(FIRST_PERSON_LEFT_HAND).translation(0, 0, 0).scale(1).rotation(0, 0, 0).end()
                .transform(GROUND).translation(0, 0, 0).scale(1).rotation(0, 0, 0).end()
                .transform(GUI).translation(0, 0, 0).scale(1).rotation(0, 0, 0).end()
                .transform(FIXED).translation(0, 0, 0).scale(1).rotation(0, 0, 0).end();
    };

    Consumer<ItemModelBuilder> reversalImage24x = builder->{
        builder.transforms()
                .transform(THIRD_PERSON_RIGHT_HAND).translation(0, 12, 4).rotation(60, 90, 0).scale(1.5F, 1.5F, 1F).end()
                .transform(THIRD_PERSON_LEFT_HAND).translation(-1, 8, 12).rotation(0, 85, 0).scale(1.5F, 1.5F, 1F).end()
                .transform(FIRST_PERSON_RIGHT_HAND).rotation(-10F,100F, 80).translation(5, 8, -1).scale(1.5F, 1.5F, 1F).end()
                /*  数据 分析                                     x轴自转                  x   y
                                                                                越大越右   越大越上  越大越后
                不用管我这构史分析，调模型用的
                 */
                .transform(FIRST_PERSON_LEFT_HAND).rotation(0, 105F, 0).translation(0, 8, 5).scale(0.5F, 1F, 1F).end()
                .transform(GROUND).scale(1F, 1F, 0.5F).translation(0F, 4F, 0).end()
                .transform(GUI).translation(4.5F, 4.5F, 0).scale(1.5F).rotation(0, 0, 0).end()
                .transform(FIXED).translation(-4.5F, 4.5F, 0).scale(1.5F).rotation(0, 0, 90).end();
    };

    Consumer<ItemModelBuilder> reversalImage16x = builder->{

    };

}
