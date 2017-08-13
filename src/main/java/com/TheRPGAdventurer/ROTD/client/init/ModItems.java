package com.TheRPGAdventurer.ROTD.client.init;

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
	
	public static Block dragonEgg;
	
	public static void init() {
		JadeDragonScales = new ItemJadeDragonScales("jade_dragonscales", "jade_dragonscales");
		RubyDragonScales = new ItemRubyDragonScales("ruby_dragonscales", "ruby_dragonscales");
		AmethystDragonScales = new ItemAmethystDragonScales("amethyst_dragonscales", "amethyst_dragonscales");
		SapphireDragonScales = new ItemSapphireDragonScales("sapphire_dragonscales", "sapphire_dragonscales");
		GarnetDragonScales = new ItemGarnetDragonScales("garnet_dragonscales", "garnet_dragonscales");
		structure_spawner = new ItemStructureSpawner("structure_spawner", "structure_spawner");
	}

    public static void register() {
    	registerItem(JadeDragonScales);
    	registerItem(RubyDragonScales);
    	registerItem(AmethystDragonScales);
    	registerItem(GarnetDragonScales);
    	registerItem(SapphireDragonScales);
    	registerItem(structure_spawner);
    	
    }
    
    public static void registerRenders() {
    	registerRender(JadeDragonScales);
    	registerRender(RubyDragonScales);
    	registerRender(AmethystDragonScales);
    	registerRender(GarnetDragonScales);
    	registerRender(SapphireDragonScales);
    	registerRender(structure_spawner);

    }
    
    public static void setCreativeTab() {
    	JadeDragonScales.setCreativeTab(CreativeTabs.MATERIALS);
    	AmethystDragonScales.setCreativeTab(CreativeTabs.MATERIALS);
    	GarnetDragonScales.setCreativeTab(CreativeTabs.MATERIALS);
    	RubyDragonScales.setCreativeTab(CreativeTabs.MATERIALS);
        SapphireDragonScales.setCreativeTab(CreativeTabs.MATERIALS);
    }
	
    public static void registerItem(Item item) {
    	GameRegistry.register(item);
    	Utils.getLogger().info("Registered item: " + item.getUnlocalizedName().substring(5));
    }
    
    public static void registerRender(Item item) {
    	ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName().toString(), "inventory")); 
    	Utils.getLogger().info("Register render for " + item.getUnlocalizedName().substring(5));
    }

}
