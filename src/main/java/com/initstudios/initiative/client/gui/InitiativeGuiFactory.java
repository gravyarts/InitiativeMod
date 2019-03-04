package com.initstudios.initiative.client.gui;

import com.initstudios.initiative.proxy.ClientProxy;
import com.initstudios.initiative.proxy.CommonProxy;
import com.initstudios.initiative.util.Reference;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.DefaultGuiFactory;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

import java.util.ArrayList;
import java.util.List;

public class InitiativeGuiFactory extends DefaultGuiFactory
{
    public InitiativeGuiFactory()
    {
        super(Reference.MOD_ID, GuiConfig.getAbridgedConfigPath(CommonProxy.config.toString()));
    }

    @Override
    public GuiScreen createConfigGui(GuiScreen parentScreen)
    {
        return new GuiConfig(parentScreen, getElements(), Reference.MOD_ID, false, false, title);
    }

    private static List<IConfigElement> getElements()
    {
        List<IConfigElement> list = new ArrayList<>();

        list.addAll((new ConfigElement(ClientProxy.configuration.getCategory("general"))).getChildElements());
        list.addAll((new ConfigElement(ClientProxy.configuration.getCategory("visual"))).getChildElements());

        return list;
    }
}
