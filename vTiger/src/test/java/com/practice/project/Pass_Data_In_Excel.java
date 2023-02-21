package com.practice.project;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Pass_Data_In_Excel {
	@Test
	public void test() throws AWTException, EncryptedDocumentException, IOException
	{
		Random r=new Random();
		int ran = r.nextInt(10);
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.xpath("//input[@title='Search for products, brands and more']")).sendKeys("phones");
		Robot ra=new Robot();
		ra.keyPress(KeyEvent.VK_ENTER);
		ra.keyRelease(KeyEvent.VK_ENTER);
		List<WebElement> phone = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		List<WebElement> price = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
		int count = phone.size();
		FileInputStream fis=new FileInputStream("data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.createSheet(""+ran);
		for(int i=0; i<count; i++)
		{
			Row row = sheet.createRow(i);
			row.createCell(0).setCellValue(phone.get(i).getText());
			row.createCell(1).setCellValue(price.get(i).getText());
			System.out.println(phone.get(i).getText()+"===>"+price.get(i).getText());
		}
		FileOutputStream fos=new FileOutputStream("data.xlsx");
		wb.write(fos);
		wb.close();
		driver.close();
	}

}
