package net.mcreator.trumpcraft.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.trumpcraft.TrumpcraftModElements;

@TrumpcraftModElements.ModElement.Tag
public class TgmCommandExecutedProcedure extends TrumpcraftModElements.ModElement {
	public TgmCommandExecutedProcedure(TrumpcraftModElements instance) {
		super(instance, 169);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure TgmCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.hasPermissionLevel((int) 2))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, (int) 99999, (int) 225, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SATURATION, (int) 99999, (int) 225, (false), (false)));
		}
	}
}
