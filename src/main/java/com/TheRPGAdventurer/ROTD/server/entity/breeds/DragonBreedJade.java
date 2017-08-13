package com.TheRPGAdventurer.ROTD.server.entity.breeds;

import com.TheRPGAdventurer.ROTD.server.entity.EntityTameableDragon;

import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraftforge.fml.common.registry.EntityRegistry;


public class DragonBreedJade extends DragonBreed {

    DragonBreedJade() {
        super("jade", 0x2d6e00);
        
        addImmunity(DamageSource.IN_FIRE);
        addImmunity(DamageSource.ON_FIRE);
        addImmunity(DamageSource.MAGIC);
        addImmunity(DamageSource.HOT_FLOOR);
        addImmunity(DamageSource.LIGHTNING_BOLT);
        addImmunity(DamageSource.WITHER);
        
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
	
