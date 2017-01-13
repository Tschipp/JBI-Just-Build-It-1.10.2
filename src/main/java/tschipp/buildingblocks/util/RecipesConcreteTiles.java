package tschipp.buildingblocks.util;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import tschipp.buildingblocks.blocks.BBBlocks;
import tschipp.buildingblocks.items.ItemConcreteDyeable;

import com.google.common.collect.Lists;

public class RecipesConcreteTiles implements IRecipe {
	/**
	 * Used to check if a recipe matches current crafting inventory
	 */
	public boolean matches(InventoryCrafting inv, World worldIn)
	{
		ItemStack stackColor1_1 = null;
		ItemStack stackColor2_1 = null;
		ItemStack stackColor1_2 = null;
		ItemStack stackColor2_2 = null;

		List<ItemStack> list = Lists.<ItemStack> newArrayList();

		for (int i = 0; i < inv.getSizeInventory(); ++i)
		{
			ItemStack testingstack = inv.getStackInSlot(i);

			if (testingstack != null)
			{
				if (testingstack.getItem() instanceof ItemConcreteDyeable)
				{

					if (stackColor1_1 == null)
					{
						stackColor1_1 = testingstack;
					}
					else if(stackColor2_1 == null)
					{
						stackColor2_1 = testingstack;
					}
					else if(stackColor1_2 == null)
					{
						stackColor1_2 = testingstack;
					}
					else if(stackColor2_2 == null)
					{
						stackColor2_2 = testingstack;
					}

					if(stackColor1_1 != null && stackColor1_2 != null && stackColor2_1 != null && stackColor2_2 != null)
					{
						int color1 = stackColor1_1.getTagCompound().getInteger("color");
						int color2 = stackColor2_1.getTagCompound().getInteger("color");
						int color3 = stackColor1_2.getTagCompound().getInteger("color");
						int color4 = stackColor2_2.getTagCompound().getInteger("color");

						if(color1 == color4 && color2 == color3)
						{
							return true;
						}
						else
						{
							return false;
						}
					}


				}
			}
		}

		return false;
	}

	/**
	 * Returns an Item that is the result of this recipe
	 */
	@Nullable
	public ItemStack getCraftingResult(InventoryCrafting inv)
	{
		ItemStack stackColor1_1 = null;
		ItemStack stackColor2_1 = null;
		ItemStack stackColor1_2 = null;
		ItemStack stackColor2_2 = null;
		int[] aint = new int[3];
		int i = 0;
		int j = 0;
		//ItemConcreteTiles itemconcrete = null;

		for (int k = 0; k < inv.getSizeInventory(); ++k)
		{
			ItemStack testingstack = inv.getStackInSlot(k);

			if (testingstack != null)
			{
				if (testingstack.getItem() instanceof ItemConcreteDyeable)
				{
					if (stackColor1_1 == null)
					{
						stackColor1_1 = testingstack;
					}
					else if(stackColor2_1 == null)
					{
						stackColor2_1 = testingstack;
					}
					else if(stackColor1_2 == null)
					{
						stackColor1_2 = testingstack;
					}
					else if(stackColor2_2 == null)
					{
						stackColor2_2 = testingstack;
					}

					if(stackColor1_1 != null && stackColor1_2 != null && stackColor2_1 != null && stackColor2_2 != null)
					{
						int color1 = stackColor1_1.getTagCompound().getInteger("color");
						int color2 = stackColor2_1.getTagCompound().getInteger("color");


						ItemStack output = new ItemStack(BBBlocks.concreteTiles, 4, 0);
						NBTTagCompound tag = new NBTTagCompound();
						tag.setInteger("color1", color1);
						tag.setInteger("color2", color2);
						output.setTagCompound(tag);

						return output;
					}

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
			aitemstack[i] = net.minecraftforge.common.ForgeHooks.getContainerItem(itemstack);
		}

		return aitemstack;
	}

}