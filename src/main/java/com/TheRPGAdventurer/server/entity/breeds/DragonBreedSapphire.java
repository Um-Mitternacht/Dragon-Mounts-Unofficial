package com.TheRPGAdventurer.server.entity.breeds;

import com.TheRPGAdventurer.server.entity.EntityTameableDragon;

import net.minecraft.init.Biomes;
import net.minecraft.util.DamageSource;


public class DragonBreedSapphire extends DragonBreed {

    DragonBreedSapphire() {
        super("sapphire", 0x4f69a8);
        
        addImmunity(DamageSource.inFire);
        addImmunity(DamageSource.onFire);
        addImmunity(DamageSource.magic);
        addImmunity(DamageSource.hotFloor);
        addImmunity(DamageSource.lightningBolt);
        addImmunity(DamageSource.wither);
        
    }

    @Override
    public void onEnable(EntityTameableDragon dragon) {
    }

    @Override
    public void onDisable(EntityTameableDragon dragon) {
    }

    @Override
    public void onDeath(EntityTameableDragon dragon) {
    
    }
}
	
