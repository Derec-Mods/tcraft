//Made with Blockbench
//Paste this code into your mod.

public static class Modeltrumpnade extends ModelBase {
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;

	public Modeltrumpnade() {
		textureWidth = 16;
		textureHeight = 16;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 1, 7, -2.0F, -5.0F, -1.0F, 2, 5,
				2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 5, 8, -2.5F, -4.0F, -1.5F, 3, 3,
				3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -1.6F, -6.0F, -0.6F, 1, 1,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -1.6F, -5.5F, 0.6F, 1, 2, 0,
				0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 1, -1.6F, -6.0F, 0.6F, 1, 0, 1,
				0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -1.4F, -5.5F, -0.2F, 0, 0,
				0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -1.7F, -5.5F, -0.2F, 0, 0,
				0, 0.0F, false));

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(-8.0F, 16.0F, 8.0F);
		setRotationAngle(bone2, 0.2618F, 0.0F, 0.0F);
		bone2.cubeList.add(new ModelBox(bone2, 0, 0, 6.4F, 0.2294F, -6.9274F,
				1, 2, 0, 0.0F, false));

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(-8.0F, 16.0F, 8.0F);
		bone3.cubeList.add(new ModelBox(bone3, 0, 0, 6.4F, 3.9F, -6.2F, 1, 2,
				0, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		bone.render(f5);
		bone2.render(f5);
		bone3.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y,
			float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3,
			float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}