package com.Sunconure11.DragonMounts.util;

import com.Sunconure11.DragonMounts.DragonMounts;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Utils {

	private static Logger logger;

	public static Logger getLogger() {
		if (logger == null) {
			logger = LogManager.getFormatterLogger(DragonMounts.MODID);
		}
		return logger;
	}

}
