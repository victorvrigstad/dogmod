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

public class ModItemGroups {
    public static final ItemGroup DOG_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(DogMod.MOD_ID, "dog"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.dog"))
                    .icon(() -> new ItemStack(ModItems.DOG)).entries((displayContext, entries) -> {
                        entries.add(ModItems.DOG);
                        entries.add(ModItems.DOG2);

                        entries.add(Items.PUFFERFISH);

                    }).build());

    public static void registerItemGroups() {
        DogMod.LOGGER.info("Registering Item Groups for " + DogMod.MOD_ID);
    }
}
