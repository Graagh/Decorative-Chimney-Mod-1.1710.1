package com.DecorativeChimney.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelChimney2 extends ModelBase
{
	//fields
	
    ModelRenderer Base1;
    ModelRenderer Base2;
    ModelRenderer Base3;
    ModelRenderer Top1;
    ModelRenderer Top2;
    ModelRenderer Top3;
    ModelRenderer Top4;
    ModelRenderer Top5;
    ModelRenderer Top6;
    ModelRenderer Top7;
    ModelRenderer Top8;

		//Renders
		
	public ModelChimney2()
	{
	    textureWidth = 128;
	    textureHeight = 64;
	    
	      Base1 = new ModelRenderer(this, 1, 37);
	      Base1.addBox(0F, 0F, 0F, 18, 3, 18);
	      Base1.setRotationPoint(-9F, 21F, -9F);
	      Base1.setTextureSize(128, 64);
	      Base1.mirror = true;
	      setRotation(Base1, 0F, 0F, 0F);
	      Base2 = new ModelRenderer(this, 1, 18);
	      Base2.addBox(0F, 0F, 0F, 16, 1, 16);
	      Base2.setRotationPoint(-8F, 20F, -8F);
	      Base2.setTextureSize(128, 64);
	      Base2.mirror = true;
	      setRotation(Base2, 0F, 0F, 0F);
	      Base3 = new ModelRenderer(this, 1, 1);
	      Base3.addBox(0F, 0F, 0F, 14, 1, 14);
	      Base3.setRotationPoint(-7F, 19F, -7F);
	      Base3.setTextureSize(128, 64);
	      Base3.mirror = true;
	      setRotation(Base3, 0F, 0F, 0F);
	      Top1 = new ModelRenderer(this, 45, 5);
	      Top1.addBox(0F, 0F, 0F, 4, 7, 1);
	      Top1.setRotationPoint(-5F, 12F, -2.5F);
	      Top1.setTextureSize(128, 64);
	      Top1.mirror = true;
	      setRotation(Top1, 0F, 0F, 0F);
	      Top2 = new ModelRenderer(this, 56, 2);
	      Top2.addBox(0F, 0F, 0F, 1, 7, 4);
	      Top2.setRotationPoint(-2F, 12F, -1.5F);
	      Top2.setTextureSize(128, 64);
	      Top2.mirror = true;
	      setRotation(Top2, 0F, 0F, 0F);
	      Top3 = new ModelRenderer(this, 45, 5);
	      Top3.addBox(0F, 0F, 0F, 4, 7, 1);
	      Top3.setRotationPoint(-6F, 12F, 1.5F);
	      Top3.setTextureSize(128, 64);
	      Top3.mirror = true;
	      setRotation(Top3, 0F, 0F, 0F);
	      Top4 = new ModelRenderer(this, 56, 2);
	      Top4.addBox(0F, 0F, 0F, 1, 7, 4);
	      Top4.setRotationPoint(-6F, 12F, -2.5F);
	      Top4.setTextureSize(128, 64);
	      Top4.mirror = true;
	      setRotation(Top4, 0F, 0F, 0F);
	      Top5 = new ModelRenderer(this, 45, 5);
	      Top5.addBox(0F, 0F, 0F, 4, 7, 1);
	      Top5.setRotationPoint(2F, 12F, -2.5F);
	      Top5.setTextureSize(128, 64);
	      Top5.mirror = true;
	      setRotation(Top5, 0F, 0F, 0F);
	      Top6 = new ModelRenderer(this, 56, 2);
	      Top6.addBox(0F, 0F, 0F, 1, 7, 4);
	      Top6.setRotationPoint(5F, 12F, -1.5F);
	      Top6.setTextureSize(128, 64);
	      Top6.mirror = true;
	      setRotation(Top6, 0F, 0F, 0F);
	      Top7 = new ModelRenderer(this, 45, 5);
	      Top7.addBox(0F, 0F, 0F, 4, 7, 1);
	      Top7.setRotationPoint(1F, 12F, 1.5F);
	      Top7.setTextureSize(128, 64);
	      Top7.mirror = true;
	      setRotation(Top7, 0F, 0F, 0F);
	      Top8 = new ModelRenderer(this, 56, 2);
	      Top8.addBox(0F, 0F, 0F, 1, 7, 4);
	      Top8.setRotationPoint(1F, 12F, -2.5F);
	      Top8.setTextureSize(128, 64);
	      Top8.mirror = true;
	      setRotation(Top8, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	    Base1.render(f5);
	    Base2.render(f5);
	    Base3.render(f5);
	    Top1.render(f5);
	    Top2.render(f5);
	    Top3.render(f5);
	    Top4.render(f5);
	    Top5.render(f5);
	    Top6.render(f5);
	    Top7.render(f5);
	    Top8.render(f5);
	}

	public void renderModel(float f5){
	    Base1.render(f5);
	    Base2.render(f5);
	    Base3.render(f5);
	    Top1.render(f5);
	    Top2.render(f5);
	    Top3.render(f5);
	    Top4.render(f5);
	    Top5.render(f5);
	    Top6.render(f5);
	    Top7.render(f5);
	    Top8.render(f5);
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