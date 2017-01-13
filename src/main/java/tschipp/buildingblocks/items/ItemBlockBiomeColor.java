package tschipp.buildingblocks.items;

import tschipp.buildingblocks.blocks.BBBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBlockBiomeColor extends ItemBlock{

	public ItemBlockBiomeColor(Block block)
	{
		super(block);

	}
	
	@SideOnly(Side.CLIENT)
	public static class Color implements IItemColor {
		
		public Block block;
		
		public Color(Block block)
		{
			this.block = block;
		}

		@Override
		public int getColorFromItemstack(ItemStack stack, int tintIndex)
		{

			if (tintIndex == 0)
			{
				if(this.block != null && this.block == BBBlocks.gravelGrass)
				{
					return ColorizerGrass.getGrassColor(0.5d, 1D);
				}
				if(this.block != null && this.block == BBBlocks.overgrowth)
				{
					return ColorizerFoliage.getFoliageColor(0.5d, 1D);
				}
			}
			return -1;
		}

	}
	

}
