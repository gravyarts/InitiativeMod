package com.initstudios.initiative.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class MDStone extends BlockBase{

	public MDStone(String name, Material material) {
		super(name, material);
		// TODO Auto-generated constructor stub
		setSoundType(SoundType.SAND);
		setHardness(0.5F);
		setResistance(2.5F);
		setHarvestLevel("shovel", 2);
	}
}
