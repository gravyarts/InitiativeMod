package com.initstudios.initiative.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class Tardis extends BlockBase {
	public Tardis(String name, Material material) 
	{
		super(name, material);
		// What sound it will make when stepped on, walked on or if breaked or placed
		setSoundType(SoundType.STONE);
		// How hard it will be
		setHardness(2.5f);
		// How resistant it is to TNT
		setResistance(18000000.0f);
		// "pickaxe" is the tool needed to break it, and the number next to it is what level (e.g 1 would be wood level)
		setHarvestLevel("pickaxe", 2);
		
	}
}