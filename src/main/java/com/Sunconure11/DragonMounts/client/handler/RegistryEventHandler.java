package com.Sunconure11.DragonMounts.client.handler;

import com.Sunconure11.DragonMounts.client.init.ModArmour;
import com.Sunconure11.DragonMounts.client.init.ModBlocks;
import com.Sunconure11.DragonMounts.client.init.ModItems;
import com.Sunconure11.DragonMounts.client.init.ModTools;
import com.Sunconure11.DragonMounts.client.items.ItemDragonBreedEgg;
import com.Sunconure11.DragonMounts.server.entity.breeds.EnumDragonBreed;
import com.Sunconure11.DragonMounts.util.Utils;
import com.Sunconure11.DragonMounts.DragonMounts;
import com.Sunconure11.DragonMounts.client.blocks.BlockDragonBreedEgg;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class RegistryEventHandler {
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(ModBlocks.BLOCKS);
		Utils.getLogger().info("Registered blocks");
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(ModItems.ITEMS);
		event.getRegistry().registerAll(ModTools.TOOLS);
		event.getRegistry().registerAll(ModArmour.ARMOR);

		for (Block block : ModBlocks.BLOCKS) {
			event.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		}

		Utils.getLogger().info("Registered items");
	}

	@SubscribeEvent
	public static void registerDragonEggItem(RegistryEvent.Register<Item> event) {
		event.getRegistry().register(ItemDragonBreedEgg.DRAGON_BREED_EGG);
	}

	@SubscribeEvent
	public static void registerDragonnEggBlock(RegistryEvent.Register<Block> event) {
		event.getRegistry().register(BlockDragonBreedEgg.DRAGON_BREED_EGG);
	}

	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		for (Block block : ModBlocks.BLOCKS) {
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
		}

		for (Block block : BlockDragonBreedEgg.BLOCK_EGG) {
			// register item renderer for dragon egg block variants
			ResourceLocation eggModelItemLoc = new ResourceLocation(DragonMounts.MODID, "dragon_egg");
			Item itemBlockDragonEgg = Item.REGISTRY.getObject(eggModelItemLoc);
			EnumDragonBreed.META_MAPPING.forEach((breed, meta) -> {
				ModelResourceLocation eggModelLoc = new ModelResourceLocation(DragonMounts.MODID + ":dragon_egg", "breed=" + breed.getName());
				ModelLoader.setCustomModelResourceLocation(itemBlockDragonEgg, meta, eggModelLoc);
			});
		}

		for (Item item : ItemDragonBreedEgg.ITEM_EGG) {
			// register item renderer for dragon egg block variants
			ResourceLocation eggModelItemLoc = new ResourceLocation(DragonMounts.MODID, "dragon_egg");
			Item itemBlockDragonEgg = Item.REGISTRY.getObject(eggModelItemLoc);
			EnumDragonBreed.META_MAPPING.forEach((breed, meta) -> {
				ModelResourceLocation eggModelLoc = new ModelResourceLocation(DragonMounts.MODID + ":dragon_egg", "breed=" + breed.getName());
				ModelLoader.setCustomModelResourceLocation(itemBlockDragonEgg, meta, eggModelLoc);
			});
		}

		for (Item item : ModItems.ITEMS) {
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		}

		for (Item item : ModTools.TOOLS) {
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		}

		for (Item item : ModArmour.ARMOR) {
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName().toString(), "inventory"));
		}

		Utils.getLogger().info("Registered models");
	}

}