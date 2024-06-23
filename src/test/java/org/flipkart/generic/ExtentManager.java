package org.flipkart.generic;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
    private static ExtentReports extent;
<<<<<<< Updated upstream
=======
    private static long startTime;
    private static long endTime;
>>>>>>> Stashed changes

    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            String workingDir = System.getProperty("user.dir");
<<<<<<< Updated upstream
            extent = new ExtentReports(workingDir + "/ExtentReports/ExtentReportResults" + ".html", true);
        }
        return extent;
    }
=======
            // Use a fixed name for the report file
            extent = new ExtentReports(workingDir + "/ExtentReports/ExtentReportResults.html", true);
        }
        return extent;
    }

    public synchronized static void endReporter() {
        if (extent != null) {
            endTime = System.currentTimeMillis();
            extent.addSystemInfo("Start Time", GenericFunctions.formatTime(startTime));
            extent.addSystemInfo("End Time", GenericFunctions.formatTime(endTime));
            extent.addSystemInfo("Execution Time", getExecutionTime());

            extent.flush();
            extent.close();
        }
    }

    private static String getExecutionTime() {
        long duration = endTime - startTime;
        long seconds = (duration / 1000) % 60;
        long minutes = (duration / (1000 * 60)) % 60;
        long hours = (duration / (1000 * 60 * 60)) % 24;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
>>>>>>> Stashed changes
}
