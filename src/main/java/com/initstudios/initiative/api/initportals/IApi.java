package com.initstudios.initiative.api.initportals;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IApi
{
    /**
     * Returns the render level of the Init Portal. 0 means not currently rendering anything/rendering the world. Anything higher means it's rendering an init portal.
     * If you disable stencils or clear the stencil buffer please only do so when getRenderLevel() is 0.
     *
     * @return render level.
     */
    @SideOnly(Side.CLIENT)
    int getRenderLevel();

    /**
     * Returns the camera roll (per render level).
     * That's right, camera roll exists in Minecraft.
     *
     * @param renderLevel the current render level of the Init Portals
     * @param partialTick partial render tick.
     * @return the camera roll for the provided renderLevel. Returns 0 if we don't have a roll for said renderLevel.
     */
    @SideOnly(Side.CLIENT)
    float getCameraRoll(int renderLevel, float partialTick);
}
