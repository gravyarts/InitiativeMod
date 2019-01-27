package com.initstudios.initiative.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class MDCore extends BlockBase{

	public MDCore(String name, Material material) {
		super(name, material);
		// TODO Auto-generated constructor stub
		setSoundType(SoundType.METAL);
		setHardness(-1F);
		setResistance(-1F);
		setHarvestLevel("none", 0);
	}
}
