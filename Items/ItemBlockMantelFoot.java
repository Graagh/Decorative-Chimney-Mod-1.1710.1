package com.DecorativeChimney.Items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMantelFoot extends ItemBlock
{

	public ItemBlockMantelFoot(Block block)
	{
		super(block);
		setMaxDamage(0);
		setHasSubtypes(true);
		setUnlocalizedName("blockMantelFoot");
	}
	
	public int getMetadata(int metaData)
	{
		return metaData;
	}

    public String getUnlocalizedName(ItemStack itemStack)
    {
        switch (itemStack.getItemDamage())
        {
        	case 0:
        		return getUnlocalizedName() + ".blackgray";
        	case 1:
        		return getUnlocalizedName() + ".blackwhite";
        	case 2:
        		return getUnlocalizedName() + ".grayblack";
        	case 3:
        		return getUnlocalizedName() + ".graywhite";
        	case 4:
        		return getUnlocalizedName() + ".whiteblack";
        	case 5:
        		return getUnlocalizedName() + ".whitegray";
        	case 6:
        		return getUnlocalizedName() + ".brick";
        	case 7:
        		return getUnlocalizedName() + ".stone";
        	case 8:
        		return getUnlocalizedName() + ".cobblestone";
        	case 9:
        		return getUnlocalizedName() + ".emerald";
        	case 10:
        		return getUnlocalizedName() + ".gold";
        	case 11:
        		return getUnlocalizedName() + ".diamond";
        	case 12:
        		return getUnlocalizedName() + ".oakplank";
        	case 13:
        		return getUnlocalizedName() + ".birchplank";
        	case 14:
        		return getUnlocalizedName() + ".spruceplank";
        	case 15:
        		return getUnlocalizedName() + ".jungleplank";
        	default:
        		return getUnlocalizedName() + ".whitegray";
        }
    }
}
