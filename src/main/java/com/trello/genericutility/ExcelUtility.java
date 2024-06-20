package com.trello.genericutility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String stringCommonData(String sheetName, int rowIndex, int cellIndex)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/trello.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		String value = workbook.getSheet(sheetName).getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		workbook.close();
		return value;

	}

	public double numericCommonData(String sheetName, int rowIndex, int cellIndex)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/trello.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		double value = workbook.getSheet(sheetName).getRow(rowIndex).getCell(cellIndex).getNumericCellValue();
		workbook.close();
		return value;
	}

}
