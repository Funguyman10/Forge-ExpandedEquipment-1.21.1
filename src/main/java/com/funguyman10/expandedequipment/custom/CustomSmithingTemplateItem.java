package com.funguyman10.expandedequipment.custom;

import com.funguyman10.expandedequipment.ExpandedEquipment;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class CustomSmithingTemplateItem extends Item {
    private static final ChatFormatting TITLE_FORMAT = ChatFormatting.GRAY;
    private static final ChatFormatting DESCRIPTION_FORMAT = ChatFormatting.BLUE;
    private static final Component INGREDIENTS_TITLE = Component.translatable(Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(ExpandedEquipment.MOD_ID, "smithing_template.ingredients")))
            .withStyle(TITLE_FORMAT);
    private static final Component APPLIES_TO_TITLE = Component.translatable(Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(ExpandedEquipment.MOD_ID, "smithing_template.applies_to")))
            .withStyle(TITLE_FORMAT);
    private static final Component CHORUNDUM_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", ResourceLocation.fromNamespaceAndPath(ExpandedEquipment.MOD_ID, "chorundum_upgrade")))
            .withStyle(TITLE_FORMAT);
    private static final Component CHORUNDUM_UPGRADE_APPLIES_TO = Component.translatable(
                    Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(ExpandedEquipment.MOD_ID, "smithing_template.chorundum_upgrade.applies_to"))
            )
            .withStyle(DESCRIPTION_FORMAT);
    private static final Component CHORUNDUM_UPGRADE_INGREDIENTS = Component.translatable(
                    Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(ExpandedEquipment.MOD_ID, "smithing_template.chorundum_upgrade.ingredients"))
            )
            .withStyle(DESCRIPTION_FORMAT);
    private static final Component CHORUNDUM_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(
            Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(ExpandedEquipment.MOD_ID, "smithing_template.chorundum_upgrade.base_slot_description"))
    );
    private static final Component CHORUNDUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(
            Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(ExpandedEquipment.MOD_ID, "smithing_template.chorundum_upgrade.additions_slot_description"))
    );
    private static final ResourceLocation EMPTY_SLOT_HELMET = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_helmet");
    private static final ResourceLocation EMPTY_SLOT_CHESTPLATE = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_chestplate");
    private static final ResourceLocation EMPTY_SLOT_LEGGINGS = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_leggings");
    private static final ResourceLocation EMPTY_SLOT_BOOTS = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_boots");
    private static final ResourceLocation EMPTY_SLOT_HOE = ResourceLocation.withDefaultNamespace("item/empty_slot_hoe");
    private static final ResourceLocation EMPTY_SLOT_AXE = ResourceLocation.withDefaultNamespace("item/empty_slot_axe");
    private static final ResourceLocation EMPTY_SLOT_SWORD = ResourceLocation.withDefaultNamespace("item/empty_slot_sword");
    private static final ResourceLocation EMPTY_SLOT_SHOVEL = ResourceLocation.withDefaultNamespace("item/empty_slot_shovel");
    private static final ResourceLocation EMPTY_SLOT_PICKAXE = ResourceLocation.withDefaultNamespace("item/empty_slot_pickaxe");
    private static final ResourceLocation EMPTY_SLOT_INGOT = ResourceLocation.withDefaultNamespace("item/empty_slot_ingot");

    private final Component appliesTo;
    private final Component ingredients;
    private final Component upgradeDescription;
    private final Component baseSlotDescription;
    private final Component additionsSlotDescription;
    private final List<ResourceLocation> baseSlotEmptyIcons;
    private final List<ResourceLocation> additionalSlotEmptyIcons;

    public CustomSmithingTemplateItem(
            Component pAppliesTo,
            Component pIngredients,
            Component pUpgradeDescription,
            Component pBaseSlotDescription,
            Component pAdditionsSlotDescription,
            List<ResourceLocation> pBaseSlotEmptyIcons,
            List<ResourceLocation> pAdditionalSlotEmptyIcons,
            FeatureFlag... pRequiredFeatures
    ) {
        super(new Item.Properties().requiredFeatures(pRequiredFeatures));
        this.appliesTo = pAppliesTo;
        this.ingredients = pIngredients;
        this.upgradeDescription = pUpgradeDescription;
        this.baseSlotDescription = pBaseSlotDescription;
        this.additionsSlotDescription = pAdditionsSlotDescription;
        this.baseSlotEmptyIcons = pBaseSlotEmptyIcons;
        this.additionalSlotEmptyIcons = pAdditionalSlotEmptyIcons;
    }

    public static CustomSmithingTemplateItem createChorundumUpgradeTemplate() {
        return new CustomSmithingTemplateItem(CHORUNDUM_UPGRADE_APPLIES_TO, CHORUNDUM_UPGRADE_INGREDIENTS, CHORUNDUM_UPGRADE, CHORUNDUM_UPGRADE_BASE_SLOT_DESCRIPTION, CHORUNDUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION, createChorundumUpgradeIconList(), createChorundumUpgradeMaterialList());
    }

    private static List<ResourceLocation> createChorundumUpgradeIconList() {
        return List.of(EMPTY_SLOT_HELMET, EMPTY_SLOT_SWORD, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_PICKAXE, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_AXE, EMPTY_SLOT_BOOTS, EMPTY_SLOT_HOE, EMPTY_SLOT_SHOVEL);
    }

    private static List<ResourceLocation> createChorundumUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_INGOT);
    }

    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
        pTooltipComponents.add(this.upgradeDescription);
        pTooltipComponents.add(CommonComponents.EMPTY);
        pTooltipComponents.add(APPLIES_TO_TITLE);
        pTooltipComponents.add(CommonComponents.space().append(this.appliesTo));
        pTooltipComponents.add(INGREDIENTS_TITLE);
        pTooltipComponents.add(CommonComponents.space().append(this.ingredients));
    }

    public Component getBaseSlotDescription() {
        return this.baseSlotDescription;
    }

    public Component getAdditionSlotDescription() {
        return this.additionsSlotDescription;
    }

    public List<ResourceLocation> getBaseSlotEmptyIcons() {
        return this.baseSlotEmptyIcons;
    }

    public List<ResourceLocation> getAdditionalSlotEmptyIcons() {
        return this.additionalSlotEmptyIcons;
    }
}