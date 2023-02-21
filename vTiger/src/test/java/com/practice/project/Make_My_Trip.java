package com.practice.project;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Make_My_Trip {

	@Test
	public void test() throws InterruptedException, AWTException
	{
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.name("q")).sendKeys("mobile");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='mobile']/ancestor::div[contains(@data-tkid,'.mobile stand')]")).click();
//		Robot r=new Robot();
//		r.keyPress(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("//a[contains(text(),'ELV Aluminum Adjustable Foldable')]")).click();
		
	}
}
