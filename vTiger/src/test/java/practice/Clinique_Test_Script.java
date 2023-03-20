package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Clinique_Test_Script {
	@Test
	public void test()
	{
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.clinique.co.uk/");
		driver.findElement(By.id("onetrust-reject-all-handler")).click();
		driver.findElement(By.id("cboxClose")).click();
		driver.findElement(By.xpath("//button[@aria-label='Shop All']")).click();
		driver.findElement(By.xpath("//button[text()='Makeup']")).click();
		driver.close();
//		driver.findElement(By.xpath("//button[@aria-label='Close']/ancestor::div[@id='onetrust-close-btn-container']")).click();
//		driver.findElement(By.xpath("//div[@class='outer-wrap signup jquery-once-1-processed']/descendant::div[@title='Hide']")).click();
	}

}
