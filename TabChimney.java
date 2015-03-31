package com.DecorativeChimney;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TabChimney extends CreativeTabs
{

	public TabChimney(String label)
	{
		super(label);
	}

	@Override
	public ItemStack getIconItemStack()
	{
	    return new ItemStack(DecorativeChimneyCore.blockLogsOn);
	}

	@Override
	public Item getTabIconItem()
	{
		return null;
	}
}
