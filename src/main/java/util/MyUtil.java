package util;

import java.io.UnsupportedEncodingException;
import java.util.logging.ConsoleHandler;

public class MyUtil {
	public static ConsoleHandler handler;
	static {
		try {
			handler = new ConsoleHandler();
			handler.setEncoding("UTF-8");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
