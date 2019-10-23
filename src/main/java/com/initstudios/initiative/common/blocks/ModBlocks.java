/*
    Copyright (C) 2018-2019 Init Studios. All rights reserved.

    This document is the property of Init Studios.
    It is considered confidential and proprietary.

    This document may not be reproduced or transmitted in any form,
    in whole or in part, without the express written permission of
    Init Studios.
 */

package com.initstudios.initiative.common.blocks;

import com.initstudios.initiative.InitMod;
import com.initstudios.initiative.common.blocks.gels.LBGelJump;
import com.initstudios.initiative.common.blocks.gels.LBGelSpeed;
import com.initstudios.initiative.common.blocks.gels.MaterialGel;
import com.initstudios.initiative.common.items.ModItems;
import com.initstudios.initiative.util.IHaveItem;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber
public class ModBlocks {
    public static final List<Block> BLOCKS = new ArrayList<Block>();
    //Cubes
    public static final Block CUBE_HEART_OFF = registerBlock(new LBCubes(Material.ANVIL), "cube_heart_off", InitMod.laboratory);
    public static final Block CUBE_STORAGE_OFF = registerBlock(new LBCubes(Material.ANVIL), "cube_storage_off", InitMod.laboratory);
    public static final Block CUBE_REFLECT = registerBlock(new LBCubes(Material.ANVIL), "cube_reflect", InitMod.laboratory);
    public static final Block CUBE_NEWSTORAGE_OFF = registerBlock(new LBCubes(Material.ANVIL), "cube_newstorage_off", InitMod.laboratory);
    public static final Block CUBE_SKULL = registerBlock(new LBCubes(Material.ANVIL), "cube_skull", InitMod.laboratory);
    public static final Block CUBE_EXPAND = registerBlock(new LBCubes(Material.ANVIL), "cube_expand", InitMod.laboratory);
    public static final Block CUBE_CLASSIC = registerBlock(new LBCubes(Material.ANVIL), "cube_classic", InitMod.laboratory);
    public static final Block CUBE_INITMOD = registerBlock(new LBCubes(Material.ANVIL), "cube_initmod", InitMod.laboratory);
    //Dropper
    public static final Block LB_GEL_JUMP_DROPPER = registerBlock(new LBDropper(Material.IRON), "lb_gel_jump_dropper", InitMod.laboratory);
    public static final Block LB_GEL_SPEED_DROPPER = registerBlock(new LBDropper(Material.IRON), "lb_gel_speed_dropper", InitMod.laboratory);
    public static final Block LB_GEL_WHITE_DROPPER = registerBlock(new LBDropper(Material.IRON), "lb_gel_white_dropper", InitMod.laboratory);
    public static final Block LB_CUBE_DROPPER = registerBlock(new LBDropper(Material.IRON), "lb_cube_dropper", InitMod.laboratory);
    //Gel
    //GEL_SPEED needs fixing <3
    public static final Block GEL_SPEED = registerBlock(new LBGelSpeed(MaterialGel.GEL), "gel_speed", InitMod.classic);
    public static final Block GEL_JUMP = registerBlock(new LBGelJump(MaterialGel.GEL), "gel_jump", InitMod.classic);
    //Lab Blocks
//    public static final Block PANEL_SURFACE_01 = registerBlock(new Portable(Material.IRON), "panel_surface_01", Main.laboratory);
//    public static final Block PANEL_SURFACE_02 = registerBlock(new Portable(Material.IRON), "panel_surface_02", Main.laboratory);
//    public static final Block PANEL_SURFACE_03 = registerBlock(new Portable(Material.IRON), "panel_surface_03", Main.laboratory);
//    public static final Block PANEL_SURFACE_04 = registerBlock(new Portable(Material.IRON), "panel_surface_04", Main.laboratory);
//    public static final Block PANEL_SURFACE_05 = registerBlock(new Portable(Material.IRON), "panel_surface_05", Main.laboratory);
//    public static final Block PANEL_SURFACE_06 = registerBlock(new Portable(Material.IRON), "panel_surface_06", Main.laboratory);
//    public static final Block PANEL_SURFACE_11 = registerBlock(new NonPortable(Material.IRON), "panel_surface_11", Main.laboratory);
//    public static final Block PANEL_SURFACE_12 = registerBlock(new NonPortable(Material.IRON), "panel_surface_12", Main.laboratory);
//    public static final Block PANEL_SURFACE_13 = registerBlock(new NonPortable(Material.IRON), "panel_surface_13", Main.laboratory);
//    public static final Block PANEL_SURFACE_14 = registerBlock(new NonPortable(Material.IRON), "panel_surface_14", Main.laboratory);
//    public static final Block PANEL_SURFACE_21 = registerBlock(new NonPortable(Material.IRON), "panel_surface_21", Main.laboratory);
//    public static final Block PANEL_SURFACE_22 = registerBlock(new NonPortable(Material.IRON), "panel_surface_22", Main.laboratory);
//    public static final Block PANEL_SURFACE_31 = registerBlock(new NonPortable(Material.IRON), "panel_surface_31", Main.laboratory);
//    public static final Block PANEL_SURFACE_32 = registerBlock(new NonPortable(Material.IRON), "panel_surface_32", Main.laboratory);
//    public static final Block PANEL_SURFACE_41 = registerBlock(new LabBlocks(Material.IRON), "panel_surface_41", Main.laboratory);
//    public static final Block PANEL_SURFACE_42 = registerBlock(new LabBlocks(Material.IRON), "panel_surface_42", Main.laboratory);
//    public static final Block PANEL_SURFACE_43 = registerBlock(new LabBlocks(Material.IRON), "panel_surface_43", Main.laboratory);
//    public static final Block PANEL_SURFACE_44 = registerBlock(new LabBlocks(Material.IRON), "panel_surface_44", Main.laboratory);
//    public static final Block PANEL_SURFACE_45 = registerBlock(new LabBlocks(Material.IRON), "panel_surface_45", Main.laboratory);
//    public static final Block PANEL_SURFACE_46 = registerBlock(new LabBlocks(Material.IRON), "panel_surface_46", Main.laboratory);
    public static final Block PANEL_TEST = registerBlock(new BlockPanel(Material.IRON, true), "panel_test", InitMod.laboratory);
    //public static final Block PANEL_BACK = registerBlock(new PanelBlocks(Material.IRON, true), "panel_back", Main.laboratory);
    public static final Block PANEL_FACE = registerBlock(new BlockPanel(Material.IRON, true), "panel_face", InitMod.laboratory);
    public static final Block PANEL_FACE_01 = registerBlock(new BlockBase(Material.IRON), "panel_face_01", InitMod.laboratory);
//    public static final Block PANEL_OUTLINE = registerBlock(new ScaffoldBlocks(Material.IRON), "panel_outline", Main.laboratory);
//    public static final Block PANEL_FRAME = registerBlock(new BlockPanel(Material.IRON, true), "panel_frame", InitMod.laboratory);
    public static final Block LIGHT_FULL_BLOCK = registerBlock(new LightBlocks(Material.IRON), "light_full_block", InitMod.laboratory);
    public static final Block SCAFFOLD_01 = registerBlock(new ScaffoldBlocks(Material.IRON), "scaffold_01", InitMod.laboratory);
    public static final Block GRATING_00 = registerBlock(new ScaffoldBlocks(Material.IRON), "grating_00", InitMod.laboratory);
    public static final Block PANEL_SCREEN_08 = registerBlock(new LBIndicatorsLong(Material.IRON), "panel_screen_08", InitMod.laboratory);
    public static final Block PANEL_INDICATOR_X = registerBlock(new LBIndicatorsShort(Material.IRON), "panel_indicator_x", InitMod.laboratory);
    public static final Block SUPER_BUTTON_01 = registerBlock(new LBButton(Material.IRON), "super_button_01", InitMod.laboratory);
    //Classic Blocks
    public static final Block BOREALIS_HULL_01 = registerBlock(new BorealisHull(Material.IRON), "borealis_hull_01", InitMod.classic);
    public static final Block BOREALIS_HULL_02 = registerBlock(new BorealisHull(Material.IRON), "borealis_hull_02", InitMod.classic);
    public static final Block BOREALIS_HULL_03 = registerBlock(new BorealisHull(Material.IRON), "borealis_hull_03", InitMod.classic);
    public static final Block BOREALIS_DECK_01 = registerBlock(new BorealisDecoration(Material.IRON), "borealis_deck_01", InitMod.classic);
    public static final Block BOREALIS_STRUCTURE_01 = registerBlock(new BorealisDecoration(Material.IRON), "borealis_structure_01", InitMod.classic);
    public static final Block BOREALIS_STACK_01 = registerBlock(new BorealisDecoration(Material.IRON), "borealis_stack_01", InitMod.classic);
    public static final Block BOREALIS_STACK_02 = registerBlock(new BorealisDecoration(Material.IRON), "borealis_stack_02", InitMod.classic);
    public static final Block OLD_GRATING_00 = registerBlock(new ScaffoldBlocks(Material.IRON), "old_grating_00", InitMod.classic);
    public static final Block OLD_GRATING_01 = registerBlock(new ScaffoldBlocks(Material.IRON), "old_grating_01", InitMod.classic);
    public static final Block OLD_SERVER_00 = registerBlock(new Servers(Material.IRON), "old_server_00", InitMod.classic);
    private static Block registerBlock(Block block, String name) {
        block.setTranslationKey(name);
        block.setRegistryName(name);
        BLOCKS.add(block);
        if(block instanceof IHaveItem) {
            if(((IHaveItem) block).getItem() != null) ModItems.ITEMS.add(((IHaveItem) block).getItem());
        }
        return block;
    }

    private static Block registerBlock(Block block, String name, CreativeTabs tab) {
        block.setCreativeTab(tab);
        return registerBlock(block, name);
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
    }
}
