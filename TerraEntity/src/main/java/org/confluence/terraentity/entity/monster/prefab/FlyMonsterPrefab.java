package org.confluence.terraentity.entity.monster.prefab;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import org.confluence.terraentity.entity.ai.goal.DashGoal;
import org.confluence.terraentity.entity.ai.goal.LookForwardWanderFlyGoal;
import org.confluence.terraentity.entity.ai.goal.MeleeAttackNoLookGoal;
import org.confluence.terraentity.entity.monster.AbstractMonster;
import org.confluence.terraentity.init.ModSounds;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;

import java.util.function.Supplier;

import static org.confluence.terraentity.entity.monster.AbstractMonster.copyFrom;

/**
 * 飞行怪预制体
 */
public class FlyMonsterPrefab {

    //在预制体上修改参数
    public static Supplier<AbstractMonster.Builder> CRIMSON_KEMERA_BUILDER =
            ()->new FlyMonsterPrefab(0.06f,10,10,20,2,11,30,0.5f,0.4f).getPrefab()
                    .setHurtSound(ModSounds.ROUTINE_HURT)
                    .setDeathSound(ModSounds.ROUTINE_DEATH)
                    .modify(b->{
                        b.friction = 0.9f;
                        return b;
                    })
            ;

    public static Supplier<AbstractMonster.Builder> DRIPPLER_BUILDER  =
            ()->new FlyMonsterPrefab(0.02f,5,40,26,3,14,30,0.5f,0.2f).getPrefab()
                .setHurtSound(ModSounds.DRIPPLER_HURT)
                .setDeathSound(ModSounds.DRIPPLER_DEATH)
                    .modify(b->{
                        b.friction = 0.8f;
                        b.maxSpeed = 0.2f;
                        return b;
                    })
            ;

    public static Supplier<AbstractMonster.Builder> FLYING_FISH_BUILDER  =
            ()->new FlyMonsterPrefab(0.04f,20,15,10,1,4,30,0.5f,0.3f).getPrefab()
                .setHurtSound(ModSounds.ROUTINE_HURT)
                .setDeathSound(ModSounds.ROUTINE_DEATH)
                    .modify(b->{
                        b.friction = 0.9f;

                        return b;
                    })
            ;


    //从一个预制体复制参数再调整参数
    public static Supplier<AbstractMonster.Builder> DO_NOTHING  = ()->copyFrom(CRIMSON_KEMERA_BUILDER)
            .setController((c,e)->c.add(new AnimationController<GeoAnimatable>(e,"move",10,s->PlayState.CONTINUE)));


    /**
     *
     * @param dashAccelerationSpeed 冲刺加速度
     * @param inertiaTick 惯性
     * @param rootYSpeed y轴回转速度
     * @param health 生命值
     * @param armor 防御值
     * @param attack 攻击力
     * @param followRange 跟随距离
     * @param knockBack 击退力
     * @param knockbackResistance 击退抗性
     */
    public FlyMonsterPrefab(float dashAccelerationSpeed,int inertiaTick, int rootYSpeed,int health,int armor,int attack,int followRange,float knockBack,float knockbackResistance) {
        SIMPLE_FLY_DASH_MONSTER = new AbstractMonster.Builder()
                .setController((c,e)->c.add(new AnimationController<GeoAnimatable>(e,"move",10,
                        state->{state.setAnimation(RawAnimation.begin().thenLoop("fly"));return PlayState.CONTINUE;})))
                .setNoGravity()
                .setArmor(armor)
                .setHealth(health)
                .setAttackDamage(attack)
                .setFollowRange(followRange)
                .setKnockBack(knockBack)
                .setKnockbackResistance(knockbackResistance)
                .setSafeFall(1000)
                .setTarget((t,e)->{
//                    t.addGoal(0, new NearestAttackableTargetGoal<>(e, Horse.class,false,LivingEntity::canBeSeenAsEnemy));
                    t.addGoal(1, new NearestAttackableTargetGoal<>(e, Player.class,false, LivingEntity::canBeSeenAsEnemy));
                })
                .setGoal((g,e)-> {
                    g.addGoal(0, new DashGoal(e, dashAccelerationSpeed,inertiaTick,rootYSpeed));
                    g.addGoal(1, new MeleeAttackNoLookGoal(e,  false));
                    g.addGoal(2, new LookForwardWanderFlyGoal(e,0.3f));
                })
                .setNavigation((e)->new FlyingPathNavigation(e,e.level()))
        ;
    }

    public FlyMonsterPrefab(float dashAccelerationSpeed,int inertiaTick, int rootYSpeed,int health,int armor,int attack) {
        this(dashAccelerationSpeed,inertiaTick,rootYSpeed,health,armor,attack,20,0.5f,0.0f);
    }

    public FlyMonsterPrefab(float dashAccelerationSpeed,int inertiaTick, int rootYSpeed,int health,int armor,int attack,int followRange) {
        this(dashAccelerationSpeed,inertiaTick,rootYSpeed,health,armor,attack,followRange,0.5f,0.0f);
    }

    protected final AbstractMonster.Builder SIMPLE_FLY_DASH_MONSTER;

    public AbstractMonster.Builder getPrefab() {
        return SIMPLE_FLY_DASH_MONSTER;
    }


}
