package net.mcreator.trumpcraft.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.trumpcraft.network.TrumpcraftModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class CheckPagesProcedure {
	@SubscribeEvent
	public static void onWorldTick(TickEvent.LevelTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.level);
		}
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if (TrumpcraftModVariables.MapVariables.get(world).UnlockedPage1) {
			TrumpcraftModVariables.MapVariables.get(world).Page1 = "Unlocked";
			TrumpcraftModVariables.MapVariables.get(world).syncData(world);
		}
		if (TrumpcraftModVariables.MapVariables.get(world).UnlockedWallMariaPatrol1) {
			TrumpcraftModVariables.MapVariables.get(world).Page2 = "Unlocked";
			TrumpcraftModVariables.MapVariables.get(world).syncData(world);
		}
		if (TrumpcraftModVariables.MapVariables.get(world).UnlockedWallMariaPatrol2) {
			TrumpcraftModVariables.MapVariables.get(world).Page3 = "Unlocked";
			TrumpcraftModVariables.MapVariables.get(world).syncData(world);
		}
		if (TrumpcraftModVariables.MapVariables.get(world).UnlockedHexSoldierPledge) {
			TrumpcraftModVariables.MapVariables.get(world).HexSoldierPledge = "Unlocked";
			TrumpcraftModVariables.MapVariables.get(world).syncData(world);
		}
		if (TrumpcraftModVariables.MapVariables.get(world).UnlockedHexBeforeAttack1) {
			TrumpcraftModVariables.MapVariables.get(world).BeforeAttack1 = "Unlocked";
			TrumpcraftModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
