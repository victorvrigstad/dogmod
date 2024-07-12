package net.victor.dogmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.victor.dogmod.block.ModBlocks;
import net.victor.dogmod.block.custom.crops.*;
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

        blockStateModelGenerator.registerCrop(ModBlocks.GREEN_BELL_PEPPER_CROP, GreenBellPepperCropBlock.AGE, 0, 1, 2, 3);
        blockStateModelGenerator.registerCrop(ModBlocks.RED_BELL_PEPPER_CROP, RedBellPepperCropBlock.AGE, 0, 1, 2, 3);
        blockStateModelGenerator.registerCrop(ModBlocks.YELLOW_BELL_PEPPER_CROP, YellowBellPepperCropBlock.AGE, 0, 1, 2, 3);
        blockStateModelGenerator.registerCrop(ModBlocks.CORN_CROP, CornCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6, 7, 8);
        blockStateModelGenerator.registerCrop(ModBlocks.LETTUCE_CROP, LettuceCropBlock.AGE, 0, 1, 2, 3);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.DOG, Models.GENERATED);
        itemModelGenerator.register(ModItems.DOG2, Models.GENERATED);
        itemModelGenerator.register(ModItems.METAL_DETECTOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.CROP_HARVESTER, Models.GENERATED);
        itemModelGenerator.register(ModItems.SVARTBIT, Models.GENERATED);
        itemModelGenerator.register(ModItems.GRAPE, Models.GENERATED);

        itemModelGenerator.register(ModItems.RAW_BULB, Models.GENERATED);
        itemModelGenerator.register(ModItems.BULB_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.BULB_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BULB_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BULB_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BULB_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BULB_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.GREEN_BELL_PEPPER, Models.GENERATED);
        itemModelGenerator.register(ModItems.RED_BELL_PEPPER, Models.GENERATED);
        itemModelGenerator.register(ModItems.YELLOW_BELL_PEPPER, Models.GENERATED);
        itemModelGenerator.register(ModItems.CORN, Models.GENERATED);
        itemModelGenerator.register(ModItems.LETTUCE, Models.GENERATED);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.BULB_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.BULB_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.BULB_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.BULB_BOOTS);


    }
}
