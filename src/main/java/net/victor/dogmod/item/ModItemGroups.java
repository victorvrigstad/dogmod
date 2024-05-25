package net.victor.dogmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.victor.dogmod.DogMod;
import net.victor.dogmod.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup DOG_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(DogMod.MOD_ID, "dog"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.dog"))
                    .icon(() -> new ItemStack(ModItems.DOG)).entries((displayContext, entries) -> {
                        entries.add(ModItems.DOG);
                        entries.add(ModItems.DOG2);

                        entries.add(ModItems.METAL_DETECTOR);

                        entries.add(ModItems.RAW_BULB);
                        entries.add(ModItems.BULB_INGOT);

                        entries.add(ModItems.BULB_PICKAXE);
                        entries.add(ModItems.BULB_AXE);
                        entries.add(ModItems.BULB_SHOVEL);
                        entries.add(ModItems.BULB_SWORD);
                        entries.add(ModItems.BULB_HOE);

                        entries.add(ModItems.GRAPE);
                        entries.add(ModItems.SVARTBIT);

                        entries.add(Items.PUFFERFISH);

                        entries.add((ModBlocks.DOG_BLOCK));
                        entries.add((ModBlocks.DOG_BLOCK2));

                        entries.add((ModBlocks.BULB_BLOCK));
                        entries.add((ModBlocks.BULB_ORE));
                        entries.add((ModBlocks.DEEPSLATE_BULB_ORE));

                        entries.add((ModBlocks.SOUND_BLOCK));

                    }).build());

    public static void registerItemGroups() {
        DogMod.LOGGER.info("Registering Item Groups for " + DogMod.MOD_ID);
    }
}
