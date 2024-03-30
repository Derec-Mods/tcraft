
package net.mcreator.trumpcraft.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.CreeperModel;

import net.mcreator.trumpcraft.entity.LivingBombEntity;

public class LivingBombRenderer extends MobRenderer<LivingBombEntity, CreeperModel<LivingBombEntity>> {
	public LivingBombRenderer(EntityRendererProvider.Context context) {
		super(context, new CreeperModel(context.bakeLayer(ModelLayers.CREEPER)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(LivingBombEntity entity) {
		return new ResourceLocation("trumpcraft:textures/entities/creeper.png");
	}
}
