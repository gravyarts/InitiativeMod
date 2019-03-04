package com.initstudios.initiative.util;

import com.google.common.collect.Lists;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.util.List;

@Mod.EventBusSubscriber(Side.CLIENT)
public class SoundHandler
{
    private static List<SoundEvent> sounds = Lists.newArrayList();
    public static final SoundEvent PING_BLOOP = createSound("bloop");

    private static SoundEvent createSound(String name)
    {
        ResourceLocation resourceLocation = new ResourceLocation(Reference.MOD_ID, name);
        SoundEvent sound = new SoundEvent(resourceLocation);

        sound.setRegistryName(name);
        sounds.add(sound);

        return sound;
    }

    @SubscribeEvent
    public static void registerSound(RegistryEvent.Register<SoundEvent> event)
    {
        for (SoundEvent sound : sounds)
        {
            event.getRegistry().register(sound);
        }
    }
}
