package com.TheRPGAdventurer.client.init;

import com.TheRPGAdventurer.RealmOfTheDragons;
import com.TheRPGAdventurer.client.items.ItemStructureSpawner;
import com.TheRPGAdventurer.client.items.dragonscales.ItemAmethystDragonScales;
import com.TheRPGAdventurer.client.items.dragonscales.ItemGarnetDragonScales;
import com.TheRPGAdventurer.client.items.dragonscales.ItemJadeDragonScales;
import com.TheRPGAdventurer.client.items.dragonscales.ItemRubyDragonScales;
import com.TheRPGAdventurer.client.items.dragonscales.ItemSapphireDragonScales;
import com.TheRPGAdventurer.server.util.Utils;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
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
		JadeDragonScales = new ItemJadeDragonScales("jade_dragon_scales", "jade_dragon_scales");
		RubyDragonScales = new ItemRubyDragonScales("ruby_dragon_scales", "ruby_dragon_scales");
		AmethystDragonScales = new ItemAmethystDragonScales("amethyst_dragon_scales", "amethyst_dragon_scales");
		SapphireDragonScales = new ItemSapphireDragonScales("sapphire_dragon_scales", "sapphire_dragon_scales");
		GarnetDragonScales = new ItemGarnetDragonScales("garnet_dragon_scales", "garnet_dragon_scales");
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
    	ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(RealmOfTheDragons.MODID, item.getUnlocalizedName().substring(5)),"inventory")); 
    	Utils.getLogger().info("Register render for" + item.getUnlocalizedName().substring(5));
    }

}
