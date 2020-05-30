package net.mcreator.trumpcraft.procedures;

import net.minecraft.world.World;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.trumpcraft.item.MAGAShotgunItem;
import net.mcreator.trumpcraft.TrumpcraftModElements;

import java.util.Random;

@TrumpcraftModElements.ModElement.Tag
public class MAGAShotgunRangedItemUsedProcedure extends TrumpcraftModElements.ModElement {
	public MAGAShotgunRangedItemUsedProcedure(TrumpcraftModElements instance) {
		super(instance, 65);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MAGAShotgunRangedItemUsed!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MAGAShotgunRangedItemUsed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		for (int index0 = 0; index0 < (int) (5); index0++) {
			if (!world.isRemote && entity instanceof LivingEntity) {
				MAGAShotgunItem.shoot(world, (LivingEntity) entity, new Random(), 1, (float) 5, (int) 0);
			}
		}
	}
}
