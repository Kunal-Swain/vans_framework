package com_Vans.PageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PriceCheck {
	public static void main(String[] args) {
		Sheet sheet = null;
		Cell cell1;

		String readmodel;
		double readPrice = 0;
		String actualprice = "";

		WebDriver driver = null;
		WebDriverWait wait;
		WebElement element;
		List<WebElement> elements;

		String xpath1 = "//span[@class = 'special-price']";
		String checkpath = "//span[@class = 'special-price']/span/span[2]/span";
		String xpath2 = "/html/body/div[3]/main/div[4]/div[2]/div[3]/div/div/ol/li/div/div/div[2]/span/span/span";
		String xpath3 = "//div[@class='message notice']";
		String baseURL = "https://www.vans.com.my/catalogsearch/result/?q=";
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Signity\\eclipse-workspace\\Selenium_MrngBatch\\Cucumber_vans\\src\\test\\resources\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();

		driver.get("https://www.vans.com.my");
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@id = 'wpn-lightbox-close-newsletter']")));
		element = driver.findElement(By.xpath("//div[@id = 'wpn-lightbox-close-newsletter']"));
		if (element.isDisplayed()) {
			element.click();
		}
		element = driver.findElement(
				By.xpath("//button[@class = 'amgdprcookie-button -allow -save' and text() = 'ACCEPT ALL']"));
		if (element.isEnabled() && element.isDisplayed()) {
			element.click();
		}
		String filepath = "C:\\Users\\Signity\\Downloads\\TestPrice.xlsx";
		try {
			FileInputStream fi = new FileInputStream(filepath);
			Workbook wb = WorkbookFactory.create(fi);
			sheet = wb.getSheetAt(0);
		} catch (IOException e) {
			System.out.println("File not found");
		}
		int rowIndex = 0;
		for (Row row : sheet) {
			if (rowIndex == 0) { // Skip the first row (headers)
				rowIndex++;
				continue;
			}
			try {
				cell1 = row.getCell(1);
				if (cell1.getCellType() == CellType.NUMERIC) {
					readPrice = cell1.getNumericCellValue();
				} else if (cell1.getCellType() == CellType.STRING) {
					try {
						readPrice = Double.parseDouble(cell1.getStringCellValue());
					} catch (NumberFormatException e) {
						System.out.println("The cell does not contain a valid numeric value.");
					}
				}
				readmodel = row.getCell(0).getStringCellValue();
				driver.get(baseURL + readmodel);
				try {
					elements = driver.findElements(By.xpath(xpath1));
					elements = driver.findElements(By.xpath(xpath2));
					if (!elements.isEmpty()) {
						actualprice = driver.findElement(By.xpath(checkpath)).getText();
						System.out.println("missing : "+actualprice);
					}
					else if (!elements.isEmpty()) {
						actualprice = elements.get(0).getText();
					} 
					else {
						elements = driver.findElements(By.xpath(xpath3));
						if (!elements.isEmpty()) {
							actualprice = elements.get(0).getText();
						} else {
							actualprice = "Not available";
						}
					}

				} catch (Exception e) {
				}
				System.out.print(readmodel + " : " + readPrice + " : "+actualprice);
				System.out.println();
			} catch (NullPointerException e) {

			}
		}

	}
}
