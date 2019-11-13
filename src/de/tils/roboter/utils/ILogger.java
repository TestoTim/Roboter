package de.tils.roboter.utils;

public interface ILogger {

    /**
     *  write lines in console
     */
    void println(LogLevel level, String... lines);

    /**
     *  write lines with DEBUG level
     */
    default void debug(String... lines) {
        println(LogLevel.DEBUG, lines);
    }

    /**
     *  write lines with INFO level
     */
    default void info(String... lines) {
        println(LogLevel.INFO, lines);
    }

    /**
     *  write lines with ERROR level
     */
    default void error(String... lines) {
        println(LogLevel.ERROR, lines);
    }

    enum LogLevel {
        INFO, DEBUG, ERROR
    }
}
