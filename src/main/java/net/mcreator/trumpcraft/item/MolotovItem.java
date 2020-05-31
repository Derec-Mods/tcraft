
package net.mcreator.trumpcraft.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.ActionResult;
import net.minecraft.network.IPacket;
import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.IRenderTypeBuffer;

import net.mcreator.trumpcraft.procedures.MolotovRangedItemUsedProcedure;
import net.mcreator.trumpcraft.procedures.MolotovBulletHitsLivingEntityProcedure;
import net.mcreator.trumpcraft.TrumpcraftModElements;

import java.util.Random;
import java.util.List;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@TrumpcraftModElements.ModElement.Tag
public class MolotovItem extends TrumpcraftModElements.ModElement {
	@ObjectHolder("trumpcraft:molotov")
	public static final Item block = null;
	@ObjectHolder("trumpcraft:entitybulletmolotov")
	public static final EntityType arrow = null;
	public MolotovItem(TrumpcraftModElements instance) {
		super(instance, 165);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemRanged());
		elements.entities.add(() -> (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(0.5f, 0.5f)).build("entitybulletmolotov").setRegistryName("entitybulletmolotov"));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void init(FMLCommonSetupEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(arrow, renderManager -> new CustomRender(renderManager));
	}
	public static class ItemRanged extends Item {
		public ItemRanged() {
			super(new Item.Properties().group(ItemGroup.COMBAT).maxDamage(1));
			setRegistryName("molotov");
		}

		@Override
		public UseAction getUseAction(ItemStack stack) {
			return UseAction.BOW;
		}

		@Override
		public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
			entity.setActiveHand(hand);
			return new ActionResult(ActionResultType.SUCCESS, entity.getHeldItem(hand));
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("That $400 better be put to good use"));
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 72000;
		}

		@Override
		public void onPlayerStoppedUsing(ItemStack itemstack, World world, LivingEntity entityLiving, int timeLeft) {
			if (!world.isRemote && entityLiving instanceof ServerPlayerEntity) {
				ServerPlayerEntity entity = (ServerPlayerEntity) entityLiving;
				ArrowCustomEntity entityarrow = shoot(world, entity, random, 1f, 5, 5);
				itemstack.damageItem(1, entity, e -> e.sendBreakAnimation(entity.getActiveHand()));
				entityarrow.pickupStatus = AbstractArrowEntity.PickupStatus.DISALLOWED;
				int x = (int) entity.getPosX();
				int y = (int) entity.getPosY();
				int z = (int) entity.getPosZ();
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("entity", entity);
					MolotovRangedItemUsedProcedure.executeProcedure($_dependencies);
				}
			}
		}
	}

	@OnlyIn(value = Dist.CLIENT, _interface = IRendersAsItem.class)
	public static class ArrowCustomEntity extends AbstractArrowEntity implements IRendersAsItem {
		public ArrowCustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			super(arrow, world);
		}

		public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, World world) {
			super(type, world);
		}

		public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, double x, double y, double z, World world) {
			super(type, x, y, z, world);
		}

		public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, LivingEntity entity, World world) {
			super(type, entity, world);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public ItemStack getItem() {
			return new ItemStack(MolotovItem.block, (int) (1));
		}

		@Override
		protected ItemStack getArrowStack() {
			return null;
		}

		@Override
		protected void arrowHit(LivingEntity entity) {
			super.arrowHit(entity);
			entity.setArrowCountInEntity(entity.getArrowCountInEntity() - 1);
			Entity sourceentity = this.getShooter();
			int x = (int) this.getPosX();
			int y = (int) this.getPosY();
			int z = (int) this.getPosZ();
			World world = this.world;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				MolotovBulletHitsLivingEntityProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		public void tick() {
			super.tick();
			int x = (int) this.getPosX();
			int y = (int) this.getPosY();
			int z = (int) this.getPosZ();
			World world = this.world;
			Entity entity = this.getShooter();
			if (this.inGround) {
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					MolotovBulletHitsLivingEntityProcedure.executeProcedure($_dependencies);
				}
				this.remove();
			}
		}
	}

	public static class CustomRender extends EntityRenderer<ArrowCustomEntity> {
		private static final ResourceLocation texture = new ResourceLocation("trumpcraft:textures/bottle.png");
		public CustomRender(EntityRendererManager renderManager) {
			super(renderManager);
		}

		@Override
		public void render(ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn,
				int packedLightIn) {
			IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
			matrixStackIn.push();
			matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
			matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
			EntityModel model = new Modelmolotov();
			model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
			matrixStackIn.pop();
			super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
		}

		@Override
		public ResourceLocation getEntityTexture(ArrowCustomEntity entity) {
			return texture;
		}
	}

	// Made with Blockbench
	// Paste this code into your mod.
	public static class Modelmolotov extends EntityModel<Entity> {
		private final ModelRenderer bone;
		private final ModelRenderer bone2;
		public Modelmolotov() {
			textureWidth = 16;
			textureHeight = 16;
			bone = new ModelRenderer(this);
			bone.setRotationPoint(0.0F, 24.0F, 0.0F);
			addBoxHelper(bone, 10, 3, -1.7F, -10.0F, -1.35F, 3, 10, 0, 0.0F, false);
			addBoxHelper(bone, 9, 0, 1.3F, -10.0F, -0.85F, 0, 10, 3, 0.0F, false);
			addBoxHelper(bone, 10, 3, -1.7F, -10.0F, 2.15F, 3, 10, 0, 0.0F, false);
			addBoxHelper(bone, 2, 0, -1.7F, -10.0F, -0.85F, 3, 10, 3, 0.0F, false);
			addBoxHelper(bone, 10, 11, -0.7F, -14.0F, 0.15F, 1, 3, 1, 0.0F, false);
			addBoxHelper(bone, 10, 7, -0.7F, -14.0F, 0.15F, 1, 0, 2, 0.0F, false);
			addBoxHelper(bone, 14, 0, -0.45F, -13.5F, 1.65F, 0, 0, 1, 0.0F, false);
			addBoxHelper(bone, 9, 0, -2.2F, -10.0F, -0.85F, 0, 10, 3, 0.0F, true);
			addBoxHelper(bone, 4, 2, -1.2F, -11.0F, -0.35F, 2, 10, 2, 0.0F, false);
			bone2 = new ModelRenderer(this);
			bone2.setRotationPoint(-11.4F, 17.75F, 18.3F);
		}

		@Override
		public void render(MatrixStack ms, IVertexBuilder vb, int i1, int i2, float f1, float f2, float f3, float f4) {
			bone.render(ms, vb, i1, i2, f1, f2, f3, f4);
			bone2.render(ms, vb, i1, i2, f1, f2, f3, f4);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
		}
	}
	@OnlyIn(Dist.CLIENT)
	public static void addBoxHelper(ModelRenderer renderer, int texU, int texV, float x, float y, float z, int dx, int dy, int dz, float delta) {
		addBoxHelper(renderer, texU, texV, x, y, z, dx, dy, dz, delta, renderer.mirror);
	}

	@OnlyIn(Dist.CLIENT)
	public static void addBoxHelper(ModelRenderer renderer, int texU, int texV, float x, float y, float z, int dx, int dy, int dz, float delta,
			boolean mirror) {
		renderer.mirror = mirror;
		renderer.addBox("", x, y, z, dx, dy, dz, delta, texU, texV);
	}

	public static ArrowCustomEntity shoot(World world, LivingEntity entity, Random random, float power, double damage, int knockback) {
		ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, world);
		entityarrow.shoot(entity.getLookVec().x, entity.getLookVec().y, entity.getLookVec().z, power * 2, 0);
		entityarrow.setSilent(true);
		entityarrow.setIsCritical(false);
		entityarrow.setDamage(damage);
		entityarrow.setKnockbackStrength(knockback);
		world.addEntity(entityarrow);
		int x = (int) entity.getPosX();
		int y = (int) entity.getPosY();
		int z = (int) entity.getPosZ();
		world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z,
				(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")),
				SoundCategory.PLAYERS, 1, 1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
		return entityarrow;
	}

	public static ArrowCustomEntity shoot(LivingEntity entity, LivingEntity target) {
		ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, entity.world);
		double d0 = target.getPosY() + (double) target.getEyeHeight() - 1.1;
		double d1 = target.getPosX() - entity.getPosX();
		double d3 = target.getPosZ() - entity.getPosZ();
		entityarrow.shoot(d1, d0 - entityarrow.getPosY() + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 1.6F, 12.0F);
		entityarrow.setSilent(true);
		entityarrow.setIsCritical(false);
		entity.world.addEntity(entityarrow);
		int x = (int) entity.getPosX();
		int y = (int) entity.getPosY();
		int z = (int) entity.getPosZ();
		entity.world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z,
				(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")),
				SoundCategory.PLAYERS, 1, 1f / (new Random().nextFloat() * 0.5f + 1));
		return entityarrow;
	}
}
