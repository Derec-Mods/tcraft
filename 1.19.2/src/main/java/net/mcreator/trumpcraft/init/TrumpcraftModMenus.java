
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.trumpcraft.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.trumpcraft.world.inventory.WallMariaPart2GUIMenu;
import net.mcreator.trumpcraft.world.inventory.TrumpBook1Menu;
import net.mcreator.trumpcraft.world.inventory.TableOfContents1Menu;
import net.mcreator.trumpcraft.world.inventory.StatsMenu;
import net.mcreator.trumpcraft.world.inventory.RealPageOneMenu;
import net.mcreator.trumpcraft.world.inventory.Page2Menu;
import net.mcreator.trumpcraft.world.inventory.HexPledgeMenu;
import net.mcreator.trumpcraft.world.inventory.ConverterGUIMenu;
import net.mcreator.trumpcraft.TrumpcraftMod;

public class TrumpcraftModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, TrumpcraftMod.MODID);
	public static final RegistryObject<MenuType<StatsMenu>> STATS = REGISTRY.register("stats", () -> IForgeMenuType.create(StatsMenu::new));
	public static final RegistryObject<MenuType<ConverterGUIMenu>> CONVERTER_GUI = REGISTRY.register("converter_gui", () -> IForgeMenuType.create(ConverterGUIMenu::new));
	public static final RegistryObject<MenuType<RealPageOneMenu>> REAL_PAGE_ONE = REGISTRY.register("real_page_one", () -> IForgeMenuType.create(RealPageOneMenu::new));
	public static final RegistryObject<MenuType<TrumpBook1Menu>> TRUMP_BOOK_1 = REGISTRY.register("trump_book_1", () -> IForgeMenuType.create(TrumpBook1Menu::new));
	public static final RegistryObject<MenuType<TableOfContents1Menu>> TABLE_OF_CONTENTS_1 = REGISTRY.register("table_of_contents_1", () -> IForgeMenuType.create(TableOfContents1Menu::new));
	public static final RegistryObject<MenuType<Page2Menu>> PAGE_2 = REGISTRY.register("page_2", () -> IForgeMenuType.create(Page2Menu::new));
	public static final RegistryObject<MenuType<WallMariaPart2GUIMenu>> WALL_MARIA_PART_2_GUI = REGISTRY.register("wall_maria_part_2_gui", () -> IForgeMenuType.create(WallMariaPart2GUIMenu::new));
	public static final RegistryObject<MenuType<HexPledgeMenu>> HEX_PLEDGE = REGISTRY.register("hex_pledge", () -> IForgeMenuType.create(HexPledgeMenu::new));
}
