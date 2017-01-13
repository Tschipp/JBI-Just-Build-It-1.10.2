package tschipp.buildingblocks.items;

import tschipp.buildingblocks.BBMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class ItemRenderRegister {
	
	
	public static void reg(Item item) {
		
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		renderItem.getItemModelMesher().register(item, 0, new ModelResourceLocation(BBMod.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
		
	}
	
	
	public static void registerItems() {
		
		reg(BBItems.pebbles);
		
		
	}

}
