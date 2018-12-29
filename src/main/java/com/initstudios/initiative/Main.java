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


import com.initstudios.initiative.init.ModItems;
import com.initstudios.initiative.proxy.ClientProxy;
import com.initstudios.initiative.proxy.CommonProxy;
import com.initstudios.initiative.util.Reference;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
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
    }
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
       LoggingUtil.info("Initiative Mod initialisation has begun! :D");
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
       LoggingUtil.info("Initiative Mod post initialisation has begun! :D");
    }
    
    public static CreativeTabs initiative = new CreativeTabs("initiative") 
	{
		@Override
		public ItemStack getTabIconItem() 
		{
			return new ItemStack(ModItems.OW_BH_UNSTABLE);
		}
	};
}
