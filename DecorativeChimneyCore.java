package com.DecorativeChimney;

import java.io.File;
import java.util.Random;

import com.DecorativeChimney.Blocks.*;
import com.DecorativeChimney.InventoryRenders.ItemChimney1Render;
import com.DecorativeChimney.InventoryRenders.ItemChimney2Render;
import com.DecorativeChimney.InventoryRenders.ItemChimney3Render;
import com.DecorativeChimney.Items.*;
import com.DecorativeChimney.Models.*;
import com.DecorativeChimney.TileEntities.*;
import com.DecorativeChimney.TileEntityRenders.*;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


@Mod(modid=DecorativeChimneyCore.modid, name="Decorative Chimneys", version="Beta 1.1710.1", dependencies="required-after:decorativemarble")

public class DecorativeChimneyCore
{
	public static final String modid = "decorativechimney";
	
	public static CreativeTabs tabChimney = new TabChimney("tabChimney");
	
	public static int blockHollowBricksModelID;
	public static int blockMantelCornerModelID;
	public static int blockMantelCenterModelID;
	public static int blockMantelSideModelID;
	public static int blockMantelPlainSideModelID;
	public static int blockMantelFootModelID;
	public static int blockChimney1ModelID;
	public static int blockChimney2ModelID;
	public static int blockChimney3ModelID;
	
	public static Block blockChimneyHollowBricks = new BlockChimneyHollow();
	public static Block blockMantelCorner = new BlockMantelCorner(TileEntityColor.class);
	public static Block blockMantelCenter = new BlockMantelCenter(TileEntityColor.class);
//	public static Block blockMantelCenterA = new BlockMantelCenterA();
	public static Block blockMantelSide = new BlockMantelSide();
	public static Block blockMantelPlainSide = new BlockMantelPlainSide();
	public static Block blockMantelFoot = new BlockMantelFoot();
	public static Block blockLogsOn = new BlockLogsOn(TileEntityLogs.class);
	public static Block blockLogsOff = new BlockLogsOff(TileEntityLogs.class);
	public static Block blockChimney1 = new BlockChimney1(TileEntityChimney1.class);
	public static Block blockChimney2 = new BlockChimney2(TileEntityChimney2.class);
	public static Block blockChimney3 = new BlockChimney3(TileEntityChimney3.class);
	
	public static Item itemChimney1;
	public static Item itemChimney2;
	public static Item itemChimney3;
	public static Item itemMantelCorner;
	public static Item itemMantelCenter;
	
	private final static ItemChimney1Render itemChimney1Render = new ItemChimney1Render();
	private final static ItemChimney2Render itemChimney2Render = new ItemChimney2Render();
	private final static ItemChimney3Render itemChimney3Render = new ItemChimney3Render();
	
	private static final String[] blockChimneyBricksNames =
		{ 
			"Black Marble", "Gray Marble", "White Marble", "Black Marble Bricks",
			"Small Black Marble Bricks", "Small Stone Bricks", "White Marble Bricks", "Small White Marble Bricks"
		};

	private static final String[] blockChimneyBrickTypeNames =
		{ 
			"Black Marble", "Gray Marble", "White Marble", "Black Marble Bricks", "Small Black Marble Bricks",
			"Stone Bricks", "Small Stone Bricks", "Stone", "Cobblestone", "White Marble Bricks",
			"Small White Marble Bricks", "Nether Brick", "Brick", "Emerald", "Gold", "Diamond"
		};

	private static final String[] blockMantelTypeNames =
		{ 
			"Black with Gray Marble", "Black with White Marble", "Gray with Black Marble", "Gray with White Marble",
			"White with Black Marble", "White with Gray Marble", "Brick", "Stone",
			"Cobblestone", "Emerald", "Gold", "Diamond",
			"Oak Wood Plank", "Birch Wood Plank", "Spruce Wood Plank", "Jungle Wood Plank"
		};
	
	private static final String[] blockMantel2TypeNames =
		{ 
			"Black Marble", "Gray Marble", "White Marble", "Black Marble Bricks", "Small Black Marble Bricks",
			"Stone Bricks", "Small Stone Bricks", "Stone", "Cobblestone", "White Marble Bricks",
			"Small White Marble Bricks", "Nether Brick", "Brick", "Emerald", "Gold", "Diamond"
		};

	private static final String[] blockChimneyTypeNames =
		{ 
			"Black Marble", "Black with Gray Marble", "Black with White Marble", "Gray with Black Marble",
			"Gray Marble", "Gray with White Marble", "White with Black Marble", "White with Gray Marble",
			"White Marble", "Black Marble with Netherbrick", "White Marble with Brick", "Stone",
			"Cobblestone", "Emerald", "Gold", "Diamond",
			"Smooth Sand Stone"
		};
	
	private static final String[] blockChimney2TypeNames =
		{ 
			"Black Marble", "Gray Marble", "White Marble", "Black Marble Bricks", "Small Black Marble Bricks",
			"Stone Bricks", "Small Stone Bricks", "Stone", "Cobblestone", "White Marble Bricks",
			"Small White Marble Bricks", "Nether Brick", "Brick", "Emerald", "Gold", "Diamond", "Smooth Sand Stone"
		};


	@SidedProxy(clientSide="com.DecorativeChimney.ClientProxy", serverSide="com.DecorativeChimney.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		proxy.registerRenderers();
		proxy.initRenders();
	}

	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
        itemChimney1 = new ItemChimney1();
        itemChimney2 = new ItemChimney2();
        itemChimney3 = new ItemChimney3();
        itemMantelCorner = new ItemMantelCorner();
        itemMantelCenter = new ItemMantelCenter();

//		LanguageRegistry.instance().addStringLocalization("itemGroup.tabChimney", "en_US", "Fireplaces and Chimneys");

		GameRegistry.registerTileEntity(TileEntityLogs.class, "LogsOn");
		GameRegistry.registerTileEntity(TileEntityLogs.class, "LogsOff");
		GameRegistry.registerTileEntity(TileEntityChimney1.class, "Chimney1");
		GameRegistry.registerTileEntity(TileEntityChimney2.class, "Chimney2");
		GameRegistry.registerTileEntity(TileEntityChimney3.class, "Chimney3");
		GameRegistry.registerTileEntity(TileEntityColor.class, "Color");
		
		MinecraftForgeClient.registerItemRenderer(itemChimney1, itemChimney1Render);
		MinecraftForgeClient.registerItemRenderer(itemChimney2, itemChimney2Render);
		MinecraftForgeClient.registerItemRenderer(itemChimney3, itemChimney3Render);

//Tool Tip Name
/*		LanguageRegistry.addName(blockLogsOn, "Logs");
		LanguageRegistry.addName(blockLogsOff, "Logs");

		for (int i = 0; i < blockChimneyTypeNames.length; i++)
		{
			ItemStack itemChimneyStyle1Stack = new ItemStack(itemChimney1, 64, i);

			LanguageRegistry.addName(itemChimneyStyle1Stack, blockChimneyTypeNames[itemChimneyStyle1Stack.getItemDamage()] + " Chimney");

			ItemStack itemChimneyStyle2Stack = new ItemStack(itemChimney2, 64, i);

			LanguageRegistry.addName(itemChimneyStyle2Stack, blockChimneyTypeNames[itemChimneyStyle2Stack.getItemDamage()] + " Chimney");

			ItemStack itemChimneysytle3Stack = new ItemStack(itemChimney3, 64, i);

			LanguageRegistry.addName(itemChimneysytle3Stack, blockChimney2TypeNames[itemChimneysytle3Stack.getItemDamage()] + " Chimney");
		}
		for (int i = 0; i < 16; i++)
		{
			ItemStack blockChimneyHollowBricksStack = new ItemStack(blockChimneyHollowBricks, 64, i);

			LanguageRegistry.addName(blockChimneyHollowBricksStack, "Hollow " + blockChimneyBrickTypeNames[blockChimneyHollowBricksStack.getItemDamage()]);

			ItemStack blockMantelPlainSideStack = new ItemStack(blockMantelPlainSide, 64, i);

			LanguageRegistry.addName(blockMantelPlainSideStack, blockMantel2TypeNames[blockMantelPlainSideStack.getItemDamage()] + " Mantel Plain Side");
		}
		for (int i = 0; i < blockMantelTypeNames.length; i++)
		{
			ItemStack itemMantelCornerStack = new ItemStack(itemMantelCorner, 64, i);

			LanguageRegistry.addName(itemMantelCornerStack, blockMantelTypeNames[itemMantelCornerStack.getItemDamage()] + " Mantel Corner");

			ItemStack itemMantelCenterStack = new ItemStack(itemMantelCenter, 64, i);

			LanguageRegistry.addName(itemMantelCenterStack, blockMantelTypeNames[itemMantelCenterStack.getItemDamage()] + " Mantel Center");

			ItemStack blockMantelSideStack = new ItemStack(blockMantelSide, 64, i);

			LanguageRegistry.addName(blockMantelSideStack, blockMantelTypeNames[blockMantelSideStack.getItemDamage()] + " Mantel Side");

			ItemStack blockMantelFootStack = new ItemStack(blockMantelFoot, 64, i);

			LanguageRegistry.addName(blockMantelFootStack, blockMantelTypeNames[blockMantelFootStack.getItemDamage()] + " Mantel Footer");
		}*/
		
//Recipes
		GameRegistry.addRecipe(new ItemStack(blockLogsOff, 4, 7), " L ", "LLL", Character.valueOf('L'), Blocks.log);

		addHollowRecipe(0, "stoneMarbleBlack", "stoneMarbleBlack");
		addHollowRecipe(1, "stoneMarbleGray", "stoneMarbleGray");
		addHollowRecipe(2, "stoneMarble", "stoneMarble");
		addHollowRecipe(3, "brickMarbleBlack", "brickMarbleBlack");
		addHollowRecipe(4, "brickMarbleSmallBlack", "brickMarbleSmallBlack");
		addHollowRecipe(5, Blocks.stonebrick, Blocks.stonebrick);
		addHollowRecipe(6, "brickStoneSmall", "brickStoneSmall");
		addHollowRecipe(7, Blocks.stone, Blocks.stone);
		addHollowRecipe(8, Blocks.cobblestone, Blocks.cobblestone);
		addHollowRecipe(9, "brickMarble", "brickMarble");
		addHollowRecipe(10, "brickMarbleSmall", "brickMarbleSmall");
		addHollowRecipe(11, Blocks.nether_brick, Blocks.nether_brick);
		addHollowRecipe(12, Blocks.brick_block, Blocks.brick_block);
		addHollowRecipe(13, Blocks.glass, Items.emerald);
		addHollowRecipe(14, Blocks.planks, Items.gold_ingot);
		addHollowRecipe(15, Blocks.glass, Items.diamond);

		addMantelCornerRecipe(0, "stoneMarbleBlack", "stoneMarbleGray");
		addMantelCornerRecipe(1, "stoneMarbleBlack", "stoneMarble");
		addMantelCornerRecipe(2, "stoneMarbleGray", "stoneMarbleBlack");
		addMantelCornerRecipe(3, "stoneMarbleGray", "stoneMarble");
		addMantelCornerRecipe(4, "stoneMarble", "stoneMarbleBlack");
		addMantelCornerRecipe(5, "stoneMarble", "stoneMarbleGray");
		addMantelCornerRecipe(6, Blocks.brick_block, Items.coal);
		addMantelCornerRecipe(7, Blocks.stone, Items.coal);
		addMantelCornerRecipe(8, Blocks.cobblestone, Items.coal);
		addMantelCornerRecipe(9, Blocks.glass, Items.emerald);
		addMantelCornerRecipe(10, Blocks.planks, Items.gold_ingot);
		addMantelCornerRecipe(11, Blocks.glass, Items.diamond);
		addMantelCornerRecipe(12, new ItemStack(Blocks.planks, 1, 0), Items.coal);
		addMantelCornerRecipe(13, new ItemStack(Blocks.planks, 1, 2), Items.coal);
		addMantelCornerRecipe(14, new ItemStack(Blocks.planks, 1, 1), Items.coal);
		addMantelCornerRecipe(15, new ItemStack(Blocks.planks, 1, 3), Items.coal);
		
		addMantelCenterRecipe(0, "stoneMarbleBlack", "stoneMarbleGray");
		addMantelCenterRecipe(1, "stoneMarbleBlack", "stoneMarble");
		addMantelCenterRecipe(2, "stoneMarbleGray", "stoneMarbleBlack");
		addMantelCenterRecipe(3, "stoneMarbleGray", "stoneMarble");
		addMantelCenterRecipe(4, "stoneMarble", "stoneMarbleBlack");
		addMantelCenterRecipe(5, "stoneMarble", "stoneMarbleGray");
		addMantelCenterRecipe(6, Blocks.brick_block, Items.coal);
		addMantelCenterRecipe(7, Blocks.stone, Items.coal);
		addMantelCenterRecipe(8, Blocks.cobblestone, Items.coal);
		addMantelCenterRecipe(9, Blocks.glass, Items.emerald);
		addMantelCenterRecipe(10, Blocks.planks, Items.gold_ingot);
		addMantelCenterRecipe(11, Blocks.glass, Items.diamond);
		addMantelCenterRecipe(12, new ItemStack(Blocks.planks, 1, 0), Items.coal);
		addMantelCenterRecipe(13, new ItemStack(Blocks.planks, 1, 2), Items.coal);
		addMantelCenterRecipe(14, new ItemStack(Blocks.planks, 1, 1), Items.coal);
		addMantelCenterRecipe(15, new ItemStack(Blocks.planks, 1, 3), Items.coal);
		
		addMantelPlainSideRecipe(0, "stoneMarbleBlack", "stoneMarbleBlack");
		addMantelPlainSideRecipe(1, "stoneMarbleGray", "stoneMarbleGray");
		addMantelPlainSideRecipe(2, "stoneMarble", "stoneMarble");
		addMantelPlainSideRecipe(3, "brickMarbleBlack", "brickMarbleBlack");
		addMantelPlainSideRecipe(4, "brickMarbleSmallBlack", "brickMarbleSmallBlack");
		addMantelPlainSideRecipe(5, Blocks.stonebrick, Items.coal);
		addMantelPlainSideRecipe(6, "brickStoneSmall", "brickStoneSmall");
		addMantelPlainSideRecipe(7, Blocks.stone, Items.coal);
		addMantelPlainSideRecipe(8, Blocks.cobblestone, Items.coal);
		addMantelPlainSideRecipe(9, "brickMarble", "brickMarble");
		addMantelPlainSideRecipe(10, "brickMarbleSmall", "brickMarbleSmall");
		addMantelPlainSideRecipe(11, Blocks.nether_brick, Items.coal);
		addMantelPlainSideRecipe(12, Blocks.brick_block, Items.coal);
		addMantelPlainSideRecipe(13, Blocks.glass, Items.emerald);
		addMantelPlainSideRecipe(14, Blocks.planks, Items.gold_ingot);
		addMantelPlainSideRecipe(15, Blocks.glass, Items.diamond);
		
		addMantelSideRecipe(0, "stoneMarbleBlack", "stoneMarbleGray");
		addMantelSideRecipe(1, "stoneMarbleBlack", "stoneMarble");
		addMantelSideRecipe(2, "stoneMarbleGray", "stoneMarbleBlack");
		addMantelSideRecipe(3, "stoneMarbleGray", "stoneMarble");
		addMantelSideRecipe(4, "stoneMarble", "stoneMarbleBlack");
		addMantelSideRecipe(5, "stoneMarble", "stoneMarbleGray");
		addMantelSideRecipe(6, Blocks.brick_block, Items.coal);
		addMantelSideRecipe(7, Blocks.stone, Items.coal);
		addMantelSideRecipe(8, Blocks.cobblestone, Items.coal);
		addMantelSideRecipe(9, Blocks.glass, Items.emerald);
		addMantelSideRecipe(10, Blocks.planks, Items.gold_ingot);
		addMantelSideRecipe(11, Blocks.glass, Items.diamond);
		addMantelSideRecipe(12, new ItemStack(Blocks.planks, 1, 0), Items.coal);
		addMantelSideRecipe(13, new ItemStack(Blocks.planks, 1, 2), Items.coal);
		addMantelSideRecipe(14, new ItemStack(Blocks.planks, 1, 1), Items.coal);
		addMantelSideRecipe(15, new ItemStack(Blocks.planks, 1, 3), Items.coal);

		addMantelFootRecipe(0, "stoneMarbleBlack", "stoneMarbleGray");
		addMantelFootRecipe(1, "stoneMarbleBlack", "stoneMarble");
		addMantelFootRecipe(2, "stoneMarbleGray", "stoneMarbleBlack");
		addMantelFootRecipe(3, "stoneMarbleGray", "stoneMarble");
		addMantelFootRecipe(4, "stoneMarble", "stoneMarbleBlack");
		addMantelFootRecipe(5, "stoneMarble", "stoneMarbleGray");
		addMantelFootRecipe(6, Blocks.brick_block, Items.coal);
		addMantelFootRecipe(7, Blocks.stone, Items.coal);
		addMantelFootRecipe(8, Blocks.cobblestone, Items.coal);
		addMantelFootRecipe(9, Blocks.glass, Items.emerald);
		addMantelFootRecipe(10, Blocks.planks, Items.gold_ingot);
		addMantelFootRecipe(11, Blocks.glass, Items.diamond);
		addMantelFootRecipe(12, new ItemStack(Blocks.planks, 1, 0), Items.coal);
		addMantelFootRecipe(13, new ItemStack(Blocks.planks, 1, 2), Items.coal);
		addMantelFootRecipe(14, new ItemStack(Blocks.planks, 1, 1), Items.coal);
		addMantelFootRecipe(15, new ItemStack(Blocks.planks, 1, 3), Items.coal);

		addChimney1Recipe(0, "stoneMarbleBlack", "stoneMarbleBlack");
		addChimney1Recipe(1, "stoneMarbleBlack", "stoneMarbleGray");
		addChimney1Recipe(2, "stoneMarbleBlack", "stoneMarble");
		addChimney1Recipe(3, "stoneMarbleGray", "stoneMarbleBlack");
		addChimney1Recipe(4, "stoneMarbleGray", "stoneMarbleGray");
		addChimney1Recipe(5, "stoneMarbleGray", "stoneMarble");
		addChimney1Recipe(6, "stoneMarble", "stoneMarbleBlack");
		addChimney1Recipe(7, "stoneMarble", "stoneMarbleGray");
		addChimney1Recipe(8, "stoneMarble", "stoneMarble");
		addChimney1Recipe(9, "stoneMarbleBlack", Items.netherbrick);
		addChimney1Recipe(10, "stoneMarble", Items.brick);
		addChimney1Recipe(11, Blocks.stone, Items.coal);
		addChimney1Recipe(12, Blocks.cobblestone, Items.coal);
		addChimney1Recipe(13, Blocks.glass, Items.emerald);
		addChimney1Recipe(14, Blocks.planks, Items.gold_ingot);
		addChimney1Recipe(15, Blocks.glass, Items.diamond);
		addChimney1Recipe(16, new ItemStack(Blocks.sandstone, 1, 2), Items.coal);

		addChimney2Recipe(0, "stoneMarbleBlack", "stoneMarbleBlack");
		addChimney2Recipe(1, "stoneMarbleBlack", "stoneMarbleGray");
		addChimney2Recipe(2, "stoneMarbleBlack", "stoneMarble");
		addChimney2Recipe(3, "stoneMarbleGray", "stoneMarbleBlack");
		addChimney2Recipe(4, "stoneMarbleGray", "stoneMarbleGray");
		addChimney2Recipe(5, "stoneMarbleGray", "stoneMarble");
		addChimney2Recipe(6, "stoneMarble", "stoneMarbleBlack");
		addChimney2Recipe(7, "stoneMarble", "stoneMarbleGray");
		addChimney2Recipe(8, "stoneMarble", "stoneMarble");
		addChimney2Recipe(9, "stoneMarbleBlack", Items.netherbrick);
		addChimney2Recipe(10, "stoneMarble", Items.brick);
		addChimney2Recipe(11, Blocks.stone, Items.coal);
		addChimney2Recipe(12, Blocks.cobblestone, Items.coal);
		addChimney2Recipe(13, Blocks.glass, Items.emerald);
		addChimney2Recipe(14, Blocks.planks, Items.gold_ingot);
		addChimney2Recipe(15, Blocks.glass, Items.diamond);
		addChimney2Recipe(16, new ItemStack(Blocks.sandstone, 1, 2), Items.coal);

		addChimney3Recipe(0, "stoneMarbleBlack", "stoneMarbleBlack");
		addChimney3Recipe(1, "stoneMarbleGray", "stoneMarbleGray");
		addChimney3Recipe(2, "stoneMarble", "stoneMarble");
		addChimney3Recipe(3, "brickMarbleBlack", "brickMarbleBlack");
		addChimney3Recipe(4, "brickMarbleSmallBlack", "brickMarbleSmallBlack");
		addChimney3Recipe(5, Blocks.stonebrick, Blocks.stonebrick);
		addChimney3Recipe(6, "brickStoneSmall", "brickStoneSmall");
		addChimney3Recipe(7, Blocks.stone, Blocks.stone);
		addChimney3Recipe(8, Blocks.cobblestone, Blocks.cobblestone);
		addChimney3Recipe(9, "brickMarble", "brickMarble");
		addChimney3Recipe(10, "brickMarbleSmall", "brickMarbleSmall");
		addChimney3Recipe(11, Blocks.nether_brick, Blocks.nether_brick);
		addChimney3Recipe(12, Blocks.brick_block, Blocks.brick_block);
		addChimney3Recipe(13, Blocks.glass, Items.emerald);
		addChimney3Recipe(14, Blocks.planks, Items.gold_ingot);
		addChimney3Recipe(15, Blocks.glass, Items.diamond);
	}

	public static void addHollowRecipe(int i, Object obj1, Object obj2)
	{
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(blockChimneyHollowBricks, 2, i), "I J", "   ", "J J",
				Character.valueOf('I'), obj1,
				Character.valueOf('J'), obj2));
	}

	public static void addMantelCornerRecipe(int i, Object obj1, Object obj2)
	{
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(itemMantelCorner, 2, i), "III", "IJI", " I ",
				Character.valueOf('I'), obj1,
				Character.valueOf('J'), obj2));
	}

	public static void addMantelCenterRecipe(int i, Object obj1, Object obj2)
	{
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(itemMantelCenter, 2, i), "IJI", " I ",
				Character.valueOf('I'), obj1,
				Character.valueOf('J'), obj2));
	}

	public static void addMantelSideRecipe(int i, Object obj1, Object obj2)
	{
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(blockMantelSide, 2, i), " I ", " J ", " I ",
				Character.valueOf('I'), obj1,
				Character.valueOf('J'), obj2));
	}

	public static void addMantelPlainSideRecipe(int i, Object obj1, Object obj2)
	{
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(blockMantelPlainSide, 2, i), " I ", " I ", " J ",
				Character.valueOf('I'), obj1,
				Character.valueOf('J'), obj2));
	}

	public static void addMantelFootRecipe(int i, Object obj1, Object obj2)
	{
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(blockMantelFoot, 2, i), " I ", " I ", "IJI",
				Character.valueOf('I'), obj1,
				Character.valueOf('J'), obj2));
	}

	public static void addChimney1Recipe(int i, Object obj1, Object obj2)
	{
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(itemChimney1, 1, i), " J ", "III",
				Character.valueOf('I'), obj1,
				Character.valueOf('J'), obj2));
	}

	public static void addChimney2Recipe(int i, Object obj1, Object obj2)
	{
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(itemChimney2, 1, i), "IJI", "III",
				Character.valueOf('I'), obj1,
				Character.valueOf('J'), obj2));
	}

	public static void addChimney3Recipe(int i, Object obj1, Object obj2)
	{
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(itemChimney3, 1, i), " J ", "I I",
				Character.valueOf('I'), obj1,
				Character.valueOf('J'), obj2));
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
	}
}
