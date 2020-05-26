package net.mcreator.trumpcraft.procedures;

import net.minecraft.world.World;

import net.mcreator.trumpcraft.TrumpcraftModVariables;
import net.mcreator.trumpcraft.TrumpcraftModElements;

@TrumpcraftModElements.ModElement.Tag
public class TrumpIncrementProcedure extends TrumpcraftModElements.ModElement {
	public TrumpIncrementProcedure(TrumpcraftModElements instance) {
		super(instance, 84);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure TrumpIncrement!");
			return;
		}
		World world = (World) dependencies.get("world");
		TrumpcraftModVariables.MapVariables
				.get(world).HexSoldiersKilled = (double) ((TrumpcraftModVariables.MapVariables.get(world).HexSoldiersKilled) + 1);
		TrumpcraftModVariables.MapVariables.get(world).syncData(world);
	}
}
