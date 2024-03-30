package net.mcreator.trumpcraft.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.trumpcraft.network.TrumpcraftModVariables;
import net.mcreator.trumpcraft.init.TrumpcraftModItems;

public class HexSoldierPledgeRightClickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player) {
			ItemStack _stktoremove = new ItemStack(TrumpcraftModItems.HEX_SOLDIER_PLEDGE.get());
			_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
		}
		TrumpcraftModVariables.MapVariables.get(world).UnlockedHexSoldierPledge = true;
		TrumpcraftModVariables.MapVariables.get(world).syncData(world);
	}
}
