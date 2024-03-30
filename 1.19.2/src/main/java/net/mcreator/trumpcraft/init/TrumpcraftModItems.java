
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.trumpcraft.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.trumpcraft.item.WallMariaAudioRecordingItem;
import net.mcreator.trumpcraft.item.WallMariaAudioRecording2Item;
import net.mcreator.trumpcraft.item.TrumpsquadarmorItem;
import net.mcreator.trumpcraft.item.TrumpNadeItem;
import net.mcreator.trumpcraft.item.SwissArmyKnifeItem;
import net.mcreator.trumpcraft.item.SparkofWarItem;
import net.mcreator.trumpcraft.item.RocketItem;
import net.mcreator.trumpcraft.item.RealIntroUnlockItem;
import net.mcreator.trumpcraft.item.PistolItem;
import net.mcreator.trumpcraft.item.MoneypackPickaxeItem;
import net.mcreator.trumpcraft.item.MoneySwordItem;
import net.mcreator.trumpcraft.item.MoneyItem;
import net.mcreator.trumpcraft.item.MoneyCutterItem;
import net.mcreator.trumpcraft.item.MURICAItem;
import net.mcreator.trumpcraft.item.MAGAShotgunItem;
import net.mcreator.trumpcraft.item.M57PilumItem;
import net.mcreator.trumpcraft.item.HexSquadArmorItem;
import net.mcreator.trumpcraft.item.HexSpecalistArmorItem;
import net.mcreator.trumpcraft.item.HexSoldierPledgeItem;
import net.mcreator.trumpcraft.item.HexBeforeAttack1Item;
import net.mcreator.trumpcraft.item.BurgerItem;
import net.mcreator.trumpcraft.item.BulletItem;
import net.mcreator.trumpcraft.item.AntiTrumpToolItem;
import net.mcreator.trumpcraft.item.AWPItem;
import net.mcreator.trumpcraft.TrumpcraftMod;

public class TrumpcraftModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, TrumpcraftMod.MODID);
	public static final RegistryObject<Item> TRUMPWANNABE_SPAWN_EGG = REGISTRY.register("trumpwannabe_spawn_egg",
			() -> new ForgeSpawnEggItem(TrumpcraftModEntities.TRUMPWANNABE, -985254, -8808709, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> CONVERTER = block(TrumpcraftModBlocks.CONVERTER, CreativeModeTab.TAB_MISC);
	public static final RegistryObject<Item> MONEY = REGISTRY.register("money", () -> new MoneyItem());
	public static final RegistryObject<Item> MONEY_BLOCK = block(TrumpcraftModBlocks.MONEY_BLOCK, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> WAR_BLOCK = block(TrumpcraftModBlocks.WAR_BLOCK, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> MONEY_FENCE = block(TrumpcraftModBlocks.MONEY_FENCE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> MONEY_SLAB = block(TrumpcraftModBlocks.MONEY_SLAB, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> MONEY_WALL = block(TrumpcraftModBlocks.MONEY_WALL, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> MONEY_STAIRS = block(TrumpcraftModBlocks.MONEY_STAIRS, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> MONEYPACK_PICKAXE = REGISTRY.register("moneypack_pickaxe", () -> new MoneypackPickaxeItem());
	public static final RegistryObject<Item> SWISS_ARMY_KNIFE = REGISTRY.register("swiss_army_knife", () -> new SwissArmyKnifeItem());
	public static final RegistryObject<Item> MONEY_CUTTER = REGISTRY.register("money_cutter", () -> new MoneyCutterItem());
	public static final RegistryObject<Item> ANTI_TRUMP_TOOL = REGISTRY.register("anti_trump_tool", () -> new AntiTrumpToolItem());
	public static final RegistryObject<Item> SPARKOF_WAR = REGISTRY.register("sparkof_war", () -> new SparkofWarItem());
	public static final RegistryObject<Item> MURICA = REGISTRY.register("murica", () -> new MURICAItem());
	public static final RegistryObject<Item> MONEY_SWORD = REGISTRY.register("money_sword", () -> new MoneySwordItem());
	public static final RegistryObject<Item> BULLET = REGISTRY.register("bullet", () -> new BulletItem());
	public static final RegistryObject<Item> ROCKET = REGISTRY.register("rocket", () -> new RocketItem());
	public static final RegistryObject<Item> PISTOL = REGISTRY.register("pistol", () -> new PistolItem());
	public static final RegistryObject<Item> AWP = REGISTRY.register("awp", () -> new AWPItem());
	public static final RegistryObject<Item> M_57_PILUM = REGISTRY.register("m_57_pilum", () -> new M57PilumItem());
	public static final RegistryObject<Item> MAGA_SHOTGUN = REGISTRY.register("maga_shotgun", () -> new MAGAShotgunItem());
	public static final RegistryObject<Item> TRUMP_NADE = REGISTRY.register("trump_nade", () -> new TrumpNadeItem());
	public static final RegistryObject<Item> TRUMPSQUADARMOR_HELMET = REGISTRY.register("trumpsquadarmor_helmet", () -> new TrumpsquadarmorItem.Helmet());
	public static final RegistryObject<Item> TRUMPSQUADARMOR_CHESTPLATE = REGISTRY.register("trumpsquadarmor_chestplate", () -> new TrumpsquadarmorItem.Chestplate());
	public static final RegistryObject<Item> TRUMPSQUADARMOR_LEGGINGS = REGISTRY.register("trumpsquadarmor_leggings", () -> new TrumpsquadarmorItem.Leggings());
	public static final RegistryObject<Item> TRUMPSQUADARMOR_BOOTS = REGISTRY.register("trumpsquadarmor_boots", () -> new TrumpsquadarmorItem.Boots());
	public static final RegistryObject<Item> HEX_SQUAD_ARMOR_HELMET = REGISTRY.register("hex_squad_armor_helmet", () -> new HexSquadArmorItem.Helmet());
	public static final RegistryObject<Item> HEX_SQUAD_ARMOR_CHESTPLATE = REGISTRY.register("hex_squad_armor_chestplate", () -> new HexSquadArmorItem.Chestplate());
	public static final RegistryObject<Item> HEX_SQUAD_ARMOR_LEGGINGS = REGISTRY.register("hex_squad_armor_leggings", () -> new HexSquadArmorItem.Leggings());
	public static final RegistryObject<Item> HEX_SQUAD_ARMOR_BOOTS = REGISTRY.register("hex_squad_armor_boots", () -> new HexSquadArmorItem.Boots());
	public static final RegistryObject<Item> HEX_SPECALIST_ARMOR_HELMET = REGISTRY.register("hex_specalist_armor_helmet", () -> new HexSpecalistArmorItem.Helmet());
	public static final RegistryObject<Item> HEX_SPECALIST_ARMOR_CHESTPLATE = REGISTRY.register("hex_specalist_armor_chestplate", () -> new HexSpecalistArmorItem.Chestplate());
	public static final RegistryObject<Item> HEX_SPECALIST_ARMOR_LEGGINGS = REGISTRY.register("hex_specalist_armor_leggings", () -> new HexSpecalistArmorItem.Leggings());
	public static final RegistryObject<Item> HEX_SPECALIST_ARMOR_BOOTS = REGISTRY.register("hex_specalist_armor_boots", () -> new HexSpecalistArmorItem.Boots());
	public static final RegistryObject<Item> WALL_MARIA_AUDIO_RECORDING = REGISTRY.register("wall_maria_audio_recording", () -> new WallMariaAudioRecordingItem());
	public static final RegistryObject<Item> WALL_MARIA_AUDIO_RECORDING_2 = REGISTRY.register("wall_maria_audio_recording_2", () -> new WallMariaAudioRecording2Item());
	public static final RegistryObject<Item> REAL_INTRO_UNLOCK = REGISTRY.register("real_intro_unlock", () -> new RealIntroUnlockItem());
	public static final RegistryObject<Item> HEX_SOLDIER_PLEDGE = REGISTRY.register("hex_soldier_pledge", () -> new HexSoldierPledgeItem());
	public static final RegistryObject<Item> HEX_BEFORE_ATTACK_1 = REGISTRY.register("hex_before_attack_1", () -> new HexBeforeAttack1Item());
	public static final RegistryObject<Item> MONEY_TRAP_DOOR = block(TrumpcraftModBlocks.MONEY_TRAP_DOOR, CreativeModeTab.TAB_REDSTONE);
	public static final RegistryObject<Item> MONEY_CHAIR = block(TrumpcraftModBlocks.MONEY_CHAIR, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> TRUMP_SOLDIER_SPAWN_EGG = REGISTRY.register("trump_soldier_spawn_egg",
			() -> new ForgeSpawnEggItem(TrumpcraftModEntities.TRUMP_SOLDIER, -16777216, -16722247, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> THANKYOURANDOMCITIZEN_SPAWN_EGG = REGISTRY.register("thankyourandomcitizen_spawn_egg",
			() -> new ForgeSpawnEggItem(TrumpcraftModEntities.THANKYOURANDOMCITIZEN, -4619758, -16619690, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> FRAGMENTOF_WALL_BLOCK = block(TrumpcraftModBlocks.FRAGMENTOF_WALL_BLOCK, null);
	public static final RegistryObject<Item> LIVING_BOMB_SPAWN_EGG = REGISTRY.register("living_bomb_spawn_egg", () -> new ForgeSpawnEggItem(TrumpcraftModEntities.LIVING_BOMB, -65536, -1, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> TRUMP_SCOUT_SPAWN_EGG = REGISTRY.register("trump_scout_spawn_egg", () -> new ForgeSpawnEggItem(TrumpcraftModEntities.TRUMP_SCOUT, -8909812, -16101757, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> BURGER = REGISTRY.register("burger", () -> new BurgerItem());

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
