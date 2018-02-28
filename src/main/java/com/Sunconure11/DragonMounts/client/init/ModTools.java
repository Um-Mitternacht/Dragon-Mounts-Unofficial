package com.Sunconure11.DragonMounts.client.init;

import com.Sunconure11.DragonMounts.client.items.*;
import com.Sunconure11.DragonMounts.DragonMounts;
import com.TheRPGAdventurer.ROTD.client.items.*;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class ModTools {

	public static final ToolMaterial JadeDragonScaleMaterial = EnumHelper.addToolMaterial(DragonMounts.MODID + ":jadedragonscales", 4, 1700, 8.0F, 6.0F, 13);
	public static final ToolMaterial RubyDragonScaleMaterial = EnumHelper.addToolMaterial(DragonMounts.MODID + ":rubydragonscales", 4, 1700, 8.0F, 6.0F, 13);
	public static final ToolMaterial GarnetDragonScaleMaterial = EnumHelper.addToolMaterial(DragonMounts.MODID + ":garnetdragonscales", 4, 1700, 8.0F, 6.0F, 13);
	public static final ToolMaterial AmethystDragonScaleMaterial = EnumHelper.addToolMaterial(DragonMounts.MODID + ":amethystdragonscales", 4, 1700, 8.0F, 6.0F, 13);
	public static final ToolMaterial SapphireDragonScaleMaterial = EnumHelper.addToolMaterial(DragonMounts.MODID + ":sapphiredragonscales", 4, 1700, 8.0F, 6.0F, 13);

	public static ItemPickaxe jadeDragonPickaxe;
	public static ItemModAxe jadeDragonAxe;
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

	public static final Item[] TOOLS = {
			jadeDragonPickaxe = new ItemModPickAxe(JadeDragonScaleMaterial, "jade_dragon_pickaxe"),
			jadeDragonAxe = new ItemModAxe(JadeDragonScaleMaterial, "jade_dragon_axe"),
			jadeDragonShovel = new ItemModShovel(JadeDragonScaleMaterial, "jade_dragon_shovel"),
			jadeDragonSword = new ItemModSword(JadeDragonScaleMaterial, "jade_dragon_sword"),

			rubyDragonPickaxe = new ItemModPickAxe(RubyDragonScaleMaterial, "ruby_dragon_pickaxe"),
			rubyDragonAxe = new ItemModAxe(RubyDragonScaleMaterial, "ruby_dragon_axe"),
			rubyDragonShovel = new ItemModShovel(RubyDragonScaleMaterial, "ruby_dragon_shovel"),
			rubyDragonSword = new ItemModSword(RubyDragonScaleMaterial, "ruby_dragon_sword"),

			amethystDragonAxe = new ItemModAxe(AmethystDragonScaleMaterial, "amethyst_dragon_axe"),
			amethystDragonPickaxe = new ItemModPickAxe(AmethystDragonScaleMaterial, "amethyst_dragon_pickaxe"),
			amethystDragonShovel = new ItemModShovel(AmethystDragonScaleMaterial, "amethyst_dragon_shovel"),
			amethystDragonSword = new ItemModSword(AmethystDragonScaleMaterial, "amethyst_dragon_sword"),

			garnetDragonAxe = new ItemModAxe(GarnetDragonScaleMaterial, "garnet_dragon_axe"),
			garnetDragonPickaxe = new ItemModPickAxe(GarnetDragonScaleMaterial, "garnet_dragon_pickaxe"),
			garnetDragonShovel = new ItemModShovel(GarnetDragonScaleMaterial, "garnet_dragon_shovel"),
			garnetDragonSword = new ItemModSword(GarnetDragonScaleMaterial, "garnet_dragon_sword"),

			sapphireDragonAxe = new ItemModAxe(SapphireDragonScaleMaterial, "sapphire_dragon_axe"),
			sapphireDragonPickaxe = new ItemModPickAxe(SapphireDragonScaleMaterial, "sapphire_dragon_pickaxe"),
			sapphireDragonShovel = new ItemModShovel(SapphireDragonScaleMaterial, "sapphire_dragon_shovel"),
			sapphireDragonSword = new ItemModSword(SapphireDragonScaleMaterial, "sapphire_dragon_sword"),

			diamond_shears = new ItemDiamondShears("diamond_shears")
	};


}