package de.tils.roboter.command.impl;

import de.tils.roboter.command.ICommand;

@ICommand.Info(name = "stop", description = "stop the programm")
public class CmdStop implements ICommand {

    @Override
    public void onExecute(String[] args) {
        System.exit(0);
    }
}
