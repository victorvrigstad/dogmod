package net.victor.dogmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.AnyOfLootCondition;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryWrapper;
import net.victor.dogmod.block.ModBlocks;
import net.victor.dogmod.block.custom.crops.GreenBellPepperCropBlock;
import net.victor.dogmod.block.custom.crops.RedBellPepperCropBlock;
import net.victor.dogmod.block.custom.crops.YellowBellPepperCropBlock;
import net.victor.dogmod.block.custom.crops.CornCropBlock;
import net.victor.dogmod.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.DOG_BLOCK);
        addDrop(ModBlocks.DOG_BLOCK2);
        addDrop(ModBlocks.BULB_BLOCK);

        addDrop(ModBlocks.BULB_ORE, copperLikeOreDrops(ModBlocks.BULB_ORE, ModItems.RAW_BULB));
        addDrop(ModBlocks.DEEPSLATE_BULB_ORE, copperLikeOreDrops(ModBlocks.DEEPSLATE_BULB_ORE, ModItems.RAW_BULB));


        addDrop(ModBlocks.SOUND_BLOCK, copperLikeOreDrops(ModBlocks.SOUND_BLOCK, ModItems.GRAPE));

        BlockStatePropertyLootCondition.Builder builder1 = BlockStatePropertyLootCondition.builder(ModBlocks.GREEN_BELL_PEPPER_CROP)
                .properties(StatePredicate.Builder.create()
                .exactMatch(GreenBellPepperCropBlock.AGE, 3));
        addDrop(ModBlocks.GREEN_BELL_PEPPER_CROP, cropDrops(ModBlocks.GREEN_BELL_PEPPER_CROP, ModItems.GREEN_BELL_PEPPER, ModItems.GREEN_BELL_PEPPER_SEEDS, builder1));

        BlockStatePropertyLootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(ModBlocks.RED_BELL_PEPPER_CROP)
                .properties(StatePredicate.Builder.create()
                        .exactMatch(RedBellPepperCropBlock.AGE, 3));
        addDrop(ModBlocks.RED_BELL_PEPPER_CROP, cropDrops(ModBlocks.RED_BELL_PEPPER_CROP, ModItems.RED_BELL_PEPPER, ModItems.RED_BELL_PEPPER_SEEDS, builder2));

        BlockStatePropertyLootCondition.Builder builder3 = BlockStatePropertyLootCondition.builder(ModBlocks.YELLOW_BELL_PEPPER_CROP)
                .properties(StatePredicate.Builder.create()
                        .exactMatch(YellowBellPepperCropBlock.AGE, 3));
        addDrop(ModBlocks.YELLOW_BELL_PEPPER_CROP, cropDrops(ModBlocks.YELLOW_BELL_PEPPER_CROP, ModItems.YELLOW_BELL_PEPPER, ModItems.YELLOW_BELL_PEPPER_SEEDS, builder3));

        AnyOfLootCondition.Builder builder4 =
            BlockStatePropertyLootCondition.builder(ModBlocks.CORN_CROP).properties(StatePredicate.Builder.create()
                            .exactMatch(YellowBellPepperCropBlock.AGE, 7))
                    .or(BlockStatePropertyLootCondition.builder(ModBlocks.CORN_CROP).properties(StatePredicate.Builder.create()
                            .exactMatch(CornCropBlock.AGE, 8)));
        addDrop(ModBlocks.CORN_CROP, cropDrops(ModBlocks.CORN_CROP, ModItems.CORN, ModItems.CORN_SEEDS, builder4));

        BlockStatePropertyLootCondition.Builder builder5 = BlockStatePropertyLootCondition.builder(ModBlocks.LETTUCE_CROP)
                .properties(StatePredicate.Builder.create()
                        .exactMatch(YellowBellPepperCropBlock.AGE, 3));
        addDrop(ModBlocks.LETTUCE_CROP, cropDrops(ModBlocks.LETTUCE_CROP, ModItems.LETTUCE, ModItems.LETTUCE_SEEDS, builder5));
    }

    public LootTable.Builder copperLikeOreDrops(Block drop, Item item) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop, ((LeafEntry.Builder) ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 5.0f)))).apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
}
