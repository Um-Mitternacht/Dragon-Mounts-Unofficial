package com.TheRPGAdventurer.server.entity.interact;

import com.TheRPGAdventurer.server.entity.EntityTameableDragon;
import com.TheRPGAdventurer.server.util.ItemUtils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;

public class DragonInteractSaddle extends DragonInteract {

    public DragonInteractSaddle(EntityTameableDragon dragon) {
        super(dragon);
    }

    @Override
    public boolean interact(EntityPlayer player, ItemStack item) {
        if (dragon.isServer() && dragon.isTamedFor(player) && !dragon.isSaddled() && !dragon.isEgg() 
        	&& ItemUtils.consumeEquipped(player, Items.SADDLE)) {
            dragon.setSaddled(true);
            return true;
        }
        
        return false;
    }

    
}
