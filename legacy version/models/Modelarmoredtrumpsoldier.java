//Made with Blockbench
//Paste this code into your mod.

public static class Modelarmoredtrumpsoldier extends ModelBase {
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer arm0;
	private final ModelRenderer arm1;
	private final ModelRenderer leg0;
	private final ModelRenderer leg1;

	public Modelarmoredtrumpsoldier() {
		textureWidth = 128;
		textureHeight = 128;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, -7.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 0, 41, -9.0F, -2.0F, -6.0F, 18,
				12, 11, 0.0F, true));
		body.cubeList.add(new ModelBox(body, 0, 73, -4.5F, 10.0F, -3.0F, 9, 5,
				6, 0.5F, true));

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -7.0F, -2.0F);
		head.cubeList.add(new ModelBox(head, 0, 0, -4.0F, -12.0F, -2.5F, 8, 10,
				8, 0.0F, true));

		arm0 = new ModelRenderer(this);
		arm0.setRotationPoint(0.0F, -7.0F, 0.0F);
		arm0.cubeList.add(new ModelBox(arm0, 41, 0, 9.0F, 1.5F, -3.0F, 4, 18,
				6, 0.0F, true));
		arm0.cubeList.add(new ModelBox(arm0, 54, 2, 9.0F, -4.0F, -4.0F, 5, 6,
				8, 0.0F, false));

		arm1 = new ModelRenderer(this);
		arm1.setRotationPoint(0.0F, -7.0F, 0.0F);
		arm1.cubeList.add(new ModelBox(arm1, 60, 68, -13.0F, 1.5F, -3.0F, 4,
				18, 6, 0.0F, true));
		arm1.cubeList.add(new ModelBox(arm1, 53, 2, -14.0F, -4.0F, -4.0F, 5, 6,
				8, 0.0F, false));

		leg0 = new ModelRenderer(this);
		leg0.setRotationPoint(4.0F, 11.0F, 0.0F);
		leg0.cubeList.add(new ModelBox(leg0, 60, 69, -2.5F, -3.0F, -3.0F, 6,
				16, 5, 0.0F, true));

		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(-5.0F, 11.0F, 0.0F);
		leg1.cubeList.add(new ModelBox(leg1, 60, 69, -2.5F, -3.0F, -3.0F, 6,
				16, 5, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		body.render(f5);
		head.render(f5);
		arm0.render(f5);
		arm1.render(f5);
		leg0.render(f5);
		leg1.render(f5);
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
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.leg0.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.leg1.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.arm1.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI)
				* f1;
		this.arm0.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
	}
}