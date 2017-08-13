package com.TheRPGAdventurer.ROTD.client.init;

import com.TheRPGAdventurer.ROTD.client.blocks.BlockPileOfSticks;
import com.TheRPGAdventurer.ROTD.util.Utils;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static Block pileofsticks;
	
	public static void init() {
		pileofsticks = new BlockPileOfSticks("pileofsticks", "pileofsticks");
		
	}
	
	public static void register() {
		registerBlock(pileofsticks);
		
	}
	
	public static void registerRenders() {
		registerRender(pileofsticks);
	}
	
	public static void registerBlock(Block block) {
		GameRegistry.register(block);
		GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		Utils.getLogger().info("Registered Block: " +block.getUnlocalizedName().substring(5));
	}
	
	public static void registerRender(Block block) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName().toString(), "inventory"));
		Utils.getLogger().info("Registered render for " + block.getUnlocalizedName().substring(5));
	}

}