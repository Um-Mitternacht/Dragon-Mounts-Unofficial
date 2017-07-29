package com.TheRPGAdventurer.server.entity.interact;

import com.TheRPGAdventurer.server.entity.EntityTameableDragon;
import com.TheRPGAdventurer.server.util.ItemUtils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;

public class DragonInteractTame extends DragonInteract {

    public DragonInteractTame(EntityTameableDragon dragon) {
        super(dragon);
    }

    @Override
    public boolean interact(EntityPlayer player, ItemStack item) {
        if (dragon.isServer() && !dragon.isTamed() && !dragon.isChild()  
        	&& ItemUtils.consumeEquipped(player, dragon.getBreed().getBreedingItem())) {
            dragon.tamedFor(player, dragon.getRNG().nextInt(5) == 0);
            return true;
        }

        return false;
    }

}
