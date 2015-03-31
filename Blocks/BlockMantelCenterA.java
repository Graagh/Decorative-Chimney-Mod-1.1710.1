package com.DecorativeChimney.Blocks;

import java.util.List;
import java.util.Random;

import com.DecorativeChimney.DecorativeChimneyCore;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockMantelCenterA extends Block
{
	public BlockMantelCenterA()
	{
		super(Material.rock);
		setHardness(5.0F);
    	setResistance(1.0F);
    	setStepSound(Block.soundTypeStone);
    	setBlockName("blockMantelCenterA");
    	setCreativeTab(DecorativeChimneyCore.tabChimney);
	}

    @SideOnly(Side.CLIENT)
	public void getSubBlocks(int i, CreativeTabs creativetabs, List list)
    {
		list.add(new ItemStack(this, 1, 0));
		list.add(new ItemStack(this, 1, 4));
		list.add(new ItemStack(this, 1, 8));
		list.add(new ItemStack(this, 1, 12));
    }

    @SideOnly(Side.CLIENT)
    private static IIcon[] icons;

    @SideOnly(Side.CLIENT)
    private static IIcon[] icons2;

    private static final String[] blockMantelCenterANames =
		{ 
    		"BlackMarble", "BlackMarble", "BlackMarble", "BlackMarble", "BlackMarble", "BlackMarble", "BlackMarble", "BlackMarble",
    		"Stone", "Stone", "Stone", "Stone", "OakPlank", "OakPlank", "OakPlank", "OakPlank"
		};

    private static final String[] blockManteCenterASecondaryNames =
		{ 
			"WhiteMarble", "WhiteMarble", "WhiteMarble", "WhiteMarble", "GrayMarble", "GrayMarble", "GrayMarble", "GrayMarble",
    		"Stone", "Stone", "Stone", "Stone", "OakPlank", "OakPlank", "OakPlank", "OakPlank"
		};

/*    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconregister)
    {
    	icons = new Icon[16];
    	icons2 = new Icon[16];
    	
    	for(int i = 0; i < 16; i++)
    	{
    		ItemStack blockMantelCenterAStack = new ItemStack(DecorativeChimneyCore.blockMantelCenterA, 64, i);

    		icons[i] = iconregister.registerIcon(DecorativeChimneyCore.modid + ":" + blockMantelCenterANames[blockMantelCenterAStack.getItemDamage()]);

    		icons2[i] = iconregister.registerIcon(DecorativeChimneyCore.modid + ":" + blockManteCenterASecondaryNames[blockMantelCenterAStack.getItemDamage()]);
    	}
    }*/
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int i, int meta)
    {
    	if(i == 6)
    	{
    		return icons[meta];
    
    	}
    	if(i == 7)
    	{
    		return icons2[meta];
    	}
    	return icons[meta];
    }
    
    public int damageDropped(int metadata)
    {
    	return metadata / 4;
    }

    public int quantityDropped(Random random)
    {
        return 1;
    }

	public boolean isOpaqueCube()
	{
		return false;
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}

	public void onBlockPlacedBy(World world, int i, int j, int k, EntityLivingBase entityliving, ItemStack itemstack)
	{
		int l = MathHelper.floor_double((double)((entityliving.rotationYaw * 4F) / 360F) + 0.5D) & 3;
		world.setBlockMetadataWithNotify(i, j, k, world.getBlockMetadata(i, j, k) + l, 2);
	}
	
	public int getRenderType()
	{
		return DecorativeChimneyCore.blockMantelCenterModelID;
	}

/*    public boolean canPlaceTorchOnTop(World world, int x, int y, int z)
    {
        if (world.doesBlockHaveSolidTopSurface(x, y, z))
        {
            return true;
        }
        else
        {
            int id = world.getBlockId(x, y, z);
            return id == DecorativeChimneyCore.blockMantelCenterA.blockID;
        }
    }*/

    public int getMobilityFlag()
    {
		return 0;    
    }
    
    public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, int i, int j, int k)
    {
    	boolean var5 = BlockMantelCorner.canConnectTo(iblockaccess, i - 1, j, k);
        boolean var6 = BlockMantelCorner.canConnectTo(iblockaccess, i + 1, j, k);
        boolean var7 = BlockMantelCorner.canConnectTo(iblockaccess, i, j, k - 1);
        boolean var8 = BlockMantelCorner.canConnectTo(iblockaccess, i, j, k + 1);
        float var9 = 0.3125F;
        float var10 = 0.6875F;

    	for(int l = 0; l < 16; l = l + 2)
    	{
        	for(int m = 1; m < 16; m = m + 2)
        	{
        		if(iblockaccess.getBlockMetadata(i, j, k) == l)
        		{
        			if(var7)
        			{
        				var9 = 0.0F;
        			}

        			if(var8)
        			{
        				var10 = 1.0F;
        			}

        			setBlockBounds(0.0F, 0.125F, var9, 1.0F, 1.0F, var10);
        		}
        		else if(iblockaccess.getBlockMetadata(i, j, k) == m)
        		{
        			if(var5)
        			{
        				var9 = 0.0F;
        			}

        			if(var6)
        			{
        				var10 = 1.0F;
        			}
        	
        			setBlockBounds(var9, 0.125F, 0.0F, var10, 1.0F, 1.0F);
        		}
        	}
        }
    }

    public void addCollidingBlockToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity)
    {
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
    }

    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z)
    {
        setBlockBoundsBasedOnState(world, x, y, z);
        return super.getSelectedBoundingBoxFromPool(world, x, y, z);
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
    {
        setBlockBoundsBasedOnState(world, x, y, z);
        return super.getCollisionBoundingBoxFromPool(world, x, y, z);
    }

    public MovingObjectPosition collisionRayTrace(World world, int x, int y, int z, Vec3 start, Vec3 end)
    {
        setBlockBoundsBasedOnState(world, x, y, z);
        return super.collisionRayTrace(world, x, y, z, start, end);
    }

    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        return true;
    }
}
