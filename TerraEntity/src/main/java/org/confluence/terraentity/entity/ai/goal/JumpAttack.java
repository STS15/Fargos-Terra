package org.confluence.terraentity.entity.ai.goal;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;

public class JumpAttack extends JumpOverBlockGoal {
    private final double distanceToJump;
    private int lastAttackTime;
    public JumpAttack(Mob mob, float speedModifier, double distanceToJump) {
        super(mob, speedModifier);
        this.distanceToJump = distanceToJump;

    }

    public boolean canUse() {
        LivingEntity target = mob.getTarget();
        if(target == null) return false;
        float distance = (float) mob.distanceToSqr(target);
        return mob.onGround() && lastAttackTime < mob.tickCount - 40 && distance < distanceToJump * distanceToJump
                && distance > 4*4;
    }

    public void start() {
        lastAttackTime = mob.tickCount;
        if(mob.getTarget() == null) return;
        mob.getLookControl().setLookAt(mob.getTarget(), 30.0F, 30.0F);
        mob.jumpFromGround();
        mob.addDeltaMovement(mob.getTarget().position().subtract(mob.position())
                .multiply(1,0,1).normalize().scale(mob.getSpeed() * speedModifier));
        mob.setAggressive(true);
    }

}
