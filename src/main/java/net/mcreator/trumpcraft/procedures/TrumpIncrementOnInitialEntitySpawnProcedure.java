package net.mcreator.trumpcraft.procedures;

import net.minecraft.world.World;
import net.minecraft.entity.monster.VexEntity;
import net.minecraft.entity.monster.IllusionerEntity;
import net.minecraft.entity.monster.EvokerEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;

import net.mcreator.trumpcraft.TrumpcraftModElements;

@TrumpcraftModElements.ModElement.Tag
public class TrumpIncrementOnInitialEntitySpawnProcedure extends TrumpcraftModElements.ModElement {
	public TrumpIncrementOnInitialEntitySpawnProcedure(TrumpcraftModElements instance) {
		super(instance, 110);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure TrumpIncrementOnInitialEntitySpawn!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure TrumpIncrementOnInitialEntitySpawn!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure TrumpIncrementOnInitialEntitySpawn!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure TrumpIncrementOnInitialEntitySpawn!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (!world.isRemote) {
			Entity entityToSpawn = new IllusionerEntity(EntityType.ILLUSIONER, world);
			entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0);
			world.addEntity(entityToSpawn);
		}
		if (!world.isRemote) {
			Entity entityToSpawn = new EvokerEntity(EntityType.EVOKER, world);
			entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0);
			world.addEntity(entityToSpawn);
		}
		for (int index0 = 0; index0 < (int) (3); index0++) {
			if (!world.isRemote) {
				Entity entityToSpawn = new VexEntity(EntityType.VEX, world);
				entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0);
				world.addEntity(entityToSpawn);
			}
		}
	}
}
