package com.DecorativeChimney.Items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMantelCenterA extends ItemBlock
{

	public ItemBlockMantelCenterA(Block block)
	{
		super(block);
		setMaxDamage(0);
		setHasSubtypes(true);
		setUnlocalizedName("blockMantelCenterA");
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
                return getUnlocalizedName() + ".blackwhite";
            case 4:
                return getUnlocalizedName() + ".blackgray";
            case 8:
                return getUnlocalizedName() + ".stone";
            case 12:
                return getUnlocalizedName() + ".wood";
            default:
                return getUnlocalizedName() + ".blackwhite";
        }
    }
}
