
package net.mcreator.trumpcraft.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.trumpcraft.block.MoneyBlockBlock;
import net.mcreator.trumpcraft.TrumpcraftModElements;

@TrumpcraftModElements.ModElement.Tag
public class MoneySwordItem extends TrumpcraftModElements.ModElement {
	@ObjectHolder("trumpcraft:moneysword")
	public static final Item block = null;
	public MoneySwordItem(TrumpcraftModElements instance) {
		super(instance, 99);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 42;
			}

			public float getEfficiency() {
				return 6.5f;
			}

			public float getAttackDamage() {
				return 2.5f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 10;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(MoneyItem.block, (int) (1)), new ItemStack(MoneyBlockBlock.block, (int) (1)));
			}
		}, 3, -1.2f, new Item.Properties().group(ItemGroup.COMBAT)) {
		}.setRegistryName("moneysword"));
	}
}
