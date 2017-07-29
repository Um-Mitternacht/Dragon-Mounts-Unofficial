/*
** 2016 April 24
**
** The author disclaims copyright to this source code. In place of
** a legal notice, here is a blessing:
**    May you do good and not evil.
**    May you find forgiveness for yourself and forgive others.
**    May you share freely, never taking more than you give.
 */
package com.TheRPGAdventurer.server.entity.interact;

import java.util.Random;

import com.TheRPGAdventurer.server.entity.EntityTameableDragon;
import com.TheRPGAdventurer.server.util.ItemUtils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;

public class DragonInteractSit extends DragonInteract {
	
	private Random rand;

    public DragonInteractSit(EntityTameableDragon dragon) {
        super(dragon);
    }

    @Override
    public boolean interact(EntityPlayer player, ItemStack item) {
        if (dragon.isServer() && dragon.isTamedFor(player) &&
                ItemUtils.hasEquipped(player, Items.STICK)) {
            dragon.getAISit().setSitting(!dragon.isSitting());
            dragon.getNavigator().clearPathEntity();
            return true;
        }
        
        return false;
    }

    
}
