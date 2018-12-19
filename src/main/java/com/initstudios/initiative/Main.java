package com.initstudios.initiative;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import org.apache.logging.log4j.Logger;

import com.initstudios.initiative.init.ModItems;
import com.initstudios.initiative.proxy.ClientProxy;
import com.initstudios.initiative.proxy.CommonProxy;
import com.initstudios.initiative.util.Reference;

@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION)
public class Main
{
    public static final String MODID = "im";
    public static final String NAME = "Initiative Mod";
    public static final String VERSION = "0.0.1";

    private static Logger logger;
    
    @Instance
    public static Main instance;
    
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;
    public static ClientProxy clientproxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
    
    public static CreativeTabs initiative = new CreativeTabs("initiative") 
	{
		@Override
		public ItemStack getTabIconItem() 
		{
			return new ItemStack(ModItems.DARK_ENERGY);
		}
	};
}
