package org.confluence.mod.network.s2c;

import com.mojang.datafixers.util.Either;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Tuple;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.server.ServerLifecycleHooks;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.confluence.mod.Confluence;
import org.confluence.mod.client.handler.ClientPacketHandler;
import org.confluence.mod.common.data.saved.ConfluenceData;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static org.confluence.mod.common.data.saved.ConfluenceData.STAR_PHASES_SIZE;

public record StarPhasesPacketS2C(Either<List<Tuple<Float, Float>>, ImmutableTriple<Integer, Float, Float>> starPhases) implements CustomPacketPayload {
    public static final Type<StarPhasesPacketS2C> TYPE = new Type<>(Confluence.asResource("star_phases"));
    public static final StreamCodec<ByteBuf, StarPhasesPacketS2C> STREAM_CODEC = StreamCodec.composite(
            new StreamCodec<>() {
                public @NotNull Either<List<Tuple<Float, Float>>, ImmutableTriple<Integer, Float, Float>> decode(@NotNull ByteBuf buffer) {
                    boolean isLeft = buffer.readBoolean();
                    if (isLeft) {
                        int length = buffer.readInt();
                        List<Tuple<Float, Float>> list = new ArrayList<>(STAR_PHASES_SIZE);
                        for (int i = 0; i < length; i++) {
                            list.add(new Tuple<>(buffer.readFloat(), buffer.readFloat()));
                        }
                        return Either.left(list);
                    }
                    return Either.right(new ImmutableTriple<>(buffer.readInt(), buffer.readFloat(), buffer.readFloat()));
                }

                public void encode(@NotNull ByteBuf buffer, @NotNull Either<List<Tuple<Float, Float>>, ImmutableTriple<Integer, Float, Float>> value) {
                    value.ifLeft(list -> {
                        buffer.writeBoolean(true);
                        buffer.writeInt(list.size());
                        for (Tuple<Float, Float> tuple : list) {
                            buffer.writeFloat(tuple.getA());
                            buffer.writeFloat(tuple.getB());
                        }
                    });
                    value.ifRight(triple -> {
                        buffer.writeBoolean(false);
                        buffer.writeInt(triple.left);
                        buffer.writeFloat(triple.middle);
                        buffer.writeFloat(triple.right);
                    });
                }
            }, p -> p.starPhases,
            StarPhasesPacketS2C::new
    );

    @Override
    public @NotNull Type<StarPhasesPacketS2C> type() {
        return TYPE;
    }

    public void handle(IPayloadContext context) {
        context.enqueueWork(() -> {
            if (context.player().isLocalPlayer()) {
                ClientPacketHandler.handleStarPhases(starPhases);
            }
        }).exceptionally(e -> {
            context.disconnect(Component.translatable("neoforge.network.invalid_flow", e.getMessage()));
            return null;
        });
    }

    public static void sendToAll(ServerLevel serverLevel) {
        if (ServerLifecycleHooks.getCurrentServer() != null) {
            PacketDistributor.sendToAllPlayers(new StarPhasesPacketS2C(Either.left(ConfluenceData.get(serverLevel).getStarPhases())));
        }
    }

    public static void sendToAll(int index, float radius, float angle) {
        if (ServerLifecycleHooks.getCurrentServer() != null) {
            PacketDistributor.sendToAllPlayers(new StarPhasesPacketS2C(Either.right(new ImmutableTriple<>(index, radius, angle))));
        }
    }

    public static void sendToPlayer(ServerPlayer serverPlayer) {
        if (ServerLifecycleHooks.getCurrentServer() != null) {
            PacketDistributor.sendToPlayer(serverPlayer, new StarPhasesPacketS2C(Either.left(ConfluenceData.get(serverPlayer.serverLevel()).getStarPhases())));
        }
    }

    public static void sendToPlayer(ServerPlayer serverPlayer, int index, float radius, float angle) {
        PacketDistributor.sendToPlayer(serverPlayer, new StarPhasesPacketS2C(Either.right(new ImmutableTriple<>(index, radius, angle))));
    }
}
