package org.confluence.mod.common.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import org.jetbrains.annotations.Nullable;


public record SingleBooleanComponent(Boolean value) implements DataComponentType<SingleBooleanComponent> {

    public static final SingleBooleanComponent TRUE = new SingleBooleanComponent(true);
    public static final SingleBooleanComponent FALSE = new SingleBooleanComponent(false);

    public static final Codec<SingleBooleanComponent> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.BOOL.fieldOf("boolean_value").forGetter(SingleBooleanComponent::value)
    ).apply(instance, SingleBooleanComponent::new));

    public static final StreamCodec<ByteBuf, SingleBooleanComponent> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.BOOL, SingleBooleanComponent::value,
            SingleBooleanComponent::new
    );

    @Override
    public @Nullable Codec<SingleBooleanComponent> codec() {return CODEC;}

    @Override
    public StreamCodec<? super RegistryFriendlyByteBuf, SingleBooleanComponent> streamCodec() {return STREAM_CODEC;}

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof SingleBooleanComponent component)) return false;
        return component.value == value;
    }

}
