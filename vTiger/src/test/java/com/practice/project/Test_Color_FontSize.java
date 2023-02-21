package com.practice.project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test_Color_FontSize {
	@Test
	public void test() {
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		String link = driver.findElement(By.xpath("//a[contains(@href,'https://www.flipkart.com/offers-list/content?screen=dynamic&pk=themeViews%3DDT')]")).getCssValue("color");
//		String color = link.getCssValue("color");
//		String size = link.getCssValue("font-size");
		System.out.println(link);
//		System.out.println(size);
	}

}
