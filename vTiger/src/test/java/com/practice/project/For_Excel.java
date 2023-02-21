package com.practice.project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class For_Excel {
	@Test 
	public void test() throws Throwable
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		FileInputStream fis=new FileInputStream("./data/book.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet("phone").getRow(0).getCell(0).setCellValue("sarfraj");
		
		FileOutputStream fos=new FileOutputStream("./data/book.xlsx");
		wb.write(fos);
		wb.close();
		driver.close();
		
	}

}
