package com_Vans.Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheet {
	
	public void exceloperation() {
		String filepath = "C:\\Users\\Signity\\eclipse-workspace\\Selenium_MrngBatch\\Cucumber_vans\\src\\main\\resources\\testdata\\testdata.xlsx";
		try {
			FileInputStream fi = new FileInputStream(filepath);
			Workbook wb = WorkbookFactory.create(fi);
			Sheet sheet = wb.getSheetAt(0);
			int lastrowcount = sheet.getLastRowNum();
			System.out.println(lastrowcount);
		} catch (IOException e) {
			System.out.println("File not found");
		}
		
	}
}
