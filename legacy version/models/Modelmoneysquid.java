//Made with Blockbench
//Paste this code into your mod.

public static class Modelmoneysquid extends ModelBase {
	private final ModelRenderer body;
	private final ModelRenderer tentacle1;
	private final ModelRenderer tentacle2;
	private final ModelRenderer tentacle3;
	private final ModelRenderer tentacle4;
	private final ModelRenderer tentacle5;
	private final ModelRenderer tentacle6;
	private final ModelRenderer tentacle7;
	private final ModelRenderer tentacle8;

	public Modelmoneysquid() {
		textureWidth = 64;
		textureHeight = 32;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 14, 4, -6.0F, -8.0F, -6.0F, 12, 16, 12, 0.0F, true));

		tentacle1 = new ModelRenderer(this);
		tentacle1.setRotationPoint(-5.0F, 31.0F, 0.0F);
		setRotationAngle(tentacle1, 0.0F, -1.5708F, 1.3963F);
		tentacle1.cubeList.add(new ModelBox(tentacle1, 48, 0, -1.0F, 0.0F, -1.0F, 2, 18, 2, 0.0F, true));

		tentacle2 = new ModelRenderer(this);
		tentacle2.setRotationPoint(-3.5F, 31.0F, 3.5F);
		setRotationAngle(tentacle2, 1.1345F, -0.7854F, 0.5236F);
		tentacle2.cubeList.add(new ModelBox(tentacle2, 48, 0, -1.0F, 0.0F, -1.0F, 2, 18, 2, 0.0F, true));

		tentacle3 = new ModelRenderer(this);
		tentacle3.setRotationPoint(0.0F, 31.0F, 5.0F);
		setRotationAngle(tentacle3, 1.3963F, 0.0F, 0.0F);
		tentacle3.cubeList.add(new ModelBox(tentacle3, 48, 0, -1.0F, 0.0F, -1.0F, 2, 18, 2, 0.0F, true));

		tentacle4 = new ModelRenderer(this);
		tentacle4.setRotationPoint(3.5F, 31.0F, 3.5F);
		setRotationAngle(tentacle4, 0.7854F, 0.5236F, -0.9599F);
		tentacle4.cubeList.add(new ModelBox(tentacle4, 37, 12, -1.0F, 0.0F, -1.0F, 2, 18, 2, 0.0F, true));

		tentacle5 = new ModelRenderer(this);
		tentacle5.setRotationPoint(5.0F, 31.0F, 0.0F);
		setRotationAngle(tentacle5, 0.0F, 1.5708F, -1.3963F);
		tentacle5.cubeList.add(new ModelBox(tentacle5, 48, 0, -1.0F, 0.0F, -1.0F, 2, 18, 2, 0.0F, true));

		tentacle6 = new ModelRenderer(this);
		tentacle6.setRotationPoint(3.5F, 31.0F, -3.5F);
		setRotationAngle(tentacle6, 0.7854F, 2.2689F, -0.8727F);
		tentacle6.cubeList.add(new ModelBox(tentacle6, 48, 0, -1.0F, 0.0F, -1.0F, 2, 18, 2, 0.0F, true));

		tentacle7 = new ModelRenderer(this);
		tentacle7.setRotationPoint(0.0F, 31.0F, -5.0F);
		setRotationAngle(tentacle7, 1.3963F, 3.1416F, 0.0F);
		tentacle7.cubeList.add(new ModelBox(tentacle7, 48, 0, -1.0F, 0.0F, -1.0F, 2, 18, 2, 0.0F, true));

		tentacle8 = new ModelRenderer(this);
		tentacle8.setRotationPoint(-3.5F, 31.0F, -3.5F);
		setRotationAngle(tentacle8, 1.4835F, 3.927F, 0.0F);
		tentacle8.cubeList.add(new ModelBox(tentacle8, 48, 0, -1.0F, 0.0F, -1.0F, 2, 18, 2, 0.0F, true));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		body.render(f5);
		tentacle1.render(f5);
		tentacle2.render(f5);
		tentacle3.render(f5);
		tentacle4.render(f5);
		tentacle5.render(f5);
		tentacle6.render(f5);
		tentacle7.render(f5);
		tentacle8.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.tentacle1.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.tentacle8.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.tentacle6.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.tentacle7.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.tentacle4.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.tentacle5.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.tentacle2.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.tentacle3.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
	}
}