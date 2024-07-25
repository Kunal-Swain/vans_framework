package com_Vans.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetSpeceficSheet {

	public static void main(String args[]) {
		String excelFilePath = "C:\\Users\\Signity\\eclipse-workspace\\Selenium_MrngBatch\\Cucumber_vans\\src\\main\\resources\\testdata\\testdata.xlsx";
		try (FileInputStream fi = new FileInputStream(excelFilePath); Workbook workbook = WorkbookFactory.create(fi)) {

			Sheet sheet = workbook.getSheetAt(0);
			// Row index is 2 (3rd row), column index is 1 (2nd column)
			Row row = sheet.getRow(1);
			if (row != null) {
				int ffd = row.getLastCellNum();
				for (int i = 0; i < ffd; i++) {
					Cell cell = row.getCell(i);
					if (cell != null) {
						switch (cell.getCellType()) {
						case STRING:
							System.out.println(cell.getStringCellValue());
							break;
						case NUMERIC:
							System.out.println(cell.getNumericCellValue());
							break;
						case BOOLEAN:
							System.out.println(cell.getBooleanCellValue());
							break;
						case FORMULA:
							System.out.println(cell.getCellFormula());
							break;
						default:
							System.out.println("Unknown cell type");
						}
					} else {
						System.out.println("Cell at column index 1 is empty.");
					}
				}
			} else {
				System.out.println("Row index 2 does not exist.");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
