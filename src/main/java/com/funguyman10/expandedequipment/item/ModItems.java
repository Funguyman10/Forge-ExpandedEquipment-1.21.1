package com.funguyman10.expandedequipment.item;

import com.funguyman10.expandedequipment.ExpandedEquipment;
import com.funguyman10.expandedequipment.custom.CustomSmithingTemplateItem;
import com.funguyman10.expandedequipment.custom.FuelItem;
import com.funguyman10.expandedequipment.custom.PaxelItem;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ExpandedEquipment.MOD_ID);

    public static final RegistryObject<Item> RAW_CHORUNDUM = ITEMS.register("raw_chorundum",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CHORUNDUM = ITEMS.register("chorundum",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ENERGETIC_ROCK = ITEMS.register("energetic_rock",
            () -> new FuelItem(new Item.Properties(), 2400));

    public static final RegistryObject<PickaxeItem> COPPER_PICKAXE = ITEMS.register("copper_pickaxe",
            () -> new PickaxeItem(ModToolTiers.COPPER, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.COPPER, 1, -2.8f))));
    public static final RegistryObject<AxeItem> COPPER_AXE = ITEMS.register("copper_axe",
            () -> new AxeItem(ModToolTiers.COPPER, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.COPPER, 6, -3.1f))));
    public static final RegistryObject<ShovelItem> COPPER_SHOVEL = ITEMS.register("copper_shovel",
            () -> new ShovelItem(ModToolTiers.COPPER, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.COPPER, 1.5f, -3))));
    public static final RegistryObject<HoeItem> COPPER_HOE = ITEMS.register("copper_hoe",
            () -> new HoeItem(ModToolTiers.COPPER, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.COPPER, -2, 0))));
    public static final RegistryObject<SwordItem> COPPER_SWORD = ITEMS.register("copper_sword",
            () -> new SwordItem(ModToolTiers.COPPER, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.COPPER, 3, -2.4f))));
    public static final RegistryObject<PaxelItem> COPPER_PAXEL = ITEMS.register("copper_paxel",
            () -> new PaxelItem(ModToolTiers.COPPER, new Item.Properties()
                    .attributes(PaxelItem.createAttributes(ModToolTiers.COPPER, 3, -3.0f))));

    public static final RegistryObject<PaxelItem> WOODEN_PAXEL = ITEMS.register("wooden_paxel",
            () -> new PaxelItem(Tiers.WOOD, new Item.Properties()
                    .attributes(PaxelItem.createAttributes(Tiers.WOOD, 2, -3.0f))));

    public static final RegistryObject<PaxelItem> STONE_PAXEL = ITEMS.register("stone_paxel",
            () -> new PaxelItem(Tiers.STONE, new Item.Properties()
                    .attributes(PaxelItem.createAttributes(Tiers.STONE, 3, -3.0f))));

    public static final RegistryObject<PaxelItem> IRON_PAXEL = ITEMS.register("iron_paxel",
            () -> new PaxelItem(Tiers.IRON, new Item.Properties()
                    .attributes(PaxelItem.createAttributes(Tiers.IRON, 3, -3.0f))));

    public static final RegistryObject<PaxelItem> DIAMOND_PAXEL = ITEMS.register("diamond_paxel",
            () -> new PaxelItem(Tiers.DIAMOND, new Item.Properties()
                    .attributes(PaxelItem.createAttributes(Tiers.DIAMOND, 3, -3.0f))));

    public static final RegistryObject<PaxelItem> GOLDEN_PAXEL = ITEMS.register("golden_paxel",
            () -> new PaxelItem(Tiers.GOLD, new Item.Properties()
                    .attributes(PaxelItem.createAttributes(Tiers.GOLD, 3, -3.0f))));

    public static final RegistryObject<PaxelItem> NETHERITE_PAXEL = ITEMS.register("netherite_paxel",
            () -> new PaxelItem(Tiers.NETHERITE, new Item.Properties()
                    .attributes(PaxelItem.createAttributes(Tiers.NETHERITE, 3, -3.0f))));

    public static final RegistryObject<PickaxeItem> CHORUNDUM_PICKAXE = ITEMS.register("chorundum_pickaxe",
            () -> new PickaxeItem(ModToolTiers.CHORUNDUM, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.CHORUNDUM, 1, -2.8f))));
    public static final RegistryObject<AxeItem> CHORUNDUM_AXE = ITEMS.register("chorundum_axe",
            () -> new AxeItem(ModToolTiers.CHORUNDUM, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.CHORUNDUM, 5, -3.0f))));
    public static final RegistryObject<ShovelItem> CHORUNDUM_SHOVEL = ITEMS.register("chorundum_shovel",
            () -> new ShovelItem(ModToolTiers.CHORUNDUM, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.CHORUNDUM, 0.5f, -3))));
    public static final RegistryObject<HoeItem> CHORUNDUM_HOE = ITEMS.register("chorundum_hoe",
            () -> new HoeItem(ModToolTiers.CHORUNDUM, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.CHORUNDUM, -5, 0))));
    public static final RegistryObject<SwordItem> CHORUNDUM_SWORD = ITEMS.register("chorundum_sword",
            () -> new SwordItem(ModToolTiers.CHORUNDUM, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.CHORUNDUM, 3, -2.4f))));

    public static final RegistryObject<PaxelItem> CHORUNDUM_PAXEL = ITEMS.register("chorundum_paxel",
            () -> new PaxelItem(ModToolTiers.CHORUNDUM, new Item.Properties()
                    .attributes(PaxelItem.createAttributes(ModToolTiers.CHORUNDUM, 3, -3.0f))));

    public static final RegistryObject<ArmorItem> COPPER_HELMET = ITEMS.register("copper_helmet",
            () -> new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(19))));
    public static final RegistryObject<ArmorItem> COPPER_CHESTPLATE = ITEMS.register("copper_chestplate",
            () -> new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(19))));
    public static final RegistryObject<ArmorItem> COPPER_LEGGINGS = ITEMS.register("copper_leggings",
            () -> new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(19))));
    public static final RegistryObject<ArmorItem> COPPER_BOOTS = ITEMS.register("copper_boots",
            () -> new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(19))));

    public static final RegistryObject<ArmorItem> CHORUNDUM_HELMET = ITEMS.register("chorundum_helmet",
            () -> new ArmorItem(ModArmorMaterials.CHORUNDUM_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(45))));
    public static final RegistryObject<ArmorItem> CHORUNDUM_CHESTPLATE = ITEMS.register("chorundum_chestplate",
            () -> new ArmorItem(ModArmorMaterials.CHORUNDUM_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(45))));
    public static final RegistryObject<ArmorItem> CHORUNDUM_LEGGINGS = ITEMS.register("chorundum_leggings",
            () -> new ArmorItem(ModArmorMaterials.CHORUNDUM_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(45))));
    public static final RegistryObject<ArmorItem> CHORUNDUM_BOOTS = ITEMS.register("chorundum_boots",
            () -> new ArmorItem(ModArmorMaterials.CHORUNDUM_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(45))));

    public static final RegistryObject<Item> CHORUNDUM_UPGRADE_TEMPLATE = ITEMS.register("chorundum_upgrade_template",
            CustomSmithingTemplateItem::createChorundumUpgradeTemplate);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
