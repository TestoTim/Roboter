package de.tils.roboter.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Logger implements ILogger {


    private static final SimpleDateFormat dataFormat = new SimpleDateFormat("HH:mm:ss");
    private final String name;

    private final List<String> history = new ArrayList<>();


    private final boolean save;


    public Logger(String name, boolean save) {
        this.name = name;
        this.save = save;

        Runtime.getRuntime().addShutdownHook(new Thread(this::onShutdown, name + "-ShutdownHook"));
    }


    @Override
    public void print(LogLevel level, boolean nextLine, String... lines) {
        Arrays.asList(lines).forEach(line -> {
            String output = String.format("[%s] [%s] [%s] %s", name, dataFormat.format(new Date()), level.toString(), line);
            history.add(output);

            if (nextLine)
                System.out.println(output);
            else
                System.out.print(output);
        });
    }

    /**
     * call when the programm shutdown
     */
    private void onShutdown() {
        saveHistory();
    }

    /**
     * save the logger history in log directory
     */
    private void saveHistory() {
        if (save) {
            StringBuilder text = new StringBuilder();
            BufferedWriter output;

            for (String line : history) {
                text.append(line).append("\n");
            }

            try {
                String date = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss").format(new Date());
                File file = new File(String.format("log/log_%s.txt", date));

                if (!file.exists()) {
                    file.getParentFile().mkdirs();
                }

                file.createNewFile();

                output = new BufferedWriter(new FileWriter(file));
                output.write(text.toString());
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
