package tschipp.buildingblocks.util;

import java.util.Random;

import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import tschipp.buildingblocks.blocks.BlockExtraStones;
import tschipp.buildingblocks.blocks.BlockExtraStones2;
import tschipp.buildingblocks.blocks.BBBlocks;

public class WorldGenStones implements IWorldGenerator{

	private WorldGenerator genMarble;
	private WorldGenerator genLimestone;
	private WorldGenerator genBasalt;
	private WorldGenerator genAcherite;


	public WorldGenStones() {
		this.genMarble = new WorldGenMinable(BBBlocks.moreStones.getDefaultState().withProperty(BlockExtraStones.VARIANT, BlockExtraStones.EnumType.MARBLE), 22);
		this.genLimestone = new WorldGenMinable(BBBlocks.moreStones.getDefaultState().withProperty(BlockExtraStones.VARIANT, BlockExtraStones.EnumType.LIMESTONE), 25);
		this.genBasalt = new WorldGenMinable(BBBlocks.moreStones2.getDefaultState().withProperty(BlockExtraStones2.VARIANT, BlockExtraStones2.EnumType.BASALT), 13);
		this.genAcherite = new WorldGenMinable(BBBlocks.blazingAcherite.getDefaultState(), 25, BlockMatcher.forBlock(Blocks.NETHERRACK));
	}

	
	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {

		switch (world.provider.getDimension()) {
		case 0:
			
			this.runGenerator(this.genMarble, world, rand, chunkX, chunkZ, 10, 60, 180);
			this.runGenerator(this.genLimestone, world, rand, chunkX, chunkZ, 13, 10, 75);
			this.runGenerator(this.genBasalt, world, rand, chunkX, chunkZ, 400, 1, 15);
			break;
			
		case -1:
			this.runGenerator(this.genAcherite, world, rand, chunkX, chunkZ, 10, 1, 80);
			
		default:
			break;


		}

	}


	private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
		if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
			throw new IllegalArgumentException("Wrong Height Arguments");

		int heightDiff = maxHeight - minHeight + 1;
		for (int i = 0; i < chancesToSpawn; i ++) {
			int x = chunk_X * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunk_Z * 16 + rand.nextInt(16);
			BlockPos pos = new BlockPos(x,y,z);
			generator.generate(world, rand, pos);
			
		}
	}



}
