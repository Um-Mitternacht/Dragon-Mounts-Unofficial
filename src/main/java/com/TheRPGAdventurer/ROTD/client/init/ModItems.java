package com.TheRPGAdventurer.ROTD.client.init;

import com.TheRPGAdventurer.ROTD.client.blocks.BlockDragonBreedEgg;
import com.TheRPGAdventurer.ROTD.client.items.ItemDragonBreedEgg;
import com.TheRPGAdventurer.ROTD.client.items.ItemStructureSpawner;
import com.TheRPGAdventurer.ROTD.client.items.dragonscales.ItemAmethystDragonScales;
import com.TheRPGAdventurer.ROTD.client.items.dragonscales.ItemGarnetDragonScales;
import com.TheRPGAdventurer.ROTD.client.items.dragonscales.ItemJadeDragonScales;
import com.TheRPGAdventurer.ROTD.client.items.dragonscales.ItemRubyDragonScales;
import com.TheRPGAdventurer.ROTD.client.items.dragonscales.ItemSapphireDragonScales;
import com.TheRPGAdventurer.ROTD.util.Utils;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems extends Items {
	
	public static Item JadeDragonScales;
	public static Item RubyDragonScales;
	public static Item AmethystDragonScales;
	public static Item SapphireDragonScales;
	public static Item GarnetDragonScales;
	public static Item DeadDragonScales;
	public static Item structure_spawner;
	
	public static final Item[] ITEMS = {
		JadeDragonScales = new ItemJadeDragonScales("jade_dragonscales", "jade_dragonscales"),
		RubyDragonScales = new ItemRubyDragonScales("ruby_dragonscales", "ruby_dragonscales"),
		AmethystDragonScales = new ItemAmethystDragonScales("amethyst_dragonscales", "amethyst_dragonscales"),
		SapphireDragonScales = new ItemSapphireDragonScales("sapphire_dragonscales", "sapphire_dragonscales"),
		GarnetDragonScales = new ItemGarnetDragonScales("garnet_dragonscales", "garnet_dragonscales"),
		structure_spawner = new ItemStructureSpawner("structure_spawner", "structure_spawner")
		
	};
    
    public static void setCreativeTab() {
    	JadeDragonScales.setCreativeTab(CreativeTabs.MATERIALS);
    	AmethystDragonScales.setCreativeTab(CreativeTabs.MATERIALS);
    	GarnetDragonScales.setCreativeTab(CreativeTabs.MATERIALS);
    	RubyDragonScales.setCreativeTab(CreativeTabs.MATERIALS);
        SapphireDragonScales.setCreativeTab(CreativeTabs.MATERIALS);
        structure_spawner.setCreativeTab(CreativeTabs.MISC);
    }
    
    
	
   
}
