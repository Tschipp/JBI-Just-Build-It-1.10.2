package tschipp.buildingblocks.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.ColorizerGrass;
import net.minecraftforge.fml.common.registry.GameRegistry;
import tschipp.buildingblocks.BBMod;
import tschipp.buildingblocks.items.ItemBlockBlazingAcherite;
import tschipp.buildingblocks.items.ItemBlockExtraSlab;
import tschipp.buildingblocks.items.ItemBlockBiomeColor;
import tschipp.buildingblocks.items.ItemConcreteDyeable;
import tschipp.buildingblocks.items.ItemConcreteTiles;
import tschipp.buildingblocks.items.ItemSubtypes;

public class BBBlocks {

	public static Block agedBricks;
	public static Block cotswoldBricks;
	public static Block moreStones;
	public static Block moreStones2;
	public static Block moreStones3;
	public static Block concreteDyeable;
	public static Block concreteTiles;
	public static Block gravelGrass;
	public static Block overgrowth;
	public static Block bush;
	public static Block blazingAcherite;

	
	public static Block cobbleGraniteStair;
	public static Block cobbleDioriteStair;
	public static Block cobbleAndesiteStair;
	public static Block cobbleLimestoneStair;
	public static Block cobbleMarbleStair;
	public static Block cobbleBasaltStair;
	public static Block cobbleSandstoneStair;
	public static Block cobbleRedsandstoneStair;
	
	public static Block brickGraniteStair;
	public static Block brickDioriteStair;
	public static Block brickAndesiteStair; 
	public static Block brickLimestoneStair;
	public static Block brickMarbleStair;
	public static Block brickBasaltStair;
	public static Block brickSandstoneStair;
	public static Block brickRedsandstoneStair;
	public static Block brickNetherrackStair;
	public static Block brickAgedbrickStair;
	public static Block brickCotswoldStair;
	public static Block brickEndstoneStair;
	public static Block brickRednetherStair;
	public static Block brickAcheriteStair;
	
	public static Block cobbleGraniteSlab;
	public static Block cobbleDioriteSlab;
	public static Block cobbleAndesiteSlab;
	public static Block cobbleLimestoneSlab;
	public static Block cobbleMarbleSlab;
	public static Block cobbleBasaltSlab;
	public static Block cobbleSandstoneSlab;
	public static Block cobbleRedsandstoneSlab;
	
	public static Block brickGraniteSlab;
	public static Block brickDioriteSlab;
	public static Block brickAndesiteSlab; 
	public static Block brickLimestoneSlab;
	public static Block brickMarbleSlab;
	public static Block brickBasaltSlab;
	public static Block brickSandstoneSlab;
	public static Block brickRedsandstoneSlab;
	public static Block brickNetherrackSlab;
	public static Block brickAgedbrickSlab;
	public static Block brickCotswoldSlab;
	public static Block brickEndstoneSlab;
	public static Block brickRednetherSlab;
	public static Block brickAcheriteSlab;

	public static Block cobbleGraniteSlab_double;
	public static Block cobbleDioriteSlab_double;
	public static Block cobbleAndesiteSlab_double;
	public static Block cobbleLimestoneSlab_double;
	public static Block cobbleMarbleSlab_double;
	public static Block cobbleBasaltSlab_double;
	public static Block cobbleSandstoneSlab_double;
	public static Block cobbleRedsandstoneSlab_double;
	
	public static Block brickGraniteSlab_double;
	public static Block brickDioriteSlab_double;
	public static Block brickAndesiteSlab_double; 
	public static Block brickLimestoneSlab_double;
	public static Block brickMarbleSlab_double;
	public static Block brickBasaltSlab_double;
	public static Block brickSandstoneSlab_double;
	public static Block brickRedsandstoneSlab_double;
	public static Block brickNetherrackSlab_double;
	public static Block brickAgedbrickSlab_double;
	public static Block brickCotswoldSlab_double;
	public static Block brickEndstoneSlab_double;
	public static Block brickRednetherSlab_double;
	public static Block brickAcheriteSlab_double;

	
	public static void createBlocks() {
		
		//Regular Block Registering
		GameRegistry.registerBlock(agedBricks = new BlockGeneric(Material.ROCK, "agedBricks", MapColor.RED, 2.5F, 11F), "agedBricks");
		GameRegistry.registerBlock(cotswoldBricks = new BlockGeneric(Material.ROCK, "cotswoldBricks", MapColor.SAND, 2.2F, 8F), "cotswoldBricks");
		GameRegistry.registerBlock(gravelGrass = new BlockGravelGrass(Material.GRASS), ItemBlockBiomeColor.class, "gravelGrass");
		GameRegistry.register(overgrowth = new BlockOvergrowth(), new ResourceLocation(BBMod.MODID + ":overgrowth"));
		GameRegistry.register(new ItemBlockBiomeColor(overgrowth),  new ResourceLocation(BBMod.MODID + ":overgrowth"));
		//GameRegistry.register(bush = new BlockLeafBush(), new ResourceLocation(BBMod.MODID + ":bush"));
		//GameRegistry.register(new ItemBlock(bush),  new ResourceLocation(BBMod.MODID + ":bush"));
		GameRegistry.registerBlock(moreStones = new BlockExtraStones().setUnlocalizedName("moreStones"), ItemSubtypes.class,  "moreStones");
		GameRegistry.registerBlock(moreStones2 = new BlockExtraStones2().setUnlocalizedName("moreStones2"), ItemSubtypes.class,  "moreStones2");
		GameRegistry.registerBlock(concreteDyeable = new BlockConcreteDyeable(Material.ROCK).setUnlocalizedName("concreteDyeable"), ItemConcreteDyeable.class, "concreteDyeable");
		GameRegistry.registerBlock(concreteTiles = new BlockConcreteTiles(Material.ROCK).setUnlocalizedName("concreteTiles"), ItemConcreteTiles.class, "concreteTiles");
		GameRegistry.register(blazingAcherite = new BlockBlazingAcherite().setUnlocalizedName("blazing_acherite" ),  new ResourceLocation(BBMod.MODID + ":blazing_acherite"));
		GameRegistry.register(new ItemBlockBlazingAcherite(blazingAcherite),  new ResourceLocation(BBMod.MODID + ":blazing_acherite"));
		GameRegistry.registerBlock(moreStones3 = new BlockExtraStones3().setUnlocalizedName("moreStones3"), ItemSubtypes.class,  "moreStones3");

		
		
		//Stair Registering
		GameRegistry.registerBlock(cobbleGraniteStair = new BlockExtraStairs(moreStones.getDefaultState()).setUnlocalizedName("cobbleGraniteStair"), "cobbleGraniteStair");
		GameRegistry.registerBlock(cobbleDioriteStair = new BlockExtraStairs(moreStones.getDefaultState()).setUnlocalizedName("cobbleDioriteStair"), "cobbleDioriteStair");
		GameRegistry.registerBlock(cobbleAndesiteStair = new BlockExtraStairs(moreStones.getDefaultState()).setUnlocalizedName("cobbleAndesiteStair"), "cobbleAndesiteStair");
		GameRegistry.registerBlock(cobbleLimestoneStair = new BlockExtraStairs(moreStones.getDefaultState()).setUnlocalizedName("cobbleLimestoneStair"), "cobbleLimestoneStair");
		GameRegistry.registerBlock(cobbleMarbleStair = new BlockExtraStairs(moreStones.getDefaultState()).setUnlocalizedName("cobbleMarbleStair"), "cobbleMarbleStair");
		GameRegistry.registerBlock(cobbleBasaltStair = new BlockExtraStairs(moreStones2.getDefaultState()).setUnlocalizedName("cobbleBasaltStair"), "cobbleBasaltStair");
		GameRegistry.registerBlock(cobbleSandstoneStair = new BlockExtraStairs(moreStones.getDefaultState()).setUnlocalizedName("cobbleSandstoneStair"), "cobbleSandstoneStair");
		GameRegistry.registerBlock(cobbleRedsandstoneStair = new BlockExtraStairs(moreStones2.getDefaultState()).setUnlocalizedName("cobbleRedsandstoneStair"), "cobbleRedsandstoneStair");
		
		GameRegistry.registerBlock(brickGraniteStair = new BlockExtraStairs(moreStones.getDefaultState()).setUnlocalizedName("brickGraniteStair"), "brickGraniteStair");
		GameRegistry.registerBlock(brickDioriteStair = new BlockExtraStairs(moreStones.getDefaultState()).setUnlocalizedName("brickDioriteStair"), "brickDioriteStair");
		GameRegistry.registerBlock(brickAndesiteStair = new BlockExtraStairs(moreStones.getDefaultState()).setUnlocalizedName("brickAndesiteStair"), "brickAndesiteStair");
		GameRegistry.registerBlock(brickLimestoneStair = new BlockExtraStairs(moreStones.getDefaultState()).setUnlocalizedName("brickLimestoneStair"), "brickLimestoneStair");
		GameRegistry.registerBlock(brickMarbleStair = new BlockExtraStairs(moreStones.getDefaultState()).setUnlocalizedName("brickMarbleStair"), "brickMarbleStair");
		GameRegistry.registerBlock(brickBasaltStair = new BlockExtraStairs(moreStones2.getDefaultState()).setUnlocalizedName("brickBasaltStair"), "brickBasaltStair");
		GameRegistry.registerBlock(brickSandstoneStair = new BlockExtraStairs(moreStones.getDefaultState()).setUnlocalizedName("brickSandstoneStair"), "brickSandstoneStair");
		GameRegistry.registerBlock(brickRedsandstoneStair = new BlockExtraStairs(moreStones2.getDefaultState()).setUnlocalizedName("brickRedsandstoneStair"), "brickRedsandstoneStair");
		GameRegistry.registerBlock(brickNetherrackStair = new BlockExtraStairs(moreStones2.getDefaultState()).setUnlocalizedName("brickNetherrackStair"), "brickNetherrackStair");
		GameRegistry.registerBlock(brickAgedbrickStair = new BlockExtraStairs(agedBricks.getDefaultState()).setUnlocalizedName("brickAgedbrickStair"), "brickAgedbrickStair");
		GameRegistry.registerBlock(brickCotswoldStair = new BlockExtraStairs(cotswoldBricks.getDefaultState()).setUnlocalizedName("brickCotswoldStair"), "brickCotswoldStair");
		GameRegistry.registerBlock(brickEndstoneStair = new BlockExtraStairs(Blocks.END_BRICKS.getDefaultState()).setUnlocalizedName("brickEndstoneStair"), "brickEndstoneStair");
		GameRegistry.registerBlock(brickRednetherStair = new BlockExtraStairs(Blocks.RED_NETHER_BRICK.getDefaultState()).setUnlocalizedName("brickRednetherStair"), "brickRednetherStair");
		GameRegistry.registerBlock(brickAcheriteStair = new BlockExtraStairs(moreStones3.getDefaultState()).setUnlocalizedName("brickAcheriteStair"), "brickAcheriteStair");

		
		
		//Slab Registering
		cobbleGraniteSlab = new BlockExtraSlabHalf(Material.ROCK, moreStones, 0).setUnlocalizedName("cobbleGraniteSlab");
		cobbleDioriteSlab = new BlockExtraSlabHalf(Material.ROCK, moreStones, 2).setUnlocalizedName("cobbleDioriteSlab");
		cobbleAndesiteSlab = new BlockExtraSlabHalf(Material.ROCK, moreStones, 4).setUnlocalizedName("cobbleAndesiteSlab");
		cobbleLimestoneSlab = new BlockExtraSlabHalf(Material.ROCK, moreStones, 7).setUnlocalizedName("cobbleLimestoneSlab");
		cobbleMarbleSlab = new BlockExtraSlabHalf(Material.ROCK, moreStones, 11).setUnlocalizedName("cobbleMarbleSlab");
		cobbleBasaltSlab = new BlockExtraSlabHalf(Material.ROCK, moreStones2, 3).setUnlocalizedName("cobbleBasaltSlab");
		cobbleSandstoneSlab = new BlockExtraSlabHalf(Material.ROCK, moreStones, 15).setUnlocalizedName("cobbleSandstoneSlab");
		cobbleRedsandstoneSlab = new BlockExtraSlabHalf(Material.ROCK, moreStones2, 7).setUnlocalizedName("cobbleRedsandstoneSlab");
		
		brickGraniteSlab = new BlockExtraSlabHalf(Material.ROCK, moreStones, 1).setUnlocalizedName("brickGraniteSlab");
		brickDioriteSlab = new BlockExtraSlabHalf(Material.ROCK, moreStones, 3).setUnlocalizedName("brickDioriteSlab");
		brickAndesiteSlab = new BlockExtraSlabHalf(Material.ROCK, moreStones, 5).setUnlocalizedName("brickAndesiteSlab");
		brickLimestoneSlab = new BlockExtraSlabHalf(Material.ROCK, moreStones, 8).setUnlocalizedName("brickLimestoneSlab");
		brickMarbleSlab = new BlockExtraSlabHalf(Material.ROCK, moreStones, 12).setUnlocalizedName("brickMarbleSlab");
		brickBasaltSlab = new BlockExtraSlabHalf(Material.ROCK, moreStones2, 4).setUnlocalizedName("brickBasaltSlab");
		brickSandstoneSlab = new BlockExtraSlabHalf(Material.ROCK, moreStones2, 0).setUnlocalizedName("brickSandstoneSlab");
		brickRedsandstoneSlab = new BlockExtraSlabHalf(Material.ROCK, moreStones2, 8).setUnlocalizedName("brickRedsandstoneSlab");
		brickNetherrackSlab = new BlockExtraSlabHalf(Material.ROCK, moreStones2, 10).setUnlocalizedName("brickNetherrackSlab");
		brickAgedbrickSlab = new BlockExtraSlabHalf(Material.ROCK, agedBricks, 0).setUnlocalizedName("brickAgedbrickSlab");
		brickCotswoldSlab = new BlockExtraSlabHalf(Material.ROCK, cotswoldBricks, 0).setUnlocalizedName("brickCotswoldSlab");
		brickEndstoneSlab = new BlockExtraSlabHalf(Material.ROCK, Blocks.END_BRICKS, 0).setUnlocalizedName("brickEndstoneSlab");
		brickRednetherSlab = new BlockExtraSlabHalf(Material.ROCK, Blocks.RED_NETHER_BRICK, 0).setUnlocalizedName("brickRednetherSlab");
		brickAcheriteSlab = new BlockExtraSlabHalf(Material.ROCK, moreStones3, 1).setUnlocalizedName("brickAcheriteSlab");

		cobbleGraniteSlab_double = new BlockExtraSlabDouble(Material.ROCK, moreStones, 0, cobbleGraniteSlab).setUnlocalizedName("cobbleGraniteSlab_double");
		cobbleDioriteSlab_double = new BlockExtraSlabDouble(Material.ROCK, moreStones, 2 , cobbleDioriteSlab).setUnlocalizedName("cobbleDioriteSlab_double");
		cobbleAndesiteSlab_double = new BlockExtraSlabDouble(Material.ROCK, moreStones, 4, cobbleAndesiteSlab).setUnlocalizedName("cobbleAndesiteSlab_double");
		cobbleLimestoneSlab_double = new BlockExtraSlabDouble(Material.ROCK, moreStones, 7, cobbleLimestoneSlab).setUnlocalizedName("cobbleLimestoneSlab_double");
		cobbleMarbleSlab_double = new BlockExtraSlabDouble(Material.ROCK, moreStones, 11, cobbleMarbleSlab).setUnlocalizedName("cobbleMarbleSlab_double");
		cobbleBasaltSlab_double = new BlockExtraSlabDouble(Material.ROCK, moreStones2, 3, cobbleBasaltSlab).setUnlocalizedName("cobbleBasaltSlab_double");
		cobbleSandstoneSlab_double = new BlockExtraSlabDouble(Material.ROCK, moreStones, 15, cobbleSandstoneSlab).setUnlocalizedName("cobbleSandstoneSlab_double");
		cobbleRedsandstoneSlab_double = new BlockExtraSlabDouble(Material.ROCK, moreStones2, 7, cobbleRedsandstoneSlab).setUnlocalizedName("cobbleRedsandstoneSlab_double");
		
		brickGraniteSlab_double = new BlockExtraSlabDouble(Material.ROCK, moreStones, 1, brickGraniteSlab).setUnlocalizedName("brickGraniteSlab_double");
		brickDioriteSlab_double = new BlockExtraSlabDouble(Material.ROCK, moreStones, 3, brickDioriteSlab).setUnlocalizedName("brickDioriteSlab_double");
		brickAndesiteSlab_double = new BlockExtraSlabDouble(Material.ROCK, moreStones, 5, brickAndesiteSlab).setUnlocalizedName("brickAndesiteSlab_double");
		brickLimestoneSlab_double = new BlockExtraSlabDouble(Material.ROCK, moreStones, 8, brickLimestoneSlab).setUnlocalizedName("brickLimestoneSlab_double");
		brickMarbleSlab_double = new BlockExtraSlabDouble(Material.ROCK, moreStones, 12, brickMarbleSlab).setUnlocalizedName("brickMarbleSlab_double");
		brickBasaltSlab_double = new BlockExtraSlabDouble(Material.ROCK, moreStones2, 4, brickBasaltSlab).setUnlocalizedName("brickBasaltSlab_double");
		brickSandstoneSlab_double = new BlockExtraSlabDouble(Material.ROCK, moreStones2, 0, brickSandstoneSlab).setUnlocalizedName("brickSandstoneSlab_double");
		brickRedsandstoneSlab_double = new BlockExtraSlabDouble(Material.ROCK, moreStones2, 8, brickRedsandstoneSlab).setUnlocalizedName("brickRedsandstoneSlab_double");
		brickNetherrackSlab_double = new BlockExtraSlabDouble(Material.ROCK, moreStones2, 10, brickNetherrackSlab).setUnlocalizedName("brickNetherrackSlab_double");
		brickAgedbrickSlab_double = new BlockExtraSlabDouble(Material.ROCK, agedBricks, 0, brickAgedbrickSlab).setUnlocalizedName("brickAgedbrickSlab_double");
		brickCotswoldSlab_double = new BlockExtraSlabDouble(Material.ROCK, cotswoldBricks, 0, brickCotswoldSlab).setUnlocalizedName("brickCotswoldSlab_double");
		brickEndstoneSlab_double = new BlockExtraSlabDouble(Material.ROCK, Blocks.END_BRICKS, 0, brickEndstoneSlab).setUnlocalizedName("brickEndstoneSlab_double");
		brickRednetherSlab_double = new BlockExtraSlabDouble(Material.ROCK, Blocks.NETHER_BRICK, 0, brickRednetherSlab).setUnlocalizedName("brickRednetherSlab_double");
		brickAcheriteSlab_double = new BlockExtraSlabDouble(Material.ROCK, moreStones3, 1, brickAcheriteSlab).setUnlocalizedName("brickAcheriteSlab_double");
			
		GameRegistry.registerBlock(cobbleGraniteSlab, ItemBlockExtraSlab.class, "cobbleGraniteSlab", cobbleGraniteSlab, cobbleGraniteSlab_double);
		GameRegistry.registerBlock(cobbleDioriteSlab, ItemBlockExtraSlab.class,"cobbleDioriteSlab" ,cobbleDioriteSlab, cobbleDioriteSlab_double);
		GameRegistry.registerBlock(cobbleAndesiteSlab, ItemBlockExtraSlab.class,"cobbleAndesiteSlab",cobbleAndesiteSlab, cobbleAndesiteSlab_double);
		GameRegistry.registerBlock(cobbleLimestoneSlab, ItemBlockExtraSlab.class,"cobbleLimestoneSlab",cobbleLimestoneSlab, cobbleLimestoneSlab_double);
		GameRegistry.registerBlock(cobbleMarbleSlab, ItemBlockExtraSlab.class,"cobbleMarbleSlab",cobbleMarbleSlab, cobbleMarbleSlab_double);
		GameRegistry.registerBlock(cobbleBasaltSlab, ItemBlockExtraSlab.class,"cobbleBasaltSlab",cobbleBasaltSlab, cobbleBasaltSlab_double);
		GameRegistry.registerBlock(cobbleSandstoneSlab,ItemBlockExtraSlab.class, "cobbleSandstoneSlab",cobbleSandstoneSlab, cobbleSandstoneSlab_double);
		GameRegistry.registerBlock(cobbleRedsandstoneSlab, ItemBlockExtraSlab.class,"cobbleRedsandstoneSlab",cobbleRedsandstoneSlab, cobbleRedsandstoneSlab_double);
		
		GameRegistry.registerBlock(brickGraniteSlab, ItemBlockExtraSlab.class, "brickGraniteSlab",brickGraniteSlab, brickGraniteSlab_double);
		GameRegistry.registerBlock(brickDioriteSlab, ItemBlockExtraSlab.class,"brickDioriteSlab",brickDioriteSlab, brickDioriteSlab_double);
		GameRegistry.registerBlock(brickAndesiteSlab, ItemBlockExtraSlab.class,"brickAndesiteSlab",brickAndesiteSlab, brickAndesiteSlab_double);
		GameRegistry.registerBlock(brickLimestoneSlab, ItemBlockExtraSlab.class,"brickLimestoneSlab",brickLimestoneSlab, brickLimestoneSlab_double);
		GameRegistry.registerBlock(brickMarbleSlab, ItemBlockExtraSlab.class,"brickMarbleSlab",brickMarbleSlab, brickMarbleSlab_double);
		GameRegistry.registerBlock(brickBasaltSlab, ItemBlockExtraSlab.class,"brickBasaltSlab",brickBasaltSlab, brickBasaltSlab_double);
		GameRegistry.registerBlock(brickSandstoneSlab, ItemBlockExtraSlab.class,"brickSandstoneSlab",brickSandstoneSlab, brickSandstoneSlab_double);
		GameRegistry.registerBlock(brickRedsandstoneSlab, ItemBlockExtraSlab.class,"brickRedsandstoneSlab",brickRedsandstoneSlab, brickRedsandstoneSlab_double);
		GameRegistry.registerBlock(brickNetherrackSlab,ItemBlockExtraSlab.class, "brickNetherrackSlab",brickNetherrackSlab, brickNetherrackSlab_double);
		GameRegistry.registerBlock(brickAgedbrickSlab, ItemBlockExtraSlab.class,"brickAgedbrickSlab",brickAgedbrickSlab, brickAgedbrickSlab_double);
		GameRegistry.registerBlock(brickCotswoldSlab, ItemBlockExtraSlab.class,"brickCotswoldSlab",brickCotswoldSlab, brickCotswoldSlab_double);
		GameRegistry.registerBlock(brickEndstoneSlab, ItemBlockExtraSlab.class,"brickEndstoneSlab",brickEndstoneSlab, brickEndstoneSlab_double);
		GameRegistry.registerBlock(brickRednetherSlab, ItemBlockExtraSlab.class,"brickRednetherSlab",brickRednetherSlab, brickRednetherSlab_double);
		GameRegistry.registerBlock(brickAcheriteSlab, ItemBlockExtraSlab.class,"brickAcheriteSlab",brickAcheriteSlab, brickAcheriteSlab_double);
		
		GameRegistry.register(cobbleGraniteSlab_double, new ResourceLocation(BBMod.MODID + ":cobbleGraniteSlab_double"));
		GameRegistry.register(cobbleDioriteSlab_double, new ResourceLocation(BBMod.MODID + ":cobbleDioriteSlab_double"));
		GameRegistry.register(cobbleAndesiteSlab_double, new ResourceLocation(BBMod.MODID + ":cobbleAndesiteSlab_double"));
		GameRegistry.register(cobbleLimestoneSlab_double, new ResourceLocation(BBMod.MODID + ":cobbleLimestoneSlab_double"));
		GameRegistry.register(cobbleMarbleSlab_double,  new ResourceLocation(BBMod.MODID + ":cobbleMarbleSlab_double"));
		GameRegistry.register(cobbleBasaltSlab_double, new ResourceLocation(BBMod.MODID + ":cobbleBasaltSlab_double"));
		GameRegistry.register(cobbleSandstoneSlab_double, new ResourceLocation(BBMod.MODID + ":cobbleSandstoneSlab_double"));
		GameRegistry.register(cobbleRedsandstoneSlab_double, new ResourceLocation(BBMod.MODID + ":cobbleRedsandstoneSlab_double"));
		
		GameRegistry.register(brickGraniteSlab_double, new ResourceLocation(BBMod.MODID + ":brickGraniteSlab_double"));
		GameRegistry.register(brickDioriteSlab_double, new ResourceLocation(BBMod.MODID + ":brickDioriteSlab_double"));
		GameRegistry.register(brickAndesiteSlab_double, new ResourceLocation(BBMod.MODID + ":brickAndesiteSlab_double"));
		GameRegistry.register(brickLimestoneSlab_double, new ResourceLocation(BBMod.MODID + ":brickLimestoneSlab_double"));
		GameRegistry.register(brickMarbleSlab_double, new ResourceLocation(BBMod.MODID + ":brickMarbleSlab_double"));
		GameRegistry.register(brickBasaltSlab_double, new ResourceLocation(BBMod.MODID + ":brickBasaltSlab_double"));
		GameRegistry.register(brickSandstoneSlab_double, new ResourceLocation(BBMod.MODID + ":brickSandstoneSlab_double"));
		GameRegistry.register(brickRedsandstoneSlab_double, new ResourceLocation(BBMod.MODID + ":brickRedsandstoneSlab_double"));
		GameRegistry.register(brickNetherrackSlab_double, new ResourceLocation(BBMod.MODID + ":brickNetherrackSlab_double"));
		GameRegistry.register(brickAgedbrickSlab_double,  new ResourceLocation(BBMod.MODID + ":brickAgedbrickSlab_double"));
		GameRegistry.register(brickCotswoldSlab_double, new ResourceLocation(BBMod.MODID + ":brickCotswoldSlab_double"));
		GameRegistry.register(brickEndstoneSlab_double, new ResourceLocation(BBMod.MODID + ":brickEndstoneSlab_double"));
		GameRegistry.register(brickRednetherSlab_double, new ResourceLocation(BBMod.MODID + ":brickRednetherSlab_double")); 
		GameRegistry.register(brickAcheriteSlab_double, new ResourceLocation(BBMod.MODID + ":brickAcheriteSlab_double")); 

		
		
	
	}
	
	

}
