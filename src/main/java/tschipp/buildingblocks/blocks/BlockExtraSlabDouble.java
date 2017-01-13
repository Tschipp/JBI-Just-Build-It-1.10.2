package tschipp.buildingblocks.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;

public class BlockExtraSlabDouble extends BlockExtraSlab {
	
	public BlockExtraSlabDouble(Material materialIn, Block parent, int parentMeta, Block halfSlab) {
		super(materialIn, parent, parentMeta, halfSlab);
	}

	@Override
	public boolean isDouble() {
		return true;
	}

	@Override
	public Comparable<?> getTypeForItem(ItemStack stack) {
		return null;
	}
	
	
}
