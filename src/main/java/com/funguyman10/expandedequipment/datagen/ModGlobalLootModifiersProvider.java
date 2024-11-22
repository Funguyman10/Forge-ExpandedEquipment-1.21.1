package com.funguyman10.expandedequipment.datagen;

import com.funguyman10.expandedequipment.ExpandedEquipment;
import com.funguyman10.expandedequipment.item.ModItems;
import com.funguyman10.expandedequipment.loot.AddItemModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, ExpandedEquipment.MOD_ID, registries);
    }

    @Override
    protected void start(HolderLookup.Provider registries) {

        add("chorundum_upgrade_template_from_end_city_treasure", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("chests/end_city_treasure")).build(),
                LootItemRandomChanceCondition.randomChance(0.65f).build()},
                ModItems.CHORUNDUM_UPGRADE_TEMPLATE.get()));
    }
}