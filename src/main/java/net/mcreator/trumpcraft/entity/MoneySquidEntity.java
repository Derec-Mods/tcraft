
package net.mcreator.trumpcraft.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.world.IWorldReader;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.pathfinding.SwimmerPathNavigator;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.passive.SquidEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.trumpcraft.item.MoneyItem;
import net.mcreator.trumpcraft.TrumpcraftModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@TrumpcraftModElements.ModElement.Tag
public class MoneySquidEntity extends TrumpcraftModElements.ModElement {
	public static EntityType entity = null;
	public MoneySquidEntity(TrumpcraftModElements instance) {
		super(instance, 157);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.WATER_CREATURE)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new)
				.size(1f, 1.2000000000000002f)).build("money_squid").setRegistryName("money_squid");
		elements.entities.add(() -> entity);
		elements.items.add(
				() -> new SpawnEggItem(entity, -12956595, -16724941, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("money_squid"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("trumpcraft:moneylake")))
				biomeCriteria = true;
			if (!biomeCriteria)
				continue;
			biome.getSpawns(EntityClassification.WATER_CREATURE).add(new Biome.SpawnListEntry(entity, 20, 2, 5));
		}
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				SquidEntity::func_223365_b);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelmoneysquid(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("trumpcraft:textures/moneysquidtemp.png");
				}
			};
		});
	}
	public static class CustomEntity extends SquidEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 3;
			setNoAI(false);
			this.moveController = new MovementController(this) {
				@Override
				public void tick() {
					if (CustomEntity.this.areEyesInFluid(FluidTags.WATER))
						CustomEntity.this.setMotion(CustomEntity.this.getMotion().add(0, 0.005, 0));
					if (this.action == MovementController.Action.MOVE_TO && !CustomEntity.this.getNavigator().noPath()) {
						double dx = this.posX - CustomEntity.this.getPosX();
						double dy = this.posY - CustomEntity.this.getPosY();
						double dz = this.posZ - CustomEntity.this.getPosZ();
						dy = dy / (double) MathHelper.sqrt(dx * dx + dy * dy + dz * dz);
						CustomEntity.this.rotationYaw = this.limitAngle(CustomEntity.this.rotationYaw,
								(float) (MathHelper.atan2(dz, dx) * (double) (180 / (float) Math.PI)) - 90, 90);
						CustomEntity.this.renderYawOffset = CustomEntity.this.rotationYaw;
						CustomEntity.this.setAIMoveSpeed(MathHelper.lerp(0.125f, CustomEntity.this.getAIMoveSpeed(),
								(float) (this.speed * CustomEntity.this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue())));
						CustomEntity.this.setMotion(CustomEntity.this.getMotion().add(0, CustomEntity.this.getAIMoveSpeed() * dy * 0.1, 0));
					} else {
						CustomEntity.this.setAIMoveSpeed(0);
					}
				}
			};
			this.navigator = new SwimmerPathNavigator(this, this.world);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new SwimGoal(this));
			this.goalSelector.addGoal(2, new PanicGoal(this, 1.2));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
			this.entityDropItem(new ItemStack(MoneyItem.block, (int) (1)));
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.squid.ambient"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.squid.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.squid.death"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source == DamageSource.DROWN)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
		}

		@Override
		public boolean canBreatheUnderwater() {
			return true;
		}

		@Override
		public boolean isNotColliding(IWorldReader worldreader) {
			return worldreader.checkNoEntityCollision(this, VoxelShapes.create(this.getBoundingBox()));
		}

		@Override
		public boolean isPushedByWater() {
			return false;
		}
	}

	// Made with Blockbench
	// Paste this code into your mod.
	public static class Modelmoneysquid extends EntityModel<Entity> {
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
			addBoxHelper(body, 14, 4, -6.0F, -8.0F, -6.0F, 12, 16, 12, 0.0F, true);
			tentacle1 = new ModelRenderer(this);
			tentacle1.setRotationPoint(-5.0F, 31.0F, 0.0F);
			setRotationAngle(tentacle1, 0.0F, -1.5708F, 1.3963F);
			addBoxHelper(tentacle1, 48, 0, -1.0F, 0.0F, -1.0F, 2, 18, 2, 0.0F, true);
			tentacle2 = new ModelRenderer(this);
			tentacle2.setRotationPoint(-3.5F, 31.0F, 3.5F);
			setRotationAngle(tentacle2, 1.1345F, -0.7854F, 0.5236F);
			addBoxHelper(tentacle2, 48, 0, -1.0F, 0.0F, -1.0F, 2, 18, 2, 0.0F, true);
			tentacle3 = new ModelRenderer(this);
			tentacle3.setRotationPoint(0.0F, 31.0F, 5.0F);
			setRotationAngle(tentacle3, 1.3963F, 0.0F, 0.0F);
			addBoxHelper(tentacle3, 48, 0, -1.0F, 0.0F, -1.0F, 2, 18, 2, 0.0F, true);
			tentacle4 = new ModelRenderer(this);
			tentacle4.setRotationPoint(3.5F, 31.0F, 3.5F);
			setRotationAngle(tentacle4, 0.7854F, 0.5236F, -0.9599F);
			addBoxHelper(tentacle4, 37, 12, -1.0F, 0.0F, -1.0F, 2, 18, 2, 0.0F, true);
			tentacle5 = new ModelRenderer(this);
			tentacle5.setRotationPoint(5.0F, 31.0F, 0.0F);
			setRotationAngle(tentacle5, 0.0F, 1.5708F, -1.3963F);
			addBoxHelper(tentacle5, 48, 0, -1.0F, 0.0F, -1.0F, 2, 18, 2, 0.0F, true);
			tentacle6 = new ModelRenderer(this);
			tentacle6.setRotationPoint(3.5F, 31.0F, -3.5F);
			setRotationAngle(tentacle6, 0.7854F, 2.2689F, -0.8727F);
			addBoxHelper(tentacle6, 48, 0, -1.0F, 0.0F, -1.0F, 2, 18, 2, 0.0F, true);
			tentacle7 = new ModelRenderer(this);
			tentacle7.setRotationPoint(0.0F, 31.0F, -5.0F);
			setRotationAngle(tentacle7, 1.3963F, 3.1416F, 0.0F);
			addBoxHelper(tentacle7, 48, 0, -1.0F, 0.0F, -1.0F, 2, 18, 2, 0.0F, true);
			tentacle8 = new ModelRenderer(this);
			tentacle8.setRotationPoint(-3.5F, 31.0F, -3.5F);
			setRotationAngle(tentacle8, 1.4835F, 3.927F, 0.0F);
			addBoxHelper(tentacle8, 48, 0, -1.0F, 0.0F, -1.0F, 2, 18, 2, 0.0F, true);
		}

		@Override
		public void render(MatrixStack ms, IVertexBuilder vb, int i1, int i2, float f1, float f2, float f3, float f4) {
			body.render(ms, vb, i1, i2, f1, f2, f3, f4);
			tentacle1.render(ms, vb, i1, i2, f1, f2, f3, f4);
			tentacle2.render(ms, vb, i1, i2, f1, f2, f3, f4);
			tentacle3.render(ms, vb, i1, i2, f1, f2, f3, f4);
			tentacle4.render(ms, vb, i1, i2, f1, f2, f3, f4);
			tentacle5.render(ms, vb, i1, i2, f1, f2, f3, f4);
			tentacle6.render(ms, vb, i1, i2, f1, f2, f3, f4);
			tentacle7.render(ms, vb, i1, i2, f1, f2, f3, f4);
			tentacle8.render(ms, vb, i1, i2, f1, f2, f3, f4);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
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
}
