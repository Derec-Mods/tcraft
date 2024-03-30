//Made with Blockbench
//Paste this code into your mod.

public static class Modeltheeva extends ModelBase {
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer leftArm;
	private final ModelRenderer rightArm;
	private final ModelRenderer leftLeg;
	private final ModelRenderer rightLeg;
	private final ModelRenderer horn;

	public Modeltheeva() {
		textureWidth = 64;
		textureHeight = 32;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 0, 0, -4.0F, -16.0F, -4.0F, 8, 8,
				8, 0.0F, true));

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 16, 16, -4.0F, -8.0F, -2.0F, 8,
				14, 4, 0.0F, true));

		leftArm = new ModelRenderer(this);
		leftArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		setRotationAngle(leftArm, 0.0F, 0.0F, 0.0873F);
		leftArm.cubeList.add(new ModelBox(leftArm, 40, 16, -4.0F, -10.0F,
				-2.0F, 4, 17, 4, 0.0F, false));
		leftArm.cubeList.add(new ModelBox(leftArm, 0, 0, -3.0F, -6.0F, 2.0F, 2,
				7, 2, 0.0F, false));

		rightArm = new ModelRenderer(this);
		rightArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		setRotationAngle(rightArm, 0.0F, 0.0F, -0.0873F);
		rightArm.cubeList.add(new ModelBox(rightArm, 0, 0, 1.0F, -6.0F, 2.0F,
				2, 7, 2, 0.0F, false));
		rightArm.cubeList.add(new ModelBox(rightArm, 40, 16, 0.0F, -10.0F,
				-2.0F, 4, 17, 4, 0.0F, true));

		leftLeg = new ModelRenderer(this);
		leftLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
		leftLeg.cubeList.add(new ModelBox(leftLeg, 0, 16, -2.0F, -6.0F, -2.0F,
				3, 18, 4, 0.0F, false));
		leftLeg.cubeList.add(new ModelBox(leftLeg, 0, 0, -2.0F, 11.0F, -6.0F,
				3, 1, 4, 0.0F, false));
		leftLeg.cubeList.add(new ModelBox(leftLeg, 0, 0, -2.0F, 10.0F, -4.0F,
				3, 1, 2, 0.0F, false));
		leftLeg.cubeList.add(new ModelBox(leftLeg, 56, 30, -2.0F, 9.0F, -3.0F,
				3, 1, 1, 0.0F, false));

		rightLeg = new ModelRenderer(this);
		rightLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
		rightLeg.cubeList.add(new ModelBox(rightLeg, 0, 16, -1.0F, -6.0F,
				-2.0F, 3, 18, 4, 0.0F, true));
		rightLeg.cubeList.add(new ModelBox(rightLeg, 56, 30, -0.8F, 9.0F,
				-3.0F, 3, 1, 1, 0.0F, false));
		rightLeg.cubeList.add(new ModelBox(rightLeg, 0, 0, -0.8F, 10.0F, -4.0F,
				3, 1, 2, 0.0F, false));
		rightLeg.cubeList.add(new ModelBox(rightLeg, 0, 0, -0.8F, 11.0F, -6.0F,
				3, 1, 4, 0.0F, false));

		horn = new ModelRenderer(this);
		horn.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(horn, 0.2618F, 0.0F, 0.0F);
		horn.cubeList.add(new ModelBox(horn, 0, 0, -1.0F, -47.0F, 7.0F, 2, 5,
				1, 0.0F, false));
		horn.cubeList.add(new ModelBox(horn, 44, 25, -1.0F, -42.0F, 7.0F, 2, 1,
				1, 0.0F, false));
		horn.cubeList.add(new ModelBox(horn, 0, 0, -1.0F, -41.0F, 7.0F, 2, 2,
				1, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		head.render(f5);
		body.render(f5);
		leftArm.render(f5);
		rightArm.render(f5);
		leftLeg.render(f5);
		rightLeg.render(f5);
		horn.render(f5);
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
		this.rightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.rightArm.rotateAngleX = MathHelper.cos(f * 0.6662F
				+ (float) Math.PI)
				* f1;
		this.leftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.leftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}