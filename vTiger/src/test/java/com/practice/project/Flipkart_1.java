package com.practice.project;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Flipkart_1 {
	@Test
	public void test() throws Throwable
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		Thread.sleep(2000);
		WebElement fashion = driver.findElement(By.xpath("//div[text()='Fashion']"));
		Actions a=new Actions(driver);
		a.moveToElement(fashion).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()=\"Men's T-Shirts\"]")).click();
		driver.findElement(By.xpath("//a[contains(@title,'T-Shirt')]/ancestor::div[@data-id='TSHGEHZUPAZVPYTU']")).click();
		switchwindow(driver, "nb-nicky-boy-printed-men-round-neck-white-black-t-shirt");
		driver.findElement(By.xpath("//a[text()='L']")).click();
		driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
		
		
		
		
	}
	
	public void switchwindow(WebDriver driver, String partialTitle)
	{
		Set<String> allwin = driver.getWindowHandles();
		Iterator<String> it=allwin.iterator();
		while(it.hasNext())
		{
			String wh = it.next();
			driver.switchTo().window(wh);
			if(driver.getTitle().contains(partialTitle))
			{
				break;
			}
		}
		
	}

}
