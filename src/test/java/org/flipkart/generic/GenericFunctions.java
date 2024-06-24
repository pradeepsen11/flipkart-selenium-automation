package org.flipkart.generic;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GenericFunctions {
	public static String currentDateAndTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
		return sdf.format(new Date());
	}

	public static String formatTime(long millis) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date(millis));
	}

	public static String overallExecutionTime(long startTime, long endTime) {
        long duration = endTime - startTime;
        long seconds = (duration / 1000) % 60;
        long minutes = (duration / (1000 * 60)) % 60;
        long hours = (duration / (1000 * 60 * 60)) % 24;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
