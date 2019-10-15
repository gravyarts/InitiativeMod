package com.initstudios.initiative.dewy.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;

import java.util.Random;

public class BlockNeflis extends Block
{
    public BlockNeflis()
    {
        super(Material.CAKE);

        blockSoundType = new SoundType(0.8F, 1.0F, SoundEvents.ENTITY_BAT_HURT, SoundEvents.ENTITY_BAT_HURT, SoundEvents.ENTITY_BAT_HURT, SoundEvents.ENTITY_BAT_HURT, SoundEvents.ENTITY_BAT_HURT)
        {
            public Random rand = new Random();

            @Override
            public float getPitch()
            {
                return (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F;
            }
        };

        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        setHardness(0.8F);

        setRegistryName(new ResourceLocation("initmod", "neflis"));
        setTranslationKey("initmod.block.compactporkchop");
    }
}
