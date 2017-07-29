package com.TheRPGAdventurer;

import java.util.Arrays;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;

public class RealmOfTheDragonsConfigGui extends GuiConfig {
	
	   private static final Configuration CONFIG = RealmOfTheDragons.instance.getConfig().getParent();
	   
	    public RealmOfTheDragonsConfigGui(GuiScreen parentScreen) {
	        super(
	            parentScreen,
	            Arrays.asList(
	                new ConfigElement(CONFIG.getCategory("server")),
	                new ConfigElement(CONFIG.getCategory("client"))
	            ),
	            RealmOfTheDragons.MODID,
	            false,
	            false,
	            RealmOfTheDragons.NAME
	        );
	    }
	    
	}



