package com.funguyman10.expandedequipment.item;

import com.funguyman10.expandedequipment.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModToolTiers {
    public static final Tier CHORUNDUM = new ForgeTier(3000, 12f, 5f, 15,
            ModTags.Blocks.NEEDS_CHORUNDUM_TOOL, () -> Ingredient.of(ModItems.CHORUNDUM.get()),
            ModTags.Blocks.INCORRECT_FOR_CHORUNDUM_TOOL);

    public static final Tier COPPER = new ForgeTier(225, 7f, 2f, 20,
            ModTags.Blocks.NEEDS_COPPER_TOOL, () -> Ingredient.of(ModItems.CHORUNDUM.get()),
            ModTags.Blocks.INCORRECT_FOR_COPPER_TOOL);
}
