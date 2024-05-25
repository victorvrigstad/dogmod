package net.victor.dogmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.VanillaRecipeProvider;
import net.minecraft.item.*;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.victor.dogmod.block.ModBlocks;
import net.victor.dogmod.item.ModItems;
import net.victor.dogmod.item.ModToolMaterial;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> DOG_SMELTABLES = List.of(ModItems.DOG);
    private static final List<ItemConvertible> BULB_SMELTABLES = List.of(ModItems.RAW_BULB, ModBlocks.BULB_ORE, ModBlocks.DEEPSLATE_BULB_ORE);

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerSmelting(exporter, DOG_SMELTABLES, RecipeCategory.MISC, ModItems.GRAPE, 0.7f, 200, "ruby");

        offerSmelting(exporter, BULB_SMELTABLES, RecipeCategory.MISC, ModItems.BULB_INGOT, 0.7f, 200, "bulb");
        offerBlasting(exporter, BULB_SMELTABLES, RecipeCategory.MISC, ModItems.BULB_INGOT, 0.7f, 100, "bulb");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.DOG, RecipeCategory.DECORATIONS,
                ModBlocks.DOG_BLOCK);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.BULB_INGOT, RecipeCategory.DECORATIONS,
                ModBlocks.BULB_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SVARTBIT, 1)
                .pattern("SSS")
                .pattern("SCS")
                .pattern("SSS")
                .input('S', Items.STONE)
                .input('C', ModItems.GRAPE)
                .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
                .criterion(hasItem(ModItems.GRAPE), conditionsFromItem(ModItems.GRAPE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SVARTBIT)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BULB_PICKAXE).input('#',
                        Items.STICK).input('X', ModItems.BULB_INGOT)
                .pattern("XXX")
                .pattern(" # ")
                .pattern(" # ")
                .criterion(hasItem(ModItems.BULB_INGOT), conditionsFromItem(ModItems.BULB_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BULB_AXE).input('#',
                        Items.STICK).input('X', ModItems.BULB_INGOT)
                .pattern("XX")
                .pattern("X#")
                .pattern(" #")
                .criterion(hasItem(ModItems.BULB_INGOT), conditionsFromItem(ModItems.BULB_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BULB_SHOVEL).input('#',
                        Items.STICK).input('X', ModItems.BULB_INGOT)
                .pattern("X")
                .pattern("#")
                .pattern("#")
                .criterion(hasItem(ModItems.BULB_INGOT), conditionsFromItem(ModItems.BULB_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BULB_SWORD).input('#',
                        Items.STICK).input('X', ModItems.BULB_INGOT)
                .pattern("X")
                .pattern("X")
                .pattern("#")
                .criterion(hasItem(ModItems.BULB_INGOT), conditionsFromItem(ModItems.BULB_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BULB_HOE).input('#',
                        Items.STICK).input('X', ModItems.BULB_INGOT)
                .pattern("XX")
                .pattern(" #")
                .pattern(" #")
                .criterion(hasItem(ModItems.BULB_INGOT), conditionsFromItem(ModItems.BULB_INGOT))
                .offerTo(exporter);
    }
}
