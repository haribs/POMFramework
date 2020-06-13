package com.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	public static Workbook workBook;
	public static Sheet sheet;

	public static String TEST_DATA_SHEET_PATH = ".\\src\\main\\java\\com\\qa\\hubspot\\testdata\\HubSpot_TestData.xlsx";

	public static Object[][] getTestData(String sheetName) {

		Object testData[][] = null;

		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(TEST_DATA_SHEET_PATH);
			workBook = WorkbookFactory.create(fileInputStream);
			sheet = workBook.getSheet(sheetName);

			testData = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				for (int j = 0; j < sheet.getRow(0).getFirstCellNum(); j++) {
					testData[i][j] = sheet.getRow(i).getCell(j).toString();
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return testData;
	}

}
