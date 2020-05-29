//Made with Blockbench
//Paste this code into your mod.

public static class Modelmolotov extends ModelBase {
	private final ModelRenderer bone;
	private final ModelRenderer bone2;

	public Modelmolotov() {
		textureWidth = 16;
		textureHeight = 16;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 10, 3, -1.7F, -10.0F, -1.35F, 3, 10, 0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 9, 0, 1.3F, -10.0F, -0.85F, 0, 10, 3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 10, 3, -1.7F, -10.0F, 2.15F, 3, 10, 0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 2, 0, -1.7F, -10.0F, -0.85F, 3, 10, 3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 10, 11, -0.7F, -14.0F, 0.15F, 1, 3, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 10, 7, -0.7F, -14.0F, 0.15F, 1, 0, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 14, 0, -0.45F, -13.5F, 1.65F, 0, 0, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 9, 0, -2.2F, -10.0F, -0.85F, 0, 10, 3, 0.0F, true));
		bone.cubeList.add(new ModelBox(bone, 4, 2, -1.2F, -11.0F, -0.35F, 2, 10, 2, 0.0F, false));

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(-11.4F, 17.75F, 18.3F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		bone.render(f5);
		bone2.render(f5);
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