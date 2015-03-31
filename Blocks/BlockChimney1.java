package com.DecorativeChimney.Blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.DecorativeChimney.DecorativeChimneyCore;
import com.DecorativeChimney.Items.ItemChimney1;
import com.DecorativeChimney.TileEntities.TileEntityChimney1;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockChimney1 extends Block implements ITileEntityProvider
{
	private final String name ="blockChimney1";
	private int maxMeta = 16;

	public BlockChimney1(Class class1)
	{
		super(Material.rock);
    	setHardness(5.0F);
    	setResistance(1.0F);
    	setStepSound(Block.soundTypeStone);
    	setBlockName(name);
		GameRegistry.registerBlock(this, name);
    	icons = new IIcon[maxMeta];
	}

    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    private static final String[] blockChimneyBricksNames =
    { 
    	"BlackMarble", "yBlackMarble", "zBlackMarble", "GrayMarble",
    	"yGrayMarble", "zGrayMarble", "WhiteMarble", "yWhiteMarble",
    	"zWhiteMarble", "NetherClay", "Clay", "Stone",
    	"CobbleStone", "Emerald", "Gold", "Diamond",
    	"SmoothSandStone"
   	};

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
    	for(int i = 0; i < icons.length; i++)
    	{
    		ItemStack blockChimneyBricksStack = new ItemStack(DecorativeChimneyCore.blockChimney1, 64, i);

    		icons[i] = iconRegister.registerIcon(DecorativeChimneyCore.modid + ":" + blockChimneyBricksNames[blockChimneyBricksStack.getItemDamage()]);
    	}
    }
    	
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metaData)
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
            ItemStack itemstack = new ItemStack(DecorativeChimneyCore.itemChimney1, 1, this.getDamageValue(world, x, y, z));
            TileEntityChimney1 tileEntityChimney1 = (TileEntityChimney1)world.getTileEntity(x, y, z);

            if (tileEntityChimney1 == null)
            {
                return drops;
            }
            drops.add(itemstack);
        }
        return drops;
    }

    public Item getItem(World world, int x, int y, int z)
    {
        return DecorativeChimneyCore.itemChimney1;
    }

    public Item getItemDropped(int metaData, Random random, int i)
    {
        return DecorativeChimneyCore.itemChimney1;
    }

    public int getDamageValue(World world, int x, int y, int z)
    {
        TileEntity tileentity = world.getTileEntity(x, y, z);
        return tileentity != null && tileentity instanceof TileEntityChimney1 ? ((TileEntityChimney1)tileentity).getChimneyType() : super.getDamageValue(world, x, y, z);
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

	public int getRenderType()
	{
		return DecorativeChimneyCore.blockChimney1ModelID;
	}

    public static void triggerSmoke(World world, int x, int y, int z, Random random)
    {
        float f = (float)x + 0.5F; //Location Width
        float f1 = (float)y + 0.8125F + (random.nextFloat() * 6F) / 10F; //Location Height
        float f2 = (float)z + 0.5F; //Location Length
        float f3 = random.nextFloat() * 0.6F - 0.3F;
        world.spawnParticle("smoke", f, f1, f2 + f3, 0.0D, 0.0D, 0.0D);
        world.spawnParticle("smoke", f, f1, f2 + f3, 0.0D, 0.0D, 0.0D);
        world.spawnParticle("smoke", f, f1, f2 + f3, 0.0D, 0.0D, 0.0D);
        world.spawnParticle("largesmoke", f, f1, f2 + f3, 0.0D, 0.0D, 0.0D);
        world.spawnParticle("largesmoke", f, f1, f2 + f3, 0.0D, 0.0D, 0.0D);
        world.spawnParticle("largesmoke", f, f1, f2 + f3, 0.0D, 0.0D, 0.0D);
    }

    public boolean getBlocksMovement(IBlockAccess iblockAccess, int x, int y, int z)
    {
        return false;
    }
    
    public void setBlockBoundsBasedOnState(IBlockAccess iblockAccess, int x, int y, int z)
    {
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
    }
    
    public void addCollidingBlockToList(World world, int x, int y, int z, AxisAlignedBB axisAlignedBB, List list, Entity entity)
    {
        this.setBlockBoundsBasedOnState(world, x, y, z);
        super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);
    }

    @SideOnly(Side.CLIENT)
    public String getItemIconName()
    {
        return this.getTextureName() + "_" + ItemChimney1.IconNames[0];
    }

    public TileEntity createNewTileEntity(World world, int i)
	{
		return new TileEntityChimney1();
	}

	private Class anEntityClass;
}