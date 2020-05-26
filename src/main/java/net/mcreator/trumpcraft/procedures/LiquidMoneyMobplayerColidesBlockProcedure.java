package net.mcreator.trumpcraft.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.passive.SquidEntity;
import net.minecraft.entity.Entity;

import net.mcreator.trumpcraft.TrumpcraftModElements;

@TrumpcraftModElements.ModElement.Tag
public class LiquidMoneyMobplayerColidesBlockProcedure extends TrumpcraftModElements.ModElement {
	public LiquidMoneyMobplayerColidesBlockProcedure(TrumpcraftModElements instance) {
		super(instance, 7);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure LiquidMoneyMobplayerColidesBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity instanceof SquidEntity)) {
			entity.remove();
		} else {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 1);
		}
	}
}
