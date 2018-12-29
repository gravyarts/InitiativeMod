package com.initstudios.initiative.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

/**
 * This is the central logging class for the Initiative Mod.
 *
 * It provides a link between the Initiative Mod and Log4J.
 * It can be used to log errors, warnings, info and debugging events, all within the Initiative Mod.
 *
 * To use it, type {@code LoggingUtil.level(message)}.
 * Replace "level" with your desired logging level, and replace "message" with the message string you want to log.
 *
 * @author iBuyMountainDew (Dewy)
 */
public class LoggingUtil {

   /**
    * The main Log4J logger variable, used to talk to the {@link Logger} interface.
    */
   public static Logger initiativeLogger;

   /**
    * Logs a message object with the {@link Level#INFO INFO} level.
    *
    * @param message the message string to log.
    */
   public static void info(String message) {
      initiativeLogger.info(message);
   }

   /**
    * Logs a message object with the {@link Level#WARN WARN} level.
    *
    * @param message the message string to log.
    */
   public static void warn(String message) {
      initiativeLogger.warn(message);
   }

   /**
    * Logs a message object with the {@link Level#ERROR ERROR} level.
    *
    * @param message the message string to log.
    */
   public static void error(String message) {
      initiativeLogger.error(message);
   }

   /**
    * Logs a message object with the {@link Level#FATAL FATAL} level.
    *
    * @param message the message string to log.
    */
   public static void fatal(String message) {
      initiativeLogger.fatal(message);
   }

   /**
    * Logs a message object with the {@link Level#DEBUG DEBUG} level.
    *
    * @param message the message string to log.
    */
   public static void debug(String message) {
      initiativeLogger.debug(message);
   }

   /**
    * Logs a message object with the given level.
    *
    * @param level the logging level.
    * @param message the message string to log.
    */
   public static void logWithLevel(Level level, String message) {
      initiativeLogger.log(level, message);
   }
}
