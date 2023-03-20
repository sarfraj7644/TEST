package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Yahoo {
	public WebDriver driver;
	@Test
	public void test()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://login.yahoo.com/");
		driver.findElement(By.id("login-username")).sendKeys("sarfraj");
		driver.findElement(By.xpath("//span[contains(@class,'stay-signed')]/descendant::label")).click();
		driver.close();
	}

}
