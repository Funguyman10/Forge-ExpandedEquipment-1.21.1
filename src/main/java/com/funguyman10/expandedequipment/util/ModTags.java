package com.funguyman10.expandedequipment.util;

import com.funguyman10.expandedequipment.ExpandedEquipment;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> NEEDS_CHORUNDUM_TOOL = createTag("needs_chorundum_tool");
        public static final TagKey<Block> NEEDS_COPPER_TOOL = createTag("needs_copper_tool");

        public static final TagKey<Block> INCORRECT_FOR_CHORUNDUM_TOOL = createTag("incorrect_for_chorundum_tool");
        public static final TagKey<Block> INCORRECT_FOR_COPPER_TOOL = createTag("incorrect_for_copper_tool");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(ExpandedEquipment.MOD_ID, name));
        }
    }
    public static class Items {

        public static final TagKey<Item> NETHERITE_UPGRADABLES = createTag("netherite_upgradables");

        public static final TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(ExpandedEquipment.MOD_ID, name));
        }
    }
}