package tschipp.buildingblocks.items;

import tschipp.buildingblocks.blocks.BBBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class ItemBlockBlazingAcherite extends ItemBlock {

	public ItemBlockBlazingAcherite(Block block)
	{
		super(block);
	}


	@Override
	public boolean onEntityItemUpdate(net.minecraft.entity.item.EntityItem entityItem)
	{
		BlockPos pos = entityItem.getPosition();
		World world = entityItem.worldObj;
		Block block = world.getBlockState(pos).getBlock();
		ItemStack stack = entityItem.getEntityItem();

		if(block.getMaterial(world.getBlockState(pos)) == Material.WATER)
		{
			stack.setItem(Item.getItemFromBlock(BBBlocks.moreStones3));
			stack.setItemDamage(0);
		//	world.playSound((EntityPlayer)null, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);
			world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F, true);
			if(!world.isRemote) 
			{
		        ((WorldServer)world).spawnParticle(EnumParticleTypes.SMOKE_LARGE, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.25D, (double)pos.getZ() + 0.5D, 8, 0.5D, 0.25D, 0.5D, 0.0D, new int[0]);
			}
			entityItem.setEntityItemStack(stack);
		}
		return false;
	}


}
