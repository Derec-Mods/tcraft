//Made with Blockbench
//Paste this code into your mod.

public static class Modeltestsubject4 extends ModelBase {
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer rightArm;
	private final ModelRenderer leftArm;
	private final ModelRenderer rightLeg;
	private final ModelRenderer leftLeg;

	public Modeltestsubject4() {
		textureWidth = 64;
		textureHeight = 32;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 17, 0, -4.0F, 0.0F, -2.0F, 8, 12,
				4, 0.0F, true));

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 3, 6, -4.0F, -8.0F, -2.0F, 8, 8,
				4, 0.0F, true));

		rightArm = new ModelRenderer(this);
		rightArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		rightArm.cubeList.add(new ModelBox(rightArm, 42, 0, -1.0F, -6.0F,
				-1.0F, 2, 18, 2, 0.0F, true));

		leftArm = new ModelRenderer(this);
		leftArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		leftArm.cubeList.add(new ModelBox(leftArm, 40, 42, -1.0F, -2.0F, -1.0F,
				2, 23, 2, 0.0F, false));

		rightLeg = new ModelRenderer(this);
		rightLeg.setRotationPoint(2.0F, 12.0F, 0.0F);
		rightLeg.cubeList.add(new ModelBox(rightLeg, 26, 16, -1.0F, -5.0F,
				-1.0F, 2, 17, 2, 0.0F, true));

		leftLeg = new ModelRenderer(this);
		leftLeg.setRotationPoint(-2.0F, 12.0F, 0.0F);
		leftLeg.cubeList.add(new ModelBox(leftLeg, 16, 1, -1.0F, 0.0F, -1.0F,
				2, 10, 2, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		body.render(f5);
		head.render(f5);
		rightArm.render(f5);
		leftArm.render(f5);
		rightLeg.render(f5);
		leftLeg.render(f5);
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
		this.rightLeg.rotateAngleX = MathHelper.cos(f * 0.6662F
				+ (float) Math.PI)
				* f1;
		this.rightArm.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.rightArm.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.leftArm.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.leftArm.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.leftLeg.rotateAngleY = MathHelper.cos(f * 0.6662F) * f1;
		this.body.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
	}
}