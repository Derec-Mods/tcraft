
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.trumpcraft.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class TrumpcraftModTabs {
	public static CreativeModeTab TAB_LORE;

	public static void load() {
		TAB_LORE = new CreativeModeTab("tablore") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(TrumpcraftModItems.REAL_INTRO_UNLOCK.get());
			}

			@Override
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
	}
}
