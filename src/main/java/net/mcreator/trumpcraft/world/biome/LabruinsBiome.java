
package net.mcreator.trumpcraft.world.biome;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.BiomeDictionary;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.feature.TwoFeatureChoiceConfig;
import net.minecraft.world.gen.feature.SphereReplaceConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.entity.EntityClassification;
import net.minecraft.block.Blocks;

import net.mcreator.trumpcraft.entity.TestSubjectEntity;
import net.mcreator.trumpcraft.entity.TestSubject4Entity;
import net.mcreator.trumpcraft.entity.TestSubject3Entity;
import net.mcreator.trumpcraft.entity.TestSubject1Entity;
import net.mcreator.trumpcraft.TrumpcraftModElements;

import com.google.common.collect.Lists;

@TrumpcraftModElements.ModElement.Tag
public class LabruinsBiome extends TrumpcraftModElements.ModElement {
	@ObjectHolder("trumpcraft:labruins")
	public static final CustomBiome biome = null;
	public LabruinsBiome(TrumpcraftModElements instance) {
		super(instance, 93);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new CustomBiome());
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.COLD, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.RARE);
	}
	static class CustomBiome extends Biome {
		public CustomBiome() {
			super(new Biome.Builder().downfall(0.5f).depth(0.1f).scale(0.2f).temperature(0.5f).precipitation(Biome.RainType.RAIN)
					.category(Biome.Category.NONE).waterColor(4159204).waterFogColor(329011)
					.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.STONE.getDefaultState(), Blocks.STONE.getDefaultState(),
							Blocks.STONE.getDefaultState())));
			setRegistryName("labruins");
			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addStructures(this);
			DefaultBiomeFeatures.addMonsterRooms(this);
			DefaultBiomeFeatures.addOres(this);
			DefaultBiomeFeatures.addLakes(this);
			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.GRASS_CONFIG)
					.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(3))));
			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
					Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.BROWN_MUSHROOM_CONFIG)
							.withPlacement(Placement.CHANCE_HEIGHTMAP_DOUBLE.configure(new ChanceConfig(1))));
			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.RED_MUSHROOM_CONFIG)
					.withPlacement(Placement.CHANCE_HEIGHTMAP_DOUBLE.configure(new ChanceConfig(1))));
			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_BOOLEAN_SELECTOR
					.withConfiguration(new TwoFeatureChoiceConfig(Feature.HUGE_RED_MUSHROOM.withConfiguration(DefaultBiomeFeatures.BIG_RED_MUSHROOM),
							Feature.HUGE_BROWN_MUSHROOM.withConfiguration(DefaultBiomeFeatures.BIG_BROWN_MUSHROOM)))
					.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.CACTUS_CONFIG)
					.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
			addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.DISK
							.withConfiguration(new SphereReplaceConfig(Blocks.SAND.getDefaultState(), 7, 2,
									Lists.newArrayList(Blocks.STONE.getDefaultState(), Blocks.STONE.getDefaultState())))
							.withPlacement(Placement.COUNT_TOP_SOLID.configure(new FrequencyConfig(1))));
			addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.DISK
							.withConfiguration(new SphereReplaceConfig(Blocks.GRAVEL.getDefaultState(), 6, 2,
									Lists.newArrayList(Blocks.STONE.getDefaultState(), Blocks.STONE.getDefaultState())))
							.withPlacement(Placement.COUNT_TOP_SOLID.configure(new FrequencyConfig(1))));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(TestSubject1Entity.entity, 15, 1, 5));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(TestSubjectEntity.entity, 15, 1, 5));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(TestSubject3Entity.entity, 15, 1, 5));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(TestSubject4Entity.entity, 15, 1, 5));
		}
	}
}
