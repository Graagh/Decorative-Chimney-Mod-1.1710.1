package com.DecorativeChimney.TileEntityRenders;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
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

    public void setTileEntityRenderer(TileEntityRenderer tileEntityRenderer)
    {
        super.setTileEntityRenderer(tileEntityRenderer);
        chimneyRenderer = this;
    }

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
				tileEntityRenderer.renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney1B.png"));
				break;
			case 1:
				tileEntityRenderer.renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney1BG.png"));
				break;
			case 2:
				tileEntityRenderer.renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney1BW.png"));
				break;
			case 3:
				tileEntityRenderer.renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney1GB.png"));
				break;
			case 4:
				tileEntityRenderer.renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney1G.png"));
				break;
			case 5:
				tileEntityRenderer.renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney1GW.png"));
				break;
			case 6:
				tileEntityRenderer.renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney1WB.png"));
				break;
			case 7:
				tileEntityRenderer.renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney1WG.png")); // and so on and so on
				break;
			case 8:
				tileEntityRenderer.renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney1W.png")); // bindTextureByName + the path to your image. for the block that you gave damage number 0
				break;
			case 9:
				tileEntityRenderer.renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney1NBr.png"));
				break;
			case 10:
				tileEntityRenderer.renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney1Br.png"));
				break;
			case 11:
				tileEntityRenderer.renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney1S.png"));
				break;
			case 12:
				tileEntityRenderer.renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney1CS.png"));
				break;
			case 13:
				tileEntityRenderer.renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney1E.png"));
				break;
			case 14:
				tileEntityRenderer.renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney1Go.png"));
				break;
			case 15:
				tileEntityRenderer.renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney1D.png"));
				break;
			case 16:
				tileEntityRenderer.renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney1SSS.png"));
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