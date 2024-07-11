package com_Vans.Utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitOperation {
	WebElement element;
	WebDriver driv = WebdriverSetup.getDriver();
	WebDriverWait wait;
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
