package com_Vans.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class VansLoop {
	public static void main(String[] args) {
		// Set the path for the ChromeDriver
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Signity\\eclipse-workspace\\Selenium_MrngBatch\\Cucumber_vans\\src\\test\\resources\\Drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			// Open the website
			driver.get("https://dam.vans.com");
			Thread.sleep(2000);
			WebElement user = driver.findElement(By.xpath("//input[@id='a2.1.4.1:LoginField']"));
			user.sendKeys("karming.song@gmg.com");
			WebElement pass = driver.findElement(By.xpath("//input[@id='a2.1.4.1:Password']"));
			pass.sendKeys("@Today123");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@class='Primary iziToast-buttons-child' and text()='OK']")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//*[@id=\"a2.1.4.1:LoginBtn\"]/a")).click();
			Thread.sleep(4000);
			driver.findElement(
					By.xpath("//a[@href='https://dam.vans.com/asset-management/2DBYOHERBY?WS=AssetManagement&Flat=y']"))
					.click();
			// Find the search box and enter the model number
			Thread.sleep(4000);
			WebElement searchBox = driver.findElement(By.xpath("//input[@id='a3.1.3.11.3.1:MainAutoComp']"));
			searchBox.sendKeys("VN000D85JVY" + Keys.ENTER);
			// Replace with actual model number
			Thread.sleep(4000);
			// Wait for search results to load
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[@id='a3.1.3.13:2ndFlow']/div[@class='ABS AvoidBreak VF']")));
			// Get the list of 30 product items
			Thread.sleep(4000);
			List<WebElement> productList = driver
					.findElements(By.xpath("//div[@id='a3.1.3.13:2ndFlow']/div[@class='ABS AvoidBreak VF']"));
			System.out.println(productList.size());
			Thread.sleep(4000);
			driver.findElement(By.xpath("//div[@id='a3.1.3.13:2ndFlow']/div[@class='ABS AvoidBreak VF'][1]")).click();
			// Loop through each product
			for (int i = 1; i <= productList.size(); i++) {
				// div[@id='a3.5.1.1.1.1.4.6:2']/a[@aria-label='Download' and @role='button']/i
				Thread.sleep(2000);
				driver.findElement(
						By.xpath("//div[@id='a3.5.1.1.1.1.4.6:2']/a[@aria-label='Download' and @role='button']/i"))
						.click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[@role = 'button' and @aria-label = 'Standard download']")).click();
				Thread.sleep(2000);
				try {
					WebElement button = driver
							.findElement(By.xpath("//a[@role='button' and @aria-label='Go to Next Page']"));
					if (button.getAttribute("disabled") == null) {
						button.click();
					}
				} catch (NoSuchElementException e) {
					System.out.println("All Images is Downloaded");
				}
			}
		} catch (Exception e) {
			System.out.println("Iteration complete");
		} finally {
			// Close the browser after all items are processed
			driver.close();
		}
	}
}
