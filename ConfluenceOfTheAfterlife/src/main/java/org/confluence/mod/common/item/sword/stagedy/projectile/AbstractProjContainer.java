package org.confluence.mod.common.item.sword.stagedy.projectile;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.confluence.mod.common.entity.projectile.SwordProjectile;

/**
 * 这个文件夹定义弹幕的大体释放逻辑，参数可以在strategy调整
 * @author coffee
 */
public abstract class AbstractProjContainer { // 剑气

    public abstract int getCooldown();

    public abstract float getBaseVelocity();

    public abstract SoundEvent getSound();

    public abstract SwordProjectile getProjectile(Player player);

    public abstract void genProjectile(Player owner);

    public abstract float getVelocity(LivingEntity living);

    public abstract int getAttackSpeed(LivingEntity living);
}
