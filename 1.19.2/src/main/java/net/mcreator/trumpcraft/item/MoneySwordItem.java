
package net.mcreator.trumpcraft.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

import net.mcreator.trumpcraft.init.TrumpcraftModItems;
import net.mcreator.trumpcraft.init.TrumpcraftModBlocks;

public class MoneySwordItem extends SwordItem {
	public MoneySwordItem() {
		super(new Tier() {
			public int getUses() {
				return 42;
			}

			public float getSpeed() {
				return 6.5f;
			}

			public float getAttackDamageBonus() {
				return 2.5f;
			}

			public int getLevel() {
				return 1;
			}

			public int getEnchantmentValue() {
				return 10;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(TrumpcraftModItems.MONEY.get()), new ItemStack(TrumpcraftModBlocks.MONEY_BLOCK.get()));
			}
		}, 3, -1.2f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));
	}
}
