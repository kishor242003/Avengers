package com.ninza.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author Kishor Kulkarni
 * this class contains the methods used to fetch the data from Excel File
 */
public class ExcelUtility {
	
	public String getDataFromExcel(String sheetName, int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/Ninza_CRM.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		return data;
		
	}
	
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/Ninza_CRM.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		int rowCount=wb.getSheet(sheetName).getLastRowNum();
		return rowCount;
		
	}
	
	public void setDataIntoExcel(String sheetName, int row, int cell, String data) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/Ninza_CRM.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(row).createCell(cell).setCellValue(data);
		FileOutputStream fos=new FileOutputStream("./data/Ninza_CRM.xlsx");
		wb.write(fos);
		wb.close();
		
	}

}
