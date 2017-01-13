package tschipp.buildingblocks.items;

import tschipp.buildingblocks.BBMod;
import tschipp.buildingblocks.blocks.BBBlocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemPebble extends Item {
	
	public ItemPebble()
	{
		this.setUnlocalizedName("pebbles");
		this.setCreativeTab(BBMod.buildingBlocks);
	}
	
	
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		if(world.getBlockState(pos) == Blocks.GRASS.getDefaultState())
		{
			world.setBlockState(pos, BBBlocks.gravelGrass.getDefaultState());
			stack.stackSize--;
			return EnumActionResult.SUCCESS;
		}
        return EnumActionResult.FAIL;
    }

}
