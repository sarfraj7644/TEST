package com.crm.Generic_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	/**
	 * this method is used to fetch the data from excel
	 * @param sheetName
	 * @param RowNum
	 * @param cellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * @author sarfraj
	 */
	
	
public String getExcelValue(String sheetName,int RowNum ,int cellNum) throws EncryptedDocumentException, IOException 
{
	FileInputStream fis =new FileInputStream("./data/book.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetName);
	Row row = sh.getRow(RowNum);
	Cell cel = row.getCell(cellNum);
	String data = cel.getStringCellValue();
	return data;
	 
	/*DataFormatter formate=new DataFormatter();
	return formate.formatCellValue(wb.getSheet(sheetName).getRow(RowNum).getCell(cellNum));*/
}

public String getDataFormater(String sheetName,int RowNum ,int cellNum) throws Throwable
{
	
	FileInputStream fis =new FileInputStream("./data/book.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	
	DataFormatter formate=new DataFormatter();
	return formate.formatCellValue(wb.getSheet(sheetName).getRow(RowNum).getCell(cellNum));
	
	
}
public void setExcelData(Workbook wb,String sheetName,int RowNum ,int cellNum,String value) throws EncryptedDocumentException, IOException
{
	
	wb.getSheet(sheetName).createRow(RowNum).createCell(cellNum).setCellValue(value);
	
}

}
