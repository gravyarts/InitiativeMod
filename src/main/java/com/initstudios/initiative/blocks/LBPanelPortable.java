package com.initstudios.initiative.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class LBPanelPortable extends BlockBase{

	public LBPanelPortable(String name, Material material) {
		super(name, material);
		// TODO Auto-generated constructor stub
		setSoundType(SoundType.STONE);
		setHardness(0F);
		setResistance(0F);
	}
}
