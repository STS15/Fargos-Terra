package org.confluence.mod.client.gui.hud;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Holder;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.event.RenderHandEvent;
import net.neoforged.neoforge.registries.DeferredItem;
import org.confluence.mod.common.init.item.BowItems;
import org.confluence.mod.common.item.bow.ShortBowItem;
import org.confluence.mod.common.item.bow.TerraBowItem;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;
import java.util.Map;


public class ArrowInBowHud {

    public static void initAdaptionMap(){
        //长弓有三个阶段参数
        offsets.put(BowItems.DAEDALUS_STORM_BOW, new Vec3(0.595f, 0.2f, 0.0f));


        //短弓只有x一个参数
        offsets.put(BowItems.PLATINUM_SHORT_BOW,new Vec3(0.08f, 0.0f, 0.0f));


    }
    private static Map<DeferredItem<? extends TerraBowItem>, Vec3> offsets = new HashMap<>();

    // tip 对长短弓的拉弓前后位移进行修改
    private static float getOffset(float charge, Vec3 off,Item item) {
        float offset;
        if(item instanceof ShortBowItem){
            /**tip 在这里修改短弓参数，然后把修改后的参数put offsets中,然后将参数置0*/
            float a = 0f;    //前后位移
            /*******************************************************************/

            return off == null? a : (float) off.x + a;
        }

        /**tip 在这里修改长弓参数，然后把修改后的参数put offsets中,然后将参数置0*/
        float a = 0;    //pulling_0
        float b = 0;    //pulling_1
        float c = 0;    //pulling_2
        /*******************************************************************/

        if(off == null){
            // 默认参数
            offset = charge < 0.65f? 0.23f + a
                    : charge < 0.9f? 0.62f + b
                    : 1f + c
            ;
        } else{
            offset = (float) (charge < 0.65f? off.x + a:
                    charge < 0.9f ? 0.58f + off.y + b : 1f + off.z + c);
        }
        return offset;
    }

    public static void transform(ItemStack bow, PoseStack poseStack, float charge){
        //拉弓前后位移
        Holder<Item> it = bow.getItemHolder();
        Vec3 off = offsets.get(it);
        float offset = getOffset(charge, off,it.value());

        poseStack.translate(0, 0.2,0);

        if(it.value() instanceof ShortBowItem){
            poseStack.translate(0, 0, offset);
        } else{
            //                                  前后阶段偏移系数  前后帧偏移系数
            poseStack.translate(0,-offset*0.04 ,offset*0.13);
        }
        poseStack.mulPose(Axis.XN.rotationDegrees(90));
        poseStack.scale(1.01f,1.01f,1.01f);
    }



    public static void render(RenderHandEvent event){


//        if(Minecraft.getInstance().player.isUsingItem() && Minecraft.getInstance().player.getItemInHand(InteractionHand.MAIN_HAND).getItem() instanceof BowItem){
//            Minecraft mc = Minecraft.getInstance();
//            float charge = mc.player.getTicksUsingItem() / 20.0f;
//            if(charge < 0.1f) return;
//            var pose = event.getPoseStack();
//            pose.pushPose();
//            ItemStack bow = mc.player.getItemInHand(InteractionHand.MAIN_HAND);
//
//
//            //拉弓前后位移
//            float scale = 1f;
//            float offset = charge < 0.65f? 0:
//                    charge < 0.9f?0.58f:1f;
//
//            float f7 = (float)bow.getUseDuration(mc.player) - ((float)mc.player.getUseItemRemainingTicks());
//            float f11 = f7 / 10.0F;
//            f11=Math.min(f11,1);
//            float f19 = f11 > 0.1F? Mth.sin((f7 - 0.1F) * 1.3F) * (f11 - 0.1F):0;
//            //应用抖动
//            //               左右偏移        上下抖动系数
//            pose.translate(0.305, f19 * 0.004F-0.1,0);
//            if(bow.getItem() instanceof ShortBowItem){
//                float f12 = Math.min(f7 / 20.0F,1);
//                //                                  前后帧偏移系数
//                pose.translate(0,0, -0.6 + f12*0.13);
//            } else{
//                //                                  前后阶段偏移系数  前后帧偏移系数
//                pose.translate(0,0, offset*0.13-0.6 + f11*0.04);
//            }
//
//            pose.scale(scale,scale,scale+f11*0.2f);
//            pose.mulPose(Axis.YP.rotationDegrees(-3));
//            pose.mulPose(Axis.XP.rotationDegrees(-110));
////            pose.mulPose(Axis.ZP.rotationDegrees(5));
//            ItemStack arrowItem = mc.player.getProjectile(bow);
//            ItemInHandRenderer renderer = mc .gameRenderer.itemInHandRenderer;
//
//            renderer.renderItem(
//                    mc.player,
//                    arrowItem,
//                    ItemDisplayContext.FIRST_PERSON_RIGHT_HAND,
//                    false,
//                    pose,
//                    mc .renderBuffers().bufferSource(),
//                    event.getPackedLight()
//            );
//
///*
//            LocalPlayer player = mc.player;
//            float f = Mth.lerp(1, player.xRotO, player.getXRot());
//
//            renderer.renderArmWithItem(
//                    mc.player,
//                    1,
//                    f,
//                    mc .player.getItemInHand(InteractionHand.MAIN_HAND),
//                    0,
//                    event.getPoseStack(),
//                    pose,
//                    ItemDisplayContext.FIRST_PERSON_RIGHT_HAND,
//                    mc .renderBuffers().bufferSource(),
//                    event.getPackedLight()
//            );
//*/
//            pose.popPose();
//        }



    }
}
