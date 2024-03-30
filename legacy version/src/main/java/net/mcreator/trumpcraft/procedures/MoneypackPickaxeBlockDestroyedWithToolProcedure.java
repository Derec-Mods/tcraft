package net.mcreator.trumpcraft.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.trumpcraft.item.MoneyItem;
import net.mcreator.trumpcraft.TrumpcraftModElements;

@TrumpcraftModElements.ModElement.Tag
public class MoneypackPickaxeBlockDestroyedWithToolProcedure extends TrumpcraftModElements.ModElement {
	public MoneypackPickaxeBlockDestroyedWithToolProcedure(TrumpcraftModElements instance) {
		super(instance, 146);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MoneypackPickaxeBlockDestroyedWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((Math.random() <= 0.1)) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(MoneyItem.block, (int) (1));
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		}
	}
}
