package com.TheRPGAdventurer.client;

import com.TheRPGAdventurer.RealmOfTheDragons;
import com.TheRPGAdventurer.client.gui.GuiDragonDebug;
import com.TheRPGAdventurer.client.init.ModArmour;
import com.TheRPGAdventurer.client.init.ModBlocks;
import com.TheRPGAdventurer.client.init.ModItems;
import com.TheRPGAdventurer.client.init.ModTools;
import com.TheRPGAdventurer.client.render.DragonRenderer;
import com.TheRPGAdventurer.server.CommonProxy;
import com.TheRPGAdventurer.server.entity.EntityTameableDragon;
import com.TheRPGAdventurer.server.entity.breeds.EnumDragonBreed;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void onPreInit(FMLPreInitializationEvent event) {
	    super.onPreInit(event);
	        
	// register dragon entity renderer
	RenderingRegistry.registerEntityRenderingHandler(
	EntityTameableDragon.class, DragonRenderer::new);
	        
	// register item renderer for dragon egg block variants
	ResourceLocation eggModelItemLoc = new ResourceLocation(RealmOfTheDragons.AID, "dragon_egg");
	Item itemBlockDragonEgg = Item.REGISTRY.getObject(eggModelItemLoc);
	EnumDragonBreed.META_MAPPING.forEach((breed, meta) -> {
	ModelResourceLocation eggModelLoc = new ModelResourceLocation(RealmOfTheDragons.AID + ":dragon_egg", "breed=" + breed.getName());
	ModelLoader.setCustomModelResourceLocation(itemBlockDragonEgg, meta, eggModelLoc);
	    });
	
	}
	
	@Override
	   public void registerRenders() {
		  ModItems.registerRenders();
		  ModTools.registerRenders();
		  ModArmour.registerRenders();
		  ModBlocks.registerRenders();
		
    }

    @Override
       public void onInit(FMLInitializationEvent evt) {
	        super.onInit(evt);
    }

    @Override
	   public void onPostInit(FMLPostInitializationEvent event) {
	       super.onPostInit(event);
	        
	   if (RealmOfTheDragons.instance.getConfig().isDebug()) {
	         MinecraftForge.EVENT_BUS.register(new GuiDragonDebug());
	        
	}
  }
}
	
	