package org.confluence.mod.common.attachment;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.common.util.INBTSerializable;
import org.jetbrains.annotations.NotNull;

import java.util.function.IntSupplier;

public class ManaStorage implements INBTSerializable<CompoundTag> {
    private int stars;
    private int additionalMana;
    private int currentMana;
    private transient int regenerateDelay;
    private transient Integer maxMana;
    private float extractRatio;
    private boolean manaRegenerationBand;

    private boolean arcaneCrystalUsed;

    public ManaStorage() {
        this.stars = 1;
        this.additionalMana = 0;
        this.currentMana = 20;
        this.regenerateDelay = 0;
        this.extractRatio = 1.0F;
        this.manaRegenerationBand = false;

        this.arcaneCrystalUsed = false;
    }

    @Override
    public CompoundTag serializeNBT(HolderLookup.@NotNull Provider provider) {
        CompoundTag nbt = new CompoundTag();
        nbt.putInt("stars", stars);
        nbt.putInt("additionalMana", additionalMana);
        nbt.putInt("currentMana", currentMana);
        nbt.putFloat("extractRatio", extractRatio);
        nbt.putBoolean("manaRegenerationBand", manaRegenerationBand);
        nbt.putBoolean("arcaneCrystalUsed", arcaneCrystalUsed);
        return nbt;
    }

    @Override
    public void deserializeNBT(HolderLookup.@NotNull Provider provider, @NotNull CompoundTag nbt) {
        this.stars = nbt.getInt("stars");
        this.additionalMana = nbt.getInt("additionalMana");
        this.currentMana = nbt.getInt("currentMana");
        this.extractRatio = nbt.getFloat("extractRatio");
        this.manaRegenerationBand = nbt.getBoolean("manaRegenerationBand");
        this.arcaneCrystalUsed = nbt.getBoolean("arcaneCrystalUsed");
    }

    public boolean receiveMana(IntSupplier sup) {
        if (!canReceive()) return false;
        int received = Math.min(sup.getAsInt(), getMaxMana() - currentMana);
        this.currentMana += received;
        return true;
    }

    // todo
    public boolean extractMana(IntSupplier sup, ServerPlayer serverPlayer) {
        if (!canExtract()) return false;
        int extract = (int) (sup.getAsInt() * extractRatio);
//        if (currentMana < extract) {
//            if (CuriosUtils.noSameCurio(serverPlayer, IAutoGetMana.class)) return false;
//            ItemStack toUse = null;
//            for (ItemStack itemStack : serverPlayer.getInventory().items) {
//                if (itemStack.getItem() instanceof ManaPotionItem manaPotion) {
//                    int amount = manaPotion.getAmount();
//                    if (currentMana + amount < extract) continue;
//                    if (toUse == null || amount < ((ManaPotionItem) toUse.getItem()).getAmount()) toUse = itemStack;
//                    if (amount == 50) break;
//                }
//            }
//            if (toUse == null) return false;
//            toUse.finishUsingItem(serverPlayer.level(), serverPlayer);
//        }
        this.currentMana -= extract;
        return true;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    public int getRegenerateDelay() {
        return regenerateDelay;
    }

    public void setRegenerateDelay(int regenerateDelay) {
        this.regenerateDelay = regenerateDelay;
    }

    public int getMaxMana() {
        if (maxMana == null) {
            freshMaxMana();
        }
        return maxMana;
    }

    public void freshMaxMana() {
        this.maxMana = stars * 20 + additionalMana;
        if (currentMana > maxMana) {
            this.currentMana = maxMana;
        }
    }

    public boolean canExtract() {
        return currentMana > 0;
    }

    public boolean canReceive() {
        return currentMana < getMaxMana();
    }

    public boolean addStar() {
        if (stars < 10) {
            this.stars++;
            freshMaxMana();
            return true;
        }
        return false;
    }

    // todo
    public void flushAbility(LivingEntity living) {
//        MutableFloat ratio = new MutableFloat(1.0);
//        AtomicBoolean band = new AtomicBoolean();
//        AtomicInteger mana = new AtomicInteger();
//        CuriosApi.getCuriosInventory(living).ifPresent(curiosItemHandler -> {
//            IItemHandlerModifiable itemHandlerModifiable = curiosItemHandler.getEquippedCurios();
//            for (int i = 0; i < itemHandlerModifiable.getSlots(); i++) {
//                ItemStack itemStack = itemHandlerModifiable.getStackInSlot(i);
//                Item item = itemStack.getItem();
//                if (item instanceof IManaReduce iManaReduce) {
//                    ratio.addAndGet(-iManaReduce.getManaReduce());
//                }
//                if (item == CurioItems.MANA_REGENERATION_BAND.getPrefab()) {
//                    band.set(true);
//                }
//                PrefixProvider.getPrefix(itemStack)
//                        .ifPresent(itemPrefix -> mana.addAndGet(itemPrefix.additionalMana));
//            }
//        });
//        this.extractRatio = ratio.getValue();
//        this.manaRegenerationBand = band.getPrefab();
//        this.additionalMana = mana.getPrefab();
    }

    public boolean hasManaRegenerationBand() {
        return manaRegenerationBand;
    }

    public void setArcaneCrystalUsed() {
        this.arcaneCrystalUsed = true;
    }

    public boolean isArcaneCrystalUsed() {
        return arcaneCrystalUsed;
    }
}
