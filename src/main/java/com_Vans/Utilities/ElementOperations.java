package com_Vans.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ElementOperations {
	WebDriver driv = WebdriverSetup.getDriver();
	WebElement element;
	Actions act = new Actions(driv);

	public void Clicks(String clickpath) {
		element = driv.findElement(By.xpath(clickpath));
		element.click();
	}// hhee

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

	public void dropdown_selection(String dopdownlocator, String visibletext) {
		element = driv.findElement(By.xpath(dopdownlocator));
		Select drop = new Select(element);
		drop.selectByVisibleText(visibletext);
	}

	public void select(String check) {
		element = driv.findElement(By.cssSelector(check));
		if (!element.isSelected()) {
			if (element.isDisplayed()) {
				element.click();
			} else {
				System.out.println("Not display");
			}

		}
	}

	public void Deselect(String uncheck) {
		element = driv.findElement(By.cssSelector(uncheck));
		if (element.isDisplayed()) {
			element.click();
		} else {
			System.out.println("Not display");
		}
	}
}
