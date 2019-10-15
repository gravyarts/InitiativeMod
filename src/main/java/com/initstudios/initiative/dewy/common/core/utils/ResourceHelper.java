package com.initstudios.initiative.dewy.common.core.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.File;

public class ResourceHelper
{
    public static final ResourceLocation texPig = new ResourceLocation("textures/entity/pig/pig.png");
    public static final ResourceLocation texZombie = new ResourceLocation("textures/entity/zombie/zombie.png");

    public static final ResourceLocation texGlint = new ResourceLocation("textures/misc/enchanted_item_glint.png");

    // Client Only***
    private static File fileAssets;
    private static File fileMods;
    private static File fileConfig;

    @SideOnly(Side.CLIENT)
    public static void init()
    {
        fileAssets = new File(Minecraft.getMinecraft().gameDir, "assets");
        fileMods = new File(Minecraft.getMinecraft().gameDir, "mods");
        fileConfig = new File(Minecraft.getMinecraft().gameDir, "config");
    }

    @SideOnly(Side.CLIENT)
    public static File getAssetsFolder()
    {
        return fileAssets;
    }

    @SideOnly(Side.CLIENT)
    public static File getModsFolder()
    {
        return fileMods;
    }

    @SideOnly(Side.CLIENT)
    public static File getConfigFolder()
    {
        return fileConfig;
    }
}
