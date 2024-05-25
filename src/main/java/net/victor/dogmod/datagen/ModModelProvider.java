package net.victor.dogmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.victor.dogmod.block.ModBlocks;
import net.victor.dogmod.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SOUND_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DOG_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DOG_BLOCK2);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BULB_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BULB_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_BULB_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.DOG, Models.GENERATED);
        itemModelGenerator.register(ModItems.DOG2, Models.GENERATED);
        itemModelGenerator.register(ModItems.METAL_DETECTOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.SVARTBIT, Models.GENERATED);
        itemModelGenerator.register(ModItems.GRAPE, Models.GENERATED);

        itemModelGenerator.register(ModItems.RAW_BULB, Models.GENERATED);
        itemModelGenerator.register(ModItems.BULB_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.BULB_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BULB_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BULB_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BULB_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BULB_HOE, Models.HANDHELD);
    }
}
