
package net.mcreator.trumpcraft.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.AxeItem;

import net.mcreator.trumpcraft.init.TrumpcraftModItems;
import net.mcreator.trumpcraft.init.TrumpcraftModBlocks;

public class MoneyCutterItem extends AxeItem {
	public MoneyCutterItem() {
		super(new Tier() {
			public int getUses() {
				return 150;
			}

			public float getSpeed() {
				return 9f;
			}

			public float getAttackDamageBonus() {
				return 3f;
			}

			public int getLevel() {
				return 3;
			}

			public int getEnchantmentValue() {
				return 5;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(TrumpcraftModItems.MONEY.get()), new ItemStack(TrumpcraftModBlocks.MONEY_BLOCK.get()), new ItemStack(TrumpcraftModItems.MONEY_CUTTER.get()));
			}
		}, 1, -1.2f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS));
	}
}
