package org.confluence.mod.common.data.saved;

import com.mojang.datafixers.util.Either;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Tuple;
import net.minecraft.world.level.saveddata.SavedData;
import net.neoforged.neoforge.network.PacketDistributor;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.confluence.mod.network.s2c.GamePhasePacketS2C;
import org.confluence.mod.network.s2c.StarPhasesPacketS2C;
import org.confluence.terra_curio.network.s2c.WindSpeedPacketS2C;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ConfluenceData extends SavedData {
    public static final int STAR_PHASES_SIZE = 11;

    private GamePhase gamePhase;
    private float windSpeedX;
    private float windSpeedZ;
    private final List<Tuple<Float, Float>> starPhases;

    ConfluenceData() {
        this.gamePhase = GamePhase.BEFORE_SKELETRON;
        this.windSpeedX = 0.0F;
        this.windSpeedZ = 0.0F;
        this.starPhases = new ArrayList<>(STAR_PHASES_SIZE);
        for (int i = 0; i < STAR_PHASES_SIZE; i++) {
            starPhases.add(new Tuple<>(0.0F, 0.0F));
        }
    }

    ConfluenceData(CompoundTag nbt, HolderLookup.@NotNull Provider registries) {
        this.gamePhase = GamePhase.getById(nbt.getInt("gamePhase"));
        this.windSpeedX = nbt.getFloat("windSpeedX");
        this.windSpeedZ = nbt.getFloat("windSpeedZ");
        ListTag listTag = nbt.getList("starPhases", Tag.TAG_COMPOUND);
        this.starPhases = new ArrayList<>(STAR_PHASES_SIZE);
        for (Tag tag : listTag) {
            CompoundTag phase = (CompoundTag) tag;
            starPhases.add(new Tuple<>(phase.getFloat("radius"), phase.getFloat("angle")));
        }
    }

    public static ConfluenceData get(ServerLevel serverLevel) {
        return serverLevel.getDataStorage().computeIfAbsent(new Factory<>(ConfluenceData::new, ConfluenceData::new), "confluence");
    }

    @Override
    public @NotNull CompoundTag save(CompoundTag nbt, HolderLookup.@NotNull Provider registries) {
        nbt.putInt("gamePhase", gamePhase.ordinal());
        nbt.putFloat("windSpeedX", windSpeedX);
        nbt.putFloat("windSpeedZ", windSpeedZ);
        ListTag listTag = new ListTag();
        for (Tuple<Float, Float> phase : starPhases) {
            CompoundTag tag = new CompoundTag();
            tag.putFloat("radius", phase.getA());
            tag.putFloat("angle", phase.getB());
            listTag.add(tag);
        }
        nbt.put("starPhases", listTag);
        return nbt;
    }

    public boolean isHardcore() {
        return gamePhase.ordinal() > 1;
    }

    public boolean isGraduated() {
        return gamePhase.ordinal() == 6;
    }

    public void setGamePhase(GamePhase gamePhase) {
        this.gamePhase = gamePhase;
        PacketDistributor.sendToAllPlayers(new GamePhasePacketS2C(gamePhase));
        setDirty();
    }

    public GamePhase getGamePhase() {
        return gamePhase;
    }

    public void setWindSpeed(float x, float z) {
        this.windSpeedX = x;
        this.windSpeedZ = z;
        PacketDistributor.sendToAllPlayers(new WindSpeedPacketS2C(x, z));
        setDirty();
    }

    public float getWindSpeedX() {
        return windSpeedX;
    }

    public float getWindSpeedZ() {
        return windSpeedZ;
    }

    public boolean setStarPhase(int index, float radius, float angle) {
        if (index >= STAR_PHASES_SIZE) return false;
        starPhases.set(index, new Tuple<>(radius, angle));
        PacketDistributor.sendToAllPlayers(new StarPhasesPacketS2C(Either.right(new ImmutableTriple<>(index, radius, angle))));
        setDirty();
        return true;
    }

    public Tuple<Float, Float> getStarPhase(int index) {
        if (index >= STAR_PHASES_SIZE) return null;
        return starPhases.get(index);
    }

    public List<Tuple<Float, Float>> getStarPhases() {
        return starPhases;
    }
}
