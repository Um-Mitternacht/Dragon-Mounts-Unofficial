package com.TheRPGAdventurer.server.entity.ai.air;

import com.TheRPGAdventurer.server.entity.EntityTameableDragon;
import com.TheRPGAdventurer.server.entity.ai.EntityAIDragonBase;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

/**
 * Dragon AI for instant landing, if left unmounted in air.
 */
public class EntityAIDragonLand extends EntityAIDragonBase {
    
    private final double speed;
    private BlockPos landingPos;

    public EntityAIDragonLand(EntityTameableDragon dragon, double speed) {
        super(dragon);
        this.speed = speed;
        setMutexBits(1);
    }
    
    private boolean findLandingBlock() {
        // get current entity position
        landingPos = dragon.getPosition();
        
        // add some variance
        int followRange = MathHelper.floor_double(getFollowRange());
        int ox = followRange - random.nextInt(followRange) * 2;
        int oz = followRange - random.nextInt(followRange) * 2;
        landingPos = landingPos.add(ox, 0, oz);

        // get ground block
        landingPos = world.getHeight(landingPos);
        
        // make sure the block below is solid
        return world.getBlockState(landingPos.down()).getMaterial().isSolid();
    }

    @Override
    public boolean shouldExecute() {
        return dragon.isFlying() && dragon.getRidingPlayer() == null && findLandingBlock();
    }
    
    @Override
    public boolean continueExecuting() {
        return dragon.isFlying() && dragon.getRidingPlayer() == null && !dragon.getNavigator().noPath();
    }

    @Override
    public void startExecuting() {
        // try to fly to ground block position
        if (!tryMoveToBlockPos(landingPos, speed)) {
            // probably too high, so simply descend vertically
            tryMoveToBlockPos(dragon.getPosition().down(4), speed);
        }
    }
}
