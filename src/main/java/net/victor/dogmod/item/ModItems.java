package net.victor.dogmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.victor.dogmod.DogMod;
import net.victor.dogmod.item.custom.MetalDetectorItem;

public class ModItems {
    public static final Item DOG = registerItem("dog", new Item(new Item.Settings()));
    public static final Item DOG2 = registerItem("dog2", new Item(new Item.Settings()));

    public static final Item METAL_DETECTOR = registerItem("metal_detector", new MetalDetectorItem(new Item.Settings().maxDamage(64)));

    public static final Item GRAPE = registerItem("grape", new Item(new Item.Settings().food(ModFoodComponents.GRAPE)));
    public static final Item SVARTBIT = registerItem("svartbit", new Item(new Item.Settings()));

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
