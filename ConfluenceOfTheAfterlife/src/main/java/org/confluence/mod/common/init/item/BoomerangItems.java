package org.confluence.mod.common.init.item;

import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.confluence.mod.Confluence;
import org.confluence.mod.common.item.sword.Boomerang;
import org.confluence.terra_curio.common.component.ModRarity;

import java.util.function.Supplier;

public class BoomerangItems {
    public static final DeferredRegister.Items BOOMERANG_ITEMS = DeferredRegister.createItems(Confluence.MODID);

    public static DeferredItem<Boomerang> WOOD_BOOMERANG = register("wood_boomerang",3,100,
            new Boomerang.BoomerangModifier()
    );
    public static DeferredItem<Boomerang> ICE_BOOMERANG = register("ice_boomerang",4,150,ModRarity.BLUE,
            new Boomerang.BoomerangModifier()
    );


    public static DeferredItem<Boomerang> DEVELOPER_BOOMERANG = register("developer_boomerang",20,100,ModRarity.EPIC,
            new Boomerang.BoomerangModifier().setNotWaitForBack().setCd(10)
    );

    public static DeferredItem<Boomerang> register(String name, Supplier<Boomerang> supplier) {
        return BOOMERANG_ITEMS.register(name, supplier);
    }
    public static DeferredItem<Boomerang> register(String name,float damage,  int durability, Boomerang.BoomerangModifier boomerangModifier) {
        return BOOMERANG_ITEMS.register(name, () -> new Boomerang(damage, durability,ModRarity.WHITE, boomerangModifier));
    }
    public static DeferredItem<Boomerang> register(String name,float damage,  int durability, ModRarity rarity, Boomerang.BoomerangModifier boomerangModifier) {
        return BOOMERANG_ITEMS.register(name, () -> new Boomerang(damage,durability,rarity, boomerangModifier));
    }
}
