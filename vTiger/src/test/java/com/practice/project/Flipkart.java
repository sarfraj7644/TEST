package com.practice.project;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Flipkart {

	@Test
	public void test() throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.xpath("//input[@title='Search for products, brands and more']")).sendKeys("Poco mobile");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		List<WebElement> mobile = driver.findElements(By.xpath("//div[contains(text(),'POCO')]"));
		List<WebElement> price = driver.findElements(By.xpath("//div[contains(text(),'₹')]"));
		int count = mobile.size();
		for(int i=0; i<count; i++)
		{
			String mobileList = mobile.get(i).getText();
			String priceList = price.get(i).getText();
			System.out.println(mobileList+" ===>"+priceList);
			
		}
	}
}
