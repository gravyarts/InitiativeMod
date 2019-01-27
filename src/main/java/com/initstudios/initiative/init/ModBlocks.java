package com.initstudios.initiative.init;

import java.util.ArrayList;
import java.util.List;

import com.initstudios.initiative.blocks.*;

import com.initstudios.initiative.blocks.dropper.gel.SpeedGelDropper;
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
 	public static final Block LB_GEL_SPEED_DROPPER = new BlockBase("lb_gel_speed_dropper", Material.IRON);
 	public static final Block LB_FOAM_PATCH = new LBPanelPortable("lb_foam_patch", Material.IRON);
 	public static final Block LB_D_FOAM_PATCH = new LBPanelPortable("lb_d_foam_patch", Material.IRON);
 	//Gels
	public static final Block GEL_SPEED = new GelSpeed("gel_speed", MaterialGel.GEL);
	//Special
	//Bottom Portable
	public static final Block LB_CL_PANEL_PORTABLE_BOTTOM = new LBPanelPortable("lb_cl_panel_portable_bottom", Material.IRON);
	public static final Block LB_CRACKED_PANEL_PORTABLE_BOTTOM = new LBPanelPortable("lb_cracked_panel_portable_bottom", Material.IRON);
	public static final Block LB_SCRATCHED_PANEL_PORTABLE_BOTTOM = new LBPanelPortable("lb_scratched_panel_portable_bottom", Material.IRON);
	public static final Block LB_OVERTAKEN_PANEL_PORTABLE_BOTTOM = new LBPanelPortable("lb_overtaken_panel_portable_bottom", Material.IRON);
	public static final Block LB_MOSS_PANEL_PORTABLE_BOTTOM = new LBPanelPortable("lb_moss_panel_portable_bottom", Material.IRON);
	public static final Block LB_VINE_PANEL_PORTABLE_BOTTOM = new LBPanelPortable("lb_vine_panel_portable_bottom", Material.IRON);
	public static final Block LB_FOAM_PANEL_PORTABLE_BOTTOM = new LBPanelPortable("lb_foam_panel_portable_bottom", Material.IRON);
	public static final Block LB_FADED_FOAM_PANEL_PORTABLE_BOTTOM = new LBPanelPortable("lb_faded_foam_panel_portable_bottom", Material.IRON);
	public static final Block LB_D_FADED_FOAM_PANEL_PORTABLE_BOTTOM = new LBPanelPortable("lb_d_faded_foam_panel_portable_bottom", Material.IRON);
	public static final Block LB_D_MOSS_PANEL_PORTABLE_BOTTOM = new LBPanelPortable("lb_d_moss_panel_portable_bottom", Material.IRON);
	public static final Block LB_D_FADE_PANEL_PORTABLE_BOTTOM = new LBPanelPortable("lb_d_fade_panel_portable_bottom", Material.IRON);
	public static final Block LB_D_PANEL_PORTABLE_BOTTOM = new LBPanelPortable("lb_d_panel_portable_bottom", Material.IRON);
	//Top Portable
	public static final Block LB_CL_PANEL_PORTABLE_TOP = new LBPanelPortable("lb_cl_panel_portable_top", Material.IRON);
	public static final Block LB_CRACKED_PANEL_PORTABLE_TOP = new LBPanelPortable("lb_cracked_panel_portable_top", Material.IRON);
	public static final Block LB_SCRATCHED_PANEL_PORTABLE_TOP = new LBPanelPortable("lb_scratched_panel_portable_top", Material.IRON);
	public static final Block LB_OVERTAKEN_PANEL_PORTABLE_TOP = new LBPanelPortable("lb_overtaken_panel_portable_top", Material.IRON);
	public static final Block LB_MOSS_PANEL_PORTABLE_TOP = new LBPanelPortable("lb_moss_panel_portable_top", Material.IRON);
	public static final Block LB_VINE_PANEL_PORTABLE_TOP = new LBPanelPortable("lb_vine_panel_portable_top", Material.IRON);
	public static final Block LB_FOAM_PANEL_PORTABLE_TOP = new LBPanelPortable("lb_foam_panel_portable_top", Material.IRON);
	public static final Block LB_FADED_FOAM_PANEL_PORTABLE_TOP = new LBPanelPortable("lb_faded_foam_panel_portable_top", Material.IRON);
	public static final Block LB_D_FADED_FOAM_PANEL_PORTABLE_TOP = new LBPanelPortable("lb_d_faded_foam_panel_portable_top", Material.IRON);
	public static final Block LB_D_MOSS_PANEL_PORTABLE_TOP = new LBPanelPortable("lb_d_moss_panel_portable_top", Material.IRON);
	public static final Block LB_D_FADE_PANEL_PORTABLE_TOP = new LBPanelPortable("lb_d_fade_panel_portable_top", Material.IRON);
	public static final Block LB_D_PANEL_PORTABLE_TOP = new LBPanelPortable("lb_d_panel_portable_top", Material.IRON);
}
