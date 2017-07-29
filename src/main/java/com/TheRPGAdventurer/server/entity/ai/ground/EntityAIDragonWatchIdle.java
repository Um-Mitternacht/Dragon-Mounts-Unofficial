package com.TheRPGAdventurer.server.entity.ai.ground;

import com.TheRPGAdventurer.server.entity.EntityTameableDragon;
import net.minecraft.entity.ai.EntityAILookIdle;

public class EntityAIDragonWatchIdle extends EntityAILookIdle {

    public EntityAIDragonWatchIdle(EntityTameableDragon par1EntityLiving) {
        super(par1EntityLiving);
        this.setMutexBits(2);
    }
}
