package com.funguyman10.expandedequipment.datagen;

import com.funguyman10.expandedequipment.ExpandedEquipment;
import com.funguyman10.expandedequipment.block.ModBlocks;
import com.funguyman10.expandedequipment.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ExpandedEquipment.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.END_CHORUNDUM_ORE.get())
                .add(ModBlocks.RAW_CHORUNDUM_BLOCK.get())
                .add(ModBlocks.CHORUNDUM_BLOCK.get())
                .add(ModBlocks.ENERGETIC_DEEPSLATE_ORE.get());


        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.END_CHORUNDUM_ORE.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ENERGETIC_DEEPSLATE_ORE.get());

        tag(BlockTags.BEACON_BASE_BLOCKS)
                .add(ModBlocks.CHORUNDUM_BLOCK.get());

        tag(ModTags.Blocks.NEEDS_COPPER_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_COPPER_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(ModTags.Blocks.NEEDS_COPPER_TOOL);

        tag(ModTags.Blocks.NEEDS_CHORUNDUM_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_CHORUNDUM_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .remove(ModTags.Blocks.NEEDS_CHORUNDUM_TOOL);

    }
}
