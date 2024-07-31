package com_Vans.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Elementcheck {
	public static void main(String[] args) {
		WebDriver driver;
		WebElement element;
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Signity\\\\eclipse-workspace\\\\Selenium_MrngBatch\\\\Cucumber_vans\\\\src\\\\test\\\\resources\\\\Drivers\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		element = driver.findElement(By.xpath("//*[@id=\"content\"]/h2"));
		element.getText();
		
	}
}
