package org.confluence.mod.common.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.confluence.mod.Confluence;
import org.confluence.mod.common.init.block.ModDecorativeBlocks;
import org.confluence.mod.common.init.block.ModOreBlocks;


public final class ModTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Confluence.MODID);

    //TODO 图标暂时为空

    public static final DeferredHolder<CreativeModeTab,CreativeModeTab> BUILDING_BLOCKS = TABS.register("building_blocks",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.AIR))
                    .title(Component.translatable("creativetab.confluence.building_blocks"))
                    .displayItems((parameters, output) -> {
                        ModDecorativeBlocks.BLOCKS.getEntries().forEach(block -> output.accept(block.get()));
                    })
                    .build()
    );

    public static final DeferredHolder<CreativeModeTab,CreativeModeTab> NATURAL_BLOCKS = TABS.register("natural_blocks",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.AIR))
                    .title(Component.translatable("creativetab.confluence.natural_blocks"))
                    .displayItems((parameters, output) -> {
                        ModOreBlocks.BLOCKS.getEntries().forEach(block -> output.accept(block.get()));
                    })
                    .build()
    );

    public static final DeferredHolder<CreativeModeTab,CreativeModeTab> CREATIVES = TABS.register("misc",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.AIR))
                    .title(Component.translatable("creativetab.confluence.misc"))
                    .displayItems((parameters, output) -> {
                        //ModBlocks.BOX.get().getAll(Registries.BLOCK).forEach(entry -> output.accept(entry.get(), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY));
                    })
                    .build()
    );
}