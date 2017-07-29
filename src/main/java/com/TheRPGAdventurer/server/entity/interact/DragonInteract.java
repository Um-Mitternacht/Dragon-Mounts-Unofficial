package com.TheRPGAdventurer.server.entity.interact;

import com.TheRPGAdventurer.server.entity.EntityTameableDragon;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;

public abstract class DragonInteract {
    
    protected final EntityTameableDragon dragon;
    
    public DragonInteract(EntityTameableDragon dragon) {
        this.dragon = dragon;
    }
    
    public abstract boolean interact(EntityPlayer player, ItemStack item);
}
