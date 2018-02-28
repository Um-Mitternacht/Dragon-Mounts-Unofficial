package com.Sunconure11.DragonMounts.client.blocks;

import com.Sunconure11.DragonMounts.DragonMounts;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBase extends Block {

	BlockBase(String name, Material material) {
		super(material);

		this.setRegistryName(DragonMounts.MODID, name);
		this.setUnlocalizedName(this.getRegistryName().toString());
	}
}