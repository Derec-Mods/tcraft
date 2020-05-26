package net.mcreator.trumpcraft.procedures;

import net.minecraft.world.World;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.trumpcraft.entity.TrumpSquad3Entity;
import net.mcreator.trumpcraft.entity.TrumpSquad2Entity;
import net.mcreator.trumpcraft.entity.TrumpSquad1Entity;
import net.mcreator.trumpcraft.entity.TrumpSoldierEntity;
import net.mcreator.trumpcraft.entity.ArmoredTrumpSoldierEntity;
import net.mcreator.trumpcraft.TrumpcraftModVariables;
import net.mcreator.trumpcraft.TrumpcraftModElements;

@TrumpcraftModElements.ModElement.Tag
public class TrumpSummonSquad75Procedure extends TrumpcraftModElements.ModElement {
	public TrumpSummonSquad75Procedure(TrumpcraftModElements instance) {
		super(instance, 79);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure TrumpSummonSquad75!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure TrumpSummonSquad75!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure TrumpSummonSquad75!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure TrumpSummonSquad75!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure TrumpSummonSquad75!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		double stage = 0;
		if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) <= 150)
				&& ((TrumpcraftModVariables.MapVariables.get(world).TrumpStage) == 0))) {
			if (!world.isRemote) {
				Entity entityToSpawn = new TrumpSquad3Entity.CustomEntity(TrumpSquad3Entity.entity, world);
				entityToSpawn.setLocationAndAngles((x + 1), y, z, world.rand.nextFloat() * 360F, 0);
				world.addEntity(entityToSpawn);
			}
			if (!world.isRemote) {
				Entity entityToSpawn = new TrumpSquad3Entity.CustomEntity(TrumpSquad3Entity.entity, world);
				entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0);
				world.addEntity(entityToSpawn);
			}
			if (!world.isRemote) {
				Entity entityToSpawn = new TrumpSquad2Entity.CustomEntity(TrumpSquad2Entity.entity, world);
				entityToSpawn.setLocationAndAngles((x - 1), y, z, world.rand.nextFloat() * 360F, 0);
				world.addEntity(entityToSpawn);
			}
			TrumpcraftModVariables.MapVariables.get(world).TrumpStage = (double) 1;
			TrumpcraftModVariables.MapVariables.get(world).syncData(world);
		} else if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) <= 75)
				&& ((TrumpcraftModVariables.MapVariables.get(world).TrumpStage) == 1))) {
			if (!world.isRemote) {
				Entity entityToSpawn = new TrumpSquad2Entity.CustomEntity(TrumpSquad2Entity.entity, world);
				entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0);
				world.addEntity(entityToSpawn);
			}
			if (!world.isRemote) {
				Entity entityToSpawn = new TrumpSquad2Entity.CustomEntity(TrumpSquad2Entity.entity, world);
				entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0);
				world.addEntity(entityToSpawn);
			}
			if (!world.isRemote) {
				Entity entityToSpawn = new TrumpSquad1Entity.CustomEntity(TrumpSquad1Entity.entity, world);
				entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0);
				world.addEntity(entityToSpawn);
			}
			TrumpcraftModVariables.MapVariables.get(world).TrumpStage = (double) 2;
			TrumpcraftModVariables.MapVariables.get(world).syncData(world);
		} else if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) <= 25)
				&& ((TrumpcraftModVariables.MapVariables.get(world).TrumpStage) == 2))) {
			if (!world.isRemote) {
				Entity entityToSpawn = new TrumpSquad1Entity.CustomEntity(TrumpSquad1Entity.entity, world);
				entityToSpawn.setLocationAndAngles(x, y, (z - 2), world.rand.nextFloat() * 360F, 0);
				world.addEntity(entityToSpawn);
			}
			if (!world.isRemote) {
				Entity entityToSpawn = new TrumpSquad1Entity.CustomEntity(TrumpSquad1Entity.entity, world);
				entityToSpawn.setLocationAndAngles(x, y, (z - 2), world.rand.nextFloat() * 360F, 0);
				world.addEntity(entityToSpawn);
			}
			if (!world.isRemote) {
				Entity entityToSpawn = new ArmoredTrumpSoldierEntity.CustomEntity(ArmoredTrumpSoldierEntity.entity, world);
				entityToSpawn.setLocationAndAngles(x, y, (z - 2), world.rand.nextFloat() * 360F, 0);
				world.addEntity(entityToSpawn);
			}
			if (!world.isRemote) {
				Entity entityToSpawn = new TrumpSoldierEntity.CustomEntity(TrumpSoldierEntity.entity, world);
				entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0);
				world.addEntity(entityToSpawn);
			}
			if (!world.isRemote) {
				Entity entityToSpawn = new TrumpSoldierEntity.CustomEntity(TrumpSoldierEntity.entity, world);
				entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0);
				world.addEntity(entityToSpawn);
			}
			TrumpcraftModVariables.MapVariables.get(world).TrumpStage = (double) 3;
			TrumpcraftModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
