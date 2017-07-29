package com.TheRPGAdventurer.server.entity.breeds;

import com.TheRPGAdventurer.client.init.ModItems;
import com.TheRPGAdventurer.server.entity.EntityTameableDragon;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.DamageSource;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class DragonBreedAmethyst extends DragonBreed {

	DragonBreedAmethyst() {
        super("amethyst", 0xab39be);
        
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
	
