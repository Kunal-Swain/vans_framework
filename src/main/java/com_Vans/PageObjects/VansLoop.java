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
import com_Vans.Utilities.PropertyConfig;
import java.util.Optional;
import java.time.Duration;

public class VansLoop {
	public static void main(String[] args) {
		PropertyConfig config = new PropertyConfig();
		String URL = config.getProperty("URL");
		String Cookies_click = config.getProperty("Cookies_click");
		String Username = config.getProperty("Username");
		String Password = config.getProperty("Password");
		String Login_click = config.getProperty("Login_click");
		String Search_box = config.getProperty("Search_box");
		String Asset_click = config.getProperty("Asset_click");
		String Next_button = config.getProperty("Next_button");
		String Page_count = config.getProperty("Page_count");
		String Download_click = config.getProperty("Download_click");
		String Standard_download = config.getProperty("Standard_download");
		String user_cred = System.getenv("V_USERNAME");
		String pass_cred = System.getenv("V_PASSWORD");
		String Search_Keyword = config.getProperty("Search_Keyword");
		System.setProperty("webdriver.chrome.driver",
				"./src/test/resources/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		try {
			WebElement button = null;
			driver.manage().window().maximize();
			driver.get(URL);
			WebElement element = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(Cookies_click)));
			element.click();
			WebElement user = driver.findElement(By.xpath(Username));
			user.sendKeys(user_cred);
			WebElement pass = driver.findElement(By.xpath(Password));
			pass.sendKeys(pass_cred);
			WebElement loginbtn = driver
					.findElement(By.xpath(Login_click));
			loginbtn.click();
			Thread.sleep(3);
			wait.until(ExpectedConditions.urlContains("Home"));
			System.out.println("succesfull homepage load");

			element = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(Search_box)));
			element.sendKeys(Search_Keyword + Keys.ENTER);
			Thread.sleep(5000);
			element = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(Asset_click)));
			element.click();
			System.out.println("item clicked");
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(Next_button)));
			String pcount = driver.findElement(By.xpath(Page_count)).getText();
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
						.visibilityOfElementLocated(By.xpath(Download_click)));
				element.click();

				element = wait.until(
						ExpectedConditions.visibilityOfElementLocated(By.xpath(Standard_download)));
				element.click();
				Thread.sleep(5000);
				button = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath(Next_button)));
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
