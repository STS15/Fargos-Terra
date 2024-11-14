package org.confluence.mod.common.attachment;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.neoforged.neoforge.common.util.INBTSerializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.UnknownNullability;

public class GamePlay implements INBTSerializable<CompoundTag> {
    private int maxCrystals;
    private int crystals;
    private int maxFruits;
    private int fruits;

    public GamePlay() {
        this.maxCrystals = 15;
        this.crystals = 0;
        this.maxFruits = 20;
        this.fruits = 0;
    }

    public boolean increaseCrystals() {
        if (crystals < maxCrystals) {
            this.crystals++;
            return true;
        }
        return false;
    }

    public int getCrystals() {
        return crystals;
    }

    public boolean increaseFruits() {
        if (fruits < maxFruits) {
            this.fruits++;
            return true;
        }
        return false;
    }

    public int getFruits() {
        return fruits;
    }

    @Override
    public @UnknownNullability CompoundTag serializeNBT(HolderLookup.@NotNull Provider provider) {
        CompoundTag nbt = new CompoundTag();
        nbt.putInt("maxCrystals", maxCrystals);
        nbt.putInt("crystals", crystals);
        nbt.putInt("maxFruits", maxFruits);
        nbt.putInt("fruits", fruits);
        return nbt;
    }

    @Override
    public void deserializeNBT(HolderLookup.@NotNull Provider provider, @NotNull CompoundTag nbt) {
        this.maxCrystals = nbt.getInt("maxCrystals");
        this.crystals = nbt.getInt("crystals");
        this.maxFruits = nbt.getInt("maxFruits");
        this.fruits = nbt.getInt("fruits");
    }
}
