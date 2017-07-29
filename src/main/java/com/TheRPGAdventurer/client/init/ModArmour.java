package com.TheRPGAdventurer.client.init;

import com.TheRPGAdventurer.RealmOfTheDragons;
import com.TheRPGAdventurer.client.items.ItemModArmour;
import com.TheRPGAdventurer.server.util.Utils;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModArmour {
	
	public static final ArmorMaterial jadeDragonScaleMaterial     = EnumHelper.addArmorMaterial("jadeDragonScale", RealmOfTheDragons.MODID + ":jadeDragonScale", 45, new int [] {4,7,9,4}, 11, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 5.0F);
	public static final ArmorMaterial rubyDragonScaleMaterial     = EnumHelper.addArmorMaterial("rubyDragonScale", RealmOfTheDragons.MODID + ":rubyDragonScale", 45, new int [] {4,7,9,4}, 11, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 5.0F);
	public static final ArmorMaterial garnetDragonScaleMaterial   = EnumHelper.addArmorMaterial("garnetDragonScale", RealmOfTheDragons.MODID + ":garnetDragonScale", 45, new int [] {4,7,9,4}, 11, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 5.0F);
	public static final ArmorMaterial amethystDragonScaleMaterial = EnumHelper.addArmorMaterial("amethystDragonScale", RealmOfTheDragons.MODID + ":amethystDragonScale", 45, new int [] {4,7,9,4}, 11, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 5.0F);
	public static final ArmorMaterial sapphireDragonScaleMaterial = EnumHelper.addArmorMaterial("sapphireDragonScale", RealmOfTheDragons.MODID + ":sapphireDragonScale", 45, new int [] {4,7,9,4}, 11, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 5.0F);
	
	public static ItemArmor jadeDragonScaleCap;
	public static ItemArmor jadeDragonScaleChestplate;
	public static ItemArmor jadeDragonScaleLeggings;
	public static ItemArmor jadeDragonScaleBoots;
	
	public static ItemArmor rubyDragonScaleCap;
	public static ItemArmor rubyDragonScaleChestplate;
	public static ItemArmor rubyDragonScaleLeggings;
	public static ItemArmor rubyDragonScaleBoots;
	
	public static ItemArmor garnetDragonScaleCap;
	public static ItemArmor garnetDragonScaleChestplate;
	public static ItemArmor garnetDragonScaleLeggings;
	public static ItemArmor garnetDragonScaleBoots;
	
	public static ItemArmor amethystDragonScaleCap;
	public static ItemArmor amethystDragonscaleChesplate;
	public static ItemArmor amethystDragonScaleLeggings;
	public static ItemArmor amethystDragonScaleBoots;
	
	public static ItemArmor sapphireDragonScaleCap;
	public static ItemArmor sapphireDragonScaleChestplate;
	public static ItemArmor sapphireDragonScaleLeggings;
	public static ItemArmor sapphireDragonScaleBoots;
	
	public static void init () {
		jadeDragonScaleCap = new ItemModArmour(jadeDragonScaleMaterial, 1, EntityEquipmentSlot.HEAD, "jade_dragonscale_cap");
		jadeDragonScaleChestplate = new ItemModArmour(jadeDragonScaleMaterial, 1, EntityEquipmentSlot.CHEST, "jade_dragonscale_chestplate");
		jadeDragonScaleLeggings = new ItemModArmour(jadeDragonScaleMaterial, 2, EntityEquipmentSlot.LEGS, "jade_dragonscale_leggings");
		jadeDragonScaleBoots = new ItemModArmour(jadeDragonScaleMaterial, 1, EntityEquipmentSlot.FEET, "jade_dragonscale_boots");
		
		rubyDragonScaleCap = new ItemModArmour(rubyDragonScaleMaterial, 1, EntityEquipmentSlot.HEAD, "ruby_dragonscale_cap");
		rubyDragonScaleChestplate = new ItemModArmour(rubyDragonScaleMaterial, 1, EntityEquipmentSlot.CHEST, "ruby_dragonscale_chestplate");
		rubyDragonScaleLeggings = new ItemModArmour(rubyDragonScaleMaterial, 2, EntityEquipmentSlot.LEGS, "ruby_dragonscale_leggings");
		rubyDragonScaleBoots = new ItemModArmour(rubyDragonScaleMaterial, 1, EntityEquipmentSlot.FEET, "ruby_dragonscale_boots");
		
		garnetDragonScaleCap = new ItemModArmour(garnetDragonScaleMaterial, 1, EntityEquipmentSlot.HEAD, "garnet_dragonscale_cap");
		garnetDragonScaleChestplate = new ItemModArmour(garnetDragonScaleMaterial, 1, EntityEquipmentSlot.CHEST, "garnet_dragonscale_chestplate");
		garnetDragonScaleLeggings = new ItemModArmour(garnetDragonScaleMaterial, 2, EntityEquipmentSlot.LEGS, "garnet_dragonscale_leggings");
		garnetDragonScaleBoots = new ItemModArmour(garnetDragonScaleMaterial, 1, EntityEquipmentSlot.FEET, "garnet_dragonscale_boots");
		
		amethystDragonScaleCap = new ItemModArmour(amethystDragonScaleMaterial, 1, EntityEquipmentSlot.HEAD, "amethyst_dragonscale_cap");
		amethystDragonscaleChesplate = new ItemModArmour(amethystDragonScaleMaterial, 1, EntityEquipmentSlot.CHEST, "amethyst_dragonscale_chestplate");
		amethystDragonScaleLeggings = new ItemModArmour(amethystDragonScaleMaterial, 2, EntityEquipmentSlot.LEGS, "amethyst_dragonscale_leggings");
		amethystDragonScaleBoots = new ItemModArmour(amethystDragonScaleMaterial, 1, EntityEquipmentSlot.FEET, "amethyst_dragonscale_boots");
		
		sapphireDragonScaleCap = new ItemModArmour(sapphireDragonScaleMaterial, 1, EntityEquipmentSlot.HEAD, "sapphire_dragonscale_cap");
		sapphireDragonScaleChestplate = new ItemModArmour(sapphireDragonScaleMaterial,  1, EntityEquipmentSlot.CHEST, "sapphire_dragonscale_chestplate");
		sapphireDragonScaleLeggings = new ItemModArmour(sapphireDragonScaleMaterial, 2, EntityEquipmentSlot.LEGS, "sapphire_dragonscale_leggings");
		sapphireDragonScaleBoots = new ItemModArmour(sapphireDragonScaleMaterial, 1, EntityEquipmentSlot.FEET, "sapphire_dragonscale_boots");
		
		
	}
	
	public static void register() {
		registerItem(jadeDragonScaleCap);
		registerItem(jadeDragonScaleChestplate);
		registerItem(jadeDragonScaleLeggings);
		registerItem(jadeDragonScaleBoots);
		
		registerItem(rubyDragonScaleCap);
		registerItem(rubyDragonScaleChestplate);
		registerItem(rubyDragonScaleLeggings);
		registerItem(rubyDragonScaleBoots);
		
		registerItem(garnetDragonScaleCap);
		registerItem(garnetDragonScaleChestplate);
		registerItem(garnetDragonScaleLeggings);
		registerItem(garnetDragonScaleBoots);

		registerItem(amethystDragonScaleCap);
		registerItem(amethystDragonscaleChesplate);
		registerItem(amethystDragonScaleLeggings);
		registerItem(amethystDragonScaleBoots);

		registerItem(sapphireDragonScaleCap);
		registerItem(sapphireDragonScaleChestplate);
		registerItem(sapphireDragonScaleLeggings);
		registerItem(sapphireDragonScaleBoots);


    }
	
	public static void registerRenders() {
		registerRender(jadeDragonScaleCap);
		registerRender(jadeDragonScaleChestplate);
		registerRender(jadeDragonScaleLeggings);
		registerRender(jadeDragonScaleBoots);
		
		registerRender(garnetDragonScaleCap);
		registerRender(garnetDragonScaleChestplate);
		registerRender(garnetDragonScaleLeggings);
		registerRender(garnetDragonScaleBoots);
		
		registerRender(rubyDragonScaleCap);
		registerRender(rubyDragonScaleChestplate);
		registerRender(rubyDragonScaleLeggings);
		registerRender(rubyDragonScaleBoots);
		
		registerRender(amethystDragonScaleCap);
		registerRender(amethystDragonscaleChesplate);
		registerRender(amethystDragonScaleLeggings);
		registerRender(amethystDragonScaleBoots);
		
		registerRender(sapphireDragonScaleCap);
		registerRender(sapphireDragonScaleChestplate);
		registerRender(sapphireDragonScaleLeggings);
		registerRender(sapphireDragonScaleBoots);

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
	    



