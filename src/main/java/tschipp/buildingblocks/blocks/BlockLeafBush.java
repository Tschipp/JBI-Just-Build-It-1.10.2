package tschipp.buildingblocks.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tschipp.buildingblocks.BBMod;

public class BlockLeafBush extends Block implements IBlockColor {

	public BlockLeafBush()
	{
		super(Material.LEAVES, MapColor.GREEN);
		this.setUnlocalizedName("bush");
		this.setCreativeTab(BBMod.buildingBlocks);
		this.setSoundType(SoundType.PLANT);
		this.setHardness(0.1F);
		this.setResistance(1F);
	}
	
	
	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state)
	{
		return false;
	}


	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.CUTOUT;
	}


	@Override
	public int colorMultiplier(IBlockState state, IBlockAccess worldIn, BlockPos pos, int tintIndex)
	{
		return 0;
	}

}
