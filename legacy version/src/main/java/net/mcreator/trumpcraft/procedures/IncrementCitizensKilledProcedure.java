package net.mcreator.trumpcraft.procedures;

import net.minecraft.world.World;

import net.mcreator.trumpcraft.TrumpcraftModVariables;
import net.mcreator.trumpcraft.TrumpcraftModElements;

@TrumpcraftModElements.ModElement.Tag
public class IncrementCitizensKilledProcedure extends TrumpcraftModElements.ModElement {
	public IncrementCitizensKilledProcedure(TrumpcraftModElements instance) {
		super(instance, 177);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure IncrementCitizensKilled!");
			return;
		}
		World world = (World) dependencies.get("world");
		TrumpcraftModVariables.MapVariables
				.get(world).CitizensKilled = (double) ((TrumpcraftModVariables.MapVariables.get(world).CitizensKilled) + 1);
		TrumpcraftModVariables.MapVariables.get(world).syncData(world);
	}
}
