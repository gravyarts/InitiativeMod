package com.initstudios.initiative.init;

import java.util.ArrayList;
import java.util.List;

import com.initstudios.initiative.blocks.*;

import com.initstudios.initiative.blocks.gels.GelSpeed;
import com.initstudios.initiative.blocks.gels.MaterialGel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {
	//Moon
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	public static final Block MD_SURFACE = new MDSurface("md_surface",Material.IRON);
	public static final Block MD_STONE = new MDStone("md_stone",Material.IRON);
	public static final Block MD_SOFT = new MDSoft("md_soft",Material.IRON);
	public static final Block MD_HARD = new MDHard("md_hard",Material.IRON);
	public static final Block MD_ORE = new MDOre("md_ore",Material.IRON);
	public static final Block MD_ROCK = new MDRock("md_rock",Material.IRON);
	//Normal
	public static final Block OW_STEEL_ORE = new OWSteelOre("ow_steel_ore",Material.IRON);
	public static final Block OW_GRASS_THICK = new OWGrassThick("ow_grass_thick",Material.IRON);
	//Laboratory
 	public static final Block BLOCK_STORAGE_CUBE = new BlockWeightedCubeBase("storage_cube", Material.ANVIL);
 	public static final Block BLOCK_COMPANION_CUBE = new BlockWeightedCubeBase("companion_cube", Material.ANVIL);
 	//Gels
	public static final Block GEL_SPEED = new GelSpeed("gel_speed", MaterialGel.GEL);
	//Special
}
