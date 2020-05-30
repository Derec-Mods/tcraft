//Made with Blockbench
//Paste this code into your mod.

public static class Modelbullet extends ModelBase {
	private final ModelRenderer bone;

	public Modelbullet() {
		textureWidth = 16;
		textureHeight = 16;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(bone, 0.0F, 0.0F, -1.5708F);
		bone.cubeList.add(new ModelBox(bone, 0, 6, 0.0F, 6.0F, -3.0F, 6, 1, 6, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 5, 0.5F, 5.0F, -2.5F, 5, 1, 5, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 6, 0.0F, -5.0F, -3.0F, 6, 10, 6, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 1, 2, 0.3F, -6.0F, -2.7F, 5, 1, 5, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 1, 2, 0.8F, -7.0F, -2.2F, 4, 1, 4, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 1, 2, 1.3F, -7.0F, -1.7F, 3, 0, 3, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		bone.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}