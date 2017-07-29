package com.TheRPGAdventurer.server.entity.breeds;

import com.TheRPGAdventurer.client.init.ModItems;
import com.TheRPGAdventurer.server.entity.EntityTameableDragon;

import net.minecraft.init.Biomes;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;

public class DragonBreedRuby extends DragonBreed {

    DragonBreedRuby() {
        super("ruby", 0x960b0f);

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
	
