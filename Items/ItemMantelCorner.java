package com.DecorativeChimney.Items;

import java.util.List;

import com.DecorativeChimney.DecorativeChimneyCore;
import com.DecorativeChimney.TileEntities.TileEntityColor;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;


public class ItemMantelCorner extends Item
{
	private final String name ="itemMantelCorner";
	private int maxMeta = 17;
	public static IIcon[] IconArray;
	public static String[] IconNames =
	{
		"MantelCornerBG", "MantelCornerBW", "MantelCornerGB", "MantelCornerGW",
		"MantelCornerWB", "MantelCornerWG", "MantelCornerBr", "MantelCornerS",
		"MantelCornerCS", "MantelCornerE", "MantelCornerG", "MantelCornerD",
		"MantelCornerOP", "MantelCornerBP", "MantelCornerSP", "MantelCornerJP"
	};

	public ItemMantelCorner()
	{
		super();
		setMaxDamage(0);
		setHasSubtypes(true);
		setUnlocalizedName(name);
    	setCreativeTab(DecorativeChimneyCore.tabChimney);
		GameRegistry.registerItem(this, name);
		IconArray = new IIcon[maxMeta];
	}

	public void getSubItems(int metaData, CreativeTabs creativeTabs, List list)
    {
        for (int j = 0; j < IconArray.length; ++j)
        {
            list.add(new ItemStack(this, 1, j));
        }
    }
	
    public int getMetadata(int metaData)
    {
        return metaData;
    }

    @SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int damage) //Gets the texture
	{
        if (damage < 0 || damage >= IconArray.length)
        {
        	damage = 0;
        }
		return this.IconArray[damage];
	}

	public String getUnlocalizedName(ItemStack itemStack) //Get's the item incode name from an itemstack
	{
        int i = itemStack.getItemDamage();

        if (i < 0 || i >= IconNames.length)
        {
            i = 0;
        }
        return super.getUnlocalizedName() + "." + IconNames[i];	}
	
	public void registerIcons(IIconRegister iconRegister)
    {
		for(int i = 0; i < IconArray.length; i++)
		{
			ItemStack itemStack = new ItemStack(DecorativeChimneyCore.itemMantelCorner, 64, i);

			IconArray[i] = iconRegister.registerIcon(DecorativeChimneyCore.modid + ":" + IconNames[itemStack.getItemDamage()]);
		}
    }

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack itemStack)
	{
		return EnumRarity.common;
		//common=white
		//uncommon=yellow
		//rare=blue
		//epic=purple
	}

	@SideOnly(Side.CLIENT)
	public boolean isFull3D()
	{
		return false;
	}
	
	public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int x, int y, int z, int metaData, float hitx, float hity, float hitz)
    {
        //par7 = side
    	if (metaData == 0)
    	{
    		--y;
    	}
    	if (metaData == 1)
    	{
    		++y;
    	}
    	if (metaData == 2)
    	{
    		--z;
    	}
    	if (metaData == 3)
    	{
    		++z;
    	}
    	if (metaData == 4)
    	{
    		--x;
    	}
    	if (metaData == 5)
    	{
    		++x;
    	}
    	if (!entityPlayer.canPlayerEdit(x, y, z, metaData, itemStack))
    	{
    		return false;
    	}
    	else if (!DecorativeChimneyCore.blockMantelCorner.canPlaceBlockAt(world, x, y, z))
    	{
    		return false;
    	}
    	else
    	{
            int i1 = 0;

            if(metaData == 0)
            {
            	i1 = 0;
            }
            else if(metaData == 1)
            {
            	i1 = 1;
            }
            else if (metaData != 0 || metaData != 1)
            {
            	i1 = ((double)hity >= 0.5D) ? i1 : i1 | 1;
            }
    		world.setBlock(x, y, z, DecorativeChimneyCore.blockMantelCorner, i1, 2);

    		TileEntity tileentity = world.getTileEntity(x, y, z);
    		if(tileentity != null && tileentity instanceof TileEntityColor)
    		{
    			((TileEntityColor)tileentity).setColor1(itemStack.getItemDamage());
    			((TileEntityColor)tileentity).setColor2(itemStack.getItemDamage());
    		}
    		--itemStack.stackSize;
    		return true;
    	}
    }
}