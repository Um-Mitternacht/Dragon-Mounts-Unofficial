package com.Sunconure11.DragonMounts.client.items;

import com.Sunconure11.DragonMounts.DragonMounts;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ItemModPickAxe extends ItemPickaxe {

	public ItemModPickAxe(ToolMaterial material, String unlocalizedName) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.isRepairable();
		this.setRegistryName(new ResourceLocation(DragonMounts.MODID, unlocalizedName));

	}

	@Override
	public boolean getIsRepairable(ItemStack toBeRepaired, ItemStack material) {
		return true;
	}

}
