package com.initstudios.initiative.api.initportals;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * A dummy implementation of IApi. The API of nothing, if you will.
 */
public class ApiDummy implements IApi
{
    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderLevel()
    {
        return 0;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public float getCameraRoll(int renderLevel, float partialTick)
    {
        return 0F;
    }
}
