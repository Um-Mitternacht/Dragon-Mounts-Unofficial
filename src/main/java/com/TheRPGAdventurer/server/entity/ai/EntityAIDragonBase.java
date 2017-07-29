package com.TheRPGAdventurer.server.entity.ai;

import static net.minecraft.entity.SharedMonsterAttributes.FOLLOW_RANGE;
import java.util.Random;
import com.TheRPGAdventurer.server.entity.EntityTameableDragon;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class EntityAIDragonBase extends EntityAIBase {
    
    protected final EntityTameableDragon dragon;
    protected final World world;
    protected final Random random;

    public EntityAIDragonBase(EntityTameableDragon dragon) {
        this.dragon = dragon;
        this.world = dragon.worldObj;
        this.random = dragon.getRNG();
    }
    
    protected boolean tryMoveToBlockPos(BlockPos pos, double speed) {
        return dragon.getNavigator().tryMoveToXYZ(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, speed);
    }
    
    protected double getFollowRange() {
        return dragon.getAttributeMap().getAttributeInstance(FOLLOW_RANGE)
            .getAttributeValue();
    }
}
