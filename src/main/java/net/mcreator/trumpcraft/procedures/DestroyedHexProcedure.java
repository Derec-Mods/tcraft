package net.mcreator.trumpcraft.procedures;

import net.minecraft.world.World;

import net.mcreator.trumpcraft.TrumpcraftModVariables;
import net.mcreator.trumpcraft.TrumpcraftModElements;

@TrumpcraftModElements.ModElement.Tag
public class DestroyedHexProcedure extends TrumpcraftModElements.ModElement {
	public DestroyedHexProcedure(TrumpcraftModElements instance) {
		super(instance, 77);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure DestroyedHex!");
			return;
		}
		World world = (World) dependencies.get("world");
		TrumpcraftModVariables.MapVariables.get(world).KilledTheHex = (double) ((TrumpcraftModVariables.MapVariables.get(world).KilledTheHex) + 1);
		TrumpcraftModVariables.MapVariables.get(world).syncData(world);
		if (((TrumpcraftModVariables.MapVariables.get(world).KilledTheHex) == 6)) {
			TrumpcraftModVariables.MapVariables.get(world).HasHexBeenKilled = (String) "Destroyed";
			TrumpcraftModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
