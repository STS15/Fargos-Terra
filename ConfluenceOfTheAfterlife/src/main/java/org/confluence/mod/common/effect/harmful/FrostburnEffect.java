package org.confluence.mod.common.effect.harmful;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import org.confluence.mod.common.init.ModDamageTypes;

//// 免疫:
// 远古幻影妖
// 装甲维京海盗 泡泡护盾
// 笨拙气球史莱姆
// 沙漠幽魂
// 地牢守卫 地牢幽魂 荷兰大炮
// 常绿尖叫怪 雪花怪 荷兰飞盗船
// 冰冻僵尸 鬼魂 冰雪蝙蝠 冰雪精 冰雪巨人 冰雪宝箱怪 冰雪女王 冰雪史莱姆 冰雪陆龟 冰雪人鱼 坎卜斯 拜月教邪教徒
// 火星飞碟
// 火星飞碟炮
// 火星飞碟炮塔
// 戳刺先生 神秘传送门
// 神秘碑牌
// 星云柱
// 幻影龙
// 海盗诅咒
// 胡闹鬼 探测怪 死神圣诞坦克 圣诞坦克 巴拉雪人 小雪怪 雪人暴徒 日耀柱
// 尖刺冰雪史莱姆 星尘柱
// 毁灭者 亡灵维京海盗 星旋柱
// 幻灵 雪兽 僵尸精灵
public class FrostburnEffect extends MobEffect { //霜冻：缓慢损失生命 每秒损失8点生命 停止生命再生
    public FrostburnEffect() {
        super(MobEffectCategory.HARMFUL, 0xBBFFFF);
    }

    @Override
    public boolean applyEffectTick(LivingEntity living, int amplifier) {
        living.hurt(ModDamageTypes.of(living.level(), ModDamageTypes.FROST_BURN), 2.0F);
        return true;
    }

    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return duration % 20 == 0;
    }
}
