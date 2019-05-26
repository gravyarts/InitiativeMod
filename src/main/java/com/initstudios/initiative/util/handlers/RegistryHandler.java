/*
    Copyright (C) 2018-2019 Init Studios. All rights reserved.

    This document is the property of Init Studios.
    It is considered confidential and proprietary.

    This document may not be reproduced or transmitted in any form,
    in whole or in part, without the express written permission of
    Init Studios.
 */

package com.initstudios.initiative.util.handlers;

import com.initstudios.initiative.common.entity.projectile.EntitySpeedGelBall;
import com.initstudios.initiative.common.init.ModBlocks;
import com.initstudios.initiative.common.init.ModItems;
import com.initstudios.initiative.util.IHasModel;

import com.initstudios.initiative.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

@EventBusSubscriber
public class RegistryHandler {

	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
	}
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
	}

	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		for(Item item : ModItems.ITEMS) {
			if(item instanceof IHasModel) {
				((IHasModel)item).registerModels();
			}
		}
		for(Block block : ModBlocks.BLOCKS) {
			if(block instanceof IHasModel) {
				((IHasModel)block).registerModels();
			}
		}
	}

	public static void registerEntities()
	{
		ResourceLocation speedGelBallRL = new ResourceLocation(Reference.MOD_ID, "lb_gel_speed_ball");

		EntityEntry speedGelBallEntity = EntityEntryBuilder.create().entity(EntitySpeedGelBall.class)
				.id(speedGelBallRL, 1).name("lb_gel_speed_ball").tracker(64, 20, true).build();

		ForgeRegistries.ENTITIES.register(speedGelBallEntity);
	}
}
