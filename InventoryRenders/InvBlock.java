package com.DecorativeChimney.InventoryRenders;

import org.lwjgl.opengl.GL11;

import com.DecorativeChimney.DecorativeChimneyCore;
import com.DecorativeChimney.Blocks.BlockChimney1;
import com.DecorativeChimney.Blocks.BlockChimney2;
import com.DecorativeChimney.Blocks.BlockChimney3;
import com.DecorativeChimney.Blocks.BlockChimneyHollow;
import com.DecorativeChimney.Blocks.BlockMantelCenter;
import com.DecorativeChimney.Blocks.BlockMantelCorner;
import com.DecorativeChimney.Blocks.BlockMantelFoot;
import com.DecorativeChimney.Blocks.BlockMantelPlainSide;
import com.DecorativeChimney.Blocks.BlockMantelSide;
import com.DecorativeChimney.TileEntities.TileEntityChimney1;
import com.DecorativeChimney.TileEntities.TileEntityChimney3;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;


public class InvBlock implements ISimpleBlockRenderingHandler
{
    public InvBlock()
    {
    }
	
	public void renderInventoryBlock(Block block, int metaData, int modelId, RenderBlocks renderBlocks)
    {
        if (block.getRenderType() == DecorativeChimneyCore.blockHollowBricksModelID)
        {

    		renderBlocks.overrideBlockTexture = block.getIcon(modelId, metaData);
        	renderBlocks.setRenderBounds(0.0F, 0.0F, 0.0F, 0.125F, 1.0F, 1.0F);
            renderBlockItem(renderBlocks, block, metaData);

        	renderBlocks.setRenderBounds(0.875F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            renderBlockItem(renderBlocks, block, metaData);

        	renderBlocks.setRenderBounds(0.125F, 0.0F, 0.0F, 0.875F, 1.0F, 0.125F);
            renderBlockItem(renderBlocks, block, metaData);

        	renderBlocks.setRenderBounds(0.125F, 0.0F, 0.875F, 0.875F, 1.0F, 1.0F);
            renderBlockItem(renderBlocks, block, metaData);

            renderBlocks.clearOverrideBlockTexture();
            block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }
/*        if (block.getRenderType() == DecorativeChimneyCore.blockMantelCornerModelID)
        {
//1
        	renderBlocks.overrideBlockTexture = block.getIcon(6, metaData);
        	renderBlocks.setRenderBounds(0.0F, 0.9375F, 0.0F, 1.0F, 1.0F, 1.0F);
            renderBlockItem(renderBlocks, block, metaData);
//2
    		renderBlocks.setRenderBounds(0.0625F, 0.875F, 0.0625F, 0.9375F, 0.9375F, 0.9375F);
            renderBlockItem(renderBlocks, block, metaData);
//3
    		renderBlocks.setRenderBounds(0.125F, 0.75F, 0.125F, 0.875F, 0.875F, 0.875F);
            renderBlockItem(renderBlocks, block, metaData);
//4
    		renderBlocks.setRenderBounds(0.1875F, 0.6875F, 0.1875F, 0.8125F, 0.75F, 0.8125F);
            renderBlockItem(renderBlocks, block, metaData);
//5
        	renderBlocks.setRenderBounds(0.25F, 0.5625F, 0.25F, 0.75F, 0.6875F, 0.75F);
            renderBlockItem(renderBlocks, block, metaData);
//6
        	renderBlocks.setRenderBounds(0.25F, 0.3125F, 0.25F, 0.375F, 0.5625F, 0.375F);
            renderBlockItem(renderBlocks, block, metaData);
//7
        	renderBlocks.setRenderBounds(0.625F, 0.3125F, 0.25F, 0.75F, 0.5625F, 0.375F);
            renderBlockItem(renderBlocks, block, metaData);
//8
        	renderBlocks.setRenderBounds(0.625F, 0.3125F, 0.625F, 0.75F, 0.5625F, 0.75F);
            renderBlockItem(renderBlocks, block, metaData);
//9
        	renderBlocks.setRenderBounds(0.25F, 0.3125F, 0.625F, 0.375F, 0.5625F, 0.75F);
            renderBlockItem(renderBlocks, block, metaData);
//10
        	renderBlocks.setRenderBounds(0.25F, 0.1875F, 0.25F, 0.75F, 0.3125F, 0.75F);
            renderBlockItem(renderBlocks, block, metaData);
//11
        	renderBlocks.setRenderBounds(0.1875F, 0.125F, 0.1875F, 0.8125F, 0.1875F, 0.8125F);
            renderBlockItem(renderBlocks, block, metaData);
//12
        	renderBlocks.setRenderBounds(0.25F, 0.0F, 0.25F, 0.75F, 0.125F, 0.75F);
            renderBlockItem(renderBlocks, block, metaData);

            renderBlocks.overrideBlockTexture = block.getIcon(7, metaData);
        	renderBlocks.setRenderBounds(0.3125F, 0.3125F, 0.3125F, 0.6875F, 0.5625F, 0.6875F);
            renderBlockItem(renderBlocks, block, metaData);

            renderBlocks.clearOverrideBlockTexture();
            block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }*/
        if (block.getRenderType() == DecorativeChimneyCore.blockMantelCenterModelID)
        {

        	renderBlocks.overrideBlockTexture = block.getIcon(6, metaData);
        	renderBlocks.setRenderBounds(0.0F, 0.9375F, 0.0F, 1.0F, 1.0F, 1.0F);
            renderBlockItem(renderBlocks, block, metaData);
    		
			renderBlocks.setRenderBounds(0.0F, 0.875F, 0.0625F, 1.0F, 0.9375F, 0.9375F);
            renderBlockItem(renderBlocks, block, metaData);
    		
			renderBlocks.setRenderBounds(0.0F, 0.75F, 0.125F, 1.0F, 0.875F, 0.875F);
            renderBlockItem(renderBlocks, block, metaData);

			renderBlocks.setRenderBounds(0.0F, 0.6875F, 0.1875F, 1.0F, 0.75F, 0.8125F);
            renderBlockItem(renderBlocks, block, metaData);

			renderBlocks.setRenderBounds(0.9375F, 0.1875F, 0.3125F, 1.0F, 0.6875F, 0.6875F);
            renderBlockItem(renderBlocks, block, metaData);

			renderBlocks.setRenderBounds(0.0625F, 0.5625F, 0.3125F, 0.9375F, 0.6875F, 0.6875F);
            renderBlockItem(renderBlocks, block, metaData);

			renderBlocks.setRenderBounds(0.0F, 0.1875F, 0.3125F, 0.0625F, 0.6875F, 0.6875F);
            renderBlockItem(renderBlocks, block, metaData);

			renderBlocks.setRenderBounds(0.0625F, 0.1875F, 0.3125F, 0.9375F, 0.3125F, 0.6875F);
            renderBlockItem(renderBlocks, block, metaData);

			renderBlocks.setRenderBounds(0.0F, 0.125F, 0.25F, 1.0F, 0.1875F, 0.75F);
            renderBlockItem(renderBlocks, block, metaData);

            renderBlocks.overrideBlockTexture = block.getIcon(7, metaData);
			renderBlocks.setRenderBounds(0.0625F, 0.3125F, 0.375F, 0.9375F, 0.5625F, 0.625F);
            renderBlockItem(renderBlocks, block, metaData);

            renderBlocks.clearOverrideBlockTexture();
            block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }
        if (block.getRenderType() == DecorativeChimneyCore.blockMantelSideModelID)
        {

        	renderBlocks.overrideBlockTexture = block.getIcon(6, metaData);
    		renderBlocks.setRenderBounds(0.25F, 0.0F, 0.25F, 0.75F, 0.0625F, 0.75F);
            renderBlockItem(renderBlocks, block, metaData);

    		renderBlocks.setRenderBounds(0.25F, 0.0625F, 0.25F, 0.375F, 0.9375F, 0.375F);
            renderBlockItem(renderBlocks, block, metaData);

    		renderBlocks.setRenderBounds(0.25F, 0.0625F, 0.625F, 0.375F, 0.9375F, 0.75F);
            renderBlockItem(renderBlocks, block, metaData);

    		renderBlocks.setRenderBounds(0.625F, 0.0625F, 0.25F, 0.75F, 0.9375F, 0.375F);
            renderBlockItem(renderBlocks, block, metaData);

    		renderBlocks.setRenderBounds(0.625F, 0.0625F, 0.625F, 0.75F, 0.9375F, 0.75F);
            renderBlockItem(renderBlocks, block, metaData);

    		renderBlocks.setRenderBounds(0.25F, 0.9375F, 0.25F, 0.75F, 1.0F, 0.75F);
            renderBlockItem(renderBlocks, block, metaData);

            renderBlocks.overrideBlockTexture = block.getIcon(7, metaData);
    		renderBlocks.setRenderBounds(0.3125F, 0.0625F, 0.3125F, 0.6875F, 0.9375F, 0.6875F);
            renderBlockItem(renderBlocks, block, metaData);

            renderBlocks.clearOverrideBlockTexture();
            block.setBlockBounds(0.25F, 0.0F, 0.25F, 0.75F, 1.0F, 0.75F);
        }
        if (block.getRenderType() == DecorativeChimneyCore.blockMantelPlainSideModelID)
        {

        	renderBlocks.overrideBlockTexture = block.getIcon(modelId, metaData);
    		renderBlocks.setRenderBounds(0.3125F, 0.0F, 0.3125F, 0.6875F, 1.0F, 0.6875F);
            renderBlockItem(renderBlocks, block, metaData);

            renderBlocks.clearOverrideBlockTexture();
            block.setBlockBounds(0.25F, 0.0F, 0.25F, 0.75F, 1.0F, 0.75F);
        }
        if (block.getRenderType() == DecorativeChimneyCore.blockMantelFootModelID)
        {

        	renderBlocks.overrideBlockTexture = block.getIcon(6, metaData);
    		renderBlocks.setRenderBounds(0.25F, 0.625F, 0.25F, 0.75F, 1.0F, 0.75F);
            renderBlockItem(renderBlocks, block, metaData);

    		renderBlocks.setRenderBounds(0.1875F, 0.5F, 0.1875F, 0.8125F, 0.625F, 0.8125F);
            renderBlockItem(renderBlocks, block, metaData);

    		renderBlocks.setRenderBounds(0.1875F, 0.125F, 0.1875F, 0.3125F, 0.5F, 0.3125F);
            renderBlockItem(renderBlocks, block, metaData);

    		renderBlocks.setRenderBounds(0.1875F, 0.125F, 0.6875F, 0.3125F, 0.5F, 0.8125F);
            renderBlockItem(renderBlocks, block, metaData);

    		renderBlocks.setRenderBounds(0.6875F, 0.125F, 0.1875F, 0.8125F, 0.5F, 0.3125F);
            renderBlockItem(renderBlocks, block, metaData);

    		renderBlocks.setRenderBounds(0.6875F, 0.125F, 0.6875F, 0.8125F, 0.5F, 0.8125F);
            renderBlockItem(renderBlocks, block, metaData);

    		renderBlocks.setRenderBounds(0.1875F, 0.0F, 0.1875F, 0.8125F, 0.125F, 0.8125F);
            renderBlockItem(renderBlocks, block, metaData);

            renderBlocks.overrideBlockTexture = block.getIcon(7, metaData);
    		renderBlocks.setRenderBounds(0.25F, 0.125F, 0.25F, 0.75F, 0.5F, 0.75F);
            renderBlockItem(renderBlocks, block, metaData);

            renderBlocks.clearOverrideBlockTexture();
            block.setBlockBounds(0.25F, 0.0F, 0.25F, 0.75F, 1.0F, 0.75F);
        }
    }

    public static void renderBlockItem(RenderBlocks renderBlocks, Block block, int i)
    {
        Tessellator tessellator = Tessellator.instance;
        
        GL11.glPushMatrix();
        
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, -1F, 0.0F);
        renderBlocks.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, renderBlocks.getBlockIconFromSideAndMetadata(block, 0, i));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        renderBlocks.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, renderBlocks.getBlockIconFromSideAndMetadata(block, 1, i));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, -1F);
        renderBlocks.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, renderBlocks.getBlockIconFromSideAndMetadata(block, 2, i));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        renderBlocks.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, renderBlocks.getBlockIconFromSideAndMetadata(block, 3, i));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(-1F, 0.0F, 0.0F);
        renderBlocks.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, renderBlocks.getBlockIconFromSideAndMetadata(block, 4, i));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderBlocks.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, renderBlocks.getBlockIconFromSideAndMetadata(block, 5, i));
        tessellator.draw();
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
        
        GL11.glPopMatrix();
    }

	public boolean renderWorldBlock(IBlockAccess iblockAccess, int x, int y, int z, Block block, int modelId, RenderBlocks renderBlocks)
	{
		if (modelId == DecorativeChimneyCore.blockHollowBricksModelID)
		{
			return BlockChimneyHollow.renderHollowBricks(block, x, y, z, renderBlocks, iblockAccess);
		}

		if (modelId == DecorativeChimneyCore.blockMantelCornerModelID)
		{
			return BlockMantelCorner.renderMantelCorner(block, x, y, z, renderBlocks, iblockAccess);
		}
	        
		if (modelId == DecorativeChimneyCore.blockMantelCenterModelID)
		{
			return BlockMantelCenter.renderMantelCenter(block, x, y, z, renderBlocks, iblockAccess);
		}

		if (modelId == DecorativeChimneyCore.blockMantelSideModelID)
		{
			return BlockMantelSide.renderMantelSide(block, x, y, z, renderBlocks, iblockAccess);
		}

		if (modelId == DecorativeChimneyCore.blockMantelPlainSideModelID)
		{
			return BlockMantelPlainSide.renderMantelPlainSide(block, x, y, z, renderBlocks, iblockAccess);
		}

		if (modelId == DecorativeChimneyCore.blockMantelFootModelID)
		{
			return BlockMantelFoot.renderMantelFoot(block, x, y, z, renderBlocks, iblockAccess);
		}

		return false;
	}


	public boolean shouldRender3DInInventory(int modelId)
	{
		return true;
	}

	public int getRenderId()
	{
		return 0;
	}
}