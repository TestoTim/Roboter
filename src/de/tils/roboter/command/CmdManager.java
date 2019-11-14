package de.tils.roboter.command;

import de.tils.roboter.Robot;
import de.tils.roboter.command.impl.CmdHelloWorld;
import de.tils.roboter.command.impl.CmdHelp;
import de.tils.roboter.command.impl.CmdStop;
import de.tils.roboter.utils.Manager;

import java.util.Arrays;

public class CmdManager extends Manager<ICommand> {

    /**
     *  is the terminal running
     */
    private boolean run = true;


    public CmdManager() {
        this.list.addAll(Arrays.asList(
                new CmdHelp(),
                new CmdHelloWorld(),
                new CmdStop()
        ));
    }

    /**
     *  call if a input came up in terminal
     */
    private void onInput(String commandText) {
        String[] args = commandText.split(" ");


        ICommand command = list.stream().filter(cmd -> cmd.getClass().getAnnotation(ICommand.Info.class).name().equalsIgnoreCase(args[0])).findFirst().orElse(null);

        if (command != null) {
            command.onExecute(args);
        } else {
            Robot.LOGGER.warning("This command does not exist!");
        }
    }

    /**
     *  start the command input
     */
    public void startTerminal() {
        Robot.LOGGER.info(
                "----------------------",
                "--- Start Terminal ---",
                "----------------------\n");

        Thread thread = new Thread(() -> {
            while (run) {
                onInput(Robot.LOGGER.input("[Command] -> "));
            }
        });

        thread.start();
    }

    /**
     * stop the command input
     */
    public void stopTerminal() {
        run = false;
    }

    public boolean isRun() {
        return run;
    }
}
