/*
    Copyright (C) 2018-2019 Init Studios. All rights reserved.

    This document is the property of Init Studios.
    It is considered confidential and proprietary.

    This document may not be reproduced or transmitted in any form,
    in whole or in part, without the express written permission of
    Init Studios.
 */

package com.initstudios.initiative.common.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;

public class ScaffoldBlocks extends LabBlocks {

    public ScaffoldBlocks(Material material) {
        super(material);
        setSoundType(SoundType.STONE);
        setHardness(5F);
        setResistance(30F);
        this.setHarvestLevel("pickaxe", 1);
    }
    @Override
    public Item getItem() {
        return new ItemBlock(this).setRegistryName(getRegistryName());
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    @Override
    public boolean isFullCube(final IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isOpaqueCube(final IBlockState state)
    {
        return false;
    }
}