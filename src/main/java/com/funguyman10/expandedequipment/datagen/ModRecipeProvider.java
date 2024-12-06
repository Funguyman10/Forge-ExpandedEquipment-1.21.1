package com.funguyman10.expandedequipment.datagen;

import com.funguyman10.expandedequipment.ExpandedEquipment;
import com.funguyman10.expandedequipment.block.ModBlocks;
import com.funguyman10.expandedequipment.item.ModItems;
import com.funguyman10.expandedequipment.util.ModTags;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.forgespi.language.IModInfo;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        List<ItemLike> EXPANDEDEQUIPMENT_CHORUNDUM_SMELTABLES = List.of(ModItems.RAW_CHORUNDUM.get(), ModBlocks.END_CHORUNDUM_ORE.get());
        List<ItemLike> EXPANDEDEQUIPMENT_ENERGETIC_SMELTABLES = List.of(ModBlocks.ENERGETIC_DEEPSLATE_ORE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CHORUNDUM_BLOCK.get())
                .pattern("DDD")
                .pattern("DDD")
                .pattern("DDD")
                .define('D', ModItems.CHORUNDUM.get())
                .unlockedBy("has_chorundum", has(ModItems.CHORUNDUM.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_CHORUNDUM_BLOCK.get())
                .pattern("DDD")
                .pattern("DDD")
                .pattern("DDD")
                .define('D', ModItems.RAW_CHORUNDUM.get())
                .unlockedBy("has_chorundum", has(ModItems.RAW_CHORUNDUM.get())).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CHORUNDUM.get(), 9)
                .requires(ModBlocks.CHORUNDUM_BLOCK.get())
                .unlockedBy("has_chorundum_block", has(ModBlocks.CHORUNDUM_BLOCK.get())).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_CHORUNDUM.get(), 9)
                .requires(ModBlocks.RAW_CHORUNDUM_BLOCK.get())
                .unlockedBy("has_raw_chorundum_block", has(ModBlocks.RAW_CHORUNDUM_BLOCK.get())).save(recipeOutput);

        oreSmelting(recipeOutput, EXPANDEDEQUIPMENT_CHORUNDUM_SMELTABLES, RecipeCategory.MISC, ModItems.CHORUNDUM.get(), 0.5f, 200, "chorundum");
        oreBlasting(recipeOutput, EXPANDEDEQUIPMENT_CHORUNDUM_SMELTABLES, RecipeCategory.MISC, ModItems.CHORUNDUM.get(), 0.5f, 100, "chorundum");

        oreSmelting(recipeOutput, EXPANDEDEQUIPMENT_ENERGETIC_SMELTABLES, RecipeCategory.MISC, ModItems.ENERGETIC_ROCK.get(), 0.1f, 200, "energetic_rock");
        oreBlasting(recipeOutput, EXPANDEDEQUIPMENT_ENERGETIC_SMELTABLES, RecipeCategory.MISC, ModItems.ENERGETIC_ROCK.get(), 0.1f, 100, "energetic_rock");

        //CHORUNDUM SMITHING TEMPLATE DUPLICATION
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CHORUNDUM_UPGRADE_TEMPLATE.get(), 2)
                .pattern("DAD")
                .pattern("DSD")
                .pattern("DDD")
                .define('D', Items.DIAMOND)
                .define('S', Items.END_STONE)
                .define('A', ModItems.CHORUNDUM_UPGRADE_TEMPLATE.get())
                .unlockedBy("has_chorundum_upgrade_template", has(ModItems.CHORUNDUM_UPGRADE_TEMPLATE.get())).save(recipeOutput);

        //ENERGETIC ROCK TORCH RECIPE
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.TORCH, 6)
                .pattern("D")
                .pattern("S")
                .define('D', ModItems.ENERGETIC_ROCK.get())
                .define('S', Items.STICK)
                .unlockedBy("has_energetic_rock", has(ModItems.ENERGETIC_ROCK.get())).save(recipeOutput, ExpandedEquipment.MOD_ID + ":torch_from_energetic_rock");

        //COPPER TOOLS AND ARMOR

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPER_PICKAXE.get())
                .pattern("DDD")
                .pattern(" S ")
                .pattern(" S ")
                .define('D', Items.COPPER_INGOT)
                .define('S', Items.STICK)
                .unlockedBy("has_copper_ingots_and_sticks", has(Items.COPPER_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPER_SHOVEL.get())
                .pattern("D")
                .pattern("S")
                .pattern("S")
                .define('D', Items.COPPER_INGOT)
                .define('S', Items.STICK)
                .unlockedBy("has_copper_ingots_and_sticks", has(Items.COPPER_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPER_AXE.get())
                .pattern("DD")
                .pattern("DS")
                .pattern(" S")
                .define('D', Items.COPPER_INGOT)
                .define('S', Items.STICK)
                .unlockedBy("has_copper_ingots_and_sticks", has(Items.COPPER_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPER_HOE.get())
                .pattern("DD")
                .pattern(" S")
                .pattern(" S")
                .define('D', Items.COPPER_INGOT)
                .define('S', Items.STICK)
                .unlockedBy("has_copper_ingots_and_sticks", has(Items.COPPER_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.COPPER_SWORD.get())
                .pattern("D")
                .pattern("D")
                .pattern("S")
                .define('D', Items.COPPER_INGOT)
                .define('S', Items.STICK)
                .unlockedBy("has_copper_ingots_and_sticks", has(Items.COPPER_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.COPPER_HELMET.get())
                .pattern("DDD")
                .pattern("D D")
                .define('D', Items.COPPER_INGOT)
                .unlockedBy("has_copper_ingots", has(Items.COPPER_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.COPPER_CHESTPLATE.get())
                .pattern("D D")
                .pattern("DDD")
                .pattern("DDD")
                .define('D', Items.COPPER_INGOT)
                .unlockedBy("has_copper_ingots", has(Items.COPPER_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.COPPER_LEGGINGS.get())
                .pattern("DDD")
                .pattern("D D")
                .pattern("D D")
                .define('D', Items.COPPER_INGOT)
                .unlockedBy("has_copper_ingots", has(Items.COPPER_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.COPPER_BOOTS.get())
                .pattern("D D")
                .pattern("D D")
                .define('D', Items.COPPER_INGOT)
                .unlockedBy("has_copper_ingots", has(Items.COPPER_INGOT)).save(recipeOutput);

        //PAXEL RECIPES

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPER_PAXEL.get())
                .pattern("DWA")
                .pattern(" S ")
                .pattern(" S ")
                .define('D', ModItems.COPPER_AXE.get())
                .define('W', ModItems.COPPER_PICKAXE.get())
                .define('A', ModItems.COPPER_SHOVEL.get())
                .define('S', Items.STICK)
                .unlockedBy("has_copper_tools", has(ModItems.COPPER_PICKAXE.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.WOODEN_PAXEL.get())
                .pattern("DWA")
                .pattern(" S ")
                .pattern(" S ")
                .define('D', Items.WOODEN_AXE)
                .define('W', Items.WOODEN_PICKAXE)
                .define('A', Items.WOODEN_SHOVEL)
                .define('S', Items.STICK)
                .unlockedBy("has_wooden_tools", has(Items.WOODEN_PICKAXE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.STONE_PAXEL.get())
                .pattern("DWA")
                .pattern(" S ")
                .pattern(" S ")
                .define('D', Items.STONE_AXE)
                .define('W', Items.STONE_PICKAXE)
                .define('A', Items.STONE_SHOVEL)
                .define('S', Items.STICK)
                .unlockedBy("has_stone_tools", has(Items.STONE_PICKAXE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.IRON_PAXEL.get())
                .pattern("DWA")
                .pattern(" S ")
                .pattern(" S ")
                .define('D', Items.IRON_AXE)
                .define('W', Items.IRON_PICKAXE)
                .define('A', Items.IRON_SHOVEL)
                .define('S', Items.STICK)
                .unlockedBy("has_iron_tools", has(Items.IRON_PICKAXE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GOLDEN_PAXEL.get())
                .pattern("DWA")
                .pattern(" S ")
                .pattern(" S ")
                .define('D', Items.GOLDEN_AXE)
                .define('W', Items.GOLDEN_PICKAXE)
                .define('A', Items.GOLDEN_SHOVEL)
                .define('S', Items.STICK)
                .unlockedBy("has_gold_tools", has(Items.GOLDEN_PICKAXE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.DIAMOND_PAXEL.get())
                .pattern("DWA")
                .pattern(" S ")
                .pattern(" S ")
                .define('D', Items.DIAMOND_AXE)
                .define('W', Items.DIAMOND_PICKAXE)
                .define('A', Items.DIAMOND_SHOVEL)
                .define('S', Items.STICK)
                .unlockedBy("has_diamond_tools", has(Items.DIAMOND_PICKAXE)).save(recipeOutput);

        SmithingTransformRecipeBuilder.smithing(
                        // The template ingredient.
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        // The base ingredient.
                        Ingredient.of(ModItems.DIAMOND_PAXEL.get()),
                        // The addition ingredient.
                        Ingredient.of(Items.NETHERITE_INGOT),
                        // The recipe book category.
                        RecipeCategory.TOOLS,
                        // The result item.
                        ModItems.NETHERITE_PAXEL.get())
                // The recipe advancement, like with the other recipes above.
                .unlocks("has_netherite_upgrade_template", has(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE))
                // This overload of #save allows us to specify a name.
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ExpandedEquipment.MOD_ID, "netherite_paxel_smithing"));

        //CHORUNDUM TOOLS AND ARMOR
        SmithingTransformRecipeBuilder.smithing(
                        // The template ingredient.
                        Ingredient.of(ModItems.CHORUNDUM_UPGRADE_TEMPLATE.get()),
                        // The base ingredient.
                        Ingredient.of(Items.NETHERITE_PICKAXE),
                        // The addition ingredient.
                        Ingredient.of(ModItems.CHORUNDUM.get()),
                        // The recipe book category.
                        RecipeCategory.TOOLS,
                        // The result item.
                        ModItems.CHORUNDUM_PICKAXE.get())
                // The recipe advancement, like with the other recipes above.
                .unlocks("has_chorundum_upgrade_template", has(ModItems.CHORUNDUM_UPGRADE_TEMPLATE.get()))
                // This overload of #save allows us to specify a name.
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ExpandedEquipment.MOD_ID, "netherite_pickaxe_upgrade"));

        SmithingTransformRecipeBuilder.smithing(
                        // The template ingredient.
                        Ingredient.of(ModItems.CHORUNDUM_UPGRADE_TEMPLATE.get()),
                        // The base ingredient.
                        Ingredient.of(Items.NETHERITE_AXE),
                        // The addition ingredient.
                        Ingredient.of(ModItems.CHORUNDUM.get()),
                        // The recipe book category.
                        RecipeCategory.TOOLS,
                        // The result item.
                        ModItems.CHORUNDUM_AXE.get())
                // The recipe advancement, like with the other recipes above.
                .unlocks("has_chorundum_upgrade_template", has(ModItems.CHORUNDUM_UPGRADE_TEMPLATE.get()))
                // This overload of #save allows us to specify a name.
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ExpandedEquipment.MOD_ID, "netherite_axe_upgrade"));

        SmithingTransformRecipeBuilder.smithing(
                        // The template ingredient.
                        Ingredient.of(ModItems.CHORUNDUM_UPGRADE_TEMPLATE.get()),
                        // The base ingredient.
                        Ingredient.of(Items.NETHERITE_SHOVEL),
                        // The addition ingredient.
                        Ingredient.of(ModItems.CHORUNDUM.get()),
                        // The recipe book category.
                        RecipeCategory.TOOLS,
                        // The result item.
                        ModItems.CHORUNDUM_SHOVEL.get())
                // The recipe advancement, like with the other recipes above.
                .unlocks("has_chorundum_upgrade_template", has(ModItems.CHORUNDUM_UPGRADE_TEMPLATE.get()))
                // This overload of #save allows us to specify a name.
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ExpandedEquipment.MOD_ID, "netherite_shovel_upgrade"));

        SmithingTransformRecipeBuilder.smithing(
                        // The template ingredient.
                        Ingredient.of(ModItems.CHORUNDUM_UPGRADE_TEMPLATE.get()),
                        // The base ingredient.
                        Ingredient.of(Items.NETHERITE_HOE),
                        // The addition ingredient.
                        Ingredient.of(ModItems.CHORUNDUM.get()),
                        // The recipe book category.
                        RecipeCategory.TOOLS,
                        // The result item.
                        ModItems.CHORUNDUM_HOE.get())
                // The recipe advancement, like with the other recipes above.
                .unlocks("has_chorundum_upgrade_template", has(ModItems.CHORUNDUM_UPGRADE_TEMPLATE.get()))
                // This overload of #save allows us to specify a name.
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ExpandedEquipment.MOD_ID, "netherite_hoe_upgrade"));

        SmithingTransformRecipeBuilder.smithing(
                        // The template ingredient.
                        Ingredient.of(ModItems.CHORUNDUM_UPGRADE_TEMPLATE.get()),
                        // The base ingredient.
                        Ingredient.of(Items.NETHERITE_SWORD),
                        // The addition ingredient.
                        Ingredient.of(ModItems.CHORUNDUM.get()),
                        // The recipe book category.
                        RecipeCategory.TOOLS,
                        // The result item.
                        ModItems.CHORUNDUM_SWORD.get())
                // The recipe advancement, like with the other recipes above.
                .unlocks("has_chorundum_upgrade_template", has(ModItems.CHORUNDUM_UPGRADE_TEMPLATE.get()))
                // This overload of #save allows us to specify a name.
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ExpandedEquipment.MOD_ID, "netherite_sword_upgrade"));

        SmithingTransformRecipeBuilder.smithing(
                        // The template ingredient.
                        Ingredient.of(ModItems.CHORUNDUM_UPGRADE_TEMPLATE.get()),
                        // The base ingredient.
                        Ingredient.of(ModItems.NETHERITE_PAXEL.get()),
                        // The addition ingredient.
                        Ingredient.of(ModItems.CHORUNDUM.get()),
                        // The recipe book category.
                        RecipeCategory.TOOLS,
                        // The result item.
                        ModItems.CHORUNDUM_PAXEL.get())
                // The recipe advancement, like with the other recipes above.
                .unlocks("has_chorundum_upgrade_template", has(ModItems.CHORUNDUM_UPGRADE_TEMPLATE.get()))
                // This overload of #save allows us to specify a name.
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ExpandedEquipment.MOD_ID, "netherite_paxel_upgrade"));

        SmithingTransformRecipeBuilder.smithing(
                        // The template ingredient.
                        Ingredient.of(ModItems.CHORUNDUM_UPGRADE_TEMPLATE.get()),
                        // The base ingredient.
                        Ingredient.of(Items.NETHERITE_HELMET),
                        // The addition ingredient.
                        Ingredient.of(ModItems.CHORUNDUM.get()),
                        // The recipe book category.
                        RecipeCategory.COMBAT,
                        // The result item.
                        ModItems.CHORUNDUM_HELMET.get())
                // The recipe advancement, like with the other recipes above.
                .unlocks("has_chorundum_upgrade_template", has(ModItems.CHORUNDUM_UPGRADE_TEMPLATE.get()))
                // This overload of #save allows us to specify a name.
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ExpandedEquipment.MOD_ID, "netherite_helmet_upgrade"));

        SmithingTransformRecipeBuilder.smithing(
                        // The template ingredient.
                        Ingredient.of(ModItems.CHORUNDUM_UPGRADE_TEMPLATE.get()),
                        // The base ingredient.
                        Ingredient.of(Items.NETHERITE_CHESTPLATE),
                        // The addition ingredient.
                        Ingredient.of(ModItems.CHORUNDUM.get()),
                        // The recipe book category.
                        RecipeCategory.COMBAT,
                        // The result item.
                        ModItems.CHORUNDUM_CHESTPLATE.get())
                // The recipe advancement, like with the other recipes above.
                .unlocks("has_chorundum_upgrade_template", has(ModItems.CHORUNDUM_UPGRADE_TEMPLATE.get()))
                // This overload of #save allows us to specify a name.
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ExpandedEquipment.MOD_ID,"netherite_chestplate_upgrade"));

        SmithingTransformRecipeBuilder.smithing(
                        // The template ingredient.
                        Ingredient.of(ModItems.CHORUNDUM_UPGRADE_TEMPLATE.get()),
                        // The base ingredient.
                        Ingredient.of(Items.NETHERITE_LEGGINGS),
                        // The addition ingredient.
                        Ingredient.of(ModItems.CHORUNDUM.get()),
                        // The recipe book category.
                        RecipeCategory.COMBAT,
                        // The result item.
                        ModItems.CHORUNDUM_LEGGINGS.get())
                // The recipe advancement, like with the other recipes above.
                .unlocks("has_chorundum_upgrade_template", has(ModItems.CHORUNDUM_UPGRADE_TEMPLATE.get()))
                // This overload of #save allows us to specify a name.
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ExpandedEquipment.MOD_ID,"netherite_leggings_upgrade"));

        SmithingTransformRecipeBuilder.smithing(
                        // The template ingredient.
                        Ingredient.of(ModItems.CHORUNDUM_UPGRADE_TEMPLATE.get()),
                        // The base ingredient.
                        Ingredient.of(Items.NETHERITE_BOOTS),
                        // The addition ingredient.
                        Ingredient.of(ModItems.CHORUNDUM.get()),
                        // The recipe book category.
                        RecipeCategory.COMBAT,
                        // The result item.
                        ModItems.CHORUNDUM_BOOTS.get())
                // The recipe advancement, like with the other recipes above.
                .unlocks("has_chorundum_upgrade_template", has(ModItems.CHORUNDUM_UPGRADE_TEMPLATE.get()))
                // This overload of #save allows us to specify a name.
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ExpandedEquipment.MOD_ID, "netherite_boots_upgrade"));

        //Spear recipes
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.COPPER_SPEAR.get())
                .pattern("  D")
                .pattern(" S ")
                .pattern("S  ")
                .define('D', Items.COPPER_INGOT)
                .define('S', Items.STICK)
                .unlockedBy("has_copper_ingots_and_sticks", has(Items.COPPER_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.WOODEN_SPEAR.get())
                .pattern("  D")
                .pattern(" S ")
                .pattern("S  ")
                .define('D', ItemTags.PLANKS)
                .define('S', Items.STICK)
                .unlockedBy("has_planks", has(ItemTags.PLANKS))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.STONE_SPEAR.get())
                .pattern("  D")
                .pattern(" S ")
                .pattern("S  ")
                .define('D', ItemTags.STONE_TOOL_MATERIALS)
                .define('S', Items.STICK)
                .unlockedBy("has_tool_stone", has(ItemTags.STONE_TOOL_MATERIALS))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.GOLDEN_SPEAR.get())
                .pattern("  D")
                .pattern(" S ")
                .pattern("S  ")
                .define('D', Items.GOLD_INGOT)
                .define('S', Items.STICK)
                .unlockedBy("has_gold_ingot", has(Items.GOLD_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.IRON_SPEAR.get())
                .pattern("  D")
                .pattern(" S ")
                .pattern("S  ")
                .define('D', Items.IRON_INGOT)
                .define('S', Items.STICK)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.DIAMOND_SPEAR.get())
                .pattern("  D")
                .pattern(" S ")
                .pattern("S  ")
                .define('D', Items.DIAMOND)
                .define('S', Items.STICK)
                .unlockedBy("has_diamond", has(Items.DIAMOND))
                .save(recipeOutput);

        SmithingTransformRecipeBuilder.smithing(
                        // The template ingredient.
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        // The base ingredient.
                        Ingredient.of(ModItems.DIAMOND_SPEAR.get()),
                        // The addition ingredient.
                        Ingredient.of(Items.NETHERITE_INGOT),
                        // The recipe book category.
                        RecipeCategory.COMBAT,
                        // The result item.
                        ModItems.NETHERITE_SPEAR.get())
                // The recipe advancement, like with the other recipes above.
                .unlocks("has_netherite_upgrade_template", has(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE))
                // This overload of #save allows us to specify a name.
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ExpandedEquipment.MOD_ID, "diamond_spear_upgrade"));

        SmithingTransformRecipeBuilder.smithing(
                        // The template ingredient.
                        Ingredient.of(ModItems.CHORUNDUM_UPGRADE_TEMPLATE.get()),
                        // The base ingredient.
                        Ingredient.of(ModItems.NETHERITE_SPEAR.get()),
                        // The addition ingredient.
                        Ingredient.of(ModItems.CHORUNDUM.get()),
                        // The recipe book category.
                        RecipeCategory.COMBAT,
                        // The result item.
                        ModItems.CHORUNDUM_SPEAR.get())
                // The recipe advancement, like with the other recipes above.
                .unlocks("has_chorundum_upgrade_template", has(ModItems.CHORUNDUM_UPGRADE_TEMPLATE.get()))
                // This overload of #save allows us to specify a name.
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(ExpandedEquipment.MOD_ID, "netherite_spear_upgrade"));

    }

    protected static void oreSmelting(RecipeOutput recipeOutput,
                                      List<ItemLike> pIngredients,
                                      RecipeCategory pCategory,
                                      ItemLike pResult,
                                      float pExperience,
                                      int pCookingTIme,
                                      String pGroup) {
        oreCooking(recipeOutput,
                RecipeSerializer.SMELTING_RECIPE,
                SmeltingRecipe::new, pIngredients,
                pCategory,
                pResult,
                pExperience,
                pCookingTIme,
                pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput,
                                      List<ItemLike> pIngredients,
                                      RecipeCategory pCategory,
                                      ItemLike pResult,
                                      float pExperience,
                                      int pCookingTime,
                                      String pGroup) {
        oreCooking(recipeOutput,
                RecipeSerializer.BLASTING_RECIPE,
                BlastingRecipe::new, pIngredients,
                pCategory,
                pResult,
                pExperience,
                pCookingTime,
                pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput,
                                                                       RecipeSerializer<T> pCookingSerializer,
                                                                       AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients,
                                                                       RecipeCategory pCategory,
                                                                       ItemLike pResult,
                                                                       float pExperience,
                                                                       int pCookingTime,
                                                                       String pGroup,
                                                                       String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory)
                    .group(pGroup)
                    .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, ExpandedEquipment.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }

    public class CustomSmithingTransformRecipeBuilder {
        private final Ingredient pTemplate;
        private final Ingredient pBase;
        private final Ingredient pAddition;
        private final RecipeCategory pCategory;
        private final Item pResult;
        private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();

        public CustomSmithingTransformRecipeBuilder(Ingredient pTemplate, Ingredient pBase, Ingredient pAddition, RecipeCategory pCategory, Item pResult) {
            this.pCategory = pCategory;
            this.pTemplate = pTemplate;
            this.pBase = pBase;
            this.pAddition = pAddition;
            this.pResult = pResult;
        }

        public static SmithingTransformRecipeBuilder smithing(
                Ingredient template, Ingredient base, Ingredient addition, RecipeCategory category, Item result
        ) {
            return new SmithingTransformRecipeBuilder(template, base, addition, category, result);
        }

        public CustomSmithingTransformRecipeBuilder unlocks(String key, Criterion<?> criterion) {
            this.criteria.put(key, criterion);
            return this;
        }

        public void save(RecipeOutput recipeOutput, String recipeId) {
            this.save(recipeOutput, ResourceLocation.parse(recipeId));
        }

        public void save(RecipeOutput recipeOutput, ResourceLocation recipeId) {
            this.ensureValid(recipeId);
            Advancement.Builder advancement$builder = recipeOutput.advancement()
                    .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeId))
                    .rewards(AdvancementRewards.Builder.recipe(recipeId))
                    .requirements(AdvancementRequirements.Strategy.OR);
            this.criteria.forEach(advancement$builder::addCriterion);
            SmithingTransformRecipe smithingtransformrecipe = new SmithingTransformRecipe(this.pTemplate, this.pBase, this.pAddition, this.pResult.getDefaultInstance());
            recipeOutput.accept(recipeId, smithingtransformrecipe, advancement$builder.build(recipeId.withPrefix("recipes/" + this.pCategory.getFolderName() + "/")));
        }

        private void ensureValid(ResourceLocation location) {
            if (this.criteria.isEmpty()) {
                throw new IllegalStateException("No way of obtaining recipe " + location);
            }
        }
    }
}