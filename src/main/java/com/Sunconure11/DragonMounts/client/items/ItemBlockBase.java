package com.Sunconure11.DragonMounts.client.items;

import com.Sunconure11.DragonMounts.DragonMounts;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemBlockBase extends ItemBlock {


	public ItemBlockBase(String name, Block block) {
		super(block);
		this.setRegistryName(DragonMounts.MODID, name);
		this.setUnlocalizedName(this.getRegistryName().toString());
	}

}
