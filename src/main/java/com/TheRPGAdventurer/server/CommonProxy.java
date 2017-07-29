package com.TheRPGAdventurer.server;

import com.TheRPGAdventurer.RealmOfTheDragons;
import com.TheRPGAdventurer.client.blocks.BlockDragonBreedEgg;
import com.TheRPGAdventurer.client.init.ModArmour;
import com.TheRPGAdventurer.client.init.ModItems;
import com.TheRPGAdventurer.client.init.ModTools;
import com.TheRPGAdventurer.client.items.ItemDragonBreedEgg;
import com.TheRPGAdventurer.server.cmd.CommandDragon;
import com.TheRPGAdventurer.server.entity.EntityTameableDragon;
import com.TheRPGAdventurer.server.handler.DragonEggBlockHandler;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppedEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
	
	    private final int ENTITY_TRACKING_RANGE = 80;
	    private final int ENTITY_UPDATE_FREQ = 3;
	    private final int ENTITY_ID = 0;
	    private final boolean ENTITY_SEND_VELO_UPDATES = true;
	    
	    public void onPreInit(FMLPreInitializationEvent event) {
	        GameRegistry.register(BlockDragonBreedEgg.DRAGON_BREED_EGG.setRegistryName("dragon_egg"));
	        GameRegistry.register(ItemDragonBreedEgg.DRAGON_BREED_EGG.setRegistryName("dragon_egg"));
	    }
	    
	    public void onInit(FMLInitializationEvent evt) {
	        registerEntities();
	        
	        MinecraftForge.EVENT_BUS.register(new DragonEggBlockHandler());
	    }

	    public void onPostInit(FMLPostInitializationEvent event) {
	    }
	    
	    public void onServerStarting(FMLServerStartingEvent evt) {
	        MinecraftServer server = evt.getServer();
	        ServerCommandManager cmdman = (ServerCommandManager) server.getCommandManager(); 
	        cmdman.registerCommand(new CommandDragon());
	    }
	    
	    public void onServerStopped(FMLServerStoppedEvent evt) {}
	    private void registerEntities() {
	        EntityRegistry.registerModEntity(EntityTameableDragon.class, "RealmOfTheDragons",
	                ENTITY_ID, RealmOfTheDragons.instance, ENTITY_TRACKING_RANGE, ENTITY_UPDATE_FREQ,
	                ENTITY_SEND_VELO_UPDATES);
	    }
	
	    public void registerRenders() {
	    	  ModItems.registerRenders();
			  ModTools.registerRenders();
			  ModArmour.registerRenders();
	    }
}