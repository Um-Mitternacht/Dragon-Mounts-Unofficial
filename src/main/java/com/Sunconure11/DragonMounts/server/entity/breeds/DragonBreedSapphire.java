package com.Sunconure11.DragonMounts.server.entity.breeds;

import com.Sunconure11.DragonMounts.server.entity.EntityTameableDragon;
import net.minecraft.util.DamageSource;


public class DragonBreedSapphire extends DragonBreed {

	DragonBreedSapphire() {
		super("sapphire", 0x4f69a8);

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
	
