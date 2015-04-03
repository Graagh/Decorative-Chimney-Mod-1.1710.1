package com.DecorativeChimney.TileEntityRenders;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.DecorativeChimney.Models.ModelChimney2;
import com.DecorativeChimney.TileEntities.TileEntityChimney2;

public class TileEntityChimney2Render extends TileEntitySpecialRenderer
{
	private ModelChimney2 model = new ModelChimney2();
	
    public static TileEntityChimney2Render chimneyRenderer;

    public void renderAModelAt(TileEntityChimney2 tileEntityChimney2, double d, double d1, double d2, float f)
	{
        this.renderModelAt((float)d, (float)d1, (float)d2, tileEntityChimney2.getBlockMetadata() & 7, (float)(tileEntityChimney2.getChimneyRotation() * 360) / 16.0F, tileEntityChimney2.getChimneyType());
	}

	public void renderModelAt(float d, float d1, float d2, int metaData, float rotation, int damage)
	{
		int j = 0;

		switch (metaData)
		{
		case 0:
			j = 270;
			break;
		case 1:
			j = 180;
			break;
		case 2:
			j = 90;
			break;
		}
		switch (damage) // the good part. get's your block multiple textures
		{
			case 0:
			default:
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney1B.png"));
				break;
			case 1:
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney1BG.png"));
				break;
			case 2:
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney1BW.png"));
				break;
			case 3:
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney1GB.png"));
				break;
			case 4:
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney1G.png"));
				break;
			case 5:
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney1GW.png"));
				break;
			case 6:
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney1WB.png"));
				break;
			case 7:
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney1WG.png")); // and so on and so on
				break;
			case 8:
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney1W.png")); // bindTextureByName + the path to your image. for the block that you gave damage number 0
				break;
			case 9:
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney1NBr.png"));
				break;
			case 10:
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney1Br.png"));
				break;
			case 11:
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney1S.png"));
				break;
			case 12:
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney1CS.png"));
				break;
			case 13:
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney1E.png"));
				break;
			case 14:
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney1Go.png"));
				break;
			case 15:
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney1D.png"));
				break;
			case 16:
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney1SSS.png"));
				break;
		}
		
		GL11.glPushMatrix(); //start
        GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F); //size
		GL11.glRotatef(j, 0.0F, 1.0F, 0.0F); //rotate
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glScalef(1.0F, -1.0F, -1.0F);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
		model.renderModel(0.0625F); //model render 0.0625
		GL11.glPopMatrix(); //end

	}
	
	public void renderTileEntityAt(TileEntity tileEntity, double d, double d1, double d2, float f)
	{
		renderAModelAt((TileEntityChimney2) tileEntity, d, d1, d2, f); //where to render
	}
}