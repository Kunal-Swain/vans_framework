package com_Vans.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebdriverSetup {
	private static WebDriver driver;

	public static WebDriver getDriver() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Signity\\eclipse-workspace\\Selenium_MrngBatch\\Cucumber_vans\\src\\test\\resources\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.out.print("");
		}
		return driver;
	}

	public void defaultPage(String defaultpage) {
		driver.manage().window().maximize();
		driver.get(defaultpage);
	}

	public void closeDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

}
