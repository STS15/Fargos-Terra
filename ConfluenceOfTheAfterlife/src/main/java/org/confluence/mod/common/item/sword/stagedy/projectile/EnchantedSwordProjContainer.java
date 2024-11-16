package org.confluence.mod.common.item.sword.stagedy.projectile;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.confluence.mod.common.entity.projectile.EnchantedSwordProjectile;
import org.confluence.mod.common.entity.projectile.SwordProjectile;
import org.confluence.terraentity.init.ModSounds;

public class EnchantedSwordProjContainer extends IceSwordProjContainer{

    @Override
    public int getCooldown() {
        return 10;
    }

    @Override
    public SoundEvent getSound() {
        return ModSounds.REGULAR_STAFF_SHOOT_2.get();
    }

    @Override
    public SwordProjectile getProjectile(Player player, ItemStack weapon) {
        return new EnchantedSwordProjectile(player);
    }

    @Override
    public float getBaseVelocity() {
        return 2.5F;
    }
}
