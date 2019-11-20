package de.tils.roboter.event.iml;

import de.madakai.eventApi.events.EventCancellable;
import de.tils.roboter.command.ICommand;

/**
 * @author Madakai
 * @since 20.11.19 10:37
 * Copyright © 2019 | Madakai | All rights reserved.
 */
public class EventCallCommand extends EventCancellable {

    private ICommand command;

    public EventCallCommand(ICommand command) {
        this.command = command;
    }

    public ICommand getCmd() {
        return command;
    }
}
