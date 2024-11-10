package org.confluence.mod.common.event.game;

import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.event.level.ExplosionEvent;
import org.confluence.mod.Confluence;
import org.confluence.mod.common.block.natural.LogBlockSet;
import org.confluence.mod.common.entity.projectile.bombs.ScarabBombEntity;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME, modid = Confluence.MODID)
public final class LevelEvents {
    @SubscribeEvent
    public static void explosionDetonate(ExplosionEvent.Detonate event) {
        if (event.getExplosion().getDirectSourceEntity() instanceof ScarabBombEntity) {
            event.getAffectedEntities().removeIf(entity -> entity instanceof ItemEntity);
        }
    }

    @SubscribeEvent
    public static void blockToolModification(BlockEvent.BlockToolModificationEvent event) {
        if (event.getItemAbility() == ItemAbilities.AXE_STRIP) {
            BlockState originalState = event.getState();
            Block block = LogBlockSet.WRAPPED_STRIP_TABLE.get(originalState.getBlock());
            if (block != null) {
                event.setFinalState(block.defaultBlockState().setValue(RotatedPillarBlock.AXIS, originalState.getValue(RotatedPillarBlock.AXIS)));
            }
        }
    }
}
