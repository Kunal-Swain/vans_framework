package com_Vans.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementOperations {
	WebDriver driv = WebdriverSetup.getDriver();
	public void Clicks(String clickpath) {
		System.out.println("this is click path value: "+clickpath);
		WebElement elementor = driv.findElement(By.xpath(clickpath));
		elementor.click();
	}
	public String GetURL() {
		String currentURL = driv.getCurrentUrl();
		return currentURL;
	}
	public void sleeper(int sec)throws Throwable {
		sec = sec*1000;
		System.out.println("seted second: "+sec);
		Thread.sleep(sec);
	}
}
