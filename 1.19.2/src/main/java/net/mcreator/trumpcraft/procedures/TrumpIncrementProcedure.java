package net.mcreator.trumpcraft.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.trumpcraft.network.TrumpcraftModVariables;

public class TrumpIncrementProcedure {
	public static void execute(LevelAccessor world) {
		TrumpcraftModVariables.MapVariables.get(world).HexSoldiersKilled = TrumpcraftModVariables.MapVariables.get(world).HexSoldiersKilled + 1;
		TrumpcraftModVariables.MapVariables.get(world).syncData(world);
	}
}
