package org.confluence.mod.common.data.saved;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.saveddata.SavedData;
import net.neoforged.neoforge.network.PacketDistributor;
import org.confluence.mod.network.s2c.GamePhasePacketS2C;
import org.confluence.mod.terra_curio.network.s2c.WindSpeedPacketS2C;
import org.jetbrains.annotations.NotNull;

public class ConfluenceData extends SavedData {
    private SpecificMoon specificMoon;
    private GamePhase gamePhase;
    private float windSpeedX;
    private float windSpeedZ;
    private int revealStep;

    ConfluenceData() {
        this.specificMoon = SpecificMoon.VANILLA;
        this.gamePhase = GamePhase.BEFORE_SKELETRON;
        this.windSpeedX = 0.0F;
        this.windSpeedZ = 0.0F;
        this.revealStep = -1;
    }

    ConfluenceData(CompoundTag nbt, HolderLookup.@NotNull Provider registries) {
        this.specificMoon = SpecificMoon.byId(nbt.getInt("moonSpecific"));
        this.gamePhase = GamePhase.getById(nbt.getInt("gamePhase"));
        this.windSpeedX = nbt.getFloat("windSpeedX");
        this.windSpeedZ = nbt.getFloat("windSpeedZ");
        this.revealStep = nbt.getInt("revealStep");
    }

    public static ConfluenceData get(ServerLevel serverLevel) {
        return serverLevel.getDataStorage().computeIfAbsent(new Factory<>(ConfluenceData::new, ConfluenceData::new), "confluence");
    }

    @Override
    public @NotNull CompoundTag save(CompoundTag nbt, HolderLookup.@NotNull Provider registries) {
        nbt.putInt("gamePhase", gamePhase.ordinal());
        nbt.putFloat("windSpeedX", windSpeedX);
        nbt.putFloat("windSpeedZ", windSpeedZ);
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

    // TODO: 发包
    public void setSpecificMoon(SpecificMoon specificMoon) {
        this.specificMoon = specificMoon;
//        NetworkHandler.CHANNEL.send(
//            PacketDistributor.ALL.noArg(),
//            new SpecificMoonPacketS2C(specificMoon)
//        );
        setDirty();
    }

    public SpecificMoon getSpecificMoon() {
        return specificMoon;
    }

}
