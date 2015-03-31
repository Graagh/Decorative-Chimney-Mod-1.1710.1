package com.DecorativeChimney.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelChimney1 extends ModelBase
{
	//fields

	ModelRenderer Base1;
	ModelRenderer Base2;
	ModelRenderer Base3;
	ModelRenderer Top1;
	ModelRenderer Top2;
	ModelRenderer Wall1;
	ModelRenderer Wall2;
	ModelRenderer Wall3;
	ModelRenderer Wall4;

	//Renders

	public ModelChimney1()
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
		Top1 = new ModelRenderer(this, 57, 40);
		Top1.addBox(0F, 0F, 0F, 7, 6, 7);
		Top1.setRotationPoint(-3.5F, 13F, -3.5F);
		Top1.setTextureSize(128, 64);
		Top1.mirror = true;
		setRotation(Top1, 0F, 0F, 0F);
		Top2 = new ModelRenderer(this, 51, 25);
		Top2.addBox(0F, 0F, 0F, 6, 1, 6);
		Top2.setRotationPoint(-3F, 12F, -3F);
		Top2.setTextureSize(128, 64);
		Top2.mirror = true;
		setRotation(Top2, 0F, 0F, 0F);
		Wall1 = new ModelRenderer(this, 76, 21);
		Wall1.addBox(0F, 0F, 0F, 0, 7, 4);
		Wall1.setRotationPoint(-2F, 12F, -2F);
		Wall1.setTextureSize(128, 64);
		Wall1.mirror = true;
		setRotation(Wall1, 0F, 0F, 0F);
		Wall2 = new ModelRenderer(this, 76, 25);
		Wall2.addBox(0F, 0F, 0F, 4, 7, 0);
		Wall2.setRotationPoint(-2F, 12F, -2F);
		Wall2.setTextureSize(128, 64);
		Wall2.mirror = true;
		setRotation(Wall2, 0F, 0F, 0F);
		Wall3 = new ModelRenderer(this, 76, 21);
		Wall3.addBox(0F, 0F, 0F, 0, 7, 4);
		Wall3.setRotationPoint(2F, 12F, -2F);
		Wall3.setTextureSize(128, 64);
		Wall3.mirror = true;
		setRotation(Wall3, 0F, 0F, 0F);
		Wall4 = new ModelRenderer(this, 76, 25);
		Wall4.addBox(0F, 0F, 0F, 4, 7, 0);
		Wall4.setRotationPoint(-2F, 12F, 2F);
		Wall4.setTextureSize(128, 64);
		Wall4.mirror = true;
		setRotation(Wall4, 0F, 0F, 0F);
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
		Wall1.render(f5);
		Wall2.render(f5);
		Wall3.render(f5);
		Wall4.render(f5);
	}

	public void renderModel(float f5)
	{
		Base1.render(f5);
		Base2.render(f5);
		Base3.render(f5);
		Top1.render(f5);
		Top2.render(f5);
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