package com_Vans.PageObjects;

import org.openqa.selenium.WebDriver;
import com_Vans.Utilities.ElementOperations;
import com_Vans.Utilities.WebdriverSetup;

public class LoginPage {
	
	WebDriver driver = WebdriverSetup.getDriver();
	ElementOperations sleep = new ElementOperations();
	ElementOperations clicked = new ElementOperations();
	ElementOperations actURL = new ElementOperations();
	public void LoggedIn() {
		driver.manage().window().maximize();
		driver.get("https://www.vans.com.sg/");
			
	}
	public void clickonad(String iniURL)throws Throwable {
		
		sleep.sleeper(4);
		clicked.Clicks(iniURL);
		System.out.println(iniURL);
	}
	public void signin(String s1)throws Throwable {
		
		clicked.Clicks(s1);
		sleep.sleeper(2);
	}
	public String urlMatch() {
		String currentURL = actURL.GetURL();
		return currentURL;
	}
	public void closeDriver() {
		WebdriverSetup.closeDriver();
	}
	
}
