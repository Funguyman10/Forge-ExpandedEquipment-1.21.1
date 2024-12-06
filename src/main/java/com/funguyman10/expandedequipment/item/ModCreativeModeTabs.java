package com.funguyman10.expandedequipment.item;


import com.funguyman10.expandedequipment.ExpandedEquipment;
import com.funguyman10.expandedequipment.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExpandedEquipment.MOD_ID);

    public static final Supplier<CreativeModeTab> EXPANDED_EQUIPMENT_ITEMS_TAB = CREATIVE_MODE_TAB.register("expanded_equipment_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.CHORUNDUM.get()))
                    .title(Component.translatable("creativetab.expandedequipment.expanded_equipment_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.CHORUNDUM.get());
                        output.accept(ModItems.RAW_CHORUNDUM.get());
                        output.accept(ModItems.ENERGETIC_ROCK.get());
                        output.accept(ModItems.CHORUNDUM_UPGRADE_TEMPLATE.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> EXPANDED_EQUIPMENT_BLOCKS_TAB = CREATIVE_MODE_TAB.register("expanded_equipment_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.CHORUNDUM_BLOCK.get()))
                    .title(Component.translatable("creativetab.expandedequipment.expanded_equipment_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.END_CHORUNDUM_ORE.get());
                        output.accept(ModBlocks.RAW_CHORUNDUM_BLOCK.get());
                        output.accept(ModBlocks.CHORUNDUM_BLOCK.get());
                        output.accept(ModBlocks.ENERGETIC_DEEPSLATE_ORE.get());
                    }).build());

    public static final Supplier<CreativeModeTab> EXPANDED_EQUIPMENT_TOOLS_TAB = CREATIVE_MODE_TAB.register("expanded_equipment_tools_tab",
            () -> CreativeModeTab.builder()
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(ExpandedEquipment.MOD_ID, "expanded_equipment_items_tab"))
                    .icon(() -> new ItemStack(ModItems.COPPER_PICKAXE.get()))
                    .title(Component.translatable("creativetab.expandedequipment.expanded_equipment_tools"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.COPPER_PICKAXE.get());
                        output.accept(ModItems.COPPER_AXE.get());
                        output.accept(ModItems.COPPER_SHOVEL.get());
                        output.accept(ModItems.COPPER_HOE.get());
                        output.accept(ModItems.COPPER_SWORD.get());
                        output.accept(ModItems.COPPER_PAXEL.get());

                        output.accept(ModItems.CHORUNDUM_PICKAXE.get());
                        output.accept(ModItems.CHORUNDUM_AXE.get());
                        output.accept(ModItems.CHORUNDUM_SHOVEL.get());
                        output.accept(ModItems.CHORUNDUM_HOE.get());
                        output.accept(ModItems.CHORUNDUM_SWORD.get());
                        output.accept(ModItems.CHORUNDUM_PAXEL.get());

                        output.accept(ModItems.WOODEN_PAXEL.get());
                        output.accept(ModItems.STONE_PAXEL.get());
                        output.accept(ModItems.IRON_PAXEL.get());
                        output.accept(ModItems.GOLDEN_PAXEL.get());
                        output.accept(ModItems.DIAMOND_PAXEL.get());
                        output.accept(ModItems.NETHERITE_PAXEL.get());

                        output.accept(ModItems.WOODEN_SPEAR.get());
                        output.accept(ModItems.STONE_SPEAR.get());
                        output.accept(ModItems.GOLDEN_SPEAR.get());
                        output.accept(ModItems.IRON_SPEAR.get());
                        output.accept(ModItems.DIAMOND_SPEAR.get());
                        output.accept(ModItems.NETHERITE_SPEAR.get());
                        output.accept(ModItems.COPPER_SPEAR.get());
                        output.accept(ModItems.CHORUNDUM_SPEAR.get());

                    }).build());

    public static final Supplier<CreativeModeTab> EXPANDED_EQUIPMENT_ARMOR_TAB = CREATIVE_MODE_TAB.register("expanded_equipment_armor_tab",
            () -> CreativeModeTab.builder()
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(ExpandedEquipment.MOD_ID, "expanded_equipment_items_tab"))
                    .icon(() -> new ItemStack(ModItems.CHORUNDUM_CHESTPLATE.get()))
                    .title(Component.translatable("creativetab.expandedequipment.expanded_equipment_armor"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.COPPER_HELMET.get());
                        output.accept(ModItems.COPPER_CHESTPLATE.get());
                        output.accept(ModItems.COPPER_LEGGINGS.get());
                        output.accept(ModItems.COPPER_BOOTS.get());

                        output.accept(ModItems.CHORUNDUM_HELMET.get());
                        output.accept(ModItems.CHORUNDUM_CHESTPLATE.get());
                        output.accept(ModItems.CHORUNDUM_LEGGINGS.get());
                        output.accept(ModItems.CHORUNDUM_BOOTS.get());

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}