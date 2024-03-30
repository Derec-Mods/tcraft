//Made with Blockbench
//Paste this code into your mod.

public static class Modeltestsubject3 extends ModelBase {
	private final ModelRenderer head;
	private final ModelRenderer nose;
	private final ModelRenderer body;
	private final ModelRenderer arms;
	private final ModelRenderer leg0;
	private final ModelRenderer leg1;
	private final ModelRenderer rightarm;
	private final ModelRenderer leftarm;

	public Modeltestsubject3() {
		textureWidth = 64;
		textureHeight = 64;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 0, 0, -4.0F, -10.0F, -4.0F, 8, 10,
				8, 0.0F, true));

		nose = new ModelRenderer(this);
		nose.setRotationPoint(0.0F, -2.0F, 0.0F);
		setRotationAngle(nose, 0.6109F, -0.5236F, -0.9599F);
		nose.cubeList.add(new ModelBox(nose, 24, 0, -1.0F, -4.0F, -5.0F, 2, 4,
				2, 0.0F, true));

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 16, 20, -4.0F, 0.0F, -3.0F, 8, 12,
				6, 0.0F, true));
		body.cubeList.add(new ModelBox(body, 0, 38, -4.0F, 0.0F, -3.0F, 8, 18,
				6, 0.5F, true));

		arms = new ModelRenderer(this);
		arms.setRotationPoint(0.0F, 2.0F, 0.0F);
		setRotationAngle(arms, -1.2217F, 0.8727F, 0.0F);
		arms.cubeList.add(new ModelBox(arms, 40, 38, -4.0F, 2.0F, -2.0F, 8, 4,
				4, 0.0F, true));
		arms.cubeList.add(new ModelBox(arms, 44, 22, 2.0F, -2.0F, -2.0F, 4, 8,
				4, 0.0F, true));
		arms.cubeList.add(new ModelBox(arms, 44, 22, -2.0F, -2.0F, 2.0F, 4, 8,
				4, 0.0F, true));

		leg0 = new ModelRenderer(this);
		leg0.setRotationPoint(2.0F, 12.0F, 0.0F);
		leg0.cubeList.add(new ModelBox(leg0, 0, 22, -2.0F, 0.0F, -2.0F, 4, 12,
				4, 0.0F, true));

		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(-2.0F, 12.0F, 0.0F);
		leg1.cubeList.add(new ModelBox(leg1, 0, 22, -2.0F, 0.0F, -2.0F, 4, 12,
				4, 0.0F, false));

		rightarm = new ModelRenderer(this);
		rightarm.setRotationPoint(5.0F, 2.0F, 0.0F);
		setRotationAngle(rightarm, 0.0F, 0.6109F, 0.0F);
		rightarm.cubeList.add(new ModelBox(rightarm, 40, 46, -1.0F, -2.0F,
				-2.0F, 4, 12, 4, 0.0F, true));

		leftarm = new ModelRenderer(this);
		leftarm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		setRotationAngle(leftarm, 0.4363F, 2.0071F, 0.0F);
		leftarm.cubeList.add(new ModelBox(leftarm, 40, 46, -2.0F, -2.0F, -2.0F,
				4, 12, 4, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		head.render(f5);
		nose.render(f5);
		body.render(f5);
		arms.render(f5);
		leg0.render(f5);
		leg1.render(f5);
		rightarm.render(f5);
		leftarm.render(f5);
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
		this.head.rotateAngleY = MathHelper.cos(f * 0.6662F) * f1;
		this.nose.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.leg0.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI)
				* f1;
		this.leg1.rotateAngleY = f2 / 20.f;
		this.rightarm.rotateAngleX = f2 / 20.f;
		this.arms.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.leftarm.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.body.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}