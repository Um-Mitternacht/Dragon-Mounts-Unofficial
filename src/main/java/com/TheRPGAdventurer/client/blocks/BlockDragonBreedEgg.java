package com.TheRPGAdventurer.client.blocks;

import java.util.List;
import java.util.Random;

import com.TheRPGAdventurer.RealmOfTheDragonsLootTables;
import com.TheRPGAdventurer.server.entity.EntityTameableDragon;
import com.TheRPGAdventurer.server.entity.breeds.EnumDragonBreed;
import net.minecraft.block.BlockDragonEgg;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockDragonBreedEgg extends BlockDragonEgg {
    
    public static final PropertyEnum<EnumDragonBreed> BREED = PropertyEnum.create("breed", EnumDragonBreed.class);
    public static final BlockDragonBreedEgg DRAGON_BREED_EGG = new BlockDragonBreedEgg();
	public EntityTameableDragon dragon;
    
    private BlockDragonBreedEgg() {
        setUnlocalizedName("dragonEgg");
        setHardness(3);
        setResistance(15);
        setSoundType(SoundType.WOOD);
        setLightLevel(0.125f);
        setCreativeTab(CreativeTabs.MISC);
    }
    

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[]{ BREED });
    }
    
    
    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(BREED, EnumDragonBreed.META_MAPPING.inverse().get(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        EnumDragonBreed type = (EnumDragonBreed) state.getValue(BREED);
        return EnumDragonBreed.META_MAPPING.get(type);
    }
    
    @Override
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list) {
        EnumDragonBreed.META_MAPPING.values().forEach(index -> list.add(new ItemStack(itemIn, 1, index)));
    }

    @Override
    public int damageDropped(IBlockState state) {
        return getMetaFromState(state);
    }
    
}