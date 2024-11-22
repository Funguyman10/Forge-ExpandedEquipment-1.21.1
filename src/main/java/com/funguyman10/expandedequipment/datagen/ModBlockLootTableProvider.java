package com.funguyman10.expandedequipment.datagen;

import com.funguyman10.expandedequipment.block.ModBlocks;
import com.funguyman10.expandedequipment.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {

        add(ModBlocks.END_CHORUNDUM_ORE.get(),
                block -> createOreDrop(ModBlocks.END_CHORUNDUM_ORE.get(), ModItems.RAW_CHORUNDUM.get()));

        add(ModBlocks.ENERGETIC_DEEPSLATE_ORE.get(),
                block -> createOreDrop(ModBlocks.ENERGETIC_DEEPSLATE_ORE.get(), ModItems.ENERGETIC_ROCK.get()));


        dropSelf(ModBlocks.RAW_CHORUNDUM_BLOCK.get());
        dropSelf(ModBlocks.CHORUNDUM_BLOCK.get());

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
