package com.initstudios.initiative.common.items;

import com.initstudios.initiative.Main;
import com.initstudios.initiative.common.init.ModItems;
import com.initstudios.initiative.util.IHasModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemPortalGun extends Item implements IHasModel
{
    public ItemPortalGun(String name)
    {
        super();

        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(Main.items);

        maxStackSize = 1;
        setMaxDamage(0);

        ModItems.ITEMS.add(this);
    }

    public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, EntityPlayer player)
    {
        return false;
    }

    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
        return true;
    }

    public EnumActionResult onItemUseFirst(EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, EnumHand hand)
    {
        return EnumActionResult.SUCCESS;
    }

    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.BOW;
    }

    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 2147483647;
    }

    @Override
    public void registerModels()
    {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
