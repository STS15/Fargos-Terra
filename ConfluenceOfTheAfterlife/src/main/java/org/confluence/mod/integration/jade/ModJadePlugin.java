package org.confluence.mod.integration.jade;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import org.confluence.mod.common.block.functional.AbstractMechanicalBlock;
import org.confluence.mod.common.block.functional.DeathChestBlock;
import snownee.jade.api.*;

@WailaPlugin
public class ModJadePlugin implements IWailaPlugin {
    @Override
    public void register(IWailaCommonRegistration registration) {
        registration.registerBlockDataProvider(MechanicalComponentProvider.INSTANCE, AbstractMechanicalBlock.Entity.class);
        registration.registerBlockDataProvider(MechanicalComponentProvider.INSTANCE, DeathChestBlock.Entity.class);
    }

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        registration.registerBlockComponent(MechanicalComponentProvider.INSTANCE, AbstractMechanicalBlock.class);
        registration.registerBlockComponent(MechanicalComponentProvider.INSTANCE, DeathChestBlock.class);
        registration.addRayTraceCallback((hitResult, accessor, originalAccessor) -> {
            if (accessor instanceof BlockAccessor blockAccessor) {
                Player player = accessor.getPlayer();
                if (!player.isCreative() && blockAccessor.getBlockEntity() instanceof DeathChestBlock.Entity entity) { // 隐藏死人箱
                    CompoundTag serverData = blockAccessor.getServerData();
                    serverData.putString("givenName", "{\"translate\":\"block.confluence.base_chest_block." + entity.variant.getSerializedName() + "\"}");
                    return registration.blockAccessor().from(blockAccessor).serverData(serverData).build();
                }
            }
            return accessor;
        });
    }
}
