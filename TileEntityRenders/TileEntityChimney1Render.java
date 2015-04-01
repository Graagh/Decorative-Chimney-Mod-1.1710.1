package com.DecorativeChimney.TileEntityRenders;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.DecorativeChimney.Models.ModelChimney1;
import com.DecorativeChimney.TileEntities.TileEntityChimney1;

public class TileEntityChimney1Render extends TileEntitySpecialRenderer
{
	private ModelChimney1 model = new ModelChimney1();
	
    public static TileEntityChimney1Render chimneyRenderer;

/*    public void setTileEntityRenderer(TileEntityRenderer tileEntityRenderer)
    {
        super.setTileEntityRenderer(tileEntityRenderer);
        chimneyRenderer = this;
    }*/

    public void renderAModelAt(TileEntityChimney1 tileEntityChimney1, double d, double d1, double d2, float f)
	{
        this.renderModelAt((float)d, (float)d1, (float)d2, tileEntityChimney1.getBlockMetadata() & 7, (float)(tileEntityChimney1.getChimneyRotation() * 360) / 4.0F, tileEntityChimney1.getChimneyType());
	}

	public void renderModelAt(float d, float d1, float d2, int metaData, float rotation, int damage)
	{
		switch (damage) // the good part. get's your block multiple textures
		{
			case 0:
			default:
				new ResourceLocation("decorativechimney:textures/Chimney1B.png");
				break;
			case 1:
				new ResourceLocation("decorativechimney:textures/Chimney1BG.png");
				break;
			case 2:
				new ResourceLocation("decorativechimney:textures/Chimney1BW.png");
				break;
			case 3:
				new ResourceLocation("decorativechimney:textures/Chimney1GB.png");
				break;
			case 4:
				new ResourceLocation("decorativechimney:textures/Chimney1G.png");
				break;
			case 5:
				new ResourceLocation("decorativechimney:textures/Chimney1GW.png");
				break;
			case 6:
				new ResourceLocation("decorativechimney:textures/Chimney1WB.png");
				break;
			case 7:
				new ResourceLocation("decorativechimney:textures/Chimney1WG.png"); // and so on and so on
				break;
			case 8:
				new ResourceLocation("decorativechimney:textures/Chimney1W.png"); // bindTextureByName + the path to your image. for the block that you gave damage number 0
				break;
			case 9:
				new ResourceLocation("decorativechimney:textures/Chimney1NBr.png");
				break;
			case 10:
				new ResourceLocation("decorativechimney:textures/Chimney1Br.png");
				break;
			case 11:
				new ResourceLocation("decorativechimney:textures/Chimney1S.png");
				break;
			case 12:
				new ResourceLocation("decorativechimney:textures/Chimney1CS.png");
				break;
			case 13:
				new ResourceLocation("decorativechimney:textures/Chimney1E.png");
				break;
			case 14:
				new ResourceLocation("decorativechimney:textures/Chimney1Go.png");
				break;
			case 15:
				new ResourceLocation("decorativechimney:textures/Chimney1D.png");
				break;
			case 16:
				new ResourceLocation("decorativechimney:textures/Chimney1SSS.png");
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
		renderAModelAt((TileEntityChimney1) tileEntity, d, d1, d2, f); //where to render
	}
}