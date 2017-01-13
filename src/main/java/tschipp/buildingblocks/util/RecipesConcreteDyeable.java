package tschipp.buildingblocks.util;

import java.util.List;

import javax.annotation.Nullable;

import tschipp.buildingblocks.blocks.BBBlocks;
import tschipp.buildingblocks.items.ItemConcreteDyeable;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.tileentity.TileEntityBanner;
import net.minecraft.world.World;

import com.google.common.collect.Lists;

public class RecipesConcreteDyeable implements IRecipe {
	/**
	 * Used to check if a recipe matches current crafting inventory
	 */
	public boolean matches(InventoryCrafting inv, World worldIn)
	{
		ItemStack itemstack = null;
		List<ItemStack> list = Lists.<ItemStack> newArrayList();

		for (int i = 0; i < inv.getSizeInventory(); ++i)
		{
			ItemStack itemstack1 = inv.getStackInSlot(i);

			if (itemstack1 != null)
			{
				if (itemstack1.getItem() instanceof ItemConcreteDyeable)
				{

					if (itemstack != null)
					{
						return false;
					}

					itemstack = itemstack1;
				} else
				{
					if (itemstack1.getItem() != Items.DYE)
					{
						return false;
					}

					list.add(itemstack1);
				}
			}
		}

		return itemstack != null && !list.isEmpty();
	}

	/**
	 * Returns an Item that is the result of this recipe
	 */
	@Nullable
	public ItemStack getCraftingResult(InventoryCrafting inv)
	{
		ItemStack itemstack = null;
		int[] aint = new int[3];
		int i = 0;
		int j = 0;
		ItemConcreteDyeable itemconcrete = null;

		for (int k = 0; k < inv.getSizeInventory(); ++k)
		{
			ItemStack itemstack1 = inv.getStackInSlot(k);

			if (itemstack1 != null)
			{
				if (itemstack1.getItem() instanceof ItemConcreteDyeable)
				{
					itemconcrete = (ItemConcreteDyeable) itemstack1.getItem();

					if (itemstack != null)
					{
						return null;
					}

					itemstack = itemstack1.copy();
					itemstack.stackSize = 1;

					if (itemconcrete.hasColor(itemstack1))
					{
						int l = itemconcrete.getColor(itemstack);
						float f = (float) (l >> 16 & 255) / 255.0F;
						float f1 = (float) (l >> 8 & 255) / 255.0F;
						float f2 = (float) (l & 255) / 255.0F;
						i = (int) ((float) i + Math.max(f, Math.max(f1, f2)) * 255.0F);
						aint[0] = (int) ((float) aint[0] + f * 255.0F);
						aint[1] = (int) ((float) aint[1] + f1 * 255.0F);
						aint[2] = (int) ((float) aint[2] + f2 * 255.0F);
						++j;
					}
				} else
				{
					if (itemstack1.getItem() != Items.DYE)
					{
						return null;
					}

					float[] afloat = EntitySheep.getDyeRgb(EnumDyeColor.byDyeDamage(itemstack1.getMetadata()));
					int l1 = (int) (afloat[0] * 255.0F);
					int i2 = (int) (afloat[1] * 255.0F);
					int j2 = (int) (afloat[2] * 255.0F);
					i += Math.max(l1, Math.max(i2, j2));
					aint[0] += l1;
					aint[1] += i2;
					aint[2] += j2;
					++j;
				}
			}
		}

		if (itemconcrete == null)
		{
			return null;
		} else
		{
			int i1 = aint[0] / j;
			int j1 = aint[1] / j;
			int k1 = aint[2] / j;
			float f3 = (float) i / (float) j;
			float f4 = (float) Math.max(i1, Math.max(j1, k1));
			i1 = (int) ((float) i1 * f3 / f4);
			j1 = (int) ((float) j1 * f3 / f4);
			k1 = (int) ((float) k1 * f3 / f4);
			int lvt_12_3_ = (i1 << 8) + j1;
			lvt_12_3_ = (lvt_12_3_ << 8) + k1;
			itemconcrete.setColor(itemstack, lvt_12_3_);
			return itemstack;
		}
	}

	/**
	 * Returns the size of the recipe area
	 */
	public int getRecipeSize()
	{
		return 10;
	}

	@Nullable
	public ItemStack getRecipeOutput()
	{
		return null;
	}

	public ItemStack[] getRemainingItems(InventoryCrafting inv)
	{
		ItemStack[] aitemstack = new ItemStack[inv.getSizeInventory()];

		for (int i = 0; i < aitemstack.length; ++i)
		{
			ItemStack itemstack = inv.getStackInSlot(i);
			aitemstack[i] = net.minecraftforge.common.ForgeHooks.getContainerItem(itemstack);
		}

		return aitemstack;
	}

	public static class RecipeDuplicateConcrete implements IRecipe {

		/**
		 * Used to check if a recipe matches current crafting inventory
		 */
		public boolean matches(InventoryCrafting inv, World worldIn)
		{
			ItemStack coloredconcrete = null;
			ItemStack whiteconcrete = null;
			ItemStack excesswhite = null;
			ItemStack excesscolor = null;

			for (int i = 0; i < inv.getSizeInventory(); ++i)
			{

				ItemStack currentstack = inv.getStackInSlot(i);

				if (currentstack != null)
				{
					if (currentstack.getItem() != Item.getItemFromBlock(BBBlocks.concreteDyeable))

					{
						return false;
					}

					if (currentstack.getTagCompound().hasKey("color"))
					{

						if (currentstack.getTagCompound().getInteger("color") == 16777215)
						{
							if (whiteconcrete == null)
							{
								whiteconcrete = currentstack;
							} else
							{
								excesswhite = currentstack;
							}

						} else
						{
							if (coloredconcrete == null)
							{
								coloredconcrete = currentstack;
							} else
							{
								excesscolor = currentstack;
							}
						}
					}
				}
			}

			return coloredconcrete != null && whiteconcrete != null && excesswhite == null && excesscolor == null;
		}

		/**
		 * Returns an Item that is the result of this recipe
		 */
		@Nullable
		public ItemStack getCraftingResult(InventoryCrafting inv)
		{
			for (int i = 0; i < inv.getSizeInventory(); ++i)
			{
				ItemStack itemstack = inv.getStackInSlot(i);

				if (itemstack != null)
				{
					if (itemstack.getTagCompound().getInteger("color") == 16777215)
					{

					} else
					{
						ItemStack output = itemstack.copy();
						output.stackSize = 1;
						return output;
					}

				}
			}

			return null;
		}

		/**
		 * Returns the size of the recipe area
		 */
		public int getRecipeSize()
		{
			return 2;
		}

		@Nullable
		public ItemStack getRecipeOutput()
		{
			return null;
		}

		public ItemStack[] getRemainingItems(InventoryCrafting inv)
		{
			ItemStack[] aitemstack = new ItemStack[inv.getSizeInventory()];

			for (int i = 0; i < aitemstack.length; ++i)
			{
				ItemStack itemstack = inv.getStackInSlot(i);

				if (itemstack != null)
				{

					if (itemstack.getTagCompound().getInteger("color") != 16777215)
					{
						aitemstack[i] = itemstack.copy();
						aitemstack[i].stackSize = 1;
					}
				}
			}

			return aitemstack;
		}
	}
}