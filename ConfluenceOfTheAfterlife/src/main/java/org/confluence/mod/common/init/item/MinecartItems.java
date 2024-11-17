package org.confluence.mod.common.init.item;

import net.neoforged.neoforge.registries.DeferredRegister;
import org.confluence.mod.Confluence;
import org.confluence.mod.common.entity.minecart.BaseMinecartEntity;
import org.confluence.mod.common.entity.minecart.DiggingMolecartEntity;
import org.confluence.mod.common.entity.minecart.MechanicalCartEntity;
import org.confluence.mod.common.item.common.BaseMinecartItem;
import org.confluence.terra_curio.common.component.ModRarity;

import java.util.function.Supplier;

public class MinecartItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Confluence.MODID);

    public static final Supplier<BaseMinecartItem> MECHANICAL_CART = ITEMS.registerItem("mechanical_cart", properties -> new BaseMinecartItem(properties.fireResistant(), ModRarity.EXPERT, BaseMinecartEntity.MECHANICAL, MechanicalCartEntity::new));
    public static final Supplier<BaseMinecartItem> DIGGING_MOLECART = ITEMS.registerItem("digging_molecart", properties -> new BaseMinecartItem(properties, ModRarity.BLUE, BaseMinecartEntity.MOLECART, DiggingMolecartEntity::new));
}
