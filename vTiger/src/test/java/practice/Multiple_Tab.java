package practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.Generic_utility.Eplicit_Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Multiple_Tab {
	@Test
	public void test() throws Throwable
	{
		
		WebDriver driver=new ChromeDriver();
//		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Thread.sleep(3000);
		for(int i=0; i<2; i++)
		{
			newTab();
			Thread.sleep(3000);
		}
		driver.quit();
		
	}
	public void newTab() throws AWTException
	{
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}

}
