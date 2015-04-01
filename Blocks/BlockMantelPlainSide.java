package com.DecorativeChimney.Blocks;

import java.util.List;
import java.util.Random;

import com.DecorativeChimney.DecorativeChimneyCore;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockMantelPlainSide extends Block
{
	private final String name ="blockMantelPlainSide";
	private int maxMeta = 16;

	public BlockMantelPlainSide()
	{
		super(Material.rock);
		setHardness(5.0F);
    	setResistance(1.0F);
    	setStepSound(Block.soundTypeStone);
    	setBlockName(name);
    	setCreativeTab(DecorativeChimneyCore.tabChimney);
		GameRegistry.registerBlock(this, name);
    	icons = new IIcon[maxMeta];
	}

    @SideOnly(Side.CLIENT)
	public void getSubBlocks(int i, CreativeTabs creativeTabs, List list)
    {
		for (int j = 0; j < 16; j++)
		{
			list.add(new ItemStack(this, 1, j));
		}
    }

    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    private static final String[] blockMantelPlainSideNames =
		{ 
			"BlackMarble", "GrayMarble", "WhiteMarble", "BlackLargeBrick",
			"BlackSmallBrick", "StoneLargeBrick", "StoneSmallBrick", "Stone",
			"CobbleStone", "WhiteLargeBrick", "WhiteSmallBrick", "NetherBrick",
			"Brick", "Emerald", "Gold", "Diamond"
		};

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
    	for(int i = 0; i < icons.length; i++)
    	{
    		ItemStack blockMantelPlainSideStack = new ItemStack(DecorativeChimneyCore.blockMantelPlainSide, 64, i);

    		icons[i] = iconRegister.registerIcon(DecorativeChimneyCore.modid + ":" + blockMantelPlainSideNames[blockMantelPlainSideStack.getItemDamage()]);
    	}
    }
    	
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int metaData)
    {
    	return icons[metaData];
    }
    
    public int damageDropped(int metaData)
    {
    	return metaData;
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

	public int getRenderType()
	{
		return DecorativeChimneyCore.blockMantelPlainSideModelID;
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
            return block == DecorativeChimneyCore.blockMantelPlainSide;
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
        float var9 = 0.3125F;
        float var10 = 0.6875F;
        float var11 = 0.3125F;
        float var12 = 0.6875F;

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

        setBlockBounds(var9, 0.0F, var11, var10, 1.0F, var12);
    }

    public void addCollidingBlockToList(World world, int x, int y, int z, AxisAlignedBB axisAlignedBB, List list, Entity entity)
    {
        setBlockBoundsBasedOnState(world, x, y, z);
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

	public static boolean renderMantelPlainSide(Block block, int x, int y, int z, RenderBlocks renderBlocks, IBlockAccess iblockAccess)
	{
        boolean var5 = BlockMantelCorner.canConnectTo(renderBlocks.blockAccess, x - 1, y, z);
        boolean var6 = BlockMantelCorner.canConnectTo(renderBlocks.blockAccess, x + 1, y, z);
        boolean var7 = BlockMantelCorner.canConnectTo(renderBlocks.blockAccess, x, y, z - 1);
        boolean var8 = BlockMantelCorner.canConnectTo(renderBlocks.blockAccess, x, y, z + 1);
        boolean var9 = var5 && var6;
        boolean var10 = var7 && var8;
        boolean var11 = var5 && var6 && var7 && var8;

        if (var11)
        {
    		renderBlocks.setRenderBounds(0.0F, 0.0F, 0.3125F, 1.0F, 1.0F, 0.6875F);
    		renderBlocks.renderStandardBlock(block, x, y, z);

       		renderBlocks.setRenderBounds(0.3125F, 0.0F, 0.0F, 0.6875F, 1.0F, 0.3125F);
       		renderBlocks.renderStandardBlock(block, x, y, z);

       		renderBlocks.setRenderBounds(0.3125F, 0.0F, 0.6875F, 0.6875F, 1.0F, 1.0F);
       		renderBlocks.renderStandardBlock(block, x, y, z);
        }
        else
        {
        	if (var9 && !var10)
        	{
        		renderBlocks.setRenderBounds(0.0F, 0.0F, 0.3125F, 1.0F, 1.0F, 0.6875F);
        		renderBlocks.renderStandardBlock(block, x, y, z);
    		
        		if (var7)
        		{
        			renderBlocks.setRenderBounds(0.3125F, 0.0F, 0.0F, 0.6875F, 1.0F, 0.3125F);
        			renderBlocks.renderStandardBlock(block, x, y, z);
        		}
        		if (var8)
        		{
        			renderBlocks.setRenderBounds(0.3125F, 0.0F, 0.6875F, 0.6875F, 1.0F, 1.0F);
        			renderBlocks.renderStandardBlock(block, x, y, z);
        		}
        	}
        	else if (var10 && !var9)
        	{
        		renderBlocks.setRenderBounds(0.3125F, 0.0F, 0.0F, 0.6875F, 1.0F, 1.0F);
        		renderBlocks.renderStandardBlock(block, x, y, z);
        
        		if (var5)
        		{
        			renderBlocks.setRenderBounds(0.0F, 0.0F, 0.3125F, 0.3125F, 1.0F, 0.6875F);
        			renderBlocks.renderStandardBlock(block, x, y, z);
        		}
        		if (var6)
        		{
        			renderBlocks.setRenderBounds(0.6875F, 0.0F, 0.3125F, 1.0F, 1.0F, 0.6875F);
        			renderBlocks.renderStandardBlock(block, x, y, z);
        		}
        	}        
        	else if (var5 && !var6 && !var10)
        	{
        		renderBlocks.setRenderBounds(0.0F, 0.0F, 0.3125F, 0.6875F, 1.0F, 0.6875F);
        		renderBlocks.renderStandardBlock(block, x, y, z);

        		if (var7 && !var8)
        		{
        			renderBlocks.setRenderBounds(0.3125F, 0.0F, 0.0F, 0.6875F, 1.0F, 0.3125F);
        			renderBlocks.renderStandardBlock(block, x, y, z);
        		}
        		if (var8 && !var7)
        		{
        			renderBlocks.setRenderBounds(0.3125F, 0.0F, 0.6875F, 0.6875F, 1.0F, 1.0F);
        			renderBlocks.renderStandardBlock(block, x, y, z);
        		}
        	}
        	else if (var6 && !var5 && !var10)
        	{
        		renderBlocks.setRenderBounds(0.3125F, 0.0F, 0.3125F, 1.0F, 1.0F, 0.6875F);
  	    	  	renderBlocks.renderStandardBlock(block, x, y, z);

  	    	  	if (var7 && !var8)
  	    	  	{
  	    	  		renderBlocks.setRenderBounds(0.3125F, 0.0F, 0.0F, 0.6875F, 1.0F, 0.3125F);
  	    	  		renderBlocks.renderStandardBlock(block, x, y, z);
  	    	  	}
  	    	  	if (var8 && !var7)
  	    	  	{
  	    	  		renderBlocks.setRenderBounds(0.3125F, 0.0F, 0.6875F, 0.6875F, 1.0F, 1.0F);
  	    	  		renderBlocks.renderStandardBlock(block, x, y, z);
  	    	  	}
        	}
        	else if (var7 && !var8 && !var9)
        	{
        		renderBlocks.setRenderBounds(0.3125F, 0.0F, 0.0F, 0.6875F, 1.0F, 0.6875F);
        		renderBlocks.renderStandardBlock(block, x, y, z);
        	}

        	else if (var8 && !var7 && !var9)
        	{
        		renderBlocks.setRenderBounds(0.3125F, 0.0F, 0.3125F, 0.6875F, 1.0F, 1.0F);
        		renderBlocks.renderStandardBlock(block, x, y, z);
        	}
        	else
        	{
        		renderBlocks.setRenderBounds(0.3125F, 0.0F, 0.3125F, 0.6875F, 1.0F, 0.6875F);
        		renderBlocks.renderStandardBlock(block, x, y, z);
        	}
        }
        
        renderBlocks.clearOverrideBlockTexture();
        block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        return true;
    }
        
    public boolean shouldSideBeRendered(IBlockAccess iblockAccess, int x, int y, int z, int l)
    {
        return true;
    }
}
