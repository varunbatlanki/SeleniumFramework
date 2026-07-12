package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private ExcelUtils() {
	}

	public static Object[][] getTestData(String filePath, String sheetName) {

		try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook = new XSSFWorkbook(fis)) {

			Sheet sheet = workbook.getSheet(sheetName);

			int rows = sheet.getPhysicalNumberOfRows();
			int cols = sheet.getRow(0).getPhysicalNumberOfCells();

			Object[][] data = new Object[rows - 1][cols];

			for (int i = 1; i < rows; i++) {

				for (int j = 0; j < cols; j++) {

					Cell cell = sheet.getRow(i).getCell(j);

					data[i - 1][j] = cell.toString();

				}
			}

			return data;

		} catch (IOException e) {

			throw new RuntimeException("Unable to read Excel", e);

		}
	}
}