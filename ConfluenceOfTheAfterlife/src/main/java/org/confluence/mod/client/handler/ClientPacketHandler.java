package org.confluence.mod.client.handler;

import net.minecraft.Util;
import net.minecraft.util.Tuple;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.confluence.mod.common.data.saved.GamePhase;
import org.confluence.mod.common.init.ModSoundEvents;
import org.confluence.mod.network.s2c.*;

import java.util.ArrayList;
import java.util.List;

import static org.confluence.mod.common.data.saved.ConfluenceData.STAR_PHASES_SIZE;

@OnlyIn(Dist.CLIENT)
public final class ClientPacketHandler {
    private static int maxMana = 20;
    private static int currentMana = 20;
    private static GamePhase gamePhase = GamePhase.BEFORE_SKELETRON;
    private static List<Tuple<Float, Float>> starPhases = Util.make(new ArrayList<>(), list -> {
        for (int i = 0; i < STAR_PHASES_SIZE; i++) {
            list.add(new Tuple<>(0.0F, 0.0F));
        }
    });
    private static float fishingPower = 0.0F;
    private static boolean mechanicalView = false;

    public static int getCurrentMana() {
        return currentMana;
    }

    public static int getMaxMana() {
        return maxMana;
    }

    public static GamePhase getGamePhase() {
        return gamePhase;
    }

    public static boolean isHardcore() {
        return gamePhase.ordinal() > 1;
    }

    public static boolean hasMechanicalView() {
        return mechanicalView;
    }

    public boolean isGraduated() {
        return gamePhase.ordinal() == 6;
    }

    public static float getFishingPower() {
        return fishingPower;
    }

    public static List<Tuple<Float, Float>> getStarPhases() {
        return starPhases;
    }

    public static void handleMana(ManaPacketS2C packet, Player player) {
        maxMana = packet.maxMana();
        currentMana = packet.currentMana();
        if (currentMana == maxMana) {
            player.playSound(ModSoundEvents.COOLDOWN_RECOVERY.get());
        }
    }

    public static void handleGamePhase(GamePhasePacketS2C packet) {
        gamePhase = packet.gamePhase();
    }

    public static void handleFishingPower(FishingPowerInfoPacketS2C packet) {
        fishingPower = packet.value();
    }

    public static void handleMechanicalView(MechanicalViewPacketS2C packet) {
        mechanicalView = packet.enable();
    }

    public static void handleStarPhases(StarPhasesPacketS2C packet) {
        starPhases = packet.starPhases();
    }
}
