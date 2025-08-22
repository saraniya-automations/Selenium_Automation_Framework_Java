package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static ExtentReports extent;
    private static ExtentTest test;

    public static ExtentReports createInstance() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        reporter.config().setReportName("UI Automation Report");
        reporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Your Name");
        return extent;
    }

    public static ExtentReports getInstance() {
        if (extent == null)
            extent = createInstance();
        return extent;
    }

    public static ExtentTest createTest(String name) {
        test = getInstance().createTest(name);
        return test;
    }

    public static ExtentTest getTest() {
        return test;
    }
}
