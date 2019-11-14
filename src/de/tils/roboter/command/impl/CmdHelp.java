package de.tils.roboter.command.impl;

import de.tils.roboter.Robot;
import de.tils.roboter.command.ICommand;

@ICommand.Info(name = "help", description = "list of all commands")
public class CmdHelp implements ICommand {

    @Override
    public void onExecute(String[] args) {
        Robot.LOGGER.info("--- Commands ---");

        Robot.CMD_MANAGER.getList().forEach(cmd -> {
            Info info = cmd.getClass().getAnnotation(Info.class);
            Robot.LOGGER.info(info.name(), info.description() + "\n");
        });

        Robot.LOGGER.info("---------------\n");
    }
}
