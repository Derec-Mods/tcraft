
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
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.trumpcraft.TrumpcraftModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@TrumpcraftModElements.ModElement.Tag
public class TestSubject1Entity extends TrumpcraftModElements.ModElement {
	public static EntityType entity = null;
	public TestSubject1Entity(TrumpcraftModElements instance) {
		super(instance, 61);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.CREATURE).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("testsubject1")
						.setRegistryName("testsubject1");
		elements.entities.add(() -> entity);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("trumpcraft:wartornplains")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("trumpcraft:labruins")))
				biomeCriteria = true;
			if (!biomeCriteria)
				continue;
			biome.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(entity, 20, 1, 5));
		}
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				AnimalEntity::canAnimalSpawn);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modeltestsubject3(), 0.7f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("trumpcraft:textures/test_subject1.png");
				}
			};
		});
	}
	public static class CustomEntity extends CreatureEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 3;
			setNoAI(false);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setCallsForHelp(this.getClass()));
			this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, false));
			this.goalSelector.addGoal(3, new LookAtGoal(this, LivingBombEntity.CustomEntity.class, (float) 6));
			this.goalSelector.addGoal(4, new RandomWalkingGoal(this, 1));
			this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(6, new SwimGoal(this));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.vindicator.ambient"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.vex.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.death"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(3);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5);
		}
	}

	// Made with Blockbench
	// Paste this code into your mod.
	public static class Modeltestsubject3 extends EntityModel<Entity> {
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
			addBoxHelper(head, 0, 0, -4.0F, -10.0F, -4.0F, 8, 10, 8, 0.0F, true);
			nose = new ModelRenderer(this);
			nose.setRotationPoint(0.0F, -2.0F, 0.0F);
			setRotationAngle(nose, 0.6109F, -0.5236F, -0.9599F);
			addBoxHelper(nose, 24, 0, -1.0F, -4.0F, -5.0F, 2, 4, 2, 0.0F, true);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 0.0F, 0.0F);
			addBoxHelper(body, 16, 20, -4.0F, 0.0F, -3.0F, 8, 12, 6, 0.0F, true);
			addBoxHelper(body, 0, 38, -4.0F, 0.0F, -3.0F, 8, 18, 6, 0.5F, true);
			arms = new ModelRenderer(this);
			arms.setRotationPoint(0.0F, 2.0F, 0.0F);
			setRotationAngle(arms, -1.2217F, 0.8727F, 0.0F);
			addBoxHelper(arms, 40, 38, -4.0F, 2.0F, -2.0F, 8, 4, 4, 0.0F, true);
			addBoxHelper(arms, 44, 22, 2.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F, true);
			addBoxHelper(arms, 44, 22, -2.0F, -2.0F, 2.0F, 4, 8, 4, 0.0F, true);
			leg0 = new ModelRenderer(this);
			leg0.setRotationPoint(2.0F, 12.0F, 0.0F);
			addBoxHelper(leg0, 0, 22, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, true);
			leg1 = new ModelRenderer(this);
			leg1.setRotationPoint(-2.0F, 12.0F, 0.0F);
			addBoxHelper(leg1, 0, 22, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false);
			rightarm = new ModelRenderer(this);
			rightarm.setRotationPoint(5.0F, 2.0F, 0.0F);
			setRotationAngle(rightarm, 0.0F, 0.6109F, 0.0F);
			addBoxHelper(rightarm, 40, 46, -1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, true);
			leftarm = new ModelRenderer(this);
			leftarm.setRotationPoint(-5.0F, 2.0F, 0.0F);
			setRotationAngle(leftarm, 0.4363F, 2.0071F, 0.0F);
			addBoxHelper(leftarm, 40, 46, -2.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, false);
		}

		@Override
		public void render(MatrixStack ms, IVertexBuilder vb, int i1, int i2, float f1, float f2, float f3, float f4) {
			head.render(ms, vb, i1, i2, f1, f2, f3, f4);
			nose.render(ms, vb, i1, i2, f1, f2, f3, f4);
			body.render(ms, vb, i1, i2, f1, f2, f3, f4);
			arms.render(ms, vb, i1, i2, f1, f2, f3, f4);
			leg0.render(ms, vb, i1, i2, f1, f2, f3, f4);
			leg1.render(ms, vb, i1, i2, f1, f2, f3, f4);
			rightarm.render(ms, vb, i1, i2, f1, f2, f3, f4);
			leftarm.render(ms, vb, i1, i2, f1, f2, f3, f4);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.head.rotateAngleY = MathHelper.cos(f * 0.6662F) * f1;
			this.nose.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.leg0.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.leg1.rotateAngleY = f2 / 20.f;
			this.rightarm.rotateAngleX = f2 / 20.f;
			this.arms.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.leftarm.rotateAngleZ = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.body.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
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
