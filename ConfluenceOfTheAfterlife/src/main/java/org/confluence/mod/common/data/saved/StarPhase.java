package org.confluence.mod.common.data.saved;

import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.CompoundTag;

public record StarPhase(float radius, float angle) {
    public static final StarPhase DEFAULT = new StarPhase(0.0F, 0.0F);

    public StarPhase(ByteBuf buffer) {
        this(buffer.readFloat(), buffer.readFloat());
    }

    public StarPhase(CompoundTag tag) {
        this(tag.getFloat("radius"), tag.getFloat("angle"));
    }

    public void writeTo(ByteBuf buffer) {
        buffer.writeFloat(radius);
        buffer.writeFloat(angle);
    }

    public void writeTo(CompoundTag tag) {
        tag.putFloat("radius", radius);
        tag.putFloat("angle", angle);
    }

    public String toIndexedString(int index) {
        return "StarPhase{index=" + index + ",radius=" + radius + ",angle=" + angle + "}";
    }
}
