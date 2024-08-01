package com_Vans.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Elementcheck {
	public static void main(String[] args) {
		WebDriver driver;
		WebElement element;
		System.setProperty("webdriver.chrome.driver",
				"C:\\\\Users\\\\Signity\\\\eclipse-workspace\\\\Selenium_MrngBatch\\\\Cucumber_vans\\\\src\\\\test\\\\resources\\\\Drivers\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.get("https://the-internet.herokuapp.com/");
		driver.get("https://www.w3schools.com/java/java_data_types.asp");
		element = driver.findElement(By.xpath("//*[@id=\"navbtn_certified\"]"));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		
		
	}
}
