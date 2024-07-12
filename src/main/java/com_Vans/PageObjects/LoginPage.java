package com_Vans.PageObjects;

import com_Vans.Utilities.ElementOperations;
import com_Vans.Utilities.WaitOperation;
import com_Vans.Utilities.WebdriverSetup;

public class LoginPage {
	
	WebdriverSetup driver = new WebdriverSetup();
	ElementOperations elemoperate = new ElementOperations();
	WaitOperation waits = new WaitOperation();
	public void LoggedIn(String defaultpage) {
		driver.defaultPage(defaultpage);
	}
	public void clickonad(String iniURL) {
		
		waits.explicitwait(5, iniURL);
		elemoperate.Clicks(iniURL);
	}
	public void signin(String sign, String waitelem) {
		
		elemoperate.Clicks(sign);
		waits.explicitwait(5, waitelem);
	}
	public String urlMatch() {
		String currentURL = elemoperate.GetURL();
		return currentURL;
	}
	
	public void closeDriver() {
		WebdriverSetup.closeDriver();
	}
	
}
