package tschipp.buildingblocks.util;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import tschipp.buildingblocks.blocks.BBBlocks;

public class OreDict {
	
	public static void registerOreDictionary() 
	{
		
		//More Specific Name
		OreDictionary.registerOre("cobblestoneGranite", new ItemStack(BBBlocks.moreStones, 1, 0));
		OreDictionary.registerOre("cobblestoneDiorite", new ItemStack(BBBlocks.moreStones, 1, 2));
		OreDictionary.registerOre("cobblestoneAndesite", new ItemStack(BBBlocks.moreStones, 1, 4));
		OreDictionary.registerOre("cobblestoneLimestone", new ItemStack(BBBlocks.moreStones, 1, 7));
		OreDictionary.registerOre("cobblestoneMarble", new ItemStack(BBBlocks.moreStones, 1, 11));
		OreDictionary.registerOre("cobblestoneSandstone", new ItemStack(BBBlocks.moreStones, 1, 15));
		OreDictionary.registerOre("cobblestoneBasalt", new ItemStack(BBBlocks.moreStones2, 1, 3));
		OreDictionary.registerOre("cobblestoneRedSandstone", new ItemStack(BBBlocks.moreStones2, 1, 7));
		
		//Base Value
		OreDictionary.registerOre("cobblestone", new ItemStack(BBBlocks.moreStones, 1, 0));
		OreDictionary.registerOre("cobblestone", new ItemStack(BBBlocks.moreStones, 1, 2));
		OreDictionary.registerOre("cobblestone", new ItemStack(BBBlocks.moreStones, 1, 4));
		OreDictionary.registerOre("cobblestone", new ItemStack(BBBlocks.moreStones, 1, 7));
		OreDictionary.registerOre("cobblestone", new ItemStack(BBBlocks.moreStones, 1, 11));
		OreDictionary.registerOre("cobblestone", new ItemStack(BBBlocks.moreStones, 1, 15));
		OreDictionary.registerOre("cobblestone", new ItemStack(BBBlocks.moreStones2, 1, 3));
		OreDictionary.registerOre("cobblestone", new ItemStack(BBBlocks.moreStones2, 1, 7));

		//More Specific Name
		OreDictionary.registerOre("stoneLimestone", new ItemStack(BBBlocks.moreStones, 1, 6));
		OreDictionary.registerOre("stoneMarble", new ItemStack(BBBlocks.moreStones, 1, 10));
		OreDictionary.registerOre("sandstone", new ItemStack(BBBlocks.moreStones, 1, 14));
		OreDictionary.registerOre("stoneBasalt", new ItemStack(BBBlocks.moreStones2, 1, 2));
		OreDictionary.registerOre("sandstone", new ItemStack(BBBlocks.moreStones2, 1, 6));
		OreDictionary.registerOre("stonePolished", new ItemStack(BBBlocks.moreStones2, 1, 12));
		OreDictionary.registerOre("endstonePolished", new ItemStack(BBBlocks.moreStones2, 1, 13));
		OreDictionary.registerOre("netherrackPolished", new ItemStack(BBBlocks.moreStones2, 1, 11));
		OreDictionary.registerOre("sandstonePolished", new ItemStack(BBBlocks.moreStones2, 1, 9));
		OreDictionary.registerOre("stoneBasaltPolished", new ItemStack(BBBlocks.moreStones2, 1, 5));
		OreDictionary.registerOre("sandstonePolished", new ItemStack(BBBlocks.moreStones2, 1, 1));
		OreDictionary.registerOre("stoneLimestonePolished", new ItemStack(BBBlocks.moreStones, 1, 9));
		OreDictionary.registerOre("stoneMarblePolished", new ItemStack(BBBlocks.moreStones, 1, 13));
		
		//Base Value
		OreDictionary.registerOre("stone", new ItemStack(BBBlocks.moreStones, 1, 6));
		OreDictionary.registerOre("stone", new ItemStack(BBBlocks.moreStones, 1, 10));
		OreDictionary.registerOre("sandstone", new ItemStack(BBBlocks.moreStones, 1, 14));
		OreDictionary.registerOre("stone", new ItemStack(BBBlocks.moreStones2, 1, 2));
		OreDictionary.registerOre("sandstone", new ItemStack(BBBlocks.moreStones2, 1, 6));
		OreDictionary.registerOre("stone", new ItemStack(BBBlocks.moreStones2, 1, 12));
		OreDictionary.registerOre("endstone", new ItemStack(BBBlocks.moreStones2, 1, 13));
		OreDictionary.registerOre("netherrack", new ItemStack(BBBlocks.moreStones2, 1, 11));
		OreDictionary.registerOre("sandstone", new ItemStack(BBBlocks.moreStones2, 1, 9));
		OreDictionary.registerOre("stone", new ItemStack(BBBlocks.moreStones2, 1, 5));
		OreDictionary.registerOre("sandstone", new ItemStack(BBBlocks.moreStones2, 1, 1));
		OreDictionary.registerOre("stone", new ItemStack(BBBlocks.moreStones, 1, 9));
		OreDictionary.registerOre("stone", new ItemStack(BBBlocks.moreStones, 1, 13));


	}

}
