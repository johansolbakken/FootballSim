package footballsim.logging;

import java.util.logging.ConsoleHandler;

/**
 * Static logger class
 */
public class Logger {
    private final static java.util.logging.Logger s_JavaLogger = java.util.logging.Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);

    private static boolean s_IsInitialized = false;
    private static LogColorRefrence s_LogColorRefrence = new LogColorRefrence();

    /**
     * Initializes the Logger.
     * Setting up colors.
     * Setting log level to OFF.
     */
    public static void init() {
        if (s_IsInitialized) throw new IllegalStateException("Logger is initialized");

        s_JavaLogger.setUseParentHandlers(false);

        ConsoleHandler handler = new ConsoleHandler();
        LogFormatter formatter = new LogFormatter();
        formatter.setColorRefrence(s_LogColorRefrence);
        handler.setFormatter(formatter);
        s_JavaLogger.addHandler(handler);

        setLevel(LogLevel.OFF);

        s_IsInitialized = true;
    }

    /**
     * Takes in a LogLevel and sets the level in the java logger.
     * @param level the level.
     */
    public static void setLevel(final LogLevel level) {
        java.util.logging.Level newLevel;

        switch (level) {
            case ALL: newLevel = java.util.logging.Level.ALL; break;
            case OFF: newLevel = java.util.logging.Level.OFF; break;
            case FINEST: newLevel = java.util.logging.Level.FINEST; break;
            case FINER: newLevel = java.util.logging.Level.FINER; break;
            case FINE: newLevel = java.util.logging.Level.FINE; break;
            case CONFIG: newLevel = java.util.logging.Level.CONFIG; break;
            case INFO: newLevel = java.util.logging.Level.INFO; break;
            case WARNING: newLevel = java.util.logging.Level.WARNING; break;
            case SEVERE: newLevel = java.util.logging.Level.SEVERE; break;
            default: newLevel = java.util.logging.Level.OFF; break;
        }
        
        s_JavaLogger.setLevel(newLevel);
    }

    /**
     * SEVERE log
     * @param message the message.
     */
    public static void severe(final String message) {
        s_LogColorRefrence.setColor(LogColor.ANSI_RED); 
        s_JavaLogger.log(java.util.logging.Level.SEVERE, message);
    }

    /**
     * WARNING log
     * @param message the message.
     */
    public static void warning(final String message) {
        s_LogColorRefrence.setColor(LogColor.ANSI_YELLOW); 
        s_JavaLogger.log(java.util.logging.Level.WARNING, message);
    }

    /**
     * INFO log
     * @param message the message.
     */
    public static void info(final String message) {
        s_LogColorRefrence.setColor(LogColor.ANSI_GREEN); 
        s_JavaLogger.log(java.util.logging.Level.INFO, message);
    }

    /**
     * CONFIG log
     * @param message the message.
     */
    public static void config(final String message) {
        s_LogColorRefrence.setColor(LogColor.ANSI_WHITE); 
        s_JavaLogger.log(java.util.logging.Level.CONFIG, message);
    }

    /**
     * FINE log
     * @param message the message.
     */
    public static void fine(final String message) {
        s_LogColorRefrence.setColor(LogColor.ANSI_CYAN); 
        s_JavaLogger.log(java.util.logging.Level.FINE, message);
    }

    /**
     * FINER log
     * @param message the message.
     */
    public static void finer(final String message) {
        s_LogColorRefrence.setColor(LogColor.ANSI_BLUE); 
        s_JavaLogger.log(java.util.logging.Level.FINER, message);
    }

    /**
     * FINEST log
     * @param message the message.
     */
    public static void finest(final String message) {
        s_LogColorRefrence.setColor(LogColor.ANSI_PURPLE); 
        s_JavaLogger.log(java.util.logging.Level.FINEST, message);
    }
}