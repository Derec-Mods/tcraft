
package net.mcreator.trumpcraft.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.trumpcraft.TrumpcraftModElements;

import com.google.common.collect.Multimap;

@TrumpcraftModElements.ModElement.Tag
public class SwissArmyKnifeItem extends TrumpcraftModElements.ModElement {
	@ObjectHolder("trumpcraft:swissarmyknife")
	public static final Item block = null;
	public SwissArmyKnifeItem(TrumpcraftModElements instance) {
		super(instance, 87);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemToolCustom() {
		}.setRegistryName("swissarmyknife"));
	}
	private static class ItemToolCustom extends Item {
		protected ItemToolCustom() {
			super(new Item.Properties().group(ItemGroup.TOOLS).maxDamage(131));
		}

		@Override
		public float getDestroySpeed(ItemStack itemstack, BlockState blockstate) {
			if (blockstate.getBlock() == Blocks.COBWEB.getDefaultState().getBlock())
				return 6f;
			if (blockstate.getBlock() == Blocks.ACACIA_LEAVES.getDefaultState().getBlock())
				return 6f;
			if (blockstate.getBlock() == Blocks.LILY_PAD.getDefaultState().getBlock())
				return 6f;
			if (blockstate.getBlock() == Blocks.VINE.getDefaultState().getBlock())
				return 6f;
			if (blockstate.getBlock() == Blocks.OAK_LEAVES.getDefaultState().getBlock())
				return 6f;
			if (blockstate.getBlock() == Blocks.SPRUCE_LEAVES.getDefaultState().getBlock())
				return 6f;
			if (blockstate.getBlock() == Blocks.BIRCH_LEAVES.getDefaultState().getBlock())
				return 6f;
			if (blockstate.getBlock() == Blocks.JUNGLE_LEAVES.getDefaultState().getBlock())
				return 6f;
			if (blockstate.getBlock() == Blocks.ACACIA_LEAVES.getDefaultState().getBlock())
				return 6f;
			if (blockstate.getBlock() == Blocks.ACACIA_LEAVES.getDefaultState().getBlock())
				return 6f;
			if (blockstate.getBlock() == Blocks.DARK_OAK_LEAVES.getDefaultState().getBlock())
				return 6f;
			if (blockstate.getBlock() == Blocks.GRASS.getDefaultState().getBlock())
				return 6f;
			return 0;
		}

		@Override
		public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
			stack.damageItem(1, entityLiving, i -> i.sendBreakAnimation(EquipmentSlotType.MAINHAND));
			return true;
		}

		@Override
		public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
			stack.damageItem(2, attacker, i -> i.sendBreakAnimation(EquipmentSlotType.MAINHAND));
			return true;
		}

		@Override
		public int getItemEnchantability() {
			return 5;
		}

		@Override
		public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
			Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(equipmentSlot);
			if (equipmentSlot == EquipmentSlotType.MAINHAND) {
				multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(),
						new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Tool modifier", 5f, AttributeModifier.Operation.ADDITION));
				multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(),
						new AttributeModifier(ATTACK_SPEED_MODIFIER, "Tool modifier", -1.2, AttributeModifier.Operation.ADDITION));
			}
			return multimap;
		}
	}
}
