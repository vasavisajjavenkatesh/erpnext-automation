package com.erpNext.testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataSupplier {
	
	@DataProvider(name = "newCustomerDetails")
	public String [][]  getData() throws IOException {
		File excelFile = new File(".\\src\\test\\resources\\testdata\\data.xlsx"); 
		FileInputStream fis = new FileInputStream(excelFile);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("sheet1");
		int noOfRows = sheet.getPhysicalNumberOfRows();
		int noOfColumn = sheet.getRow(1).getLastCellNum();

		String[][] data = new String[noOfRows-1][noOfColumn];
		List<String> list = new ArrayList<String>();
		
		for (int i = 1; i < noOfRows-1; i++) {
			for (int j = 0; j < noOfColumn;j++) {
				
				DataFormatter df = new DataFormatter();
				data[i-1][j] = df.formatCellValue(sheet.getRow(i).getCell(j));
				list.add(data[i-1][j]);
				System.out.println(data[i-1][j]);
			}

		}
		
		
		
		workbook.close();
		fis.close();
		return data;


	}
}
