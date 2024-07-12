package net.victor.dogmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.victor.dogmod.DogMod;
import net.victor.dogmod.block.ModBlocks;
import net.victor.dogmod.item.custom.CropHarvestItem;
import net.victor.dogmod.item.custom.MetalDetectorItem;

public class ModItems {

    // TEST ITEMS
    public static final Item DOG = registerItem("dog", new Item(new Item.Settings()));
    public static final Item DOG2 = registerItem("dog2", new Item(new Item.Settings()));
    public static final Item METAL_DETECTOR = registerItem("metal_detector", new MetalDetectorItem(new Item.Settings().maxDamage(64)));
    public static final Item CROP_HARVESTER = registerItem("crop_harvester", new CropHarvestItem(new Item.Settings()));
    public static final Item GRAPE = registerItem("grape", new Item(new Item.Settings().food(ModFoodComponents.GRAPE)));
    public static final Item SVARTBIT = registerItem("svartbit", new Item(new Item.Settings()));

    // BULB ITEMS
    public static final Item RAW_BULB = registerItem("raw_bulb", new Item(new Item.Settings()));
    public static final Item BULB_INGOT = registerItem("bulb_ingot", new Item(new Item.Settings()));
    public static final Item BULB_PICKAXE = registerItem("bulb_pickaxe", new PickaxeItem(ModToolMaterial.BULB, new Item.Settings().attributeModifiers((PickaxeItem.createAttributeModifiers(ModToolMaterial.BULB, 2f, -2f)))));
    public static final Item BULB_AXE = registerItem("bulb_axe", new AxeItem(ModToolMaterial.BULB, new Item.Settings().attributeModifiers((PickaxeItem.createAttributeModifiers(ModToolMaterial.BULB, 7f, -1f)))));
    public static final Item BULB_SHOVEL = registerItem("bulb_shovel", new ShovelItem(ModToolMaterial.BULB, new Item.Settings().attributeModifiers((PickaxeItem.createAttributeModifiers(ModToolMaterial.BULB, 2f, -2f)))));
    public static final Item BULB_SWORD = registerItem("bulb_sword", new SwordItem(ModToolMaterial.BULB, new Item.Settings().attributeModifiers((PickaxeItem.createAttributeModifiers(ModToolMaterial.BULB, 5f, -3f)))));
    public static final Item BULB_HOE = registerItem("bulb_hoe", new HoeItem(ModToolMaterial.BULB, new Item.Settings().attributeModifiers((PickaxeItem.createAttributeModifiers(ModToolMaterial.BULB, 0f, -2f)))));
    public static final Item BULB_HELMET = registerItem("bulb_helmet", new ArmorItem(ModArmorMaterials.BULB, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));
    public static final Item BULB_CHESTPLATE = registerItem("bulb_chestplate", new ArmorItem(ModArmorMaterials.BULB, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));
    public static final Item BULB_LEGGINGS = registerItem("bulb_leggings", new ArmorItem(ModArmorMaterials.BULB, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));
    public static final Item BULB_BOOTS = registerItem("bulb_boots", new ArmorItem(ModArmorMaterials.BULB, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));


    // FOOD ITEMS
    public static final Item GREEN_BELL_PEPPER_SEEDS = registerItem("green_bell_pepper_seeds", new AliasedBlockItem(ModBlocks.GREEN_BELL_PEPPER_CROP, new Item.Settings()));
    public static final Item RED_BELL_PEPPER_SEEDS = registerItem("red_bell_pepper_seeds", new AliasedBlockItem(ModBlocks.RED_BELL_PEPPER_CROP, new Item.Settings()));
    public static final Item YELLOW_BELL_PEPPER_SEEDS = registerItem("yellow_bell_pepper_seeds", new AliasedBlockItem(ModBlocks.YELLOW_BELL_PEPPER_CROP, new Item.Settings()));
    public static final Item CORN_SEEDS = registerItem("corn_seeds", new AliasedBlockItem(ModBlocks.CORN_CROP, new Item.Settings()));
    public static final Item LETTUCE_SEEDS = registerItem("lettuce_seeds", new AliasedBlockItem(ModBlocks.LETTUCE_CROP, new Item.Settings()));

    public static final Item GREEN_BELL_PEPPER = registerItem("green_bell_pepper", new Item(new Item.Settings().food(ModFoodComponents.GREEN_BELL_PEPPER)));
    public static final Item RED_BELL_PEPPER = registerItem("red_bell_pepper", new Item(new Item.Settings().food(ModFoodComponents.RED_BELL_PEPPER)));
    public static final Item YELLOW_BELL_PEPPER = registerItem("yellow_bell_pepper", new Item(new Item.Settings().food(ModFoodComponents.YELLOW_BELL_PEPPER)));
    public static final Item CORN = registerItem("corn", new Item(new Item.Settings().food(ModFoodComponents.CORN)));
    public static final Item LETTUCE = registerItem("lettuce", new Item(new Item.Settings().food(ModFoodComponents.LETTUCE)));





    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(DOG);
        entries.add(DOG2);
    }

    private static Item registerItem(String name, Item item) {
    return Registry.register(Registries.ITEM, new Identifier(DogMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        DogMod.LOGGER.info("Registering Mod Items for " + DogMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
