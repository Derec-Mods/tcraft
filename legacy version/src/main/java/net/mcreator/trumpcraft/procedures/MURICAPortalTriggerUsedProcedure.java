package net.mcreator.trumpcraft.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.server.MinecraftServer;

import net.mcreator.trumpcraft.TrumpcraftModElements;

@TrumpcraftModElements.ModElement.Tag
public class MURICAPortalTriggerUsedProcedure extends TrumpcraftModElements.ModElement {
	public MURICAPortalTriggerUsedProcedure(TrumpcraftModElements instance) {
		super(instance, 14);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MURICAPortalTriggerUsed!");
			return;
		}
		World world = (World) dependencies.get("world");
		if ((!(world.isRemote))) {
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new StringTextComponent("Welcome to the Land of the Free"));
			}
		}
	}
}
