package net.mcreator.trumpcraft.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.trumpcraft.network.TrumpcraftModVariables;
import net.mcreator.trumpcraft.init.TrumpcraftModEntities;
import net.mcreator.trumpcraft.entity.TrumpSquad3Entity;
import net.mcreator.trumpcraft.entity.TrumpSquad2Entity;
import net.mcreator.trumpcraft.entity.TrumpSquad1Entity;
import net.mcreator.trumpcraft.entity.TrumpSoldierEntity;
import net.mcreator.trumpcraft.entity.ArmoredTrumpSoldierEntity;

public class TrumpSummonSquad75Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double stage = 0;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 150 && TrumpcraftModVariables.MapVariables.get(world).TrumpStage == 0) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new TrumpSquad3Entity(TrumpcraftModEntities.TRUMP_SQUAD_3.get(), _level);
				entityToSpawn.moveTo((x + 1), y, z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new TrumpSquad3Entity(TrumpcraftModEntities.TRUMP_SQUAD_3.get(), _level);
				entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new TrumpSquad2Entity(TrumpcraftModEntities.TRUMP_SQUAD_2.get(), _level);
				entityToSpawn.moveTo((x - 1), y, z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
			TrumpcraftModVariables.MapVariables.get(world).TrumpStage = 1;
			TrumpcraftModVariables.MapVariables.get(world).syncData(world);
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 75 && TrumpcraftModVariables.MapVariables.get(world).TrumpStage == 1) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new TrumpSquad2Entity(TrumpcraftModEntities.TRUMP_SQUAD_2.get(), _level);
				entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new TrumpSquad2Entity(TrumpcraftModEntities.TRUMP_SQUAD_2.get(), _level);
				entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new TrumpSquad1Entity(TrumpcraftModEntities.TRUMP_SQUAD_1.get(), _level);
				entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
			TrumpcraftModVariables.MapVariables.get(world).TrumpStage = 2;
			TrumpcraftModVariables.MapVariables.get(world).syncData(world);
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 25 && TrumpcraftModVariables.MapVariables.get(world).TrumpStage == 2) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new TrumpSquad1Entity(TrumpcraftModEntities.TRUMP_SQUAD_1.get(), _level);
				entityToSpawn.moveTo(x, y, (z - 2), world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new TrumpSquad1Entity(TrumpcraftModEntities.TRUMP_SQUAD_1.get(), _level);
				entityToSpawn.moveTo(x, y, (z - 2), world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new ArmoredTrumpSoldierEntity(TrumpcraftModEntities.ARMORED_TRUMP_SOLDIER.get(), _level);
				entityToSpawn.moveTo(x, y, (z - 2), world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new TrumpSoldierEntity(TrumpcraftModEntities.TRUMP_SOLDIER.get(), _level);
				entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new TrumpSoldierEntity(TrumpcraftModEntities.TRUMP_SOLDIER.get(), _level);
				entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
			TrumpcraftModVariables.MapVariables.get(world).TrumpStage = 3;
			TrumpcraftModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
