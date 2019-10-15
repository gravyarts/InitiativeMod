package com.initstudios.initiative.dewy.common.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class DualieCallback
{
    public static final DualieCallback DEFAULT = new DualieCallback();

    public boolean isItemDualie(ItemStack item)
    {
        return true;
    }

    public boolean canBeUsed(ItemStack item, EntityLivingBase user)
    {
        return true;
    }

    public boolean shouldBeHeldLikeABow(ItemStack item, EntityLivingBase user)
    {
        return true;
    }
}
