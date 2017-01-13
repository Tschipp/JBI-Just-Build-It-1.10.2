package tschipp.buildingblocks;

import java.util.List;

import net.minecraft.block.BlockStone;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import tschipp.buildingblocks.blocks.BBBlocks;
import tschipp.buildingblocks.proxies.CommonProxy;
import tschipp.buildingblocks.util.BBEvents;
import tschipp.buildingblocks.util.Crafting;


@Mod(modid = "buildingblocks", name = "Just Build It", version = "1.0")

public class BBMod 
{
	public final static String MODID = "buildingblocks";

	@Instance(value = MODID)
	public static BBMod instance;

	public static final String COMMON_PROXY = "tschipp.buildingblocks.proxies.CommonProxy";
	public static final String CLIENT_PROXY = "tschipp.buildingblocks.proxies.ClientProxy";

	@SidedProxy(clientSide = CLIENT_PROXY, serverSide = COMMON_PROXY)
	public static CommonProxy proxy;


	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
		MinecraftForge.EVENT_BUS.register(new BBEvents());
		Crafting.craft();
	}


	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);

	}


	public static CreativeTabs buildingBlocks = new CreativeTabs("moreBuildingBlocks"){
		@Override
		public Item getTabIconItem(){
			return Item.getItemFromBlock(BBBlocks.cotswoldBricks);
		}
	};




}






