//Made with Blockbench
//Paste this code into your mod.

public static class Modelig extends ModelBase {
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer arm0;
	private final ModelRenderer arm1;
	private final ModelRenderer leg0;
	private final ModelRenderer leg1;
	private final ModelRenderer armright;
	private final ModelRenderer armleft;

	public Modelig() {
		textureWidth = 128;
		textureHeight = 128;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, -7.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 2, 56, -18.0F, -40.0F, -8.0F, 34, 26, 15, 0.0F, true));

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -7.0F, -2.0F);
		head.cubeList.add(new ModelBox(head, 61, 8, -3.0F, -52.0F, -2.5F, 8, 22, 8, 0.0F, true));
		head.cubeList.add(new ModelBox(head, 5, 3, -1.0F, -48.0F, -3.5F, 4, 7, 1, 0.0F, true));

		arm0 = new ModelRenderer(this);
		arm0.setRotationPoint(0.0F, -7.0F, 0.0F);
		setRotationAngle(arm0, 0.0F, -0.6109F, 0.0F);
		arm0.cubeList.add(new ModelBox(arm0, 75, 47, 9.5532F, -36.5F, -13.5886F, 6, 37, 6, 0.0F, true));

		arm1 = new ModelRenderer(this);
		arm1.setRotationPoint(0.0F, -7.0F, 0.0F);
		setRotationAngle(arm1, 0.0F, 0.5236F, 0.0F);
		arm1.cubeList.add(new ModelBox(arm1, 102, 5, -17.7942F, -36.5F, -12.5F, 7, 37, 6, 0.0F, true));

		leg0 = new ModelRenderer(this);
		leg0.setRotationPoint(4.0F, 11.0F, 0.0F);
		leg0.cubeList.add(new ModelBox(leg0, 0, 63, 0.5F, -37.0F, -4.0F, 8, 50, 7, 0.0F, true));

		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(-5.0F, 11.0F, 0.0F);
		leg1.cubeList.add(new ModelBox(leg1, 98, 25, -7.5F, -37.0F, -4.0F, 8, 50, 7, 0.0F, false));

		armright = new ModelRenderer(this);
		armright.setRotationPoint(0.0F, 24.0F, 0.0F);
		armright.cubeList.add(new ModelBox(armright, 89, 50, 14.0F, -51.5F, -4.0F, 6, 22, 6, 0.0F, true));

		armleft = new ModelRenderer(this);
		armleft.setRotationPoint(0.0F, 24.0F, 0.0F);
		armleft.cubeList.add(new ModelBox(armleft, 85, 48, -19.0F, -52.5F, -4.0F, 6, 21, 6, 0.0F, true));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		body.render(f5);
		head.render(f5);
		arm0.render(f5);
		arm1.render(f5);
		leg0.render(f5);
		leg1.render(f5);
		armright.render(f5);
		armleft.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.leg0.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.armright.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.leg1.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.armleft.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.arm1.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.arm0.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
	}
}