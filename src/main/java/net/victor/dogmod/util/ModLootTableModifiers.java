package net.victor.dogmod.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.condition.SurvivesExplosionLootCondition;
import net.minecraft.loot.entry.ItemEntry;

public class ModLootTableModifiers {
    //private static final Identifier JUNGLE_TEMPLE_ID = new Identifier("minecraft", "chests/jungle_temple");
    //private static final Identifier CREEPER_ID = new Identifier("minecraft", "entities/creeper");

    public static void modifyLootTables() {

        LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {
            if (Blocks.COBBLESTONE.getLootTableKey() == key && source.isBuiltin()) {
                LootPool.Builder pool = LootPool.builder()
                    .with(ItemEntry.builder(Items.DIAMOND))
                    .conditionally(SurvivesExplosionLootCondition.builder())
                    .conditionally(RandomChanceLootCondition.builder(1f)); // DROP CHANCE
                    //.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build()); HOW MANY DROPS
                tableBuilder.pool(pool);
            }
        });
    }
}
