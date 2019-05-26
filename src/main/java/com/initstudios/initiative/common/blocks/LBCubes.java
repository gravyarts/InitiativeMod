package com.initstudios.initiative.common.blocks;

import com.initstudios.initiative.Main;
import com.initstudios.initiative.common.init.ModBlocks;
import com.initstudios.initiative.common.init.ModItems;
import com.initstudios.initiative.util.IHasModel;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;

public class LBCubes extends BlockFalling implements IHasModel {
	public LBCubes(String name, Material material) {
		super(material);
		setTranslationKey(name);
		setRegistryName(name);
		setCreativeTab(Main.items);
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
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