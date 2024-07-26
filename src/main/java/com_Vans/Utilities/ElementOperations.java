package com_Vans.Utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementOperations {
	WebDriver driv = WebdriverSetup.getDriver();
	WebElement element;
	WebDriverWait wait;
	Actions act = new Actions(driv);

	public void Clicks(String clickpath) {
		element = driv.findElement(By.xpath(clickpath));
		element.click();
	}
	
	public void conditionclick(String condition) {
		element = driv.findElement(By.xpath(condition));
		if(element.isDisplayed()) {
			element.click();
		}
	}

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
		String xpaths = sendpath.replace("\\", "");
		driv.findElement(By.xpath(xpaths)).sendKeys(value);
	}

	public void dropdown_selection(String dopdownlocator, String visibletext) {
		String xpaths = dopdownlocator.replace("\\", "");
		element = driv.findElement(By.xpath(xpaths));
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
	
	public void sleeper(int sec)throws Throwable {
		sec = sec*1000;
		System.out.println("seted second: "+sec);
		Thread.sleep(sec);
	}
	public void explicitwait(int waituntil, String xpathlocator) {
		wait = new WebDriverWait(driv, Duration.ofSeconds(waituntil));
		element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathlocator)));
	}
	public void implicitwait(int implywait) {
		driv.manage().timeouts().implicitlyWait(Duration.ofSeconds(implywait));
	}
}
