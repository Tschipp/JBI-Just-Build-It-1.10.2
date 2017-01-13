package tschipp.buildingblocks.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tschipp.buildingblocks.BBMod;

public class BlockOvergrowth extends Block implements IShearable {

	public static final AxisAlignedBB bbNorth = new AxisAlignedBB( 0.0, 1.0, 1.0 , 0.0, 1.0, 1.0 );
	public static final AxisAlignedBB bbEast = new AxisAlignedBB( 1, 0.0, 0.0 , 1, 1, 1 );
	public static final AxisAlignedBB bbSouth = new AxisAlignedBB( 0.0, 0.0, 1 , 1.0, 1.0, 1.0 );
	public static final AxisAlignedBB bbWest = new AxisAlignedBB( 0.0, 0.0, 0.0 , 0.0, 1, 1 );
	public static final AxisAlignedBB bbUp = new AxisAlignedBB( 0.0, 1, 0.0 , 1.0, 1, 1.0 );
	public static final AxisAlignedBB bbDown = new AxisAlignedBB( 0.0, 0.0, 0.0 , 1.0, 0.0, 1.0 );


	public BlockOvergrowth()
	{
		super(Material.PLANTS, MapColor.GRASS);
		this.setCreativeTab(BBMod.buildingBlocks);
		this.setUnlocalizedName("overgrowth");
		this.setSoundType(SoundType.PLANT);
		this.setTickRandomly(true);
		this.setHardness(0.1F);
		this.setResistance(1F);

	}

	@Override
	public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos)
	{
		return true;
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		if (!this.canBlockStay(worldIn, pos, state))
		{
			worldIn.destroyBlock(pos, false);
		}

	}

	@Deprecated
	@Override
	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block blockIn)
	{
		this.updateTick(world, pos, state, new Random());
	}


	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
	{
		BlockPos posDown = pos.down();
		BlockPos posUp = pos.up();
		BlockPos posNorth = pos.north();
		BlockPos posEast = pos.east();
		BlockPos posSouth = pos.south();
		BlockPos posWest = pos.west();

		Block blockDown = worldIn.getBlockState(posDown).getBlock();
		Block blockUp = worldIn.getBlockState(posUp).getBlock();
		Block blockNorth = worldIn.getBlockState(posNorth).getBlock();
		Block blockSouth = worldIn.getBlockState(posSouth).getBlock();
		Block blockEast = worldIn.getBlockState(posEast).getBlock();
		Block blockWest = worldIn.getBlockState(posWest).getBlock();

		if(!isConnectable(blockDown) && !isConnectable(blockUp) && !isConnectable(blockNorth) && !isConnectable(blockEast) && !isConnectable(blockSouth) && !isConnectable(blockWest))
		{
			return false;
		}
		return true;    
	}



	public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state)
	{
		BlockPos posDown = pos.down();
		BlockPos posUp = pos.up();
		BlockPos posNorth = pos.north();
		BlockPos posEast = pos.east();
		BlockPos posSouth = pos.south();
		BlockPos posWest = pos.west();

		Block blockDown = worldIn.getBlockState(posDown).getBlock();
		Block blockUp = worldIn.getBlockState(posUp).getBlock();
		Block blockNorth = worldIn.getBlockState(posNorth).getBlock();
		Block blockSouth = worldIn.getBlockState(posSouth).getBlock();
		Block blockEast = worldIn.getBlockState(posEast).getBlock();
		Block blockWest = worldIn.getBlockState(posWest).getBlock();

		if(!isConnectable(blockDown) && !isConnectable(blockUp) && !isConnectable(blockNorth) && !isConnectable(blockEast) && !isConnectable(blockSouth) && !isConnectable(blockWest))
		{
			return false;
		}
		return true;


	}

	@Override
	@Deprecated
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		BlockPos posDown = pos.down();
		BlockPos posUp = pos.up();
		BlockPos posNorth = pos.north();
		BlockPos posEast = pos.east();
		BlockPos posSouth = pos.south();
		BlockPos posWest = pos.west();

		Block blockDown = source.getBlockState(posDown).getBlock();
		Block blockUp = source.getBlockState(posUp).getBlock();
		Block blockNorth = source.getBlockState(posNorth).getBlock();
		Block blockSouth = source.getBlockState(posSouth).getBlock();
		Block blockEast = source.getBlockState(posEast).getBlock();
		Block blockWest = source.getBlockState(posWest).getBlock();

		IBlockState stateDown = source.getBlockState(posDown);
		IBlockState stateUp = source.getBlockState(posUp);
		IBlockState stateNorth = source.getBlockState(posNorth);
		IBlockState stateSouth = source.getBlockState(posSouth);
		IBlockState stateEast = source.getBlockState(posEast);
		IBlockState stateWest = source.getBlockState(posWest);

		if(isConnectable(blockDown, stateDown) && !isConnectable(blockUp, stateUp) && !isConnectable(blockNorth, stateNorth) && !isConnectable(blockSouth, stateSouth) && !isConnectable(blockEast, stateEast) && !isConnectable(blockWest, stateWest))
		{
			return bbDown;
		}
		else if(!isConnectable(blockDown, stateDown) && isConnectable(blockUp, stateUp) && !isConnectable(blockNorth, stateNorth) && !isConnectable(blockSouth, stateSouth) && !isConnectable(blockEast, stateEast) && !isConnectable(blockWest, stateWest))
		{
			return bbUp;
		}
		else if(!isConnectable(blockDown, stateDown) && !isConnectable(blockUp, stateUp) && isConnectable(blockNorth, stateNorth) && !isConnectable(blockSouth, stateSouth) && !isConnectable(blockEast, stateEast) && !isConnectable(blockWest, stateWest))
		{
			return bbNorth;
		}
		else if(!isConnectable(blockDown, stateDown) && !isConnectable(blockUp, stateUp) && !isConnectable(blockNorth, stateNorth) && isConnectable(blockSouth, stateSouth) && !isConnectable(blockEast, stateEast) && !isConnectable(blockWest, stateWest))
		{
			return bbSouth;
		}
		else if(!isConnectable(blockDown, stateDown) && !isConnectable(blockUp, stateUp) && !isConnectable(blockNorth, stateNorth) && !isConnectable(blockSouth, stateSouth) && isConnectable(blockEast, stateEast) && !isConnectable(blockWest, stateWest))
		{
			return bbEast;
		}
		else if(!isConnectable(blockDown, stateDown) && !isConnectable(blockUp, stateUp) && !isConnectable(blockNorth, stateNorth) && !isConnectable(blockSouth, stateSouth) && !isConnectable(blockEast, stateEast) && isConnectable(blockWest, stateWest))
		{
			return bbWest;
		}		
		return FULL_BLOCK_AABB;
	}


	public boolean isConnectable(Block block, IBlockState state)
	{
		return block != Blocks.AIR && block.getMaterial(state) != Material.PLANTS && block.isBlockNormalCube(state);
	}

	public boolean isConnectable(Block block)
	{
		return block != Blocks.AIR && block.getMaterial(block.getDefaultState()) != Material.PLANTS && block.isBlockNormalCube(block.getDefaultState());
	}


	@Override
	@Nullable
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return null;
	}


	@Nullable
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, World worldIn, BlockPos pos)
	{
		return NULL_AABB;
	}

	@Override
	public boolean isReplaceable(IBlockAccess worldIn, BlockPos pos)
	{
		return true;
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


	@Deprecated
	@Override
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess world, BlockPos pos, EnumFacing side)
	{
		Block nextTo = world.getBlockState(pos.offset(side)).getBlock();
		IBlockState state = world.getBlockState(pos.offset(side));
		if(isConnectable(nextTo, state)) 
		{
			return true;
		}
		return false;
	}



	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune)
	{
		List<ItemStack> drops = new ArrayList<ItemStack>();
		drops.add(new ItemStack(BBBlocks.overgrowth));
		return drops;
	}

	@SideOnly(Side.CLIENT)
	public static class Color implements IBlockColor {


		@Override
		public int colorMultiplier(IBlockState state, IBlockAccess worldIn, BlockPos pos, int tintIndex)
		{
			return 0;
		}

	}

}
