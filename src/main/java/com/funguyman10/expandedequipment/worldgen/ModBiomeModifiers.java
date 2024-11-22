package com.funguyman10.expandedequipment.worldgen;

import com.funguyman10.expandedequipment.ExpandedEquipment;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;


public class ModBiomeModifiers {
    private static final ResourceKey<BiomeModifier> ADD_ENERGETIC_ORE = registerKey("add_energetic_ore");
    private static final ResourceKey<BiomeModifier> ADD_CHORUNDUM_ORE = registerKey("add_chorundum_ore");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_ENERGETIC_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.ENERGETIC_ORE_PLACED_KEY)),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                ));

        context.register(ADD_CHORUNDUM_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(BiomeTags.IS_END),
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.CHORUNDUM_ORE_PLACED_KEY)),
                        GenerationStep.Decoration.UNDERGROUND_ORES
                ));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(ExpandedEquipment.MOD_ID, name));
    }
}