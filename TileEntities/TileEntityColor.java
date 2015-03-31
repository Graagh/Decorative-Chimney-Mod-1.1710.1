package com.DecorativeChimney.TileEntities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityColor extends TileEntity
{
	private int color1;
	private int color2;

	public TileEntityColor()
	{
		color1 = 0;
		color2 = 0;
	}

	public void setColor1(int color)
	{
		this.color1 = color;
	}

	public void setColor2(int color)
	{
		this.color2 = color;
	}

	public int getColor1()
	{
		return color1;
	}

	public int getColor2()
	{
		return color2;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbtTagCompound)
	{
		super.readFromNBT(nbtTagCompound);
		color1 = nbtTagCompound.getInteger("color1");
		color2 = nbtTagCompound.getInteger("color2");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbtTagCompound)
	{
		super.writeToNBT(nbtTagCompound);
		nbtTagCompound.setInteger("color1", color1 & 255);
		nbtTagCompound.setInteger("color2", color2 & 255);
	}

	public void onDataPacket(NetworkManager networkManager, S35PacketUpdateTileEntity s35PacketUpdateTileEntity)
	{
		readFromNBT(s35PacketUpdateTileEntity.func_148857_g());
	}

	public Packet getDescriptionPacket()
	{
		NBTTagCompound nbtTagCompound = new NBTTagCompound();
		writeToNBT(nbtTagCompound);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, nbtTagCompound);
	}
}
