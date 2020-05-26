package net.mcreator.trumpcraft.procedures;

import net.minecraft.world.World;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;

import net.mcreator.trumpcraft.TrumpcraftModElements;

@TrumpcraftModElements.ModElement.Tag
public class ExplodeProcedure extends TrumpcraftModElements.ModElement {
	public ExplodeProcedure(TrumpcraftModElements instance) {
		super(instance, 35);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Explode!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure Explode!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure Explode!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure Explode!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Explode!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		entity.remove();
		if (!world.isRemote) {
			Entity entityToSpawn = new TNTEntity(EntityType.TNT, world);
			entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0);
			world.addEntity(entityToSpawn);
		}
	}
}
