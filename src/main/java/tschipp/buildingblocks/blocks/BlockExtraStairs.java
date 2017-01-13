package tschipp.buildingblocks.blocks;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import tschipp.buildingblocks.BBMod;

public class BlockExtraStairs extends BlockStairs {

	protected BlockExtraStairs(IBlockState modelState) {
		super(modelState);
		this.setCreativeTab(BBMod.buildingBlocks);
		this.useNeighborBrightness = true;
	}

}
