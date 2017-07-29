package com.TheRPGAdventurer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.TheRPGAdventurer.client.init.ModArmour;
import com.TheRPGAdventurer.client.init.ModBlocks;
import com.TheRPGAdventurer.client.init.ModItems;
import com.TheRPGAdventurer.client.init.ModTools;
import com.TheRPGAdventurer.server.CommonProxy;
import com.TheRPGAdventurer.server.entity.EntityTameableDragon;
import com.TheRPGAdventurer.server.handler.RecipeHandler;
import com.TheRPGAdventurer.server.world.ROTDWorldGenerator;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
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
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(
	    modid = RealmOfTheDragons.MODID,
	    name = RealmOfTheDragons.NAME,
	    version = RealmOfTheDragons.VERSION,
	    useMetadata = true,
	    guiFactory = "com.TheRPGAdventurer.RealmOfTheDragonsConfigGuiFactory"
	)
	
    public class RealmOfTheDragons {
	    
	    public static final String NAME = "Realm Of The Dragons";
	    public static final String MODID = "rotd";
	    public static final String AID = MODID.toLowerCase();
	    public static final String VERSION = "@VERSION@";
	    public static final Logger LOGGER = LogManager.getLogger("Realm Of The Dragons");
	    
	    @SidedProxy(
	        serverSide = "com.TheRPGAdventurer.server.CommonProxy",
	        clientSide = "com.TheRPGAdventurer.client.ClientProxy"
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
	    public void onPreInit(FMLPreInitializationEvent evt) {
	        config = new RealmOfTheDragonsConfig(new Configuration(evt.getSuggestedConfigurationFile()));
	        metadata = evt.getModMetadata();
	        proxy.onPreInit(evt);
	        ModItems.init();
		    ModBlocks.init();
		    ModItems.register();
		    ModBlocks.register();
			ModTools.init();
			ModTools.register();
			ModArmour.init();
			ModArmour.register();
			RealmOfTheDragonsLootTables.registerLootTables();
			
	        proxy.registerRenders();
	    }

	    @EventHandler
	    public void onInit(FMLInitializationEvent evt) {
	        proxy.onInit(evt);
	        RecipeHandler.registerCraftingRecipes(null, null, null, null, null);
			GameRegistry.registerWorldGenerator(new ROTDWorldGenerator(), 0);
	    }

	    @EventHandler
	    public void onPostInit(FMLPostInitializationEvent event) {
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