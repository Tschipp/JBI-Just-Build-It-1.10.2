package tschipp.buildingblocks.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import tschipp.buildingblocks.blocks.BBBlocks;

public class BBItems {
	
	public static Item pebbles;
	
	
	public static void createItems() {
		
		GameRegistry.registerItem(pebbles = new ItemPebble(),  "pebbles");	
		
	}
	


}
