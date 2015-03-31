package com.DecorativeChimney;

import com.DecorativeChimney.InventoryRenders.InvBlock;
import com.DecorativeChimney.InventoryRenders.ItemChimney1Render;
import com.DecorativeChimney.InventoryRenders.ItemChimney2Render;
import com.DecorativeChimney.Models.ModelChimney1;
import com.DecorativeChimney.Models.ModelChimney2;
import com.DecorativeChimney.TileEntityRenders.*;

import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerRenderers()
	{
	}

	public void preInitLoading()
    {
    }

    public void initRenders()
    {
		DecorativeChimneyCore.blockHollowBricksModelID = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(DecorativeChimneyCore.blockHollowBricksModelID, new InvBlock());
        
		DecorativeChimneyCore.blockMantelCornerModelID = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(DecorativeChimneyCore.blockMantelCornerModelID, new InvBlock());
        
		DecorativeChimneyCore.blockMantelCenterModelID = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(DecorativeChimneyCore.blockMantelCenterModelID, new InvBlock());
        
		DecorativeChimneyCore.blockMantelSideModelID = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(DecorativeChimneyCore.blockMantelSideModelID, new InvBlock());
        
		DecorativeChimneyCore.blockMantelPlainSideModelID = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(DecorativeChimneyCore.blockMantelPlainSideModelID, new InvBlock());
        
		DecorativeChimneyCore.blockMantelFootModelID = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(DecorativeChimneyCore.blockMantelFootModelID, new InvBlock());
        
		DecorativeChimneyCore.blockChimney1ModelID = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(DecorativeChimneyCore.blockChimney1ModelID, new InvBlock());
        
		DecorativeChimneyCore.blockChimney2ModelID = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(DecorativeChimneyCore.blockChimney2ModelID, new InvBlock());
        
		DecorativeChimneyCore.blockChimney3ModelID = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(DecorativeChimneyCore.blockChimney3ModelID, new InvBlock());
        
        ClientRegistry.bindTileEntitySpecialRenderer(com.DecorativeChimney.TileEntities.TileEntityLogs.class, new TileEntityLogsRender());
        ClientRegistry.bindTileEntitySpecialRenderer(com.DecorativeChimney.TileEntities.TileEntityChimney1.class, new TileEntityChimney1Render());
        ClientRegistry.bindTileEntitySpecialRenderer(com.DecorativeChimney.TileEntities.TileEntityChimney2.class, new TileEntityChimney2Render());
        ClientRegistry.bindTileEntitySpecialRenderer(com.DecorativeChimney.TileEntities.TileEntityChimney3.class, new TileEntityChimney3Render());
    }	
}