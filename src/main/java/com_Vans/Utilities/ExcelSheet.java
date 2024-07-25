package com_Vans.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheet {

//	public void exceloperation() {
	public static void main(String args[]) {
		String filepath = "C:\\Users\\Signity\\eclipse-workspace\\Selenium_MrngBatch\\Cucumber_vans\\src\\main\\resources\\testdata\\testdata.xlsx";
		try {
			FileInputStream fi = new FileInputStream(filepath);
			Workbook wb = WorkbookFactory.create(fi);
			Sheet sheet = wb.getSheetAt(0);
			int lastrowcount = sheet.getLastRowNum();
			System.out.println("Total Rows: " + lastrowcount);
			for (Row row : sheet) {
				for (Cell cell : row) {
					switch (cell.getCellType()) {
					 	case BLANK:
					 		System.out.print("blank\t");
                        break;
						case STRING:
							System.out.print(cell.getStringCellValue() + "\t");
						break;
						case NUMERIC:
							if (DateUtil.isCellDateFormatted(cell)) {
                                System.out.print(cell.getDateCellValue() + "\t");
                            } else {
                                System.out.print(cell.getNumericCellValue() + "\t");
                            }
						break;
						case BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + "\t");
                        break;
                        case FORMULA:
                            System.out.print(cell.getCellFormula() + "\t");
                        break;
                        default:
                            System.out.print("UNKNOWN\t");
                        break;
					}
				}
				System.out.println();
			}
		} catch (IOException e) {
			System.out.println("File not found");
		}

	}
}
