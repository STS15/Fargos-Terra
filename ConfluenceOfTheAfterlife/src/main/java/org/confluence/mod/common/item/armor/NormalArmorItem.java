package org.confluence.mod.common.item.armor;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import org.confluence.mod.Confluence;
import org.confluence.mod.common.data.gen.limit.NormalGeoItem;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.io.File;
import java.util.function.Consumer;

public class NormalArmorItem extends ArmorItem implements NormalGeoItem {
    private final String name;
    public NormalArmorItem(String name, Holder<ArmorMaterial> material, Type type, Properties properties) {
        super(material, type, properties);
        this.name = name;
    }

    public final class NormalArmorItemRenderer extends GeoArmorRenderer<NormalArmorItem> {
        public NormalArmorItemRenderer(String path) {
            super(new DefaultedItemGeoModel<>(Confluence.asResource(path)));

        }
    }

    @Override
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider() {
            private NormalArmorItemRenderer renderer;
            @Override
            public <T extends LivingEntity> HumanoidModel<?> getGeoArmorRenderer(@Nullable T livingEntity, ItemStack itemStack, @Nullable EquipmentSlot equipmentSlot, @Nullable HumanoidModel<T> original) {
                if (this.renderer == null){
                    //tip 缺失模型默认为仙人掌套
                    String base = System.getProperty("user.dir");
                    File file = new File(base.substring(0, base.indexOf("ConfluenceOfTheAfterlife"))+
                            "build/resources/main/assets/confluence/geo/item/"+name+".geo.json");
                    this.renderer = file.exists()? new NormalArmorItemRenderer(name) : new NormalArmorItemRenderer("armor/cactus_armor");
                }
                return this.renderer;
            }
        });
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {}
    private final AnimatableInstanceCache CACHE = GeckoLibUtil.createInstanceCache(this);
    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return CACHE;
    }
}
