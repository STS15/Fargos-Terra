package org.confluence.mod.common.data.saved;

import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.saveddata.SavedData;
import org.confluence.mod.Confluence;
import org.confluence.mod.network.s2c.GamePhasePacketS2C;
import org.confluence.mod.network.s2c.StarPhasesPacketS2C;
import org.confluence.terra_curio.network.s2c.WindSpeedPacketS2C;
import org.jetbrains.annotations.NotNull;

public class ConfluenceData extends SavedData {
    public static final int STAR_PHASES_SIZE = 11;

    private GamePhase gamePhase;
    private float windSpeedX;
    private float windSpeedZ;
    private final Int2ObjectMap<StarPhase> starPhases;

    ConfluenceData() {
        this.gamePhase = GamePhase.BEFORE_SKELETRON;
        this.windSpeedX = 0.0F;
        this.windSpeedZ = 0.0F;
        this.starPhases = new Int2ObjectArrayMap<>();
        for (int i = 0; i < STAR_PHASES_SIZE; i++) {
            starPhases.put(i, StarPhase.DEFAULT);
        }
    }

    ConfluenceData(CompoundTag nbt, HolderLookup.@NotNull Provider registries) {
        this.gamePhase = GamePhase.getById(nbt.getInt("gamePhase"));
        this.windSpeedX = nbt.getFloat("windSpeedX");
        this.windSpeedZ = nbt.getFloat("windSpeedZ");
        ListTag listTag = nbt.getList("starPhases", Tag.TAG_COMPOUND);
        this.starPhases = new Int2ObjectArrayMap<>();
        for (Tag tag : listTag) {
            CompoundTag phase = (CompoundTag) tag;
            starPhases.put(phase.getInt("index"), new StarPhase(phase));
        }
    }

    public static ConfluenceData get(ServerLevel serverLevel) {
        return serverLevel.getDataStorage().computeIfAbsent(new Factory<>(ConfluenceData::new, ConfluenceData::new), Confluence.MODID);
    }

    @Override
    public @NotNull CompoundTag save(CompoundTag nbt, HolderLookup.@NotNull Provider registries) {
        nbt.putInt("gamePhase", gamePhase.ordinal());
        nbt.putFloat("windSpeedX", windSpeedX);
        nbt.putFloat("windSpeedZ", windSpeedZ);
        ListTag listTag = new ListTag();
        for (int i = 0; i < STAR_PHASES_SIZE; i++) {
            CompoundTag tag = new CompoundTag();
            tag.putInt("index", i);
            starPhases.getOrDefault(i, StarPhase.DEFAULT).writeTo(tag);
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
        GamePhasePacketS2C.sendToAll(gamePhase);
        setDirty();
    }

    public GamePhase getGamePhase() {
        return gamePhase;
    }

    public void setWindSpeed(float x, float z) {
        this.windSpeedX = x;
        this.windSpeedZ = z;
        WindSpeedPacketS2C.sendToAll(x, z);
        setDirty();
    }

    public float getWindSpeedX() {
        return windSpeedX;
    }

    public float getWindSpeedZ() {
        return windSpeedZ;
    }

    public boolean setStarPhase(int index, int timeOffset, float radius, float angle) {
        if (index >= STAR_PHASES_SIZE) return false;
        starPhases.put(index, new StarPhase(timeOffset, radius, angle));
        StarPhasesPacketS2C.sendToAll(index, timeOffset, radius, angle);
        setDirty();
        return true;
    }

    public StarPhase getStarPhase(int index) {
        if (index >= STAR_PHASES_SIZE) return null;
        return starPhases.getOrDefault(index, StarPhase.DEFAULT);
    }

    public Int2ObjectMap<StarPhase> getStarPhases() {
        return starPhases;
    }
}
