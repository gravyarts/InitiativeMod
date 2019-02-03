package com.initstudios.initiative.blocks;

import com.initstudios.initiative.Main;
import com.initstudios.initiative.init.ModBlocks;
import com.initstudios.initiative.init.ModItems;
import com.initstudios.initiative.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;

public class LBCubes extends Block implements IHasModel {
	public LBCubes(String name, Material material) {
		super(material);
		setUnlocalizedName(name);
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
    public BlockRenderLayer getBlockLayer()
    {
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