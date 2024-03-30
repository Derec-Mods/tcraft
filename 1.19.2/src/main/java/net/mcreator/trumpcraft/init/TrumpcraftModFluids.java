
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.trumpcraft.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import net.mcreator.trumpcraft.fluid.LiquidMoneyFluid;
import net.mcreator.trumpcraft.TrumpcraftMod;

public class TrumpcraftModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(ForgeRegistries.FLUIDS, TrumpcraftMod.MODID);
	public static final RegistryObject<FlowingFluid> LIQUID_MONEY = REGISTRY.register("liquid_money", () -> new LiquidMoneyFluid.Source());
	public static final RegistryObject<FlowingFluid> FLOWING_LIQUID_MONEY = REGISTRY.register("flowing_liquid_money", () -> new LiquidMoneyFluid.Flowing());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(LIQUID_MONEY.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_LIQUID_MONEY.get(), RenderType.translucent());
		}
	}
}
