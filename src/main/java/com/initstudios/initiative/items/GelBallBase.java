package com.initstudios.initiative.items;

import com.initstudios.initiative.Main;
import com.initstudios.initiative.init.ModItems;
import com.initstudios.initiative.util.IHasModel;
import net.minecraft.item.ItemSnowball;

public class GelBallBase extends ItemSnowball implements IHasModel
{
    public GelBallBase(String name)
    {
        super();

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.initiative);

        this.maxStackSize = 32;

        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels()
    {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
