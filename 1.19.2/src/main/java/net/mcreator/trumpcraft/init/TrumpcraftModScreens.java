
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.trumpcraft.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.trumpcraft.client.gui.WallMariaPart2GUIScreen;
import net.mcreator.trumpcraft.client.gui.TrumpBook1Screen;
import net.mcreator.trumpcraft.client.gui.TableOfContents1Screen;
import net.mcreator.trumpcraft.client.gui.StatsScreen;
import net.mcreator.trumpcraft.client.gui.RealPageOneScreen;
import net.mcreator.trumpcraft.client.gui.Page2Screen;
import net.mcreator.trumpcraft.client.gui.HexPledgeScreen;
import net.mcreator.trumpcraft.client.gui.ConverterGUIScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TrumpcraftModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(TrumpcraftModMenus.STATS.get(), StatsScreen::new);
			MenuScreens.register(TrumpcraftModMenus.CONVERTER_GUI.get(), ConverterGUIScreen::new);
			MenuScreens.register(TrumpcraftModMenus.REAL_PAGE_ONE.get(), RealPageOneScreen::new);
			MenuScreens.register(TrumpcraftModMenus.TRUMP_BOOK_1.get(), TrumpBook1Screen::new);
			MenuScreens.register(TrumpcraftModMenus.TABLE_OF_CONTENTS_1.get(), TableOfContents1Screen::new);
			MenuScreens.register(TrumpcraftModMenus.PAGE_2.get(), Page2Screen::new);
			MenuScreens.register(TrumpcraftModMenus.WALL_MARIA_PART_2_GUI.get(), WallMariaPart2GUIScreen::new);
			MenuScreens.register(TrumpcraftModMenus.HEX_PLEDGE.get(), HexPledgeScreen::new);
		});
	}
}
