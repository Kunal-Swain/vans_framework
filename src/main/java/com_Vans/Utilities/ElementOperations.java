package com_Vans.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementOperations {
	WebDriver driv = WebdriverSetup.getDriver();
	WebElement element;
	public void Clicks(String clickpath) {
		element = driv.findElement(By.xpath(clickpath));
		element.click();
	}//hhee
	public String GetURL() {
		String currentURL = driv.getCurrentUrl();
		return currentURL;
	}
	public void scrolltoelem(String Selempath) {
		element = driv.findElement(By.xpath(Selempath));
		JavascriptExecutor js = (JavascriptExecutor) driv;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	public void formfill(String sendpath, String value) {
		driv.findElement(By.xpath(sendpath)).sendKeys(value);
	}
}
