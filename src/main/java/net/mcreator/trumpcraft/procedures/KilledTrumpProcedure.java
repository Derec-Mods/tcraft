package net.mcreator.trumpcraft.procedures;

import net.minecraft.world.World;

import net.mcreator.trumpcraft.TrumpcraftModVariables;
import net.mcreator.trumpcraft.TrumpcraftModElements;

@TrumpcraftModElements.ModElement.Tag
public class KilledTrumpProcedure extends TrumpcraftModElements.ModElement {
	public KilledTrumpProcedure(TrumpcraftModElements instance) {
		super(instance, 76);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure KilledTrump!");
			return;
		}
		World world = (World) dependencies.get("world");
		TrumpcraftModVariables.MapVariables.get(world).TrumpStage = (double) 1;
		TrumpcraftModVariables.MapVariables.get(world).syncData(world);
		TrumpcraftModVariables.MapVariables.get(world).KilledTheTrump = (double) 1;
		TrumpcraftModVariables.MapVariables.get(world).syncData(world);
		if (((TrumpcraftModVariables.MapVariables.get(world).KilledTheTrump) == 1)) {
			TrumpcraftModVariables.MapVariables.get(world).HasTrumpBeenKilled = (String) "Killed";
			TrumpcraftModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
