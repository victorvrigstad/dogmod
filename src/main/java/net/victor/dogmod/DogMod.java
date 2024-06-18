package net.victor.dogmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.victor.dogmod.block.ModBlocks;
import net.victor.dogmod.event.UseItemHandler;
import net.victor.dogmod.item.ModItemGroups;
import net.victor.dogmod.item.ModItems;
import net.victor.dogmod.util.ModLootTableModifiers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DogMod implements ModInitializer {
	public static final String MOD_ID = "dogmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModLootTableModifiers.modifyLootTables();
		UseBlockCallback.EVENT.register(new UseItemHandler());

		FuelRegistry.INSTANCE.add(ModItems.SVARTBIT, 160);
	}
}