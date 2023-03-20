package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Automation_Book_Store {
	@Test
	public void test() throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://automationbookstore.dev/");
		driver.findElement(By.id("searchBar")).sendKeys("test");
		Thread.sleep(2000);
		String modifiedName="Test";
		String modifiedName1="Automation";
		List<WebElement> book = driver.findElements(By.xpath("//h2[contains(text(),'"+modifiedName+"')]"));
		List<WebElement> author = driver.findElements(By.xpath("//p[contains(text(),' ')]"));
		
		int count = book.size();
		for(int i=0; i<count; i++)
		{
			String bookName = book.get(i).getText();
			String authorName = author.get(i).getText();
			System.out.println(bookName+"==>"+authorName);
//			System.out.println("==============================");
//			System.out.println(authorName);
			
		}
		driver.close();
	}

}
