package org.confluence.mod.network.s2c;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.confluence.mod.Confluence;
import org.confluence.mod.client.handler.ClientPacketHandler;
import org.confluence.mod.common.init.item.AccessoryItems;
import org.confluence.terra_curio.common.component.AccessoriesComponent;
import org.confluence.terra_curio.util.TCUtils;
import org.jetbrains.annotations.NotNull;

public record MechanicalViewPacketS2C(boolean enable) implements CustomPacketPayload {
    public static final Type<MechanicalViewPacketS2C> TYPE = new Type<>(Confluence.asResource("mechanical_view"));
    public static final StreamCodec<ByteBuf, MechanicalViewPacketS2C> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.BOOL, p -> p.enable,
            MechanicalViewPacketS2C::new
    );

    @Override
    public @NotNull Type<MechanicalViewPacketS2C> type() {
        return TYPE;
    }

    public void handle(IPayloadContext context) {
        context.enqueueWork(() -> {
            if (context.player().isLocalPlayer()) {
                ClientPacketHandler.handleMechanicalView(this);
            }
        }).exceptionally(e -> {
            context.disconnect(Component.translatable("neoforge.network.invalid_flow", e.getMessage()));
            return null;
        });
    }

    public static void sendToClient(ServerPlayer serverPlayer) {
        boolean enable = serverPlayer.getInventory().items.stream().anyMatch(itemStack -> {
            AccessoriesComponent component = TCUtils.getAccessoriesComponent(itemStack);
            return component != null && component.contains(AccessoryItems.MECHANICAL$VIEW);
        });
        PacketDistributor.sendToPlayer(serverPlayer, new MechanicalViewPacketS2C(enable));
    }
}
