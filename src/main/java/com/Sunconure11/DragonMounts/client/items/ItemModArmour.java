package com.Sunconure11.DragonMounts.client.items;

import com.Sunconure11.DragonMounts.DragonMounts;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ItemModArmour extends ItemArmor {

	private final ItemArmor.ArmorMaterial material;

	public ItemModArmour(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn, String unlocalizedName) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		this.setUnlocalizedName(unlocalizedName);
		this.material = materialIn;
		this.setRegistryName(new ResourceLocation(DragonMounts.MODID, unlocalizedName));

	}

	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return this.material.getRepairItem() == repair.getItem() ? true : super.getIsRepairable(toRepair, repair);
	}

}