
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.trumpcraft.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.biome.Biome;

import net.mcreator.trumpcraft.world.biome.WarzoneBiome;
import net.mcreator.trumpcraft.world.biome.WarTornPlainsBiome;
import net.mcreator.trumpcraft.world.biome.MoneyLandBiome;
import net.mcreator.trumpcraft.world.biome.MoneyLakeBiome;
import net.mcreator.trumpcraft.world.biome.LabruinsBiome;
import net.mcreator.trumpcraft.TrumpcraftMod;

public class TrumpcraftModBiomes {
	public static final DeferredRegister<Biome> REGISTRY = DeferredRegister.create(ForgeRegistries.BIOMES, TrumpcraftMod.MODID);
	public static final RegistryObject<Biome> WARZONE = REGISTRY.register("warzone", WarzoneBiome::createBiome);
	public static final RegistryObject<Biome> MONEY_LAKE = REGISTRY.register("money_lake", MoneyLakeBiome::createBiome);
	public static final RegistryObject<Biome> MONEY_LAND = REGISTRY.register("money_land", MoneyLandBiome::createBiome);
	public static final RegistryObject<Biome> WAR_TORN_PLAINS = REGISTRY.register("war_torn_plains", WarTornPlainsBiome::createBiome);
	public static final RegistryObject<Biome> LABRUINS = REGISTRY.register("labruins", LabruinsBiome::createBiome);
}
