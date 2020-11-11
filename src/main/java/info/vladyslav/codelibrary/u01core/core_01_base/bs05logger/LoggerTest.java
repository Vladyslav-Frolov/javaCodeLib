package info.vladyslav.codelibrary.u01core.core_01_base.bs05logger;


import java.util.logging.Level;

public class LoggerTest {
    private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(LoggerTest.class.getName());
    private static final String MESSAGE = "{0} test logger {1}";

    public static void main(String[] args) {
        LOGGER.log(Level.INFO, MESSAGE, new String[]{"--> 1", "INFO"}); // INFO: --> 1 test logger INFO
        LOGGER.log(Level.FINE, MESSAGE, new String[]{"--> 2", "FINE"}); // [void]
        LOGGER.log(Level.FINER, MESSAGE, new String[]{"--> 3", "FINER"}); // [void]
        LOGGER.log(Level.FINEST, MESSAGE, new String[]{"--> 4", "FINEST"}); // [void]
        LOGGER.log(Level.CONFIG, MESSAGE, new String[]{"--> 5", "CONFIG"}); // [void]
        LOGGER.log(Level.WARNING, MESSAGE, new String[]{"--> 6", "WARNING"}); // WARNING: --> 6 can`t write file WARNING
        LOGGER.log(Level.ALL, MESSAGE, new String[]{"--> 7", "ALL"}); // [void]
        LOGGER.log(Level.SEVERE, MESSAGE, new String[]{"--> 8", "SEVERE"}); // SEVERE: --> 8 test logger SEVERE
        LOGGER.log(Level.OFF, MESSAGE, new String[]{"--> 9", "OFF"}); // OFF: --> 9 test logger OFF
        LOGGER.log(Level.SEVERE, MESSAGE, new String[]{"--> 10", "SEVERE"}); // SEVERE: --> 10 test logger SEVERE
    }
}
