package com.initstudios.initiative.init;

import java.util.ArrayList;
import java.util.List;

import com.initstudios.initiative.blocks.MDHard;
import com.initstudios.initiative.blocks.MDOre;
import com.initstudios.initiative.blocks.MDRock;
import com.initstudios.initiative.blocks.MDSoft;
import com.initstudios.initiative.blocks.MDStone;
import com.initstudios.initiative.blocks.MDSurface;
import com.initstudios.initiative.blocks.OWGrassThick;
import com.initstudios.initiative.blocks.OWSteelOre;

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
	//Special
}
