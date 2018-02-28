/*
** 2016 March 09
**
** The author disclaims copyright to this source code. In place of
** a legal notice, here is a blessing:
**    May you do good and not evil.
**    May you find forgiveness for yourself and forgive others.
**    May you share freely, never taking more than you give.
 */
package com.Sunconure11.DragonMounts.client.blocks;

import com.Sunconure11.DragonMounts.server.entity.breeds.EnumDragonBreed;
import net.minecraft.block.BlockDragonEgg;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

/**
 * @author Nico Bergemann <barracuda415 at yahoo.de>
 */
public class BlockDragonBreedEgg extends BlockDragonEgg {

	public static final PropertyEnum<EnumDragonBreed> BREED = PropertyEnum.create("breed", EnumDragonBreed.class);
	public static BlockDragonBreedEgg DRAGON_BREED_EGG;
	public static final BlockDragonBreedEgg[] BLOCK_EGG = {
			DRAGON_BREED_EGG = new BlockDragonBreedEgg()
	};

	private BlockDragonBreedEgg() {
		setUnlocalizedName("dragonEgg");
		setRegistryName("dragon_egg");
		setHardness(3);
		setResistance(15);
		setSoundType(SoundType.WOOD);
		setLightLevel(0.125f);
		setCreativeTab(CreativeTabs.MISC);

	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[]{BREED});
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(BREED,
				EnumDragonBreed.META_MAPPING.inverse().get(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		EnumDragonBreed type = (EnumDragonBreed) state.getValue(BREED);
		return EnumDragonBreed.META_MAPPING.get(type);
	}

	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		EnumDragonBreed.META_MAPPING.values().forEach(index -> items.add(new ItemStack(this, 1, index)));
	}

	@Override
	public int damageDropped(IBlockState state) {
		return getMetaFromState(state);
	}

}