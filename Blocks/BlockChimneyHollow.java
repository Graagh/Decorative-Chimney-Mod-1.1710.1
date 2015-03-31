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
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockChimneyHollow extends Block
{
	private final String name ="blockChimneyHollowBricks";
	private int maxMeta = 16;

	public BlockChimneyHollow()
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
	public void getSubBlocks(int i, CreativeTabs creativetabs, List list)
    {
		for (int j = 0; j < 16; j++)
		{
			list.add(new ItemStack(this, 1, j));
		}
    }

    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    private static final String[] blockChimneyBricksNames =
		{ 
			"BlackMarble", "GrayMarble", "WhiteMarble", "BlackLargeBrick",
			"BlackSmallBrick", "StoneLargeBrick", "StoneSmallBrick", "Stone",
			"CobbleStone", "WhiteLargeBrick", "WhiteSmallBrick", "NetherBrick",
			"Brick", "Emerald", "Gold", "Diamond"
		};

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconregister)
    {
    	for(int i = 0; i < icons.length; i++)
    	{
    		ItemStack blockChimneyBricksStack = new ItemStack(DecorativeChimneyCore.blockChimneyHollowBricks, 64, i);

    		icons[i] = iconregister.registerIcon(DecorativeChimneyCore.modid + ":" + blockChimneyBricksNames[blockChimneyBricksStack.getItemDamage()]);
    	}
    }
    	
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int meta)
    {
    	return icons[meta];
    }
    
    public int damageDropped(int metadata)
    {
    	return metadata;
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
		return DecorativeChimneyCore.blockHollowBricksModelID;
	}

	public String getTextureFile()
	{
		return "/DecorativeChimney/Textures/ChimneyItems.png";
	}
   
    public int getMobilityFlag()
    {
		return 0;    
    }

	public void randomDisplayTick(World world, int x, int y, int z, Random random)
	{
		Block var1 = Blocks.lit_furnace;
		Block var2 = DecorativeChimneyCore.blockLogsOn;
		Block var3 = Blocks.fire;
		Block var4 = world.getBlock(x - 1, y, z);
		Block var5 = world.getBlock(x + 1, y, z);
		Block var6 = world.getBlock(x, y, z - 1);
		Block var7 = world.getBlock(x, y, z + 1);
		Block var8 = world.getBlock(x, y - 1, z);
		Block var9 = world.getBlock(x, y - 2, z);

        if (var4 == var1 || var5 == var1 || var6 == var1 || var7 == var1 || var8 == var1 ||
        		var4 == var2 || var5 == var2 || var6 == var2 || var7 == var2 || var8 == var2 ||
                var4 == var3 || var5 == var3 || var6 == var3 || var7 == var3 || var8 == var3 ||
        		var9 == var2 || var9 == var3 || world.isBlockIndirectlyGettingPowered(x, y, z))
        {
            triggerSmoke(world, x, y - 1, z, random);
        }
	}

    public static void triggerSmoke(World world, int i, int j, int k, Random random)
    {
    	Block var1 = world.getBlock(i, j + 1, k);
        if (var1 == DecorativeChimneyCore.blockChimneyHollowBricks)
        {
            triggerSmoke(world, i, j + 1, k, random);
        }
        else if (var1 == DecorativeChimneyCore.blockChimney1)
        {
            BlockChimney1.triggerSmoke(world, i, j + 1, k, random);
        }
        else if (var1 == DecorativeChimneyCore.blockChimney2)
        {
            BlockChimney2.triggerSmoke(world, i, j + 1, k, random);
        }
        else if (var1 == DecorativeChimneyCore.blockChimney3)
        {
            BlockChimney3.triggerSmoke(world, i, j + 1, k, random);
        }
        else
        {
        		float f = (float)i + 0.5F; //Location Width
        		float f1 = (float)j + 0.75F + (random.nextFloat() * 6F) / 10F; //Location Height
        		float f2 = (float)k + 0.5F; //Location Length
        		float f3 = random.nextFloat() * 0.6F - 0.3F;
        		world.spawnParticle("smoke", f, f1, f2 + f3, 0.0D, 0.0D, 0.0D);
        		world.spawnParticle("smoke", f, f1, f2 + f3, 0.0D, 0.0D, 0.0D);
        		world.spawnParticle("smoke", f, f1, f2 + f3, 0.0D, 0.0D, 0.0D);
        		world.spawnParticle("largesmoke", f, f1, f2 + f3, 0.0D, 0.0D, 0.0D);
        		world.spawnParticle("largesmoke", f, f1, f2 + f3, 0.0D, 0.0D, 0.0D);
        		world.spawnParticle("largesmoke", f, f1, f2 + f3, 0.0D, 0.0D, 0.0D);
        }
    }

    public boolean canConnectRedstone(IBlockAccess world, int x, int y, int z, int side)
    {
		return true;
    }
    
    public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, int i, int j, int k)
    {
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public void addCollidingBlockToList(World world, int i, int j, int k, AxisAlignedBB axisAlignedBB, List list, Entity entity)
    {
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        super.addCollisionBoxesToList(world, i, j, k, axisAlignedBB, list, entity);
    }

    public static boolean renderHollowBricks(Block block, int i, int j, int k, RenderBlocks renderblocks, IBlockAccess iblockaccess)
    {
    	renderblocks.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.125F);
    	renderblocks.renderStandardBlock(block, i, j, k);

    	renderblocks.setRenderBounds(0.875F, 0.0F, 0.125F, 1.0F, 1.0F, 0.875F);
    	renderblocks.renderStandardBlock(block, i, j, k);


    	renderblocks.setRenderBounds(0.0F, 0.0F, 0.875F, 1.0F, 1.0F, 1.0F);
    	renderblocks.renderStandardBlock(block, i, j, k);

    	renderblocks.setRenderBounds(0.0F, 0.0F,0.125F, 0.125F, 1.0F, 0.875F);
    	renderblocks.renderStandardBlock(block, i, j, k);

       	renderblocks.clearOverrideBlockTexture();
       	block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
       	return true;
	}

    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        return true;
    }
}
