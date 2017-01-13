package tschipp.buildingblocks.blocks;

import tschipp.buildingblocks.BBMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;

public class BlockExtraSlabHalf extends BlockExtraSlab {
	
	public BlockExtraSlabHalf(Material materialIn, Block parent, int parentMeta) {
		super(materialIn, parent, parentMeta, null);
		this.useNeighborBrightness = true;
		this.setCreativeTab(BBMod.buildingBlocks);
	}

	@Override
	public boolean isDouble() {
		return false;
	}

	@Override
	public Comparable<?> getTypeForItem(ItemStack stack) {
		return false;
	}


}
