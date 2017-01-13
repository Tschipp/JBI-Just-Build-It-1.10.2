package tschipp.buildingblocks.proxies;

import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.world.biome.BiomeColorHelper;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import tschipp.buildingblocks.blocks.BBBlocks;
import tschipp.buildingblocks.blocks.BlockConcreteDyeable;
import tschipp.buildingblocks.blocks.BlockConcreteTiles;
import tschipp.buildingblocks.blocks.BlockRenderRegister;
import tschipp.buildingblocks.items.ItemBlockBiomeColor;
import tschipp.buildingblocks.items.ItemConcreteDyeable;
import tschipp.buildingblocks.items.ItemConcreteTiles;
import tschipp.buildingblocks.items.ItemRenderRegister;

public class ClientProxy extends CommonProxy
{
	

	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
	}
	
	public void init(FMLInitializationEvent event) {
		super.init(event);
		
		
		ItemRenderRegister.registerItems();
		BlockRenderRegister.registerBlocks();
		Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler(new BlockConcreteDyeable.Color(), BBBlocks.concreteDyeable);
		Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler(new BlockConcreteTiles.Color(), BBBlocks.concreteTiles);

		Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler((state, worldIn, pos, tintIndex) -> {
			if(worldIn != null && pos != null && tintIndex == 0) {
				return BiomeColorHelper.getGrassColorAtPos(worldIn, pos);	

			}
			return -1;
			
		}, BBBlocks.gravelGrass);	
		
		Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler((state, worldIn, pos, tintIndex) -> {
			if(worldIn != null && pos != null && tintIndex == 0) {
				return BiomeColorHelper.getGrassColorAtPos(worldIn, pos);	

			}
			return -1;
			
		}, BBBlocks.overgrowth);	
		
	/*	Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler((state, worldIn, pos, tintIndex) -> {
			if(worldIn != null && pos != null && tintIndex == 0) {
				return BiomeColorHelper.getFoliageColorAtPos(worldIn, pos);	

			}
			return -1;
			
		}, BBBlocks.bush);	 */
		
		FMLClientHandler.instance().getClient().getItemColors().registerItemColorHandler(new ItemConcreteDyeable.Color(), BBBlocks.concreteDyeable);
		FMLClientHandler.instance().getClient().getItemColors().registerItemColorHandler(new ItemBlockBiomeColor.Color(BBBlocks.gravelGrass), BBBlocks.gravelGrass);
		FMLClientHandler.instance().getClient().getItemColors().registerItemColorHandler(new ItemBlockBiomeColor.Color(BBBlocks.overgrowth), BBBlocks.overgrowth);
		FMLClientHandler.instance().getClient().getItemColors().registerItemColorHandler(new ItemConcreteTiles.Color(), BBBlocks.concreteTiles);

	}
	
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
		
		
	}

}
