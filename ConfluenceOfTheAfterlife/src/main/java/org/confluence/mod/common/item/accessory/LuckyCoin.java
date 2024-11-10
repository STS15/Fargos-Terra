package org.confluence.mod.common.item.accessory;

import net.minecraft.util.RandomSource;
import net.minecraft.util.Unit;
import net.minecraft.world.Containers;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.confluence.mod.common.CommonConfigs;
import org.confluence.mod.common.init.item.ModItems;
import org.confluence.terra_curio.api.primitive.UnitValue;
import org.confluence.terra_curio.api.primitive.ValueType;
import org.confluence.terra_curio.common.init.TCAttachments;
import org.confluence.terra_curio.common.item.curio.BaseCurioItem;

public class LuckyCoin extends BaseCurioItem {
    public static final ValueType<Unit, UnitValue> LUCKY$COIN = ValueType.ofUnit("lucky_coin");

    public LuckyCoin(Builder builder) {
        super(builder);
    }

    public static void apply(Player player, Entity target) {
        if (!CommonConfigs.DROP_MONEY.get()) return;
        RandomSource randomSource = player.getRandom();
        if (player.getData(TCAttachments.ACCESSORIES).contains(LUCKY$COIN) && randomSource.nextFloat() < 0.2F) {
            Item item;
            float a = randomSource.nextFloat();
            if (a < 0.01F) {
                item = ModItems.GOLDEN_COIN.get();
            } else if (a < 0.099F) {
                item = ModItems.SILVER_COIN.get();
            } else {
                item = ModItems.COPPER_COIN.get();
            }
            Containers.dropItemStack(player.level(), target.getX(), target.getY(), target.getZ(), new ItemStack(item, randomSource.nextInt(1, 3)));
        }
    }
}
