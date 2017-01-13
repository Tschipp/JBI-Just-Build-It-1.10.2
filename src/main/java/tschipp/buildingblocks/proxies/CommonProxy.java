package tschipp.buildingblocks.proxies;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import tschipp.buildingblocks.blocks.BBBlocks;
import tschipp.buildingblocks.blocks.tileentity.TileEntityConcrete;
import tschipp.buildingblocks.blocks.tileentity.TileEntityConcreteTiles;
import tschipp.buildingblocks.items.BBItems;
import tschipp.buildingblocks.util.OreDict;
import tschipp.buildingblocks.util.WorldGenStones;

public class CommonProxy {
	
	
	
	public void preInit(FMLPreInitializationEvent event) {
		BBItems.createItems();
		BBBlocks.createBlocks();
		GameRegistry.registerTileEntity(TileEntityConcrete.class, "bbconcrete");
		GameRegistry.registerTileEntity(TileEntityConcreteTiles.class, "bbconcretetiles");

	}
	
	public void init(FMLInitializationEvent event) {
		OreDict.registerOreDictionary();
	    GameRegistry.registerWorldGenerator(new WorldGenStones(), 0);
	}
	
	public void postInit(FMLPostInitializationEvent event) {
		
		
	}

}
