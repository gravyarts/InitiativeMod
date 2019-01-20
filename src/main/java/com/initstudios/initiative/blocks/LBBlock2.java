package com.initstudios.initiative.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class LBBlock2 extends BlockBase{

	public LBBlock2(String name, Material material) {
		super(name, material);
		// TODO Auto-generated constructor stub
		setSoundType(SoundType.METAL);
		setHardness(40F);
		setResistance(30F);
		setHarvestLevel("pickaxe", 2);
	}
}