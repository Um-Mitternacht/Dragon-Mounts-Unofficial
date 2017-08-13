package com.TheRPGAdventurer.ROTD.client.items;

import com.TheRPGAdventurer.ROTD.RealmOfTheDragons;
import com.TheRPGAdventurer.ROTD.server.entity.EntityTameableDragon;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.IShearable;

public class ItemDiamondShears extends ItemShears {
		
	public ItemDiamondShears(String unlocalizedName) {
	    this.setUnlocalizedName(unlocalizedName);
	    this.setRegistryName(new ResourceLocation(RealmOfTheDragons.MODID, unlocalizedName));
	    this.setMaxDamage(345);
	    this.setMaxStackSize(1);
	    this.setCreativeTab(CreativeTabs.TOOLS);
	}
	
	@Override
    public boolean itemInteractionForEntity(ItemStack itemstack, EntityPlayer player, EntityLivingBase entity, net.minecraft.util.EnumHand hand) {
		 if (entity.worldObj.isRemote)
	        {return false;}
	        if (entity instanceof EntityTameableDragon)
	        {
	            EntityTameableDragon target = (EntityTameableDragon)entity;
	            BlockPos pos = new BlockPos(entity.posX, entity.posY, entity.posZ);
	            if (target.isShearable(itemstack, entity.worldObj, pos))
	            {
	                java.util.List<ItemStack> drops = target.onSheared(itemstack, entity.worldObj, pos,
	                        net.minecraft.enchantment.EnchantmentHelper.getEnchantmentLevel(net.minecraft.init.Enchantments.FORTUNE, itemstack));

	                java.util.Random rand = new java.util.Random();
	                for(ItemStack stack : drops)
	                {
	                    net.minecraft.entity.item.EntityItem ent = entity.entityDropItem(stack, 1.0F);
	                    ent.motionY += rand.nextFloat() * 0.05F;
	                    ent.motionX += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
	                    ent.motionZ += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
	                }
	                itemstack.damageItem(154, entity);
	            }
	     
	      return true;
	      
	  } else {
		  
		  if (entity.worldObj.isRemote)
	        {return false;}
	        if (entity instanceof IShearable)
	        {
	            IShearable target = (IShearable)entity;
	            BlockPos pos = new BlockPos(entity.posX, entity.posY, entity.posZ);
	            if (target.isShearable(itemstack, entity.worldObj, pos))
	            {
	                java.util.List<ItemStack> drops = target.onSheared(itemstack, entity.worldObj, pos,
	                        net.minecraft.enchantment.EnchantmentHelper.getEnchantmentLevel(net.minecraft.init.Enchantments.FORTUNE, itemstack));

	                java.util.Random rand = new java.util.Random();
	                for(ItemStack stack : drops)
	                {
	                    net.minecraft.entity.item.EntityItem ent = entity.entityDropItem(stack, 1.0F);
	                    ent.motionY += rand.nextFloat() * 0.05F;
	                    ent.motionX += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
	                    ent.motionZ += (rand.nextFloat() - rand.nextFloat()) * 0.1F;
	                }
	                itemstack.damageItem(1, entity);
	            }
	            return true;
	        }
	      
	      return false;
	  }
	  
   }

}