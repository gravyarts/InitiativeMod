/*
    Copyright (C) 2018-2019 Init Studios. All rights reserved.

    This document is the property of Init Studios.
    It is considered confidential and proprietary.

    This document may not be reproduced or transmitted in any form,
    in whole or in part, without the express written permission of
    Init Studios.
 */

package com.initstudios.initiative.common.blocks;

import com.initstudios.initiative.Main;
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
    public static final Block CUBE_HEART_OFF = registerBlock(new LBCubes(Material.ANVIL), "cube_heart_off", Main.items);
    public static final Block CUBE_STORAGE_OFF = registerBlock(new LBCubes(Material.ANVIL), "cube_storage_off", Main.items);
    public static final Block CUBE_REFLECT = registerBlock(new LBCubes(Material.ANVIL), "cube_reflect", Main.items);
    //Dropper
    public static final Block LB_GEL_JUMP_DROPPER = registerBlock(new LBDropper(Material.IRON), "lb_gel_jump_dropper", Main.items);
    public static final Block LB_GEL_SPEED_DROPPER = registerBlock(new LBDropper(Material.IRON), "lb_gel_speed_dropper", Main.items);
    public static final Block LB_GEL_WHITE_DROPPER = registerBlock(new LBDropper(Material.IRON), "lb_gel_white_dropper", Main.items);
    public static final Block LB_CUBE_DROPPER = registerBlock(new LBDropper(Material.IRON), "lb_cube_dropper", Main.items);
    //Gel
    //GEL_SPEED needs fixing <3
    public static final Block GEL_SPEED = registerBlock(new LBGelSpeed(MaterialGel.GEL), "gel_speed", Main.items);
    //Lab Blocks
    public static final Block PANEL_SURFACE_01 = registerBlock(new Portable(Material.IRON), "panel_surface_01", Main.panels);
    public static final Block PANEL_SURFACE_02 = registerBlock(new Portable(Material.IRON), "panel_surface_02", Main.panels);
    public static final Block PANEL_SURFACE_11 = registerBlock(new NonPortable(Material.IRON), "panel_surface_11", Main.panels);
    public static final Block PANEL_SURFACE_12 = registerBlock(new NonPortable(Material.IRON), "panel_surface_12", Main.panels);
    public static final Block PANEL_SURFACE_21 = registerBlock(new NonPortable(Material.IRON), "panel_surface_21", Main.panels);
    public static final Block PANEL_SURFACE_22 = registerBlock(new NonPortable(Material.IRON), "panel_surface_22", Main.panels);
    public static final Block PANEL_SURFACE_31 = registerBlock(new Portable(Material.IRON), "panel_surface_31", Main.panels);
    //Borealis Blocks
    public static final Block BOREALIS_HULL_01 = registerBlock(new BorealisHull(Material.IRON), "borealis_hull_01", Main.borealis);
    public static final Block BOREALIS_HULL_02 = registerBlock(new BorealisHull(Material.IRON), "borealis_hull_02", Main.borealis);
    public static final Block BOREALIS_HULL_03 = registerBlock(new BorealisHull(Material.IRON), "borealis_hull_03", Main.borealis);
    public static final Block BOREALIS_DECK_01 = registerBlock(new BorealisDecoration(Material.IRON), "borealis_deck_01", Main.borealis);
    public static final Block BOREALIS_STRUCTURE_01 = registerBlock(new BorealisDecoration(Material.IRON), "borealis_structure_01", Main.borealis);
    public static final Block BOREALIS_STACK_01 = registerBlock(new BorealisDecoration(Material.IRON), "borealis_stack_01", Main.borealis);
    public static final Block BOREALIS_STACK_02 = registerBlock(new BorealisDecoration(Material.IRON), "borealis stack_02", Main.borealis);

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
