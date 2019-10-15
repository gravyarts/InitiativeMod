package com.initstudios.initiative.dewy.common.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumHandSide;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

public class ItemHandler
{
    private static HashMap<Class<? extends Item>, DualieCallback> dualies = new HashMap<>();

    // Any item that's registered here can't ever use Minecraft's default "use timer". Instead, their use timer (getMaxItemUseDuration) must be set to Integer.MAX_VALUE.
    private static void registerDualie(@Nonnull Class<? extends Item> clazz, DualieCallback dualieCallback)
    {
        dualies.put(clazz, dualieCallback != null ? dualieCallback : DualieCallback.DEFAULT);
    }

    public static void registerDualie(@Nonnull Class<? extends Item> clazz)
    {
        registerDualie(clazz, null);
    }

    public static DualieCallback getDualieCallback(ItemStack item)
    {
        for (Map.Entry<Class<? extends Item>, DualieCallback> entry : dualies.entrySet())
        {
            if (entry.getKey().isInstance(item.getItem()))
            {
                return entry.getValue();
            }
        }

        return DualieCallback.DEFAULT;
    }

    public static boolean isItemADualie(ItemStack item)
    {
        if (item.isEmpty())
        {
            return false;
        }

        for (Map.Entry<Class<? extends Item>, DualieCallback> entry : dualies.entrySet())
        {
            if (entry.getKey().isInstance(item.getItem()))
            {
                return entry.getValue().isItemDualie(item);
            }
        }

        return false;
    }

    public static boolean canBeUsed(EntityLivingBase user, ItemStack item)
    {
        return item != null && (!isItemADualie(item) || getDualieCallback(item).canBeUsed(item, user) && (user.getHeldItem(EnumHand.MAIN_HAND) == item && user.getHeldItem(EnumHand.OFF_HAND).isEmpty() || user.getHeldItem(EnumHand.OFF_HAND) == item && user.getHeldItem(EnumHand.MAIN_HAND).isEmpty()));
    }

    public static @Nonnull ItemStack getUsableDualie(EntityLivingBase user) // If the item can't be used, it returns null.
    {
        ItemStack item = user.getHeldItem(EnumHand.MAIN_HAND);

        if (isItemADualie(item) && canBeUsed(user, item))
        {
            return item;
        }

        item = user.getHeldItem(EnumHand.OFF_HAND);

        if (isItemADualie(item) && canBeUsed(user, item))
        {
            return item;
        }

        return ItemStack.EMPTY;
    }

    public static EnumHandSide getHandSide(EntityLivingBase living, ItemStack is)
    {
        return living.getHeldItem(EnumHand.OFF_HAND) == is ? living.getPrimaryHand().opposite() : living.getPrimaryHand();
    }
}
