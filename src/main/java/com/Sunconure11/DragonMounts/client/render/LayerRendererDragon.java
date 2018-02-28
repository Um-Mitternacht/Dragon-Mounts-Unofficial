/*
** 2016 February 23
**
** The author disclaims copyright to this source code. In place of
** a legal notice, here is a blessing:
**    May you do good and not evil.
**    May you find forgiveness for yourself and forgive others.
**    May you share freely, never taking more than you give.
 */
package com.Sunconure11.DragonMounts.client.render;

import com.Sunconure11.DragonMounts.client.model.DragonModel;
import com.Sunconure11.DragonMounts.client.render.breeds.DefaultDragonBreedRenderer;
import com.Sunconure11.DragonMounts.server.entity.EntityTameableDragon;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;

/**
 * @author Nico Bergemann <barracuda415 at yahoo.de>
 */
public abstract class LayerRendererDragon implements LayerRenderer<EntityTameableDragon> {

	protected final DragonRenderer renderer;
	protected final DefaultDragonBreedRenderer breedRenderer;
	protected final DragonModel model;

	public LayerRendererDragon(DragonRenderer renderer,
	                           DefaultDragonBreedRenderer breedRenderer, DragonModel model) {
		this.renderer = renderer;
		this.breedRenderer = breedRenderer;
		this.model = model;
	}

	protected void disableLighting() {
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240, 240);
		GlStateManager.disableLighting();
	}

	protected void enableLighting(int b) {
		int u = b % 65536;
		int v = b / 65536;
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, u, v);
		GlStateManager.enableLighting();
	}
}
