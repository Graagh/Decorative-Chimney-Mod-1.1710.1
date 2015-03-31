package com.DecorativeChimney.InventoryRenders;

import org.lwjgl.opengl.GL11;

import com.DecorativeChimney.DecorativeChimneyCore;
import com.DecorativeChimney.Models.ModelChimney2;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class ItemChimney2Render implements IItemRenderer
{
	protected ModelChimney2 model;
	
	public void texture(int damage)
	{
		switch (damage) // the good part. get's your block multiple textures
		{
			case 0:
			default:
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney1B.png")); // bindTextureByName + the path to your image. for the block that you gave damage number 0
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
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney1WG.png"));
				break;
			case 8:
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("decorativechimney:textures/Chimney1W.png"));
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
	}
		

	public ItemChimney2Render()
	{
		model = new ModelChimney2();
	}
	
	@Override
	public boolean handleRenderType(ItemStack itemStack, ItemRenderType itemRenderType)
	{
		switch(itemRenderType)
		{
			case EQUIPPED:
			case EQUIPPED_FIRST_PERSON:
			case ENTITY:
			case INVENTORY:
				 return true;
			default:
				return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType itemRenderType, ItemStack itemStack, ItemRendererHelper itemRenderHelper)
	{
		switch(itemRenderHelper)
		{
			case ENTITY_ROTATION:
			case ENTITY_BOBBING:
			case EQUIPPED_BLOCK:
			case BLOCK_3D:
				 return true;
			default:
				return false;
		}
	}


	public void renderItem(ItemRenderType itemRenderType, ItemStack itemStack, Object... data)
	{
		switch(itemRenderType)
		{
			case EQUIPPED:
				GL11.glPushMatrix();
				
				texture(itemStack.getItemDamage());
				
				GL11.glRotatef(90f, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(90f, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(90f, 0.0F, 0.0F, 1.0F);
				
				GL11.glTranslatef(0.5F, -1.875F, 0.5F);
				
				float scale = 1.0F;
				GL11.glScalef(scale, scale, scale);

				model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
				break;
			case EQUIPPED_FIRST_PERSON:
				GL11.glPushMatrix();

				texture(itemStack.getItemDamage());

				GL11.glRotatef(180f, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(0f, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(0f, 0.0F, 0.0F, 1.0F);

				GL11.glTranslatef(-0.5F, -2.05F, -0.70F);

				scale = 0.75F;
				GL11.glScalef(scale, scale, scale);

				model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
				break;
			case ENTITY:
				GL11.glPushMatrix();

				texture(itemStack.getItemDamage());

				GL11.glRotatef(90f, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(90f, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(90f, 0.0F, 0.0F, 1.0F);

				GL11.glTranslatef(0.0F, -0.675F, 0.0F);

				scale = 0.5F;
				GL11.glScalef(scale, scale, scale);

				model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
				break;
			case INVENTORY:
				GL11.glPushMatrix();

				texture(itemStack.getItemDamage());

				GL11.glRotatef(330f, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(45f, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(0f, 0.0F, 0.0F, 1.0F);

				GL11.glTranslatef(11.1F, 0.0F, 0.0F);
				
		        GL11.glDisable(GL11.GL_CULL_FACE);
		        
		        scale = 10.0F;
				GL11.glScalef(scale, scale, scale);

				model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
			default:
				break;
		}
	}
}