package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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

import com.crm.Generic_utility.Eplicit_Wait;

public class Pass_Data_In_Excel {
	@Test
	public void fillExcelData() throws Throwable
	{
		Random r=new Random();
		int ran = r.nextInt(100);
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone"+Keys.ENTER);
		List<WebElement> iphone = driver.findElements(By.xpath("//span[contains(text(),'Apple iPhone')]"));
		List<WebElement> price = driver.findElements(By.xpath("//div[@class='sg-row']/descendant::span[@class='a-price']"));
		FileInputStream fis=new FileInputStream("data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.createSheet("sheet"+ran);
		for(int i=0; i<iphone.size(); i++)
		{
			String phone = iphone.get(i).getText();
			String pPrice = price.get(i).getText();
			Row row = sheet.createRow(i);
			row.createCell(0).setCellValue(phone);
			row.createCell(1).setCellValue(pPrice);
			System.out.println(phone+"===>"+pPrice);
			
		}
		FileOutputStream fos=new FileOutputStream("data.xlsx");
		wb.write(fos);
		wb.close();
		driver.close();
	}

}
