package com.practice.project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Spice_jet {

	public static WebDriver driver;
	@BeforeClass 
	public void test() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		
		driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com/");
		driver.findElement(By.xpath("//div[text()='one way']")).click();
		String from="bang";
		String to="goa";
		String samePath="/descendant::input[@autocapitalize='sentences']";
		driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']"+samePath)).sendKeys(from);
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n']/descendant::div[text()='Bengaluru']")).click();
		driver.findElement(By.xpath("//div[text()='To']")).click();
		driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']"+samePath)).sendKeys(to);
		String airPortName="Goa(Dabolim) International Airport";
		driver.findElement(By.xpath("//div[text()='"+airPortName+"']/ancestor::div[@class='css-1dbjc4n']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'24')]/ancestor::div[@data-testid='undefined-month-February-2023']/descendant::div[@data-testid='undefined-calendar-day-24']")).click();
		driver.findElement(By.xpath("//div[@data-testid='home-page-travellers']")).click();
		WebElement adults = driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']"));
		for(int i=0; i<3; i++)
		{
			adults.click();
		}
		
		driver.findElement(By.xpath("//div[@data-testid='home-page-travellers']")).click();
		driver.findElement(By.xpath("//div[text()='Students']/ancestor::div[@style='cursor: pointer;']")).click();
		driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']")).click();
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-zso239']/ancestor::div[@class='css-1dbjc4n r-13awgt0 r-18u37iz']/descendant::div[@class='css-1dbjc4n r-zso239']")).click();
		WebElement cont = driver.findElement(By.xpath("//div[text()='Continue']"));
		Actions a=new Actions(driver);
		a.click(cont).perform();
		Thread.sleep(3000);
		
		//contact information
		String fname="sarfraj";
		String lname="ahmad";
		String phoneNO="7004898612";
		String emailID="sonuking8381@gmail.com";
		String address="banglore";
		driver.findElement(By.xpath("//div[text()='Continue']/ancestor::div[@data-testid='continue-search-page-cta']")).click();
		driver.findElement(By.xpath("//input[@data-testid='first-inputbox-contact-details']")).sendKeys(fname);
		driver.findElement(By.xpath("//input[@data-testid='last-inputbox-contact-details']")).sendKeys(lname);
		driver.findElement(By.xpath("//input[@data-testid='contact-number-input-box']")).sendKeys(phoneNO);
		driver.findElement(By.xpath("//input[@data-testid='emailAddress-inputbox-contact-details']")).sendKeys(emailID);
		driver.findElement(By.xpath("//input[@data-testid='city-inputbox-contact-details']")).sendKeys(address);
	}
	
			@AfterClass
			public void browserclose()
			{
				driver.close();
			}
			
			
			@Test(dataProvider = "testDataProvider")
			public void Data(String name,String sname,String mobile,String sid,String x)
			{
				int i=0;
				driver.findElement(By.xpath("//input[@data-testid='traveller-"+x+"-first-traveller-info-input-box']")).sendKeys(name);
				driver.findElement(By.xpath("//input[@data-testid='traveller-"+x+"-last-traveller-info-input-box']")).sendKeys(sname);
				driver.findElement(By.xpath("//input[@data-testid='sc-member-mobile-number-input-box']")).sendKeys(mobile);
				try
				{
					driver.findElement(By.xpath("//div[text()='Student ID Card*']/ancestor::div[@class='css-1dbjc4n r-18u37iz r-1w6e6rj r-xzortm']/descendant::input[@class='css-1cwyjr8 r-homxoj r-poiln3 r-ubezar r-1eimq0t r-1e081e0 r-xfkzu9 r-lnhwgy']")).sendKeys(sid);
				} catch (Exception e) 
				{
					
				}
				driver.findElement(By.xpath("//div[text()='Next']")).click();
				i++;
			}
			
			@DataProvider
			public Object[][] testDataProvider()
			{
				Object[][] objArr=new Object[4][5];
				
				objArr[0][0]="sarfraj ahmad";
				objArr[0][1]="ansari";
				objArr[0][2]="7004898612";
				objArr[0][3]="98612";
				objArr[0][4]="0";
				
				objArr[1][0]="putturaj";
				objArr[1][1]="raj";
				objArr[1][2]="8877542903";
				objArr[1][3]="98613";
				objArr[1][4]="1";
				
				objArr[2][0]="parveen";
				objArr[2][1]="neva";
				objArr[2][2]="8877542904";
				objArr[2][3]="98614";
				objArr[2][4]="2";
				
				objArr[3][0]="keshwa";
				objArr[3][1]="kumar";
				objArr[3][2]="8877542905";
				objArr[3][3]="98615";
				objArr[3][4]="3";
				
				return objArr;
	}
}

