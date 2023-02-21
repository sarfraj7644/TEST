package com.crm.campaign;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Grid {
	
	@Test
	public void test() throws MalformedURLException {
		URL url=new URL("http://192.168.0.129:4444/wd/hub");
		DesiredCapabilities des=new DesiredCapabilities();
		des.setBrowserName("chrome");
		des.setPlatform(Platform.WINDOWS);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new RemoteWebDriver(url,des);
		driver.get("https://www.google.com/");
		
	}
}
