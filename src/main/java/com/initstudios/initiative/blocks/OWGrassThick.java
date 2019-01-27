package com.initstudios.initiative.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class OWGrassThick extends BlockBase{

	public OWGrassThick(String name, Material material) {
		super(name, material);
		// TODO Auto-generated constructor stub
		setSoundType(SoundType.PLANT);
		setHardness(0F);
		setResistance(0F);
	}
}
