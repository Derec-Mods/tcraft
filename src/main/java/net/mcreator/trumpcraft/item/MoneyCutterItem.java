
package net.mcreator.trumpcraft.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

import net.mcreator.trumpcraft.block.MoneyBlockBlock;
import net.mcreator.trumpcraft.TrumpcraftModElements;

@TrumpcraftModElements.ModElement.Tag
public class MoneyCutterItem extends TrumpcraftModElements.ModElement {
	@ObjectHolder("trumpcraft:moneycutter")
	public static final Item block = null;
	public MoneyCutterItem(TrumpcraftModElements instance) {
		super(instance, 60);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 150;
			}

			public float getEfficiency() {
				return 9f;
			}

			public float getAttackDamage() {
				return 3f;
			}

			public int getHarvestLevel() {
				return 3;
			}

			public int getEnchantability() {
				return 5;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(MoneyItem.block, (int) (1)), new ItemStack(MoneyBlockBlock.block, (int) (1)),
						new ItemStack(MoneyCutterItem.block, (int) (1)));
			}
		}, 1, -1.2f, new Item.Properties().group(ItemGroup.TOOLS)) {
		}.setRegistryName("moneycutter"));
	}
}
