package com.funguyman10.expandedequipment.worldgen;

import com.funguyman10.expandedequipment.ExpandedEquipment;
import com.funguyman10.expandedequipment.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> END_CHORUNDUM_ORE_KEY_FEATURE = registerKey("chorundum_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_END_CHORUNDUM_ORE_KEY_FEATURE = registerKey("big_chorundum_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_ENERGETIC_STONE_ORE_KEY = registerKey("energetic_ore");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        RuleTest deepslateReplacable = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest endReplacables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldEnergeticOres = List.of(OreConfiguration.target(deepslateReplacable,
                ModBlocks.ENERGETIC_DEEPSLATE_ORE.get().defaultBlockState()));

        FeatureUtils.register(context, OVERWORLD_ENERGETIC_STONE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldEnergeticOres, 15, 0.4F));

        FeatureUtils.register(context, END_CHORUNDUM_ORE_KEY_FEATURE, Feature.ORE, new OreConfiguration(endReplacables,
                ModBlocks.END_CHORUNDUM_ORE.get().defaultBlockState(), 3, 0.5F));

        FeatureUtils.register(context, BIG_END_CHORUNDUM_ORE_KEY_FEATURE, Feature.ORE, new OreConfiguration(endReplacables,
                ModBlocks.END_CHORUNDUM_ORE.get().defaultBlockState(), 5, 0.9F));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(ExpandedEquipment.MOD_ID, name));

    }
    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}