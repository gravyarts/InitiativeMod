package com.initstudios.initiative.common.blocks;

import com.initstudios.initiative.util.IHaveItem;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class HandheldPedestal extends Block implements IHaveItem {

    private static final AxisAlignedBB PEDESTAL_AABB = new AxisAlignedBB(0.5D, 0.0D, 0.5D, 0.5D, 1.25D, 0.5D);

	public HandheldPedestal(Material material) {
		super(material);
	}

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return PEDESTAL_AABB;
    }

    @Override
    public Item getItem() {
        return new ItemBlock(this).setRegistryName(getRegistryName());
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public boolean isFullCube(final IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isOpaqueCube(final IBlockState state)
    {
        return false;
    }


}