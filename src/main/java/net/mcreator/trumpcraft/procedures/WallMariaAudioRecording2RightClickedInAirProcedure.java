package net.mcreator.trumpcraft.procedures;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.trumpcraft.item.WallMariaAudioRecording2Item;
import net.mcreator.trumpcraft.TrumpcraftModVariables;
import net.mcreator.trumpcraft.TrumpcraftModElements;

@TrumpcraftModElements.ModElement.Tag
public class WallMariaAudioRecording2RightClickedInAirProcedure extends TrumpcraftModElements.ModElement {
	public WallMariaAudioRecording2RightClickedInAirProcedure(TrumpcraftModElements instance) {
		super(instance, 123);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure WallMariaAudioRecording2RightClickedInAir!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure WallMariaAudioRecording2RightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).inventory
					.clearMatchingItems(p -> new ItemStack(WallMariaAudioRecording2Item.block, (int) (1)).getItem() == p.getItem(), (int) 1);
		TrumpcraftModVariables.MapVariables.get(world).UnlockedWallMariaPatrol2 = (boolean) (true);
		TrumpcraftModVariables.MapVariables.get(world).syncData(world);
	}
}
