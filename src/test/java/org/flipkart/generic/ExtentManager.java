package org.flipkart.generic;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	private static ExtentReports extent;
    private static long startTime;
    private static long endTime;

    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            String workingDir = System.getProperty("user.dir");
            extent = new ExtentReports(workingDir + "/ExtentReports/ExtentReportResult" + ".html", true);
            startTime = System.currentTimeMillis();  // Record the start time
        }
        return extent;
    }

    public synchronized static void endReporter() {
        if (extent != null) {
            endTime = System.currentTimeMillis();  // Record the end time
            extent.addSystemInfo("Start Time", GenericFunctions.formatTime(startTime));
            extent.addSystemInfo("End Time", GenericFunctions.formatTime(endTime));
            extent.addSystemInfo("Execution Time", GenericFunctions.overallExecutionTime(startTime, endTime));
            extent.flush();
            extent.close();
        }
    }
}
