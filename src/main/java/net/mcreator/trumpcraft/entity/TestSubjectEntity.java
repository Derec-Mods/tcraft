
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
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.monster.MonsterEntity;
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
public class TestSubjectEntity extends TrumpcraftModElements.ModElement {
	public static EntityType entity = null;
	public TestSubjectEntity(TrumpcraftModElements instance) {
		super(instance, 62);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("testsubject")
						.setRegistryName("testsubject");
		elements.entities.add(() -> entity);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("trumpcraft:labruins")))
				biomeCriteria = true;
			if (!biomeCriteria)
				continue;
			biome.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(entity, 10, 1, 5));
		}
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				MonsterEntity::canMonsterSpawn);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modeltestsubject1(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("trumpcraft:textures/testsubject1.png");
				}
			};
		});
	}
	public static class CustomEntity extends WolfEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 20;
			setNoAI(false);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setCallsForHelp(this.getClass()));
			this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 0.5, false));
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
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.ambient"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.polar_bear.hurt"));
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
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.1);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(3);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5);
		}
	}

	// Made with Blockbench
	// Paste this code into your mod.
	public static class Modeltestsubject1 extends EntityModel<Entity> {
		private final ModelRenderer body;
		private final ModelRenderer head;
		private final ModelRenderer leg0;
		private final ModelRenderer leg1;
		private final ModelRenderer leg2;
		private final ModelRenderer leg3;
		private final ModelRenderer tail;
		private final ModelRenderer tail_fin;
		private final ModelRenderer back_fin;
		private final ModelRenderer left_fin;
		private final ModelRenderer right_fin;
		private final ModelRenderer nose;
		public Modeltestsubject1() {
			textureWidth = 64;
			textureHeight = 64;
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 24.0F, -3.0F);
			setRotationAngle(body, 0.7854F, 0.0F, 0.0F);
			addBoxHelper(body, 0, 13, -1.0F, -7.0F, 0.0F, 8, 7, 13, 0.0F, true);
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 24.0F, -3.0F);
			setRotationAngle(head, -1.6581F, 0.0F, 0.0F);
			addBoxHelper(head, 0, 0, -4.0F, -7.0F, -6.0F, 8, 7, 6, 0.0F, true);
			leg0 = new ModelRenderer(this);
			leg0.setRotationPoint(2.0F, 18.0F, 4.0F);
			setRotationAngle(leg0, -0.8727F, 0.0F, 0.0F);
			addBoxHelper(leg0, 0, 16, -2.0F, 0.0F, -3.0F, 4, 7, 4, 0.0F, true);
			leg1 = new ModelRenderer(this);
			leg1.setRotationPoint(-2.0F, 18.0F, 4.0F);
			setRotationAngle(leg1, -2.1817F, -0.6981F, 0.0F);
			addBoxHelper(leg1, 8, 21, -2.0F, -1.0F, -2.0F, 4, 5, 4, 0.0F, true);
			leg2 = new ModelRenderer(this);
			leg2.setRotationPoint(2.0F, 18.0F, -4.0F);
			setRotationAngle(leg2, 0.0F, 0.0F, -0.2618F);
			addBoxHelper(leg2, 0, 16, -2.0F, 0.0F, 0.0F, 4, 6, 3, 0.0F, true);
			leg3 = new ModelRenderer(this);
			leg3.setRotationPoint(-2.0F, 18.0F, -4.0F);
			setRotationAngle(leg3, 0.3491F, 0.0F, 0.0F);
			addBoxHelper(leg3, 0, 16, -2.0F, 0.0F, -1.0F, 3, 6, 4, 0.0F, true);
			tail = new ModelRenderer(this);
			tail.setRotationPoint(0.0F, 21.5F, 11.0F);
			addBoxHelper(tail, 0, 33, -2.0F, -2.5F, -16.0F, 4, 5, 11, 0.0F, true);
			tail_fin = new ModelRenderer(this);
			tail_fin.setRotationPoint(0.0F, 21.5F, 20.0F);
			addBoxHelper(tail_fin, 0, 49, -8.0F, -0.5F, -21.0F, 10, 1, 6, 0.0F, true);
			back_fin = new ModelRenderer(this);
			back_fin.setRotationPoint(0.0F, 17.0F, 4.0F);
			addBoxHelper(back_fin, 29, 0, -0.5F, -5.0F, -1.0F, 1, 5, 4, 0.0F, true);
			left_fin = new ModelRenderer(this);
			left_fin.setRotationPoint(-3.0F, 23.0F, -1.0F);
			setRotationAngle(left_fin, 0.0F, -2.618F, 0.0F);
			addBoxHelper(left_fin, 40, 0, -8.0F, -1.0F, -1.0F, 8, 1, 4, 0.0F, true);
			right_fin = new ModelRenderer(this);
			right_fin.setRotationPoint(3.0F, 23.0F, -1.0F);
			addBoxHelper(right_fin, 40, 6, -3.0F, 0.0F, -1.0F, 8, 1, 4, 0.0F, true);
			nose = new ModelRenderer(this);
			nose.setRotationPoint(0.0F, 24.0F, -13.0F);
			setRotationAngle(nose, 0.0F, 0.0F, -0.1745F);
			addBoxHelper(nose, 0, 13, -4.0F, -2.0F, 6.0F, 2, 2, 4, 0.0F, true);
		}

		@Override
		public void render(MatrixStack ms, IVertexBuilder vb, int i1, int i2, float f1, float f2, float f3, float f4) {
			body.render(ms, vb, i1, i2, f1, f2, f3, f4);
			head.render(ms, vb, i1, i2, f1, f2, f3, f4);
			leg0.render(ms, vb, i1, i2, f1, f2, f3, f4);
			leg1.render(ms, vb, i1, i2, f1, f2, f3, f4);
			leg2.render(ms, vb, i1, i2, f1, f2, f3, f4);
			leg3.render(ms, vb, i1, i2, f1, f2, f3, f4);
			tail.render(ms, vb, i1, i2, f1, f2, f3, f4);
			tail_fin.render(ms, vb, i1, i2, f1, f2, f3, f4);
			back_fin.render(ms, vb, i1, i2, f1, f2, f3, f4);
			left_fin.render(ms, vb, i1, i2, f1, f2, f3, f4);
			right_fin.render(ms, vb, i1, i2, f1, f2, f3, f4);
			nose.render(ms, vb, i1, i2, f1, f2, f3, f4);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.head.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.leg0.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.leg1.rotateAngleY = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.left_fin.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.tail.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.right_fin.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.leg3.rotateAngleY = f2 / 20.f;
			this.body.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.body.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.tail_fin.rotateAngleZ = f3 / (180F / (float) Math.PI);
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
