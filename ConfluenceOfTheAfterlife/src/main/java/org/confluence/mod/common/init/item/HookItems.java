package org.confluence.mod.common.init.item;

import net.minecraft.data.tags.IntrinsicHolderTagsProvider;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.confluence.mod.Confluence;
import org.confluence.mod.common.entity.hook.AbstractHookEntity;
import org.confluence.mod.common.entity.hook.BaseHookEntity;
import org.confluence.mod.common.entity.hook.DualHookEntity;
import org.confluence.mod.common.entity.hook.MimicHookEntity;
import org.confluence.mod.common.init.ModEntities;
import org.confluence.mod.common.item.hook.BaseHookItem;
import org.confluence.mod.common.item.hook.FishHookItem;
import org.confluence.mod.common.item.hook.LunarHookItem;
import org.confluence.mod.common.item.hook.WebSlingerItem;
import org.confluence.terra_curio.common.component.ModRarity;
import org.confluence.terra_curio.util.TCUtils;

public class HookItems {
    public static final DeferredRegister.Items HOOKS = DeferredRegister.createItems(Confluence.MODID);

    public static final DeferredItem<BaseHookItem> GRAPPLING_HOOK = HOOKS.register("grappling_hook", () -> new BaseHookItem(ModRarity.BLUE, 1, 12.5F, 1.15F, BaseHookItem.HookType.SINGLE, (itemStack, item, player, level) -> new BaseHookEntity(item, player, level, BaseHookEntity.Variant.GRAPPLING))),
            AMETHYST_HOOK = HOOKS.register("amethyst_hook", () -> new BaseHookItem(ModRarity.BLUE, 1, 12.5F, 1.0F, BaseHookItem.HookType.SINGLE, (itemStack, item, player, level) -> new BaseHookEntity(item, player, level, BaseHookEntity.Variant.AMETHYST))),
            ANTI_GRAVITY_HOOK = HOOKS.register("anti_gravity_hook", () -> new BaseHookItem(ModRarity.LIME, 3, 20.83F, 1.4F, BaseHookItem.HookType.SIMULTANEOUS, (itemStack, item, player, level) -> new AbstractHookEntity.Impl(ModEntities.ANTI_GRAVITY_HOOK.get(), item, player, level))),
            TOPAZ_HOOK = HOOKS.register("topaz_hook", () -> new BaseHookItem(ModRarity.BLUE, 1, 13.75F, 1.05F, BaseHookItem.HookType.SINGLE, (itemStack, item, player, level) -> new BaseHookEntity(item, player, level, BaseHookEntity.Variant.TOPAZ))),
            SAPPHIRE_HOOK = HOOKS.register("sapphire_hook", () -> new BaseHookItem(ModRarity.BLUE, 1, 15.0F, 1.1F, BaseHookItem.HookType.SINGLE, (itemStack, item, player, level) -> new BaseHookEntity(item, player, level, BaseHookEntity.Variant.SAPPHIRE))),
            EMERALD_HOOK = HOOKS.register("emerald_hook", () -> new BaseHookItem(ModRarity.BLUE, 1, 16.25F, 1.15F, BaseHookItem.HookType.SINGLE, (itemStack, item, player, level) -> new BaseHookEntity(item, player, level, BaseHookEntity.Variant.EMERALD))),
            RUBY_HOOK = HOOKS.register("ruby_hook", () -> new BaseHookItem(ModRarity.BLUE, 1, 17.5F, 1.2F, BaseHookItem.HookType.SINGLE, (itemStack, item, player, level) -> new BaseHookEntity(item, player, level, BaseHookEntity.Variant.RUBY))),
            AMBER_HOOK = HOOKS.register("amber_hook", () -> new BaseHookItem(ModRarity.BLUE, 1, 18.33F, 1.25F, BaseHookItem.HookType.SINGLE, (itemStack, item, player, level) -> new BaseHookEntity(item, player, level, BaseHookEntity.Variant.AMBER))),
            DIAMOND_HOOK = HOOKS.register("diamond_hook", () -> new BaseHookItem(ModRarity.BLUE, 1, 19.42F, 1.25F, BaseHookItem.HookType.SINGLE, (itemStack, item, player, level) -> new BaseHookEntity(item, player, level, BaseHookEntity.Variant.DIAMOND))),
            WEB_SLINGER = HOOKS.register("web_slinger", WebSlingerItem::new),
            SKELETRON_HAND = HOOKS.register("skeletron_hand", () -> new BaseHookItem(ModRarity.GREEN, 2, 14.58F, 1.5F, BaseHookItem.HookType.SIMULTANEOUS, (itemStack, item, player, level) -> new AbstractHookEntity.Impl(ModEntities.SKELETRON_HAND.get(), item, player, level))),
            SLIME_HOOK = HOOKS.register("slime_hook", () -> new BaseHookItem(ModRarity.ORANGE, 3, 12.5F, 1.3F, BaseHookItem.HookType.SIMULTANEOUS, (itemStack, item, player, level) -> new AbstractHookEntity.Impl(ModEntities.SLIME_HOOK.get(), item, player, level))),
            FISH_HOOK = HOOKS.register("fish_hook", FishHookItem::new),
            IVY_WHIP = HOOKS.register("ivy_whip", () -> new BaseHookItem(ModRarity.ORANGE, 3, 18.67F, 1.3F, BaseHookItem.HookType.SIMULTANEOUS, (itemStack, item, player, level) -> new AbstractHookEntity.Impl(ModEntities.IVY_WHIP.get(), item, player, level))),
            BAT_HOOK = HOOKS.register("bat_hook", () -> new BaseHookItem(ModRarity.ORANGE, 1, 20.83F, 1.35F, BaseHookItem.HookType.SINGLE, (itemStack, item, player, level) -> new AbstractHookEntity.Impl(ModEntities.BAT_HOOK.get(), item, player, level))),
            CANDY_CANE_HOOK = HOOKS.register("candy_cane_hook", () -> new BaseHookItem(ModRarity.LIME, 1, 16.67F, 1.15F, BaseHookItem.HookType.SINGLE, (itemStack, item, player, level) -> new AbstractHookEntity.Impl(ModEntities.CANDY_CANE_HOOK.get(), item, player, level))),
            DUAL_HOOK = HOOKS.register("dual_hook", () -> new BaseHookItem(ModRarity.LIGHT_RED, 2, 18.33F, 1.4F, BaseHookItem.HookType.INDIVIDUAL, (itemStack, item, player, level) -> {
                CompoundTag tag = TCUtils.getItemStackNbt(itemStack);
                boolean isRed = tag.getBoolean("isRed");
                tag.putBoolean("isRed", !isRed);
                return new DualHookEntity(item, player, level, isRed ? DualHookEntity.Variant.RED : DualHookEntity.Variant.BLUE);
            })),
            HOOK_OF_DISSONANCE = HOOKS.register("hook_of_dissonance", () -> new BaseHookItem(ModRarity.PINK, 1, 20.0F, 1.6F, BaseHookItem.HookType.SINGLE, (itemStack, item, player, level) -> new AbstractHookEntity.Impl(ModEntities.HOOK_OF_DISSONANCE.get(), item, player, level))),
            THORN_HOOK = HOOKS.register("thorn_hook", () -> new BaseHookItem(ModRarity.LIGHT_PURPLE, 3, 20.0F, 1.6F, BaseHookItem.HookType.SIMULTANEOUS, (itemStack, item, player, level) -> new AbstractHookEntity.Impl(ModEntities.THORN_HOOK.get(), item, player, level))),
            ILLUMINANT_HOOK = HOOKS.register("illuminant_hook", () -> new BaseHookItem(ModRarity.LIGHT_PURPLE, 3, 20.0F, 1.5F, BaseHookItem.HookType.SIMULTANEOUS, (itemStack, item, player, level) -> new MimicHookEntity(item, player, level, MimicHookEntity.Variant.ILLUMINANT))),
            WORM_HOOK = HOOKS.register("worm_hook", () -> new BaseHookItem(ModRarity.LIGHT_PURPLE, 3, 20.0F, 1.5F, BaseHookItem.HookType.SIMULTANEOUS, (itemStack, item, player, level) -> new MimicHookEntity(item, player, level, MimicHookEntity.Variant.WORM))),
            TENDON_HOOK = HOOKS.register("tendon_hook", () -> new BaseHookItem(ModRarity.LIGHT_PURPLE, 3, 20.0F, 1.5F, BaseHookItem.HookType.SIMULTANEOUS, (itemStack, item, player, level) -> new MimicHookEntity(item, player, level, MimicHookEntity.Variant.TENDON))),
            SPOOKY_HOOK = HOOKS.register("spooky_hook", () -> new BaseHookItem(ModRarity.LIME, 3, 22.92F, 1.55F, BaseHookItem.HookType.SIMULTANEOUS, (itemStack, item, player, level) -> new AbstractHookEntity.Impl(ModEntities.SPOOKY_HOOK.get(), item, player, level))),
            CHRISTMAS_HOOK = HOOKS.register("christmas_hook", () -> new BaseHookItem(ModRarity.LIME, 3, 22.92F, 1.55F, BaseHookItem.HookType.SIMULTANEOUS, (itemStack, item, player, level) -> new AbstractHookEntity.Impl(ModEntities.CHRISTMAS_HOOK.get(), item, player, level))),
            LUNAR_HOOK = HOOKS.register("lunar_hook", LunarHookItem::new);
    /* todo 静止钩 */

    public static void acceptTag(IntrinsicHolderTagsProvider.IntrinsicTagAppender<Item> tag) {
        for (DeferredHolder<Item, ? extends Item> hooks : HOOKS.getEntries()) tag.add(hooks.get());
    }
}
