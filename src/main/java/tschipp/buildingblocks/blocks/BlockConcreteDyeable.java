package tschipp.buildingblocks.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tschipp.buildingblocks.BBMod;
import tschipp.buildingblocks.blocks.tileentity.TileEntityConcrete;

public class BlockConcreteDyeable extends Block{

	public BlockConcreteDyeable(Material material)
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

	// FOR TESTING PURPOSES
	/*
	 * @Override public boolean onBlockActivated(World world, BlockPos pos,
	 * IBlockState state, EntityPlayer player, EnumHand hand, @Nullable
	 * ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
	 * { if(!world.isRemote) {
	 * 
	 * TileEntityConcrete tile = (TileEntityConcrete) world.getTileEntity(pos);
	 * NBTTagCompound tag = new NBTTagCompound(); tile.setColor(tile.getColor()
	 * + 1000); tile.writeToNBT(tag); if(player instanceof EntityPlayerMP) {
	 * ((EntityPlayerMP) player).connection.sendPacket(new
	 * SPacketUpdateTileEntity(pos, 0, tag)); }
	 * world.notifyBlockOfStateChange(pos, this); tile.markDirty(); }
	 * 
	 * return true; }
	 */

	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
	{
		TileEntityConcrete tile = (TileEntityConcrete) world.getTileEntity(pos);
		if (stack.getTagCompound() == null)
		{
			tile.setColor(16777215);
		} else
		{
			tile.setColor(stack.getTagCompound().getInteger("color"));
		}

	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player)
	{
		TileEntityConcrete tile = (TileEntityConcrete) world.getTileEntity(pos);
		int color = tile.getColor();
		ItemStack stack = new ItemStack(BBBlocks.concreteDyeable, 1, 0);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setInteger("color", color);
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
		return new TileEntityConcrete();

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
				TileEntityConcrete tile = (TileEntityConcrete) worldIn.getTileEntity(pos);
				int color = tile.getColor();

				return color;
			} else
			{
				return -1;
			}

		}

	}

}
