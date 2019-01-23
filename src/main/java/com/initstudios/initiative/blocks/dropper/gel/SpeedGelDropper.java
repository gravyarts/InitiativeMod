package com.initstudios.initiative.blocks.dropper.gel;

import com.initstudios.initiative.blocks.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;

public class SpeedGelDropper extends BlockBase
{
    public SpeedGelDropper(String name, Material material)
    {
        super(name, material);
    }

    @Override
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
}
