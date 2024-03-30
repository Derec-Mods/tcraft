
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.trumpcraft.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.trumpcraft.TrumpcraftMod;

public class TrumpcraftModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, TrumpcraftMod.MODID);
	public static final RegistryObject<SoundEvent> AWP = REGISTRY.register("awp", () -> new SoundEvent(new ResourceLocation("trumpcraft", "awp")));
	public static final RegistryObject<SoundEvent> MAGASHOTGUN = REGISTRY.register("magashotgun", () -> new SoundEvent(new ResourceLocation("trumpcraft", "magashotgun")));
	public static final RegistryObject<SoundEvent> ARMOREDDEATH = REGISTRY.register("armoreddeath", () -> new SoundEvent(new ResourceLocation("trumpcraft", "armoreddeath")));
	public static final RegistryObject<SoundEvent> HAIL = REGISTRY.register("hail", () -> new SoundEvent(new ResourceLocation("trumpcraft", "hail")));
	public static final RegistryObject<SoundEvent> PILUMLAUNCH = REGISTRY.register("pilumlaunch", () -> new SoundEvent(new ResourceLocation("trumpcraft", "pilumlaunch")));
	public static final RegistryObject<SoundEvent> THEEVADEATH = REGISTRY.register("theevadeath", () -> new SoundEvent(new ResourceLocation("trumpcraft", "theevadeath")));
	public static final RegistryObject<SoundEvent> ATTATTACK = REGISTRY.register("attattack", () -> new SoundEvent(new ResourceLocation("trumpcraft", "attattack")));
}
