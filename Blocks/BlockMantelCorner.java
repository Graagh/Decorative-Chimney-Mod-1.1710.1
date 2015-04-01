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
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockMantelCorner extends Block implements ITileEntityProvider
{
	private final String name ="blockMantelCorner";
	private int maxMeta = 16;

	public BlockMantelCorner(Class class1)
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

    private static final String[] blockNames =
		{ 
    		"BlackMarble", "BlackMarble", "GrayMarble", "GrayMarble",
    		"WhiteMarble", "WhiteMarble", "Brick", "Stone",
    		"CobbleStone", "Emerald", "Gold", "Diamond",
    		"OakPlank", "BirchPlank", "SprucePlank", "JunglePlank"
		};

    private static final String[] blockSecondaryNames =
		{ 
    		"GrayMarble", "WhiteMarble", "BlackMarble", "WhiteMarble",
    		"BlackMarble", "GrayMarble", "Brick", "Stone",
    		"CobbleStone", "Emerald", "Gold", "Diamond",
    		"OakPlank", "BirchPlank", "SprucePlank", "JunglePlank"
		};

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
    	for(int i = 0; i < blockNames.length; i++)
    	{
    		ItemStack blockMantelSideStack = new ItemStack(DecorativeChimneyCore.blockMantelSide, 64, i);

    		icons[i] = iconRegister.registerIcon(DecorativeChimneyCore.modid + ":" + blockNames[blockMantelSideStack.getItemDamage()]);

    		icons2[i] = iconRegister.registerIcon(DecorativeChimneyCore.modid + ":" + blockSecondaryNames[blockMantelSideStack.getItemDamage()]);
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
            ItemStack itemstack = new ItemStack(DecorativeChimneyCore.itemMantelCorner, 1, this.getDamageValue(world, x, y, z));
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
        return DecorativeChimneyCore.itemMantelCorner;
    }

    public Item getItemDropped(int metaData, Random random)
    {
        return DecorativeChimneyCore.itemMantelCorner;
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
		return DecorativeChimneyCore.blockMantelCornerModelID;
	}

	public boolean canPlaceTorchOnTop(World world, int x, int y, int z)
    {
        if (world.doesBlockHaveSolidTopSurface(world, x, y, z))
        {
            return true;
        }
        else
        {
            Block block = world.getBlock(x, y, z);
            return block == DecorativeChimneyCore.blockMantelCorner;
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

    public static boolean canConnectTo(IBlockAccess iblockAccess, int x, int y, int z)
    {
        Block block = iblockAccess.getBlock(x, y, z);
        return block != null && block != DecorativeChimneyCore.blockChimneyHollowBricks
        		&& block != DecorativeChimneyCore.blockMantelCorner
        		&& block != DecorativeChimneyCore.blockMantelCenter
        		&& block != DecorativeChimneyCore.blockMantelSide
        		&& block != DecorativeChimneyCore.blockMantelPlainSide
        		&& block != DecorativeChimneyCore.blockMantelFoot
        		&& block != Blocks.fence_gate ? (block.blockMaterial.isOpaque() && block.renderAsNormalBlock() ? block.blockMaterial != Material.gourd : false) : true;
    }

    public static boolean renderMantelCorner(Block block, int x, int y, int z, RenderBlocks renderBlocks, IBlockAccess iblockAccess)
    {
        boolean var5 = canConnectTo(renderBlocks.blockAccess, x - 1, y, z);
        boolean var6 = canConnectTo(renderBlocks.blockAccess, x + 1, y, z);
        boolean var7 = canConnectTo(renderBlocks.blockAccess, x, y, z - 1);
        boolean var8 = canConnectTo(renderBlocks.blockAccess, x, y, z + 1);
        boolean var9 = var5 && var6 && var7 && var8;
        
        TileEntityColor tileEntityClothColor = (TileEntityColor)iblockAccess.getTileEntity(x, y, z);

        float par1 = 0.0625F;
        float par2 = 0.0625F;
        float par3 = 0.9375F;
        float par4 = 0.9375F;
        float par5 = 0.125F;
        float par6 = 0.125F;
        float par7 = 0.875F;
        float par8 = 0.875F;
        float par9 = 0.1875F;
        float par10 = 0.1875F;
        float par11 = 0.8125F;
        float par12 = 0.8125F;
        float par13 = 0.25F;
        float par14 = 0.25F;
        float par15 = 0.75F;
        float par16 = 0.75F;
        float par17 = 0.3125F;
        float par18 = 0.3125F;
        float par19 = 0.6875F;
        float par20 = 0.6875F;
        
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
        float par10a = 0.0F;
        float par10b = 0.6875F;
        
    	for(int l = 0; l < blockNames.length; l = l + 2)
    	{
        	for(int m = 1; m < blockNames.length; m = m + 2)
    		  {
        		if(iblockAccess.getBlockMetadata(x, y, z) == l || iblockAccess.getBlockMetadata(x, y, z) == m)
        		{
        			if (var9)
        			{
        				par1a = 0.0F;
        				par1b = 1.0F;
        			}
        			else
        			{
    					if(iblockAccess.getBlockMetadata(x, y, z) == m)
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
    						par10a = 0.3125F;
    						par10b = 1.0F;
    					}
        				if (var5 || var6 || var7 || var8)
        				{
        					if (var5)
        					{
        						par1 = 0.0F;
        						par5 = 0.0F;
        						par9 = 0.0F;
        						par13 = 0.0F;
        						par17 = 0.0F;

        						if (var6)
        						{
        							par3 = 1.0F;
        							par7 = 1.0F;
        							par11 = 1.0F;
        							par15 = 1.0F;
        							par19 = 1.0F;

        							if (var7 && !var8)
        							{
        								par2 = 0.0F;
        								par6 = 0.0F;
        								par10 = 0.0F;
        								par14 = 0.0F;
        								par18 = 0.0F;

        							}
        							else if (var8 && !var7)
        							{
        								par4 = 1.0F;
        								par8 = 1.0F;
        								par12 = 1.0F;
        								par16 = 1.0F;
        								par20 = 1.0F;
        							}
        						}
        						else if (var7 && !var6)
        						{
        							par2 = 0.0F;
        							par6 = 0.0F;
        							par10 = 0.0F;
        							par14 = 0.0F;
        							par18 = 0.0F;

        							if (var8)
        							{
        								par4 = 1.0F;
        								par8 = 1.0F;
        								par12 = 1.0F;
        								par16 = 1.0F;
        								par20 = 1.0F;
        							}
        						}
        						else if (var8 && !var6 && !var7)
        						{
        							par4 = 1.0F;
        							par8 = 1.0F;
        							par12 = 1.0F;
        							par16 = 1.0F;
        							par20 = 1.0F;
        						}
        					}
        					else if (var6 && !var5)
        					{
        						par3 = 1.0F;
        						par7 = 1.0F;
        						par11 = 1.0F;
        						par15 = 1.0F;
        						par19 = 1.0F;

        						if (var7)
        						{
        							par2 = 0.0F;
        							par6 = 0.0F;
        							par10 = 0.0F;
        							par14 = 0.0F;
        							par18 = 0.0F;

        							if(var8)
        							{
        								par4 = 1.0F;
        								par8 = 1.0F;
        								par12 = 1.0F;
        								par16 = 1.0F;
        								par20 = 1.0F;
        							}
        						}
        						else if (var8 && !var7)
        						{
        							par4 = 1.0F;
        							par8 = 1.0F;
        							par12 = 1.0F;
        							par16 = 1.0F;
        							par20 = 1.0F;
        						}
        					}
        					else if (var7 && !var5 && !var6)
        					{
        						par2 = 0.0F;
        						par6 = 0.0F;
        						par10 = 0.0F;
        						par14 = 0.0F;
        						par18 = 0.0F;

        						if(var8)
        						{
        							par4 = 1.0F;
        							par8 = 1.0F;
        							par12 = 1.0F;
        							par16 = 1.0F;
        							par20 = 1.0F;
        						}
        					}
        					else if (var8 && !var5 && !var6 && !var7)
        					{
        						par4 = 1.0F;
        						par8 = 1.0F;
        						par12 = 1.0F;
        						par16 = 1.0F;
        						par20 = 1.0F;
        					}
        				}
		        	}
		        }
        	}
        }
	//Top
		renderBlocks.setRenderBounds(0.0F, par1a, 0.0F, 1.0F, par1b, 1.0F);
		renderBlocks.renderStandardBlock(block, x, y, z);

	//Level 2
		renderBlocks.setRenderBounds(par1, par2a, par2, par3, par2b, par4);
		renderBlocks.renderStandardBlock(block, x, y, z);
	//Level 3
		renderBlocks.setRenderBounds(par5, par3a, par6, par7, par3b, par8);
		renderBlocks.renderStandardBlock(block, x, y, z);
	//Level 4
		renderBlocks.setRenderBounds(par9, par4a, par10, par11, par4b, par12);
		renderBlocks.renderStandardBlock(block, x, y, z);

	//Level 5
		renderBlocks.setRenderBounds(0.25F, par5a, 0.25F, 0.75F, par5b, 0.75F);
		renderBlocks.renderStandardBlock(block, x, y, z);
	//Level 6
	//Pole 1
		renderBlocks.setRenderBounds(0.25F, par6a, 0.25F, 0.375F, par6b, 0.375F);
		renderBlocks.renderStandardBlock(block, x, y, z);
	//Pole 2
		renderBlocks.setRenderBounds(0.625F, par6a, 0.25F, 0.75F, par6b, 0.375F);
		renderBlocks.renderStandardBlock(block, x, y, z);
	//Pole 3
		renderBlocks.setRenderBounds(0.625F, par6a, 0.625F, 0.75F, par6b, 0.75F);
		renderBlocks.renderStandardBlock(block, x, y, z);
	//Pole 4
		renderBlocks.setRenderBounds(0.25F, par6a, 0.625F, 0.375F, par6b, 0.75F);
		renderBlocks.renderStandardBlock(block, x, y, z);
	//Level 7
		renderBlocks.setRenderBounds(0.25F, par7a, 0.25F, 0.75F, par7b, 0.75F);
		renderBlocks.renderStandardBlock(block, x, y, z);
	//Level 8
		renderBlocks.setRenderBounds(0.1875F, par8a, 0.1875F, 0.8125F, par8b, 0.8125F);
		renderBlocks.renderStandardBlock(block, x, y, z);
	//Level 9
		renderBlocks.setRenderBounds(0.25F, par9a, 0.25F, 0.75F, par9b, 0.75F);
		renderBlocks.renderStandardBlock(block, x, y, z);

		renderBlocks.setRenderBounds(par13, par8a, par14, par15, par8b, par16);
		renderBlocks.renderStandardBlock(block, x, y, z);

		renderBlocks.setRenderBounds(par17, par10a, par18, par19, par10b, par20);
		renderBlocks.renderStandardBlock(block, x, y, z);
	//Core
		renderBlocks.overrideBlockTexture = block.getIcon(iblockAccess, x, y, z, 7);
		renderBlocks.setRenderBounds(0.3115F, par6a, 0.3115F, 0.6885F, par6b, 0.6885F);
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
