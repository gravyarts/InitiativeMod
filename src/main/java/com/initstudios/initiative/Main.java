/*
    Copyright (C) 2018-2019 Init Studios. All rights reserved.

    This document is the property of Init Studios.
    It is considered confidential and proprietary.

    This document may not be reproduced or transmitted in any form,
    in whole or in part, without the express written permission of
    Init Studios.
 */

package com.initstudios.initiative;

import com.initstudios.initiative.common.blocks.ModBlocks;
import com.initstudios.initiative.common.items.ModItems;
import com.initstudios.initiative.proxy.ClientProxy;
import com.initstudios.initiative.proxy.CommonProxy;
import com.initstudios.initiative.util.LoggingUtil;
import com.initstudios.initiative.util.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS, dependencies = Reference.DEPENDENCIES_FORGE, guiFactory = Reference.GUI_FACTORY)
public class Main 
{
    public static FMLCommonHandler commonHandler;

    @Instance
    public static Main instance;
    
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;
    public static ClientProxy clientproxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
       LoggingUtil.initiativeLogger = event.getModLog();
       ModItems.init();
       LoggingUtil.info("Initiative Mod pre initialisation has begun! :D");
       proxy.preInit(event);

       proxy.syncConfig();
    }
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
       LoggingUtil.info("Initiative Mod initialisation has begun! :D");

       proxy.init(event);
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
       LoggingUtil.info("Initiative Mod post initialisation has begun! :D");

       proxy.postInit(event);
    }
    
    public static CreativeTabs items = new CreativeTabs("items")
	{
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.OW_BH_UNSTABLE);
        }
    };
    public static CreativeTabs laboratory = new CreativeTabs("laboratory")
	{
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.CUBE_INITMOD);
        }
    };
    public static CreativeTabs classic = new CreativeTabs("classic")
    {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.BOREALIS_HULL_01);
        }
    };

    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.PostConfigChangedEvent event)
    {
        if (event.getModID().equals(Reference.MOD_ID))
        {
            proxy.syncConfig();
        }
    }
}
