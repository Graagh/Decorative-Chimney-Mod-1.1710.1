package com.DecorativeChimney.Items;

import java.util.List;

import com.DecorativeChimney.DecorativeChimneyCore;
import com.DecorativeChimney.TileEntities.TileEntityChimney3;

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
import net.minecraft.world.World;

public class ItemChimney3 extends Item
{
	private final String name ="itemChimney3";
	private int maxMeta = 16;
	public static IIcon[] IconArray;
	public static String[] IconNames =
	{
		"BlackMarble", "GrayMarble", "WhiteMarble", "BlackLargeBrick",
		"BlackSmallBrick", "StoneLargeBrick", "StoneSmallBrick", "Stone",
		"CobbleStone", "WhiteLargeBrick", "WhiteSmallBrick", "NetherBrick",
		"Brick", "Emerald", "Gold", "Diamond",
    	"SmoothSandStone"
	};
	
	public ItemChimney3()
	{
		super();
		setMaxDamage(0);
		setHasSubtypes(true);
		setUnlocalizedName(name);
    	setCreativeTab(DecorativeChimneyCore.tabChimney);
		GameRegistry.registerItem(this, name);
		IconArray = new IIcon[maxMeta];
	}

    @SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list)
    {
		for (int i = 0; i < maxMeta; i++)
		{
			list.add(new ItemStack(item, 1, i));
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
        return super.getUnlocalizedName() + "." + IconNames[i];
	}
	
	public void registerIcons(IIconRegister iconRegister)
    {
		for(int i = 0; i < IconArray.length; i++)
		{
			ItemStack itemStack = new ItemStack(DecorativeChimneyCore.itemChimney3, 64, i);

			IconArray[i] = iconRegister.registerIcon(DecorativeChimneyCore.modid + ":" + IconNames[itemStack.getItemDamage()]);
		}
    }

	@SideOnly(Side.CLIENT)
	public boolean isFull3D()
	{
		return true;
	}
	
	@Override
	public boolean hasEffect(ItemStack itemStack)
	{
		return false; //true to add enchanted effect to item.
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
	
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean par4)
	{
		list.add("Style 3");
	}
	
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int x, int y, int z, int metaData, float hitx, float hity, float hitz)
    {
        //par7 = side
    	
    	if (metaData != 1)
        {
            return false;
        }
        else
        {
        	if (metaData == 1)
        	{
        		++y;
        	}
        	if (!entityPlayer.canPlayerEdit(x, y, z, metaData, itemStack))
        	{
        		return false;
        	}
        	else if (!DecorativeChimneyCore.blockChimney3.canPlaceBlockAt(world, x, y, z))
        	{
        		return false;
        	}
        	else
        	{
        		world.setBlock(x, y, z, DecorativeChimneyCore.blockChimney3, metaData, 2);

        		TileEntity tileentity = world.getTileEntity(x, y, z);
        		if(tileentity != null && tileentity instanceof TileEntityChimney3)
        		{
        			((TileEntityChimney3)tileentity).setChimneyType(itemStack.getItemDamage());
        		}
        		--itemStack.stackSize;
        		return true;
        	}
        }
    }
}