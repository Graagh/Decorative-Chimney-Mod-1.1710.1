package com.DecorativeChimney.TileEntityRenders;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.DecorativeChimney.Models.ModelLogs;
import com.DecorativeChimney.TileEntities.TileEntityLogs;


public class TileEntityLogsRender extends TileEntitySpecialRenderer
{

	public TileEntityLogsRender()
	{
		model = new ModelLogs();
	}
	
	public void renderAModelAt(TileEntityLogs tileEntityLogs, double d, double d1, double d2, float f)
	{
		int i = tileEntityLogs.worldObj.getBlockMetadata(tileEntityLogs.xCoord, tileEntityLogs.yCoord, tileEntityLogs.zCoord);
		int j = 0;

		if (i == 0)
		{
			j = 180;
		}

		if (i == 1)
		{
			j = 90;
		}

		if (i == 2)
		{
			j = 0;
		}

		if (i == 3)
		{
			j = 270;
		}

		tileEntityRenderer.renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/LogModel.png")); //texture
		GL11.glPushMatrix(); //start
		GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F); //size
		GL11.glRotatef(j, 0.0F, 1.0F, 0.0F); //rotate based on metadata
		GL11.glScalef(1.0F, -1F, -1F); //if you read this comment out this line and you can see what happens
		model.renderModel(0.0625F); //renders and yes 0.0625 is a random number
		GL11.glPopMatrix(); //end
	}

	public void renderTileEntityAt(TileEntity tileEntity, double d, double d1, double d2, float f)
	{
		renderAModelAt((TileEntityLogs) tileEntity, d, d1, d2, f); //where to render
	}

	private ModelLogs model;
}