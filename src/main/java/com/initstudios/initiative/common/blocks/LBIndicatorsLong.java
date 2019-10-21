/*
    Copyright (C) 2018-2019 Init Studios. All rights reserved.

    This document is the property of Init Studios.
    It is considered confidential and proprietary.

    This document may not be reproduced or transmitted in any form,
    in whole or in part, without the express written permission of
    Init Studios.
 */

package com.initstudios.initiative.common.blocks;

import com.initstudios.initiative.util.IHaveItem;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class LBIndicatorsLong extends Block implements IHaveItem {
	private static final AxisAlignedBB BUTTON_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 2.0D, 1.0D);
	public LBIndicatorsLong(Material material) {
		super(material);
		this.setSoundType(SoundType.GLASS);
		this.setHardness(2F);
		this.setResistance(10F);
		this.setHarvestLevel("pickaxe", 1);
		this.setLightLevel(1F);
		setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.SOUTH));
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
	public boolean isFullCube(final IBlockState state) {
		return true;
	}

	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return BUTTON_AABB;
	}

	@Override
	public boolean isOpaqueCube(final IBlockState state)
	{
		return false;
	}


	@Override
	public IBlockState getStateFromMeta(int meta) {
		EnumFacing facing = EnumFacing.byIndex(meta);

		if (facing.getAxis() == EnumFacing.Axis.Y) {
			facing = EnumFacing.SOUTH;
		}
		return getDefaultState().withProperty(FACING, facing);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(FACING).getIndex();
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, FACING);
	}

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}
}