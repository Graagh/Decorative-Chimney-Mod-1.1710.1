package com.DecorativeChimney.Blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.DecorativeChimney.DecorativeChimneyCore;
import com.DecorativeChimney.TileEntities.TileEntityColor;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockMantelCenter extends Block implements ITileEntityProvider
{
	private final String name ="blockMantelCenter";
	private int maxMeta = 16;
	public BlockMantelCenter(Class class1)
	{
    	super(Material.rock);
		anEntityClass = class1;
		setHardness(5.0F);
    	setResistance(1.0F);
    	setStepSound(Block.soundTypeStone);
    	setBlockName(name);
		GameRegistry.registerBlock(this, name);
    	icons = new IIcon[maxMeta];
    	icons2 = new IIcon[maxMeta];
  }

    @SideOnly(Side.CLIENT)
    private static IIcon[] icons;

    @SideOnly(Side.CLIENT)
    private static IIcon[] icons2;

    private static final String[] blockMantelCenterNames =
		{ 
    		"BlackMarble", "BlackMarble", "GrayMarble", "GrayMarble",
    		"WhiteMarble", "WhiteMarble", "Brick", "Stone",
    		"CobbleStone", "Emerald", "Gold", "Diamond",
    		"OakPlank", "BirchPlank", "SprucePlank", "JunglePlank"
		};

    private static final String[] blockManteCenterSecondaryNames =
		{ 
    		"GrayMarble", "WhiteMarble", "BlackMarble", "WhiteMarble",
    		"BlackMarble", "GrayMarble", "Brick", "Stone",
    		"CobbleStone", "Emerald", "Gold", "Diamond",
    		"OakPlank", "BirchPlank", "SprucePlank", "JunglePlank"
		};

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
    	for(int i = 0; i < blockMantelCenterNames.length; i++)
    	{
    		ItemStack blockMantelSideStack = new ItemStack(DecorativeChimneyCore.blockMantelSide, 64, i);

    		icons[i] = iconRegister.registerIcon(DecorativeChimneyCore.modid + ":" + blockMantelCenterNames[blockMantelSideStack.getItemDamage()]);

    		icons2[i] = iconRegister.registerIcon(DecorativeChimneyCore.modid + ":" + blockManteCenterSecondaryNames[blockMantelSideStack.getItemDamage()]);
    	}
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getBlockTexture(IBlockAccess iblockAccess, int x, int y, int z, int i)
    {
        TileEntityColor tileEntityClothColor = (TileEntityColor)iblockAccess.getTileEntity(x, y, z);

    	if(i == 6)
    	{
    		return icons[tileEntityClothColor.getColor1()];
    
    	}
    	if(i == 7)
    	{
    		return icons2[tileEntityClothColor.getColor2()];
    	}
    	return icons[tileEntityClothColor.getColor1()];
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int i, int metaData)
    {
    	return icons[metaData];
    }

    public void onBlockHarvested(World world, int x, int y, int z, int metaData, EntityPlayer entityPlayer)
    {
        if (entityPlayer.capabilities.isCreativeMode)
        {
            metaData |= 8;
            world.setBlockMetadataWithNotify(x, y, z, metaData, 4);
        }

        dropBlockAsItem(world, x, y, z, metaData, 0);

        super.onBlockHarvested(world, x, y, z, metaData, entityPlayer);
    }

    public void breakBlock(World world, int x, int y, int z, Block block, int metaData)
    {
        super.breakBlock(world, x, y, z, block, metaData);
    }

    public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metaData, int fortune)
    {
        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
        if ((metaData & 8) == 0)
        {
            ItemStack itemstack = new ItemStack(DecorativeChimneyCore.itemMantelCenter, 1, this.getDamageValue(world, x, y, z));
            TileEntityColor tileEntityColor = (TileEntityColor)world.getTileEntity(x, y, z);

            if (tileEntityColor == null)
            {
                return drops;
            }
            drops.add(itemstack);
        }
        return drops;
    }

    public Item getItem(World world, int x, int y, int z)
    {
        return DecorativeChimneyCore.itemMantelCenter;
    }

    public Item getItemDropped(int metaData, Random random)
    {
        return DecorativeChimneyCore.itemMantelCenter;
    }

    public int getDamageValue(World world, int x, int y, int z)
    {
        TileEntity tileentity = world.getTileEntity(x, y, z);
        return tileentity != null && tileentity instanceof TileEntityColor ? ((TileEntityColor)tileentity).getColor1() : super.getDamageValue(world, x, y, z);
    }

    public int damageDropped(int damage)
    {
        return damage;
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

	public boolean renderBlockasItem()
	{
		return true;	
	}
	
	public int getRenderType()
	{
		return DecorativeChimneyCore.blockMantelCenterModelID;
	}

	public boolean canPlaceTorchOnTop(World world, int x, int y, int z)
    {
        if (world.doesBlockHaveSolidTopSurface(world, x, y, z))
        {
            return true;
        }
        else
        {
            Block id = world.getBlock(x, y, z);
            return id == DecorativeChimneyCore.blockMantelCenter;
        }
    }

    public int getMobilityFlag()
    {
		return 0;    
    }
    
    public void setBlockBoundsBasedOnState(IBlockAccess iblockAccess, int x, int y, int z)
    {
        boolean var5 = BlockMantelCorner.canConnectTo(iblockAccess, x, y, z - 1);
        boolean var6 = BlockMantelCorner.canConnectTo(iblockAccess, x, y, z + 1);
        boolean var7 = BlockMantelCorner.canConnectTo(iblockAccess, x - 1, y, z);
        boolean var8 = BlockMantelCorner.canConnectTo(iblockAccess, x + 1, y, z);
        float var9 = 0.25F;
        float var10 = 0.75F;
        float var11 = 0.25F;
        float var12 = 0.75F;

        if (var5)
        {
            var11 = 0.0F;
        }

        if (var6)
        {
            var12 = 1.0F;
        }

        if (var7)
        {
            var9 = 0.0F;
        }

        if (var8)
        {
            var10 = 1.0F;
        }

        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public void addCollidingBlockToList(World world, int x, int y, int z, AxisAlignedBB axisAlignedBB, List list, Entity entity)
    {
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);
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

    public static boolean renderMantelCenter(Block block, int x, int y, int z, RenderBlocks renderBlocks, IBlockAccess iblockAccess)
    {
        boolean var5 = BlockMantelCorner.canConnectTo(renderBlocks.blockAccess, x - 1, y, z);
        boolean var6 = BlockMantelCorner.canConnectTo(renderBlocks.blockAccess, x + 1, y, z);
        boolean var7 = BlockMantelCorner.canConnectTo(renderBlocks.blockAccess, x, y, z - 1);
        boolean var8 = BlockMantelCorner.canConnectTo(renderBlocks.blockAccess, x, y, z + 1);
        boolean var14 = BlockMantelCorner.canConnectTo(renderBlocks.blockAccess, x, y - 1, z);
        boolean var9 = var5 && var6;
        boolean var10 = var7 && var8;
        boolean var13 = var5 && var6 && var7 && var8;
        
        TileEntityColor tileEntityClothColor = (TileEntityColor)iblockAccess.getTileEntity(x, y, z);

        float par1 = 0.0F;
        float par2 = 0.0625F;
        float par3 = 1.0F;
        float par4 = 0.9375F;
        float par5 = 0.0F;
        float par6 = 0.125F;
        float par7 = 1.0F;
        float par8 = 0.875F;
        float par9 = 0.0F;
        float par10 = 0.1875F;
        float par11 = 1.0F;
        float par12 = 0.8125F;
        float par13 = 0.0F;
        float par14 = 0.3125F;
        float par15 = 1.0F;
        float par16 = 0.6875F;
        float par17 = 0.0F;
        float par18 = 0.3125F;
        float par19 = 0.0625F;
        float par20 = 0.6875F;
        float par21 = 0.9375F;
        float par22 = 0.3125F;
        float par23 = 1.0F;
        float par24 = 0.6875F;
        float par25 = 0.0F;
        float par26 = 0.25F;
        float par27 = 1.0F;
        float par28 = 0.75F;
        float par29 = 0.0625F;
        float par30 = 0.375F;
        float par31 = 0.9375F;
        float par32 = 0.625F;
        
        float par1a = 0.9375F;
        float par1b = 1.0F;
        float par2a = 0.875F;
        float par2b = 0.9375F;
        float par3a = 0.75F;
        float par3b = 0.875F;
        float par4a = 0.6875F;
        float par4b = 0.75F;
        float par5a = 0.5625F;
        float par5b = 0.6875F;
        float par6a = 0.3125F;
        float par6b = 0.5625F;
        float par7a = 0.1875F;
        float par7b = 0.3125F;
        float par8a = 0.125F;
        float par8b = 0.1875F;
        float par9a = 0.0F;
        float par9b = 0.125F;

        for(int l = 0; l < blockMantelCenterNames.length; l = l + 2)
        {
        	for(int m = 1; m < blockMantelCenterNames.length; m = m + 2)
        	{
        		if(iblockAccess.getBlockMetadata(x, y, z) == l || iblockAccess.getBlockMetadata(x, y, z) == m)
        		{
        			if(iblockAccess.getBlockMetadata(x, y, z) == l && var10)
        			{
        				par1a = 0.0F;
        				par1b = 1.0F;
        			}
        			else if(iblockAccess.getBlockMetadata(x, y, z) == m && var9)
        			{
        				par1a = 0.0F;
        				par1b = 1.0F;
        			}
        			else
        			{
        				if(iblockAccess.getBlockMetadata(x, y, z) == 4 || iblockAccess.getBlockMetadata(x, y, z) == 5 || iblockAccess.getBlockMetadata(x, y, z) == 6 || iblockAccess.getBlockMetadata(x, y, z) == 7)
        				{
        					par1a = 0.0F;
        					par1b = 0.0625F;
        					par2a = 0.0625F;
        					par2b = 0.125F;
        					par3a = 0.125F;
        					par3b = 0.25F;
        					par4a = 0.25F;
        					par4b = 0.3125F;
        					par5a = 0.3125F;
        					par5b = 0.4375F;
        					par6a = 0.4375F;
        					par6b = 0.6875F;
        					par7a = 0.6875F;
        					par7b = 0.8125F;
        					par8a = 0.8125F;
        					par8b = 0.875F;
        					par9a = 0.875F;
        					par9b = 1.0F;
        				}
        				if(iblockAccess.getBlockMetadata(x, y, z) == m )
        				{
        					par1 = 0.0625F;
        					par2 = 0.0F;
        					par3 = 0.9375F;
        					par4 = 1.0F;
        					par5 = 0.125F;
        					par6 = 0.0F;
        					par7 = 0.875F;
        					par8 = 1.0F;
        					par9 = 0.1875F;
        					par10 = 0.0F;
        					par11 = 0.8125F;
        					par12 = 1.0F;
        					par13 = 0.3125F;
        					par14 = 0.0F;
        					par15 = 0.6875F;
        					par16 = 1.0F;
        					par17 = 0.3125F;
        					par18 = 0.0F;
        					par19 = 0.6875F;
        					par20 = 0.0625F;
        					par21 = 0.3125F;
        					par22 = 0.9375F;
        					par23 = 0.6875F;
        					par24 = 1.0F;
        					par25 = 0.25F;
        					par26 = 0.0F;
        					par27 = 0.75F;
        					par28 = 1.0F;
        					par29 = 0.375F;
        					par30 = 0.0625F;
        					par31 = 0.625F;
        					par32 = 0.9375F;

        					if(var5 && !var6)
        					{
        						par1 = 0.0F;
        						par5 = 0.0F;
        						par9 = 0.0F;
        						par13 = 0.0F;
        						par17 = 0.0F;
        						par21 = 0.0F;
        						par25 = 0.0F;
        						par29 = 0.0F;
        					}
        					else if(var6 && !var5)
        					{
        						par3 = 1.0F;
        						par7 = 1.0F;
        						par11 = 1.0F;
        						par15 = 1.0F;
        						par19 = 1.0F;
        						par23 = 1.0F;
        						par27 = 1.0F;
        						par31 = 1.0F;
        					}
        				}
        				if(iblockAccess.getBlockMetadata(x, y, z) == l)
        				{
        					if(var7 && !var8)
        					{
        						par2 = 0.0F;
        						par6 = 0.0F;
        						par10 = 0.0F;
        						par14 = 0.0F;
        						par18 = 0.0F;
        						par22 = 0.0F;
        						par26 = 0.0F;
        						par30 = 0.0F;
        					}
        					else if(var8 && !var7)
        					{
        						par4 = 1.0F;
        						par8 = 1.0F;
        						par12 = 1.0F;
        						par16 = 1.0F;
        						par20 = 1.0F;
        						par24 = 1.0F;
        						par28 = 1.0F;
        						par32 = 1.0F;
        					}
        				}
        			}
        		}
        	}
        }
		//Top
		renderBlocks.setRenderBounds(0.0F, par1a, 0.0F, 1.0F, par1b, 1.0F);
		renderBlocks.renderStandardBlock(block, x, y, z);
		//Level 1
		renderBlocks.setRenderBounds(par1, par2a, par2, par3, par2b, par4);
		renderBlocks.renderStandardBlock(block, x, y, z);
		//Level 2
		renderBlocks.setRenderBounds(par5, par3a, par6, par7, par3b, par8);
		renderBlocks.renderStandardBlock(block, x, y, z);
		//Level 3
		renderBlocks.setRenderBounds(par9, par4a, par10, par11, par4b, par12);
		renderBlocks.renderStandardBlock(block, x, y, z);
		//Level 4
		renderBlocks.setRenderBounds(par13, par5a, par14, par15, par5b, par16);
		renderBlocks.renderStandardBlock(block, x, y, z);
		//Level 5
		//Side 1
		renderBlocks.setRenderBounds(par17, par6a, par18, par19, par6b, par20);
		renderBlocks.renderStandardBlock(block, x, y, z);
		//Side 2
		renderBlocks.setRenderBounds(par21, par6a, par22, par23, par6b, par24);
		renderBlocks.renderStandardBlock(block, x, y, z);
		//Level 6
		renderBlocks.setRenderBounds(par13, par7a, par14, par15, par7b, par16);
		renderBlocks.renderStandardBlock(block, x, y, z);
		//Level 7
		renderBlocks.setRenderBounds(par25, par8a, par26, par27, par8b, par28);
		renderBlocks.renderStandardBlock(block, x, y, z);
		//Level 8
		renderBlocks.setRenderBounds(par13, par9a, par14, par15, par9b, par16);
		renderBlocks.renderStandardBlock(block, x, y, z);
		//Core
		renderBlocks.overrideBlockTexture = block.getIcon(iblockAccess, x, y, z, 7);
		renderBlocks.setRenderBounds(par29, par6a, par30, par31, par6b, par32);
		renderBlocks.renderStandardBlock(block, x, y, z);
		renderBlocks.clearOverrideBlockTexture();	

		block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        return true;
    }

    public boolean shouldSideBeRendered(IBlockAccess iblockAccess, int x, int y, int z, int l)
    {
        return true;
    }
    
	@Override
    public TileEntity createNewTileEntity(World world, int i)
    {
        return new TileEntityColor();
    }
	
	private Class anEntityClass;
}