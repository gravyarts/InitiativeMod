package com.initstudios.initiative.common.blocks;

import com.initstudios.initiative.util.IHaveItem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;

public class LabBlocks extends Block implements IHaveItem {
    public LabBlocks(Material material) {
        super(material);
    }

    @Override
    public Item getItem() {
        return new ItemBlock(this).setRegistryName(getRegistryName());
    }
}