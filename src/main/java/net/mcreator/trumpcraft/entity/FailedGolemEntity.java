
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
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
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
public class FailedGolemEntity extends TrumpcraftModElements.ModElement {
	public static EntityType entity = null;
	public FailedGolemEntity(TrumpcraftModElements instance) {
		super(instance, 155);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire().size(3f, 5f)).build("failedgolem")
						.setRegistryName("failedgolem");
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
			biome.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(entity, 20, 1, 3));
		}
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				MonsterEntity::canMonsterSpawn);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelig(), 0.6f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("trumpcraft:textures/golemm.png");
				}
			};
		});
	}
	public static class CustomEntity extends MonsterEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 15;
			setNoAI(false);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, false));
			this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, PlayerEntity.class, false, false));
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
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.husk.ambient"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.creeper.death"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source == DamageSource.FALL)
				return false;
			if (source == DamageSource.DROWN)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5);
		}
	}

	// Made with Blockbench
	// Paste this code into your mod.
	public static class Modelig extends EntityModel<Entity> {
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
			addBoxHelper(body, 2, 56, -18.0F, -40.0F, -8.0F, 34, 26, 15, 0.0F, true);
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, -7.0F, -2.0F);
			addBoxHelper(head, 61, 8, -3.0F, -52.0F, -2.5F, 8, 22, 8, 0.0F, true);
			addBoxHelper(head, 5, 3, -1.0F, -48.0F, -3.5F, 4, 7, 1, 0.0F, true);
			arm0 = new ModelRenderer(this);
			arm0.setRotationPoint(0.0F, -7.0F, 0.0F);
			setRotationAngle(arm0, 0.0F, -0.6109F, 0.0F);
			addBoxHelper(arm0, 75, 47, 9.5532F, -36.5F, -13.5886F, 6, 37, 6, 0.0F, true);
			arm1 = new ModelRenderer(this);
			arm1.setRotationPoint(0.0F, -7.0F, 0.0F);
			setRotationAngle(arm1, 0.0F, 0.5236F, 0.0F);
			addBoxHelper(arm1, 102, 5, -17.7942F, -36.5F, -12.5F, 7, 37, 6, 0.0F, true);
			leg0 = new ModelRenderer(this);
			leg0.setRotationPoint(4.0F, 11.0F, 0.0F);
			addBoxHelper(leg0, 0, 63, 0.5F, -37.0F, -4.0F, 8, 50, 7, 0.0F, true);
			leg1 = new ModelRenderer(this);
			leg1.setRotationPoint(-5.0F, 11.0F, 0.0F);
			addBoxHelper(leg1, 98, 25, -7.5F, -37.0F, -4.0F, 8, 50, 7, 0.0F, false);
			armright = new ModelRenderer(this);
			armright.setRotationPoint(0.0F, 24.0F, 0.0F);
			addBoxHelper(armright, 89, 50, 14.0F, -51.5F, -4.0F, 6, 22, 6, 0.0F, true);
			armleft = new ModelRenderer(this);
			armleft.setRotationPoint(0.0F, 24.0F, 0.0F);
			addBoxHelper(armleft, 85, 48, -19.0F, -52.5F, -4.0F, 6, 21, 6, 0.0F, true);
		}

		@Override
		public void render(MatrixStack ms, IVertexBuilder vb, int i1, int i2, float f1, float f2, float f3, float f4) {
			body.render(ms, vb, i1, i2, f1, f2, f3, f4);
			head.render(ms, vb, i1, i2, f1, f2, f3, f4);
			arm0.render(ms, vb, i1, i2, f1, f2, f3, f4);
			arm1.render(ms, vb, i1, i2, f1, f2, f3, f4);
			leg0.render(ms, vb, i1, i2, f1, f2, f3, f4);
			leg1.render(ms, vb, i1, i2, f1, f2, f3, f4);
			armright.render(ms, vb, i1, i2, f1, f2, f3, f4);
			armleft.render(ms, vb, i1, i2, f1, f2, f3, f4);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
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
