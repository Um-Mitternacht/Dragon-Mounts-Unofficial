package com.TheRPGAdventurer.ROTD.client.init;

import com.TheRPGAdventurer.ROTD.RealmOfTheDragons;
import com.TheRPGAdventurer.ROTD.client.items.ItemDiamondShears;
import com.TheRPGAdventurer.ROTD.client.items.ItemModAxe;
import com.TheRPGAdventurer.ROTD.client.items.ItemModPickAxe;
import com.TheRPGAdventurer.ROTD.client.items.ItemModShovel;
import com.TheRPGAdventurer.ROTD.client.items.ItemModSword;
import com.TheRPGAdventurer.ROTD.util.Utils;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTools {

	public static final ToolMaterial JadeDragonScaleMaterial     = EnumHelper.addToolMaterial(RealmOfTheDragons.MODID + ":jadedragonscales", 4, 1700, 8.0F, 6.0F, 13);
	public static final ToolMaterial RubyDragonScaleMaterial     = EnumHelper.addToolMaterial(RealmOfTheDragons.MODID + ":rubydragonscales", 4, 1700, 8.0F, 6.0F, 13);
	public static final ToolMaterial GarnetDragonScaleMaterial   = EnumHelper.addToolMaterial(RealmOfTheDragons.MODID + ":garnetdragonscales", 4, 1700, 8.0F, 6.0F, 13);
	public static final ToolMaterial AmethystDragonScaleMaterial = EnumHelper.addToolMaterial(RealmOfTheDragons.MODID + ":amethystdragonscales", 4, 1700, 8.0F, 6.0F, 13);
	public static final ToolMaterial SapphireDragonScaleMaterial = EnumHelper.addToolMaterial(RealmOfTheDragons.MODID + ":sapphiredragonscales", 4, 1700, 8.0F, 6.0F, 13);
	
	public static ItemPickaxe jadeDragonPickaxe;
	public static ItemModAxe  jadeDragonAxe;
	public static ItemSpade jadeDragonShovel;
	public static ItemSword jadeDragonSword;
	
	public static ItemPickaxe garnetDragonPickaxe;
	public static ItemModAxe garnetDragonAxe;
	public static ItemSpade garnetDragonShovel;
	public static ItemSword garnetDragonSword;
	
	public static ItemPickaxe sapphireDragonPickaxe;
	public static ItemModAxe sapphireDragonAxe;
	public static ItemSpade sapphireDragonShovel;
	public static ItemSword sapphireDragonSword;
    
	public static ItemPickaxe amethystDragonPickaxe;
	public static ItemModAxe amethystDragonAxe;
	public static ItemSpade amethystDragonShovel;
	public static ItemSword amethystDragonSword;
	
	public static ItemPickaxe rubyDragonPickaxe;
	public static ItemModAxe rubyDragonAxe;
	public static ItemSpade rubyDragonShovel;
	public static ItemSword rubyDragonSword;
	
	public static ItemDiamondShears diamond_shears;
	
	public static void init() {
		jadeDragonPickaxe = new ItemModPickAxe(JadeDragonScaleMaterial, "jade_dragon_pickaxe");
		jadeDragonAxe = new ItemModAxe(JadeDragonScaleMaterial, "jade_dragon_axe");
		jadeDragonShovel = new ItemModShovel(JadeDragonScaleMaterial, "jade_dragon_shovel");
		jadeDragonSword = new ItemModSword(JadeDragonScaleMaterial, "jade_dragon_sword");
		
		rubyDragonPickaxe = new ItemModPickAxe(RubyDragonScaleMaterial, "ruby_dragon_pickaxe");
	    rubyDragonAxe = new ItemModAxe(RubyDragonScaleMaterial, "ruby_dragon_axe");
	    rubyDragonShovel = new ItemModShovel(RubyDragonScaleMaterial, "ruby_dragon_shovel");
	    rubyDragonSword = new ItemModSword(RubyDragonScaleMaterial, "ruby_dragon_sword");
	    
	    amethystDragonAxe = new ItemModAxe(AmethystDragonScaleMaterial, "amethyst_dragon_axe");
		amethystDragonPickaxe = new ItemModPickAxe(AmethystDragonScaleMaterial, "amethyst_dragon_pickaxe");
		amethystDragonShovel = new ItemModShovel(AmethystDragonScaleMaterial, "amethyst_dragon_shovel");
		amethystDragonSword = new ItemModSword(AmethystDragonScaleMaterial, "amethyst_dragon_sword");
		
	    garnetDragonAxe = new ItemModAxe(GarnetDragonScaleMaterial, "garnet_dragon_axe");
	    garnetDragonPickaxe = new ItemModPickAxe(GarnetDragonScaleMaterial, "garnet_dragon_pickaxe");
	    garnetDragonShovel = new ItemModShovel(GarnetDragonScaleMaterial, "garnet_dragon_shovel");
	    garnetDragonSword = new ItemModSword(GarnetDragonScaleMaterial, "garnet_dragon_sword");
	    
	    sapphireDragonAxe = new ItemModAxe(SapphireDragonScaleMaterial, "sapphire_dragon_axe");
	    sapphireDragonPickaxe = new ItemModPickAxe(SapphireDragonScaleMaterial, "sapphire_dragon_pickaxe");
	    sapphireDragonShovel = new ItemModShovel(SapphireDragonScaleMaterial, "sapphire_dragon_shovel");
	    sapphireDragonSword = new ItemModSword(SapphireDragonScaleMaterial, "sapphire_dragon_sword");
	    
	    diamond_shears = new ItemDiamondShears("diamond_shears");
	}

	public static void register() {
		registerItem(jadeDragonPickaxe);
		registerItem(jadeDragonAxe);
		registerItem(jadeDragonShovel);
		registerItem(jadeDragonSword);
		
		registerItem(garnetDragonAxe);
		registerItem(garnetDragonPickaxe);
		registerItem(garnetDragonShovel);
		registerItem(garnetDragonSword);
		
		registerItem(amethystDragonAxe);
		registerItem(amethystDragonPickaxe);
		registerItem(amethystDragonShovel);
		registerItem(amethystDragonSword);
		
		registerItem(sapphireDragonAxe);
		registerItem(sapphireDragonPickaxe);
		registerItem(sapphireDragonShovel);
		registerItem(sapphireDragonSword);
		
		registerItem(rubyDragonPickaxe);
		registerItem(rubyDragonAxe);
		registerItem(rubyDragonShovel);
		registerItem(rubyDragonSword);
		
		registerItem(diamond_shears);
	}
	
	public static void registerRenders()  {
		registerRender(jadeDragonPickaxe);
		registerRender(jadeDragonAxe);
		registerRender(jadeDragonShovel);
		registerRender(jadeDragonSword);
		
		registerRender(garnetDragonAxe);
		registerRender(garnetDragonPickaxe);
		registerRender(garnetDragonShovel);
		registerRender(garnetDragonSword);
		
		registerRender(amethystDragonAxe);
		registerRender(amethystDragonPickaxe);
		registerRender(amethystDragonShovel);
		registerRender(amethystDragonSword);
		
		registerRender(sapphireDragonAxe);
		registerRender(sapphireDragonPickaxe);
		registerRender(sapphireDragonShovel);
		registerRender(sapphireDragonSword);
		
		registerRender(rubyDragonPickaxe);
		registerRender(rubyDragonAxe);
		registerRender(rubyDragonShovel);
		registerRender(rubyDragonSword);

		registerRender(diamond_shears);
		
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