/*
    Copyright (C) 2018-2019 Init Studios. All rights reserved.

    This document is the property of Init Studios.
    It is considered confidential and proprietary.

    This document may not be reproduced or transmitted in any form,
    in whole or in part, without the express written permission of
    Init Studios.
 */

package com.initstudios.initiative.proxy;

import com.initstudios.initiative.common.entity.projectile.EntitySpeedGelBall;
import com.initstudios.initiative.common.items.ModItems;
import com.initstudios.initiative.network.PacketHandler;
import com.initstudios.initiative.util.InitiativeConfig;
import com.initstudios.initiative.util.handlers.RegistryHandler;
import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.IProjectile;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
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

        RegistryHandler.registerEntities();

		PacketHandler.initialize();
	}

	public void init(FMLInitializationEvent event)
	{

	}

	public void postInit(FMLPostInitializationEvent event)
	{
		if (config.hasChanged()) {
			config.save();
		}

		registerDispenserBehaviors();
	}

	static void registerDispenserBehaviors()
	{
		BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(ModItems.LB_GEL_SPEED_BALL, new BehaviorProjectileDispense()
		{
			/**
			 * Return the projectile entity spawned by this dispense behavior.
			 */
			protected IProjectile getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn)
			{
				return new EntitySpeedGelBall(worldIn, position.getX(), position.getY(), position.getZ());
			}
		});
	}

	public void syncConfig() {}

	public void registerItemRenderer(Item item, int meta, String id) {}
}
