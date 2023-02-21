package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Pass_Value_Another_Way {
	@Test
	public void test()
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		
	}

}
