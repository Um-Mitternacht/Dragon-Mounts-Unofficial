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
    public static final String VERSION = "1.0";
    
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
    public void PreInitialization(FMLPreInitializationEvent event) {
    	RealmOfTheDragonsLootTables.registerLootTables();
        config = new RealmOfTheDragonsConfig(new Configuration(event.getSuggestedConfigurationFile()));
        metadata = event.getModMetadata();
        proxy.PreInitialization(event);
       
    }

    @EventHandler
    public void Initialization(FMLInitializationEvent event) {
        proxy.Initialization(event);
        GameRegistry.registerWorldGenerator(new RealmOfTheDragonsWorldGenerator(), 0);
       
    }

    @EventHandler
    public void PostInitialization(FMLPostInitializationEvent event) {
        proxy.PostInitialization(event);
    }
    
    @EventHandler
    public void ServerStarting(FMLServerStartingEvent event) {
        proxy.ServerStarting(event);
    }
    
    @EventHandler
    public void ServerStopped(FMLServerStoppedEvent event) {
        proxy.ServerStopped(event);
    }
}
