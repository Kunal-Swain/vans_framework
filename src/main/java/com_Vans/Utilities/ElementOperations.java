package com_Vans.Utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ElementOperations {
	WebDriver driv = WebdriverSetup.getDriver();
	WebElement element;
	WebDriverWait wait;
	Actions act = new Actions(driv);
	String xpaths = "";
	Actions action = new Actions(driv);

	public void Clicks(String clickpath) {
		xpaths = clickpath.replace("\\", "");
		element = driv.findElement(By.xpath(xpaths));
		element.click();
	}

	public void Conditionclick(String condition) {
		xpaths = condition.replace("\\", "");
		element = driv.findElement(By.xpath(xpaths));
		if (element.isDisplayed()) {
			element.click();
		}
	}

	public String GetURL() {
		String currentURL = driv.getCurrentUrl();
		return currentURL;
	}

	public void scrolltoelem(String Selempath) {
		xpaths = Selempath.replace("\\", "");
		element = driv.findElement(By.xpath(xpaths));
		JavascriptExecutor js = (JavascriptExecutor) driv;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void formfill(String sendpath, String value) {
		xpaths = sendpath.replace("\\", "");
		driv.findElement(By.xpath(xpaths)).sendKeys(value);
	}

	public void dropdown_selection(String dropdownlocator, String visibletext) {
		String xpaths = dropdownlocator.replace("\\", "");
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

	public void sleeper(int sec) {
		sec = sec * 1000;
		try {
			Thread.sleep(sec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void explicitwait(String xpathlocator, int waituntil) {
		xpaths = xpathlocator.replace("\\", "");
		wait = new WebDriverWait(driv, Duration.ofSeconds(waituntil));
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpaths)));
	}

	public void implicitwait(int implywait) {
		driv.manage().timeouts().implicitlyWait(Duration.ofSeconds(implywait));
	}

	public String getCurrentMethodName() {
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		return stackTraceElements[2].getMethodName();
	}

	public void URLasserted(String currentURL, String expURL) {
		Assert.assertEquals(currentURL, expURL);
	}

	public void verifyText(String textPath, String actualText) {
		xpaths = textPath.replace("\\", "");
		element = driv.findElement(By.xpath(xpaths));
		String getText = element.getText();
		Assert.assertTrue(getText.equalsIgnoreCase(actualText));
	}

	public void hoverOn(String hoverElem) {
		xpaths = hoverElem.replace("\\", "");
		element = driv.findElement(By.xpath(xpaths));
		action.moveToElement(element).perform();
	}

	public void Takescreenshot(String imagename) {
			File screenshot = ((TakesScreenshot) driv).getScreenshotAs(OutputType.FILE);
			if(imagename.isBlank() || imagename.isEmpty() || imagename.equals("")) {
				String alpha = "abcdefghijklmnopqrstuvwxyz";
				Random random = new Random();
				int wordLength = 5;
				StringBuilder word = new StringBuilder();
				for (int i = 0; i < wordLength; i++) {
		            char randomChar = alpha.charAt(random.nextInt(alpha.length()));
		            word.append(randomChar);
		        }
				imagename = word.toString();
			}
			File destination = new File("C:\\Users\\Signity\\eclipse-workspace\\Selenium_MrngBatch\\Cucumber_vans\\test-output\\Screenshots\\"+imagename+".png");
		try {	
			FileHandler.copy(screenshot, destination);
		} catch (IOException e) {
			System.out.println("screenshot exception");
		}
	}
}
