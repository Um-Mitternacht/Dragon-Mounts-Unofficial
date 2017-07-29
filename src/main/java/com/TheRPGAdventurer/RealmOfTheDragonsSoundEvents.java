package com.TheRPGAdventurer;

import com.TheRPGAdventurer.RealmOfTheDragons;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RealmOfTheDragonsSoundEvents {
	
	public static final SoundEvent ENTITY_DRAGON_STEP = registerSound("mob.dragon.step");
    public static final SoundEvent ENTITY_DRAGON_BREATHE = registerSound("mob.dragon.breathe");
    public static final SoundEvent ENTITY_DRAGON_DEATH = registerSound("mob.dragon.death");
    public static final SoundEvent ENTITY_DRAGON_GROWL = registerSound("mob.dragon.growl");

    private static SoundEvent registerSound(String soundName) {
        ResourceLocation soundID = new ResourceLocation(RealmOfTheDragons.AID, soundName);
        return GameRegistry.register(new SoundEvent(soundID).setRegistryName(soundID));
    }

    private RealmOfTheDragonsSoundEvents() {
    }
}


