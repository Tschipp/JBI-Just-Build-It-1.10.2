package tschipp.buildingblocks.blocks;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import tschipp.buildingblocks.BBMod;

public class BlockRenderRegister {

	static RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

	public static void registerBlocks()
	{

		// Registering Basic Blocks
		reg(BBBlocks.agedBricks);
		reg(BBBlocks.moreStones);
		reg(BBBlocks.cotswoldBricks);
		reg(BBBlocks.moreStones2);
		reg(BBBlocks.concreteDyeable);
		reg(BBBlocks.gravelGrass);
		reg(BBBlocks.overgrowth);
		reg(BBBlocks.blazingAcherite);
		reg(BBBlocks.concreteTiles);
		//reg(BBBlocks.bush);

		// Registering Special Blocks (With Meta)
		regSpecial(BBBlocks.moreStones, 0, "granite_cobblestone");
		regSpecial(BBBlocks.moreStones, 1, "granite_bricks");
		regSpecial(BBBlocks.moreStones, 2, "diorite_cobblestone");
		regSpecial(BBBlocks.moreStones, 3, "diorite_bricks");
		regSpecial(BBBlocks.moreStones, 4, "andesite_cobblestone");
		regSpecial(BBBlocks.moreStones, 5, "andesite_bricks");
		regSpecial(BBBlocks.moreStones, 6, "limestone");
		regSpecial(BBBlocks.moreStones, 7, "limestone_cobblestone");
		regSpecial(BBBlocks.moreStones, 8, "limestone_bricks");
		regSpecial(BBBlocks.moreStones, 9, "limestone_smooth");
		regSpecial(BBBlocks.moreStones, 10, "marble");
		regSpecial(BBBlocks.moreStones, 11, "marble_cobblestone");
		regSpecial(BBBlocks.moreStones, 12, "marble_bricks");
		regSpecial(BBBlocks.moreStones, 13, "marble_smooth");
		regSpecial(BBBlocks.moreStones, 14, "sandstone");
		regSpecial(BBBlocks.moreStones, 15, "sandstone_cobblestone");

		regSpecial(BBBlocks.moreStones2, 0, "sandstone_bricks");
		regSpecial(BBBlocks.moreStones2, 1, "sandstone_smooth");
		regSpecial(BBBlocks.moreStones2, 2, "basalt");
		regSpecial(BBBlocks.moreStones2, 3, "basalt_cobblestone");
		regSpecial(BBBlocks.moreStones2, 4, "basalt_bricks");
		regSpecial(BBBlocks.moreStones2, 5, "basalt_smooth");
		regSpecial(BBBlocks.moreStones2, 6, "red_sandstone");
		regSpecial(BBBlocks.moreStones2, 7, "red_sandstone_cobblestone");
		regSpecial(BBBlocks.moreStones2, 8, "red_sandstone_bricks");
		regSpecial(BBBlocks.moreStones2, 9, "red_sandstone_smooth");
		regSpecial(BBBlocks.moreStones2, 10, "netherrack_bricks");
		regSpecial(BBBlocks.moreStones2, 11, "netherrack_smooth");
		regSpecial(BBBlocks.moreStones2, 12, "stone_smooth");
		regSpecial(BBBlocks.moreStones2, 13, "endstone_smooth");
		regSpecial(BBBlocks.moreStones2, 14, "concrete_wet");
		regSpecial(BBBlocks.moreStones2, 15, "concrete_dry");
		
		regSpecial(BBBlocks.moreStones3, 0, "acherite");
		regSpecial(BBBlocks.moreStones3, 1, "acherite_bricks");
		regSpecial(BBBlocks.moreStones3, 2, "acherite_smooth");


		// Registering Stair Blocks
		regStair(BBBlocks.cobbleAndesiteStair);
		regStair(BBBlocks.cobbleGraniteStair);
		regStair(BBBlocks.cobbleDioriteStair);
		regStair(BBBlocks.cobbleMarbleStair);
		regStair(BBBlocks.cobbleLimestoneStair);
		regStair(BBBlocks.cobbleSandstoneStair);
		regStair(BBBlocks.cobbleBasaltStair);
		regStair(BBBlocks.cobbleRedsandstoneStair);

		regStair(BBBlocks.brickAndesiteStair);
		regStair(BBBlocks.brickGraniteStair);
		regStair(BBBlocks.brickDioriteStair);
		regStair(BBBlocks.brickMarbleStair);
		regStair(BBBlocks.brickLimestoneStair);
		regStair(BBBlocks.brickSandstoneStair);
		regStair(BBBlocks.brickBasaltStair);
		regStair(BBBlocks.brickRedsandstoneStair);
		regStair(BBBlocks.brickRednetherStair);
		regStair(BBBlocks.brickEndstoneStair);
		regStair(BBBlocks.brickNetherrackStair);
		regStair(BBBlocks.brickCotswoldStair);
		regStair(BBBlocks.brickAgedbrickStair);
		regStair(BBBlocks.brickAcheriteStair);

		// Registering all Slabs
		regSlab(BBBlocks.cobbleAndesiteSlab);
		regSlab(BBBlocks.cobbleGraniteSlab);
		regSlab(BBBlocks.cobbleDioriteSlab);
		regSlab(BBBlocks.cobbleMarbleSlab);
		regSlab(BBBlocks.cobbleLimestoneSlab);
		regSlab(BBBlocks.cobbleSandstoneSlab);
		regSlab(BBBlocks.cobbleBasaltSlab);
		regSlab(BBBlocks.cobbleRedsandstoneSlab);

		regSlab(BBBlocks.brickAndesiteSlab);
		regSlab(BBBlocks.brickGraniteSlab);
		regSlab(BBBlocks.brickDioriteSlab);
		regSlab(BBBlocks.brickMarbleSlab);
		regSlab(BBBlocks.brickLimestoneSlab);
		regSlab(BBBlocks.brickSandstoneSlab);
		regSlab(BBBlocks.brickBasaltSlab);
		regSlab(BBBlocks.brickRedsandstoneSlab);
		regSlab(BBBlocks.brickRednetherSlab);
		regSlab(BBBlocks.brickEndstoneSlab);
		regSlab(BBBlocks.brickNetherrackSlab);
		regSlab(BBBlocks.brickCotswoldSlab);
		regSlab(BBBlocks.brickAgedbrickSlab);
		regSlab(BBBlocks.brickAcheriteSlab);

	}

	/**
	 * Registers a normal Block
	 * 
	 * @param block
	 */
	public static void reg(Block block)
	{
		renderItem.getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(BBMod.MODID + ":" + block.getUnlocalizedName().substring(5), "inventory"));
		
	}

	/**
	 * Registers Render for a special Block (usually with Metadata)
	 * 
	 * @param block
	 * @param meta
	 * @param name
	 */

	public static void regSpecial(Block block, int meta, String name)
	{

		renderItem.getItemModelMesher().register(Item.getItemFromBlock(block), meta, new ModelResourceLocation(BBMod.MODID + ":" + name, "inventory"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(block), new ResourceLocation(BBMod.MODID + ":" + name));
		
	}

	/**
	 * Registers Render for a stair Block
	 * 
	 * @param block
	 */
	public static void regStair(Block block)
	{

		renderItem.getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(BBMod.MODID + ":stair/" + block.getUnlocalizedName().substring(5), "inventory"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(block), new ModelResourceLocation(BBMod.MODID + ":stair/" + block.getUnlocalizedName().substring(5), "inventory"));

	}

	/**
	 * Registers Render for a slab Block
	 * 
	 * @param block
	 */
	public static void regSlab(Block block)
	{
		ModelBakery.registerItemVariants(Item.getItemFromBlock(block), new ModelResourceLocation(BBMod.MODID + ":slab/" + block.getUnlocalizedName().substring(5), "inventory"));
		renderItem.getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(BBMod.MODID + ":slab/" + block.getUnlocalizedName().substring(5), "inventory"));

	}

}
