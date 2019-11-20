package de.tils.roboter.event.listener;

import de.madakai.eventApi.events.annotation.EventTarget;
import de.madakai.eventApi.listener.EventListener;
import de.tils.roboter.event.iml.EventCallCommand;

/**
 * @author Madakai
 * @since 20.11.19 10:42
 * Copyright © 2019 | Madakai | All rights reserved.
 */
public class CommandListener implements EventListener {

    @EventTarget
    public void onCallCommad(EventCallCommand event) {
    }
}
