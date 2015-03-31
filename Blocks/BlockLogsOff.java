package com.DecorativeChimney.Blocks;

import java.util.List;
import java.util.Random;

import com.DecorativeChimney.DecorativeChimneyCore;
import com.DecorativeChimney.TileEntities.TileEntityLogs;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockLogsOff extends Block implements ITileEntityProvider
{
	private final String name ="blockLogsOff";
    private Random random = new Random();

	public BlockLogsOff(Class class1)
	{
		super(Material.wood);
		anEntityClass = class1;
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
    	setHardness(1.5F);
    	setResistance(1.0F);
    	setStepSound(Block.soundTypeWood);
    	setBlockName(name);
    	setCreativeTab(DecorativeChimneyCore.tabChimney);
		GameRegistry.registerBlock(this, name);
	}

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
    	blockIcon = iconRegister.registerIcon("DecorativeChimney:Logs");
    }

	public int quantityDropped(Random random)
	{
		return 1;
	}
	
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int l, float i, float j, float k)
    {
        ItemStack itemStack = entityPlayer.getCurrentEquippedItem();
        Item item = entityPlayer.getCurrentEquippedItem().getItem();
        if(item != null && item == Items.flint_and_steel)
        {
            int q = world.getBlockMetadata(x, y, z);
            world.playSoundEffect((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, "fire.ignite", 1.0F, this.random.nextFloat() * 0.4F + 0.8F);
            itemStack.damageItem(1, entityPlayer);
            world.setBlock(x, y, z, DecorativeChimneyCore.blockLogsOn);
            world.setBlockMetadataWithNotify(x, y, z, q, 2);
            return true;
        }
        else
        {
            return false;
        }
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
		return -1;
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack)
	{
		int l = MathHelper.floor_double((double)((entityLivingBase.rotationYaw * 4F) / 360F) + 0.5D) & 3;
		world.setBlockMetadataWithNotify(x, y, z, l, 2);
	}
	
	public TileEntity createNewTileEntity(World world, int i)
	{
		return new TileEntityLogs();
	}

	private Class anEntityClass;
	
    public boolean getBlocksMovement(IBlockAccess iblockAccess, int x, int y, int z)
    {
        return false;
    }
    
    public void addCollidingBlockToList(World world, int x, int y, int z, AxisAlignedBB axisAlignedBB, List list, Entity entity)
    {
        this.setBlockBoundsBasedOnState(world, x, y, z);
        super.addCollisionBoxesToList(world, x, y, z, axisAlignedBB, list, entity);
    }
}