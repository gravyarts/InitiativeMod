package com.initstudios.initiative.network.packet;

import com.initstudios.initiative.client.PingtoolHandler;
import com.initstudios.initiative.pingTool.PingWrapper;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ServerBroadcastPing implements IMessage, IMessageHandler<ServerBroadcastPing, IMessage>
{
    public PingWrapper ping;

    public ServerBroadcastPing() {}

    ServerBroadcastPing(PingWrapper ping)
    {
        this.ping = ping;
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        ping.writeToBuffer(buf);
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        ping = PingWrapper.readFromBuffer(buf);
    }

    @Override
    public IMessage onMessage(ServerBroadcastPing message, MessageContext ctx)
    {
        Minecraft.getMinecraft().addScheduledTask(() -> PingtoolHandler.INSTANCE.onPingPacket(message));

        return null;
    }
}
