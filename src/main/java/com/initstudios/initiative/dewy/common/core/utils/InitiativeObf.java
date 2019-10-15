package com.initstudios.initiative.dewy.common.core.utils;

import com.initstudios.initiative.Main;
import com.initstudios.initiative.dewy.common.blocks.*;
import com.initstudios.initiative.util.Reference;

import java.lang.reflect.Field;

/**
 * A utility class used to detect an obfuscated version of MC.
 */
public class InitiativeObf
{
    private static final String OBF_VERSION = "1.12.2";

    private static boolean isObfuscated;

    /**
     * Detect an obfuscated environment, crash the game if you're running
     * a deobf mod jar in an obfuscated environment.
     */
    public static void detectObfuscation()
    {
        isObfuscated = true;

        try
        {
            Field[] fields = Class.forName("net.minecraft.item.ItemBlock").getDeclaredFields();

            for (Field f : fields)
            {
                f.setAccessible(true);

                if (f.getName().equalsIgnoreCase("block"))
                {
                    isObfuscated = false;

                    if (!Reference.VERSION_OF_MC.equals(OBF_VERSION))
                    {
                        Main.logger.logFatalError("ObfuscationHelper string OBF_VERSION is not updated to match the current MC version! Bad Dewy! Fix it NOW!");

                        Main.commonHandler.exitJava(-1, true);
                    }

                    return;
                }
            }

            BlockNeflis.class.getDeclaredMethod("func_149722_s");
        }
        catch (NoSuchMethodException e)
        {
            throw new RuntimeException("Huh! You seem to be running the deobf version of Initiative Mod in an obfuscated environment! You really shouldn't do this...");
        }
        catch (Exception ignored)
        {

        }
    }
}
