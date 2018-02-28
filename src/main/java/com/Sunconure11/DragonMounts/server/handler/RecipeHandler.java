package com.Sunconure11.DragonMounts.server.handler;

import com.Sunconure11.DragonMounts.client.init.ModArmour;
import com.Sunconure11.DragonMounts.client.init.ModBlocks;
import com.Sunconure11.DragonMounts.client.init.ModItems;
import com.Sunconure11.DragonMounts.client.init.ModTools;
import com.Sunconure11.DragonMounts.client.items.ItemModAxe;
import com.Sunconure11.DragonMounts.util.Utils;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeHandler {

	public static void registerCraftingRecipes(Item DragonScales, ItemModAxe DragonAxe, ItemPickaxe DragonPickaxe, ItemSword DragonSword, ItemSpade DragonShovel) {
		Utils.getLogger().info("Registered Crafting Recipes!");
		//Jade Set
		registerToolRecipe(ModItems.JadeDragonScales, ModTools.jadeDragonPickaxe, ModTools.jadeDragonAxe, ModTools.jadeDragonShovel, ModTools.jadeDragonSword);
		registerArmourRecipe(ModArmour.jadeDragonScaleCap, ModArmour.jadeDragonScaleChestplate, ModArmour.jadeDragonScaleLeggings, ModArmour.jadeDragonScaleBoots, ModItems.JadeDragonScales);
		//Ruby Set
		registerToolRecipe(ModItems.RubyDragonScales, ModTools.rubyDragonPickaxe, ModTools.rubyDragonAxe, ModTools.rubyDragonShovel, ModTools.rubyDragonSword);
		registerArmourRecipe(ModArmour.rubyDragonScaleCap, ModArmour.rubyDragonScaleChestplate, ModArmour.rubyDragonScaleLeggings, ModArmour.rubyDragonScaleBoots, ModItems.RubyDragonScales);
		//Amethyst Set
		registerToolRecipe(ModItems.AmethystDragonScales, ModTools.amethystDragonPickaxe, ModTools.amethystDragonAxe, ModTools.amethystDragonSword, ModTools.amethystDragonSword);
		registerArmourRecipe(ModArmour.amethystDragonScaleCap, ModArmour.amethystDragonscaleChesplate, ModArmour.amethystDragonScaleLeggings, ModArmour.amethystDragonScaleBoots, ModItems.AmethystDragonScales);
		//Garnet Set
		registerToolRecipe(ModItems.GarnetDragonScales, ModTools.garnetDragonPickaxe, ModTools.garnetDragonAxe, ModTools.garnetDragonShovel, ModTools.garnetDragonSword);
		registerArmourRecipe(ModArmour.garnetDragonScaleCap, ModArmour.garnetDragonScaleChestplate, ModArmour.garnetDragonScaleLeggings, ModArmour.garnetDragonScaleBoots, ModItems.GarnetDragonScales);
		//Sapphire Set
		registerToolRecipe(ModItems.SapphireDragonScales, ModTools.sapphireDragonPickaxe, ModTools.sapphireDragonAxe, ModTools.sapphireDragonShovel, ModTools.sapphireDragonSword);
		registerArmourRecipe(ModArmour.sapphireDragonScaleCap, ModArmour.sapphireDragonScaleChestplate, ModArmour.sapphireDragonScaleLeggings, ModArmour.sapphireDragonScaleBoots, ModItems.SapphireDragonScales);
	}

	public static void registerFurnaceRecipes() {
		Utils.getLogger().info("Registered Furnace Recipes!");
	}

	private static void registerToolRecipe(Item scales, Item pickaxe, Item axe, Item shovel, Item sword) {
		GameRegistry.addRecipe(new ItemStack(pickaxe), new Object[]{"III", " S ", " S ", 'I', scales, 'S', Items.STICK});
		GameRegistry.addRecipe(new ItemStack(axe), new Object[]{" II", " SI", " S ", 'I', scales, 'S', Items.STICK});
		GameRegistry.addRecipe(new ItemStack(axe), new Object[]{"II ", " SI", " S ", 'I', scales, 'S', Items.STICK});
		GameRegistry.addRecipe(new ItemStack(shovel), new Object[]{" I ", " S ", " S ", 'I', scales, 'S', Items.STICK});
		GameRegistry.addRecipe(new ItemStack(shovel), new Object[]{"I  ", "S  ", "S  ", 'I', scales, 'S', Items.STICK});
		GameRegistry.addRecipe(new ItemStack(shovel), new Object[]{"  I", "  S", "  S", 'I', scales, 'S', Items.STICK});
		GameRegistry.addRecipe(new ItemStack(sword), new Object[]{" I ", " I ", " S ", 'I', scales, 'S', Items.STICK});
		GameRegistry.addRecipe(new ItemStack(sword), new Object[]{"I  ", "I  ", "S  ", 'I', scales, 'S', Items.STICK});
		GameRegistry.addRecipe(new ItemStack(sword), new Object[]{"  I", "  I", "  S", 'I', scales, 'S', Items.STICK});
	}

	public static void registerArmourRecipe(Item helmet, Item chestplate, Item leggings, Item boots, Item scales) {
		GameRegistry.addRecipe(new ItemStack(helmet), new Object[]{"III", "I I", "   ", 'I', scales});
		GameRegistry.addRecipe(new ItemStack(helmet), new Object[]{"   ", "III", "I I", 'I', scales});
		GameRegistry.addRecipe(new ItemStack(chestplate), new Object[]{"I I", "III", "III", 'I', scales});
		GameRegistry.addRecipe(new ItemStack(leggings), new Object[]{"III", "I I", "I I", 'I', scales});
		GameRegistry.addRecipe(new ItemStack(boots), new Object[]{"I I", "I I", "   ", 'I', scales});
		GameRegistry.addRecipe(new ItemStack(boots), new Object[]{"   ", "I I", "I I", 'I', scales});
	}


	private static void registerOtherRecipes() {
		GameRegistry.addRecipe(new ItemStack(ModBlocks.pileofsticks), new Object[]{"SSS", "SSS", "SSS", 'S', Items.STICK});
		GameRegistry.addRecipe(new ItemStack(ModTools.diamond_shears), new Object[]{" D", "D ", 'D', Items.DIAMOND});

	}
}