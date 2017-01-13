package tschipp.buildingblocks.blocks.tileentity;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityConcreteTiles extends TileEntity
{

	protected int color1 = 16777215;
	protected int color2 = 16777215;


	@Override
	public void readFromNBT(NBTTagCompound tag) 
	{
		super.readFromNBT(tag);
		this.color1 = tag.getInteger("color1");
		this.color2 = tag.getInteger("color2");

	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound tag) 
	{
		if (tag == null) 
		{
			NBTTagCompound comp = new NBTTagCompound();
			comp.setInteger("color1", this.color1);
			comp.setInteger("color2", this.color2);
			return super.writeToNBT(comp);
		}
		else {
			tag.setInteger("color1", this.color1);
			tag.setInteger("color2", this.color2);
			return super.writeToNBT(tag);

		}

	}

	@Override
	public SPacketUpdateTileEntity getUpdatePacket()
	{
		NBTTagCompound tag = new NBTTagCompound();
		this.writeToNBT(tag);
		return new SPacketUpdateTileEntity(this.pos, 0, tag);
	}
	
	@Override
	public void onChunkUnload()
    {
		this.color1 = this.getTileData().getInteger("color1");
		this.color2 = this.getTileData().getInteger("color2");

    }

	@Override
	public void onDataPacket(net.minecraft.network.NetworkManager net, net.minecraft.network.play.server.SPacketUpdateTileEntity pkt)
	{
		
		readFromNBT(pkt.getNbtCompound());
		worldObj.markBlockRangeForRenderUpdate(this.pos, this.pos);

	}
	
	@Override
	public void onLoad()
    {
		worldObj.markBlockRangeForRenderUpdate(this.pos, this.pos);
		this.updateContainingBlockInfo();
		
    }

	

	@Override
	public NBTTagCompound getUpdateTag()
	{
		NBTTagCompound tag = new NBTTagCompound();
		this.writeToNBT(tag);
		return tag;
	}

	@Override
	public boolean receiveClientEvent(int id, int type)
	{
		return true;
	}
	
	public void markBlockForUpdate()
	{
		worldObj.markBlockRangeForRenderUpdate(this.pos, this.pos);
		this.markDirty();
	}



	public int getColor1() 
	{
		return this.color1;
	}
	
	public int getColor2() 
	{
		return this.color2;
	}

	public void setColor1(int color) 
	{
		this.color1 = color;
		this.markBlockForUpdate();
	}
	
	public void setColor2(int color) 
	{
		this.color2 = color;
		this.markBlockForUpdate();
	}


}
