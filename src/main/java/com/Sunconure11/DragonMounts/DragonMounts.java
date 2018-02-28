/*
 ** 2012 August 13
 **
 ** The author disclaims copyright to this source code.  In place of
 ** a legal notice, here is a blessing:
 **    May you do good and not evil.
 **    May you find forgiveness for yourself and forgive others.
 **    May you share freely, never taking more than you give.
 */
package com.Sunconure11.DragonMounts;

import com.Sunconure11.DragonMounts.server.CommonProxy;
import com.Sunconure11.DragonMounts.server.world.RealmOfTheDragonsWorldGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Main control class for Forge.
 */
@Mod(
		modid = DragonMounts.MODID,
		name = DragonMounts.NAME,
		version = DragonMounts.VERSION,
		useMetadata = true,
		guiFactory = "DragonMountsConfigGuiFactory"
)
public class DragonMounts {

	public static final String NAME = "Dragon Mounts";
	public static final String MODID = "dragon_mounts";
	public static final String VERSION = "1.0.2 Alpha";

	@SidedProxy(
			serverSide = "CommonProxy",
			clientSide = "ClientProxy"
	)
	public static CommonProxy proxy;

	@Instance(MODID)
	public static DragonMounts instance;

	private ModMetadata metadata;
	private DragonMountsConfig config;

	public DragonMountsConfig getConfig() {
		return config;
	}

	public ModMetadata getMetadata() {
		return metadata;
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent evt) {
		DragonMountsLootTables.registerLootTables();

	}

	@EventHandler
	public void onPreInit(FMLPreInitializationEvent evt) {
		config = new DragonMountsConfig(new Configuration(evt.getSuggestedConfigurationFile()));
		metadata = evt.getModMetadata();
		proxy.onPreInit(evt);

	}

	@EventHandler
	public void init(FMLInitializationEvent evt) {
//    	RecipeHandler.registerCraftingRecipes(null, null, null, null, null);
		GameRegistry.registerWorldGenerator(new RealmOfTheDragonsWorldGenerator(), 0);
	}

	@EventHandler
	public void onInit(FMLInitializationEvent evt) {
		proxy.onInit(evt);

	}

	@EventHandler
	public void onPostInit(FMLPostInitializationEvent event, ResourceLocation dragon) {
		proxy.onPostInit(event);
	}

	@EventHandler
	public void onServerStarting(FMLServerStartingEvent evt) {
		proxy.onServerStarting(evt);
	}

	@EventHandler
	public void onServerStopped(FMLServerStoppedEvent evt) {
		proxy.onServerStopped(evt);
	}
}
