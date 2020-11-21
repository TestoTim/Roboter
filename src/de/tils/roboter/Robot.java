package de.tils.roboter;

import de.madakai.eventApi.manager.EventManager;
import de.tils.roboter.command.CmdManager;
import de.tils.roboter.event.listener.CommandListener;
import de.tils.roboter.utils.Logger;

public class Robot {

    /**
     *	Logger for Project
     */
    public static final Logger LOGGER = new Logger("Robot", false);

    /**
     *  manager for mange the commands in the terminal
     */
    public static final CmdManager CMD_MANAGER = new CmdManager();

    /**
     * Infos form project
     */
    public static class Info {
        static final String VERSION = "1.0";
        static final String[] CODER = { "Tim", "Nils" };
    }

    public Robot() { 
        projectInfos();

        initListener();

        CMD_MANAGER.startTerminal();
    }

    /**
     *  register all Listeners
     */
    private void initListener() {
        EventManager.registerListener(new CommandListener());
    }

    /**
     *	print project infos in console
     */
    private static void projectInfos() {
        System.out.println(String.format(
                " ______         __           __              \n" +
                        "|   __ \\.-----.|  |--.-----.|  |_.-----.----.\n" +
                        "|      <|  _  ||  _  |  _  ||   _|  -__|   _|\n" +
                        "|___|__||_____||_____|_____||____|_____|__|  \n" +
                        "   Version: %s  |  Coder: %s and %s          \n",
                Info.VERSION, Info.CODER[0], Info.CODER[1]));
    }
}
