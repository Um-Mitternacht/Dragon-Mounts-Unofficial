package com.TheRPGAdventurer.ROTD.client.items;

import com.TheRPGAdventurer.ROTD.RealmOfTheDragons;

import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

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
