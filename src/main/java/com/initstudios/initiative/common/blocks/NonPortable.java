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

public class NonPortable extends LaboratoryBlocks {

	public NonPortable(Material material) {
		super(material);
		setSoundType(SoundType.STONE);
		setHardness(0F);
		setResistance(0F);
	}
}