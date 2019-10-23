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
import com.initstudios.initiative.util.IHaveItem;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHaveItem {
	public BlockBase(Material material) {
		super(material);
		setCreativeTab(InitMod.items);
	}

	@Override
	public Item getItem() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}
}