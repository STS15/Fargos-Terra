package org.confluence.mod.common.block.natural.herbs;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.state.BlockState;
import org.confluence.mod.common.block.natural.BaseHerbBlock;
import org.confluence.mod.common.init.item.ModItems;
import org.jetbrains.annotations.NotNull;

public class Waterleaf extends BaseHerbBlock {
	@Override
	protected @NotNull ItemLike getBaseSeedId(){
		return ModItems.WATERLEAF_SEED.get();
	}

	@Override
	public boolean canBloom(ServerLevel world, BlockState state){
		return world.isRaining();
	}
}
