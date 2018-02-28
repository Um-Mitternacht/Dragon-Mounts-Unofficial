/*
 ** 2012 August 27
 **
 ** The author disclaims copyright to this source code.  In place of
 ** a legal notice, here is a blessing:
 **    May you do good and not evil.
 **    May you find forgiveness for yourself and forgive others.
 **    May you share freely, never taking more than you give.
 */
package com.Sunconure11.DragonMounts.server;

import com.Sunconure11.DragonMounts.DragonMounts;
import com.Sunconure11.DragonMounts.server.cmd.CommandDragon;
import com.Sunconure11.DragonMounts.server.entity.EntityTameableDragon;
import com.Sunconure11.DragonMounts.server.handler.DragonEggBlockHandler;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.registry.EntityRegistry;

/**
 * @author Nico Bergemann <barracuda415 at yahoo.de>
 */
public class CommonProxy {

	private final int ENTITY_TRACKING_RANGE = 80;
	private final int ENTITY_UPDATE_FREQ = 3;
	private final int ENTITY_ID = 1;
	private final boolean ENTITY_SEND_VELO_UPDATES = true;

	public void onPreInit(FMLPreInitializationEvent event) {
	}


	public void onInit(FMLInitializationEvent evt) {
		MinecraftForge.EVENT_BUS.register(new DragonEggBlockHandler());
	}

	public void onPostInit(FMLPostInitializationEvent event) {
		registerEntities();

	}

	public void onServerStarting(FMLServerStartingEvent evt) {
		MinecraftServer server = evt.getServer();
		ServerCommandManager cmdman = (ServerCommandManager) server.getCommandManager();
		cmdman.registerCommand(new CommandDragon());
	}

	public void onServerStopped(FMLServerStoppedEvent evt) {
	}

	private void registerEntities() {
		EntityRegistry.registerModEntity(new ResourceLocation(DragonMounts.MODID, "dragon"), EntityTameableDragon.class, "RealmOfTheDragon",
				ENTITY_ID, DragonMounts.instance, ENTITY_TRACKING_RANGE, ENTITY_UPDATE_FREQ,
				ENTITY_SEND_VELO_UPDATES);
	}
}