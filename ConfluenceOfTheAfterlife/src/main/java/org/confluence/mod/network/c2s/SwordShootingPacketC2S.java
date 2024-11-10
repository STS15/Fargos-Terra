package org.confluence.mod.network.c2s;

import io.netty.buffer.ByteBuf;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.confluence.mod.Confluence;
import org.confluence.mod.common.data.saved.GamePhase;
import org.confluence.mod.common.entity.projectile.SwordProjectile;
import org.confluence.mod.common.item.sword.BaseSwordItem;
import org.confluence.mod.network.s2c.GamePhasePacketS2C;


import java.util.function.Supplier;

public class SwordShootingPacketC2S implements CustomPacketPayload {

    public static final StreamCodec<FriendlyByteBuf, SwordShootingPacketC2S> STREAM_CODEC =
            CustomPacketPayload.codec(SwordShootingPacketC2S::write,SwordShootingPacketC2S::new);
    public SwordShootingPacketC2S(FriendlyByteBuf friendlyByteBuf) {}
    public SwordShootingPacketC2S() {}
    private void write(FriendlyByteBuf buf) {}
    public static final Type<SwordShootingPacketC2S> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(Confluence.MODID, "sword_proj"));
    public Type<? extends CustomPacketPayload> type() {return TYPE;}
    public static void receive(SwordShootingPacketC2S packet, final IPayloadContext context) {
        context.enqueueWork(() -> {
            ServerPlayer player = (ServerPlayer) context.player();
            ItemStack mainHandItem = player.getMainHandItem();
            if (mainHandItem.getItem() instanceof BaseSwordItem item) {
                if(item.modifier.proj!=null){
                    item.modifier.proj.genProjectile(player,mainHandItem);
                }
            }
        });
    }
}
