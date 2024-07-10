package com_Vans.Utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitOperation {
	WebDriver driv = WebdriverSetup.getDriver();
	public void waitUntil(int waituntil, String xpathlocator) {
		WebDriverWait wait = new WebDriverWait(driv, Duration.ofSeconds(waituntil));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathlocator)));
	}
}
