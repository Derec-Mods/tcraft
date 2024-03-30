package net.mcreator.trumpcraft.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.trumpcraft.network.TrumpcraftModVariables;

public class DestroyedHexProcedure {
	public static void execute(LevelAccessor world) {
		TrumpcraftModVariables.MapVariables.get(world).KilledTheHex = TrumpcraftModVariables.MapVariables.get(world).KilledTheHex + 1;
		TrumpcraftModVariables.MapVariables.get(world).syncData(world);
		if (TrumpcraftModVariables.MapVariables.get(world).KilledTheHex == 6) {
			TrumpcraftModVariables.MapVariables.get(world).HasHexBeenKilled = "Destroyed";
			TrumpcraftModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
