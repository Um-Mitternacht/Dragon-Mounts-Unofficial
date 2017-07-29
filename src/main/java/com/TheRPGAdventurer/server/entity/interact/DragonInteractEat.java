package com.TheRPGAdventurer.server.entity.interact;

import com.TheRPGAdventurer.server.entity.EntityTameableDragon;
import com.TheRPGAdventurer.server.util.ItemUtils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;

public class DragonInteractEat extends DragonInteract {

    public DragonInteractEat(EntityTameableDragon dragon) {
        super(dragon);
    }

    @Override
    public boolean interact(EntityPlayer player, ItemStack item) {
        // eat only if hurt
        if (dragon.isServer() && dragon.getHealthRelative() < 1) {
            ItemFood food = (ItemFood) ItemUtils.consumeEquipped(player,
                    dragon.getBreed().getFoodItems());

            // heal only if the food was actually consumed
            if (food != null) {
                dragon.heal(food.getHealAmount(item));
                dragon.playSound(dragon.getSoundManager().getEatSound(), 0.7f, 1);
                
                return true;
            }
        }

        return false;
    }

    
}
