package com_Vans.PageObjects;

import org.openqa.selenium.WebDriver;
import com_Vans.Utilities.ElementOperations;
import com_Vans.Utilities.WaitOperation;
import com_Vans.Utilities.WebdriverSetup;

public class LoginPage {
	
	WebDriver driver = WebdriverSetup.getDriver();
	ElementOperations sleep = new ElementOperations();
	ElementOperations clicked = new ElementOperations();
	ElementOperations actURL = new ElementOperations();
	WaitOperation waits = new WaitOperation();
	public void LoggedIn() {
		driver.manage().window().maximize();
		driver.get("https://www.vans.com.sg/");
			
	}
	public void clickonad(String iniURL)throws Throwable {
		//changes
		waits.waitUntil(5, iniURL);
		clicked.Clicks(iniURL);
		System.out.println(iniURL);
	}
	public void signin(String sign, String waitelem) {
		
		clicked.Clicks(sign);
		waits.waitUntil(5, waitelem);
	}
	public String urlMatch() {
		String currentURL = actURL.GetURL();
		return currentURL;
	}
	
	public void closeDriver() {
		WebdriverSetup.closeDriver();
	}
	
}
