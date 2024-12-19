package com_Vans.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v131.network.Network;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Optional;
import java.time.Duration;

public class VansLoop {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		String username = System.getenv("V_USERNAME");
		String password = System.getenv("V_PASSWORD");
		try {
			WebElement button = null;
			driver.manage().window().maximize();
			driver.get("https://dam.vans.com");
			WebElement element = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//button[@class = 'Primary iziToast-buttons-child']")));
			element.click();
			WebElement user = driver.findElement(By.xpath("//input[@aria-label = 'Email or Login ID']"));
			user.sendKeys(username);
			WebElement pass = driver.findElement(By.xpath("//input[@aria-label = 'Password']"));
			pass.sendKeys(password);
			WebElement loginbtn = driver
					.findElement(By.xpath("//a[@role = 'button' and @aria-label = 'Login' and text() = 'Login']"));
			loginbtn.click();
			Thread.sleep(3);
			wait.until(ExpectedConditions.urlContains("Home"));
			System.out.println("succesfull homepage load");

			element = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//input[@aria-label = 'Type your search here']")));
			element.sendKeys("VN000D85JVY" + Keys.ENTER);
			Thread.sleep(5000);
			element = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("(//div[@class = 'ABS AvoidBreak VF HighlightOverItem'])[1]")));
			element.click();
			System.out.println("item clicked");
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//a[@role = 'button' and @aria-label = 'Go to Next Page']")));
			String pcount = driver.findElement(By.xpath("//span[@class = 'Lbl'  and contains(@id, 'TotalPageCount')]")).getText();
			String totalproduct = pcount.replaceAll("[^0-9]", "");
			System.out.println(totalproduct);
			int finalcount = Integer.parseInt(totalproduct);
			DevTools devtools = ((ChromeDriver) driver).getDevTools();
			devtools.createSession();
			devtools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
			devtools.addListener(Network.responseReceived(), response -> {
				String url = response.getResponse().getUrl();
				if (url.contains(".jpg") || url.contains(".png") || url.contains(".jpeg")) {
					System.out.println("url : "+ url);
				}
	        });
			int i = 1;
			
			while(i <= finalcount) {
				element = wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//a[text() = 'Download' and @role = 'button']")));
				element.click();

				element = wait.until(
						ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text() = 'Standard download']")));
				element.click();
				button = wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//a[@role = 'button' and @aria-label = 'Go to Next Page']")));
				button.click();
				i++;
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.close();
		}
	}
}
