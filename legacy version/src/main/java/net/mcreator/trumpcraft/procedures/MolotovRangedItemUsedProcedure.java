package net.mcreator.trumpcraft.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.trumpcraft.item.MolotovItem;
import net.mcreator.trumpcraft.TrumpcraftModElements;

@TrumpcraftModElements.ModElement.Tag
public class MolotovRangedItemUsedProcedure extends TrumpcraftModElements.ModElement {
	public MolotovRangedItemUsedProcedure(TrumpcraftModElements instance) {
		super(instance, 165);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MolotovRangedItemUsed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).inventory.clearMatchingItems(p -> new ItemStack(MolotovItem.block, (int) (1)).getItem() == p.getItem(), (int) 1);
	}
}
