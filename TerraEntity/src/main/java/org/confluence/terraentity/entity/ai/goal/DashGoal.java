package org.confluence.terraentity.entity.ai.goal;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.Vec3;
import org.confluence.terraentity.entity.monster.AbstractMonster;
import org.confluence.terraentity.utils.ModUtils;

/**
 * 飞行冲撞目标的AI
 */
public class DashGoal extends Goal {

    protected final AbstractMonster mob;

    protected int dashTime = 0;
    protected int _dashTime;


    protected Vec3 lastDir = Vec3.ZERO;
    protected  States state = States.idle;
    protected float friction;
    protected float maxSpeed;
    protected int additionTime;
    protected float acceleration;
    protected int rootYSpeed;
    protected float triggerAngle;
    protected float turnAngle;

    enum States{
        dashing,
        dashing_back,
        idle
    }

    public DashGoal(AbstractMonster entity,float friction, float maxSpeed,int additionTime) {
        this(entity,friction,maxSpeed,additionTime,0.01f,10,10,10);
    }

    /**
     *
     * @param friction 摩擦力
     * @param maxSpeed 最大速度
     * @param additionTime 额外冲刺时间
     * @param acceleration 冲刺加速度
     * @param rootSpeed 转向速度
     * @param triggerAngle 初始冲刺角度
     * @param turnAngle 最大朝向目标加速角度
     */
    public DashGoal(AbstractMonster entity,float friction,float maxSpeed,int additionTime,
                    float acceleration,int rootSpeed, float triggerAngle,float turnAngle) {
        super();
        this.mob = entity;
        this.acceleration = acceleration;
        this._dashTime = -additionTime;
        this.rootYSpeed = rootSpeed;
        this.friction = friction;
        this.triggerAngle = triggerAngle;
        this.turnAngle = turnAngle;
        this.maxSpeed = maxSpeed;
        this.additionTime = additionTime;
    }

    public boolean requiresUpdateEveryTick(){return true;}

    @Override
    public boolean canUse() {
//        System.out.println("canUse: "+mob.tickCount);
        return mob.getTarget()!=null && mob.getTarget().isAlive();
    }

    public void start() {

    }

    public void stop() {

    }

    protected void lookAtTarget(LivingEntity target) {
        mob.getLookControl().setLookAt(target, 0, 85);
        mob.lookAt(target, rootYSpeed, 85);
    }

    protected void downSpeed(){
        lastDir = lastDir.scale(friction);
        mob.setDeltaMovement(lastDir);
    }

    protected float getAngle(LivingEntity target){
        return (float) ModUtils.angleBetween(target.position().subtract(mob.position()), mob.getForward());
    }



    public void tick() {
//        System.out.println("tick: "+mob.tickCount);
        LivingEntity target = mob.getTarget();
        if(target == null ||!target.isAlive())
            return;
        System.out.println(state +" " +mob.tickCount);
        if(mob.hurtTime>0) {
            state = States.idle;

        }
        if(state == States.dashing_back){
            --dashTime;
            downSpeed();
            mob.addDeltaMovement( new Vec3(0,0.05f,0));
            if(dashTime <= _dashTime) state = States.idle;
            return;
        }
        else if(state == States.idle) {
            lookAtTarget(target);
            downSpeed();

            float angle = getAngle(target);
            if(angle < triggerAngle / 180 * 3.14159) {
                state = States.dashing;
            }
            return;
        }

        float angle = getAngle(target);

        if(angle < turnAngle / 180 * 3.14159) {//30度 向前方加速
            lookAtTarget(target);

            float speed = (float) Math.min(maxSpeed , mob.getDeltaMovement().add(mob.getDeltaMovement().normalize().scale(this.acceleration)).length());
            if(speed < 0.1) {
                mob.setDeltaMovement(mob.getForward().normalize().scale(0.1F));
                return;
            }

            Vec3 dir1 = mob.getForward().normalize();
            Vec3 dir2 = target.getEyePosition().subtract(mob.position()).normalize();
            Vec3 newSpeed = dir1.add(dir2).normalize().scale(speed);

            mob.setDeltaMovement(newSpeed);


        }
        else {//背向 往前冲刺一段时间
            dashTime = 0;
            state = States.dashing_back;
            lastDir = mob.getDeltaMovement();
        }

    }

}
