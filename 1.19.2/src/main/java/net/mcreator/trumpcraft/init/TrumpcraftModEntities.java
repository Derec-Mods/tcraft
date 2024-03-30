
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.trumpcraft.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.trumpcraft.entity.VladEntity;
import net.mcreator.trumpcraft.entity.TrumpSquad3Entity;
import net.mcreator.trumpcraft.entity.TrumpSquad2Entity;
import net.mcreator.trumpcraft.entity.TrumpSquad1Entity;
import net.mcreator.trumpcraft.entity.TrumpSoldierEntity;
import net.mcreator.trumpcraft.entity.TrumpScoutEntity;
import net.mcreator.trumpcraft.entity.TrumpNadeEntity;
import net.mcreator.trumpcraft.entity.TrumpEntity;
import net.mcreator.trumpcraft.entity.TheTrumpEntity;
import net.mcreator.trumpcraft.entity.TheFnaticEntity;
import net.mcreator.trumpcraft.entity.ThankyourandomcitizenEntity;
import net.mcreator.trumpcraft.entity.TestSubjectEntity;
import net.mcreator.trumpcraft.entity.TestSubject4Entity;
import net.mcreator.trumpcraft.entity.TestSubject3Entity;
import net.mcreator.trumpcraft.entity.TestSubject1Entity;
import net.mcreator.trumpcraft.entity.SashaEntity;
import net.mcreator.trumpcraft.entity.PistolEntity;
import net.mcreator.trumpcraft.entity.MAGAShotgunEntity;
import net.mcreator.trumpcraft.entity.M57PilumEntity;
import net.mcreator.trumpcraft.entity.LivingBombEntity;
import net.mcreator.trumpcraft.entity.EvaEntity;
import net.mcreator.trumpcraft.entity.DeathSquadGolemEntity;
import net.mcreator.trumpcraft.entity.ArmoredTrumpSoldierEntity;
import net.mcreator.trumpcraft.entity.AntiTrumpToolEntity;
import net.mcreator.trumpcraft.entity.AWPEntity;
import net.mcreator.trumpcraft.TrumpcraftMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TrumpcraftModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TrumpcraftMod.MODID);
	public static final RegistryObject<EntityType<TrumpEntity>> TRUMPWANNABE = register("trumpwannabe",
			EntityType.Builder.<TrumpEntity>of(TrumpEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TrumpEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<TheTrumpEntity>> THE_TRUMP = register("the_trump",
			EntityType.Builder.<TheTrumpEntity>of(TheTrumpEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TheTrumpEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<EvaEntity>> EVA = register("eva",
			EntityType.Builder.<EvaEntity>of(EvaEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(EvaEntity::new).fireImmune().sized(0.7f, 2.5f));
	public static final RegistryObject<EntityType<AntiTrumpToolEntity>> ANTI_TRUMP_TOOL = register("projectile_anti_trump_tool",
			EntityType.Builder.<AntiTrumpToolEntity>of(AntiTrumpToolEntity::new, MobCategory.MISC).setCustomClientFactory(AntiTrumpToolEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<PistolEntity>> PISTOL = register("projectile_pistol",
			EntityType.Builder.<PistolEntity>of(PistolEntity::new, MobCategory.MISC).setCustomClientFactory(PistolEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<AWPEntity>> AWP = register("projectile_awp",
			EntityType.Builder.<AWPEntity>of(AWPEntity::new, MobCategory.MISC).setCustomClientFactory(AWPEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<M57PilumEntity>> M_57_PILUM = register("projectile_m_57_pilum",
			EntityType.Builder.<M57PilumEntity>of(M57PilumEntity::new, MobCategory.MISC).setCustomClientFactory(M57PilumEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<MAGAShotgunEntity>> MAGA_SHOTGUN = register("projectile_maga_shotgun",
			EntityType.Builder.<MAGAShotgunEntity>of(MAGAShotgunEntity::new, MobCategory.MISC).setCustomClientFactory(MAGAShotgunEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<TrumpNadeEntity>> TRUMP_NADE = register("projectile_trump_nade",
			EntityType.Builder.<TrumpNadeEntity>of(TrumpNadeEntity::new, MobCategory.MISC).setCustomClientFactory(TrumpNadeEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<TrumpSoldierEntity>> TRUMP_SOLDIER = register("trump_soldier", EntityType.Builder.<TrumpSoldierEntity>of(TrumpSoldierEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TrumpSoldierEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<ThankyourandomcitizenEntity>> THANKYOURANDOMCITIZEN = register("thankyourandomcitizen",
			EntityType.Builder.<ThankyourandomcitizenEntity>of(ThankyourandomcitizenEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(ThankyourandomcitizenEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<LivingBombEntity>> LIVING_BOMB = register("living_bomb",
			EntityType.Builder.<LivingBombEntity>of(LivingBombEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LivingBombEntity::new)

					.sized(0.6f, 1.7f));
	public static final RegistryObject<EntityType<TrumpSquad1Entity>> TRUMP_SQUAD_1 = register("trump_squad_1", EntityType.Builder.<TrumpSquad1Entity>of(TrumpSquad1Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TrumpSquad1Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<TrumpSquad2Entity>> TRUMP_SQUAD_2 = register("trump_squad_2", EntityType.Builder.<TrumpSquad2Entity>of(TrumpSquad2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TrumpSquad2Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<TrumpSquad3Entity>> TRUMP_SQUAD_3 = register("trump_squad_3", EntityType.Builder.<TrumpSquad3Entity>of(TrumpSquad3Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TrumpSquad3Entity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<ArmoredTrumpSoldierEntity>> ARMORED_TRUMP_SOLDIER = register("armored_trump_soldier", EntityType.Builder.<ArmoredTrumpSoldierEntity>of(ArmoredTrumpSoldierEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ArmoredTrumpSoldierEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<TestSubject1Entity>> TEST_SUBJECT_1 = register("test_subject_1",
			EntityType.Builder.<TestSubject1Entity>of(TestSubject1Entity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TestSubject1Entity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<TestSubjectEntity>> TEST_SUBJECT = register("test_subject",
			EntityType.Builder.<TestSubjectEntity>of(TestSubjectEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TestSubjectEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<TestSubject3Entity>> TEST_SUBJECT_3 = register("test_subject_3",
			EntityType.Builder.<TestSubject3Entity>of(TestSubject3Entity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TestSubject3Entity::new)

					.sized(0.9f, 1.4f));
	public static final RegistryObject<EntityType<TestSubject4Entity>> TEST_SUBJECT_4 = register("test_subject_4",
			EntityType.Builder.<TestSubject4Entity>of(TestSubject4Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TestSubject4Entity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<TrumpScoutEntity>> TRUMP_SCOUT = register("trump_scout",
			EntityType.Builder.<TrumpScoutEntity>of(TrumpScoutEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TrumpScoutEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<SashaEntity>> SASHA = register("sasha",
			EntityType.Builder.<SashaEntity>of(SashaEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SashaEntity::new)

					.sized(0.6f, 1.9f));
	public static final RegistryObject<EntityType<TheFnaticEntity>> THE_FNATIC = register("the_fnatic", EntityType.Builder.<TheFnaticEntity>of(TheFnaticEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(TheFnaticEntity::new).fireImmune().sized(0.5f, 1.7f));
	public static final RegistryObject<EntityType<DeathSquadGolemEntity>> DEATH_SQUAD_GOLEM = register("death_squad_golem", EntityType.Builder.<DeathSquadGolemEntity>of(DeathSquadGolemEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(DeathSquadGolemEntity::new).fireImmune().sized(0.6f, 2.1f));
	public static final RegistryObject<EntityType<VladEntity>> VLAD = register("vlad",
			EntityType.Builder.<VladEntity>of(VladEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(VladEntity::new)

					.sized(0.6f, 1.8f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			TrumpEntity.init();
			TheTrumpEntity.init();
			EvaEntity.init();
			TrumpSoldierEntity.init();
			ThankyourandomcitizenEntity.init();
			LivingBombEntity.init();
			TrumpSquad1Entity.init();
			TrumpSquad2Entity.init();
			TrumpSquad3Entity.init();
			ArmoredTrumpSoldierEntity.init();
			TestSubject1Entity.init();
			TestSubjectEntity.init();
			TestSubject3Entity.init();
			TestSubject4Entity.init();
			TrumpScoutEntity.init();
			SashaEntity.init();
			TheFnaticEntity.init();
			DeathSquadGolemEntity.init();
			VladEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(TRUMPWANNABE.get(), TrumpEntity.createAttributes().build());
		event.put(THE_TRUMP.get(), TheTrumpEntity.createAttributes().build());
		event.put(EVA.get(), EvaEntity.createAttributes().build());
		event.put(TRUMP_SOLDIER.get(), TrumpSoldierEntity.createAttributes().build());
		event.put(THANKYOURANDOMCITIZEN.get(), ThankyourandomcitizenEntity.createAttributes().build());
		event.put(LIVING_BOMB.get(), LivingBombEntity.createAttributes().build());
		event.put(TRUMP_SQUAD_1.get(), TrumpSquad1Entity.createAttributes().build());
		event.put(TRUMP_SQUAD_2.get(), TrumpSquad2Entity.createAttributes().build());
		event.put(TRUMP_SQUAD_3.get(), TrumpSquad3Entity.createAttributes().build());
		event.put(ARMORED_TRUMP_SOLDIER.get(), ArmoredTrumpSoldierEntity.createAttributes().build());
		event.put(TEST_SUBJECT_1.get(), TestSubject1Entity.createAttributes().build());
		event.put(TEST_SUBJECT.get(), TestSubjectEntity.createAttributes().build());
		event.put(TEST_SUBJECT_3.get(), TestSubject3Entity.createAttributes().build());
		event.put(TEST_SUBJECT_4.get(), TestSubject4Entity.createAttributes().build());
		event.put(TRUMP_SCOUT.get(), TrumpScoutEntity.createAttributes().build());
		event.put(SASHA.get(), SashaEntity.createAttributes().build());
		event.put(THE_FNATIC.get(), TheFnaticEntity.createAttributes().build());
		event.put(DEATH_SQUAD_GOLEM.get(), DeathSquadGolemEntity.createAttributes().build());
		event.put(VLAD.get(), VladEntity.createAttributes().build());
	}
}
