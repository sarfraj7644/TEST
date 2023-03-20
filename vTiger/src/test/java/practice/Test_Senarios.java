package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test_Senarios {
	@Test
	public void test()
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("q")).sendKeys("selenium");
		 List<WebElement> allSugg = driver.findElements(By.xpath("//span[contains(text(),'selenium')]"));
		int count = allSugg.size();
		System.out.println(count);
		for(int i=0; i<count; i++)
		{
			String sugg = allSugg.get(i).getText();
			System.out.println(sugg);
		}
		driver.close();
	}

}
