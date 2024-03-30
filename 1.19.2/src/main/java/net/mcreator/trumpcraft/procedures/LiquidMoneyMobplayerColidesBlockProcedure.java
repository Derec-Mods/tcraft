package net.mcreator.trumpcraft.procedures;

import net.minecraft.world.entity.animal.Squid;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;

public class LiquidMoneyMobplayerColidesBlockProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Squid) {
			if (!entity.level.isClientSide())
				entity.discard();
		} else {
			entity.hurt(DamageSource.GENERIC, 1);
		}
	}
}
