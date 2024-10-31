package org.confluence.mod.common.block.natural;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import org.confluence.mod.common.data.gen.limit.CustomModel;

public class AshBlock extends Block implements CustomModel {
    public AshBlock() {
        super(Properties.ofFullCopy(Blocks.STONE)
            .strength(1.0F, 1.0F)
            .sound(SoundType.SAND)
        );
    }
}