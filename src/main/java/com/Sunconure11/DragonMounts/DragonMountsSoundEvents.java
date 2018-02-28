package com.Sunconure11.DragonMounts;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class DragonMountsSoundEvents {

	public static final SoundEvent ENTITY_DRAGON_STEP = registerSound("mob.dragon.step");
	public static final SoundEvent ENTITY_DRAGON_BREATHE = registerSound("mob.dragon.breathe");
	public static final SoundEvent ENTITY_DRAGON_DEATH = registerSound("mob.dragon.death");
	public static final SoundEvent ENTITY_DRAGON_GROWL = registerSound("mob.dragon.growl");

	private DragonMountsSoundEvents() {

	}

	private static SoundEvent registerSound(String soundName) {
		ResourceLocation soundID = new ResourceLocation(DragonMounts.MODID, soundName);
//        return GameRegistry.register(new SoundEvent(soundID).setRegistryName(soundID));
		return null;
	}
}