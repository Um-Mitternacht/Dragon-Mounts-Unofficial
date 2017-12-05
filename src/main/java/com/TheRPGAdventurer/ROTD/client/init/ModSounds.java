package com.TheRPGAdventurer.ROTD.client.init;

import com.TheRPGAdventurer.ROTD.RealmOfTheDragons;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@ObjectHolder(RealmOfTheDragons.MODID)
public class ModSounds {
	
	@ObjectHolder("mob.dragon.step")
	public static final SoundEvent ENTITY_DRAGON_STEP = createSoundEvent("mob.dragon.step");

	@ObjectHolder("mob.dragon.breathe")
	public static final SoundEvent ENTITY_DRAGON_BREATHE = createSoundEvent("mob.dragon.breathe");

	@ObjectHolder("mob.dragon.death")
	public static final SoundEvent ENTITY_DRAGON_DEATH = createSoundEvent("mob.dragon.death");
	
	@ObjectHolder("mob.dragon.growl")
	public static final SoundEvent ENTITY_DRAGON_GROWL = createSoundEvent("mob.dragon.growl");

	private static SoundEvent createSoundEvent(final String soundName) {
		final ResourceLocation soundID = new ResourceLocation(RealmOfTheDragons.MODID, soundName);
		return new SoundEvent(soundID).setRegistryName(soundID);
	}

	@Mod.EventBusSubscriber(modid = RealmOfTheDragons.MODID)
	public static class RegistrationHandler {
		@SubscribeEvent
		public static void registerSoundEvents(final RegistryEvent.Register<SoundEvent> event) {
			event.getRegistry().registerAll(
					ENTITY_DRAGON_STEP,
					ENTITY_DRAGON_BREATHE,
					ENTITY_DRAGON_DEATH,
					ENTITY_DRAGON_GROWL
			);
		}
	}
}
