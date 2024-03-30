package net.mcreator.trumpcraft.procedures;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.trumpcraft.item.HexBeforeAttack1Item;
import net.mcreator.trumpcraft.TrumpcraftModVariables;
import net.mcreator.trumpcraft.TrumpcraftModElements;

@TrumpcraftModElements.ModElement.Tag
public class HexBeforeAttack1RightClickedProcedure extends TrumpcraftModElements.ModElement {
	public HexBeforeAttack1RightClickedProcedure(TrumpcraftModElements instance) {
		super(instance, 135);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure HexBeforeAttack1RightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure HexBeforeAttack1RightClicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		TrumpcraftModVariables.MapVariables.get(world).UnlockedHexBeforeAttack1 = (boolean) (true);
		TrumpcraftModVariables.MapVariables.get(world).syncData(world);
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).inventory.clearMatchingItems(p -> new ItemStack(HexBeforeAttack1Item.block, (int) (1)).getItem() == p.getItem(),
					(int) 1);
	}
}
