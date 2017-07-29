package com.TheRPGAdventurer;

import java.io.File;
import java.util.List;

import com.google.common.collect.Lists;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class RealmOfTheDragonsConfig {
	
	 private static Configuration config;
	 private static Configuration worldgen;
	    
	    // config properties
	    private boolean disableBlockOverride = false;
	    private boolean debug = false;
	    
	    public RealmOfTheDragonsConfig(Configuration config) {
	        debug = config.getBoolean("debug", "client", debug, "Debug mode. Unless you're a developer or are told to activate it, you don't want to set this to true.");
	        disableBlockOverride = config.getBoolean("disableBlockOverride", "client", debug, "Disables right-click override on the vanilla dragon egg block. May help to fix issues with other mods.");
	        
	        if (config.hasChanged()) {
	            config.save();
	        }
	        
	        this.config = config;
	    }
	    
	    public Configuration getParent() {
	        return config;
	    }

	    public boolean isDebug() {
	        return debug;
	    }

	    public boolean isDisableBlockOverride() {
	        return disableBlockOverride;
	    }
	    
	    /*
		 * WORLDGEN
		 */
		
		public static boolean spawnStructures = true;

		public static boolean spawntesthouse = true;
		
		// chances
		public static int rubyChance = 500;
		public static int sapphireChance = 500;
		public static int testhousechance = 500;
		
		public static void init(File dir)
		{
			worldgen = new Configuration(new File(dir.getPath(), "worldgen.cfg"));
			
			sync();
		}
		
		private static void sync()
		{
			syncWorldGens();
		}
		
		private static void syncWorldGens() {
			String category = "worldgen";
			List<String> propOrder = Lists.newArrayList();
			Property prop;

			prop = worldgen.get(category, "spawnStructures", spawnStructures);
			prop.setComment("If true, structures will spawn throughout the world.");
			spawnStructures = prop.getBoolean();
			propOrder.add(prop.getName());
			
			prop = worldgen.get(category, "spawntesthouse", spawntesthouse);
			prop.setComment("If true, structures will spawn throughout the world (excludes dungeons).");
			spawntesthouse = prop.getBoolean();
			propOrder.add(prop.getName());
			
			// chances
			prop = worldgen.get(category, "spawnteshouse", testhousechance);
			prop.setComment("If true, structures will spawn throughout the world (excludes dungeons).");
			spawntesthouse = prop.getBoolean();
			propOrder.add(prop.getName());
			
			worldgen.setCategoryPropertyOrder(category, propOrder);
			worldgen.save();
		}
	}




