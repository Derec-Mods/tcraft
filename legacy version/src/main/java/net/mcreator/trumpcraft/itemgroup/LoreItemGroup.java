
package net.mcreator.trumpcraft.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.trumpcraft.item.RealIntroUnlockItem;
import net.mcreator.trumpcraft.TrumpcraftModElements;

@TrumpcraftModElements.ModElement.Tag
public class LoreItemGroup extends TrumpcraftModElements.ModElement {
	public LoreItemGroup(TrumpcraftModElements instance) {
		super(instance, 122);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tablore") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(RealIntroUnlockItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
