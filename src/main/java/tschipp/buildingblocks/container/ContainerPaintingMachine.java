package tschipp.buildingblocks.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.inventory.SlotFurnaceOutput;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import tschipp.buildingblocks.blocks.BBBlocks;
import tschipp.buildingblocks.blocks.tileentity.TileEntityPaintingMachine;

public class ContainerPaintingMachine extends Container {
	
	private TileEntityPaintingMachine paintingMachine;
	protected World world;
	protected BlockPos pos;
	
	public ContainerPaintingMachine(InventoryPlayer player, TileEntityPaintingMachine machine)
	{
		this.paintingMachine = machine;
		this.world = machine.getWorld();
		this.pos = machine.getPos();
		
		this.addSlotToContainer(new SlotFurnaceOutput(player.player, machine, 3, 50, 50));
		this.addSlotToContainer(new Slot(machine, 0, 45, 20));
		this.addSlotToContainer(new Slot(machine, 1, 50, 20));
		this.addSlotToContainer(new Slot(machine, 2, 55, 20));
		this.addSlotToContainer(new Slot(machine, 4, 30, 20));
		
	}
	
	@Override
	public void onContainerClosed(EntityPlayer player) {
		super.onContainerClosed(player);
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return 
		player.getDistanceSq(this.pos) <= 64.0d;	
	}
	
	/*@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex) 
	{
		ItemStack stack = null;
		
		
	} */

}
