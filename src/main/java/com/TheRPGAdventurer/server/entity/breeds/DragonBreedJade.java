package com.TheRPGAdventurer.server.entity.breeds;

import com.TheRPGAdventurer.client.init.ModItems;
import com.TheRPGAdventurer.server.entity.EntityTameableDragon;

import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraftforge.fml.common.registry.EntityRegistry;


public class DragonBreedJade extends DragonBreed {

    DragonBreedJade() {
        super("jade", 0x2d6e00);
        
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
	
