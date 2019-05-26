package com.initstudios.initiative.common.blocks;

import com.initstudios.initiative.Main;
import com.initstudios.initiative.common.items.ModItems;
import com.initstudios.initiative.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class HandheldPedestal extends Block implements IHasModel {

    private static final AxisAlignedBB PEDESTAL_AABB = new AxisAlignedBB(0.5D, 0.0D, 0.5D, 0.5D, 1.25D, 0.5D);

	public HandheldPedestal(String name, Material material) {
		super(material);
		setTranslationKey(name);
		setRegistryName(name);
		setCreativeTab(Main.items);
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return PEDESTAL_AABB;
    }

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
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