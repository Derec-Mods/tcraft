
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.trumpcraft.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.trumpcraft.block.WarBlockBlock;
import net.mcreator.trumpcraft.block.MoneyWallBlock;
import net.mcreator.trumpcraft.block.MoneyTrapDoorBlock;
import net.mcreator.trumpcraft.block.MoneyStairsBlock;
import net.mcreator.trumpcraft.block.MoneySlabBlock;
import net.mcreator.trumpcraft.block.MoneyFenceBlock;
import net.mcreator.trumpcraft.block.MoneyChairBlock;
import net.mcreator.trumpcraft.block.MoneyBlockBlock;
import net.mcreator.trumpcraft.block.MURICAPortalBlock;
import net.mcreator.trumpcraft.block.LiquidMoneyBlock;
import net.mcreator.trumpcraft.block.FragmentofWallBlockBlock;
import net.mcreator.trumpcraft.block.ConverterBlock;
import net.mcreator.trumpcraft.TrumpcraftMod;

public class TrumpcraftModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, TrumpcraftMod.MODID);
	public static final RegistryObject<Block> CONVERTER = REGISTRY.register("converter", () -> new ConverterBlock());
	public static final RegistryObject<Block> LIQUID_MONEY = REGISTRY.register("liquid_money", () -> new LiquidMoneyBlock());
	public static final RegistryObject<Block> MONEY_BLOCK = REGISTRY.register("money_block", () -> new MoneyBlockBlock());
	public static final RegistryObject<Block> WAR_BLOCK = REGISTRY.register("war_block", () -> new WarBlockBlock());
	public static final RegistryObject<Block> MONEY_FENCE = REGISTRY.register("money_fence", () -> new MoneyFenceBlock());
	public static final RegistryObject<Block> MONEY_SLAB = REGISTRY.register("money_slab", () -> new MoneySlabBlock());
	public static final RegistryObject<Block> MONEY_WALL = REGISTRY.register("money_wall", () -> new MoneyWallBlock());
	public static final RegistryObject<Block> MONEY_STAIRS = REGISTRY.register("money_stairs", () -> new MoneyStairsBlock());
	public static final RegistryObject<Block> MURICA_PORTAL = REGISTRY.register("murica_portal", () -> new MURICAPortalBlock());
	public static final RegistryObject<Block> MONEY_TRAP_DOOR = REGISTRY.register("money_trap_door", () -> new MoneyTrapDoorBlock());
	public static final RegistryObject<Block> MONEY_CHAIR = REGISTRY.register("money_chair", () -> new MoneyChairBlock());
	public static final RegistryObject<Block> FRAGMENTOF_WALL_BLOCK = REGISTRY.register("fragmentof_wall_block", () -> new FragmentofWallBlockBlock());
}
