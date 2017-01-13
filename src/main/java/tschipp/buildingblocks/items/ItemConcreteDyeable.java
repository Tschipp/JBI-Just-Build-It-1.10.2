package tschipp.buildingblocks.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemConcreteDyeable extends ItemBlock{

	public ItemConcreteDyeable(Block block)
	{
		super(block);
	}

	@SideOnly(Side.CLIENT)
	public static class Color implements IItemColor {


		@Override
		public int getColorFromItemstack(ItemStack stack, int tintIndex)
		{
			if (stack.getTagCompound() != null)
			{
				int color = stack.getTagCompound().getInteger("color");
				return color;
			} else
			{
				return 16777215;
			}

		}

	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tab, List<ItemStack> subItems)
	{
		NBTTagCompound tag = new NBTTagCompound();
		tag.setInteger("color", 16777215);
		ItemStack stack = new ItemStack(item, 1, 0);
		stack.setTagCompound(tag);
		subItems.add(stack);
	}

	@Override
	public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, IBlockState newState)
	{
		if (!world.setBlockState(pos, newState, 3))
			return false;

		IBlockState state = world.getBlockState(pos);
		if (state.getBlock() == this.block)
		{

			this.block.onBlockPlacedBy(world, pos, state, player, stack);
		}

		return true;
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
	{
		if (stack.getTagCompound() != null && stack.getTagCompound().hasKey("color"))
		{
			tooltip.add("Dyeable in a Crafting Table like Leather Armor");
		} else
		{
			tooltip.add(TextFormatting.RED + "Do not use this block, can cause crashes");
		}
	}

	@Override
	public String getItemStackDisplayName(ItemStack stack)
	{

		if (stack.getTagCompound() != null && stack.getTagCompound().hasKey("color"))
		{
			String color = Integer.toHexString(stack.getTagCompound().getInteger("color")).toUpperCase();
			return "Dyed Concrete (Color: " + color + ")";
		} else
		{
			return super.getItemStackDisplayName(stack);
		}
	}

	public boolean hasColor(ItemStack stack)
	{
		return true;
	}

	public int getColor(ItemStack stack)
	{
		if (stack.getTagCompound() != null && stack.getTagCompound().hasKey("color"))
		{
			if (stack.getTagCompound().getInteger("color") == 16777215)
			{
				return 0;
			} else
			{
				return stack.getTagCompound().getInteger("color");
			}
		} else
		{
			return 0;
		}

	}

	public void setColor(ItemStack stack, int color)
	{
		NBTTagCompound tag = stack.getTagCompound();
		tag.setInteger("color", color);
	}

}
