package com.DecorativeChimney.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelLogs extends ModelBase
{
	//fields
	
	ModelRenderer LogA;
	ModelRenderer LogB;
	ModelRenderer LogC;
	ModelRenderer LogD;
	ModelRenderer LogE;
	ModelRenderer LogF;

	//Renders
		
	public ModelLogs()
	{
        textureWidth = 64;
        textureHeight = 64;

        LogA = new ModelRenderer(this, 0, 9);
        LogA.addBox(0F, 0F, 0F, 14, 4, 4);
        LogA.setRotationPoint(-7F, 20F, -7F);
        LogA.setTextureSize(64, 64);
        LogA.mirror = true;
        setRotation(LogA, 0F, 0F, 0F);
        LogB = new ModelRenderer(this, 0, 0);
        LogB.addBox(0F, 0F, 0F, 15, 4, 4);
        LogB.setRotationPoint(-7.5F, 20F, -2.5F);
        LogB.setTextureSize(64, 64);
        LogB.mirror = true;
        setRotation(LogB, 0F, 0F, 0F);
        LogC = new ModelRenderer(this, 0, 18);
        LogC.addBox(0F, 0F, 0F, 13, 4, 4);
        LogC.setRotationPoint(-6.5F, 20F, 3F);
        LogC.setTextureSize(64, 64);
        LogC.mirror = true;
        setRotation(LogC, 0F, 0F, 0F);
        LogD = new ModelRenderer(this,  0, 18);
        LogD.addBox(0F, 0F, 0F, 13, 4, 4);
        LogD.setRotationPoint(-7.0F, 16F, -4.5F);
        LogD.setTextureSize(64, 64);
        LogD.mirror = true;
        setRotation(LogD, 0F, 0F, 0F);
        LogE = new ModelRenderer(this,  0, 9);
        LogE.addBox(0F, 0F, 0F, 14, 4, 4);
        LogE.setRotationPoint(-7.5F, 16F, 1F);
        LogE.setTextureSize(64, 64);
        LogE.mirror = true;
        setRotation(LogE, 0F, 0F, 0F);
        LogF = new ModelRenderer(this, 0, 9);
        LogF.addBox(0F, 0F, 0F, 14, 4, 4);
        LogF.setRotationPoint(-7F, 12F, -2F);
        LogF.setTextureSize(64, 64);
        LogF.mirror = true;
        setRotation(LogF, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		LogA.render(f5);
		LogB.render(f5);
		LogC.render(f5);
		LogD.render(f5);
		LogE.render(f5);
		LogF.render(f5);
	}

	public void renderModel(float f5)
	{
		LogA.render(f5);
		LogB.render(f5);
		LogC.render(f5);
		LogD.render(f5);
		LogE.render(f5);
		LogF.render(f5);
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