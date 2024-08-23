package com_Vans.PageObjects;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.Assert;
import com_Vans.Utilities.Data;
import com_Vans.Utilities.ElementOperations;
import com_Vans.Utilities.ExtentReport;
import com_Vans.Utilities.WebdriverSetup;

public class BaseClass {
	ElementOperations elemoperate = new ElementOperations();
	WebdriverSetup driver = new WebdriverSetup();
	ExtentReport exreport = new ExtentReport();
	Data data = new Data();
	String step = "";
	long approx;

	public void basics(String stepname) {
		Sheet sheet = data.ExcelDyna();
		String featurename = sheet.getSheetName();
		exreport.setup(featurename);
		exreport.createTest();
		String info = "";
		for (Row row : sheet) {
			try {
				String step = row.getCell(0).getStringCellValue();
//				info = row.getCell(4).getStringCellValue();
				if (stepname.equalsIgnoreCase(step)) {
					String action = row.getCell(1).getStringCellValue();
					String xpath = row.getCell(2).getStringCellValue();
					
					switch (row.getCell(3).getCellType()) {
					case BLANK:
						if ("Takescreenshot".equalsIgnoreCase(action)) {
							elemoperate.Takescreenshot("");
						}
						break;
					case STRING:
						String value = row.getCell(3).getStringCellValue();
						if ("formfill".equalsIgnoreCase(action)) {
							elemoperate.formfill(xpath, value);
							exreport.Pass(info);
						}
						if ("dropdown_selection".equalsIgnoreCase(action)) {
							elemoperate.dropdown_selection(xpath, value);
							exreport.Pass(info);
						}
						if ("scrolltoelem".equalsIgnoreCase(action)) {
							elemoperate.scrolltoelem(xpath);
							exreport.Pass(info);
						}
						if ("Clicks".equalsIgnoreCase(action)) {
							elemoperate.Clicks(xpath);
							exreport.Pass(info);
						}
						if ("Conditionclick".equalsIgnoreCase(action)) {
							elemoperate.Conditionclick(xpath);
							exreport.Pass(info);
						}
						if ("select".equalsIgnoreCase(action)) {
							elemoperate.select(xpath);
							exreport.Pass(info);
						}
						if ("Deselect".equalsIgnoreCase(action)) {
							elemoperate.Deselect(xpath);
							exreport.Pass(info);
						}
						if ("GetURL".equalsIgnoreCase(action)) {
							String actualURL = elemoperate.GetURL();
							String expectedURL = value;
							Assert.assertEquals(actualURL, expectedURL);
							exreport.Pass(info);
						}
						if ("verifyText".equalsIgnoreCase(action)) {
							elemoperate.verifyText(xpath, value);
							exreport.Pass(info);
						}
						if ("hoverOn".equalsIgnoreCase(action)) {
							elemoperate.hoverOn(xpath);
							exreport.Pass(info);
						}
						if ("Takescreenshot".equalsIgnoreCase(action)) {
							elemoperate.Takescreenshot(value);
							exreport.Pass(info);
						}
						break;
					case NUMERIC:
						double value1 = row.getCell(3).getNumericCellValue();
						if ("explicitwait".equalsIgnoreCase(action)) {
							elemoperate.explicitwait(xpath, (int) value1);
							exreport.Pass(info);
						}
						if ("formfill".equalsIgnoreCase(action)) {
							approx = (long) value1;
							elemoperate.formfill(xpath, approx + "");
							exreport.Pass(info);
						}
						if ("dropdown_selection".equalsIgnoreCase(action)) {
							approx = (long) value1;
							elemoperate.dropdown_selection(xpath, approx + "");
							exreport.Pass(info);
						}
						if ("verifyText".equalsIgnoreCase(action)) {
							elemoperate.verifyText(xpath, value1 + "");
							exreport.Pass(info);
						}
						if ("sleeper".equalsIgnoreCase(action)) {
							elemoperate.sleeper((int) value1);
							exreport.Pass(info);
						}
						break;
					default:
						break;
					}
					exreport.flushReport();
				} else {
					System.out.print("");
				}
			} catch (NullPointerException e) {
			}
		}
	}
}
