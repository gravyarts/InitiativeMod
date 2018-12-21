package com.initstudios.initiative.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class MDOre extends BlockBase{

	public MDOre(String name, Material material) {
		super(name, material);
		// TODO Auto-generated constructor stub
		setSoundType(SoundType.STONE);
		setHardness(22.5F);
		setResistance(30F);
		setHarvestLevel("pickaxe", 3);
	}
}
