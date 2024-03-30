
package net.mcreator.trumpcraft.block;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.trumpcraft.procedures.LiquidMoneyMobplayerColidesBlockProcedure;
import net.mcreator.trumpcraft.init.TrumpcraftModFluids;

public class LiquidMoneyBlock extends LiquidBlock {
	public LiquidMoneyBlock() {
		super(() -> TrumpcraftModFluids.LIQUID_MONEY.get(), BlockBehaviour.Properties.of(Material.WATER).strength(100f).noCollission().noLootTable());
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		LiquidMoneyMobplayerColidesBlockProcedure.execute(entity);
	}
}
