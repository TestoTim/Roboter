package de.tils.roboter.main;

import de.tils.roboter.utils.Logger;

public class Main {

	/**
	 *	Logger for Project
	 */
	public static final Logger logger = new Logger("Robot");

	/**
	 * Infos form project
	 */
	public static class Info {
		static final String VERSION = "1.0";
		static final String[] CODER = { "Tim", "Nils" };
	}

	public static void main(String[] args) {
		projectInfos();
		logger.error("Nils ist ein error");
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
