package com.TheRPGAdventurer.client.items;

import com.TheRPGAdventurer.RealmOfTheDragons;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.RecipeRepairItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.IShearable;

public class ItemModPickAxe extends ItemPickaxe {

	public ItemModPickAxe(ToolMaterial material, String unlocalizedName) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.isRepairable();
		this.setRegistryName(new ResourceLocation(RealmOfTheDragons.MODID, unlocalizedName));
		
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toBeRepaired, ItemStack material) {
		return true;
	}
	
}
