package com.initstudios.initiative.network;

import com.initstudios.initiative.network.packet.ClientSendPing;
import com.initstudios.initiative.network.packet.ServerBroadcastPing;
import com.initstudios.initiative.util.Reference;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketHandler
{
    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);
    private static int id = -1;

    public static void initialize()
    {
        INSTANCE.registerMessage(ClientSendPing.class, ClientSendPing.class, id++, Side.SERVER);
        INSTANCE.registerMessage(ServerBroadcastPing.class, ServerBroadcastPing.class, id++, Side.CLIENT);
    }
}
