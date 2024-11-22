package com.funguyman10.expandedequipment.worldgen;

import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModOrePlacement {

    public static List<PlacementModifier> orePlacement(PlacementModifier pCountPlacement, PlacementModifier pHeightRange) {
        return List.of(pCountPlacement, InSquarePlacement.spread(), pHeightRange, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier pHeightRange) {
        return orePlacement(CountPlacement.of(count), pHeightRange);
    }

    public static List<PlacementModifier> rareOrePlacement(int chance, PlacementModifier pHeightRange) {
        return orePlacement(RarityFilter.onAverageOnceEvery(chance), pHeightRange);
    }

}
