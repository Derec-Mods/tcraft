package net.mcreator.trumpcraft.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;

public class RealPageOneOnButtonClickedProcedure {
	public static void execute(LevelAccessor world) {
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Lorebook Link: https://www.curseforge.com/minecraft/customization/trumpcraft-guidebook-lore"), false);
	}
}
