package tschipp.buildingblocks.blocks.tileentity;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityConcrete extends TileEntity
{

	protected int color = 16777215;

	@Override
	public void readFromNBT(NBTTagCompound tag) 
	{
		super.readFromNBT(tag);
		this.color = tag.getInteger("color");

	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound tag) 
	{
		if (tag == null) 
		{
			NBTTagCompound comp = new NBTTagCompound();
			comp.setInteger("color", this.color);
			return super.writeToNBT(comp);
		}
		else {
			tag.setInteger("color", this.color);
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
		this.color = this.getTileData().getInteger("color");
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



	public int getColor() 
	{
		return this.color;
	}

	public void setColor(int color) 
	{
		this.color = color;
		this.markBlockForUpdate();
	}


}
