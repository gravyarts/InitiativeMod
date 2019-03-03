/*
    Copyright (C) 2018-2019 Init Studios. All rights reserved.

    This document is the property of Init Studios.
    It is considered confidential and proprietary.

    This document may not be reproduced or transmitted in any form,
    in whole or in part, without the express written permission of
    Init Studios.
 */

package com.initstudios.initiative;

import com.initstudios.initiative.util.LoggingUtil;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.initstudios.initiative.init.ModBlocks;
import com.initstudios.initiative.init.ModItems;
import com.initstudios.initiative.proxy.ClientProxy;
import com.initstudios.initiative.proxy.CommonProxy;
import com.initstudios.initiative.util.Reference;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS, dependencies = Reference.DEPENDENCIES_FORGE, guiFactory = Reference.GUI_FACTORY)
public class Main 
{

    @Instance
    public static Main instance;
    
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;
    public static ClientProxy clientproxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
       LoggingUtil.initiativeLogger = event.getModLog();
       LoggingUtil.info("Initiative Mod pre initialisation has begun! :D");
       proxy.preInit(event);
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
		public ItemStack getTabIconItem() 
		{
			return new ItemStack(ModItems.OW_BH_UNSTABLE);
		}
	};
    public static CreativeTabs panels = new CreativeTabs("panels")
	{
		@Override
		public ItemStack getTabIconItem() 
		{
			return new ItemStack(ModBlocks.LB_D_FOAM_PATCH);
		}
	};
}
