
package net.mcreator.trumpcraft.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.trumpcraft.entity.ThankyourandomcitizenEntity;

public class ThankyourandomcitizenRenderer extends HumanoidMobRenderer<ThankyourandomcitizenEntity, HumanoidModel<ThankyourandomcitizenEntity>> {
	public ThankyourandomcitizenRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR))));
	}

	@Override
	public ResourceLocation getTextureLocation(ThankyourandomcitizenEntity entity) {
		return new ResourceLocation("trumpcraft:textures/entities/skin-ea519b76754fb7e8107ccac89a75a02949f58476fac1d1bfc2d35d96f9b7cdf8.png");
	}
}
