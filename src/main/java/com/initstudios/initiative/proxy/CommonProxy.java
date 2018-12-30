package com.initstudios.initiative.proxy;

import com.initstudios.initiative.util.InitiativeConfig;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

public class CommonProxy {

	public static Configuration config;

	public void preInit(FMLPreInitializationEvent event)
	{
		File dir = event.getModConfigurationDirectory();
		config = new Configuration(new File(dir.getPath(), "initiative.cfg"));
		InitiativeConfig.readCfg();
	}

	public void init(FMLInitializationEvent event)
	{

	}

	public void postInit(FMLPostInitializationEvent event)
	{
		if (config.hasChanged()) {
			config.save();
		}
	}

	public void registerItemRenderer(Item item, int meta, String id) {}
}
