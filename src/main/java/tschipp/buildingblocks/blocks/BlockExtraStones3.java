package tschipp.buildingblocks.blocks;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tschipp.buildingblocks.BBMod;



public class BlockExtraStones3 extends Block implements IMetaBlockName{




	public static final PropertyEnum<BlockExtraStones3.EnumType> VARIANT = PropertyEnum.<BlockExtraStones3.EnumType>create("variant", BlockExtraStones3.EnumType.class);


	public BlockExtraStones3() {


		super(Material.ROCK);
		this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockExtraStones3.EnumType.ACHERITE));
		this.setCreativeTab(BBMod.buildingBlocks);
		this.setHardness(1.8F);
		this.setResistance(10F);



	}

	@Nullable
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Item.getItemFromBlock(this);

	}



	@Override
	public int damageDropped(IBlockState state)
	{
		switch(state.getValue(VARIANT)) 
		{
		default:
			return (state.getValue(VARIANT)).getMetadata();
		}


	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player)
	{
		return new ItemStack(this, 1, this.getMetaFromState(state));
	}


	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(VARIANT, BlockExtraStones3.EnumType.byMetadata(meta));
	}

	/**
	 * Convert the BlockState into the correct metadata value
	 */
	@Override
	public int getMetaFromState(IBlockState state)
	{
		return ((BlockExtraStones3.EnumType)state.getValue(VARIANT)).getMetadata();
	}

	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {VARIANT});
	}

	@Override
	public MapColor getMapColor(IBlockState state)
	{
		return ((BlockExtraStones3.EnumType)state.getValue(VARIANT)).getMapColor();
	}


	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list)
	{
		for (BlockExtraStones3.EnumType blockstone$enumtype : BlockExtraStones3.EnumType.values())
		{
			list.add(new ItemStack(itemIn, 1, blockstone$enumtype.getMetadata()));
		}
	}


	public static enum EnumType implements IStringSerializable
	{
		ACHERITE(0, MapColor.ADOBE, "acherite"),
		ACHERITE_BRICKS(1, MapColor.ADOBE, "acherite_bricks"),
		ACHERITE_SMOOTH(2, MapColor.ADOBE, "acherite_smooth");


		/** Array of the Block's BlockStates */
		private static final BlockExtraStones3.EnumType[] META = new BlockExtraStones3.EnumType[values().length];
		/** The BlockState's metadata. */
		private final int meta;
		/** The EnumType's name. */
		private final String name;
		private final String unlocalizedName;
		private final MapColor mapColor;

		private EnumType(int i, MapColor color, String name)
		{
			this(i, color, name, name);
		}

		private EnumType(int meta, MapColor color, String name, String name2)
		{
			this.meta = meta;
			this.name = name;
			this.unlocalizedName = name2;
			this.mapColor = color;
		}

		/**
		 * Returns the EnumType's metadata value.
		 */
		public int getMetadata()
		{
			return this.meta;
		}

		public MapColor getMapColor()
		{
			return this.mapColor;
		}

		public String toString()
		{
			return this.name;
		}

		/**
		 * Returns an EnumType for the BlockState from a metadata value.
		 */
		public static BlockExtraStones3.EnumType byMetadata(int meta)
		{
			if (meta < 0 || meta >= META.length)
			{
				meta = 0;
			}

			return META[meta];
		}

		public String getName()
		{
			return this.name;
		}

		public String getUnlocalizedName()
		{
			return this.unlocalizedName;
		}

		static
		{
			for (BlockExtraStones3.EnumType blockstone$enumtype : values())
			{
				META[blockstone$enumtype.getMetadata()] = blockstone$enumtype;
			}
		}


	}


	@Override
	public String getSpecialName(ItemStack stack) {
		switch(stack.getMetadata()) {

		case 0:
			return "acherite";
		case 1:
			return "acheriteBricks";
		case 2:
			return "acheriteSmooth";
		default:
			return null;

		}






	}


}




