package org.confluence.mod.common.block.common;

import net.minecraft.world.level.block.Block;
import org.confluence.mod.common.data.gen.limit.CustomModel;

public class CustomModelBlock extends Block implements CustomModel {
    public CustomModelBlock() {
        super(Properties.of());
    }

    public CustomModelBlock(Properties properties) {
        super(properties);
    }
}
