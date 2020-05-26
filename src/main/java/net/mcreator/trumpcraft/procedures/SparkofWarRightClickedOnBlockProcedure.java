package net.mcreator.trumpcraft.procedures;

import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.World;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.network.play.server.SPlayerAbilitiesPacket;
import net.minecraft.network.play.server.SPlaySoundEventPacket;
import net.minecraft.network.play.server.SPlayEntityEffectPacket;
import net.minecraft.network.play.server.SChangeGameStatePacket;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.trumpcraft.world.dimension.WargroundDimension;
import net.mcreator.trumpcraft.block.WarBlockBlock;
import net.mcreator.trumpcraft.TrumpcraftModElements;

import java.util.Collections;

@TrumpcraftModElements.ModElement.Tag
public class SparkofWarRightClickedOnBlockProcedure extends TrumpcraftModElements.ModElement {
	public SparkofWarRightClickedOnBlockProcedure(TrumpcraftModElements instance) {
		super(instance, 96);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure SparkofWarRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure SparkofWarRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure SparkofWarRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure SparkofWarRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure SparkofWarRightClickedOnBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == WarBlockBlock.block.getDefaultState().getBlock())) {
			if (((entity.dimension.getId()) == 0)) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.ABSORPTION, (int) 15, (int) 50, (false), (false)));
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
						DimensionType destinationType = WargroundDimension.type;
						ObfuscationReflectionHelper.setPrivateValue(ServerPlayerEntity.class, (ServerPlayerEntity) _ent, true, "field_184851_cj");
						ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
						((ServerPlayerEntity) _ent).connection.sendPacket(new SChangeGameStatePacket(4, 0));
						((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(), nextWorld.getSpawnPoint().getY() + 1,
								nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw, _ent.rotationPitch);
						((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
						for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
							((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
						}
						((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
					}
				}
				{
					Entity _ent = entity;
					_ent.setPositionAndUpdate(x, y, z);
					if (_ent instanceof ServerPlayerEntity) {
						((ServerPlayerEntity) _ent).connection.setPlayerLocation(x, y, z, _ent.rotationYaw, _ent.rotationPitch,
								Collections.emptySet());
					}
				}
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("world", world);
					$_dependencies.put("x", (int) (x));
					$_dependencies.put("y", (int) (y));
					$_dependencies.put("z", (int) (z));
					PlaceAirProcedure.executeProcedure($_dependencies);
				}
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), Blocks.AIR.getDefaultState(), 3);
				if (!world.isRemote) {
					Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("trumpcraft", "safezone1"));
					if (template != null) {
						template.addBlocksToWorldChunk(world, new BlockPos((int) (x - 2), (int) y, (int) (z - 2)), new PlacementSettings()
								.setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk((ChunkPos) null).setIgnoreEntities(false));
					}
				}
			} else if (((entity.dimension.getId()) == (WargroundDimension.type.getId()))) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.ABSORPTION, (int) 15, (int) 50, (false), (false)));
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
						DimensionType destinationType = DimensionType.OVERWORLD;
						ObfuscationReflectionHelper.setPrivateValue(ServerPlayerEntity.class, (ServerPlayerEntity) _ent, true, "field_184851_cj");
						ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
						((ServerPlayerEntity) _ent).connection.sendPacket(new SChangeGameStatePacket(4, 0));
						((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(), nextWorld.getSpawnPoint().getY() + 1,
								nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw, _ent.rotationPitch);
						((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
						for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
							((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
						}
						((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
					}
				}
				{
					Entity _ent = entity;
					_ent.setPositionAndUpdate(x, y, z);
					if (_ent instanceof ServerPlayerEntity) {
						((ServerPlayerEntity) _ent).connection.setPlayerLocation(x, y, z, _ent.rotationYaw, _ent.rotationPitch,
								Collections.emptySet());
					}
				}
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("world", world);
					$_dependencies.put("x", (int) (x));
					$_dependencies.put("y", (int) (y));
					$_dependencies.put("z", (int) (z));
					PlaceAirProcedure.executeProcedure($_dependencies);
				}
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), Blocks.AIR.getDefaultState(), 3);
				if (!world.isRemote) {
					Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("trumpcraft", "safezone1"));
					if (template != null) {
						template.addBlocksToWorldChunk(world, new BlockPos((int) (x - 2), (int) y, (int) (z - 2)), new PlacementSettings()
								.setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk((ChunkPos) null).setIgnoreEntities(false));
					}
				}
			}
		}
	}
}
