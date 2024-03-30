
package net.mcreator.trumpcraft.fluid;

import net.minecraftforge.fluids.ForgeFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;

import net.mcreator.trumpcraft.init.TrumpcraftModFluids;
import net.mcreator.trumpcraft.init.TrumpcraftModFluidTypes;
import net.mcreator.trumpcraft.init.TrumpcraftModBlocks;

public abstract class LiquidMoneyFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(() -> TrumpcraftModFluidTypes.LIQUID_MONEY_TYPE.get(), () -> TrumpcraftModFluids.LIQUID_MONEY.get(),
			() -> TrumpcraftModFluids.FLOWING_LIQUID_MONEY.get()).explosionResistance(100f).block(() -> (LiquidBlock) TrumpcraftModBlocks.LIQUID_MONEY.get());

	private LiquidMoneyFluid() {
		super(PROPERTIES);
	}

	public static class Source extends LiquidMoneyFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends LiquidMoneyFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}
