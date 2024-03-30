
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.trumpcraft.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.levelgen.feature.Feature;

import net.mcreator.trumpcraft.world.features.Trumpshelter2Feature;
import net.mcreator.trumpcraft.world.features.TrumpShelterFeature;
import net.mcreator.trumpcraft.world.features.TrumpShelter3Feature;
import net.mcreator.trumpcraft.world.features.Tree2Feature;
import net.mcreator.trumpcraft.world.features.Tree1Feature;
import net.mcreator.trumpcraft.world.features.Ruins9Feature;
import net.mcreator.trumpcraft.world.features.Ruins8Feature;
import net.mcreator.trumpcraft.world.features.Ruins7Feature;
import net.mcreator.trumpcraft.world.features.Ruins6Feature;
import net.mcreator.trumpcraft.world.features.Ruins5Feature;
import net.mcreator.trumpcraft.world.features.Ruins4Feature;
import net.mcreator.trumpcraft.world.features.Ruins3Feature;
import net.mcreator.trumpcraft.world.features.Ruins2Feature;
import net.mcreator.trumpcraft.world.features.Ruins12Feature;
import net.mcreator.trumpcraft.world.features.Ruins11Feature;
import net.mcreator.trumpcraft.world.features.Ruins10Feature;
import net.mcreator.trumpcraft.world.features.RealRuins2Feature;
import net.mcreator.trumpcraft.world.features.LiquidMoneyFeatureFeature;
import net.mcreator.trumpcraft.world.features.Labruins2Feature;
import net.mcreator.trumpcraft.world.features.LabRuins6Feature;
import net.mcreator.trumpcraft.world.features.LabRuins5Feature;
import net.mcreator.trumpcraft.world.features.LabRuins4Feature;
import net.mcreator.trumpcraft.world.features.LabRuins3Feature;
import net.mcreator.trumpcraft.world.features.LabRuins1Feature;
import net.mcreator.trumpcraft.world.features.Lab1Feature;
import net.mcreator.trumpcraft.world.features.Highway1Feature;
import net.mcreator.trumpcraft.world.features.Farm2Feature;
import net.mcreator.trumpcraft.world.features.Farm1Feature;
import net.mcreator.trumpcraft.world.features.Bunker4Feature;
import net.mcreator.trumpcraft.TrumpcraftMod;

@Mod.EventBusSubscriber
public class TrumpcraftModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, TrumpcraftMod.MODID);
	public static final RegistryObject<Feature<?>> TRUMP_SHELTER = REGISTRY.register("trump_shelter", TrumpShelterFeature::feature);
	public static final RegistryObject<Feature<?>> TRUMPSHELTER_2 = REGISTRY.register("trumpshelter_2", Trumpshelter2Feature::feature);
	public static final RegistryObject<Feature<?>> TRUMP_SHELTER_3 = REGISTRY.register("trump_shelter_3", TrumpShelter3Feature::feature);
	public static final RegistryObject<Feature<?>> HIGHWAY_1 = REGISTRY.register("highway_1", Highway1Feature::feature);
	public static final RegistryObject<Feature<?>> BUNKER_4 = REGISTRY.register("bunker_4", Bunker4Feature::feature);
	public static final RegistryObject<Feature<?>> RUINS_2 = REGISTRY.register("ruins_2", Ruins2Feature::feature);
	public static final RegistryObject<Feature<?>> REAL_RUINS_2 = REGISTRY.register("real_ruins_2", RealRuins2Feature::feature);
	public static final RegistryObject<Feature<?>> RUINS_3 = REGISTRY.register("ruins_3", Ruins3Feature::feature);
	public static final RegistryObject<Feature<?>> RUINS_4 = REGISTRY.register("ruins_4", Ruins4Feature::feature);
	public static final RegistryObject<Feature<?>> RUINS_5 = REGISTRY.register("ruins_5", Ruins5Feature::feature);
	public static final RegistryObject<Feature<?>> RUINS_6 = REGISTRY.register("ruins_6", Ruins6Feature::feature);
	public static final RegistryObject<Feature<?>> RUINS_7 = REGISTRY.register("ruins_7", Ruins7Feature::feature);
	public static final RegistryObject<Feature<?>> RUINS_8 = REGISTRY.register("ruins_8", Ruins8Feature::feature);
	public static final RegistryObject<Feature<?>> RUINS_9 = REGISTRY.register("ruins_9", Ruins9Feature::feature);
	public static final RegistryObject<Feature<?>> LAB_RUINS_1 = REGISTRY.register("lab_ruins_1", LabRuins1Feature::feature);
	public static final RegistryObject<Feature<?>> LABRUINS_2 = REGISTRY.register("labruins_2", Labruins2Feature::feature);
	public static final RegistryObject<Feature<?>> LAB_RUINS_3 = REGISTRY.register("lab_ruins_3", LabRuins3Feature::feature);
	public static final RegistryObject<Feature<?>> LAB_RUINS_4 = REGISTRY.register("lab_ruins_4", LabRuins4Feature::feature);
	public static final RegistryObject<Feature<?>> LAB_RUINS_5 = REGISTRY.register("lab_ruins_5", LabRuins5Feature::feature);
	public static final RegistryObject<Feature<?>> LAB_1 = REGISTRY.register("lab_1", Lab1Feature::feature);
	public static final RegistryObject<Feature<?>> RUINS_10 = REGISTRY.register("ruins_10", Ruins10Feature::feature);
	public static final RegistryObject<Feature<?>> RUINS_11 = REGISTRY.register("ruins_11", Ruins11Feature::feature);
	public static final RegistryObject<Feature<?>> RUINS_12 = REGISTRY.register("ruins_12", Ruins12Feature::feature);
	public static final RegistryObject<Feature<?>> FARM_1 = REGISTRY.register("farm_1", Farm1Feature::feature);
	public static final RegistryObject<Feature<?>> FARM_2 = REGISTRY.register("farm_2", Farm2Feature::feature);
	public static final RegistryObject<Feature<?>> TREE_1 = REGISTRY.register("tree_1", Tree1Feature::feature);
	public static final RegistryObject<Feature<?>> TREE_2 = REGISTRY.register("tree_2", Tree2Feature::feature);
	public static final RegistryObject<Feature<?>> LAB_RUINS_6 = REGISTRY.register("lab_ruins_6", LabRuins6Feature::feature);
	public static final RegistryObject<Feature<?>> LIQUID_MONEY_FEATURE = REGISTRY.register("liquid_money_feature", LiquidMoneyFeatureFeature::new);
}
