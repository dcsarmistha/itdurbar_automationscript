package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
//makes sure only one report object is created
    private static ExtentReports extent;

    public static ExtentReports getExtentReports() {
    // CREATE ONLY IF NOT CREATED
        if (extent == null) {
//PROJECT-FOLDER/REPORTS/REPORT.HTML
            String path = System.getProperty("user.dir")
                    + "/reports/report.html";
//creates html report engine
            ExtentSparkReporter reporter =
                    new ExtentSparkReporter(path);

            reporter.config().setReportName("Automation Report");
            reporter.config().setDocumentTitle("Test Results");

            extent = new ExtentReports();
            //connect engine and report file
            extent.attachReporter(reporter);
//appears in report header
            extent.setSystemInfo("Framework", "POM + TestNG");
            extent.setSystemInfo("Tester", "You");
        }

        return extent;
    }
}