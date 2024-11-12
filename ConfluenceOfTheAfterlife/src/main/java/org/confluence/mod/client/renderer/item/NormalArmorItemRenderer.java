package org.confluence.mod.client.renderer.item;

import org.confluence.mod.Confluence;
import org.confluence.mod.common.item.armor.NormalArmorItem;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class NormalArmorItemRenderer extends GeoArmorRenderer<NormalArmorItem> {
    public NormalArmorItemRenderer(String path) {
        super(new DefaultedItemGeoModel<>(Confluence.asResource(path)));
    }
}
