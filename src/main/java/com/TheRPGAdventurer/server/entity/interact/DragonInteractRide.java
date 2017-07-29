package com.TheRPGAdventurer.server.entity.interact;

import com.TheRPGAdventurer.client.init.ModTools;
import com.TheRPGAdventurer.server.entity.EntityTameableDragon;
import com.TheRPGAdventurer.server.util.ItemUtils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;

public class DragonInteractRide extends DragonInteract {

    public DragonInteractRide(EntityTameableDragon dragon) {
        super(dragon);
    }

    @Override
    public boolean interact(EntityPlayer player, ItemStack item) {
        if (dragon.isServer() && dragon.isTamedFor(player) &&
                dragon.isSaddled() && !ItemUtils.hasEquippedUsable(player) && !ItemUtils.hasEquipped(player, ModTools.diamond_shears)) {
            dragon.setRidingPlayer(player);
            return true;
        }

        return false;
    }

}
