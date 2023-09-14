package util;

import java.io.UnsupportedEncodingException;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

public class MyUtil {
	public static ConsoleHandler handler;

	public static Logger logger(String className) {
		Logger logger = Logger.getLogger(className);
		handler = new ConsoleHandler();
		try {
			handler.setEncoding("UTF-8");
		} catch (SecurityException | UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		logger.addHandler(handler);
		logger.setUseParentHandlers(false);
		return logger;
	}
}
