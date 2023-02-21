package com.practice.project;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Jupiter {
	@Test(priority = 1)
	public void test()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://jupiter.cloud.planittesting.com/#/");
		driver.findElement(By.xpath("//li[@id='nav-contact']")).click();
		driver.findElement(By.xpath("//a[text()='Submit']")).click();
		String errorMsg = driver.findElement(By.xpath("//div[@class='alert alert-error ng-scope']")).getText();
		System.out.println(errorMsg);
		driver.findElement(By.id("forename")).sendKeys("sarfraj");
		driver.findElement(By.id("email")).sendKeys("sonu@gmail.com");
		driver.findElement(By.id("message")).sendKeys("hi i am sonu");
		driver.close();
		
	}
	
	
	
	@Test(priority = 2)
	public void test1() throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://jupiter.cloud.planittesting.com/#/");
		driver.findElement(By.xpath("//li[@id='nav-contact']")).click();
		driver.findElement(By.id("forename")).sendKeys("sarfraj");
		driver.findElement(By.id("email")).sendKeys("sonu@gmail.com");
		driver.findElement(By.id("message")).sendKeys("hi i am sonu");
		driver.findElement(By.xpath("//a[text()='Submit']")).click();
		String successMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		System.out.println(successMsg);
		Thread.sleep(10000);
		driver.close();
	}
	
	
	
	@Test(priority = 3)
	public void test2() throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://jupiter.cloud.planittesting.com/#/");
		driver.findElement(By.xpath("//li[@id='nav-shop']")).click();
		Thread.sleep(3000);
		WebElement frogBuy = driver.findElement(By.xpath("//h4[text()='Stuffed Frog']/../p/a"));
		for(int i=0; i<2; i++)
		{
			frogBuy.click();
		}
		
		WebElement BunnyBuy = driver.findElement(By.xpath("//h4[text()='Fluffy Bunny']/../p/a"));
		for(int i=0; i<5; i++)
		{
			BunnyBuy.click();
		}
		WebElement bearBuy = driver.findElement(By.xpath("//h4[text()='Valentine Bear']/../p/a"));
		for(int i=0; i<3; i++)
		{
			bearBuy.click();
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//i[@class='icon icon-shopping-cart icon-white']")).click();
		List<WebElement> Price = driver.findElements(By.xpath("//td[contains(text(),'$')]/ancestor::tr/descendant::td[2][@class='ng-binding']"));
		List<WebElement> name = driver.findElements(By.xpath("//img[contains(text(),'')]/ancestor::td"));
		List<WebElement> subTotal = driver.findElements(By.xpath("//tr/td[4]"));
		for(int i=0; i<Price.size(); i++)
		{
			String eachPrice = Price.get(i).getText();
			String productName = name.get(i).getText();
			String subtotalpri = subTotal.get(i).getText();
			System.out.println(productName+"==price--->  "+eachPrice+"=subTotal-->"+subtotalpri);
		}
		double sum=0;
		for(WebElement we:subTotal)
		{
			String text = we.getText();
			String pri = text.replace("$","");
			double pric = Double.parseDouble(pri);
			sum=sum+pric;
		}
		System.out.println("subTotal-->  "+sum);
		String totalPrice = driver.findElement(By.xpath("//strong")).getText();
		String total = totalPrice.replace("Total: ", "");
		double totalp = Double.parseDouble(total);
		System.out.println("total price--> "+totalp);
		Assert.assertEquals(sum,totalp);
		Thread.sleep(2000);
		driver.close();
	}
}