package com.TheRPGAdventurer.server.entity.ai;

import com.TheRPGAdventurer.server.entity.EntityTameableDragon;
import com.TheRPGAdventurer.util.math.MathX;
import com.TheRPGAdventurer.util.reflection.PrivateAccessor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.Vec3d;

/**
 * Abstract "AI" for player-controlled movements.
 *
 * @author Nico Bergemann <barracuda415 at yahoo.de>
 */
public class EntityAIDragonRide extends EntityAIDragonBase implements PrivateAccessor {

    protected EntityPlayer rider;

    public EntityAIDragonRide(EntityTameableDragon dragon) {
        super(dragon);
        setMutexBits(0xffffffff);
    }
    
    @Override
    public boolean shouldExecute() {   
        rider = dragon.getRidingPlayer();
        return rider != null;
    }

    @Override
    public void startExecuting() {
        dragon.getNavigator().clearPathEntity();
    }
    
    @Override
    public void updateTask() {
        double x = dragon.posX;
        double y = dragon.posY;
        double z = dragon.posZ;
                
        // control direction with movement keys
        if (rider.moveStrafing != 0 || rider.moveForward != 0) {
            Vec3d wp = rider.getLookVec();
            
            if (rider.moveForward < 0) {
                wp = wp.rotateYaw(MathX.PI_F);
            } else if (rider.moveStrafing > 0) {
                wp = wp.rotateYaw(MathX.PI_F * 0.5f);
            } else if (rider.moveStrafing < 0) {
                wp = wp.rotateYaw(MathX.PI_F * -0.5f);
            }
            
            x += wp.xCoord * 10;
            y += wp.yCoord * 10;
            z += wp.zCoord * 10;
        }
        
        // lift off with a jump
        if (!dragon.isFlying()) {
            if (entityIsJumping(rider)) {
                dragon.liftOff();
            }
        }

        dragon.getMoveHelper().setMoveTo(x, y, z, 1);
    }
}
