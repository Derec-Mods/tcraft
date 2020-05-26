
package net.mcreator.trumpcraft.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.mcreator.trumpcraft.procedures.HexSoldierPledgeRightClickProcedure;
import net.mcreator.trumpcraft.itemgroup.LoreItemGroup;
import net.mcreator.trumpcraft.TrumpcraftModElements;

import java.util.List;

@TrumpcraftModElements.ModElement.Tag
public class HexSoldierPledgeItem extends TrumpcraftModElements.ModElement {
	@ObjectHolder("trumpcraft:hexsoldierpledge")
	public static final Item block = null;
	public HexSoldierPledgeItem(TrumpcraftModElements instance) {
		super(instance, 126);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(LoreItemGroup.tab).maxStackSize(1));
			setRegistryName("hexsoldierpledge");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Shinzou wo sasageyo!"));
		}

		@Override
		public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
			ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
			ItemStack itemstack = ar.getResult();
			int x = (int) entity.getPosX();
			int y = (int) entity.getPosY();
			int z = (int) entity.getPosZ();
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("world", world);
				HexSoldierPledgeRightClickProcedure.executeProcedure($_dependencies);
			}
			return ar;
		}
	}
}
