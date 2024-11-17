package org.confluence.mod.common.init.item;

import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.confluence.mod.Confluence;
import org.confluence.mod.common.item.sword.Boomerang;
import org.confluence.terra_curio.common.component.ModRarity;

import java.util.function.Supplier;

public class BoomerangItems {
    public static final DeferredRegister.Items BOOMERANG_ITEMS = DeferredRegister.createItems(Confluence.MODID);

    public static DeferredItem<Boomerang> WOOD_BOOMERANG = register("wood_boomerang",3,640,ModRarity.BLUE,
            new Boomerang.BoomerangModifier()
    );
    public static DeferredItem<Boomerang> ENCHANTED_BOOMERANG = register("enchanted_boomerang",4.4f,1,ModRarity.BLUE,
            new Boomerang.BoomerangModifier().setForwardTick(15).setFlySpeedFactor(1.55f).setBackSpeedFactor(1.55f)
    );
    public static DeferredItem<Boomerang> SHROOMERANG = register("shroomerang",4.4f,1,ModRarity.BLUE,
            new Boomerang.BoomerangModifier().setForwardTick(15).setFlySpeedFactor(1.55f).setBackSpeedFactor(1.55f)
    );
    public static DeferredItem<Boomerang> ICE_BOOMERANG = register("ice_boomerang",5.5f,1,ModRarity.BLUE,
            new Boomerang.BoomerangModifier().setForwardTick(16).setFlySpeedFactor(1.6f).setBackSpeedFactor(1.6f)
    );   //50% 的几率造成 3 秒的霜冻。

    public static DeferredItem<Boomerang> TRIMARANG = register("trimarang",5.5f,1,ModRarity.ORANGE,
            new Boomerang.BoomerangModifier().setForwardTick(17).setFlySpeedFactor(1.85f).setBackSpeedFactor(1.85f)
    );   // 使用三次


    public static DeferredItem<Boomerang> FLAMARANG = register("flamarang",12.5f,1,ModRarity.ORANGE,
            new Boomerang.BoomerangModifier().setForwardTick(18).setFlySpeedFactor(1.85f).setBackSpeedFactor(1.85f)
    );
         //50% 的几率造成 着火。


    public static DeferredItem<Boomerang> DEVELOPER_BOOMERANG = register("developer_boomerang",20,100,ModRarity.EPIC,
            new Boomerang.BoomerangModifier().setNotWaitForBack().setCd(10) // 不需要等待返回，设置cd
                    .setForwardTick(50).setFlySpeedFactor(1.5f) // 设置向前飞行速度
                    .setBackSpeedFactor(2f) // 设置后退速度
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
