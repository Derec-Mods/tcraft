
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.trumpcraft.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fluids.FluidType;

import net.mcreator.trumpcraft.fluid.types.LiquidMoneyFluidType;
import net.mcreator.trumpcraft.TrumpcraftMod;

public class TrumpcraftModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, TrumpcraftMod.MODID);
	public static final RegistryObject<FluidType> LIQUID_MONEY_TYPE = REGISTRY.register("liquid_money", () -> new LiquidMoneyFluidType());
}
