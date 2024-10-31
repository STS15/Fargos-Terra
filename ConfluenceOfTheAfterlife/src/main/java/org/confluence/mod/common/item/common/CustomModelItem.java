package org.confluence.mod.common.item.common;

import net.minecraft.world.item.Item;
import org.confluence.mod.common.data.gen.limit.CustomModel;

public class CustomModelItem extends Item implements CustomModel {
    public CustomModelItem(){
        super(new Properties());
    }

    public CustomModelItem(Properties properties){
        super(properties);
    }
}
