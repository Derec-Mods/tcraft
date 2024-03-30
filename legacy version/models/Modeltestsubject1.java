//Made with Blockbench
//Paste this code into your mod.

public static class Modeltestsubject1 extends ModelBase {
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer leg0;
	private final ModelRenderer leg1;
	private final ModelRenderer leg2;
	private final ModelRenderer leg3;
	private final ModelRenderer tail;
	private final ModelRenderer tail_fin;
	private final ModelRenderer back_fin;
	private final ModelRenderer left_fin;
	private final ModelRenderer right_fin;
	private final ModelRenderer nose;

	public Modeltestsubject1() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, -3.0F);
		setRotationAngle(body, 0.7854F, 0.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 0, 13, -1.0F, -7.0F, 0.0F, 8, 7,
				13, 0.0F, true));

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 24.0F, -3.0F);
		setRotationAngle(head, -1.6581F, 0.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 0, 0, -4.0F, -7.0F, -6.0F, 8, 7,
				6, 0.0F, true));

		leg0 = new ModelRenderer(this);
		leg0.setRotationPoint(2.0F, 18.0F, 4.0F);
		setRotationAngle(leg0, -0.8727F, 0.0F, 0.0F);
		leg0.cubeList.add(new ModelBox(leg0, 0, 16, -2.0F, 0.0F, -3.0F, 4, 7,
				4, 0.0F, true));

		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(-2.0F, 18.0F, 4.0F);
		setRotationAngle(leg1, -2.1817F, -0.6981F, 0.0F);
		leg1.cubeList.add(new ModelBox(leg1, 8, 21, -2.0F, -1.0F, -2.0F, 4, 5,
				4, 0.0F, true));

		leg2 = new ModelRenderer(this);
		leg2.setRotationPoint(2.0F, 18.0F, -4.0F);
		setRotationAngle(leg2, 0.0F, 0.0F, -0.2618F);
		leg2.cubeList.add(new ModelBox(leg2, 0, 16, -2.0F, 0.0F, 0.0F, 4, 6, 3,
				0.0F, true));

		leg3 = new ModelRenderer(this);
		leg3.setRotationPoint(-2.0F, 18.0F, -4.0F);
		setRotationAngle(leg3, 0.3491F, 0.0F, 0.0F);
		leg3.cubeList.add(new ModelBox(leg3, 0, 16, -2.0F, 0.0F, -1.0F, 3, 6,
				4, 0.0F, true));

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, 21.5F, 11.0F);
		tail.cubeList.add(new ModelBox(tail, 0, 33, -2.0F, -2.5F, -16.0F, 4, 5,
				11, 0.0F, true));

		tail_fin = new ModelRenderer(this);
		tail_fin.setRotationPoint(0.0F, 21.5F, 20.0F);
		tail_fin.cubeList.add(new ModelBox(tail_fin, 0, 49, -8.0F, -0.5F,
				-21.0F, 10, 1, 6, 0.0F, true));

		back_fin = new ModelRenderer(this);
		back_fin.setRotationPoint(0.0F, 17.0F, 4.0F);
		back_fin.cubeList.add(new ModelBox(back_fin, 29, 0, -0.5F, -5.0F,
				-1.0F, 1, 5, 4, 0.0F, true));

		left_fin = new ModelRenderer(this);
		left_fin.setRotationPoint(-3.0F, 23.0F, -1.0F);
		setRotationAngle(left_fin, 0.0F, -2.618F, 0.0F);
		left_fin.cubeList.add(new ModelBox(left_fin, 40, 0, -8.0F, -1.0F,
				-1.0F, 8, 1, 4, 0.0F, true));

		right_fin = new ModelRenderer(this);
		right_fin.setRotationPoint(3.0F, 23.0F, -1.0F);
		right_fin.cubeList.add(new ModelBox(right_fin, 40, 6, -3.0F, 0.0F,
				-1.0F, 8, 1, 4, 0.0F, true));

		nose = new ModelRenderer(this);
		nose.setRotationPoint(0.0F, 24.0F, -13.0F);
		setRotationAngle(nose, 0.0F, 0.0F, -0.1745F);
		nose.cubeList.add(new ModelBox(nose, 0, 13, -4.0F, -2.0F, 6.0F, 2, 2,
				4, 0.0F, true));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		body.render(f5);
		head.render(f5);
		leg0.render(f5);
		leg1.render(f5);
		leg2.render(f5);
		leg3.render(f5);
		tail.render(f5);
		tail_fin.render(f5);
		back_fin.render(f5);
		left_fin.render(f5);
		right_fin.render(f5);
		nose.render(f5);
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
		this.head.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.leg0.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI)
				* f1;
		this.leg1.rotateAngleY = MathHelper.cos(f * 0.6662F + (float) Math.PI)
				* f1;
		this.left_fin.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.tail.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.right_fin.rotateAngleX = MathHelper.cos(f * 0.6662F
				+ (float) Math.PI)
				* f1;
		this.leg3.rotateAngleY = f2 / 20.f;
		this.body.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.body.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.tail_fin.rotateAngleZ = f3 / (180F / (float) Math.PI);
	}
}