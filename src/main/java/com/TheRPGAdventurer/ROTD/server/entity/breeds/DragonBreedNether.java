package com.TheRPGAdventurer.ROTD.server.entity.breeds;


import com.TheRPGAdventurer.ROTD.server.entity.EntityTameableDragon;

import net.minecraft.init.Biomes;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


public class DragonBreedNether extends DragonBreed {

    DragonBreedNether() {
        super("nether", 0x960b0f);
        
        addImmunity(DamageSource.IN_FIRE);
        addImmunity(DamageSource.ON_FIRE);
        addImmunity(DamageSource.MAGIC);
        addImmunity(DamageSource.HOT_FLOOR);
        addImmunity(DamageSource.LIGHTNING_BOLT);
        addImmunity(DamageSource.WITHER);
        
    }

    @Override
    public void onEnable(EntityTameableDragon dragon) {
        dragon.getBrain().setAvoidsWater(true);
    }

    @Override
    public void onDisable(EntityTameableDragon dragon) {
        dragon.getBrain().setAvoidsWater(false);
    }

    @Override
    public void onDeath(EntityTameableDragon dragon) {
    
    }
    
    @SubscribeEvent
	public void NetherDragonregenonLava(LivingHurtEvent event, EntityTameableDragon dragon) {
	  if (event.getSource().isFireDamage() && event.getEntityLiving() instanceof EntityTameableDragon) {
	    event.getEntityLiving().addPotionEffect(new PotionEffect(MobEffects.REGENERATION));
	    event.setCanceled(true); }
    }
    
}
