package tschipp.buildingblocks.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import tschipp.buildingblocks.BBMod;
import tschipp.buildingblocks.blocks.tileentity.TileEntityPaintingMachine;
import tschipp.buildingblocks.container.ContainerPaintingMachine;

public class GuiPaintingMachine extends GuiContainer {
	
	private static final ResourceLocation texture = new ResourceLocation(BBMod.MODID + ":textures/gui/paintingMachine.png");

	
	public GuiPaintingMachine(InventoryPlayer player, TileEntityPaintingMachine machine) 
	{
		super(new ContainerPaintingMachine(player, machine));
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		GL11.glColor4f(1.0F, 1f, 1f, 1f);
		this.mc.getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y) 
	{
		this.fontRendererObj.drawString("Painting Machine", x, y, 4210752);
	}

}
