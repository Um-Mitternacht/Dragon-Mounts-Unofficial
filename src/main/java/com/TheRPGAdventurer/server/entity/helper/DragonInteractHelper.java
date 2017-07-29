package com.TheRPGAdventurer.server.entity.helper;

import java.util.ArrayList;
import java.util.List;

import com.TheRPGAdventurer.server.entity.EntityTameableDragon;
import com.TheRPGAdventurer.server.entity.interact.DragonInteract;
import com.TheRPGAdventurer.server.entity.interact.DragonInteractEat;
import com.TheRPGAdventurer.server.entity.interact.DragonInteractRide;
import com.TheRPGAdventurer.server.entity.interact.DragonInteractSaddle;
import com.TheRPGAdventurer.server.entity.interact.DragonInteractSit;
import com.TheRPGAdventurer.server.entity.interact.DragonInteractTame;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class DragonInteractHelper extends DragonHelper {
    
    private final List<DragonInteract> actions = new ArrayList<>();
    
    public DragonInteractHelper(EntityTameableDragon dragon) {
        super(dragon);
        
        actions.add(new DragonInteractEat(dragon));
        actions.add(new DragonInteractTame(dragon));
        actions.add(new DragonInteractSaddle(dragon));
        actions.add(new DragonInteractSit(dragon));
        actions.add(new DragonInteractRide(dragon)); 
		
    }
    
    public boolean interact(EntityPlayer player, ItemStack item) {
        return actions.stream().anyMatch(action -> action.interact(player, item));
    }
    
}