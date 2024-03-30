
package net.mcreator.trumpcraft.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.CowModel;

import net.mcreator.trumpcraft.entity.TestSubject3Entity;

public class TestSubject3Renderer extends MobRenderer<TestSubject3Entity, CowModel<TestSubject3Entity>> {
	public TestSubject3Renderer(EntityRendererProvider.Context context) {
		super(context, new CowModel(context.bakeLayer(ModelLayers.COW)), 0.3f);
	}

	@Override
	public ResourceLocation getTextureLocation(TestSubject3Entity entity) {
		return new ResourceLocation("trumpcraft:textures/entities/maga.png");
	}
}
