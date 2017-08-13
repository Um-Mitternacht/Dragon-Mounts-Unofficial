/*
 ** 2012 August 13
 **
 ** The author disclaims copyright to this source code.  In place of
 ** a legal notice, here is a blessing:
 **    May you do good and not evil.
 **    May you find forgiveness for yourself and forgive others.
 **    May you share freely, never taking more than you give.
 */
package com.TheRPGAdventurer.ROTD;

import com.TheRPGAdventurer.ROTD.client.init.ModArmour;
import com.TheRPGAdventurer.ROTD.client.init.ModBlocks;
import com.TheRPGAdventurer.ROTD.client.init.ModItems;
import com.TheRPGAdventurer.ROTD.client.init.ModTools;
import com.TheRPGAdventurer.ROTD.server.CommonProxy;
import com.TheRPGAdventurer.ROTD.server.world.RealmOfTheDragonsWorldGenerator;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppedEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Main control class for Forge.
 * 
 */
@Mod(
    modid = RealmOfTheDragons.MODID,
    name = RealmOfTheDragons.NAME,
    version = RealmOfTheDragons.VERSION,
    useMetadata = true,
    guiFactory = "com.TheRPGAdventurer.ROTD.RealmOfTheDragonsConfigGuiFactory"
)
public class RealmOfTheDragons {
    
    public static final String NAME = "Realm Of The Dragons";
    public static final String MODID = "rotd";
    public static final String VERSION = "1.0.2 Alpha";
    
    @SidedProxy(
        serverSide = "com.TheRPGAdventurer.ROTD.server.CommonProxy",
        clientSide = "com.TheRPGAdventurer.ROTD.client.ClientProxy"
    )
    public static CommonProxy proxy;
    
    @Instance(MODID)
    public static RealmOfTheDragons instance;
    
    private ModMetadata metadata;
    private RealmOfTheDragonsConfig config;
    
    public RealmOfTheDragonsConfig getConfig() {
        return config;
    }
    
    public ModMetadata getMetadata() {
        return metadata;
    }
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent evt) {
		RealmOfTheDragonsLootTables.registerLootTables();

    }
    
    @EventHandler
    public void onPreInit(FMLPreInitializationEvent evt) {
        config = new RealmOfTheDragonsConfig(new Configuration(evt.getSuggestedConfigurationFile()));
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
