package org.confluence.mod.common.item.hook;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.confluence.mod.common.entity.hook.AbstractHookEntity;
import org.confluence.terra_curio.common.component.ModRarity;
import org.confluence.terra_curio.common.init.TCDataComponentTypes;
import org.confluence.terra_curio.util.TCUtils;
import org.jetbrains.annotations.Nullable;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class BaseHookItem extends Item implements ICurioItem {
    protected final int amount;
    protected final float range;
    protected final float velocity;
    protected final HookType type;
    protected final HookEntityFactory factory;

    public BaseHookItem(Properties pProperties, ModRarity rarity, int amount, float range, float velocity, HookType type, HookEntityFactory factory) {
        super(pProperties.component(TCDataComponentTypes.MOD_RARITY, rarity).stacksTo(1));
        this.amount = amount;
        this.range = range;
        this.velocity = velocity;
        this.type = type;
        this.factory = factory;
    }

    public BaseHookItem(ModRarity rarity, int amount, float range, float velocity, HookType type, HookEntityFactory factory) {
        this(new Properties(), rarity, amount, range, velocity, type, factory);
    }

    public int getHookAmount() {
        return amount;
    }

    public float getHookRange() {
        return range;
    }

    public float getHookVelocity() {
        return velocity;
    }

    public AbstractHookEntity getHook(ItemStack itemStack, BaseHookItem item, Player player, Level level) {
        return factory.create(itemStack, item, player, level);
    }

    public HookType getHookType() {
        return type;
    }

    public boolean canHook(ServerLevel level, ItemStack itemStack) {
        CompoundTag nbt = TCUtils.getItemStackNbt(itemStack);
        ListTag list = nbt.getList("hooks", Tag.TAG_COMPOUND);
        list.removeIf(tag -> getHookEntity(tag, level) == null);
        TCUtils.updateItemStackNbt(itemStack, tag -> tag.put("hooks", list));
        if (this instanceof IHookFastThrow) return list.size() <= getHookAmount();
        if (list.isEmpty()) return true;
        return list.stream().allMatch(tag -> {
            AbstractHookEntity hookEntity = getHookEntity(tag, level);
            return hookEntity == null || hookEntity.getHookState() == AbstractHookEntity.HookState.HOOKED;
        });
    }

    @Override
    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        return "hook".equals(slotContext.identifier());
    }

    @Override
    public boolean canEquipFromUse(SlotContext slotContext, ItemStack stack) {
        return canEquip(slotContext, stack);
    }

    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
        if (ItemStack.isSameItem(newStack, stack)) return;
        if (slotContext.entity().level() instanceof ServerLevel level && TCUtils.getItemStackNbt(stack).get("hooks") instanceof ListTag list) {
            removeAll(list, level);
        }
    }

    public static void removeAll(ListTag list, ServerLevel level) {
        list.removeIf(tag -> {
            AbstractHookEntity hookEntity = getHookEntity(tag, level);
            if (hookEntity != null) hookEntity.discard();
            return true;
        });
    }

    @Nullable
    public static AbstractHookEntity getHookEntity(Tag tag, ServerLevel level) {
        if (tag instanceof CompoundTag compoundTag) {
            return level.getEntity(compoundTag.getInt("id")) instanceof AbstractHookEntity hookEntity ? hookEntity : null;
        }
        return null;
    }

    @Override
    public Component getName(ItemStack stack) {
        return Component.translatable(getDescriptionId()).withStyle(style -> style.withColor(stack.get(TCDataComponentTypes.MOD_RARITY).getColor()));
    }

    public enum HookType {
        SINGLE, // 只有一个钩爪
        SIMULTANEOUS, // 有多个钩爪,且可以同时保持
        INDIVIDUAL // 有多个钩爪,但只能保持其一
    }

    @FunctionalInterface
    public interface HookEntityFactory {
        AbstractHookEntity create(ItemStack itemStack, BaseHookItem item, Player player, Level level);
    }
}
