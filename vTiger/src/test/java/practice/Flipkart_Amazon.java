package practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart_Amazon {
	WebDriver driver;
	@Test 
	public void test() throws Throwable
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.name("q")).sendKeys("redmi"+Keys.ENTER);
		Thread.sleep(3000);
		
		newTab();
		switchWindow("New Tab");
		driver.navigate().to("https://www.amazon.in/");
		Thread.sleep(3000);
		tab();
		switchWindow("redmi&otracker");
		driver.findElement(By.xpath("//div[text()='REDMI 10 (Pacific Blue, 64 GB)']")).click();
		
//		driver.close();
		
		
		
	}
		public void newTab() throws Throwable
		{
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_T);
			r.keyRelease(KeyEvent.VK_T);
			r.keyRelease(KeyEvent.VK_CONTROL);
		}
		public void switchWindow(String partialTitle)
		{
		Set<String> allwin = driver.getWindowHandles();	
		Iterator<String> i=allwin.iterator();
		while(i.hasNext())
		{
			String win = i.next();
			driver.switchTo().window(win);
		
		if(driver.getTitle().contains(partialTitle))
		{
			break;
		}
		}
		}
		
		public void tab() throws Throwable
		{
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_TAB);
		}
}
