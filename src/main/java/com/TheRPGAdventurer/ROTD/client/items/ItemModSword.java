package com.TheRPGAdventurer.ROTD.client.items;

import com.TheRPGAdventurer.ROTD.RealmOfTheDragons;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;

public class ItemModSword extends ItemSword {

	public ItemModSword(ToolMaterial material, String unlocalizedName) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(RealmOfTheDragons.MODID, unlocalizedName));
		
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toBeRepaired, ItemStack material) {
		return true;
	}
	
}
