package com.crm.Generic_utility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hpsf.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriver_Utility {
		
	/**
	 * it's an implicitly wait  Always wait for Element in DOM document & release the control 
	 * if element available 
	 * 
	 * wait for page to load before identifying any synchronization in DOM
	 * @param driver
	 */
	public void waitPageToLoad(WebDriver driver) 
	{
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	
	}
	
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	
	/**
	 * wait for all the methods present in the web driver 
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element )
	{
	WebDriverWait wait=new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	
	 public void scriptTimeOut(WebDriver driver) 
	 {
		driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
		 
	 }
	 

		/**
		 *  used to Switch to Any Window based on Window Titles
		 * @param driver
		 * @param partialWindowTitle
		 */
	 public void switchToWindow(WebDriver driver,String PartialWindowTitle) 
		{
			Set<String> allId = driver.getWindowHandles();
			Iterator<String> it= allId.iterator();
			while(it.hasNext())
			{
			String wid = it.next();
			driver.switchTo().window(wid);
			if(driver.getTitle().contains(PartialWindowTitle))
			{
				
			break;
			}}
	       }
	 
	 
	 
	 /**
	  * used to Switch to Alert Window & click on OK button
	  * @param driver
	  */
	 public void switchToAlertAndAccept(WebDriver driver)
		{
			driver.switchTo().alert().accept();
		}
	 
	 
	 /**
	  * used to Switch to Alert Window & click on cancel button
	  * @param driver
	  */
	 public void switchToAlertAndDismiss(WebDriver driver)
		{
			driver.switchTo().alert().dismiss();
		}
		
	 
	 
	 /**
	  * used to Switch to Frame Window based on index
	  * @param driver
	  * @param index
	  */
	 public void switchToFrame(WebDriver driver, int index)
		{
			driver.switchTo().frame(index);
		}
		
	 
	 
		/**
		 * used to Switch to Frame Window based on id or name attribute
		 * @param driver
		 * @param id_name_Attribute
		 */
	 public void switchToFrame(WebDriver driver,String id_name_Attribute)
		{
			driver.switchTo().frame(id_name_Attribute);
		}
		
		/**
		 * used to select the value from the dropDwon  based on index
		 * @param element
		 * @param index
		 */
	 public void selectIndex(WebElement element,int index)
		{
			Select s=new Select(element);
			s.selectByIndex(index);
		}
	 
	 /**
	  * used to select the value from the dropDwon  based on Value
	  * @param element
	  * @param value
	  */
	 public void selectValue(WebElement element,String value)
		{
			Select s=new Select(element);
			s.selectByValue(value);
		}
	 
	 
	 /**
	  * used to select the value from the dropDwon  based on Visible Text
	  * @param element
	  * @param Text
	  */
	 public void selectVisibleText(WebElement element,String Text)
		{
			Select s=new Select(element);
			s.deselectByVisibleText(Text);
		}
		
	 
	 /**
	  * used to place mouse cursor on specified element
	  * @param driver
	  * @param element
	  */
	 public void moveToElement(WebDriver driver, WebElement element)
		{
			Actions a=new Actions(driver);
			a.moveToElement(element).perform();
		}
	 
	 /**
	  * used to right click  on specified element
	  * @param driver
	  * @param element
	  */
	 public void rightClickOnElement(WebDriver driver, WebElement element)
		{
			Actions a=new Actions(driver);
			a.contextClick(element).perform();
		}
		
	 
	 /**
	  * 
	  * @param driver
	  * @param x
	  * @param y
	  */
	 public void moveByOffset(WebDriver driver,int x, int y)
		{
			Actions a=new Actions(driver);
			a.moveByOffset(x, y).click().perform();
		}
		
	
	public String takeScreenshotOfPage(WebDriver driver, String screenshotName) throws IOException{
		 Date d = new Date();
		 String date = d.toString().replace(" ", "-").replace(":", "-");
		 TakesScreenshot ts = (TakesScreenshot) driver;
		 File source = ts.getScreenshotAs(OutputType.FILE);
		 screenshotName = screenshotName + date;
		 File destination = new File("./Screenshots/" + screenshotName + " " + ".png");
		 FileUtils.copyFile(source, destination);
		 System.out.println("Screenshot Taken Successfully");
		 return destination.getAbsolutePath();

	}
	
}
