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
import net.minecraft.block.material.*;
import net.minecraft.block.state.IBlockState;

public class LightBlocks extends LabBlocks {

    public LightBlocks(Material material) {
        super(material);
        setSoundType(SoundType.GLASS);
        setHardness(1F);
        setResistance(10F);
        this.setLightLevel(1.0F);
        this.setHarvestLevel("pickaxe", 0);
    }
    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }
}