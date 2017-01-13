package tschipp.buildingblocks.items;

import java.util.List;

import tschipp.buildingblocks.blocks.BlockExtraSlabDouble;
import tschipp.buildingblocks.blocks.BlockExtraSlabHalf;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBlockExtraSlab extends ItemSlab {

	public ItemBlockExtraSlab(Block block, BlockExtraSlabHalf halfSlab, BlockExtraSlabDouble doubleSlab)
	{
		super(block, halfSlab, doubleSlab);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
    {
        return this.getUnlocalizedName();
    }

}
