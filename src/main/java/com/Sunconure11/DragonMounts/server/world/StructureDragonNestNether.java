package com.Sunconure11.DragonMounts.server.world;

import com.Sunconure11.DragonMounts.client.init.ModBlocks;
import com.Sunconure11.DragonMounts.server.block.BlockDragonBreedEgg;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockDirt.DirtType;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class StructureDragonNestNether {

	public boolean generate(World worldIn, Random rand, BlockPos pos) {
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		//upper
		worldIn.setBlockState(new BlockPos(x + 2, y + 1, z + 0), ModBlocks.pileofsticks.getStateFromMeta(0));
		worldIn.setBlockState(new BlockPos(x + 3, y + 1, z + 0), ModBlocks.pileofsticks.getStateFromMeta(0));
		worldIn.setBlockState(new BlockPos(x + 4, y + 1, z + 0), ModBlocks.pileofsticks.getStateFromMeta(0));
		worldIn.setBlockState(new BlockPos(x + 0, y + 1, z + 2), ModBlocks.pileofsticks.getStateFromMeta(0));
		worldIn.setBlockState(new BlockPos(x + 1, y + 1, z + 1), ModBlocks.pileofsticks.getStateFromMeta(0));
		worldIn.setBlockState(new BlockPos(x + 1, y + 1, z + 5), ModBlocks.pileofsticks.getStateFromMeta(0));
		worldIn.setBlockState(new BlockPos(x + 5, y + 1, z + 5), ModBlocks.pileofsticks.getStateFromMeta(0));
		worldIn.setBlockState(new BlockPos(x + 2, y + 1, z + 6), ModBlocks.pileofsticks.getStateFromMeta(0));
		worldIn.setBlockState(new BlockPos(x + 3, y + 1, z + 6), ModBlocks.pileofsticks.getStateFromMeta(0));
		worldIn.setBlockState(new BlockPos(x + 4, y + 1, z + 6), ModBlocks.pileofsticks.getStateFromMeta(0));
		worldIn.setBlockState(new BlockPos(x + 5, y + 1, z + 1), ModBlocks.pileofsticks.getStateFromMeta(0));
		worldIn.setBlockState(new BlockPos(x + 0, y + 1, z + 2), ModBlocks.pileofsticks.getStateFromMeta(0));
		worldIn.setBlockState(new BlockPos(x + 0, y + 1, z + 3), ModBlocks.pileofsticks.getStateFromMeta(0));
		worldIn.setBlockState(new BlockPos(x + 0, y + 1, z + 4), ModBlocks.pileofsticks.getStateFromMeta(0));
		worldIn.setBlockState(new BlockPos(x + 6, y + 1, z + 2), ModBlocks.pileofsticks.getStateFromMeta(0));
		worldIn.setBlockState(new BlockPos(x + 6, y + 1, z + 3), ModBlocks.pileofsticks.getStateFromMeta(0));
		worldIn.setBlockState(new BlockPos(x + 6, y + 1, z + 4), ModBlocks.pileofsticks.getStateFromMeta(0));
		//bottom
		worldIn.setBlockState(new BlockPos(x + 1, y + 0, z + 2), ModBlocks.pileofsticks.getStateFromMeta(0));
		worldIn.setBlockState(new BlockPos(x + 1, y + 0, z + 4), ModBlocks.pileofsticks.getStateFromMeta(0));
		worldIn.setBlockState(new BlockPos(x + 2, y + 0, z + 1), ModBlocks.pileofsticks.getStateFromMeta(0));
		worldIn.setBlockState(new BlockPos(x + 2, y + 0, z + 3), ModBlocks.pileofsticks.getStateFromMeta(0));
		worldIn.setBlockState(new BlockPos(x + 2, y + 0, z + 4), ModBlocks.pileofsticks.getStateFromMeta(0));
		worldIn.setBlockState(new BlockPos(x + 3, y + 0, z + 2), ModBlocks.pileofsticks.getStateFromMeta(0));
		worldIn.setBlockState(new BlockPos(x + 3, y + 0, z + 3), ModBlocks.pileofsticks.getStateFromMeta(0));
		worldIn.setBlockState(new BlockPos(x + 3, y + 0, z + 5), ModBlocks.pileofsticks.getStateFromMeta(0));
		worldIn.setBlockState(new BlockPos(x + 4, y + 0, z + 1), ModBlocks.pileofsticks.getStateFromMeta(0));
		worldIn.setBlockState(new BlockPos(x + 4, y + 0, z + 2), ModBlocks.pileofsticks.getStateFromMeta(0));
		worldIn.setBlockState(new BlockPos(x + 4, y + 0, z + 3), ModBlocks.pileofsticks.getStateFromMeta(0));
		worldIn.setBlockState(new BlockPos(x + 4, y + 0, z + 5), ModBlocks.pileofsticks.getStateFromMeta(0));
		worldIn.setBlockState(new BlockPos(x + 5, y + 0, z + 3), ModBlocks.pileofsticks.getStateFromMeta(0));
		worldIn.setBlockState(new BlockPos(x + 5, y + 0, z + 4), ModBlocks.pileofsticks.getStateFromMeta(0));
		worldIn.setBlockState(new BlockPos(x + 1, y + 0, z + 3), Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, DirtType.COARSE_DIRT));
		worldIn.setBlockState(new BlockPos(x + 2, y + 0, z + 5), Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, DirtType.COARSE_DIRT));
		worldIn.setBlockState(new BlockPos(x + 2, y + 0, z + 2), Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, DirtType.COARSE_DIRT));
		worldIn.setBlockState(new BlockPos(x + 3, y + 0, z + 1), Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, DirtType.COARSE_DIRT));
		worldIn.setBlockState(new BlockPos(x + 3, y + 0, z + 4), Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, DirtType.COARSE_DIRT));
		worldIn.setBlockState(new BlockPos(x + 4, y + 0, z + 4), Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, DirtType.COARSE_DIRT));
		worldIn.setBlockState(new BlockPos(x + 5, y + 0, z + 2), Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, DirtType.COARSE_DIRT));
		worldIn.setBlockState(new BlockPos(x + 3, y + 1, z + 3), BlockDragonBreedEgg.DRAGON_BREED_EGG.getStateFromMeta(6));
		return true;
	}

}
