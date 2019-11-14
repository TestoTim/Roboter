package de.tils.roboter.utils;

import java.util.Scanner;

public interface ILogger {

    /**
     *  write lines in console
     */
    void print(LogLevel level, boolean nextLine, String... lines);

    /**
     *  write lines with DEBUG level
     */
    default void debug(String... lines) {
        print(LogLevel.DEBUG, true, lines);
    }

    /**
     *  write lines with INFO level
     */
    default void info(String... lines) {
        print(LogLevel.INFO, true, lines);
    }

    /**
     *  write lines with ERROR level
     */
    default void error(String... lines) {
        print(LogLevel.ERROR, true, lines);
    }

    /**
     *  write lines with WARNING level
     */
    default void warning(String... lines) {
        print(LogLevel.WARNING, true, lines);
    }

    /**
     *  write lines with ERROR level
     */
    default String input(String... lines) {
        Scanner scanner = new Scanner(System.in);

        print(LogLevel.INPUT, false, lines);

        return scanner.nextLine();
    }

    enum LogLevel {
        INFO, DEBUG, ERROR, INPUT, WARNING
    }
}
