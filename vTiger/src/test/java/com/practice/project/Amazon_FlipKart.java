package com.practice.project;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Amazon_FlipKart {
	@Test
	public void test() throws AWTException, InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		Robot r= new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_CONTROL);
		switchwin(driver, "https://www.flipkart.com/");
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		JavascriptExecutor j=(JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		driver.findElement(By.xpath("//a[text()='Facebook']")).click();
		String expectedTitle = "Flipkart - Home | Facebook";
		Thread.sleep(3000);
		String actualTitle = driver.getTitle();
		System.out.println(expectedTitle);
		Assert.assertEquals(expectedTitle, actualTitle);
		driver.close();
	}
	public void switchwin(WebDriver driver, String partialTitle)
	{
		Set<String> allwin = driver.getWindowHandles();
		Iterator<String> it=allwin.iterator();
		while(it.hasNext())
		{
			String wn = it.next();
			driver.switchTo().window(wn);
			if(driver.getTitle().contains(partialTitle))
			{
				break;
			}
		}
	}

}
