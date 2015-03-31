package com.DecorativeChimney.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelChimney3 extends ModelBase
{
	//fields
	
	ModelRenderer Top1;
	ModelRenderer Top2;
	ModelRenderer Top3;
	ModelRenderer Wall1;
	ModelRenderer Wall2;
	ModelRenderer Wall3;
	ModelRenderer Wall4;

		//Renders
		
	  public ModelChimney3()
	  {
		    textureWidth = 128;
		    textureHeight = 64;
		    
		      Top1 = new ModelRenderer(this, 1, 37);
		      Top1.addBox(0F, 0F, 0F, 18, 3, 18);
		      Top1.setRotationPoint(-9F, 21F, -9F);
		      Top1.setTextureSize(128, 64);
		      Top1.mirror = true;
		      setRotation(Top1, 0F, 0F, 0F);
		      Top2 = new ModelRenderer(this, 1, 18);
		      Top2.addBox(0F, 0F, 0F, 16, 1, 16);
		      Top2.setRotationPoint(-8F, 20F, -8F);
		      Top2.setTextureSize(128, 64);
		      Top2.mirror = true;
		      setRotation(Top2, 0F, 0F, 0F);
		      Top3 = new ModelRenderer(this, 1, 1);
		      Top3.addBox(0F, 0F, 0F, 14, 1, 14);
		      Top3.setRotationPoint(-7F, 19F, -7F);
		      Top3.setTextureSize(128, 64);
		      Top3.mirror = true;
		      setRotation(Top3, 0F, 0F, 0F);
		      Wall1 = new ModelRenderer(this, 45, 1);
		      Wall1.addBox(0F, 0F, 0F, 10, 5, 0);
		      Wall1.setRotationPoint(-5F, 19F, 5F);
		      Wall1.setTextureSize(128, 64);
		      Wall1.mirror = true;
		      setRotation(Wall1, 0F, 0F, 0F);
		      Wall2 = new ModelRenderer(this, 45, -9);
		      Wall2.addBox(0F, 0F, 0F, 0, 5, 10);
		      Wall2.setRotationPoint(-5F, 19F, -5F);
		      Wall2.setTextureSize(128, 64);
		      Wall2.mirror = true;
		      setRotation(Wall2, 0F, 0F, 0F);
		      Wall3 = new ModelRenderer(this, 45, 1);
		      Wall3.addBox(0F, 0F, 0F, 10, 5, 0);
		      Wall3.setRotationPoint(-5F, 19F, -5F);
		      Wall3.setTextureSize(128, 64);
		      Wall3.mirror = true;
		      setRotation(Wall3, 0F, 0F, 0F);
		      Wall4 = new ModelRenderer(this, 45, -9);
		      Wall4.addBox(0F, 0F, 0F, 0, 5, 10);
		      Wall4.setRotationPoint(5F, 19F, -5F);
		      Wall4.setTextureSize(128, 64);
		      Wall4.mirror = true;
		      setRotation(Wall4, 0F, 0F, 0F);
	  }
	  
	  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	    Top1.render(f5);
	    Top2.render(f5);
	    Top3.render(f5);
	    Wall1.render(f5);
	    Wall2.render(f5);
	    Wall3.render(f5);
	    Wall4.render(f5);
	  }

	public void renderModel(float f5){
		Top1.render(f5);
		Top2.render(f5);
		Top3.render(f5);
	    Wall1.render(f5);
	    Wall2.render(f5);
	    Wall3.render(f5);
	    Wall4.render(f5);
	}

	private void setRotation(ModelRenderer modelRender, float x, float y, float z)
	{
		modelRender.rotateAngleX = x;
		modelRender.rotateAngleY = y;
		modelRender.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}
}