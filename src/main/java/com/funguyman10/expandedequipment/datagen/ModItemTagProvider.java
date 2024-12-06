package com.funguyman10.expandedequipment.datagen;

import com.funguyman10.expandedequipment.ExpandedEquipment;
import com.funguyman10.expandedequipment.item.ModItems;
import com.funguyman10.expandedequipment.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, ExpandedEquipment.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(ItemTags.BEACON_PAYMENT_ITEMS)
                .add(ModItems.CHORUNDUM.get());

        tag(ItemTags.PICKAXES)
                .add(ModItems.COPPER_PICKAXE.get())
                .add(ModItems.CHORUNDUM_PICKAXE.get())
                .add(ModItems.WOODEN_PAXEL.get())
                .add(ModItems.STONE_PAXEL.get())
                .add(ModItems.IRON_PAXEL.get())
                .add(ModItems.COPPER_PAXEL.get())
                .add(ModItems.GOLDEN_PAXEL.get())
                .add(ModItems.DIAMOND_PAXEL.get())
                .add(ModItems.NETHERITE_PAXEL.get())
                .add(ModItems.CHORUNDUM_PAXEL.get());


        tag(ItemTags.AXES)
                .add(ModItems.COPPER_AXE.get())
                .add(ModItems.CHORUNDUM_AXE.get())
                .add(ModItems.WOODEN_PAXEL.get())
                .add(ModItems.STONE_PAXEL.get())
                .add(ModItems.IRON_PAXEL.get())
                .add(ModItems.COPPER_PAXEL.get())
                .add(ModItems.GOLDEN_PAXEL.get())
                .add(ModItems.DIAMOND_PAXEL.get())
                .add(ModItems.NETHERITE_PAXEL.get())
                .add(ModItems.CHORUNDUM_PAXEL.get());

        tag(ItemTags.SHOVELS)
                .add(ModItems.COPPER_SHOVEL.get())
                .add(ModItems.CHORUNDUM_SHOVEL.get())
                .add(ModItems.WOODEN_PAXEL.get())
                .add(ModItems.STONE_PAXEL.get())
                .add(ModItems.IRON_PAXEL.get())
                .add(ModItems.COPPER_PAXEL.get())
                .add(ModItems.GOLDEN_PAXEL.get())
                .add(ModItems.DIAMOND_PAXEL.get())
                .add(ModItems.NETHERITE_PAXEL.get())
                .add(ModItems.CHORUNDUM_PAXEL.get());

        tag(ItemTags.HOES)
                .add(ModItems.COPPER_HOE.get())
                .add(ModItems.CHORUNDUM_HOE.get());

        tag(ItemTags.SWORDS)
                .add(ModItems.COPPER_SWORD.get())
                .add(ModItems.CHORUNDUM_SWORD.get())
                .add(ModItems.CHORUNDUM_SPEAR.get())
                .add(ModItems.COPPER_SPEAR.get())
                .add(ModItems.WOODEN_SPEAR.get())
                .add(ModItems.STONE_SPEAR.get())
                .add(ModItems.GOLDEN_SPEAR.get())
                .add(ModItems.IRON_SPEAR.get())
                .add(ModItems.DIAMOND_SPEAR.get())
                .add(ModItems.NETHERITE_SPEAR.get());

        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.COPPER_HELMET.get())
                .add(ModItems.COPPER_CHESTPLATE.get())
                .add(ModItems.COPPER_LEGGINGS.get())
                .add(ModItems.COPPER_BOOTS.get())
                .add(ModItems.CHORUNDUM_HELMET.get())
                .add(ModItems.CHORUNDUM_CHESTPLATE.get())
                .add(ModItems.CHORUNDUM_LEGGINGS.get())
                .add(ModItems.CHORUNDUM_BOOTS.get());

        tag(ModTags.Items.NETHERITE_UPGRADABLES)
                .add(Items.NETHERITE_PICKAXE)
                .add(Items.NETHERITE_AXE)
                .add(Items.NETHERITE_SHOVEL)
                .add(Items.NETHERITE_HOE)
                .add(Items.NETHERITE_SWORD)
                .add(Items.NETHERITE_HELMET)
                .add(Items.NETHERITE_BOOTS)
                .add(Items.NETHERITE_LEGGINGS)
                .add(Items.NETHERITE_CHESTPLATE)
                .add(ModItems.NETHERITE_PAXEL.get())
                .add(ModItems.NETHERITE_SPEAR.get());
    }
}
