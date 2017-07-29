package com.TheRPGAdventurer.server.entity.ai.air;

import com.TheRPGAdventurer.server.entity.EntityTameableDragon;
import com.TheRPGAdventurer.server.entity.ai.EntityAIDragonBase;
import net.minecraft.entity.player.EntityPlayer;

public class EntityAIDragonFollowOwner extends EntityAIDragonBase {
    
    protected EntityPlayer owner;

    public EntityAIDragonFollowOwner(EntityTameableDragon dragon) {
        super(dragon);
    }

    @Override
    public boolean shouldExecute() {
        if (!dragon.isFlying()) {
            return false;
        }
        
        owner = (EntityPlayer) dragon.getOwner();
        
        // don't follow if ownerless 
        if (owner == null) {
            return false;
        }
        
        // don't follow if sitting.
        if (dragon.isSitting()) {
        	return false;
        }
        
        // don't follow if being ridden
        if (dragon.isPassenger(owner)) {
            return false;
        }
        
        // follow only if the owner is using an Elytra
        return owner.isElytraFlying();
    }
    
    @Override
    public void updateTask() {
        dragon.getNavigator().tryMoveToEntityLiving(owner, 1);
    }
}
