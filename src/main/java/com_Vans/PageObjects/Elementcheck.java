package com_Vans.PageObjects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Elementcheck {
	ExtentReports extent;
    ExtentTest test;

    public void setup() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extentReport.html");
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setDocumentTitle("Automation Test Report");
        sparkReporter.config().setReportName("Extent Report Demo");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("OS", "Windows");
        extent.setSystemInfo("Browser", "Chrome");
    }

    public void createTest() {
        test = extent.createTest("Test Case 1", "Sample description for Test Case 1");
    }

    public void logTestSteps() {
        test.log(com.aventstack.extentreports.Status.PASS, "Step 1 Passed");
        test.log(com.aventstack.extentreports.Status.FAIL, "Step 2 Failed");
        test.log(com.aventstack.extentreports.Status.SKIP, "Step 3 Skipped");
        test.addScreenCaptureFromPath("C:\\Users\\Signity\\eclipse-workspace\\Selenium_MrngBatch\\Cucumber_vans\\test-output\\Screenshots\\Kids.png");
        //check with target
    }

    public void flushReport() {
        extent.flush();
    }

    public static void main(String[] args) {
    	Elementcheck example = new Elementcheck();
        example.setup();
        example.createTest();
        example.logTestSteps();
        example.flushReport();
    }
}
