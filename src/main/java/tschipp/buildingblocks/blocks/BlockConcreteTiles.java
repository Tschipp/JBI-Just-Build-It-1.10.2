package tschipp.buildingblocks.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import tschipp.buildingblocks.BBMod;
import tschipp.buildingblocks.blocks.tileentity.TileEntityConcreteTiles;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockConcreteTiles extends Block{

	public BlockConcreteTiles(Material material)
	{
		super(material, MapColor.GRAY);
		this.setHardness(1.8F);
		this.setResistance(10F);
		// this.setTickRandomly(true);
		this.isBlockContainer = true;
		this.setCreativeTab(BBMod.buildingBlocks);

	}

	@Override
	@Nullable
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return null;
	}

	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
	{
		TileEntityConcreteTiles tile = (TileEntityConcreteTiles) world.getTileEntity(pos);
		if (stack.getTagCompound() == null)
		{
			tile.setColor1(16777215);
			tile.setColor1(16777215);

		} else
		{
			tile.setColor1(stack.getTagCompound().getInteger("color1"));
			tile.setColor2(stack.getTagCompound().getInteger("color2"));

		}

	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player)
	{
		TileEntityConcreteTiles tile = (TileEntityConcreteTiles) world.getTileEntity(pos);
		int color1 = tile.getColor1();
		int color2 = tile.getColor2();
		ItemStack stack = new ItemStack(BBBlocks.concreteTiles, 1, 0);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setInteger("color1", color1);
		tag.setInteger("color2", color2);
		stack.setTagCompound(tag);
		return stack;
	}


	@Override
	public boolean hasTileEntity(IBlockState state)
	{
		return true;
	}

	@Override
	public TileEntity createTileEntity(World world, IBlockState state)
	{
		return new TileEntityConcreteTiles();

	}

	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.SOLID;
	}


	@SideOnly(Side.CLIENT)
	public static class Color implements IBlockColor {

		@Override
		@SideOnly(Side.CLIENT)
		public int colorMultiplier(IBlockState state, @Nullable IBlockAccess worldIn, @Nullable BlockPos pos, int tintIndex)
		{

			if (worldIn != null && pos != null)
			{
				TileEntityConcreteTiles tile = (TileEntityConcreteTiles) worldIn.getTileEntity(pos);

				if(tintIndex == 0)
				{
					int color = tile.getColor1();
					return color;
				}
				else if (tintIndex == 1)
				{
					int color = tile.getColor2();
					return color;
				}
			} 

			return -1;


		}

	}

}
