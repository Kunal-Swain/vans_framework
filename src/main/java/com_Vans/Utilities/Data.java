package com_Vans.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Data {
	public Sheet ExcelDyna() {
		Sheet sheet = null;
		String filepath = "C:\\Users\\Signity\\eclipse-workspace\\Selenium_MrngBatch\\Cucumber_vans\\src\\main\\resources\\testdata\\testdata.xlsx";
		try {
			FileInputStream fi = new FileInputStream(filepath);
			Workbook wb = WorkbookFactory.create(fi);
			sheet = wb.getSheetAt(3);
		} catch (IOException e) {
			System.out.println("File not found");
		}
		return sheet;
	}
}
