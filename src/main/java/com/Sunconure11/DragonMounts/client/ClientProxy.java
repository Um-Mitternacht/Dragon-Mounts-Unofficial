/*
 ** 2012 August 27
 **
 ** The author disclaims copyright to this source code.  In place of
 ** a legal notice, here is a blessing:
 **    May you do good and not evil.
 **    May you find forgiveness for yourself and forgive others.
 **    May you share freely, never taking more than you give.
 */
package com.Sunconure11.DragonMounts.client;

import com.Sunconure11.DragonMounts.client.gui.GuiDragonDebug;
import com.Sunconure11.DragonMounts.client.render.DragonRenderer;
import com.Sunconure11.DragonMounts.server.CommonProxy;
import com.Sunconure11.DragonMounts.server.entity.EntityTameableDragon;
import com.Sunconure11.DragonMounts.DragonMounts;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * @author Nico Bergemann <barracuda415 at yahoo.de>
 */
public class ClientProxy extends CommonProxy {


	@Override
	public void onPreInit(FMLPreInitializationEvent event) {
		super.onPreInit(event);

		// register dragon entity renderer
		RenderingRegistry.registerEntityRenderingHandler(EntityTameableDragon.class, DragonRenderer::new);

	}

	@Override
	public void onInit(FMLInitializationEvent evt) {
		super.onInit(evt);
	}

	@Override
	public void onPostInit(FMLPostInitializationEvent event) {
		super.onPostInit(event);

		if (DragonMounts.instance.getConfig().isDebug()) {
			MinecraftForge.EVENT_BUS.register(new GuiDragonDebug());
		}
	}
}
