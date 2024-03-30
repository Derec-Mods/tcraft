// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modeltrumperman extends EntityModel<Entity> {
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer headwear;
	private final ModelRenderer right_arm;
	private final ModelRenderer right_arm2;
	private final ModelRenderer left_arm;
	private final ModelRenderer left_arm2;
	private final ModelRenderer right_leg;
	private final ModelRenderer left_leg;

	public Modeltrumperman() {
		textureWidth = 64;
		textureHeight = 32;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, -15.0F, 0.0F);
		body.setTextureOffset(32, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, true);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -15.0F, 0.0F);
		head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, true);

		headwear = new ModelRenderer(this);
		headwear.setRotationPoint(0.0F, -15.0F, 0.0F);
		headwear.setTextureOffset(0, 16).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, -0.5F, true);

		right_arm = new ModelRenderer(this);
		right_arm.setRotationPoint(5.0F, -13.0F, 0.0F);
		right_arm.setTextureOffset(56, 0).addBox(-11.0F, -2.0F, -1.0F, 2.0F, 15.0F, 2.0F, 0.0F, true);

		right_arm2 = new ModelRenderer(this);
		right_arm2.setRotationPoint(0.0F, 0.0F, 1.0F);
		right_arm.addChild(right_arm2);
		setRotationAngle(right_arm2, -0.0873F, 0.0F, 0.0F);
		right_arm2.setTextureOffset(56, 0).addBox(-11.0F, 11.0F, -1.0F, 2.0F, 15.0F, 2.0F, 0.0F, true);

		left_arm = new ModelRenderer(this);
		left_arm.setRotationPoint(-5.0F, -28.0F, 0.0F);
		left_arm.setTextureOffset(56, 0).addBox(9.0F, 13.0F, -1.0F, 2.0F, 15.0F, 2.0F, 0.0F, true);

		left_arm2 = new ModelRenderer(this);
		left_arm2.setRotationPoint(0.0F, -3.0F, 2.0F);
		left_arm.addChild(left_arm2);
		setRotationAngle(left_arm2, -0.0873F, 0.0F, 0.0F);
		left_arm2.setTextureOffset(56, 0).addBox(9.0F, 29.0F, -1.0F, 2.0F, 15.0F, 2.0F, 0.0F, true);

		right_leg = new ModelRenderer(this);
		right_leg.setRotationPoint(2.0F, -6.0F, 0.0F);
		right_leg.setTextureOffset(56, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 30.0F, 2.0F, 0.0F, true);

		left_leg = new ModelRenderer(this);
		left_leg.setRotationPoint(-2.0F, -6.0F, 0.0F);
		left_leg.setTextureOffset(56, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 30.0F, 2.0F, 0.0F, true);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		headwear.render(matrixStack, buffer, packedLight, packedOverlay);
		right_arm.render(matrixStack, buffer, packedLight, packedOverlay);
		left_arm.render(matrixStack, buffer, packedLight, packedOverlay);
		right_leg.render(matrixStack, buffer, packedLight, packedOverlay);
		left_leg.render(matrixStack, buffer, packedLight, packedOverlay);
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
		this.right_arm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.left_arm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}