package net.mcreator.trumpcraft.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.trumpcraft.network.TrumpcraftModVariables;

public class HexIncrementProcedure {
	public static void execute(LevelAccessor world) {
		TrumpcraftModVariables.MapVariables.get(world).TrumpSoldiersKilled = TrumpcraftModVariables.MapVariables.get(world).TrumpSoldiersKilled + 1;
		TrumpcraftModVariables.MapVariables.get(world).syncData(world);
	}
}
