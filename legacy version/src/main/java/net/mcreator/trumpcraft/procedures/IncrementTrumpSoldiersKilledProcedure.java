package net.mcreator.trumpcraft.procedures;

import net.minecraft.world.World;

import net.mcreator.trumpcraft.TrumpcraftModVariables;
import net.mcreator.trumpcraft.TrumpcraftModElements;

@TrumpcraftModElements.ModElement.Tag
public class IncrementTrumpSoldiersKilledProcedure extends TrumpcraftModElements.ModElement {
	public IncrementTrumpSoldiersKilledProcedure(TrumpcraftModElements instance) {
		super(instance, 159);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure IncrementTrumpSoldiersKilled!");
			return;
		}
		World world = (World) dependencies.get("world");
		TrumpcraftModVariables.MapVariables
				.get(world).TrumpSoldiersKilled = (double) ((TrumpcraftModVariables.MapVariables.get(world).TrumpSoldiersKilled) + 1);
		TrumpcraftModVariables.MapVariables.get(world).syncData(world);
	}
}
