package com_Vans.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class SingleSheet {

	public static void main(String[] args) {
		String filepath = "C:\\Users\\Signity\\eclipse-workspace\\Selenium_MrngBatch\\Cucumber_vans\\src\\main\\resources\\testdata\\testdata.xlsx";
		try {
			FileInputStream fi = new FileInputStream(filepath);
			int columnIndex = 0;
			Workbook wb = WorkbookFactory.create(fi);
			Sheet sheet = wb.getSheetAt(0);
			int lastrowcount = sheet.getLastRowNum();
			System.out.println("Total Rows: " + lastrowcount);
			for (Row row : sheet) {
				Cell cell = row.getCell(columnIndex);
                if (cell != null) {
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.println(cell.getStringCellValue());
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                System.out.println(cell.getDateCellValue());
                            } else {
                                System.out.println(cell.getNumericCellValue());
                            }
                            break;
                        case BOOLEAN:
                            System.out.println(cell.getBooleanCellValue());
                            break;
                        case FORMULA:
                            System.out.println(cell.getCellFormula());
                            break;
                        case BLANK:
                            System.out.println("BLANK");
                            break;
                        default:
                            System.out.println("UNKNOWN");
                            break;
                    }
                } else {
                    System.out.println("BLANK");
                }
			}
		} catch (IOException e) {
			System.out.println("File not found");
		}

	}

}
