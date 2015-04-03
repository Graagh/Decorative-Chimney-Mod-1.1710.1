package com.DecorativeChimney.TileEntityRenders;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.DecorativeChimney.Models.ModelChimney3;
import com.DecorativeChimney.TileEntities.TileEntityChimney3;


public class TileEntityChimney3Render extends TileEntitySpecialRenderer
{
	private ModelChimney3 model = new ModelChimney3();
	
    public static TileEntityChimney3Render chimneyRenderer;

    public void renderAModelAt(TileEntityChimney3 tileEntityChimney3, double d, double d1, double d2, float f)
	{
        this.renderModelAt((float)d, (float)d1, (float)d2, tileEntityChimney3.getBlockMetadata() & 7, (float)(tileEntityChimney3.getChimneyRotation() * 360) / 4.0F, tileEntityChimney3.getChimneyType());
	}

	public void renderModelAt(float d, float d1, float d2, int metaData, float rotation, int damage)
	{
		switch (damage) // the good part. get's your block multiple textures
		{
			case 0:
			default:
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney3B.png"));
				break;
			case 1:
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney3G.png"));
				break;
			case 2:
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney3W.png"));
				break;
			case 3:
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney3LB.png"));
				break;
			case 4:
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney3SB.png"));
				break;
			case 5:
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney3LG.png"));
				break;
			case 6:
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney3SG.png"));
				break;
			case 7:
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney3S.png")); // and so on and so on
				break;
			case 8:
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney3CS.png")); // bindTextureByName + the path to your image. for the block that you gave damage number 0
				break;
			case 9:
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney3LW.png"));
				break;
			case 10:
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney3SW.png"));
				break;
			case 11:
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney3NBr.png"));
				break;
			case 12:
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney3Br.png"));
				break;
			case 13:
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney3E.png"));
				break;
			case 14:
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney3Go.png"));
				break;
			case 15:
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney3D.png"));
				break;
			case 16:
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney3SSS.png"));
				break;
		}
		
		GL11.glPushMatrix(); //start
        GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F); //size
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glScalef(1.0F, -1.0F, -1.0F); //if you read this comment out this line and you can see what happens
        GL11.glEnable(GL11.GL_ALPHA_TEST);
		model.renderModel(0.0625F); //renders and yes 0.0625 is a random number
		GL11.glPopMatrix(); //end

	}
	
	public void renderTileEntityAt(TileEntity tileEntity, double d, double d1, double d2, float f)
	{
		renderAModelAt((TileEntityChimney3) tileEntity, d, d1, d2, f); //where to render
	}
}