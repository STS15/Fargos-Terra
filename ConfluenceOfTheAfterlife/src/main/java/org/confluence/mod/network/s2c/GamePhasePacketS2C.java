package org.confluence.mod.network.s2c;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.server.ServerLifecycleHooks;
import org.confluence.mod.Confluence;
import org.confluence.mod.client.handler.ClientPacketHandler;
import org.confluence.mod.common.data.saved.GamePhase;
import org.jetbrains.annotations.NotNull;

public record GamePhasePacketS2C(GamePhase gamePhase) implements CustomPacketPayload {
    public static final Type<GamePhasePacketS2C> TYPE = new Type<>(Confluence.asResource("game_phase"));
    public static final StreamCodec<ByteBuf, GamePhasePacketS2C> STREAM_CODEC = StreamCodec.composite(
            GamePhase.STREAM_CODEC, p -> p.gamePhase,
            GamePhasePacketS2C::new
    );

    @Override
    public @NotNull Type<GamePhasePacketS2C> type() {
        return TYPE;
    }

    public void handle(IPayloadContext context) {
        context.enqueueWork(() -> {
            if (context.player().isLocalPlayer()) {
                ClientPacketHandler.handleGamePhase(this);
            }
        }).exceptionally(e -> {
            context.disconnect(Component.translatable("neoforge.network.invalid_flow", e.getMessage()));
            return null;
        });
    }

    public static void sendToAll(GamePhase gamePhase) {
        if (ServerLifecycleHooks.getCurrentServer() != null) {
            PacketDistributor.sendToAllPlayers(new GamePhasePacketS2C(gamePhase));
        }
    }
}
