package net.mcreator.trumpcraft.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.trumpcraft.network.TrumpcraftModVariables;

public class KilledTrumpProcedure {
	public static void execute(LevelAccessor world) {
		TrumpcraftModVariables.MapVariables.get(world).TrumpStage = 1;
		TrumpcraftModVariables.MapVariables.get(world).syncData(world);
		TrumpcraftModVariables.MapVariables.get(world).KilledTheTrump = 1;
		TrumpcraftModVariables.MapVariables.get(world).syncData(world);
		if (TrumpcraftModVariables.MapVariables.get(world).KilledTheTrump == 1) {
			TrumpcraftModVariables.MapVariables.get(world).HasTrumpBeenKilled = "Killed";
			TrumpcraftModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
