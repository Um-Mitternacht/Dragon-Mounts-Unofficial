package com.Sunconure11.DragonMounts.client.items;

import com.Sunconure11.DragonMounts.DragonMounts;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ItemModShovel extends ItemSpade {

	public ItemModShovel(ToolMaterial material, String unlocalizedName) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(DragonMounts.MODID, unlocalizedName));

	}

	@Override
	public boolean getIsRepairable(ItemStack toBeRepaired, ItemStack material) {
		return true;
	}


}
