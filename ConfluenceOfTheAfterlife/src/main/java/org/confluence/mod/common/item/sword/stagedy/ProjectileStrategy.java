package org.confluence.mod.common.item.sword.stagedy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.network.PacketDistributor;
import org.confluence.mod.common.item.sword.BaseSwordItem;
import org.confluence.mod.common.item.sword.stagedy.projectile.AbstractProjContainer;
import org.confluence.mod.common.item.sword.stagedy.projectile.EnchantedSwordProjContainer;
import org.confluence.mod.common.item.sword.stagedy.projectile.IceSwordProjContainer;
import org.confluence.mod.common.item.sword.stagedy.projectile.StarFuryProjContainer;
import org.confluence.mod.network.c2s.SwordShootingPacketC2S;

/**
 * 这里是定义弹幕策略类工厂，方便给类似的弹幕逻辑修改参数
 * @author coffee
 */
public class ProjectileStrategy {


    public static final AbstractProjContainer ICE_PROJ = new IceSwordProjContainer();

    public static final AbstractProjContainer STAR_FURY_PROJ = new StarFuryProjContainer();

    public static final AbstractProjContainer ENCHANTED_SWORD_PROJ = new EnchantedSwordProjContainer();




    public static final AbstractProjContainer UNDEFINED_PROJ = ICE_PROJ;

    public static void handle() {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        if (minecraft.gameMode == null || minecraft.gameMode.isDestroying() || !minecraft.options.keyAttack.isDown()) {return;}
        Item item = localPlayer.getMainHandItem().getItem();
        if (item instanceof BaseSwordItem sword && !localPlayer.getCooldowns().isOnCooldown(item)
            && sword.modifier.proj!= null
        ) {
            PacketDistributor.sendToServer((new SwordShootingPacketC2S()));
            localPlayer.getCooldowns().addCooldown(sword,sword.modifier.proj.getAttackSpeed(localPlayer));
            localPlayer.swing(InteractionHand.MAIN_HAND);
        }
    }
}
