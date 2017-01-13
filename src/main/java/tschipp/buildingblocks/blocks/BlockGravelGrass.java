package tschipp.buildingblocks.blocks;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import tschipp.buildingblocks.BBMod;
import tschipp.buildingblocks.items.BBItems;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockGravelGrass extends Block{

	public BlockGravelGrass(Material materialIn)
	{
		super(materialIn, MapColor.STONE);
		this.blockHardness = 0.8F;
		this.blockResistance = 3.5F;
		this.setSoundType(SoundType.PLANT);
		this.setUnlocalizedName("gravelGrass");
		this.setCreativeTab(BBMod.buildingBlocks);
		this.setHarvestLevel("shovel", 0);
	}

	@SideOnly(Side.CLIENT)
	public static class Color implements IBlockColor {

		@Override
		@SideOnly(Side.CLIENT)
		public int colorMultiplier(IBlockState state, @Nullable IBlockAccess worldIn, @Nullable BlockPos pos, int tintIndex)
		{			
			return 0;
		}

	}



	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, net.minecraftforge.common.IPlantable plantable)
	{
		return true;
	}


	@Override
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
	{
		List<ItemStack> drops = new ArrayList<ItemStack>();
		drops.add(new ItemStack(Blocks.DIRT, 1));
		drops.add(new ItemStack(BBItems.pebbles, 1));
		return drops;

	}

}
