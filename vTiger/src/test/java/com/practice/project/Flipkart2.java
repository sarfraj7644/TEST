package com.practice.project;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.Generic_utility.Excel_Utility;

public class Flipkart2 {
	@Test
	public void test() throws AWTException, EncryptedDocumentException, IOException
	{
//		ArrayList a=new ArrayList();
		Random ra=new Random();
		int ran = ra.nextInt(1000);
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.xpath("//input[@title='Search for products, brands and more']")).sendKeys("phones");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		List<WebElement> phone = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
//		List<WebElement> price = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
		
		int count = phone.size();
		
		FileInputStream fis=new FileInputStream("data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1"+ran);
		for(int i=0; i<count; i++)
		{
//			String phoneName = phone.get(i).getText();
			Row row = sheet.createRow(i);
			row.createCell(0).setCellValue(phone.get(i).getText());
//			System.out.println(phoneName);
		}
		FileOutputStream fos=new FileOutputStream("data.xlsx");
		wb.write(fos);
		wb.close();
		driver.close();
//		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		for (WebElement we : phone) 
//		{
//			String iPhones = we.getText();
//			a.add(iPhones);
//		}
//		Collections.sort(a);
//		for(int i=0; i<a.size(); i++)
//		{
//			System.out.println(a.get(i));
//		}
		
//		for (WebElement web : price)
//		{
//			String iPhoneprice=web.getText();
//			a.add(price);
//		}
//		Collections.sort(a);
//		for(int i=0; i<a.size(); i++)
//		{
//			System.out.println(a.get(i));
//		}
	
	}
	@Test(enabled = false)
	public void test1() throws AWTException
	{
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.xpath("//input[@title='Search for products, brands and more']")).sendKeys("i phone");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		List<WebElement> phone = driver.findElements(By.xpath("//div[contains(text(),'APPLE iPhone')]/ancestor::div[@class='col col-7-12']/descendant::div[@class='_4rR01T']"));
		List<WebElement> price = driver.findElements(By.xpath("//div[contains(text(),'₹')]/ancestor::div[@class='col col-5-12 nlI3QM']/descendant::div[@class='_30jeq3 _1_WHN1']"));
		
		int count = phone.size();
		for(int i=0; i<count; i++)
		{
			String iPhone = phone.get(i).getText();
			String iPhonePrice = price.get(i).getText();
			System.out.println(iPhone+"=======>"+iPhonePrice);
		}
		driver.close();
	}
	

}
