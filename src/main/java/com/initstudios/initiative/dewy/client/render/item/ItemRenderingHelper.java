package com.initstudios.initiative.dewy.client.render.item;

import com.initstudios.initiative.dewy.common.item.ItemHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumHandSide;
import net.minecraftforge.client.event.RenderSpecificHandEvent;

import javax.annotation.Nullable;
import java.util.HashSet;

public class ItemRenderingHelper
{
    private static int lastThirdPersonView;

    private static HashSet<SwingProofHandler> swingProofItems = new HashSet<>();

    private static int prevCurItem;
    private static boolean currentItemIsSwingProof;
    private static boolean hasShownItemName;

    public static int dualieAnimationRight;
    public static int dualieAnimationLeft;
    public static int prevDualieAnimationRight;
    public static int prevDualieAnimationLeft;

    public static int dualieAnimationTime = 5;

    public static class SwingProofHandler
    {
        public final Class<? extends Item> itemClass;
        public final @Nullable IItemEquippedHandler hand;

        public SwingProofHandler(Class<? extends Item> itemClass, IItemEquippedHandler hand)
        {
            this.itemClass = itemClass;
            this.hand = hand;
        }

        public interface IItemEquippedHandler
        {
            void handleEquip(EntityPlayerSP player, ItemStack stack);

            boolean hideName();
        }

        @Override
        public boolean equals(Object obj)
        {
            if (obj instanceof SwingProofHandler)
            {
                SwingProofHandler swing = (SwingProofHandler)obj;

                return swing.itemClass == itemClass && swing.hand.getClass() == hand.getClass();
            }

            return false;
        }
    }

    public static void registerSwingProofItem(SwingProofHandler handler)
    {
        for (SwingProofHandler swingProofHandler : swingProofItems)
        {
            if (swingProofHandler.itemClass.equals(handler.itemClass))
            {
                return;
            }
        }

        swingProofItems.add(handler);
    }

    private static boolean isItemSwingProof(Item item)
    {
        for (SwingProofHandler swingProofHandler : swingProofItems)
        {
            if (swingProofHandler.itemClass.isInstance(item))
            {
                return true;
            }
        }

        return false;
    }

    private static void handleSwingProofItemEquip(EntityPlayerSP player, ItemStack stack)
    {
        for (SwingProofHandler swingProofHandler : swingProofItems)
        {
            if (swingProofHandler.itemClass.isInstance(stack.getItem()))
            {
                if (swingProofHandler.hand != null)
                {
                    swingProofHandler.hand.handleEquip(player, stack);
                }

                break;
            }
        }
    }

    public static void handlePreRender(Minecraft mc)
    {
        if (mc.player != null)
        {
            ItemStack currentInv = mc.player.getHeldItemMainhand();

            if (!currentInv.isEmpty())
            {
                if (isItemSwingProof(currentInv.getItem()))
                {
                    mc.playerController.resetBlockRemoving();

                    if (prevCurItem == mc.player.inventory.currentItem)
                    {
                        if (!currentItemIsSwingProof)
                        {
                            handleSwingProofItemEquip(mc.player, currentInv);
                        }

                        if (currentInv.getItem().shouldCauseReequipAnimation(currentInv, mc.getItemRenderer().itemStackMainHand, false))
                        {
                            mc.getItemRenderer().itemStackMainHand = currentInv;
                        }

                        if (mc.ingameGUI.remainingHighlightTicks == 0)
                        {
                            hasShownItemName = true;
                        }

                        if (hasShownItemName)
                        {
                            mc.ingameGUI.remainingHighlightTicks = 0;
                        }
                    }

                    if (mc.player.ticksSinceLastSwing < 2)
                    {
                        mc.entityRenderer.itemRenderer.equippedProgressMainHand = 1F;
                    }

                    mc.player.ticksSinceLastSwing = 10000;
                    mc.player.isSwingInProgress = false;
                    mc.player.swingProgressInt = 0;
                    mc.player.swingProgress = 0;
                }
            }

            currentItemIsSwingProof = !currentInv.isEmpty() && isItemSwingProof(currentInv.getItem());

            if (prevCurItem != mc.player.inventory.currentItem)
            {
                if (mc.player.inventory.currentItem >= 0 && mc.player.inventory.currentItem <= 9 && mc.entityRenderer.itemRenderer.equippedProgressMainHand >= 1.0F)
                {
                    prevCurItem = mc.player.inventory.currentItem;
                }

                currentItemIsSwingProof = false;
                hasShownItemName = false;
            }
        }
    }

    public static void onRenderSpecificHand(RenderSpecificHandEvent event)
    {
        if (event.getHand() == EnumHand.MAIN_HAND && event.getItemStack().isEmpty())
        {
            ItemStack item = Minecraft.getMinecraft().player.getHeldItem(EnumHand.OFF_HAND);

            if (!item.isEmpty() && ItemHandler.isItemADualie(item))
            {
                event.setCanceled(true);
            }
        }
    }

    public static void handlePlayerTick(Minecraft mc, EntityPlayer player)
    {
        boolean isRenderViewEntity = mc.getRenderViewEntity() == player;

        if (isRenderViewEntity)
        {
            prevDualieAnimationLeft = dualieAnimationLeft;
            prevDualieAnimationRight = dualieAnimationRight;

            dualieAnimationRight++;
            dualieAnimationLeft++;

            dualieAnimationTime = 4;

            if (dualieAnimationRight > dualieAnimationTime)
            {
                dualieAnimationRight = dualieAnimationTime;
            }

            if (dualieAnimationLeft > dualieAnimationTime)
            {
                dualieAnimationLeft = dualieAnimationTime;
            }
        }

        ItemStack heldItem = player.getHeldItem(EnumHand.MAIN_HAND);

        if (!heldItem.isEmpty() && ItemHandler.isItemADualie(heldItem) && ItemHandler.canBeUsed(player, heldItem))
        {
            if (isRenderViewEntity)
            {
                if (player.getPrimaryHand() == EnumHandSide.RIGHT)
                {
                    dualieAnimationRight -= 2;

                    if (dualieAnimationRight < 0)
                    {
                        dualieAnimationRight = 0;
                    }
                }
                else
                {
                    dualieAnimationLeft -= 2;

                    if (dualieAnimationLeft < 0)
                    {
                        dualieAnimationLeft = 0;
                    }
                }
            }

            if (ItemHandler.getDualieCallback(heldItem).shouldBeHeldLikeABow(heldItem, player) && !(player == mc.getRenderViewEntity() && mc.gameSettings.thirdPersonView == 0))
            {
                if (player.getItemInUseCount() <= 0)
                {
                    player.resetActiveHand();
                    player.setActiveHand(EnumHand.MAIN_HAND);
                }
            }
            else
            {
                player.resetActiveHand();
            }
        }

        heldItem = player.getHeldItem(EnumHand.OFF_HAND);

        if (!heldItem.isEmpty() && ItemHandler.isItemADualie(heldItem) && ItemHandler.canBeUsed(player, heldItem))
        {
            if (isRenderViewEntity)
            {
                if (player.getPrimaryHand() == EnumHandSide.RIGHT)
                {
                    dualieAnimationLeft -= 2;

                    if (dualieAnimationLeft < 0)
                    {
                        dualieAnimationLeft = 0;
                    }
                }
                else
                {
                    dualieAnimationRight -= 2;

                    if (dualieAnimationRight < 0)
                    {
                        dualieAnimationRight = 0;
                    }
                }
            }

            if (ItemHandler.getDualieCallback(heldItem).shouldBeHeldLikeABow(heldItem, player) && !(player == mc.getRenderViewEntity() && mc.gameSettings.thirdPersonView == 0))
            {
                if (player.getItemInUseCount() <= 0)
                {
                    player.resetActiveHand();
                    player.setActiveHand(EnumHand.OFF_HAND);
                }
            }
            else
            {
                player.resetActiveHand();
            }
        }

        if (player == mc.getRenderViewEntity() && mc.gameSettings.thirdPersonView == 0 && !(!heldItem.isEmpty() && ItemHandler.getDualieCallback(heldItem).shouldBeHeldLikeABow(heldItem, player)) && lastThirdPersonView != 0)
        {
            player.resetActiveHand();
        }

        if (player == mc.getRenderViewEntity())
        {
            lastThirdPersonView = mc.gameSettings.thirdPersonView;
        }
    }
}
