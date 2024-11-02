package org.confluence.terraentity.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomStandGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomFlyingGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.confluence.terraentity.client.boss.renderer.CthulhuEyeRenderer;
import org.confluence.terraentity.client.entity.model.GeoNormalModel;
import org.confluence.terraentity.client.entity.renderer.*;
import org.confluence.terraentity.entity.ai.goal.DashGoal;
import org.confluence.terraentity.entity.ai.goal.MeleeAttackNoLookGoal;
import org.confluence.terraentity.entity.boss.CthulhuEye;
import org.confluence.terraentity.entity.boss.KingSlime;
import org.confluence.terraentity.entity.model.CrownOfKingSlimeModelEntity;
import org.confluence.terraentity.entity.monster.AbstractMonster;
import org.confluence.terraentity.entity.monster.BloodCrawler;
import org.confluence.terraentity.entity.monster.BloodySpore;
import org.confluence.terraentity.entity.monster.demoneye.DemonEye;
import org.confluence.terraentity.entity.monster.demoneye.DemonEyeSurroundTargetGoal;
import org.confluence.terraentity.entity.monster.demoneye.DemonEyeWanderGoal;
import org.confluence.terraentity.entity.monster.slime.BaseSlime;
import org.confluence.terraentity.entity.monster.slime.BlackSlime;
import org.confluence.terraentity.entity.monster.slime.HoneySlime;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import static org.confluence.terraentity.TerraEntity.MODID;

@SuppressWarnings("unused")
@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD)
public final class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, MODID);


    // tip 史莱姆
    public static final DeferredHolder<EntityType<?>,EntityType<BaseSlime>> BLUE_SLIME = registerSlime("blue", 0x73bcf4, 2);
    public static final DeferredHolder<EntityType<?>,EntityType<BaseSlime>> GREEN_SLIME = registerSlime("green", 0x48E920, 2);
    public static final DeferredHolder<EntityType<?>,EntityType<BaseSlime>> PINK_SLIME = registerSlime("pink", 0xFF87B3, 1);
    public static final DeferredHolder<EntityType<?>,EntityType<BaseSlime>> CORRUPTED_SLIME = registerSlime("corrupted", 0xC91717, 2);
    public static final DeferredHolder<EntityType<?>,EntityType<BaseSlime>> DESERT_SLIME = registerSlime("desert", 0xDCC59a, 2);
    public static final DeferredHolder<EntityType<?>,EntityType<BaseSlime>> JUNGLE_SLIME = registerSlime("jungle", 0x9ae920, 2);
    public static final DeferredHolder<EntityType<?>,EntityType<BaseSlime>> EVIL_SLIME = registerSlime("evil", 0xFF00FF, 2);
    public static final DeferredHolder<EntityType<?>,EntityType<BaseSlime>> ICE_SLIME = registerSlime("ice", 0xB3F0EA, 2);
    public static final DeferredHolder<EntityType<?>,EntityType<BaseSlime>> LAVA_SLIME = ENTITIES.register("lava_slime", () -> EntityType.Builder.<BaseSlime>of((entityType, level) -> new BaseSlime(entityType, level, 0xFFB150, 2), MobCategory.MONSTER).sized(2.04F, 2.04F).clientTrackingRange(10).fireImmune().build(Key("lava_slime")));
    public static final DeferredHolder<EntityType<?>,EntityType<BaseSlime>> LUMINOUS_SLIME = registerSlime("luminous", 0xFFFFFF, 2);
    public static final DeferredHolder<EntityType<?>,EntityType<BaseSlime>> CRIMSON_SLIME = registerSlime("crimson", 0x8B4949, 2);
    public static final DeferredHolder<EntityType<?>,EntityType<BaseSlime>> PURPLE_SLIME = registerSlime("purple", 0xf334f8, 2);
    public static final DeferredHolder<EntityType<?>,EntityType<BaseSlime>> RED_SLIME = registerSlime("red", 0xf83434, 2);
    public static final DeferredHolder<EntityType<?>,EntityType<BaseSlime>> TROPIC_SLIME = registerSlime("tropic", 0x73bcf4, 2);
    public static final DeferredHolder<EntityType<?>,EntityType<BaseSlime>> YELLOW_SLIME = registerSlime("yellow", 0xf8e234, 2);
    public static final DeferredHolder<EntityType<?>,EntityType<HoneySlime>> HONEY_SLIME = ENTITIES.register("honey_slime", () -> EntityType.Builder.<HoneySlime>of((entityType, level) -> new HoneySlime(entityType, level, 0xf8e234), MobCategory.MONSTER).sized(2.04F, 2.04F).clientTrackingRange(10).build(Key("honey_slime")));
    public static final DeferredHolder<EntityType<?>,EntityType<BlackSlime>> BLACK_SLIME = ENTITIES.register("black_slime", () -> EntityType.Builder.of(BlackSlime::new, MobCategory.MONSTER).sized(2.04F, 2.04F).clientTrackingRange(10).build(Key("black_slime")));
    private static DeferredHolder<EntityType<?>, EntityType<BaseSlime>> registerSlime(String prefix, int color, int size) {
        return ENTITIES.register(prefix + "_slime", () -> EntityType.Builder.<BaseSlime>of((entityType, level) -> new BaseSlime(entityType, level, color, size), MobCategory.MONSTER).sized(0.6f, 0.6f).clientTrackingRange(10).build(Key("" + prefix + "_slime")));
    }


    // tip 野怪
    public static final DeferredHolder<EntityType<?>, EntityType<AbstractMonster>> SIMPLE_MONSTER = registerSimpleMonster("crimson_kemera", new AbstractMonster.Builder()
            .setController((c,e)->c.add(new AnimationController<GeoAnimatable>(e,"move",10,
                    state->{state.setAnimation(RawAnimation.begin().thenLoop("fly"));return PlayState.CONTINUE;})))
            .setNoGravity()
            .setHealth(1)
            .setAttackDamage(1)
            .setFollowRange(20)
            .setKnockBack(0.5f)
//            .setFlyingSpeed(20)
            .setSafeFall(1000)
            .setTarget((t,e)->{
                t.addGoal(0,new NearestAttackableTargetGoal<>(e, Villager.class,false));
                t.addGoal(1,new NearestAttackableTargetGoal<>(e, Player.class,false));

            })
            .setGoal((g,e)-> {
                g.addGoal(0,new DashGoal(e, 0.08f,10,10));
                g.addGoal(1, new MeleeAttackNoLookGoal(e, 0.5, false));
//                g.addGoal(2, new DemonEyeWanderGoal(e));
//                g.addGoal(2,new DemonEyeSurroundTargetGoal(e));
            })
            .setNavigation((e)->new FlyingPathNavigation(e,e.level()))
    );

    public static final DeferredHolder<EntityType<?>, EntityType<DemonEye>> DEMON_EYE = ENTITIES.register("demon_eye", () -> EntityType.Builder.of(DemonEye::new, MobCategory.MONSTER).sized(0.6F, 0.6F).clientTrackingRange(10).build(Key("demon_eye")));
    public static final DeferredHolder<EntityType<?>, EntityType<BloodySpore>> BLOODY_SPORE = ENTITIES.register("bloody_spore", () -> EntityType.Builder.of(BloodySpore::new, MobCategory.MONSTER).build(Key("bloody_spore")));
    public static final DeferredHolder<EntityType<?>, EntityType<BloodCrawler>> BLOOD_CRAWLER = ENTITIES.register("blood_crawler", () -> EntityType.Builder.of(BloodCrawler::new, MobCategory.MONSTER).sized(1.8F, 1.2F).clientTrackingRange(10).build(Key("blood_crawler")));


    public static <T extends AbstractMonster> DeferredHolder<EntityType<?>, EntityType<AbstractMonster>> registerSimpleMonster(String name, AbstractMonster.Builder builder) {
        return ENTITIES.register(name, () -> EntityType.Builder.<AbstractMonster>of((type,level)->new AbstractMonster(type,level,builder), MobCategory.MISC).clientTrackingRange(10).setTrackingRange(50).sized(1,1f).build(Key(name)));
    }

    // tip Boss
    public static final DeferredHolder<EntityType<?>, EntityType<KingSlime>> KING_SLIME = ENTITIES.register("king_slime", () -> EntityType.Builder.<KingSlime>of(KingSlime::new, MobCategory.MONSTER).sized(0.6f, 0.6f).clientTrackingRange(10).build(Key("king_slime")));
    public static final DeferredHolder<EntityType<?>, EntityType<CrownOfKingSlimeModelEntity>> CROWN_OF_KING_SLIME_MODEL = ENTITIES.register("crown_of_king_slime_model", () -> EntityType.Builder.<CrownOfKingSlimeModelEntity>of(CrownOfKingSlimeModelEntity::new, MobCategory.MISC).sized(0.0F, 0.0F).clientTrackingRange(10).build(Key("crown_of_king_slime_model")));

    public static final DeferredHolder<EntityType<?>, EntityType<CthulhuEye>> CTHULHU_EYE = ENTITIES.register("cthulhu_eye", () -> EntityType.Builder.<CthulhuEye>of(CthulhuEye::new, MobCategory.MONSTER).sized(2.04F, 2.04F).clientTrackingRange(200).setTrackingRange(200).build(Key("cthulhu_eye")));







    // tip 渲染器
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(BLUE_SLIME.get(), c -> new CustomSlimeRenderer(c, "blue"));
        event.registerEntityRenderer(GREEN_SLIME.get(), c -> new CustomSlimeRenderer(c, "green"));
        event.registerEntityRenderer(PINK_SLIME.get(), c -> new CustomSlimeRenderer(c, "pink"));
        event.registerEntityRenderer(CORRUPTED_SLIME.get(), c -> new CustomSlimeRenderer(c, "corrupted"));
        event.registerEntityRenderer(DESERT_SLIME.get(), c -> new CustomSlimeRenderer(c, "desert"));
        event.registerEntityRenderer(JUNGLE_SLIME.get(), c -> new CustomSlimeRenderer(c, "jungle"));
        event.registerEntityRenderer(EVIL_SLIME.get(), c -> new CustomSlimeRenderer(c, "evil"));
        event.registerEntityRenderer(ICE_SLIME.get(), c -> new CustomSlimeRenderer(c, "ice"));
        event.registerEntityRenderer(LAVA_SLIME.get(), c -> new CustomSlimeRenderer(c, "lava"));
        event.registerEntityRenderer(LUMINOUS_SLIME.get(), c -> new CustomSlimeRenderer(c, "luminous"));
        event.registerEntityRenderer(CRIMSON_SLIME.get(), c -> new CustomSlimeRenderer(c, "crimson"));
        event.registerEntityRenderer(PURPLE_SLIME.get(), c -> new CustomSlimeRenderer(c, "purple"));
        event.registerEntityRenderer(RED_SLIME.get(), c -> new CustomSlimeRenderer(c, "red"));
        event.registerEntityRenderer(TROPIC_SLIME.get(), c -> new CustomSlimeRenderer(c, "tropic"));
        event.registerEntityRenderer(YELLOW_SLIME.get(), c -> new CustomSlimeRenderer(c, "yellow"));
        event.registerEntityRenderer(HONEY_SLIME.get(), c -> new CustomSlimeRenderer(c, "honey"));
        event.registerEntityRenderer(BLACK_SLIME.get(), c -> new CustomSlimeRenderer(c, "black"));


        event.registerEntityRenderer(DEMON_EYE.get(), DemonEyeRenderer::new);
        event.registerEntityRenderer(BLOOD_CRAWLER.get(), BloodCrawlerRenderer::new);
        event.registerEntityRenderer(BLOODY_SPORE.get(), BloodySporeRenderer::new);
        event.registerEntityRenderer(SIMPLE_MONSTER.get(), c->new GeoEntityRenderer<>(c,new GeoNormalModel<>("crimson_kemera")));

        // boss
        event.registerEntityRenderer(KING_SLIME.get(), KingSlimeRenderer::new);
        event.registerEntityRenderer(CTHULHU_EYE.get(), CthulhuEyeRenderer::new);

    }

    // tip 属性
    @SubscribeEvent
    public static void registerEntityAttributes(EntityAttributeCreationEvent event) {
        AttributeSupplier.Builder genericBossAttribs = Monster.createMobAttributes()
                .add(Attributes.FOLLOW_RANGE, 100)
                .add(Attributes.MAX_HEALTH, 100)
                .add(Attributes.GRAVITY, 0)
                .add(Attributes.MOVEMENT_SPEED, 0.15f)
                .add(Attributes.ATTACK_DAMAGE, 1)
                .add(Attributes.KNOCKBACK_RESISTANCE, 10)
                .add(Attributes.ATTACK_KNOCKBACK, 1);




        event.put(BLUE_SLIME.get(), BaseSlime.createSlimeAttributes(4.0F, 0, 16.0F).build());
        event.put(GREEN_SLIME.get(), BaseSlime.createSlimeAttributes(3.0F, 0, 9.0F).build());
        event.put(PINK_SLIME.get(), BaseSlime.createSlimeAttributes(2.0F, 2, 97.0F).build());
        event.put(CORRUPTED_SLIME.get(), BaseSlime.createSlimeAttributes(35.0F, 6, 110.0F).build());
        event.put(DESERT_SLIME.get(), BaseSlime.createSlimeAttributes(6.0F, 0, 21.0F).build());
        event.put(JUNGLE_SLIME.get(), BaseSlime.createSlimeAttributes(12.0F, 0, 46.0F).build());
        event.put(EVIL_SLIME.get(), BaseSlime.createSlimeAttributes(29.0F, 2, 58.0F).build());
        event.put(ICE_SLIME.get(), BaseSlime.createSlimeAttributes(5.0F, 0, 13.0F).build());
        event.put(LAVA_SLIME.get(), BaseSlime.createSlimeAttributes(10.0F, 2, 30.0F).build());
        event.put(LUMINOUS_SLIME.get(), BaseSlime.createSlimeAttributes(45.0F, 6, 117.0F).build());
        event.put(CRIMSON_SLIME.get(), BaseSlime.createSlimeAttributes(39.0F, 5, 130.0F).build());
        event.put(PURPLE_SLIME.get(), BaseSlime.createSlimeAttributes(5.0F, 1, 25.0F).build());
        event.put(RED_SLIME.get(), BaseSlime.createSlimeAttributes(5.0F, 1, 25.0F).build());
        event.put(TROPIC_SLIME.get(), BaseSlime.createSlimeAttributes(5.0F, 0, 13.0F).build());
        event.put(YELLOW_SLIME.get(), BaseSlime.createSlimeAttributes(6.0F, 2, 25.0F).build());
        event.put(HONEY_SLIME.get(), HoneySlime.createSlimeAttributes(0F, 0, 16.0F).build());
        event.put(BLACK_SLIME.get(), Monster.createMonsterAttributes().build()); // 由finalizeSpawn设置


        event.put(DEMON_EYE.get(), DemonEye.createAttributes().build());
        event.put(BLOOD_CRAWLER.get(), BloodCrawler.createAttributes().build());
        event.put(BLOODY_SPORE.get(), BloodySpore.createAttributes().build());
        event.put(SIMPLE_MONSTER.get(), AbstractMonster.createAttributes().build());



        event.put(KING_SLIME.get(), KingSlime.createSlimeAttributes().build());
        event.put(CTHULHU_EYE.get(),CthulhuEye.createAttributes().build());


    }

    //tip 生成位置
    @SubscribeEvent
    public static void spawnPlacementRegister(RegisterSpawnPlacementsEvent event) {
        event.register(BLUE_SLIME.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BaseSlime::checkSlimeSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(GREEN_SLIME.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BaseSlime::checkSlimeSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(PURPLE_SLIME.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BaseSlime::checkSlimeSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(PINK_SLIME.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BaseSlime::checkSlimeSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(CORRUPTED_SLIME.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BaseSlime::checkSlimeSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(DESERT_SLIME.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BaseSlime::checkSlimeSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(JUNGLE_SLIME.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BaseSlime::checkSlimeSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(ICE_SLIME.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BaseSlime::checkSlimeSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(TROPIC_SLIME.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BaseSlime::checkSlimeSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(CRIMSON_SLIME.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BaseSlime::checkSlimeSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(YELLOW_SLIME.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BaseSlime::checkSlimeSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(RED_SLIME.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BaseSlime::checkSlimeSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(BLACK_SLIME.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BaseSlime::checkSlimeSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(DEMON_EYE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DemonEye::checkDemonEyeSpawn,  RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(BLOOD_CRAWLER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BloodCrawler::checkBloodCrawlerSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(BLOODY_SPORE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BloodySpore::checkBloodySporeSpawn, RegisterSpawnPlacementsEvent.Operation.REPLACE);


    }


    public static String Key(String key){
        return MODID + ":" + key;
    }
}
