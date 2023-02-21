package com.practice.project;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Multiple_tab {
	public static WebDriver driver;
	@Test
	public void test() throws Throwable
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		Thread.sleep(3000);
		
		newTab();
		Thread.sleep(3000);
		switchwin();
		driver.get("https://www.flipkart.com/");
		
		newTab();
		Thread.sleep(3000);
		switchwin();
		driver.get("https://www.icicibank.com/");
		newTab();
		newTab();
	}
	
	
	public void newTab() throws Throwable
	{
		Robot r= new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_T);
		}
	public void switchwin()
	{
		Set<String> allwh = driver.getWindowHandles();
		Iterator<String> it=allwh.iterator();
			
			while(it.hasNext())
			{
				String win = it.next();
				driver.switchTo().window(win);
				if(driver.getTitle().contains("NewTab"))
				{
					break;
				}
			}
	}
	}
