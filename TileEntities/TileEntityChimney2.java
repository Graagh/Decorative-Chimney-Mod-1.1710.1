package com.DecorativeChimney.TileEntities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityChimney2 extends TileEntity
{
    private int chimneyType;

    private int chimneyRotation;

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound)
    {
        super.writeToNBT(nbtTagCompound);
        nbtTagCompound.setInteger("Type", (int)(this.chimneyType));
        nbtTagCompound.setInteger("Rot", (int)(this.chimneyRotation));
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound)
    {
        super.readFromNBT(nbtTagCompound);
        this.chimneyType = nbtTagCompound.getInteger("Type");
        this.chimneyRotation = nbtTagCompound.getInteger("Rot");
    }

    public void onDataPacket(NetworkManager inetworkManager, S35PacketUpdateTileEntity s35PacketUpdateTileEntity)
    {
        readFromNBT(s35PacketUpdateTileEntity.func_148857_g());
    }

    public Packet getDescriptionPacket()
    {
        NBTTagCompound nbtTagCompound = new NBTTagCompound();
        this.writeToNBT(nbtTagCompound);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 4, nbtTagCompound);
    }

    public void setChimneyType(int type)
    {
        this.chimneyType = type;
    }

    public int getChimneyType()
    {
        return this.chimneyType;
    }

    public void setChimneyRotation(int rotation)
    {
        this.chimneyRotation = rotation;
    }

    public int getChimneyRotation()
    {
//    	System.out.println(chimneyRotation);
        return this.chimneyRotation;
    }
}