package tschipp.buildingblocks.util;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import tschipp.buildingblocks.blocks.BBBlocks;
import tschipp.buildingblocks.blocks.BlockConcreteDyeable;
import tschipp.buildingblocks.blocks.BlockConcreteTiles;
import tschipp.buildingblocks.blocks.BlockGravelGrass;
import tschipp.buildingblocks.blocks.tileentity.TileEntityConcrete;
import tschipp.buildingblocks.blocks.tileentity.TileEntityConcreteTiles;
import tschipp.buildingblocks.items.BBItems;

public class BBEvents {

	@SubscribeEvent
	public void onBlockHarvest(HarvestDropsEvent event)
	{
		IBlockState state = event.getState();
		ItemStack harvestingStack;
		NBTTagList taglist;
		NBTBase nbtbase;
		boolean hasSilkTouch = false;
		List<ItemStack> drops = event.getDrops();
		if (state.getBlock() == Blocks.STONE && event.getHarvester().getHeldItemMainhand() != null)
		{
			harvestingStack = event.getHarvester().getHeldItemMainhand();
			if (harvestingStack.isItemEnchanted())
			{
				taglist = harvestingStack.getEnchantmentTagList();
				nbtbase = taglist.get(0);
				hasSilkTouch = (nbtbase.toString().contains("id:33s"));
			}

			if (state.getValue(BlockStone.VARIANT) == BlockStone.EnumType.GRANITE)
			{
				if (hasSilkTouch)
				{
					return;
				} else
				{
					drops.clear();
					drops.add(new ItemStack(BBBlocks.moreStones, 1, 0));
				}
			}
			if (state.getValue(BlockStone.VARIANT) == BlockStone.EnumType.DIORITE)
			{
				if (hasSilkTouch)
				{
					return;
				} else
				{
					drops.clear();
					drops.add(new ItemStack(BBBlocks.moreStones, 1, 2));
				}
			}
			if (state.getValue(BlockStone.VARIANT) == BlockStone.EnumType.ANDESITE)
			{
				if (hasSilkTouch)
				{
					return;
				} else
				{
					drops.clear();
					drops.add(new ItemStack(BBBlocks.moreStones, 1, 4));
				}
			}

		}

		if(state.getBlock() == Blocks.GRAVEL)
		{
			Random rand = new Random();

			if(rand.nextInt(5) == 1)
			{
				drops.add(new ItemStack(BBItems.pebbles));
			}
		}

	}

	@SubscribeEvent
	public void onBlockBreak(BreakEvent event)
	{
		if (event.getState() != null && event.getState().getBlock() instanceof BlockConcreteDyeable)
		{
			if (!event.getPlayer().isCreative())
			{
				Block block = event.getState().getBlock();
				BlockPos pos = event.getPos();
				World world = event.getWorld();
				TileEntityConcrete tile = (TileEntityConcrete) world.getTileEntity(pos);
				int color = tile.getColor();
				ItemStack stack = new ItemStack(BBBlocks.concreteDyeable, 1, 0);
				NBTTagCompound tag = new NBTTagCompound();
				tag.setInteger("color", color);
				stack.setTagCompound(tag);
				Block.spawnAsEntity(world, pos, stack);
			}
		}
		
		else
		if (event.getState() != null && event.getState().getBlock() instanceof BlockConcreteTiles)
		{
			if (!event.getPlayer().isCreative())
			{
				Block block = event.getState().getBlock();
				BlockPos pos = event.getPos();
				World world = event.getWorld();
				TileEntityConcreteTiles tile = (TileEntityConcreteTiles) world.getTileEntity(pos);
				int color1 = tile.getColor1();
				int color2 = tile.getColor2();
				ItemStack stack = new ItemStack(BBBlocks.concreteTiles, 1, 0);
				NBTTagCompound tag = new NBTTagCompound();
				tag.setInteger("color1", color1);
				tag.setInteger("color2", color2);
				stack.setTagCompound(tag);
				Block.spawnAsEntity(world, pos, stack);
			}
		}



	}

}
