package tschipp.buildingblocks.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import tschipp.buildingblocks.BBMod;

public class BlockGeneric extends Block {

	public BlockGeneric(Material material, String name, MapColor color, float hardness, float resistance) {
		super(material, color);
		this.setUnlocalizedName(name);
		this.setHardness(hardness);
		this.setResistance(resistance);
		this.setCreativeTab(BBMod.buildingBlocks);
	}

}
