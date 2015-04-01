package com.DecorativeChimney.Blocks;

import java.util.List;
import java.util.Random;

import com.DecorativeChimney.DecorativeChimneyCore;
import com.DecorativeChimney.Items.ItemBlockMantelFoot;

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

public class BlockMantelFoot extends Block
{
	private final String name ="blockMantelFoot";
	private int maxMeta = 16;

	public BlockMantelFoot()
	{
		super(Material.rock);
		setHardness(5.0F);
    	setResistance(1.0F);
    	setStepSound(Block.soundTypeStone);
    	setBlockName(name);
    	setCreativeTab(DecorativeChimneyCore.tabChimney);
		GameRegistry.registerBlock(this, ItemBlockMantelFoot.class, name);
    	icons = new IIcon[maxMeta];
    	icons2 = new IIcon[maxMeta];
	}

    @SideOnly(Side.CLIENT)
	public void getSubBlocks(int i, CreativeTabs creativeTabs, List list)
    {
		for (int j = 0; j < blockMantelFootNames.length; j++)
		{
			list.add(new ItemStack(this, 1, j));
		}
    }

    @SideOnly(Side.CLIENT)
    private static IIcon[] icons;

    @SideOnly(Side.CLIENT)
    private static IIcon[] icons2;

    private static final String[] blockMantelFootNames =
		{ 
    		"BlackMarble", "BlackMarble", "GrayMarble", "GrayMarble",
    		"WhiteMarble", "WhiteMarble", "Brick", "Stone",
    		"CobbleStone", "Emerald", "Gold", "Diamond",
    		"OakPlank", "BirchPlank", "SprucePlank", "JunglePlank"
		};

    private static final String[] blockManteFootSecondaryNames =
		{ 
    		"GrayMarble", "WhiteMarble", "BlackMarble", "WhiteMarble",
    		"BlackMarble", "GrayMarble", "Brick", "Stone",
    		"CobbleStone", "Emerald", "Gold", "Diamond",
    		"OakPlank", "BirchPlank", "SprucePlank", "JunglePlank"
		};

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
    	for(int i = 0; i < blockMantelFootNames.length; i++)
    	{
    		ItemStack blockMantelFootStack = new ItemStack(DecorativeChimneyCore.blockMantelFoot, 64, i);

    		icons[i] = iconRegister.registerIcon(DecorativeChimneyCore.modid + ":" + blockMantelFootNames[blockMantelFootStack.getItemDamage()]);

    		icons2[i] = iconRegister.registerIcon(DecorativeChimneyCore.modid + ":" + blockManteFootSecondaryNames[blockMantelFootStack.getItemDamage()]);
    	}
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int i, int metaData)
    {
    	if(i == 6)
    	{
    		return icons[metaData];
    
    	}
    	if(i == 7)
    	{
    		return icons2[metaData];
    	}
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
		return DecorativeChimneyCore.blockMantelFootModelID;
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
            return block == DecorativeChimneyCore.blockMantelFoot;
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

	public static boolean renderMantelFoot(Block block, int x, int y, int z, RenderBlocks renderBlocks, IBlockAccess iblockAccess)
	{
        boolean var5 = BlockMantelCorner.canConnectTo(renderBlocks.blockAccess, x - 1, y, z);
        boolean var6 = BlockMantelCorner.canConnectTo(renderBlocks.blockAccess, x + 1, y, z);
        boolean var7 = BlockMantelCorner.canConnectTo(renderBlocks.blockAccess, x, y, z - 1);
        boolean var8 = BlockMantelCorner.canConnectTo(renderBlocks.blockAccess, x, y, z + 1);
        boolean var9 = var5 && var7;
        boolean var10 = var5 && var8;
        boolean var11 = var6 && var7;
        boolean var12 = var6 && var8;
        
        float par1 = 0.3125F;
        float par2 = 0.3125F;
        float par3 = 0.6875F;
        float par4 = 0.6875F;

        for(int l = 0; l < blockMantelFootNames.length; l++)
    	{
    		if(iblockAccess.getBlockMetadata(x, y, z) == l)
    		{
    			if (var5)
    			{
    				par1 = 0.0F;
    			}
    			if (var6)
    			{
    				par3 = 1.0F;
    			}
    			if (var7)
    			{
    				par2 = 0.0F;
    			}
    			if (var8)
    			{
    				par4 = 1.0F;
    			}
    			//Sides
    			renderBlocks.setRenderBounds(par1, 0.0F, par2, par3, 1.0F, par4);
    			renderBlocks.renderStandardBlock(block, x, y, z);
    			//Top
    			renderBlocks.setRenderBounds(0.25F, 0.0F, 0.25F, 0.75F, 1.0F, 0.75F);
    			renderBlocks.renderStandardBlock(block, x, y, z);
    			//Level 1
    			renderBlocks.setRenderBounds(0.1875F, 0.5F, 0.1875F, 0.8125F, 0.625F, 0.8125F);
    			renderBlocks.renderStandardBlock(block, x, y, z);
    			//Level 2
    			//Pole 1
    			renderBlocks.setRenderBounds(0.1875F, 0.125F, 0.1875F, 0.3125F, 0.5F, 0.3125F);
    			renderBlocks.renderStandardBlock(block, x, y, z);
    			//Pole 2
    			renderBlocks.setRenderBounds(0.1875F, 0.125F, 0.6875F, 0.3125F, 0.5F, 0.8125F);
    			renderBlocks.renderStandardBlock(block, x, y, z);
    			//Pole 3
    			renderBlocks.setRenderBounds(0.6875F, 0.125F, 0.1875F, 0.8125F, 0.5F, 0.3125F);
    			renderBlocks.renderStandardBlock(block, x, y, z);
    			//Pole 4
    			renderBlocks.setRenderBounds(0.6875F, 0.125F, 0.6875F, 0.8125F, 0.5F, 0.8125F);
    			renderBlocks.renderStandardBlock(block, x, y, z);
    			//Level 3
    			renderBlocks.setRenderBounds(0.1875F, 0.0F, 0.1875F, 0.8125F, 0.125F, 0.8125F);
    			renderBlocks.renderStandardBlock(block, x, y, z);
    			//Core
    			renderBlocks.overrideBlockTexture = block.getIcon(7, l);
    			renderBlocks.setRenderBounds(0.249F, 0.125F, 0.249F, 0.751F, 0.5F, 0.751F);
    			renderBlocks.renderStandardBlock(block, x, y, z);
    			renderBlocks.clearOverrideBlockTexture();
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
