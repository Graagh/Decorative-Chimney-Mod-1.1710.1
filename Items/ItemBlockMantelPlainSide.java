package com.DecorativeChimney.Items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMantelPlainSide extends ItemBlock
{

	public ItemBlockMantelPlainSide(Block block)
	{
		super(block);
		setMaxDamage(0);
		setHasSubtypes(true);
		setUnlocalizedName("blockMantelPlainSide");
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
                return getUnlocalizedName() + ".blackmarble";
            case 1:
                return getUnlocalizedName() + ".graymarble";
            case 2:
                return getUnlocalizedName() + ".whitemarble";
            case 3:
                return getUnlocalizedName() + ".blackbrick";
            case 4:
                return getUnlocalizedName() + ".smallblackbrick";
            case 5:
                return getUnlocalizedName() + ".stonebrick";
            case 6:
                return getUnlocalizedName() + ".smallstonebrick";
            case 7:
                return getUnlocalizedName() + ".stone";
            case 8:
                return getUnlocalizedName() + ".cobblestone";
            case 9:
                return getUnlocalizedName() + ".whitebrick";
            case 10:
                return getUnlocalizedName() + ".smallwhitebrick";
            case 11:
                return getUnlocalizedName() + ".netherbrick";
            case 12:
                return getUnlocalizedName() + ".brick";
            case 13:
                return getUnlocalizedName() + ".emerald";
            case 14:
                return getUnlocalizedName() + ".gold";
            case 15:
                return getUnlocalizedName() + ".gold";
            default:
                return getUnlocalizedName() + ".blackmarble";
        }
    }
}
