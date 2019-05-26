/*
    Copyright (C) 2018-2019 Init Studios. All rights reserved.

    This document is the property of Init Studios.
    It is considered confidential and proprietary.

    This document may not be reproduced or transmitted in any form,
    in whole or in part, without the express written permission of
    Init Studios.
 */

package com.initstudios.initiative.common.items;

import com.initstudios.initiative.Main;
import com.initstudios.initiative.util.IHasModel;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

	public ItemBase() {
		setCreativeTab(Main.items);
		
		ModItems.ITEMS.add(this);
	}
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}

}