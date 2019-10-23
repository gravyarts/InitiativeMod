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
import com.initstudios.initiative.keybinds.PingtoolKeybindHandler;
import com.initstudios.initiative.network.PacketHandler;
import com.initstudios.initiative.network.packet.ClientSendPing;
import com.initstudios.initiative.pingTool.PingType;
import com.initstudios.initiative.pingTool.PingWrapper;
import com.initstudios.initiative.util.RaytraceHelper;
import com.initstudios.initiative.util.render.RenderSpeedGelBall;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.awt.*;

public class ClientProxy extends CommonProxy
{
	public static int pingR;
	public static int pingG;
	public static int pingB;

	public static boolean pingBlockOverlay;
	public static boolean pingMenuBackground;
	public static boolean sound;

	public static double pingAcceptDistance;
	public static int pingDuration;

	public static Configuration configuration;

	public static void sendPing(PingType type)
	{
		RayTraceResult mob = RaytraceHelper.raytrace(Minecraft.getMinecraft().player, 50);

		System.out.println("wwwwwwwwwww");

		if (mob != null && mob.typeOfHit == RayTraceResult.Type.BLOCK)
		{
			sendPing(mob, new Color(ClientProxy.pingR, ClientProxy.pingG, ClientProxy.pingB).getRGB(), type);
		}
	}

	private static void sendPing(RayTraceResult mob, int colour, PingType type)
	{
		PacketHandler.INSTANCE.sendToServer(new ClientSendPing(new PingWrapper(mob.getBlockPos(), colour, type)));
	}

	@Override
	public void preInit(FMLPreInitializationEvent event)
	{
		super.preInit(event);

		RenderingRegistry.registerEntityRenderingHandler(EntitySpeedGelBall.class, RenderSpeedGelBall::new);

		ClientRegistry.registerKeyBinding(PingtoolKeybindHandler.KEY_BINDING);
		ClientRegistry.registerKeyBinding(PingtoolKeybindHandler.PING_ALERT);
		ClientRegistry.registerKeyBinding(PingtoolKeybindHandler.PING_MINE);
		ClientRegistry.registerKeyBinding(PingtoolKeybindHandler.PING_LOOK);
		ClientRegistry.registerKeyBinding(PingtoolKeybindHandler.PING_GOTO);

		configuration = new Configuration(event.getSuggestedConfigurationFile());
		configuration.load();
	}

	@Override
	public void syncConfig()
	{
		Property p_pingR = configuration.get("visual", "red", 255, "Value from 0 - 255");
		Property p_pingG = configuration.get("visual", "green", 0, "Value from 0 - 255");
		Property p_pingB = configuration.get("visual", "blue", 0, "Value from 0 - 255");

		pingR = verify(p_pingR);
		pingG = verify(p_pingG);
		pingB = verify(p_pingB);

		pingBlockOverlay = configuration.get("visual", "blockOverlay", true, "Whether to render a colored overlay on the Pinged block").getBoolean();
		pingMenuBackground = configuration.get("visual", "backgroundMenu", true, "Whether to render the Ping Menu background").getBoolean();
		sound = configuration.get("general", "sound", true, "Whether to play a sound when a Ping is received").getBoolean();
		pingAcceptDistance = configuration.get("general", "pingAcceptDistance", 64D, "Maximum distance a Ping can be from you and still be received").getDouble();
		pingDuration = configuration.get("general", "pingDuration", 125, "How long a Ping should remain active before disappearing").getInt();

		if (configuration.hasChanged())
		{
			configuration.save();
		}
	}

	@Override
	public void init(FMLInitializationEvent event)
	{
		super.init(event);
	}

	@Override
	public void postInit(FMLPostInitializationEvent event)
	{
		super.postInit(event);
	}

	private int verify(Property property)
	{
		int val = property.getInt();

		if (val < 0)
		{
			val = 0;
		}
		else if (val > 255)
		{
			val = 255;
		}

		return val;
	}

	@Override
	public void registerItemRenderer(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}
	
	@Override
	public String localize(String unlocalized, Object... args) {
		return I18n.format(unlocalized, args);
	}
	
}