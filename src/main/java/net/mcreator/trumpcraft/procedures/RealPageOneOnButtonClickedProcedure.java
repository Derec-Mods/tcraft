package net.mcreator.trumpcraft.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.server.MinecraftServer;

import net.mcreator.trumpcraft.TrumpcraftModElements;

@TrumpcraftModElements.ModElement.Tag
public class RealPageOneOnButtonClickedProcedure extends TrumpcraftModElements.ModElement {
	public RealPageOneOnButtonClickedProcedure(TrumpcraftModElements instance) {
		super(instance, 124);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		{
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null)
				mcserv.getPlayerList().sendMessage(
						new StringTextComponent("Lorebook Link: https://www.curseforge.com/minecraft/customization/trumpcraft-guidebook-lore"));
		}
	}
}
