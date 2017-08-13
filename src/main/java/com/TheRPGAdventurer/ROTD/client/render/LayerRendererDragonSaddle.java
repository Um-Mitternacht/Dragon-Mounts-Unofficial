package com.TheRPGAdventurer.ROTD.client.render;

import com.TheRPGAdventurer.ROTD.client.model.DragonModel;
import com.TheRPGAdventurer.ROTD.client.model.DragonModelMode;
import com.TheRPGAdventurer.ROTD.client.render.breeds.DefaultDragonBreedRenderer;
import com.TheRPGAdventurer.ROTD.server.entity.EntityTameableDragon;

import net.minecraft.client.renderer.GlStateManager;

/**
 * Created by EveryoneElse on 14/06/2015.
 */
public class LayerRendererDragonSaddle extends LayerRendererDragon {
    
    public LayerRendererDragonSaddle(DragonRenderer renderer,
            DefaultDragonBreedRenderer breedRenderer, DragonModel model) {
        super(renderer, breedRenderer, model);
    }
    
    @Override
    public void doRenderLayer(EntityTameableDragon dragon, float moveTime,
            float moveSpeed, float partialTicks, float ticksExisted, float lookYaw,
            float lookPitch, float scale) {
        if (!dragon.isSaddled()) {
            return;
        }
        
        renderer.bindTexture(breedRenderer.getSaddleTexture());
        GlStateManager.color(1, 1, 1, 1);
        model.setMode(DragonModelMode.BODY_ONLY);
        model.render(dragon, moveTime, moveSpeed, ticksExisted, lookYaw, lookPitch, scale);
    }

    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
}
