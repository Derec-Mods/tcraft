package net.mcreator.trumpcraft.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.mcreator.trumpcraft.entity.TrumpEntity;
import net.mcreator.trumpcraft.entity.TheTrumpEntity;
import net.mcreator.trumpcraft.TrumpcraftModElements;

@TrumpcraftModElements.ModElement.Tag
public class IftrumpProcedure extends TrumpcraftModElements.ModElement {
	public IftrumpProcedure(TrumpcraftModElements instance) {
		super(instance, 30);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Iftrump!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity instanceof TrumpEntity.CustomEntity)) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 999);
		}
		if ((entity instanceof TheTrumpEntity.CustomEntity)) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 999);
		}
	}
}
