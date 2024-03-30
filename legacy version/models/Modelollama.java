//Made with Blockbench
//Paste this code into your mod.

public static class Modelollama extends ModelBase {
	private final ModelRenderer head;
	private final ModelRenderer chest1;
	private final ModelRenderer chest2;
	private final ModelRenderer body;
	private final ModelRenderer leg0;
	private final ModelRenderer leg1;
	private final ModelRenderer leg2;
	private final ModelRenderer leg3;

	public Modelollama() {
		textureWidth = 128;
		textureHeight = 128;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 7.0F, -6.0F);
		head.cubeList.add(new ModelBox(head, 70, 22, -2.0F, -10.0F, -10.0F, 4, 4, 9, 0.0F, true));
		head.cubeList.add(new ModelBox(head, 63, 32, -6.0F, -16.0F, -5.0F, 12, 18, 6, 0.0F, true));
		head.cubeList.add(new ModelBox(head, 17, 0, 1.0F, -19.0F, -4.0F, 3, 3, 2, 0.0F, true));
		head.cubeList.add(new ModelBox(head, 17, 0, -4.0F, -19.0F, -4.0F, 3, 3, 2, 0.0F, true));

		chest1 = new ModelRenderer(this);
		chest1.setRotationPoint(8.5F, 3.0F, 3.0F);
		setRotationAngle(chest1, 0.0F, -1.5708F, 0.0F);
		chest1.cubeList.add(new ModelBox(chest1, 79, 45, -5.0F, 0.0F, 0.0F, 8, 8, 3, 0.0F, true));

		chest2 = new ModelRenderer(this);
		chest2.setRotationPoint(-5.5F, 3.0F, 3.0F);
		setRotationAngle(chest2, 0.0F, -1.5708F, 0.0F);
		chest2.cubeList.add(new ModelBox(chest2, 78, 46, -5.0F, 0.0F, 0.0F, 8, 8, 3, 0.0F, true));

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 5.0F, 2.0F);
		body.cubeList.add(new ModelBox(body, 53, 42, -6.0F, -10.0F, -7.0F, 12, 18, 10, 0.0F, true));

		leg0 = new ModelRenderer(this);
		leg0.setRotationPoint(3.5F, 10.0F, 6.0F);
		leg0.cubeList.add(new ModelBox(leg0, 0, 75, -2.0F, 0.0F, -2.0F, 4, 14, 4, 0.0F, true));

		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(-3.5F, 10.0F, 6.0F);
		leg1.cubeList.add(new ModelBox(leg1, 0, 58, -2.0F, 0.0F, -2.0F, 4, 14, 4, 0.0F, true));

		leg2 = new ModelRenderer(this);
		leg2.setRotationPoint(3.5F, 10.0F, -5.0F);
		leg2.cubeList.add(new ModelBox(leg2, 14, 49, -2.0F, 0.0F, -2.0F, 4, 14, 4, 0.0F, true));

		leg3 = new ModelRenderer(this);
		leg3.setRotationPoint(-3.5F, 10.0F, -5.0F);
		leg3.cubeList.add(new ModelBox(leg3, 0, 72, -2.0F, 0.0F, -2.0F, 4, 14, 4, 0.0F, true));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		head.render(f5);
		chest1.render(f5);
		chest2.render(f5);
		body.render(f5);
		leg0.render(f5);
		leg1.render(f5);
		leg2.render(f5);
		leg3.render(f5);
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
		this.leg1.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.leg2.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.leg3.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}