package com.practice.project;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Amazon {

//	static {
//		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
//	}
	@Test
	public void testAmazon() throws Throwable
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobile");
		Thread.sleep(2000);
		List<WebElement> sugg = driver.findElements(By.xpath("//div[text()='mobile']"));
		sugg.size();
		System.out.println(sugg.size());
		String first = sugg.get(0).getText();
		String second = sugg.get(1).getText();
		String last = sugg.get(sugg.size()-1).getText();
		System.out.println(first);
		System.out.println(second);
		System.out.println(last);
		
	}
}
