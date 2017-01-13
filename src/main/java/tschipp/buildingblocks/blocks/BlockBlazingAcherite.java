package tschipp.buildingblocks.blocks;

import java.util.Random;

import tschipp.buildingblocks.BBMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class BlockBlazingAcherite extends Block {
	
	public BlockBlazingAcherite() {

		super(Material.ROCK);
		this.setCreativeTab(BBMod.buildingBlocks);
		this.setHardness(1.8F);
        this.setLightLevel(0.4F);
		this.setResistance(10F);
        this.setTickRandomly(true);
       


	}
	
	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn)
    {
        if (!entityIn.isImmuneToFire() && entityIn instanceof EntityLivingBase && !EnchantmentHelper.hasFrostWalkerEnchantment((EntityLivingBase)entityIn))
        {
            entityIn.attackEntityFrom(DamageSource.inFire, 1.0F + ((float)this.RANDOM.nextInt(2)));
        }

        super.onEntityWalk(worldIn, pos, entityIn);
    }
	
	@Override
    public void updateTick(World worldIn, BlockPos blockpos, IBlockState state, Random rand)
    {
        ((WorldServer)worldIn).spawnParticle(EnumParticleTypes.SMOKE_LARGE, (double)blockpos.getX() + 0.5D, (double)blockpos.getY() + 0.25D, (double)blockpos.getZ() + 0.5D, 8, 0.5D, 0.25D, 0.5D, 0.0D, new int[0]);

    }


}
