package com_Vans.PageObjects;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.Assert;
import com_Vans.Utilities.Data;
import com_Vans.Utilities.ElementOperations;
import com_Vans.Utilities.WebdriverSetup;

public class BaseClass {
	ElementOperations elemoperate = new ElementOperations();
	WebdriverSetup driver = new WebdriverSetup();
	Data data = new Data();
	String step = "";
	long approx;

	public void basics(String stepname) {
		Sheet sheet = data.ExcelDyna();
		for (Row row : sheet) {
			try {
				String step = row.getCell(0).getStringCellValue();

				if (stepname.equalsIgnoreCase(step)) {
					String action = row.getCell(1).getStringCellValue();
					String xpath = row.getCell(2).getStringCellValue();
					switch (row.getCell(3).getCellType()) {
					case STRING:
						String value = row.getCell(3).getStringCellValue();
						if ("formfill".equalsIgnoreCase(action)) {
							elemoperate.formfill(xpath, value);
						}
						if ("dropdown_selection".equalsIgnoreCase(action)) {
							elemoperate.dropdown_selection(xpath, value);
						}
						if ("scrolltoelem".equalsIgnoreCase(action)) {
							elemoperate.scrolltoelem(xpath);
						}
						if ("Clicks".equalsIgnoreCase(action)) {
							elemoperate.Clicks(xpath);
						}
						if ("Conditionclick".equalsIgnoreCase(action)) {
							elemoperate.Conditionclick(xpath);
						}
						if ("select".equalsIgnoreCase(action)) {
							elemoperate.select(xpath);
						}
						if ("Deselect".equalsIgnoreCase(action)) {
							elemoperate.Deselect(xpath);
						}
						if ("GetURL".equalsIgnoreCase(action)) {
							String actualURL = elemoperate.GetURL();
							String expectedURL = value;
							Assert.assertEquals(actualURL, expectedURL);
						}
						if ("verifyText".equalsIgnoreCase(action)) {
							elemoperate.verifyText(xpath, value);
						}
						if ("hoverOn".equalsIgnoreCase(action)) {
							elemoperate.hoverOn(xpath);
						}
						break;
					case NUMERIC:
						double value1 = row.getCell(3).getNumericCellValue();
						if ("explicitwait".equalsIgnoreCase(action)) {
							elemoperate.explicitwait(xpath, (int) value1);
						}
						if ("formfill".equalsIgnoreCase(action)) {
							approx = (long) value1;
							elemoperate.formfill(xpath, approx + "");
						}
						if ("dropdown_selection".equalsIgnoreCase(action)) {
							approx = (long) value1;
							elemoperate.dropdown_selection(xpath, approx + "");
						}
						if ("verifyText".equalsIgnoreCase(action)) {
							elemoperate.verifyText(xpath, value1 + "");
						}
						break;
					default:
						break;
					}
				} else {
					System.out.print("");
				}
			} catch (NullPointerException e) {
			}
		}
	}
}
