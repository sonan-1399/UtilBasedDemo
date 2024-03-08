package com.excel.handle;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {

	public void readFile(String data) throws Exception {
				
		FileInputStream fs = new FileInputStream("C:/Users/snthadev/ParaBankDataSheet.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);

		for (Row row : sheet) {
			if (row.getCell(0).toString().equals(data)) {
				for (Cell cell : row) {
					switch (cell.getCellType()) {
					case STRING:
						 cell.getStringCellValue();
						 break;
						 
					case NUMERIC:
						 cell.getNumericCellValue();
						break;
						
					default:
						break;
					}
				}
			}
		}
		workbook.close();
		
	}

	
}
