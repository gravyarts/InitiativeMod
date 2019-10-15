package com.initstudios.initiative.dewy.common.core;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InitiativeLogger
{
    public final String MOD_NAME;
    public final Logger INIT_LOGGER;

    private InitiativeLogger(String modName)
    {
        this.MOD_NAME = modName;

        INIT_LOGGER = LogManager.getLogger(MOD_NAME);
    }

    public void log(Level logLevel, String format, Object... msg)
    {
        INIT_LOGGER.log(logLevel, String.format(format, msg));
    }

    public void log(Level logLevel, Object msg)
    {
        log(logLevel, "%s", msg);
    }

    public void logInfo(Object msg)
    {
        log(Level.INFO, msg);
    }

    public void logWarn(Object msg)
    {
        log(Level.WARN, msg);
    }

    public void logError(Object msg)
    {
        log(Level.ERROR, msg);
    }

    public void logFatalError(Object msg)
    {
        log(Level.FATAL, msg);
    }

    public void logDebug(Object msg)
    {
        log(Level.DEBUG, msg);
    }

    public void logDebugTrace(Object msg)
    {
        log(Level.TRACE, msg);
    }

    public static InitiativeLogger createInitiativeLogger(String modName)
    {
        return new InitiativeLogger(modName);
    }
}
