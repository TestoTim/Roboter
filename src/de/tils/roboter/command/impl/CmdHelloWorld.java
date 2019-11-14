package de.tils.roboter.command.impl;

import de.tils.roboter.Robot;
import de.tils.roboter.command.ICommand;

@ICommand.Info(name = "helloWorld", description = "say Hello World")
public class CmdHelloWorld implements ICommand {

    @Override
    public void onExecute(String[] args) {
        Robot.LOGGER.info("Hello World");
    }
}
