package net.mcreator.trumpcraft.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.trumpcraft.init.TrumpcraftModItems;

public class MoneypackPickaxeBlockDestroyedWithToolProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (Math.random() <= 0.1) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(TrumpcraftModItems.MONEY.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
	}
}
