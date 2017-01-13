package tschipp.buildingblocks.util;

import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import tschipp.buildingblocks.blocks.BBBlocks;
import tschipp.buildingblocks.blocks.BlockExtraSlab;

public class Crafting {

	public static void craft()
	{
		/**
		 * Removes some Vanilla Crafting Recipes
		 */
		List<IRecipe> recipeList = CraftingManager.getInstance().getRecipeList();
		Iterator<IRecipe> recipe = recipeList.iterator();

		while (recipe.hasNext())
		{
			ItemStack stack = recipe.next().getRecipeOutput();

			if (stack != null && stack.areItemsEqual(stack, new ItemStack(Blocks.STONEBRICK, 1, 0)))
			{
				recipe.remove();
			} else if (stack != null && stack.areItemsEqual(stack, new ItemStack(Blocks.END_BRICKS, 1, 0)))
			{
				recipe.remove();
			}
		}

		/**
		 * Adds all the 2 by 2 crafting Recipes
		 */
		craft2by2(new ItemStack(Blocks.STONE, 1, 2), new ItemStack(BBBlocks.moreStones, 4, 1));
		craft2by2(new ItemStack(Blocks.STONE, 1, 4), new ItemStack(BBBlocks.moreStones, 4, 3));
		craft2by2(new ItemStack(Blocks.STONE, 1, 6), new ItemStack(BBBlocks.moreStones, 4, 5));
		craft2by2(new ItemStack(BBBlocks.moreStones, 1, 6), new ItemStack(BBBlocks.moreStones, 4, 9));
		craft2by2(new ItemStack(BBBlocks.moreStones, 1, 9), new ItemStack(BBBlocks.moreStones, 4, 8));
		craft2by2(new ItemStack(BBBlocks.moreStones, 1, 10), new ItemStack(BBBlocks.moreStones, 4, 13));
		craft2by2(new ItemStack(BBBlocks.moreStones, 1, 13), new ItemStack(BBBlocks.moreStones, 4, 12));
		craft2by2(new ItemStack(Blocks.SANDSTONE, 1, 2), new ItemStack(BBBlocks.moreStones, 4, 14));
		craft2by2(new ItemStack(BBBlocks.moreStones, 1, 8), new ItemStack(BBBlocks.cotswoldBricks, 4));
		craft2by2(new ItemStack(Blocks.BRICK_BLOCK, 1), new ItemStack(BBBlocks.agedBricks, 4));
		craft2by2(new ItemStack(BBBlocks.moreStones2, 1, 2), new ItemStack(BBBlocks.moreStones2, 4, 5));
		craft2by2(new ItemStack(BBBlocks.moreStones2, 1, 5), new ItemStack(BBBlocks.moreStones2, 4, 4));
		craft2by2(new ItemStack(BBBlocks.moreStones2, 1, 1), new ItemStack(BBBlocks.moreStones2, 4, 0));
		craft2by2(new ItemStack(BBBlocks.moreStones, 1, 14), new ItemStack(BBBlocks.moreStones2, 4, 1));
		craft2by2(new ItemStack(Blocks.RED_SANDSTONE, 1, 2), new ItemStack(BBBlocks.moreStones2, 4, 6));
		craft2by2(new ItemStack(BBBlocks.moreStones2, 1, 6), new ItemStack(BBBlocks.moreStones2, 4, 9));
		craft2by2(new ItemStack(BBBlocks.moreStones2, 1, 9), new ItemStack(BBBlocks.moreStones2, 4, 8));
		craft2by2(new ItemStack(Blocks.NETHERRACK, 1), new ItemStack(BBBlocks.moreStones2, 4, 11));
		craft2by2(new ItemStack(BBBlocks.moreStones2, 1, 11), new ItemStack(BBBlocks.moreStones2, 4, 10));
		craft2by2(new ItemStack(Blocks.STONE), new ItemStack(BBBlocks.moreStones2, 4, 12));
		craft2by2(new ItemStack(Blocks.END_STONE), new ItemStack(BBBlocks.moreStones2, 4, 13));
		craft2by2(new ItemStack(BBBlocks.moreStones2, 1, 12), new ItemStack(Blocks.STONEBRICK, 4, 0));
		craft2by2(new ItemStack(BBBlocks.moreStones2, 1, 13), new ItemStack(Blocks.END_BRICKS, 4, 0));
		craft2by2(new ItemStack(BBBlocks.moreStones3, 1, 0), new ItemStack(BBBlocks.moreStones3, 4, 2));
		craft2by2(new ItemStack(BBBlocks.moreStones3, 1, 2), new ItemStack(BBBlocks.moreStones3, 4, 1));


		/**
		 * Adds all the stair Recipes
		 */
		craftStair(new ItemStack(BBBlocks.moreStones, 1, 0), new ItemStack(BBBlocks.cobbleGraniteStair, 4));
		craftStair(new ItemStack(BBBlocks.moreStones, 1, 2), new ItemStack(BBBlocks.cobbleDioriteStair, 4));
		craftStair(new ItemStack(BBBlocks.moreStones, 1, 4), new ItemStack(BBBlocks.cobbleAndesiteStair, 4));
		craftStair(new ItemStack(BBBlocks.moreStones, 1, 7), new ItemStack(BBBlocks.cobbleLimestoneStair, 4));
		craftStair(new ItemStack(BBBlocks.moreStones, 1, 11), new ItemStack(BBBlocks.cobbleMarbleStair, 4));
		craftStair(new ItemStack(BBBlocks.moreStones, 1, 15), new ItemStack(BBBlocks.cobbleSandstoneStair, 4));
		craftStair(new ItemStack(BBBlocks.moreStones2, 1, 3), new ItemStack(BBBlocks.cobbleBasaltStair, 4));
		craftStair(new ItemStack(BBBlocks.moreStones2, 1, 7), new ItemStack(BBBlocks.cobbleRedsandstoneStair, 4));
		craftStair(new ItemStack(BBBlocks.moreStones, 1, 1), new ItemStack(BBBlocks.brickGraniteStair, 4));
		craftStair(new ItemStack(BBBlocks.moreStones, 1, 3), new ItemStack(BBBlocks.brickDioriteStair, 4));
		craftStair(new ItemStack(BBBlocks.moreStones, 1, 5), new ItemStack(BBBlocks.brickAndesiteStair, 4));
		craftStair(new ItemStack(BBBlocks.moreStones, 1, 8), new ItemStack(BBBlocks.brickLimestoneStair, 4));
		craftStair(new ItemStack(BBBlocks.moreStones, 1, 12), new ItemStack(BBBlocks.brickMarbleStair, 4));
		craftStair(new ItemStack(BBBlocks.moreStones2, 1, 0), new ItemStack(BBBlocks.brickSandstoneStair, 4));
		craftStair(new ItemStack(BBBlocks.moreStones2, 1, 4), new ItemStack(BBBlocks.brickBasaltStair, 4));
		craftStair(new ItemStack(BBBlocks.moreStones2, 1, 8), new ItemStack(BBBlocks.brickRedsandstoneStair, 4));
		craftStair(new ItemStack(BBBlocks.moreStones2, 1, 10), new ItemStack(BBBlocks.brickNetherrackStair, 4));
		craftStair(new ItemStack(BBBlocks.cotswoldBricks, 1), new ItemStack(BBBlocks.brickCotswoldStair, 4));
		craftStair(new ItemStack(BBBlocks.agedBricks, 1), new ItemStack(BBBlocks.brickAgedbrickStair, 4));
		craftStair(new ItemStack(Blocks.END_BRICKS, 1), new ItemStack(BBBlocks.brickEndstoneStair, 4));
		craftStair(new ItemStack(Blocks.RED_NETHER_BRICK, 1), new ItemStack(BBBlocks.brickRednetherStair, 4));
		craftStair(new ItemStack(BBBlocks.moreStones3, 1, 1), new ItemStack(BBBlocks.brickAcheriteStair, 4));

		/**
		 * Adds all the slab Recipes
		 */
		craftSlab(BBBlocks.cobbleAndesiteSlab);
		craftSlab(BBBlocks.cobbleGraniteSlab);
		craftSlab(BBBlocks.cobbleDioriteSlab);
		craftSlab(BBBlocks.cobbleMarbleSlab);
		craftSlab(BBBlocks.cobbleLimestoneSlab);
		craftSlab(BBBlocks.cobbleSandstoneSlab);
		craftSlab(BBBlocks.cobbleBasaltSlab);
		craftSlab(BBBlocks.cobbleRedsandstoneSlab);
		craftSlab(BBBlocks.brickAndesiteSlab);
		craftSlab(BBBlocks.brickGraniteSlab);
		craftSlab(BBBlocks.brickDioriteSlab);
		craftSlab(BBBlocks.brickMarbleSlab);
		craftSlab(BBBlocks.brickLimestoneSlab);
		craftSlab(BBBlocks.brickSandstoneSlab);
		craftSlab(BBBlocks.brickBasaltSlab);
		craftSlab(BBBlocks.brickRedsandstoneSlab);
		craftSlab(BBBlocks.brickRednetherSlab);
		craftSlab(BBBlocks.brickEndstoneSlab);
		craftSlab(BBBlocks.brickNetherrackSlab);
		craftSlab(BBBlocks.brickCotswoldSlab);
		craftSlab(BBBlocks.brickAgedbrickSlab);
		craftSlab(BBBlocks.brickAcheriteSlab);
		
		/**
		 * Other Crafting Recipes
		 */
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(BBBlocks.moreStones2, 16, 14), new Object[] { Blocks.CLAY, "sand", Blocks.GRAVEL, Items.WATER_BUCKET}));
		NBTTagCompound concreteTag = new NBTTagCompound();
		concreteTag.setInteger("color", 16777215);
		ItemStack concreteStack = new ItemStack(BBBlocks.concreteDyeable, 8, 0);
		concreteStack.setTagCompound(concreteTag);
		GameRegistry.addRecipe(concreteStack, new Object[] { "###", "#O#", "###", '#', new ItemStack(BBBlocks.moreStones2, 1, 15), 'O', Items.PAPER });
		GameRegistry.addRecipe(new RecipesConcreteDyeable());
		GameRegistry.addRecipe(new RecipesConcreteTiles());
		GameRegistry.addRecipe(new RecipesConcreteDyeable.RecipeDuplicateConcrete());
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(BBBlocks.overgrowth, 8),new Object[] { "treeLeaves", "treeLeaves"}));

		/**
		 * Adds all the smelting Recipes
		 */
		smelt(new ItemStack(BBBlocks.moreStones, 1, 0), new ItemStack(Blocks.STONE, 1, 1));
		smelt(new ItemStack(BBBlocks.moreStones, 1, 2), new ItemStack(Blocks.STONE, 1, 3));
		smelt(new ItemStack(BBBlocks.moreStones, 1, 4), new ItemStack(Blocks.STONE, 1, 5));
		smelt(new ItemStack(BBBlocks.moreStones, 1, 7), new ItemStack(BBBlocks.moreStones, 1, 6));
		smelt(new ItemStack(BBBlocks.moreStones, 1, 11), new ItemStack(BBBlocks.moreStones, 1, 10));
		smelt(new ItemStack(BBBlocks.moreStones, 1, 15), new ItemStack(BBBlocks.moreStones, 1, 14));
		smelt(new ItemStack(BBBlocks.moreStones2, 1, 3), new ItemStack(BBBlocks.moreStones2, 1, 2));
		smelt(new ItemStack(BBBlocks.moreStones2, 1, 7), new ItemStack(BBBlocks.moreStones2, 1, 6));
		smelt(new ItemStack(BBBlocks.moreStones2, 1, 14), new ItemStack(BBBlocks.moreStones2, 1, 15));

	}

	/**
	 * Creates a crafting recipe for a 2x2 recipe
	 * 
	 * @param input
	 * @param output
	 */
	private static void craft2by2(ItemStack input, ItemStack output)
	{
		GameRegistry.addRecipe(output, new Object[] { "##", "##", '#', input });
	}

	/**
	 * Creates a stair crafting Recipe
	 * 
	 * @param input
	 * @param output
	 */
	private static void craftStair(ItemStack input, ItemStack output)
	{
		GameRegistry.addRecipe(output, new Object[] { "#  ", "## ", "###", '#', input });
	}
	
	/**
	 * Crafts a Slab usig the given Block and its parent
	 * 
	 * @param input
	 */
	private static void craftSlab(Block block)
	{
		BlockExtraSlab input = ((BlockExtraSlab)block);
		Block parent = input.getParent();
		int parentMeta = input.getParentMeta();
		
		GameRegistry.addRecipe(new ItemStack(block, 6, 0), new Object[] { "###", '#', new ItemStack(parent, 1, parentMeta) });
		GameRegistry.addRecipe(new ItemStack(parent, 1, parentMeta), new Object[] { "#", "#", '#', new ItemStack(block) });
	}

	/**
	 * Registers a Smelting Recipe for an Item
	 * 
	 * @param input
	 * @param output
	 */
	private static void smelt(ItemStack input, ItemStack output)
	{
		GameRegistry.addSmelting(input, output, 0.45F);
	}

}
