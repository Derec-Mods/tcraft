package net.mcreator.trumpcraft.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec2f;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import net.mcreator.trumpcraft.TrumpcraftModElements;

@TrumpcraftModElements.ModElement.Tag
public class MolotovBulletHitsLivingEntityProcedure extends TrumpcraftModElements.ModElement {
	public MolotovBulletHitsLivingEntityProcedure(TrumpcraftModElements instance) {
		super(instance, 180);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure MolotovBulletHitsLivingEntity!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MolotovBulletHitsLivingEntity!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure MolotovBulletHitsLivingEntity!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MolotovBulletHitsLivingEntity!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (!world.isRemote && world.getServer() != null) {
			world.getServer().getCommandManager()
					.handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), world.getServer(), null).withFeedbackDisabled(),
							"summon fireball ~ ~ ~ {ExplosionPower:4,direction:[0.0,0.0,0.0]}");
		}
	}
}
