package org.confluence.mod.common.init;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.confluence.mod.Confluence;
import org.confluence.mod.worldgen.feature.ModFeatures;

import java.util.Optional;

public final class ModTreeGrower {
    public static final TreeGrower SHADOW_GROWER = register("shadow", Optional.empty(),  Optional.of(ModFeatures.SHADOW), Optional.empty());
    public static final TreeGrower EBONY_GROWER = register("ebony", Optional.empty(),  Optional.of(ModFeatures.EBONY), Optional.empty());
    public static final TreeGrower PALM_GROWER = register("palm", Optional.empty(),  Optional.of(ModFeatures.PALM), Optional.empty());
    public static final TreeGrower PEARL_GROWER = register("pearl", Optional.empty(),  Optional.of(ModFeatures.PEARL), Optional.empty());
    public static final TreeGrower RUBY_GROWER = register("ruby", Optional.empty(),  Optional.of(ModFeatures.RUBY), Optional.empty());
    public static final TreeGrower AMBER_GROWER = register("amber", Optional.empty(),  Optional.of(ModFeatures.AMBER), Optional.empty());
    public static final TreeGrower TOPAZ_GROWER = register("topaz", Optional.empty(),  Optional.of(ModFeatures.TOPAZ), Optional.empty());
    public static final TreeGrower EMERALD_GROWER = register("emerald", Optional.empty(),  Optional.of(ModFeatures.EMERALD), Optional.empty());
    public static final TreeGrower DIAMOND_GROWER = register("diamond", Optional.empty(),  Optional.of(ModFeatures.DIAMOND), Optional.empty());
    public static final TreeGrower SAPPHIRE_GROWER = register("sapphire", Optional.empty(),  Optional.of(ModFeatures.SAPPHIRE), Optional.empty());
    public static final TreeGrower TR_AMETHYST_GROWER = register("tr_amethyst", Optional.empty(),  Optional.of(ModFeatures.TR_AMETHYST), Optional.empty());
    public static final TreeGrower ASH_GROWER = register("ash", Optional.empty(),  Optional.of(ModFeatures.ASH), Optional.empty());
    public static final TreeGrower LIVING_GROWER = register("living", Optional.empty(),  Optional.of(ModFeatures.LIVING), Optional.empty());

    private static TreeGrower register(String name, Optional<ResourceKey<ConfiguredFeature<?, ?>>> megaTree, Optional<ResourceKey<ConfiguredFeature<?, ?>>> tree, Optional<ResourceKey<ConfiguredFeature<?, ?>>> flowers)
    {
        return new TreeGrower(String.format("%s:%s", Confluence.MODID, name), megaTree, tree, flowers);
    }
}
