package net.mcreator.trumpcraft.procedures;

import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.network.play.server.SPlayerAbilitiesPacket;
import net.minecraft.network.play.server.SPlaySoundEventPacket;
import net.minecraft.network.play.server.SPlayEntityEffectPacket;
import net.minecraft.network.play.server.SChangeGameStatePacket;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.trumpcraft.world.dimension.WargroundDimension;
import net.mcreator.trumpcraft.block.WarBlockBlock;
import net.mcreator.trumpcraft.TrumpcraftModElements;

import java.util.Random;
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
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure SparkofWarRightClickedOnBlock!");
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
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
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
				entity.getPersistentData().putBoolean("JustTeleportedToID", (true));
				{
					ItemStack _ist = (itemstack);
					if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
						_ist.shrink(1);
						_ist.setDamage(0);
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
				entity.getPersistentData().putBoolean("JustTeleportedToID", (true));
				{
					ItemStack _ist = (itemstack);
					if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
						_ist.shrink(1);
						_ist.setDamage(0);
					}
				}
			}
		}
	}
}
