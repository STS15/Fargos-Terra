package org.confluence.mod.common.block.natural;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;

public class AshBlock extends Block {
    public AshBlock() {
        super(Properties.ofFullCopy(Blocks.STONE)
            .strength(1.0F, 1.0F)
            .sound(SoundType.SAND)
        );
    }
}