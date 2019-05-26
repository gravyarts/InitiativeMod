/*
    Copyright (C) 2018-2019 Init Studios. All rights reserved.

    This document is the property of Init Studios.
    It is considered confidential and proprietary.

    This document may not be reproduced or transmitted in any form,
    in whole or in part, without the express written permission of
    Init Studios.
 */

package com.initstudios.initiative.init;

import java.util.ArrayList;
import java.util.List;

import com.initstudios.initiative.blocks.*;
import com.initstudios.initiative.blocks.gels.LBGelSpeed;
import com.initstudios.initiative.blocks.gels.MaterialGel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	//Cubes
 	public static final Block CUBE_HEART_OFF = new LBCubes("cube_heart_off", Material.ANVIL);
 	public static final Block CUBE_STORAGE_OFF = new LBCubes("cube_storage_off", Material.ANVIL);
 	public static final Block CUBE_REFLECT = new LBCubes("cube_reflect", Material.ANVIL);
 	//Dropper
 	public static final Block LB_GEL_JUMP_DROPPER = new LBDropper("lb_gel_jump_dropper", Material.IRON);
 	public static final Block LB_GEL_SPEED_DROPPER = new LBDropper("lb_gel_speed_dropper", Material.IRON);
 	public static final Block LB_GEL_WHITE_DROPPER = new LBDropper("lb_gel_white_dropper", Material.IRON);
 	public static final Block LB_CUBE_DROPPER = new LBDropper("lb_cube_dropper", Material.IRON);
	//Gel
	//GEL_SPEED needs fixing <3
	public static final Block GEL_SPEED = new LBGelSpeed("gel_speed", MaterialGel.GEL);
	//Lab Blocks
	public static final Block PANEL_SURFACE_01 = new Portable("panel_surface_01", Material.IRON);
	public static final Block PANEL_SURFACE_02 = new Portable("panel_surface_02", Material.IRON);
	public static final Block PANEL_SURFACE_11 = new NonPortable("panel_surface_11", Material.IRON);
	public static final Block PANEL_SURFACE_12 = new NonPortable("panel_surface_12", Material.IRON);
	public static final Block PANEL_SURFACE_21 = new NonPortable("panel_surface_21", Material.IRON);
	public static final Block PANEL_SURFACE_22 = new NonPortable("panel_surface_22", Material.IRON);
	public static final Block PANEL_SURFACE_31 = new Portable("panel_surface_31", Material.IRON);
	//Borealis Blocks
	public static final Block BOREALIS_HULL_01 = new BorealisHull("borealis_hull_01", Material.IRON);
	public static final Block BOREALIS_HULL_02 = new BorealisHull("borealis_hull_02", Material.IRON);
	public static final Block BOREALIS_HULL_03 = new BorealisHull("borealis_hull_03", Material.IRON);
	public static final Block BOREALIS_DECK_01 = new BorealisDecoration("borealis_deck_01", Material.IRON);
	public static final Block BOREALIS_STRUCTURE_01 = new BorealisDecoration("borealis_structure_01", Material.IRON);
	public static final Block BOREALIS_STACK_01 = new BorealisDecoration("borealis_stack_01", Material.IRON);
	public static final Block BOREALIS_STACK_02 = new BorealisDecoration("borealis stack_02", Material.IRON);
}
