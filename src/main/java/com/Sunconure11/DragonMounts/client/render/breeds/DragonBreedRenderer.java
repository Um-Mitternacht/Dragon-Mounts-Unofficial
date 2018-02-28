/*
** 2016 March 07
**
** The author disclaims copyright to this source code. In place of
** a legal notice, here is a blessing:
**    May you do good and not evil.
**    May you find forgiveness for yourself and forgive others.
**    May you share freely, never taking more than you give.
 */
package com.Sunconure11.DragonMounts.client.render.breeds;

import com.Sunconure11.DragonMounts.client.model.DragonModel;
import com.Sunconure11.DragonMounts.client.render.DragonRenderer;
import com.Sunconure11.DragonMounts.server.entity.EntityTameableDragon;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;

import java.util.List;

/**
 * @author Nico Bergemann <barracuda415 at yahoo.de>
 */
public interface DragonBreedRenderer {

	public ResourceLocation getBodyTexture();

	public ResourceLocation getDissolveTexture();

	public ResourceLocation getEggTexture();

	public ResourceLocation getGlowTexture();

	public ResourceLocation getGlowAnimTexture();

	public List<LayerRenderer<EntityTameableDragon>> getLayers();

	public DragonModel getModel();

	public DragonRenderer getRenderer();

	public ResourceLocation getSaddleTexture();

}
