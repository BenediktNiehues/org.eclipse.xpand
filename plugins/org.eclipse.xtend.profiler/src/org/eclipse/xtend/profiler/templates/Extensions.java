package org.eclipse.xtend.profiler.templates;

import java.util.HashMap;
import java.util.Map;

public class Extensions {
	
	private static final Map<String, Object> globalState = new HashMap<String, Object>();
	
	public static Object setGlobal(Object value, String name) {
		globalState.put(name, value);
		return value;
	}
	
	public static Object getGlobal(String name) {
		return globalState.get(name);
	}
	
	public static String format(String format, Object param1) {
		return String.format(format, param1);
	}

	public static String format(String format, Object param1, Object param2) {
		return String.format(format, param1, param2);
	}
	
	public static String getFormFeed() {
		return "\f";
	}
	
	public static String anchorFragment(String value) {
		// TODO find real way without loosing information
		return value.replaceAll("[^a-zA-Z_-]", "_");
	}
	
	
	private static String bytesToMb(long bytes) {
		return String.format("%d MB", bytes / (1024 * 1024));
	}
	
	public static String totalMemory() {
		return bytesToMb(Runtime.getRuntime().totalMemory());
	}

	public static String maxMemory() {
		return bytesToMb(Runtime.getRuntime().maxMemory());
	}
}
