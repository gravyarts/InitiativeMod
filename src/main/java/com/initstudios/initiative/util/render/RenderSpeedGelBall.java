/*
    Copyright (C) 2018-2019 Init Studios. All rights reserved.

    This document is the property of Init Studios.
    It is considered confidential and proprietary.

    This document may not be reproduced or transmitted in any form,
    in whole or in part, without the express written permission of
    Init Studios.
 */

package com.initstudios.initiative.util.render;

import com.initstudios.initiative.entity.projectile.EntitySpeedGelBall;
import com.initstudios.initiative.model.ModelGelBall;
import com.initstudios.initiative.util.Reference;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderSpeedGelBall extends Render<EntitySpeedGelBall>
{
    private final ModelGelBall model = new ModelGelBall();

    public RenderSpeedGelBall(RenderManager renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    public void doRender(EntitySpeedGelBall entity, double x, double y, double z, float entityYaw, float partialTicks) {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)x,(float)y,(float)z);
        GlStateManager.enableRescaleNormal();
        GlStateManager.rotate(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate((float)(this.renderManager.options.thirdPersonView == 2 ? -1 : 1) * this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
        this.bindEntityTexture(entity);

        model.render(entity,partialTicks,0f,-1f,0f,0f,0.01f);
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(entity,x, y, z, entityYaw, partialTicks);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntitySpeedGelBall entity) {
        return new ResourceLocation(Reference.MOD_ID,"textures/items/lb_gel_speed_ball.png");
    }

}
