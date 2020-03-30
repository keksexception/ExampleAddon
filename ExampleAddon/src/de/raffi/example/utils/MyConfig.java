package de.raffi.example.utils;

import de.raffi.druglabs.utils.Configurable;
import de.raffi.druglabs.utils.Files;

public class MyConfig {
	
	@Configurable("myconfig.yml")
	public static int TRIP_COCAINE_DURARATION_SECONDS=60;
	@Configurable(Files.CONFIG)
	public static int TRIP_COCAINE_UPDATETICKS=60;
	@Configurable //default translation.yml
	public static String ITEM_NAME_COCAINE = "§7Cocaine";
	@Configurable
	public static String BLOCK_NAME_EXAMPLE = "§7Example block";

}
