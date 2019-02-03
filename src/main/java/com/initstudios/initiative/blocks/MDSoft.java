/*
    Copyright (C) 2018-2019 Init Studios. All rights reserved.

    This document is the property of Init Studios.
    It is considered confidential and proprietary.

    This document may not be reproduced or transmitted in any form,
    in whole or in part, without the express written permission of
    Init Studios.
 */

package com.initstudios.initiative.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class MDSoft extends BlockBase{

	public MDSoft(String name, Material material) {
		super(name, material);
		// TODO Auto-generated constructor stub
		setSoundType(SoundType.SAND);
		setHardness(0.5F);
		setResistance(2.5F);
		setHarvestLevel("shovel", 2);
	}
}
