package com.TheRPGAdventurer.server.entity.ai.ground;

import com.TheRPGAdventurer.server.entity.EntityTameableDragon;
import com.google.common.base.Predicate;
import net.minecraft.entity.ai.EntityAITargetNonTamed;

public class EntityAIDragonHunt extends EntityAITargetNonTamed {
    
    private final EntityTameableDragon dragon;

    public EntityAIDragonHunt(EntityTameableDragon dragon, Class classTarget,
            boolean checkSight, Predicate targetSelector) {
        super(dragon, classTarget, checkSight, targetSelector);
        this.dragon = dragon;
    }

    @Override
    public boolean shouldExecute() {
        return dragon.isAdult() && super.shouldExecute();
    }
}
