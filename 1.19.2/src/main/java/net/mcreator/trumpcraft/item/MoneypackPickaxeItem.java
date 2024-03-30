
package net.mcreator.trumpcraft.item;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.core.BlockPos;

import net.mcreator.trumpcraft.procedures.MoneypackPickaxeBlockDestroyedWithToolProcedure;
import net.mcreator.trumpcraft.init.TrumpcraftModItems;
import net.mcreator.trumpcraft.init.TrumpcraftModBlocks;

public class MoneypackPickaxeItem extends PickaxeItem {
	public MoneypackPickaxeItem() {
		super(new Tier() {
			public int getUses() {
				return 300;
			}

			public float getSpeed() {
				return 6f;
			}

			public float getAttackDamageBonus() {
				return 1f;
			}

			public int getLevel() {
				return 2;
			}

			public int getEnchantmentValue() {
				return 14;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(TrumpcraftModItems.MONEY.get()), new ItemStack(TrumpcraftModBlocks.MONEY_BLOCK.get()));
			}
		}, 1, -3f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS));
	}

	@Override
	public boolean mineBlock(ItemStack itemstack, Level world, BlockState blockstate, BlockPos pos, LivingEntity entity) {
		boolean retval = super.mineBlock(itemstack, world, blockstate, pos, entity);
		MoneypackPickaxeBlockDestroyedWithToolProcedure.execute(entity);
		return retval;
	}
}
