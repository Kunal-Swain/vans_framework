package com_Vans.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	ExtentReports extent;
	ExtentTest test;

	public void setup(String featurename) {
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(featurename+".html");
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setDocumentTitle("Automation Test Report advance");
		sparkReporter.config().setReportName("Extent Report Demo from basic");

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Browser", "Chrome Browser");
	}

	public void createTest() {
		test = extent.createTest("Test Case extent", "Sample description for Test Case extent");
	}

	public void Pass(String info) {
		if (info == "") {
			info = "No information Provided";
		}
		test.log(com.aventstack.extentreports.Status.PASS, info);

//		test.addScreenCaptureFromPath(
//				"C:\\Users\\Signity\\eclipse-workspace\\Selenium_MrngBatch\\Cucumber_vans\\test-output\\Screenshots\\Kids.png");
	}

	public void Fail(String info) {
		if (info == "") {
			info = "No information Provided";
		}
		test.log(com.aventstack.extentreports.Status.FAIL, info);
	}

	public void Skip(String info) {
		if (info == "") {
			info = "No information Provided";
		}
		test.log(com.aventstack.extentreports.Status.SKIP, info);
	}

	public void flushReport() {
		extent.flush();
	}

	public static void main(String[] args) {
		ExtentReport example = new ExtentReport();
		example.setup("ss");
		example.createTest();
		example.Pass("");
		example.Fail("");
		example.Skip("");
		example.flushReport();
	}

}
