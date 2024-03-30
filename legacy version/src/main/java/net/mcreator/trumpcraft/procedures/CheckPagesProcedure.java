package net.mcreator.trumpcraft.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;

import net.mcreator.trumpcraft.TrumpcraftModVariables;
import net.mcreator.trumpcraft.TrumpcraftModElements;

@TrumpcraftModElements.ModElement.Tag
public class CheckPagesProcedure extends TrumpcraftModElements.ModElement {
	public CheckPagesProcedure(TrumpcraftModElements instance) {
		super(instance, 118);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure CheckPages!");
			return;
		}
		World world = (World) dependencies.get("world");
		if ((TrumpcraftModVariables.MapVariables.get(world).UnlockedPage1)) {
			TrumpcraftModVariables.MapVariables.get(world).Page1 = (String) "Unlocked";
			TrumpcraftModVariables.MapVariables.get(world).syncData(world);
		}
		if ((TrumpcraftModVariables.MapVariables.get(world).UnlockedWallMariaPatrol1)) {
			TrumpcraftModVariables.MapVariables.get(world).Page2 = (String) "Unlocked";
			TrumpcraftModVariables.MapVariables.get(world).syncData(world);
		}
		if ((TrumpcraftModVariables.MapVariables.get(world).UnlockedWallMariaPatrol2)) {
			TrumpcraftModVariables.MapVariables.get(world).Page3 = (String) "Unlocked";
			TrumpcraftModVariables.MapVariables.get(world).syncData(world);
		}
		if ((TrumpcraftModVariables.MapVariables.get(world).UnlockedHexSoldierPledge)) {
			TrumpcraftModVariables.MapVariables.get(world).HexSoldierPledge = (String) "Unlocked";
			TrumpcraftModVariables.MapVariables.get(world).syncData(world);
		}
		if ((TrumpcraftModVariables.MapVariables.get(world).UnlockedHexBeforeAttack1)) {
			TrumpcraftModVariables.MapVariables.get(world).BeforeAttack1 = (String) "Unlocked";
			TrumpcraftModVariables.MapVariables.get(world).syncData(world);
		}
	}

	@SubscribeEvent
	public void onWorldTick(TickEvent.WorldTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			World world = event.world;
			java.util.HashMap<String, Object> dependencies = new java.util.HashMap<>();
			dependencies.put("world", world);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
