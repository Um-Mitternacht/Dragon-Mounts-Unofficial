package com.TheRPGAdventurer.client.blocks;

import java.util.Random;

import com.TheRPGAdventurer.RealmOfTheDragons;
import com.TheRPGAdventurer.client.init.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockPileOfSticks extends Block {

	public BlockPileOfSticks(String unlocalizedName, String registryName) {
		super(Material.WOOD);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(RealmOfTheDragons.MODID, registryName));
		this.setResistance(1);
		this.setHardness(1);
		this.setSoundType(SoundType.WOOD);
		this.setCreativeTab(CreativeTabs.DECORATIONS);
	}

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
    	return Item.getItemFromBlock(this);
    }
    
    @Override
    public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
        return 10;
    }
    
    @Override
    public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face) {
        return 45;
    }
}
