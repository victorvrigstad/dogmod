package net.victor.dogmod.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.victor.dogmod.DogMod;
import net.victor.dogmod.block.custom.SoundBlock;
import net.victor.dogmod.block.custom.crops.*;

public class ModBlocks {
    public static final Block DOG_BLOCK = registerBlock("dog_block",
            new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.SLIME)));
    public static final Block DOG_BLOCK2 = registerBlock("dog_block2",
            new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.SLIME)));

    public static final Block BULB_BLOCK = registerBlock("bulb_block",
            new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
    public static final Block BULB_ORE = registerBlock("bulb_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.IRON_ORE)));
    public static final Block DEEPSLATE_BULB_ORE = registerBlock("deepslate_bulb_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE_IRON_ORE)));

    public static final Block GREEN_BELL_PEPPER_CROP = Registry.register(Registries.BLOCK, new Identifier(DogMod.MOD_ID, "green_bell_pepper_crop"),
            new GreenBellPepperCropBlock(AbstractBlock.Settings.copy(Blocks.WHEAT)));
    public static final Block RED_BELL_PEPPER_CROP = Registry.register(Registries.BLOCK, new Identifier(DogMod.MOD_ID, "red_bell_pepper_crop"),
            new RedBellPepperCropBlock(AbstractBlock.Settings.copy(Blocks.WHEAT)));
    public static final Block YELLOW_BELL_PEPPER_CROP = Registry.register(Registries.BLOCK, new Identifier(DogMod.MOD_ID, "yellow_bell_pepper_crop"),
            new YellowBellPepperCropBlock(AbstractBlock.Settings.copy(Blocks.WHEAT)));

    public static final Block CORN_CROP = Registry.register(Registries.BLOCK, new Identifier(DogMod.MOD_ID, "corn_crop"),
            new CornCropBlock(AbstractBlock.Settings.copy(Blocks.WHEAT)));

    public static final Block LETTUCE_CROP = Registry.register(Registries.BLOCK, new Identifier(DogMod.MOD_ID, "lettuce_crop"),
            new LettuceCropBlock(AbstractBlock.Settings.copy(Blocks.WHEAT)));


    public static final Block SOUND_BLOCK = registerBlock("sound_block",
            new SoundBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.SLIME)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(DogMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(DogMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        DogMod.LOGGER.info("Registering ModBlocks for " + DogMod.MOD_ID);
    }
}
