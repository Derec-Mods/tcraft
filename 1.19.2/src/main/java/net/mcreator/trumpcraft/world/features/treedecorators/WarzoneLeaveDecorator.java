package net.mcreator.trumpcraft.world.features.treedecorators;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.BlockPos;

public class WarzoneLeaveDecorator extends LeaveVineDecorator {
	public static final WarzoneLeaveDecorator INSTANCE = new WarzoneLeaveDecorator();
	public static com.mojang.serialization.Codec<LeaveVineDecorator> codec;
	public static TreeDecoratorType<?> tdt;
	static {
		codec = com.mojang.serialization.Codec.unit(() -> INSTANCE);
		tdt = new TreeDecoratorType<>(codec);
		ForgeRegistries.TREE_DECORATOR_TYPES.register("warzone_tree_leave_decorator", tdt);
	}

	public WarzoneLeaveDecorator() {
		super(0.25f);
	}

	@Override
	protected TreeDecoratorType<?> type() {
		return tdt;
	}

	@Override
	public void place(TreeDecorator.Context context) {
		context.leaves().forEach((blockpos) -> {
			if (context.random().nextFloat() < 0.25f) {
				BlockPos pos = blockpos.west();
				if (context.isAir(pos)) {
					addVine(pos, context);
				}
			}
			if (context.random().nextFloat() < 0.25f) {
				BlockPos pos = blockpos.east();
				if (context.isAir(pos)) {
					addVine(pos, context);
				}
			}
			if (context.random().nextFloat() < 0.25f) {
				BlockPos pos = blockpos.north();
				if (context.isAir(pos)) {
					addVine(pos, context);
				}
			}
			if (context.random().nextFloat() < 0.25f) {
				BlockPos pos = blockpos.south();
				if (context.isAir(pos)) {
					addVine(pos, context);
				}
			}
		});
	}

	private static void addVine(BlockPos pos, TreeDecorator.Context context) {
		context.setBlock(pos, Blocks.LAVA.defaultBlockState());
		int i = 4;
		for (BlockPos blockpos = pos.below(); context.isAir(blockpos) && i > 0; --i) {
			context.setBlock(blockpos, Blocks.LAVA.defaultBlockState());
			blockpos = blockpos.below();
		}
	}
}
