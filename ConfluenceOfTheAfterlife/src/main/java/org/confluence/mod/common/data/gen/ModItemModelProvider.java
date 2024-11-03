package org.confluence.mod.common.data.gen;

import com.google.common.util.concurrent.Runnables;
import net.minecraft.client.renderer.entity.EntityRenderer;
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
import org.apache.logging.log4j.util.TriConsumer;
import org.confluence.mod.Confluence;
import org.confluence.mod.common.init.armor.ModArmors;
import org.confluence.mod.common.init.block.ModBlocks;
import org.confluence.mod.common.init.item.*;
import software.bernie.geckolib.animatable.GeoItem;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static net.minecraft.world.item.ItemDisplayContext.*;
import static org.confluence.mod.Confluence.MODID;

public class ModItemModelProvider extends ItemModelProvider {
    private static final Set<Item> SKIP_ITEMS = Set.of(ModBlocks.BEACH_BOX.asItem());
    private static final ResourceLocation MISSING_ITEM = Confluence.asResource("item/item_icon");
    private static final ResourceLocation MISSING_BLOCK = Confluence.asResource("item/blocks_icon");
    private Map<DeferredItem<? extends Item>, Consumer<ItemModelBuilder>> dispatcher;

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MODID, existingFileHelper);
        initDispatcher();
    }
    // 特殊调整贴图
    private void initDispatcher(){
        dispatcher = Map.of(
                SwordItems.STARFURY, image24x,
                SwordItems.BLOOD_BUTCHERER, image24x,
                AxeItems.EBONY_AXE, image24x,
                AxeItems.TR_CRIMSON_AXE, image24x
        );
    }

    @Override
    protected void registerModels() {

        // 一般物品
        // tip：MATERIALS的贴图分多个文件夹 "materials/","gem/","ingot/","ore/"，物品多的文件夹放前面提高速度
        List<Map<DeferredRegister.Items,List<String>>> customModels = List.of(
                createDir(IconItems.ICONS,"icon/"),
                createDir(MaterialItems.MATERIALS,"materials/","ingot/","ore/"),
                createDir(TerraPotions.POTIONS,"potion/"),
                createDir(ArrowItems.ARROWS,"arrow/"),
                createDir(FoodItems.FOODS,"food/"),
                createDir(FishingPoleItems.POLES,"fishingpole/"),
                createDir(ModArmors.ARMOR,"armor_item/"),
                createDir(AccessoryItems.ACCESSORIES, "accessory/"),
                createDir(ModItems.ITEMS,"misc/", "seed/", "consumables/")
        );
        genModels(customModels,"item/generated",false);


        // 手持物品
        List<Map<DeferredRegister.Items,List<String>>> handheld = List.of(
                createDir(SwordItems.SWORDS,"sword/"),
                createDir(BowItems.BOWS,"bow/"),
                createDir(AxeItems.AXE,"axe/")
        );
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

}
