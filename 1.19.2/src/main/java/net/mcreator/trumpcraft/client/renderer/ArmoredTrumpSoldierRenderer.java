
package net.mcreator.trumpcraft.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.trumpcraft.entity.ArmoredTrumpSoldierEntity;

public class ArmoredTrumpSoldierRenderer extends HumanoidMobRenderer<ArmoredTrumpSoldierEntity, HumanoidModel<ArmoredTrumpSoldierEntity>> {
	public ArmoredTrumpSoldierRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.7f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR))));
	}

	@Override
	public ResourceLocation getTextureLocation(ArmoredTrumpSoldierEntity entity) {
		return new ResourceLocation("trumpcraft:textures/entities/armored.png");
	}
}
