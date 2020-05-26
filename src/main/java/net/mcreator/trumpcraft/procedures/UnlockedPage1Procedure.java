package net.mcreator.trumpcraft.procedures;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.trumpcraft.item.RealIntroUnlockItem;
import net.mcreator.trumpcraft.TrumpcraftModVariables;
import net.mcreator.trumpcraft.TrumpcraftModElements;

@TrumpcraftModElements.ModElement.Tag
public class UnlockedPage1Procedure extends TrumpcraftModElements.ModElement {
	public UnlockedPage1Procedure(TrumpcraftModElements instance) {
		super(instance, 126);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure UnlockedPage1!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure UnlockedPage1!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).inventory.clearMatchingItems(p -> new ItemStack(RealIntroUnlockItem.block, (int) (1)).getItem() == p.getItem(),
					(int) 1);
		TrumpcraftModVariables.MapVariables.get(world).UnlockedPage1 = (boolean) (true);
		TrumpcraftModVariables.MapVariables.get(world).syncData(world);
	}
}
