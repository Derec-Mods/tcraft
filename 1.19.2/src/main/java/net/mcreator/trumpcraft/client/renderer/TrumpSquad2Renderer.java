
package net.mcreator.trumpcraft.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.trumpcraft.entity.TrumpSquad2Entity;

public class TrumpSquad2Renderer extends HumanoidMobRenderer<TrumpSquad2Entity, HumanoidModel<TrumpSquad2Entity>> {
	public TrumpSquad2Renderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR))));
	}

	@Override
	public ResourceLocation getTextureLocation(TrumpSquad2Entity entity) {
		return new ResourceLocation("trumpcraft:textures/entities/trumpsquad2.png");
	}
}