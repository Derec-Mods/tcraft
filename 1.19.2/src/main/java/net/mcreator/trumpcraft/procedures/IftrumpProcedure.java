package net.mcreator.trumpcraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.trumpcraft.entity.TrumpEntity;
import net.mcreator.trumpcraft.entity.TheTrumpEntity;

public class IftrumpProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof TrumpEntity) {
			entity.hurt(DamageSource.GENERIC, 999);
		}
		if (entity instanceof TheTrumpEntity) {
			entity.hurt(DamageSource.GENERIC, 999);
		}
	}
}
