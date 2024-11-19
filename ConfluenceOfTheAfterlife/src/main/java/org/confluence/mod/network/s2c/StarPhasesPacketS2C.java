package org.confluence.mod.network.s2c;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.util.Tuple;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.confluence.mod.Confluence;
import org.confluence.mod.client.handler.ClientPacketHandler;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static org.confluence.mod.common.data.saved.ConfluenceData.STAR_PHASES_SIZE;

public record StarPhasesPacketS2C(List<Tuple<Float, Float>> starPhases) implements CustomPacketPayload {
    public static final Type<StarPhasesPacketS2C> TYPE = new Type<>(Confluence.asResource("star_phases"));
    public static final StreamCodec<ByteBuf, StarPhasesPacketS2C> STREAM_CODEC = StreamCodec.composite(
            new StreamCodec<>() {
                public @NotNull List<Tuple<Float, Float>> decode(@NotNull ByteBuf buffer) {
                    int length = buffer.readInt();
                    List<Tuple<Float, Float>> list = new ArrayList<>(STAR_PHASES_SIZE);
                    for (int i = 0; i < length; i++) {
                        list.add(new Tuple<>(buffer.readFloat(), buffer.readFloat()));
                    }
                    return list;
                }

                public void encode(@NotNull ByteBuf buffer, @NotNull List<Tuple<Float, Float>> value) {
                    buffer.writeInt(value.size());
                    for (Tuple<Float, Float> tuple : value) {
                        buffer.writeFloat(tuple.getA());
                        buffer.writeFloat(tuple.getB());
                    }
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
                ClientPacketHandler.handleStarPhases(this);
            }
        }).exceptionally(e -> {
            context.disconnect(Component.translatable("neoforge.network.invalid_flow", e.getMessage()));
            return null;
        });
    }
}
