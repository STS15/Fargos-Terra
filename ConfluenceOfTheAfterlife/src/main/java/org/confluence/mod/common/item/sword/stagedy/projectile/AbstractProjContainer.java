package org.confluence.mod.common.item.sword.stagedy.projectile;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.confluence.mod.common.entity.projectile.SwordProjectile;

/**
 * 这个文件夹定义弹幕的大体释放逻辑，参数可以在strategy调整
 * @author coffee
 */
public interface  AbstractProjContainer { // 剑气

    int getCooldown();

    float getBaseVelocity();

    SoundEvent getSound();

    SwordProjectile getProjectile(Player player);

    void genProjectile(Player owner);

    float getVelocity(LivingEntity living);

    int getAttackSpeed(LivingEntity living);
}
