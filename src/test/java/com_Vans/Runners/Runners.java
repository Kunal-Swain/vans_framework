package com_Vans.Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {
"C:\\Users\\Signity\\eclipse-workspace\\Selenium_MrngBatch\\Cucumber_vans\\src\\main\\resources\\testexample.feature" }, monochrome = true, tags = "@tag1", glue = "com_Vans.StepDefinations", plugin = {"pretty", "html:test-output/cucumber/LoginPage.html", "json:test-output/cucjson-reports/Cucumber.json" } )
public class Runners extends AbstractTestNGCucumberTests {

}
